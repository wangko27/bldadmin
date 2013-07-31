package com.cnarj.ttxs.pojo.stuz;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * blogaction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class blogaction implements java.io.Serializable {

	// Fields

	private String actionid;
	private Blog blog;
	private Member member;
	private Long actiontype;
	private Date actiondate;
	private String userip;
	private String username;

	// Constructors

	/** default constructor */
	public blogaction() {
	}

	
	public blogaction(Blog blog, Member member, Long actiontype,
			Date actiondate, String userip, String username) {
	
		this.blog = blog;
		this.member = member;
		this.actiontype = actiontype;
		this.actiondate = actiondate;
		this.userip = userip;
		this.username = username;
	}


	public String getActionid() {
		return actionid;
	}

	public void setActionid(String actionid) {
		this.actionid = actionid;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Long getActiontype() {
		return actiontype;
	}

	public void setActiontype(Long actiontype) {
		this.actiontype = actiontype;
	}

	public Date getActiondate() {
		return actiondate;
	}

	public void setActiondate(Date actiondate) {
		this.actiondate = actiondate;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}