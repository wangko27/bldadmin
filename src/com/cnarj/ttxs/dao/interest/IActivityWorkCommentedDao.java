package com.cnarj.ttxs.dao.interest;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.user.Member;

/**
 * 兴趣频道Dao接口类 - 活动作品平任信息Dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityWorkCommentedDao extends IBaseDao<ActivityWorkCommented, String> {

	/**
	 * 根据hql 得到作品的详细信息
	 * @param hql
	 * @return
	 */
	public ActivityWorks ByActivityIdActivityWork(String hql);

	/**
	 * 根据hql 得到总行数
	 * @param hql
	 * @return
	 */
	public long getCount(String hql);
	/**
	 * 根据活动作品的id得到该作品的评论(含分页)
	 * @param
	 * @return
	 */

	public Result getByWorkIdActivityWorkCommenteds(String hql, Page page);
/**
 * 判断用户是否评论过该作品
 * @param hql
 * @return
 */
	public List<ActivityWorkCommented> findActivityWorkCommented(String hql);
/**
 * 根据用户id得到用户信息
 * @param hql
 * @param userid
 * @return
 */
public Member getByUserIdMember(String hql, String userid);

/**
 * 根据作品id得到参赛的图片
 * @param workId
 * @return
 */
public List<ActivityWorkPhotos> getActivityWorkPhotos(String hql);

}
