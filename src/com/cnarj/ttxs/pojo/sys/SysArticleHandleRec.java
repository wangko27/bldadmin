package com.cnarj.ttxs.pojo.sys;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;


/**
 * ArticleHandleRec entity. @author MyEclipse Persistence Tools
 */

public class SysArticleHandleRec  implements java.io.Serializable {


    // Fields    

     private String recordid;
     private Member member;
     private Article article;
     private Long actiontype;
     private Date actiondate;
     private String actionpath;


    // Constructors

    /** default constructor */
    public SysArticleHandleRec() {
    }

    
    /** full constructor */
    public SysArticleHandleRec(Member member, Article article, Long actiontype, Date actiondate,String actionpath) {
        this.member = member;
        this.article = article;
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
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
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