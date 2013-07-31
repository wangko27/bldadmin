package com.cnarj.ttxs.dao.imp.interest;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.interest.IActivityVotesDao;
import com.cnarj.ttxs.pojo.interest.ActivityVotes;

/**
 * 兴趣频道Dao实现类 - 活动作品投票信息Daoimpl
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityVotesDaoImpl extends BaseDaoImpl<ActivityVotes, String> implements IActivityVotesDao {

	@SuppressWarnings("unchecked")
	public List<ActivityVotes> findActivityVtes(String hql) {
		
		return  this.getSession().createQuery(hql).list();
	}

}
