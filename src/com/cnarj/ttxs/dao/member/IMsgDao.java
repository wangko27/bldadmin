package com.cnarj.ttxs.dao.member;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MsgInfo;

public interface IMsgDao extends IBaseDao<MsgInfo,String> {


	/**
	 * 查询指定用户的留言信息
	 * @param page 分页对象
	 * @param memberid 要查询留言的用户ID
	 * @return
	 */
	public Result listUserMsg(Page page,String memberid) ;
}
