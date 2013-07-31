package com.cnarj.ttxs.admin.service.imp.interest;

import java.util.Date;

import com.cnarj.ttxs.admin.service.interest.IActivityTeacherService;
import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.interest.IActivityTeacherDao;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 兴趣频道后台Service实现类 - 活动指导老师
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityTeacherServiceImpl extends
		BaseServiceImpl<ActivityTeacher, String> implements
		IActivityTeacherService {

	IActivityTeacherDao activityTeacherDao;

	MemberDao memberDao;

	public IActivityTeacherDao getActivityTeacherDao() {
		return activityTeacherDao;
	}

	public void setActivityTeacherDao(IActivityTeacherDao activityTeacherDao) {
		this.activityTeacherDao = activityTeacherDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setBaseDao(IActivityTeacherDao activityTeacherDao) {
		super.setBaseDao(activityTeacherDao);
	}

	public void saveActivityTeacher(String[] memberid,
			ActivityTeacher activityTeacher) {
		if (null != memberid && memberid.length > 0) {
			for (int i = 0; i < memberid.length; i++) {
				Member member = memberDao.get(memberid[i]);
				ActivityTeacher activityTeacherNew = new ActivityTeacher();
				activityTeacherNew.setCreatedate(new Date());
				activityTeacherNew.setModifydate(new Date());
				activityTeacherNew.setIsrecomment("0");// 默认不推荐
				activityTeacherNew.setActivity(activityTeacher.getActivity());
				activityTeacherNew.setMember(member);
				activityTeacherDao.save(activityTeacherNew);
			}
		}

	}

}
