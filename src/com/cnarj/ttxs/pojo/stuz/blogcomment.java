package com.cnarj.ttxs.pojo.stuz;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * blogcomment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class blogcomment implements java.io.Serializable {

	// Fields

	private String commentedid;
	private Member member;
	private Blog blog;
	private String commentedcontent;
	private String username;
	private String userip;
	private Date commenteddate;
	private String delflag;
	
	private blogcomment parent;
	private Set children = new HashSet(0);

	// Constructors

	/** default constructor */
	public blogcomment() {
	}

	/** full constructor */
	public blogcomment(Member member, Blog blog, String commentedcontent,
			String username, String userip, Date commenteddate,
			String delflag,blogcomment parent,Set children ) {
		super();
		this.member = member;
		this.blog = blog;
		this.commentedcontent = commentedcontent;
		this.username = username;
		this.userip = userip;
		this.commenteddate = commenteddate;
		this.delflag = delflag;
		this.parent = parent;
		this.children = children;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	public blogcomment getParent() {
		return parent;
	}

	public void setParent(blogcomment parent) {
		this.parent = parent;
	}

	public String getCommentedid() {
		return commentedid;
	}

	public void setCommentedid(String commentedid) {
		this.commentedid = commentedid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getCommentedcontent() {
		return commentedcontent;
	}

	public void setCommentedcontent(String commentedcontent) {
		this.commentedcontent = commentedcontent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public Date getCommenteddate() {
		return commenteddate;
	}

	public void setCommenteddate(Date commenteddate) {
		this.commenteddate = commenteddate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	
}