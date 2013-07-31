package com.cnarj.ttxs.web.actions.zone;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.msg.MsgInfo;
import com.cnarj.ttxs.pojo.msg.RemsgInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.member.IFriendsInfoService;
import com.cnarj.ttxs.service.member.IMsgService;
import com.cnarj.ttxs.service.member.IRemsgService;
import com.cnarj.ttxs.web.actions.base.PageAction;

public class MessageAction extends PageAction {

	private IMsgService msgService;
	private IRemsgService remsgService;
	private MemberService memberService;
	private IFriendsInfoService friendService;
	
	private MsgInfo msg;
	private RemsgInfo remsg;
	private List<MsgInfo> msgList;

	private String TTid;//所访问的用户Id 
	private Member TTUser;//所访问的用户对象
	private String memberid;//当前用户ID
	private boolean friendsign = false;//是否已是好友标志

	
	public boolean isFriendsign() {		return friendsign;	}
	public void setFriendsign(boolean friendsign) {		this.friendsign = friendsign;	}
	public IFriendsInfoService getFriendService() {		return friendService;	}
	public void setFriendService(IFriendsInfoService friendService) {		this.friendService = friendService;	}
	public MemberService getMemberService() {		return memberService;	}
	public void setMemberService(MemberService memberService) {		this.memberService = memberService;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public RemsgInfo getRemsg() {		return remsg;	}
	public void setRemsg(RemsgInfo remsg) {		this.remsg = remsg;	}
	public IRemsgService getRemsgService() {		return remsgService;	}
	public void setRemsgService(IRemsgService remsgService) {		this.remsgService = remsgService;	}
	public String getTTid() {		return TTid;	}
	public void setTTid(String tid) {		TTid = tid;	}
	public Member getTTUser() {		return TTUser;	}
	public void setTTUser(Member user) {		TTUser = user;	}
	public List<MsgInfo> getMsgList() {		return msgList;	}
	public void setMsgList(List<MsgInfo> msgList) {		this.msgList = msgList;	}
	public MsgInfo getMsg() {		return msg;	}
	public void setMsg(MsgInfo msg) {		this.msg = msg;	}
	public IMsgService getMsgService() {		return msgService;	}
	public void setMsgService(IMsgService msgService) {		this.msgService = msgService;	}
	

	
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
		
		result = this.msgService.listUserMsg(page, this.TTid);
		msgList = result.getContent();
		return SUCCESS;
	}
	/**
	 * 发表留言
	 * @return
	 */
	public String add(){
		try{
			Member recm = new Member();
			recm.setMemberid(this.TTid);
			recm.setNikename(this.TTUser.getNikename());
		
	
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			Member sendm = new Member();
			sendm.setMemberid(memberid);
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
	public void validateAdd() {
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
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
	public void validateAddRemsg() {
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
		}
	}
	

	@Override
	/**
	 * 所有的方法都要判断他人用户信息
	 */
	public void validate() {
		if(this.TTid == null || this.TTid.length() == 0){
			this.addActionError("错误！需指定他人ID");
		}
		else{
			if(null == TTUser){
				TTUser = memberService.get(this.TTid);
				
				String mid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
				if(null != mid && mid.length() > 0){

					//判断是否是好友
					Hashtable table = new Hashtable();
					table.put("memberByUserid.memberid", mid);
					table.put("memberByFrienduserid.memberid", TTid);
					
					this.friendsign = this.friendService.isExist(table);
				}
				
			}
		}
	}
}
