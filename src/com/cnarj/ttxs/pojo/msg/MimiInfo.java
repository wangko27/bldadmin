package com.cnarj.ttxs.pojo.msg;

import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.user.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * MsgInfo entity. @author MyEclipse Persistence Tools
 */

public class MimiInfo  implements java.io.Serializable {


    // Fields    

     private String msgid; //ID 
     private Member sendmember; //留言发送者对象
     private String sendusername; //留言发送者昵称
     private String msgcontent; //留言内容
     private Date msgdate; //留言日期
     private Long delstatus; //是否删除 0 否     1 是
     private Long approstatus; //审核状态 0 未通过    1 未审核     2 审核通过
     private String isshow; //是否显示 0 否     1 是
     
     private String approusername; //审核人昵称
     private String approuserip; //审核IP
     private Admin admin; //审核的管理员
     private Long classid;//班级id
     private Set remimis = new HashSet(0);//回复集合
     private List list = new ArrayList();
     
    // Constructors



	/** default constructor */
    public MimiInfo() {
    }

    
    /** full constructor */
    public MimiInfo(String msgid, Member sendmember, String sendusername,
			String msgcontent, Date msgdate, Long delstatus, Long approstatus,
			String isshow, String approusername, String approuserip,
			Admin admin, Long classid, Set remimis, List list) {
		super();
		this.msgid = msgid;
		this.sendmember = sendmember;
		this.sendusername = sendusername;
		this.msgcontent = msgcontent;
		this.msgdate = msgdate;
		this.delstatus = delstatus;
		this.approstatus = approstatus;
		this.isshow = isshow;
		this.approusername = approusername;
		this.approuserip = approuserip;
		this.admin = admin;
		this.classid = classid;
		this.remimis = remimis;
		this.list = list ;
	}


	public String getMsgid() {
		return msgid;
	}


	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}


	public Member getSendmember() {
		return sendmember;
	}


	public void setSendmember(Member sendmember) {
		this.sendmember = sendmember;
	}


	public String getSendusername() {
		return sendusername;
	}


	public void setSendusername(String sendusername) {
		this.sendusername = sendusername;
	}


	public String getMsgcontent() {
		return msgcontent;
	}


	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}


	public Date getMsgdate() {
		return msgdate;
	}


	public void setMsgdate(Date msgdate) {
		this.msgdate = msgdate;
	}


	public Long getDelstatus() {
		return delstatus;
	}


	public void setDelstatus(Long delstatus) {
		this.delstatus = delstatus;
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


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public Set getRemimis() {
		return remimis;
	}


	public void setRemimis(Set remimis) {
		this.remimis = remimis;
	}


	public Long getClassid() {
		return classid;
	}


	public void setClassid(Long classid) {
		this.classid = classid;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}

	

   
    // Property accessors








}