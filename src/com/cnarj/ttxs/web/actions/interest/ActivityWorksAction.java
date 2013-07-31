package com.cnarj.ttxs.web.actions.interest;

import java.util.List;

import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.interest.IActivityWorksService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 活动作品首页
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ActivityWorksAction extends PageAction {

	private String activitId;
	private IActivityWorksService activityWorksService;
	private String activitPro;//栏目id
	
	public String getActivitPro() {
		return activitPro;
	}

	public void setActivitPro(String activitPro) {
		this.activitPro = activitPro;
	}

	public String getActivitId() {
		return activitId;
	}

	public void setActivitId(String activitId) {
		this.activitId = activitId;
	}

	public IActivityWorksService getActivityWorksService() {
		return activityWorksService;
	}

	public void setActivityWorksService(IActivityWorksService activityWorksService) {
		this.activityWorksService = activityWorksService;
	}

	/**
	 * 根据活动id获得参赛作品首页
	 * @return
	 */
	public String showActionWorks(){
		
		//得到该活动的最新评论
		List<ActivityWorkCommented> workComments=activityWorksService.getByActIdActivityWorkCommented(activitId, 9, false);
		//得到该活动的所有的作品的总评论数
		Long workCommentsNum=activityWorksService.getByActIdActivityWorkCommentedNum(activitId);
		this.setAttribute("workCommentsNum", workCommentsNum);
		//按活动的id号  得到25条的参赛作品
		List<ActivityWorks> list=activityWorksService.getByActivityIdWorks(activitId, 25,"0");
		this.setAttribute("workComments", workComments);
		this.setAttribute("actWorks", list);
		showLeft();
		return "actworks";
	}
	/**
	 * 左边部分
	 * @return
	 */
	public String showLeft(){
		
		//得到(推荐的)活动老师
		List<ActivityTeacher> teachers=activityWorksService.getByActIdActivityTeacher(activitId);
		if(teachers.size()!=0){
			//得到老师的最新博文信息
			Blog blog=activityWorksService.getByTeacherIdBlog(teachers.get(0).getId());
			setAttribute("teachers", teachers);
			if(blog!=null&&blog.getBlogcontent()!=null&&blog.getBlogcontent().trim().equals("")){
				setAttribute("blogcontent", HtmlUtil.splitAndFilterString(blog.getBlogcontent(), 30));
			}
		}
		//得到活动的详细信息
		Activity activity=activityWorksService.getByIdActivity(activitId);
		if(activity!=null){
			//得到票数最多的10条信息(排行版)
			List<ActivityWorks> fareList=activityWorksService.getByFareActivityWorks(10,false,activity.getActivityid());
			setAttribute("fareList", fareList);
		}
		//System.out.println(activity.getActivityid());
		if(activity!=null&&activity.getActivityintro()!=null&&!activity.getActivityintro().trim().equals("")){
			System.out.println(HtmlUtil.splitAndFilterString(activity.getActivityintro(), 75));
			setAttribute("activityInfo", HtmlUtil.splitAndFilterString(activity.getActivityintro(), 75));
		}
		setAttribute("hangye", activity.getIndustryid());//该活动的行业知识
		if(activity!=null&&activity.getIndustryid()!=null&&!activity.getIndustryid().trim().equals("")){
			//行业知识
			List<Article> harticles=activityWorksService.getByIndustryidArticles(activity.getIndustryid(), 13,false);
			setAttribute("harticles", harticles);
		}
		if(activity!=null&&activity.getSysnotesid()!=null&&!activity.getSysnotesid().trim().equals("")){
			//活动公告
			List<Article> darticles=activityWorksService.getBySysnotesidArticles(activity.getSysnotesid(),3);
			this.setAttribute("darticles", darticles);
			this.setAttribute("activityfeaphotopath",activity.getActivityfeaphotopath());//// 活动专题图片
		}
		return "left";
	}
	/**
	 * 按活动id的到所有的活动
	 */
	@SuppressWarnings("unchecked")
	public String showAllActWorks(){
		//设置page参数
		// 设置每页显示的条数
		page.setEveryPage(20);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		//得到所有的活动的参赛作品
		result=activityWorksService.getByActivityIdWorks(activitId,page);
		List<ActivityWorks> list=result.getContent();
		this.setAttribute("actWorks", list);
		showLeft();
		return "all";
	}
}
