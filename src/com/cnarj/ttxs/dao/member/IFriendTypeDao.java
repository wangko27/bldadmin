package com.cnarj.ttxs.dao.member;


import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendType;

public interface IFriendTypeDao extends IBaseDao<FriendType,String> {

	/**
	 * 查找用户 根据用户姓名
	 * @param Page
	 * @param xm
	 * @return
	 */
	public Result getMemberList(Page page,String xm);
}
