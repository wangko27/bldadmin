package com.cnarj.ttxs.service.imp.member;


import java.util.Date;

import com.cnarj.ttxs.dao.member.IMsgDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MsgInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IMsgService;

public class MsgServiceImpl extends BaseServiceImpl<MsgInfo,String> implements IMsgService {

	private IMsgDao msgDao;
	
	public IMsgDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(IMsgDao msgDao) {
		this.msgDao = msgDao;
	}

	public void setBaseDao(IMsgDao msgDao) {
		super.setBaseDao(msgDao);
	}
	
	/**
	 * 保存留言
	 * @param info 留言对象
	 * @param recm 留言接收人对象
	 * @param sendm 留言发送人对象
	 * @return
	 */
	public int saveMsg(MsgInfo info,Member recm,Member sendm){
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		info.setAdmin(null);
		info.setApprostatus(new Long("2"));
		info.setDelstatus(new Long("0"));
		info.setIschat("0");
		info.setIsread("0");
		info.setIsshow("1");
		info.setMemberByRecuserid(recm);
		info.setMemberBySenduserid(sendm);
		info.setMsgdate(now);
		info.setRecusername(recm.getNikename());
		info.setSendusername(sendm.getNikename());
		
		msgDao.save(info);
		
		return 1;
	}

	public Result listUserMsg(Page page, String memberid) {

		return msgDao.listUserMsg(page, memberid);
	}
	
}
