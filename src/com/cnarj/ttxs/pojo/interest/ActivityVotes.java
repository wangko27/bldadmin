package com.cnarj.ttxs.pojo.interest;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * ActivityVotes entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ActivityVotes implements java.io.Serializable {

	// Fields

	private String id;
	private ActivityWorks activityWorks;
	private String userip;
	private Date createdate;
	private Date modifydate;
	private Long votes;

	private Member member;
	// Constructors

	
	/** default constructor */
	public ActivityVotes() {
	}

	/** full constructor */
	public ActivityVotes(ActivityWorks activityWorks, String userip,
			Date createdate, Date modifydate,Long votes) {
		this.activityWorks = activityWorks;
		this.userip = userip;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.votes = votes;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ActivityWorks getActivityWorks() {
		return this.activityWorks;
	}

	public void setActivityWorks(ActivityWorks activityWorks) {
		this.activityWorks = activityWorks;
	}

	public String getUserip() {
		return this.userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	
	

}