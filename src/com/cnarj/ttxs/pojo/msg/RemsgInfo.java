package com.cnarj.ttxs.pojo.msg;

import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * MsgInfo entity. @author MyEclipse Persistence Tools
 */

public class RemsgInfo  implements java.io.Serializable {


    // Fields    
     private String remsgid; //ID 
     private String remsgcontent; //留言内容
     private Date remsgdate; //留言日期
     private String sendusername; //留言发送者昵称
     private Long delstatus; //是否删除 0 否     1 是
     private String ischat; //是否私聊 0 否     1 是
     private Long approstatus; //审核状态 0 未通过    1 未审核     2 审核通过
     private String isshow; //是否显示 0 否     1 是
     private String approusername; //审核人昵称
     private String approuserip; //审核IP
     
     private Member memberBySenduserid; //留言发送者对象
     private MsgInfo msg;
     private Admin admin; //审核的管理员
     

    // Constructors



	/** default constructor */
    public RemsgInfo() {
    }

    
    /** full constructor */

    public RemsgInfo(String remsgid, String remsgcontent, Date remsgdate,
			String sendusername, Long delstatus, String ischat,
			Long approstatus, String isshow, String approusername,
			String approuserip, Member memberBySenduserid, MsgInfo msg,
			Admin admin) {
		super();
		this.remsgid = remsgid;
		this.remsgcontent = remsgcontent;
		this.remsgdate = remsgdate;
		this.sendusername = sendusername;
		this.delstatus = delstatus;
		this.ischat = ischat;
		this.approstatus = approstatus;
		this.isshow = isshow;
		this.approusername = approusername;
		this.approuserip = approuserip;
		this.memberBySenduserid = memberBySenduserid;
		this.msg = msg;
		this.admin = admin;
	}


	public String getRemsgid() {
		return remsgid;
	}


	public void setRemsgid(String remsgid) {
		this.remsgid = remsgid;
	}


	public String getRemsgcontent() {
		return remsgcontent;
	}


	public void setRemsgcontent(String remsgcontent) {
		this.remsgcontent = remsgcontent;
	}


	public Date getRemsgdate() {
		return remsgdate;
	}


	public void setRemsgdate(Date remsgdate) {
		this.remsgdate = remsgdate;
	}


	public String getSendusername() {
		return sendusername;
	}


	public void setSendusername(String sendusername) {
		this.sendusername = sendusername;
	}


	public Long getDelstatus() {
		return delstatus;
	}


	public void setDelstatus(Long delstatus) {
		this.delstatus = delstatus;
	}


	public String getIschat() {
		return ischat;
	}


	public void setIschat(String ischat) {
		this.ischat = ischat;
	}


	public Long getApprostatus() {
		return approstatus;
	}


	public void setApprostatus(Long approstatus) {
		this.approstatus = approstatus;
	}


	public String getIsshow() {
		return isshow;
	}


	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}


	public String getApprousername() {
		return approusername;
	}


	public void setApprousername(String approusername) {
		this.approusername = approusername;
	}


	public String getApprouserip() {
		return approuserip;
	}


	public void setApprouserip(String approuserip) {
		this.approuserip = approuserip;
	}


	public Member getMemberBySenduserid() {
		return memberBySenduserid;
	}


	public void setMemberBySenduserid(Member memberBySenduserid) {
		this.memberBySenduserid = memberBySenduserid;
	}


	public MsgInfo getMsg() {
		return msg;
	}


	public void setMsg(MsgInfo msg) {
		this.msg = msg;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

   
    // Property accessors









}