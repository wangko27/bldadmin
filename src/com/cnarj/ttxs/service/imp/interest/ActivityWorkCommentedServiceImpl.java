package com.cnarj.ttxs.service.imp.interest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.dao.interest.IActivityWorkCommentedDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.interest.IActivityWorkCommentedService;

/**
 * 兴趣频道service实现类 - 活动作品平任信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityWorkCommentedServiceImpl extends BaseServiceImpl< ActivityWorkCommented, String> implements IActivityWorkCommentedService {

	private IActivityWorkCommentedDao activityWorkCommentedDao;

	public IActivityWorkCommentedDao getActivityWorkCommentedDao() {
		return activityWorkCommentedDao;
	}

	public void setActivityWorkCommentedDao(
			IActivityWorkCommentedDao activityWorkCommentedDao) {
		this.activityWorkCommentedDao = activityWorkCommentedDao;
	}

	
	
	/**
	 * 根据活动作品的id的到活动的详细信息
	 * @param activityId
	 * @return
	 */
	public ActivityWorks getByActivityIdActivityWork(String activityId) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityWorks w where w.worksid='").append(activityId).append("'");
		return activityWorkCommentedDao.ByActivityIdActivityWork(hql.toString());
	}

	/**
	 * 根据活动作品的id得到评论的总条数
	 */
	public long getCount(String activityId) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(*) from ActivityWorkCommented c where c.works.worksid='")
		.append(activityId).append("'");
		return activityWorkCommentedDao.getCount(hql.toString());
	}
	/**
	 * 根据活动作品的id得到该作品的评论(含分页)
	 * @param workId
	 * @return
	 */
	public Result getByWorkIdActivityWorkCommenteds(String workId,Page page) {
		StringBuffer sql=new StringBuffer();
		sql.append("from ActivityWorkCommented c where c.works.worksid='")
		.append(workId).append("'").append(" order by c.comDate desc");
		
		return activityWorkCommentedDao.getByWorkIdActivityWorkCommenteds(sql.toString(),page);
	}

	public void saveActivityWorkCommentedService(String workId, String userId,
			String comContent, String comUserName,String comIP) {
		ActivityWorkCommented akc=new ActivityWorkCommented();
		akc.setComIP(comIP);//用户id
		akc.setComUserName(comUserName);
		akc.setComContent(comContent);
		akc.setComDate(new Date());
		Member mb=new Member();
		mb.setMemberid(userId);
		akc.setMember(mb);
		ActivityWorks aw=new ActivityWorks();
		aw.setWorksid(workId);
		akc.setWorks(aw);
		activityWorkCommentedDao.save(akc);
	}

	public boolean isActivityWorkCommentedService(String userId, String workId) {
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
		hql.append("from ActivityWorkCommented w where w.works.worksid='").append(workId)
		.append("' and w.member.memberid='").append(userId)
		.append("' and to_char(w.comDate,'yyyy-MM-dd')='"+dat+"'");
		System.out.println(activityWorkCommentedDao.findActivityWorkCommented(hql.toString()).size());
		
		return activityWorkCommentedDao.findActivityWorkCommented(hql.toString()).size()<=0 ? false : true;
	}

	public Member getByUserIdMember(String userid) {
		String hql="from Member m where m.memberid=?";
		return activityWorkCommentedDao.getByUserIdMember(hql,userid);
	}
	/**
	 * 根据作品id得到参赛的图片
	 * @param workId
	 * @return
	 */
	public List<ActivityWorkPhotos> getActivityPhotosbyWorkId(String workId) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityWorkPhotos a where a.work.worksid='").append(workId).append("'");
		return activityWorkCommentedDao.getActivityWorkPhotos(hql.toString());
	}
	
	
}
