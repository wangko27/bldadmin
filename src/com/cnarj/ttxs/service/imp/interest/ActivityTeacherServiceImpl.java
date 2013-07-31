package com.cnarj.ttxs.service.imp.interest;

import com.cnarj.ttxs.dao.interest.IActivityTeacherDao;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.interest.IActivityTeacherService;

/**
 * 兴趣频道Service实现类 - 活动指导老师
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityTeacherServiceImpl extends BaseServiceImpl<ActivityTeacher, String> implements IActivityTeacherService {

	private IActivityTeacherDao activityTeacherDao;

	public IActivityTeacherDao getActivityTeacherDao() {
		return activityTeacherDao;
	}

	public void setActivityTeacherDao(IActivityTeacherDao activityTeacherDao) {
		this.activityTeacherDao = activityTeacherDao;
	}
}
