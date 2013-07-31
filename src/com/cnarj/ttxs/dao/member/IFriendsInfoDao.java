package com.cnarj.ttxs.dao.member;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendsInfo;

public interface IFriendsInfoDao extends IBaseDao<FriendsInfo,String> {

	/**
	 * 查询我的好友
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getFriendList(Page page,String memberid,String typeid);
}
