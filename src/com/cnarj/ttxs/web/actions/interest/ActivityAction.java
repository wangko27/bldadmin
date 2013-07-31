package com.cnarj.ttxs.web.actions.interest;

import java.io.File;
import java.util.List;

import com.cnarj.ttxs.pojo.Album;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.interest.IActivityService;
import com.cnarj.ttxs.service.interest.IActivityWorksService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 活动信息action
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class ActivityAction extends PageAction {

	private IActivityWorksService activityWorksService;
	private String proID;// 栏目id
	private IActivityService activityService;
	private Activity activity;
	private String activitId;
	private String resKey;// 搜索关键字

	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public String getActivitId() {
		return activitId;
	}

	public void setActivitId(String activitId) {
		this.activitId = activitId;
	}

	public String getProID() {

		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public IActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * 按活动栏目得到所有的活动
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showActions() {
		/**
		 * 按栏目和关键字搜索
		 * 
		 * @return
		 */
		// 设置page参数
		// 设置每页显示的条数
		page.setEveryPage(9);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));

		result = activityService.getActivitys(proID, resKey, page);
		List actis = result.getContent();
		ActivityPrograma programa = activityService
				.getActivityProGramaName(proID);
		this.setAttribute("actis", actis);
		setAttribute("programa", programa);
		return "act";
	}

	/**
	 * 获得某文件下所有文件名
	 * 
	 * @param path
	 * @return
	 */

	public String[] getPictres(String path) {
		File file = new File(this.getRealPath() + path);
		String[] pics = file.list();// 得到picpath目录中的文件名称
		return pics;
	}

	/**
	 * 根据活动id获得活动的介绍和活动的图片
	 * 
	 * @return
	 */
	public String showactintro() {
		// 活动介绍
		activity = activityService.get(activitId);
		Activity activity = activityService.get(activitId);
		Album album = new Album();
		String picPath = activity.getUnlinepath();
		if (picPath != null) {
			album.setAlbumPath(picPath);
			String[] pics = getPictres(picPath);// 得到picpath目录中的文件名称
			StringBuffer str_pics = new StringBuffer();
			if (pics != null) {
				for (int i = 0; i < pics.length; i++) {
					if (i == (pics.length - 1)) {
						str_pics.append("'").append(pics[i]).append("'");
						break;
					}
					str_pics.append("'").append(pics[i]).append("',");
				}
				album.setPictures(pics);
				album.setStr_picture(str_pics.toString());

			}
		}
		String stre = activity.getActivityintro();
		String[] content = null;
		if (stre != null) {
			content = stre
					.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
		}
		this.activity = activity;
		setAttribute("srclength", stre != null ? content.length : 0);
		setAttribute("content", content);
		showLeft(activity.getActivityid());
		this.setAttribute("activitPro", activity.getPrograma().getProID());
		this.setAttribute("album", album);
		return "actintro";
	}

	/**
	 * 左边部分
	 * 
	 * @return
	 */
	public String showLeft(String actId) {
		// 得到票数最多的10条信息(排行版)
		List<ActivityWorks> fareList = activityWorksService
				.getByFareActivityWorks(10, false, actId);
		setAttribute("fareList", fareList);
		// 得到(推荐的)活动老师
		List<ActivityTeacher> teachers = activityWorksService
				.getByActIdActivityTeacher(actId);
		if (teachers.size() != 0) {
			// 得到老师的最新博文信息
			Blog blog = activityWorksService.getByTeacherIdBlog(teachers.get(0)
					.getId());
			setAttribute("teachers", teachers);
			if (blog != null && blog.getBlogcontent() != null
					&& blog.getBlogcontent().trim().equals("")) {
				setAttribute("blogcontent", HtmlUtil.splitAndFilterString(blog
						.getBlogcontent(), 30));
			}
		}
		// 得到活动的详细信息
		Activity activity = activityWorksService.getByIdActivity(actId);
		if (activity != null && activity.getActivityintro() != null
				&& !activity.getActivityintro().trim().equals("")) {
			setAttribute("activityInfo", HtmlUtil.splitAndFilterString(activity
					.getActivityintro(), 75));
		}
		setAttribute("hangye", activity.getIndustryid());// 该活动的行业知识
		if (activity != null && activity.getIndustryid() != null
				&& !activity.getIndustryid().trim().equals("")) {
			// 行业知识
			List<Article> harticles = activityWorksService
					.getByIndustryidArticles(activity.getIndustryid(), 13,
							false);
			setAttribute("harticles", harticles);
		}
		if (activity != null && activity.getSysnotesid() != null
				&& !activity.getSysnotesid().trim().equals("")) {
			// 活动公告
			List<Article> darticles = activityWorksService
					.getBySysnotesidArticles(activity.getSysnotesid(), 3);
			this.setAttribute("darticles", darticles);
			this.setAttribute("activityfeaphotopath", activity
					.getActivityfeaphotopath());// // 活动专题图片
		}
		return "left";
	}

	public IActivityWorksService getActivityWorksService() {
		return activityWorksService;
	}

	public void setActivityWorksService(
			IActivityWorksService activityWorksService) {
		this.activityWorksService = activityWorksService;
	}

	/**
	 * 根据活动id获得活动规则
	 * 
	 * @return
	 */
	public String showActivityrule() {
		// 活动规则
		activity = activityService.get(activitId);

		setAttribute("activity", activity);
		showLeft(activity.getActivityid());
		this.setAttribute("activitPro", activity.getPrograma().getProID());
		return "rule";
	}
}
