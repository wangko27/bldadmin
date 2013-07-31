package com.cnarj.ttxs.service.member;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MsgInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

public interface IMsgService extends IBaseService<MsgInfo,String> {
	
	/**
	 * 保存留言
	 * @param info 留言对象
	 * @param recm 留言接收人对象
	 * @param sendm 留言发送人对象
	 * @return
	 */
	public int saveMsg(MsgInfo info,Member recm,Member sendm);

	/**
	 * 查询指定用户的留言信息
	 * @param page 分页对象
	 * @param memberid 要查询留言的用户ID
	 * @return
	 */
	public Result listUserMsg(Page page,String memberid) ;
}
