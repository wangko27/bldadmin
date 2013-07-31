package com.cnarj.ttxs.service.imp.interest;

import java.util.Calendar;
import java.util.Date;

import com.cnarj.ttxs.dao.interest.IActivityVotesDao;
import com.cnarj.ttxs.pojo.interest.ActivityVotes;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.interest.IActivityVotesService;

/**
 * 兴趣频道Service实现类 - 活动作品投票信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityVotesServiceImpl extends BaseServiceImpl<ActivityVotes, String> implements IActivityVotesService {

	private IActivityVotesDao activityVotesDao;

	public IActivityVotesDao getActivityVotesDao() {
		return activityVotesDao;
	}

	public void setActivityVotesDao(IActivityVotesDao activityVotesDao) {
		this.activityVotesDao = activityVotesDao;
	}

	/**
	 * 增加作品投票信息
	 * @param workId 作品id
	 * @param userId 用户id
	 */
	public boolean addActivityVote(String workId, String userId,String userIp) {
		ActivityVotes votes=new ActivityVotes();
		ActivityWorks works=new ActivityWorks();
		works.setWorksid(workId);
		votes.setActivityWorks(works);
		votes.setUserip(userIp);
		votes.setCreatedate(new Date());
		votes.setModifydate(new Date());
		votes.setVotes(new Long(1));
		Member member=new Member();
		member.setMemberid(userId);
		votes.setMember(member);
		activityVotesDao.save(votes);
		return false;
	}
	/**
	 * 根据 作品id 和用户 和时间查找 投票记录
	 */
	public boolean findActivityVtes(String workId, String userId) {	
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int mm=cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DATE);
		String str_mm=null;
		String str_day=day+"";
		if(mm<10){
			str_mm="0"+mm;
		}
		if(day<10){
			str_day="0"+day;
		}
		String dat=year+"-"+str_mm+"-"+str_day;
		System.out.println(dat);
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityVotes v where v.activityWorks.worksid='").append(workId)
		.append("' and v.member.memberid='").append(userId)
		.append("' and to_char(v.createdate,'yyyy-MM-dd')='"+dat+"'");
		System.out.println(activityVotesDao.findActivityVtes(hql.toString()).size());
		return activityVotesDao.findActivityVtes(hql.toString()).size()<=0 ? false : true;
	}
	
}
