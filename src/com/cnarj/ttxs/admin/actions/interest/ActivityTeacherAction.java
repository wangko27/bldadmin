package com.cnarj.ttxs.admin.actions.interest;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.admin.service.interest.IActivityService;
import com.cnarj.ttxs.admin.service.interest.IActivityTeacherService;
import com.cnarj.ttxs.admin.service.user.IMemberService;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 兴趣频道后台Action类 - 活动指导老师
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityTeacherAction extends PageAction implements
		ModelDriven<ActivityTeacher> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ActivityTeacher activityTeacher = new ActivityTeacher();

	IActivityTeacherService activityTeacherService;

	IMemberService memberService;

	IActivityService activityService;

	public ActivityTeacher getModel() {
		return activityTeacher;
	}

	public IActivityTeacherService getActivityTeacherService() {
		return activityTeacherService;
	}

	public void setActivityTeacherService(
			IActivityTeacherService activityTeacherService) {
		this.activityTeacherService = activityTeacherService;
	}

	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	public IActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

	/**
	 * 指导老师管理
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String manage() {
		try {
			String activityid = getParameter("activityid");

			Activity activity = activityService.get(activityid);
			setAttribute("activity", activity);

			List list_teacher = activityTeacherService.getList(
					"activity.activityid", activityid);
			setAttribute("list_teacher", list_teacher);
			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 搜索老师
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String seachTeacher() {
		try {
			String nikename = getParameter("nikename");
			List list_member = memberService.listMemberByNikename(nikename,
					new Long(3));
			setAttribute("list_member", list_member);
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
		try {
			String[] memberid = getParameterValues("memberid");
			String activityid = getParameter("activityid");
			activityTeacher.setActivity(activityService.get(activityid));
			activityTeacherService.saveActivityTeacher(memberid,
					activityTeacher);
			this.addActionMessage("添加成功!");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		try {
			activityTeacherService.delete(activityTeacher.getId());
			this.addActionMessage("删除成功!");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 推荐
	 * 
	 * @return
	 */
	public String recomment() {
		try {
			ActivityTeacher activityTeacherNew = activityTeacherService
					.get(activityTeacher.getId());
			activityTeacherNew.setIsrecomment("1");
			activityTeacherNew.setModifydate(new Date());
			activityTeacherService.update(activityTeacherNew);
			this.addActionMessage("推荐成功!");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 取消推荐
	 * 
	 * @return
	 */
	public String cancelRecomment() {
		try {
			ActivityTeacher activityTeacherNew = activityTeacherService
					.get(activityTeacher.getId());
			activityTeacherNew.setIsrecomment("0");
			activityTeacherNew.setModifydate(new Date());
			activityTeacherService.update(activityTeacherNew);
			this.addActionMessage("取消推荐成功!");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

}
