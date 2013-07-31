package com.cnarj.ttxs.admin.service.imp.interest;

import java.io.File;
import java.util.Date;

import com.cnarj.ttxs.admin.service.interest.IActivityService;
import com.cnarj.ttxs.dao.Article.ISysArticleTypeDao;
import com.cnarj.ttxs.dao.interest.IActivityDao;
import com.cnarj.ttxs.dao.interest.IActivityProgramaDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.Pubfun;

/**
 * 兴趣频道后台Service实现类 - 活动
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityServiceImpl extends BaseServiceImpl<Activity, String>
		implements IActivityService {

	IActivityDao activityDao;

	IActivityProgramaDao activityProgramaDao;

	ISysArticleTypeDao sysArticleTypeDao;

	public IActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(IActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public void setBaseDao(IActivityDao activityDao) {
		super.setBaseDao(activityDao);
	}

	public IActivityProgramaDao getActivityProgramaDao() {
		return activityProgramaDao;
	}

	public void setActivityProgramaDao(IActivityProgramaDao activityProgramaDao) {
		this.activityProgramaDao = activityProgramaDao;
	}

	public ISysArticleTypeDao getSysArticleTypeDao() {
		return sysArticleTypeDao;
	}

	public void setSysArticleTypeDao(ISysArticleTypeDao sysArticleTypeDao) {
		this.sysArticleTypeDao = sysArticleTypeDao;
	}

	public Result findActivityByPager(Page pager, String activitytitle,
			String proID, String typeId) throws Exception {
		return activityDao.findActivityByPager(pager, activitytitle, proID,
				typeId);
	}

	public void saveActivity(Activity activity, File cover,
			String coverFileName, String coverContentType, File featured,
			String featuredFileName, String featuredContentType)
			throws Exception {
		ActivityPrograma activityPrograma = activityProgramaDao.get(activity
				.getPrograma().getProID());

		// 添加系统文章类别
		SysArticleType articleType_lm = sysArticleTypeDao.get(activityPrograma
				.getProProgramatypeid());

		// 添加活动类别
		SysArticleType sysArticleType_hd = new SysArticleType();
		sysArticleType_hd.setCreatedate(new Date());
		sysArticleType_hd.setModifydate(new Date());
		sysArticleType_hd.setArticletypename("活动公告");
		sysArticleType_hd.setArticleType(articleType_lm);
		sysArticleType_hd.setArticlesort(new Long(3));
		String articletypeid_hd = sysArticleTypeDao.save(sysArticleType_hd);

		// 活动公告
		SysArticleType sysArticleType_gg = new SysArticleType();
		sysArticleType_gg.setCreatedate(new Date());
		sysArticleType_gg.setModifydate(new Date());
		sysArticleType_gg.setArticletypename("活动公告");
		sysArticleType_gg.setArticleType(sysArticleType_hd);
		sysArticleType_gg.setArticlesort(new Long(4));
		String articletypeid_gg = sysArticleTypeDao.save(sysArticleType_gg);

		// 行业知识
		SysArticleType sysArticleType_hy = new SysArticleType();
		sysArticleType_hy.setCreatedate(new Date());
		sysArticleType_hy.setModifydate(new Date());
		sysArticleType_hy.setArticletypename("行业知识");
		sysArticleType_hy.setArticleType(sysArticleType_hd);
		sysArticleType_hy.setArticlesort(new Long(4));
		String articletypeid_hy = sysArticleTypeDao.save(sysArticleType_hy);

		activity.setCreatedate(new Date());
		activity.setModifydate(new Date());
		activity.setActivetypeid(articletypeid_hd);
		activity.setSysnotesid(articletypeid_gg);
		activity.setIndustryid(articletypeid_hy);

		String newIntro = Pubfun.contentHandle(activity.getActivityintro());
		activity.setActivityintro(newIntro);// 简介
		String newRule = Pubfun.contentHandle(activity.getActivityrule());
		activity.setActivityrule(newRule);// 活动规则
		String activityid = activityDao.save(activity);

		// 上传封面
		String coverPath = "uploadfiles/none.gif";// 封面路径
		String featuredPath = "uploadfiles/none.gif";// 专题图片路径
		// 文件保存路径
		String uploadFilepath = Pubfun.structurePath("activity", new Date(),
				activityid);

		if (null != cover) {
			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("activity",
					new Date(), activityid, cover, coverFileName,
					coverContentType);
			if (coverUploadPath.length() > 0) {
				coverPath = coverUploadPath;
			}
		}
		if (null != featured) {
			// 获得文件后缀名
			String extension = featuredFileName.substring(featuredFileName
					.lastIndexOf("."));
			// 封面保存文件名
			String featuredUploadFilename = "featured" + extension;
			// 上传专题图片
			String featuredUploadPath = FileOperate.fileUpload(featured,
					featuredFileName, featuredContentType, uploadFilepath,
					featuredUploadFilename);
			if (featuredUploadPath.length() > 0) {
				featuredPath = featuredUploadPath;
			}
			featuredPath = featuredPath.replaceAll("\\\\", "/");
		}

		activity.setActivityfeaphotopath(featuredPath);// 专题图片路径
		activity.setActivitysrc(coverPath);// 封面路径
		activity.setUnlinepath(uploadFilepath + "unline" + File.separator);// 线下图片路径
		activityDao.update(activity);

	}

	public void updateActivity(Activity activity, File cover,
			String coverFileName, String coverContentType, File featured,
			String featuredFileName, String featuredContentType)
			throws Exception {

		Activity activityNew = activityDao.get(activity.getActivityid());

		// 修改系统文章 活动类别
		SysArticleType articleType_hd = sysArticleTypeDao.get(activityNew
				.getActivetypeid());
		articleType_hd.setModifydate(new Date());
		articleType_hd.setArticletypename(activity.getActivitytitle());
		sysArticleTypeDao.update(articleType_hd);

		// 文件保存路径
		String uploadFilepath = Pubfun.structurePath("activity", activityNew
				.getCreatedate(), activityNew.getActivityid());

		if (null != cover) {
			// 删除原有封面
			if (null != activityNew.getActivitysrc()
					&& !"uploadfiles/none.gif".equals(activityNew
							.getActivitysrc())) {
				FileOperate.deleteFile(activityNew.getActivitysrc());
			}
			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("activity",
					activityNew.getCreatedate(), activityNew.getActivityid(),
					cover, coverFileName, coverContentType);
			activityNew.setActivitysrc(coverUploadPath);// 封面路径
		}

		if (null != featured) {
			// 删除原有专题图片
			if (null != activityNew.getActivityfeaphotopath()
					&& !"uploadfiles/none.gif".equals(activityNew
							.getActivityfeaphotopath())) {
				FileOperate.deleteFile(activityNew.getActivityfeaphotopath());
			}
			// 获得文件后缀名
			String extension = featuredFileName.substring(featuredFileName
					.lastIndexOf("."));
			// 封面保存文件名
			String featuredUploadFilename = "featured" + extension;
			// 上传专题图片
			String featuredUploadPath = FileOperate.fileUpload(featured,
					featuredFileName, featuredContentType, uploadFilepath,
					featuredUploadFilename);
			featuredUploadPath = featuredUploadPath.replaceAll("\\\\", "/");
			activityNew.setActivityfeaphotopath(featuredUploadPath);
		}

		activityNew.setModifydate(new Date());// 修改时间
		String newIntro = Pubfun.contentHandle(activity.getActivityintro());
		activityNew.setActivityintro(newIntro);// 简介
		String newRule = Pubfun.contentHandle(activity.getActivityrule());
		activityNew.setActivityrule(newRule);// 活动规则
		activityNew.setActivitytitle(activity.getActivitytitle());// 标题
		activityNew.setActivityType(activity.getActivityType());// 类别
		activityNew.setPrograma(activity.getPrograma());// 栏目
		activityNew.setIsshowpic(activity.getIsshowpic());// 是否显示线下图片
		activityNew.setBegindate(activity.getBegindate());// 开始时间
		activityNew.setEnddate(activity.getEnddate());// 结束时间

		activityDao.update(activityNew);

	}

	public void deleteActivity(String activityid) throws Exception {
		Activity activity = activityDao.get(activityid);

		// 删除系统文章类别 活动公告类别
		if (null != activity.getSysnotesid()) {
			SysArticleType articleTypeGG = sysArticleTypeDao.get(
					"articletypeid", activity.getSysnotesid());
			if (null != articleTypeGG) {
				sysArticleTypeDao.delete(articleTypeGG);
			}
		}

		// 删除系统文章类别 行业知识
		if (null != activity.getIndustryid()) {
			SysArticleType articleTypeHY = sysArticleTypeDao.get(
					"articletypeid", activity.getIndustryid());
			if (null != articleTypeHY) {
				sysArticleTypeDao.delete(articleTypeHY);
			}
		}

		// 删除系统文章类别 活动类别
		if (null != activity.getActivetypeid()) {
			SysArticleType articleType = sysArticleTypeDao.get("articletypeid",
					activity.getActivetypeid());
			if (null != articleType) {
				sysArticleTypeDao.delete(articleType);
			}
		}

		// 删除活动
		activityDao.delete(activityid);

		// 删除活动的文件（封面，线下图片，专题图片）
		// 文件保存路径
		String uploadFilepath = Pubfun.structurePath("activity", activity
				.getCreatedate(), activity.getActivetypeid());
		File directoryfile = new File(HttpUtil.getRealPath() + uploadFilepath);
		FileOperate.deleteDirectoryAndFile(directoryfile);
	}
}
