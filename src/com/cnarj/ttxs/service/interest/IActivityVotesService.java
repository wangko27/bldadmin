package com.cnarj.ttxs.service.interest;

import com.cnarj.ttxs.pojo.interest.ActivityVotes;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道Service类 - 活动作品投票信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityVotesService extends IBaseService<ActivityVotes, String>{

	/**
	 * 增加作品投票信息
	 * @param workId 作品id
	 * @param userId 用户id
	 */
	public boolean addActivityVote(String workId,String userId,String userIp);
	/**
	 * 根据 作品id 和用户 和时间查找 投票记录
	 */
	public boolean findActivityVtes(String workId,String userId);
}