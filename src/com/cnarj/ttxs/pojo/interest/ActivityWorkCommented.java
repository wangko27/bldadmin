package com.cnarj.ttxs.pojo.interest;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;

public class ActivityWorkCommented implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String comID;// 评论ID
	private ActivityWorks works;// 被评论作品
	private String comContent;// 评论内容
	private String comUserName;// 评论用户名称
	private String comIP;// 评论IP
	private Member member;// 评论用户
	private Date comDate;// 评论时间
	private String comDelFlag;// 删除标志 0已删除，1未删除
	private String comIsaudit;// 是否审核通过 0未通过 1已通过 2未审核

	public ActivityWorkCommented() {
		super();
	}

	

	public ActivityWorkCommented(ActivityWorks works, String comContent,
			String comUserName, String comIP, Member member, Date comDate,
			String comDelFlag, String comIsaudit) {
		super();
		this.works = works;
		this.comContent = comContent;
		this.comUserName = comUserName;
		this.comIP = comIP;
		this.member = member;
		this.comDate = comDate;
		this.comDelFlag = comDelFlag;
		this.comIsaudit = comIsaudit;
	}



	public String getComID() {
		return comID;
	}

	public void setComID(String comID) {
		this.comID = comID;
	}

	public ActivityWorks getWorks() {
		return works;
	}

	public void setWorks(ActivityWorks works) {
		this.works = works;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public String getComUserName() {
		return comUserName;
	}

	public void setComUserName(String comUserName) {
		this.comUserName = comUserName;
	}

	public String getComIP() {
		return comIP;
	}

	public void setComIP(String comIP) {
		this.comIP = comIP;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	public Date getComDate() {
		return comDate;
	}



	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}



	public String getComDelFlag() {
		return comDelFlag;
	}

	public void setComDelFlag(String comDelFlag) {
		this.comDelFlag = comDelFlag;
	}

	public String getComIsaudit() {
		return comIsaudit;
	}

	public void setComIsaudit(String comIsaudit) {
		this.comIsaudit = comIsaudit;
	}

}
