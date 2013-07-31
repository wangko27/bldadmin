package com.cnarj.ttxs.service.imp.interest;

import java.util.List;


import com.cnarj.ttxs.dao.interest.IActivityWorksDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.interest.IActivityWorksService;

/**
 * 兴趣频道Service实现类 - 活动作品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityWorksServiceImpl extends BaseServiceImpl<ActivityWorks, String> implements IActivityWorksService {

	private IActivityWorksDao activityWorksDao;

	public IActivityWorksDao getActivityWorksDao() {
		return activityWorksDao;
	}

	public void setActivityWorksDao(IActivityWorksDao activityWorksDao) {
		this.activityWorksDao = activityWorksDao;
	}
	/**
	 * 按活动的id号  得到所有的参赛作品,
	 * @param workId 
	 * @return
	 */
	public Result getByActivityIdWorks(String activityId,Page page) {
		if(activityId!=null&&!activityId.trim().equals("")){
			StringBuffer hql=new StringBuffer();
			hql.append("from ActivityWorks b where b.activity.activityid='")
			.append(activityId).append("'");
			return activityWorksDao.getActivityWorkses(hql.toString(), page);
		}
		return null;
	}

	/**
	 * 根据活动票数得到规定的num条数据
	 * isPro 是否按栏目来查
	 * pro  栏目的id
	 * @param num
	 * @return
	 */
	public List<ActivityWorks> getByFareActivityWorks(int num,boolean isPro,String proid) {
		if(num<=0){
			num=3;
		}
		StringBuffer hql=new StringBuffer();
		if(isPro){
			hql.append("from ActivityWorks a where a.activity.programa.proID='").append(proid).append("' order by a.votes desc");
		}else{
			hql.append("from ActivityWorks w where w.activity.activityid='").append(proid).append("' order by w.votes desc");
		}
		String ss=hql.toString();
		return activityWorksDao.getByFareActivityWorkses(num, ss);
	}
	/**
	 * 根据活动的id得到活动的详细信息
	 * @param actId 活动Id
	 * @return
	 */
	public Activity getByIdActivity(String actId) {
		String hql="from Activity a where a.activityid=? ";
		return activityWorksDao.getByIdActivity(hql,actId);
	}
	/**
	 * 根据活动的id 得到所有的活动的指导老师
	 * @param actId 活动的id
	 * @return
	 */
	public List<ActivityTeacher> getByActIdActivityTeacher(String actId) {
		String hql="from ActivityTeacher t where t.activity.activityid='"+actId+"' and t.isrecomment='1'";
		return activityWorksDao.getByActIdActivityTeacher(hql);
	}

	/**
	 * 根据活动的Id得到num条用户拼论
	 * @param stypeId 查询评论的条件
	 * @param num
	 * @param isSelect 是否是单个作品的评论
	 * @return
	 */
	public List<ActivityWorkCommented> getByActIdActivityWorkCommented(
			String stypeId, int num, boolean isSelect) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityWorkCommented w where 1=1 ");
		if(isSelect){
			hql.append(" and w.works.worksid='").append(stypeId).append("'");
		}else {
			hql.append(" and w.works.activity.activityid='").append(stypeId).append("'");
		}
		hql.append(" order by w.comDate desc");
		return activityWorksDao.getByActIdActivityWorkCommented(hql.toString(),num);
	}

	/**
	 * 
	 * 按活动的id号  得到num条的参赛作品 按descType排序
	 * @param num
	 * @return
	 *
	 */
	public List<ActivityWorks> getByActivityIdWorks(String actId,
			int num,String descType) {
			StringBuffer hql=new StringBuffer();
			hql.append("from ActivityWorks b where b.activity.activityid='")
			.append(actId);
			if(descType.equals("0")){
				hql.append("' order by b.worksnumber");
			}else if(descType.equals("1")){
				hql.append("' order by b.votes desc");
			}
		return  activityWorksDao.getActivityWorkses(hql.toString(), num);
	}
	/**
	 * 
	 * 获得最新通过审核的活动作品信息
	 * @param num
	 * @return
	 *
	 */
	public List<ActivityWorks> getnewsWorks(int num) {
			StringBuffer hql=new StringBuffer();
			hql.append("from ActivityWorks a where a.approstatu='1'").append(" order by a.createdate desc");
		return  activityWorksDao.getActivityWorkses(hql.toString(), num); 
	}
	/**
	 * 根据老师的id得到他的最新博文信息
	 */
	public Blog getByTeacherIdBlog(String teacherid) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Blog b where b.viewperm=1 and b.member.memberid='")
		.append(teacherid).append("' order by b.modifydate desc");
		List<Blog> blogs=activityWorksDao.getByTeacherIdBlog(hql.toString(),1);
		if(blogs.size()==0){
			return null;
		}
		return blogs.get(0);
	}

	
	/**
	 * 根据活动的id得到活动公告
	 */
	public List<Article> getBySysnotesidArticles(String actId,int num) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Article a where a.articleType.articleType.articleType.articletypeid='").append(actId)
		.append("' order by a.createdate desc");
		return activityWorksDao.getBySysnotesidArticles(hql.toString(),num);
	}
	/**
	 * 根据行业类别的id得到行业知识
	 * 
	 */
	public List<Article> getByIndustryidArticles(String actid, int num,boolean isAll) {
		StringBuffer hql=new StringBuffer();
		if(isAll){
			hql.append("from Article a where a.articleType.articleType.articleType.articletypeid='").append(actid)
			.append("' order by a.createdate desc");
		}else{
			hql.append("from Article a where a.articleType.articletypeid='").append(actid)
			.append("' order by a.createdate desc");
		}
		return activityWorksDao.getBySysnotesidArticles(hql.toString(),num);
	}
	/**
	 *按作品id修改投票次数
	 *并返回修改后的值
	 */
	public ActivityWorks updateActivityWorksFare(String worksId) {
		ActivityWorks works=activityWorksDao.get(worksId);
		int worksfare=works.getVotes().intValue();
		worksfare=worksfare+1;
		works.setVotes(new Long(worksfare));
		activityWorksDao.update(works);
		return activityWorksDao.get(worksId);
	}

	/**
	 * 得到所有的活动公告(根据活动)
	 * @param sysnotesid
	 * @return
	 */
	public Result getAllActivityBulletin(String sysnotesid,Page page) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Article a where a.articleType.articleType.articleType.articletypeid='").append(sysnotesid)
		.append("' order by a.createdate desc");
		Result result=activityWorksDao.getAllActivityBulletin(hql.toString(),page);
		return result;
	}
	/**
	 * 得到该活动的总的评论数量
	 * @param activitId
	 * @return
	 */
	public Long getByActIdActivityWorkCommentedNum(String activitId) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(*) from ActivityWorkCommented a where a.works.activity.activityid='").append(activitId).append("'");;
		return activityWorksDao.getByActIdActivityWorkCommentedNum(hql.toString());
	}

}
