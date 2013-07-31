package com.cnarj.ttxs.admin.service.imp.interest;

import java.io.File;
import java.util.Date;

import com.cnarj.ttxs.admin.service.interest.IActivityWorksService;
import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.interest.IActivityWorksDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.HttpUtil;

/**
 * 兴趣频道后台Service实现类 - 活动作品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityWorksServiceImpl extends
		BaseServiceImpl<ActivityWorks, String> implements IActivityWorksService {

	IActivityWorksDao activityWorksDao;

	MemberDao memberDao;

	public IActivityWorksDao getActivityWorksDao() {
		return activityWorksDao;
	}

	public void setActivityWorksDao(IActivityWorksDao activityWorksDao) {
		this.activityWorksDao = activityWorksDao;
	}

	public void setBaseDao(IActivityWorksDao activityWorksDao) {
		super.setBaseDao(activityWorksDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Result findActivityWorksByPager(Page pager, String activityid,
			String worksnumber, String workstitle, String author)
			throws Exception {
		return activityWorksDao.findActivityWorksByPager(pager, activityid,
				worksnumber, workstitle, author);
	}

	public void saveActivityWorks(ActivityWorks activityWorks, File cover,
			String coverFileName, String coverContentType, File show,
			String showFileName, String showContentType) throws Exception {
		activityWorks.setCreatedate(new Date());
		activityWorks.setModifydate(new Date());
		activityWorks.setVotes(new Long(0));

		com.cnarj.ttxs.pojo.user.Member member = memberDao.get(activityWorks
				.getMember().getMemberid());
		activityWorks.setAuthor(member.getUsername());

		String worksid = activityWorksDao.save(activityWorks);

		// 上传封面
		String coverPath = "uploadfiles/none.gif";// 封面路径
		// 文件保存路径
		StringBuffer sbUploadFilePath = new StringBuffer("uploadfiles");// 上传文件目录
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("activity");// 活动
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("works");// 作品
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("admin");// 用户（这里是后台）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(DateUtil
				.setDateFormat(new Date(), "yyyy-MM-dd"));// 日期（年月日）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(worksid);// 作品ID
		sbUploadFilePath.append(File.separator);

		// 上传封面
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

		activityWorks.setFacepath(coverPath);// 封面

		String showPath = "";// 展示图片路径
		// 上传展示图片
		if (null != show) {
			// 获得文件后缀名
			String extension = showFileName.substring(showFileName
					.lastIndexOf("."));
			// 封面保存文件名
			String showUploadFilename = "show" + extension;
			// 上传封面
			String showUploadPath = FileOperate.fileUpload(show, showFileName,
					showContentType, sbUploadFilePath.toString(),
					showUploadFilename);
			if (showUploadPath.length() > 0) {
				showPath = showUploadPath;
			}
		}
		activityWorks.setShowsrc(showPath);// 展示图片路径

		activityWorksDao.update(activityWorks);
	}

	public void updateActivityWorks(ActivityWorks activityWorks, File cover,
			String coverFileName, String coverContentType, File show,
			String showFileName, String showContentType) throws Exception {

		ActivityWorks activityWorksNew = activityWorksDao.get(activityWorks
				.getWorksid());

		activityWorksNew.setModifydate(new Date());
		activityWorksNew.setWorksintro(activityWorks.getWorksintro());
		activityWorksNew.setWorksnumber(activityWorks.getWorksnumber());
		activityWorksNew.setWorkstitle(activityWorks.getWorkstitle());
		activityWorksNew.setWorkscontent(activityWorks.getWorkscontent());
		// 上传封面
		String coverPath = "uploadfiles/none.gif";// 封面路径
		// 文件保存路径
		StringBuffer sbUploadFilePath = new StringBuffer("uploadfiles");// 上传文件目录
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("activity");// 活动
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("works");// 作品
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append("admin");// 用户（这里是后台）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(DateUtil.setDateFormat(activityWorksNew
				.getCreatedate(), "yyyy-MM-dd"));// 日期（年月日）
		sbUploadFilePath.append(File.separator);
		sbUploadFilePath.append(activityWorksNew.getWorksid());// 作品ID
		sbUploadFilePath.append(File.separator);

		// 上传封面
		if (null != cover) {

			// 删除之前的封面
			if (!coverPath.equals(activityWorksNew.getFacepath())) {
				FileOperate.deleteFile(activityWorksNew.getFacepath());
			}

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

		activityWorksNew.setFacepath(coverPath);// 封面

		String showPath = "";// 展示图片路径
		// 上传展示图片
		if (null != show) {
			// 删除之前的展示图片
			FileOperate.deleteFile(activityWorksNew.getShowsrc());

			// 获得文件后缀名
			String extension = showFileName.substring(showFileName
					.lastIndexOf("."));
			// 封面保存文件名
			String showUploadFilename = "show" + extension;
			// 上传封面
			String showUploadPath = FileOperate.fileUpload(show, showFileName,
					showContentType, sbUploadFilePath.toString(),
					showUploadFilename);
			if (showUploadPath.length() > 0) {
				showPath = showUploadPath;
			}
		}
		activityWorksNew.setShowsrc(showPath);// 展示图片路径

		activityWorksDao.update(activityWorksNew);

	}

	public void deleteActivityWorks(String worksid) throws Exception {
		ActivityWorks activityWorksNew = activityWorksDao.get(worksid);

		activityWorksDao.delete(worksid);

		// 删除相关文件
		String filepath = "";
		// 删除封面
		if (!"uploadfiles/none.gif".equals(activityWorksNew.getFacepath())) {
			filepath = activityWorksNew.getFacepath().substring(0,
					activityWorksNew.getFacepath().lastIndexOf(File.separator));
		} else {
			if (null != activityWorksNew.getShowsrc()
					&& !"".equals(activityWorksNew.getShowsrc())) {
				filepath = activityWorksNew.getShowsrc().substring(
						0,
						activityWorksNew.getShowsrc().lastIndexOf(
								File.separator));
			}
		}
		// 删除展示图片
		File file = new File(HttpUtil.getRealPath() + filepath);
		FileOperate.deleteDirectoryAndFile(file);

	}
}
