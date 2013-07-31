package com.cnarj.ttxs.pojo.comm;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * ArticleHandleRec entity. @author MyEclipse Persistence Tools
 */

public class ArticleHandleRec  implements java.io.Serializable {


    // Fields    

     private String recordid;
     private Member member;
     private ArticleSrc articleSrc;
     private Long actiontype;
     private Date actiondate;
     private String actionpath;


    // Constructors

    /** default constructor */
    public ArticleHandleRec() {
    }

    
    /** full constructor */
    public ArticleHandleRec(Member member, ArticleSrc articleSrc, Long actiontype, Date actiondate,String actionpath) {
        this.member = member;
        this.articleSrc = articleSrc;
        this.actiontype = actiontype;
        this.actiondate = actiondate;
        this.actionpath = actionpath;
    }

   
    // Property accessors

    public String getRecordid() {
        return this.recordid;
    }
    
    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public ArticleSrc getArticleSrc() {
        return this.articleSrc;
    }
    
    public void setArticleSrc(ArticleSrc articleSrc) {
        this.articleSrc = articleSrc;
    }

    public Long getActiontype() {
        return this.actiontype;
    }
    
    public void setActiontype(Long actiontype) {
        this.actiontype = actiontype;
    }

    public Date getActiondate() {
        return this.actiondate;
    }
    
    public void setActiondate(Date actiondate) {
        this.actiondate = actiondate;
    }
    
	public String getActionpath() {
		return actionpath;
	}
	
	public void setActionpath(String actionpath) {
		this.actionpath = actionpath;
	}
   








}