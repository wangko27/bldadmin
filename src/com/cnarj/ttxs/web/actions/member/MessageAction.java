package com.cnarj.ttxs.web.actions.member;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.msg.MsgInfo;
import com.cnarj.ttxs.pojo.msg.RemsgInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IMsgService;
import com.cnarj.ttxs.service.member.IRemsgService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 用户Action类 - 留言板
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class MessageAction extends PageAction {

	private IMsgService msgService;
	private IRemsgService remsgService;
	
	private MsgInfo msg;
	private RemsgInfo remsg;
	private String memberid; //登陆的用户的ID
	private String recmid; //接收留言的ID
	private String recmnikename; //就收留言的用户昵称
	private String showmid;//查询留言时 所查询用户的ID
	private List<MsgInfo> msgList;
	

	public RemsgInfo getRemsg() {		return remsg;	}
	public void setRemsg(RemsgInfo remsg) {		this.remsg = remsg;	}
	public IRemsgService getRemsgService() {	return remsgService;	}
	public void setRemsgService(IRemsgService remsgService) {		this.remsgService = remsgService;	}
	public List<MsgInfo> getMsgList() {		return msgList;	}
	public void setMsgList(List<MsgInfo> msgList) {		this.msgList = msgList;	}
	public String getShowmid() {		return showmid;	}
	public void setShowmid(String showmid) {		this.showmid = showmid;	}
	public String getRecmid() {		return recmid;	}
	public void setRecmid(String recmid) {		this.recmid = recmid;	}
	public String getRecmnikename() {		return recmnikename;	}
	public void setRecmnikename(String recmnikename) {		this.recmnikename = recmnikename;	}
	public MsgInfo getMsg() {		return msg;	}
	public void setMsg(MsgInfo msg) {		this.msg = msg;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public IMsgService getMsgService() {		return msgService;	}
	public void setMsgService(IMsgService msgService) {		this.msgService = msgService;	}
	
	/**
	 * 发表留言
	 * @return
	 */
	public String add(){
		try{
			
			Member recm = new Member();
			recm.setMemberid(recmid);
			recm.setNikename(recmnikename);
		
	
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			Member sendm = new Member();
			sendm.setMemberid(this.memberid);
			sendm.setNikename(nikename);
			

			
			msgService.saveMsg(msg, recm, sendm);
	
			this.addActionMessage("留言成功！");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("留言失败！");
			return ERROR;
		}
	}

	/**
	 * 回复
	 * @return
	 */
	public String addRemsg(){
		try{
			//取当前时间
			Date now = new Date(System.currentTimeMillis());

			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			Member sendm = new Member();
			sendm.setMemberid(this.memberid);
			sendm.setNikename(nikename);
			
			this.remsg.setAdmin(null);
			remsg.setApprostatus(new Long("2"));
			remsg.setDelstatus(new Long("0"));
			remsg.setIschat("0");
			remsg.setIsshow("0");
			remsg.setMemberBySenduserid(sendm);
			remsg.setMsg(msg);
			remsg.setRemsgdate(now);
			remsg.setSendusername(nikename);
			
			this.remsgService.save(remsg);
	
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("回复留言失败！");
			return ERROR;
		}
	}
	
	
	/**
	 * 查询留言
	 * @return
	 */
	public String list(){

		//page分页信息
		// 设置每页显示的条数
		page.setEveryPage(CommStaticNum.PAGENUM_MSG);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		if(this.showmid == null || this.showmid.trim().length() == 0){
			this.showmid = this.memberid;
		}
		
		result = this.msgService.listUserMsg(page, this.showmid);
		msgList = result.getContent();
		return SUCCESS;
	}
	
	@Override
	/**
	 * 所有的方法都要判断用户信息
	 */
	public void validate() {
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
		}
	}
}
