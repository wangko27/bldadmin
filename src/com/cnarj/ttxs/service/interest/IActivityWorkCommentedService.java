package com.cnarj.ttxs.service.interest;


import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道service类 - 活动作品评论信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityWorkCommentedService extends IBaseService<ActivityWorkCommented, String>{

	/**
	 * 根据活动作品的id的到活动的详细信息
	 * @param activityId
	 * @return
	 */
	public ActivityWorks getByActivityIdActivityWork(String activityId);
	/**
	 * 根据活动作品的id得到评论的总条数
	 */
	public long getCount(String activityId);
	/**
	 * 根据活动作品的id得到该作品的评论(含分页)
	 * @param workId
	 * @return
	 */
	public Result getByWorkIdActivityWorkCommenteds(String workId,Page page);
	/**
	 * 根据用户id和作品id  和时间得到是否评论
	 */
	public boolean isActivityWorkCommentedService(String userId,String workId);
	/**
	 * 插入一条评论
	 */
	public void saveActivityWorkCommentedService(String workId,
			String userId,String comContent,String comUserName ,String comIp);
	/**
	 * 根据用户id得到用户名称
	 */
	public Member getByUserIdMember(String userid);
	/**
	 * 根据作品id得到参赛的图片
	 * @param workId
	 * @return
	 */
	public List<ActivityWorkPhotos> getActivityPhotosbyWorkId(String workId);
}