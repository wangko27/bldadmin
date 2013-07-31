package com.cnarj.ttxs.pojo.comm;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * ArticleCommentInfo entity. @author MyEclipse Persistence Tools
 */

public class ArticleCommentInfo  implements java.io.Serializable {


    // Fields    

     private String msgid;
     private ArticleSrc articleSrc;
     private Member member;
     private String msgContent;
     private String msgUserOthername;
     private String msgUserIp;
     private Date msgTime;
     private String flag;


    // Constructors

    /** default constructor */
    public ArticleCommentInfo() {
    }

    
    /** full constructor */
    public ArticleCommentInfo(ArticleSrc articleSrc, Member member, String msgContent, String msgUserOthername, String msgUserIp, Date msgTime, String flag) {
        this.articleSrc = articleSrc;
        this.member = member;
        this.msgContent = msgContent;
        this.msgUserOthername = msgUserOthername;
        this.msgUserIp = msgUserIp;
        this.msgTime = msgTime;
        this.flag = flag;
    }

   
    // Property accessors

    public String getMsgid() {
        return this.msgid;
    }
    
    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public ArticleSrc getArticleSrc() {
        return this.articleSrc;
    }
    
    public void setArticleSrc(ArticleSrc articleSrc) {
        this.articleSrc = articleSrc;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public String getMsgContent() {
        return this.msgContent;
    }
    
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgUserOthername() {
        return this.msgUserOthername;
    }
    
    public void setMsgUserOthername(String msgUserOthername) {
        this.msgUserOthername = msgUserOthername;
    }

    public String getMsgUserIp() {
        return this.msgUserIp;
    }
    
    public void setMsgUserIp(String msgUserIp) {
        this.msgUserIp = msgUserIp;
    }

    public Date getMsgTime() {
        return this.msgTime;
    }
    
    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public String getFlag() {
        return this.flag;
    }
    
    public void setFlag(String flag) {
        this.flag = flag;
    }
   








}