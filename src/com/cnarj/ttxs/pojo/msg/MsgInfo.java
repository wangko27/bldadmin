package com.cnarj.ttxs.pojo.msg;

import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * MsgInfo entity. @author MyEclipse Persistence Tools
 */

public class MsgInfo  implements java.io.Serializable {


    // Fields    

     private String msgid; //ID 
     private Admin admin; //审核的管理员
     private Member memberBySenduserid; //留言发送者对象
     private MsgInfo msgInfo; //上级留言对象
     private Member memberByRecuserid; //留言接受者对象
     private String msgtitle; //留言标题
     private String msgcontent; //留言内容
     private Date msgdate; //留言日期
     private String sendusername; //留言发送者昵称
     private String recusername; //留言接收者昵称
     private String isread; //是否已读 0 否     1 是
     private Long delstatus; //是否删除 0 否     1 是
     private String ischat; //是否私聊 0 否     1 是
     private Long approstatus; //审核状态 0 未通过    1 未审核     2 审核通过
     private String isshow; //是否显示 0 否     1 是
     private String approusername; //审核人昵称
     private String approuserip; //审核IP
     private Set msgInfos = new HashSet(0); //子留言集合
     private Set remsgs = new HashSet(0);//回复集合

    // Constructors

    /** default constructor */
    public MsgInfo() {
    }

    
    /** full constructor */
    public MsgInfo(Admin admin, Member memberBySenduserid, MsgInfo msgInfo, Member memberByRecuserid, String msgtitle, String msgcontent, Date msgdate, String sendusername, String recusername, String isread, Long delstatus, String ischat, Long approstatus, String isshow, String approusername, String approuserip, Set msgInfos,Set remsgs) {
        this.admin = admin;
        this.memberBySenduserid = memberBySenduserid;
        this.msgInfo = msgInfo;
        this.memberByRecuserid = memberByRecuserid;
        this.msgtitle = msgtitle;
        this.msgcontent = msgcontent;
        this.msgdate = msgdate;
        this.sendusername = sendusername;
        this.recusername = recusername;
        this.isread = isread;
        this.delstatus = delstatus;
        this.ischat = ischat;
        this.approstatus = approstatus;
        this.isshow = isshow;
        this.approusername = approusername;
        this.approuserip = approuserip;
        this.msgInfos = msgInfos;
        this.remsgs = remsgs;
    }

   
    // Property accessors

    public String getMsgid() {
        return this.msgid;
    }
    
    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Member getMemberBySenduserid() {
        return this.memberBySenduserid;
    }
    
    public void setMemberBySenduserid(Member memberBySenduserid) {
        this.memberBySenduserid = memberBySenduserid;
    }

    public MsgInfo getMsgInfo() {
        return this.msgInfo;
    }
    
    public void setMsgInfo(MsgInfo msgInfo) {
        this.msgInfo = msgInfo;
    }

    public Member getMemberByRecuserid() {
        return this.memberByRecuserid;
    }
    
    public void setMemberByRecuserid(Member memberByRecuserid) {
        this.memberByRecuserid = memberByRecuserid;
    }

    public String getMsgtitle() {
        return this.msgtitle;
    }
    
    public void setMsgtitle(String msgtitle) {
        this.msgtitle = msgtitle;
    }

    public String getMsgcontent() {
        return this.msgcontent;
    }
    
    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }

    public Date getMsgdate() {
        return this.msgdate;
    }
    
    public void setMsgdate(Date msgdate) {
        this.msgdate = msgdate;
    }

    public String getSendusername() {
        return this.sendusername;
    }
    
    public void setSendusername(String sendusername) {
        this.sendusername = sendusername;
    }

    public String getRecusername() {
        return this.recusername;
    }
    
    public void setRecusername(String recusername) {
        this.recusername = recusername;
    }

    public String getIsread() {
        return this.isread;
    }
    
    public void setIsread(String isread) {
        this.isread = isread;
    }

    public Long getDelstatus() {
        return this.delstatus;
    }
    
    public void setDelstatus(Long delstatus) {
        this.delstatus = delstatus;
    }

    public String getIschat() {
        return this.ischat;
    }
    
    public void setIschat(String ischat) {
        this.ischat = ischat;
    }

    public Long getApprostatus() {
        return this.approstatus;
    }
    
    public void setApprostatus(Long approstatus) {
        this.approstatus = approstatus;
    }

    public String getIsshow() {
        return this.isshow;
    }
    
    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }

    public String getApprousername() {
        return this.approusername;
    }
    
    public void setApprousername(String approusername) {
        this.approusername = approusername;
    }

    public String getApprouserip() {
        return this.approuserip;
    }
    
    public void setApprouserip(String approuserip) {
        this.approuserip = approuserip;
    }

    public Set getMsgInfos() {
        return this.msgInfos;
    }
    
    public void setMsgInfos(Set msgInfos) {
        this.msgInfos = msgInfos;
    }


	public Set getRemsgs() {
		return remsgs;
	}


	public void setRemsgs(Set remsgs) {
		this.remsgs = remsgs;
	}
   








}