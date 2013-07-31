package com.cnarj.ttxs.admin.service.imp.interest;

import java.io.File;
import java.util.Date;

import com.cnarj.ttxs.admin.service.interest.IActivityWorksShowService;
import com.cnarj.ttxs.dao.interest.IActivityWorksShowDao;
import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.FileOperate;

/**
 * 兴趣频道后台Service实现类 - 首页活动作品展示
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月30日
 */
public class IActivityWorksShowServiceImpl extends
		BaseServiceImpl<ActivityWorksShow, String> implements
		IActivityWorksShowService {

	IActivityWorksShowDao activityWorksShowDao;

	public IActivityWorksShowDao getActivityWorksShowDao() {
		return activityWorksShowDao;
	}

	public void setActivityWorksShowDao(
			IActivityWorksShowDao activityWorksShowDao) {
		this.activityWorksShowDao = activityWorksShowDao;
	}

	public void setBaseDao(IActivityWorksShowDao activityWorksShowDao) {
		super.setBaseDao(activityWorksShowDao);
	}

	public void deleteActivityWorksShow(String showId) throws Exception {
		ActivityWorksShow activityWorksShow = activityWorksShowDao.get(showId);

		activityWorksShowDao.delete(showId);

		if (!"uploadfiles/none.gif".equals(activityWorksShow.getShowImgpath())) {
			// 删除图片
			FileOperate.deleteFile(activityWorksShow.getShowImgpath());
		}
	}

	public void saveActivityWorksShow(ActivityWorksShow activityWorksShow,
			File cover, String coverFileName, String coverContentType)
			throws Exception {
		activityWorksShow.setShowCreatedate(new Date());
		activityWorksShow.setShowModifydate(new Date());
		String showId = activityWorksShowDao.save(activityWorksShow);

		// 上传封面
		String coverPath = "uploadfiles/none.gif";// 封面路径
		// 文件保存路径
		StringBuffer sbUploadFilePath = new StringBuffer("uploadfiles");// 上传文件目录
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("activity");// 活动
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("worksshow");// 首页活动作品展示
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("admin");// 用户（这里是后台）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(DateUtil
				.setDateFormat(new Date(), "yyyy-MM-dd"));// 日期（年月日）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(showId);// 活动ID
		sbUploadFilePath.append(File.separator);

		if (null != cover) {
			// 获得文件后缀名
			String extension = coverFileName.substring(coverFileName
					.lastIndexOf("."));
			// 封面保存文件名
			String coverUploadFilename = "cover" + extension;
			// 上传封面
			String coverUploadPath = FileOperate.fileUpload(cover,
					coverFileName, coverContentType, sbUploadFilePath
							.toString(), coverUploadFilename);
			if (coverUploadPath.length() > 0) {
				coverPath = coverUploadPath;
			}
		}

		activityWorksShow.setShowImgpath(coverPath);// 图片路径

		activityWorksShowDao.update(activityWorksShow);
	}

	public void updateActivityWorksShow(ActivityWorksShow activityWorksShow,
			File cover, String coverFileName, String coverContentType)
			throws Exception {
		ActivityWorksShow activityWorksShowNew = activityWorksShowDao
				.get(activityWorksShow.getShowId());
		activityWorksShowNew.setShowModifydate(new Date());
		activityWorksShowNew.setShowEnabled(activityWorksShow.getShowEnabled());
		activityWorksShowNew.setShowSort(activityWorksShow.getShowSort());
		activityWorksShowNew.setShowUrl(activityWorksShow.getShowUrl());
		activityWorksShowNew.setShowTitle(activityWorksShow.getShowTitle());

		// 上传封面
		String coverPath = "uploadfiles/none.gif";// 封面路径
		// 文件保存路径
		StringBuffer sbUploadFilePath = new StringBuffer("uploadfiles");// 上传文件目录
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("activity");// 活动
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("worksshow");// 作品
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("admin");// 用户（这里是后台）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(DateUtil.setDateFormat(activityWorksShowNew
				.getShowCreatedate(), "yyyy-MM-dd"));// 日期（年月日）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(activityWorksShowNew.getShowId());// ID
		sbUploadFilePath.append(File.separator);

		if (null != cover) {
			// 获得文件后缀名
			String extension = coverFileName.substring(coverFileName
					.lastIndexOf("."));
			// 封面保存文件名
			String coverUploadFilename = "cover" + extension;
			// 上传封面
			String coverUploadPath = FileOperate.fileUpload(cover,
					coverFileName, coverContentType, sbUploadFilePath
							.toString(), coverUploadFilename);
			if (coverUploadPath.length() > 0) {
				coverPath = coverUploadPath;
			}
			activityWorksShowNew.setShowImgpath(coverPath);// 封面路径
		}

		activityWorksShowDao.update(activityWorksShowNew);
	}

}
