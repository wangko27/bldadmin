package com.cnarj.ttxs.pojo.interest;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * ActivityTeacher entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ActivityTeacher implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;// ID
	private Member member;// 指导老师
	private Activity activity;// 活动
	private Date createdate;// 添加日期
	private Date modifydate;// 修改日期
	private String isrecomment;// 是否推荐

	// Constructors

	/** default constructor */
	public ActivityTeacher() {
	}

	/** full constructor */
	public ActivityTeacher(Member member, Activity activity, Date createdate,
			Date modifydate, String isrecomment) {
		this.member = member;
		this.activity = activity;
		this.createdate = createdate;
		this.modifydate = modifydate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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

	public String getIsrecomment() {
		return isrecomment;
	}

	public void setIsrecomment(String isrecomment) {
		this.isrecomment = isrecomment;
	}

}