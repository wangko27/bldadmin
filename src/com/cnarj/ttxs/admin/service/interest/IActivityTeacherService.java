package com.cnarj.ttxs.admin.service.interest;

import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道后台Service接口类 - 活动指导老师
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public interface IActivityTeacherService extends
		IBaseService<ActivityTeacher, String> {

	/**
	 * 添加指导老师
	 * 
	 * @param memberid
	 * @param activityTeacher
	 */
	public void saveActivityTeacher(String[] memberid,
			ActivityTeacher activityid);
}
