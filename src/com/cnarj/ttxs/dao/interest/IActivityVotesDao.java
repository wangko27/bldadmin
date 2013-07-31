package com.cnarj.ttxs.dao.interest;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.interest.ActivityVotes;
/**
 * 兴趣频道Dao接口类 - 活动作品投票信息Dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityVotesDao extends IBaseDao<ActivityVotes, String> {

	/**
	 * 查询某条记录
	 * @param string
	 * @return
	 */
	public List<ActivityVotes> findActivityVtes(String hql);

}
