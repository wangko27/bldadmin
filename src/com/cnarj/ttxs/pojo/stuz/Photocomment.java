package com.cnarj.ttxs.pojo.stuz;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * Photocomment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Photocomment implements java.io.Serializable {

	// Fields

	private String commentedid;
	private Member member;
	private Photos photos;
	private String commentedcontent;
	private String username;
	private String userip;
	private Date commenteddate;
	private String delflag;
	

	private Photocomment parent;

	// Constructors

	/** default constructor */
	public Photocomment() {
	}

	/** full constructor */
	public Photocomment(Member member, Photos photos,
			String commentedcontent, String username, String userip,
			Date commenteddate, String delflag, Photocomment parent) {
		this.member = member;
		this.photos = photos;
		this.commentedcontent = commentedcontent;
		this.username = username;
		this.userip = userip;
		this.commenteddate = commenteddate;
		this.delflag = delflag;
		this.parent = parent;
	}

	// Property accessors

	public String getCommentedid() {
		return this.commentedid;
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

	public Photos getPhotos() {
		return this.photos;
	}

	public void setPhotos(Photos photos) {
		this.photos = photos;
	}

	public String getCommentedcontent() {
		return this.commentedcontent;
	}

	public void setCommentedcontent(String commentedcontent) {
		this.commentedcontent = commentedcontent;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserip() {
		return this.userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public Date getCommenteddate() {
		return this.commenteddate;
	}

	public void setCommenteddate(Date commenteddate) {
		this.commenteddate = commenteddate;
	}

	public String getDelflag() {
		return this.delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public Photocomment getParent() {
		return parent;
	}

	public void setParent(Photocomment parent) {
		this.parent = parent;
	}


}