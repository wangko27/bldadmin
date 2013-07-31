package com.cnarj.ttxs.pojo.learn;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;

/**
 * ReadSrcHandleRec entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ReadSrcHandleRec implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String recid;// 主建
	private ReadSrc readSrc;// 博览群书
	private Member member;// 用户
	private Long actiontype;// 处理类别 1分享，2收藏，3推荐
	private Date actiondate;// 处理时间
    private String actionpath;

	// Constructors

	/** default constructor */
	public ReadSrcHandleRec() {
	}

	/** full constructor */
	public ReadSrcHandleRec(ReadSrc readSrc, Member member, Long actiontype,String actionpath,
			Date actiondate) {
		this.readSrc = readSrc;
		this.member = member;
		this.actiontype = actiontype;
		this.actiondate = actiondate;
        this.actionpath = actionpath;
	}

	// Property accessors

	public String getRecid() {
		return this.recid;
	}

	public void setRecid(String recid) {
		this.recid = recid;
	}

	public ReadSrc getReadSrc() {
		return this.readSrc;
	}

	public void setReadSrc(ReadSrc readSrc) {
		this.readSrc = readSrc;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
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