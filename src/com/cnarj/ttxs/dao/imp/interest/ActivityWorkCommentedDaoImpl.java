package com.cnarj.ttxs.dao.imp.interest;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.interest.IActivityWorkCommentedDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.user.Member;

/**
 * 兴趣频道Dao实现类 - 活动作品平任信息DaoImpl
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityWorkCommentedDaoImpl extends BaseDaoImpl<ActivityWorkCommented, String> implements
		IActivityWorkCommentedDao {

	/**
	 * 根据hql 得到作品的详细信息
	 * @param hql
	 * @return
	 */
	public ActivityWorks ByActivityIdActivityWork(String hql) {
		return (ActivityWorks) this.getSession().createQuery(hql).uniqueResult();
	}

	/**
	 * 根据hql 得到总行数
	 * @param hql
	 * @return
	 */
	public long getCount(String hql) {
		return (Long) this.getSession().createQuery(hql).uniqueResult();
	}

	/**
	 * 根据活动作品的id得到该作品的评论(含分页)
	 * @param 
	 * @return
	 */
	public Result getByWorkIdActivityWorkCommenteds(String hql, Page page) {
		return this.findByPager(page, hql);
	}

	/**
	 * 判断用户是否评论过该作品
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityWorkCommented> findActivityWorkCommented(String hql) {
		return this.getSession().createQuery(hql).list();
	}
/**
 * 根据用户id的到用户信息
 */
	public Member getByUserIdMember(String hql, String userid) {
		return (Member) this.getSession().createQuery(hql).setParameter(0, userid).uniqueResult();
	}
	/**
	 * 根据作品id得到参赛的图片
	 * @param workId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityWorkPhotos> getActivityWorkPhotos(String hql) {
		
		return this.getSession().createQuery(hql).list();
}

	
	
}
