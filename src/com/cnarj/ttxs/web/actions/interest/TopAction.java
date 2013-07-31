package com.cnarj.ttxs.web.actions.interest;

import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.service.interest.IActivityProgramaService;
import com.cnarj.ttxs.service.interest.IActivityWorksService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 导航栏目信息表
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class TopAction extends PageAction {

	private String activitId;
	private String actId;
	private IActivityProgramaService activityProgramaService;
	private IActivityWorksService activityWorksService;
	public IActivityWorksService getActivityWorksService() {
		return activityWorksService;
	}
	public void setActivityWorksService(IActivityWorksService activityWorksService) {
		this.activityWorksService = activityWorksService;
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public IActivityProgramaService getActivityProgramaService() {
		return activityProgramaService;
	}
	public String getActivitId() {
		return activitId;
	}
	public void setActivitId(String activitId) {
		this.activitId = activitId;
	}
	public void setActivityProgramaService(
			IActivityProgramaService activityProgramaService) {
		this.activityProgramaService = activityProgramaService;
	}
	/**
	 * 活动栏目
	 * @return
	 */
	public String showTop(){
		List<ActivityPrograma> list=activityProgramaService.getTopPrograma(false, 0, true);
		setAttribute("actps", list);
		setAttribute("actpsize", list.size());
		return "top";
	}
	/**
	 * 得到所有的排行榜信息
	 */
	public String showAllFera(){
		//设置page参数
		// 设置每页显示的条数
		page.setEveryPage(45);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		result =activityProgramaService.getShowAllFera(actId,page);
		Activity acti=activityWorksService.getByIdActivity(actId);//得到详细信息
		setAttribute("activitId", acti.getActivityid());
		setAttribute("activitPro", acti.getPrograma().getProID());
		setAttribute("hangye", acti.getIndustryid());
		if(result!=null&&result.getContent().size()>=0){
			this.setAttribute("feraActionWorks", result.getContent());
		}
		this.setAttribute("activityfeaphotopath", acti.getActivityfeaphotopath());//// 活动专题图片
		return "allFera";
	}
}
