package com.cnarj.ttxs.web.actions.interest;

import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.service.interest.IActivityWorksService;
import com.cnarj.ttxs.web.actions.base.PageAction;

@SuppressWarnings("serial")
public class ActivityBulletinAction extends PageAction {

	private String activityId;
	private IActivityWorksService worksService;
	
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public IActivityWorksService getWorksService() {
		return worksService;
	}

	public void setWorksService(IActivityWorksService worksService) {
		this.worksService = worksService;
	}

	public String showBulletin(){
		
		//设置page参数
		// 设置每页显示的条数
		page.setEveryPage(45);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		
		Activity activity=worksService.getByIdActivity(activityId);
		result=worksService.getAllActivityBulletin(activity.getSysnotesid(),page);
		setAttribute("activity", activity);
		setAttribute("actList", result.getContent());
		setAttribute("proID", activity.getPrograma().getProID());
		return "bull";
	}
}
