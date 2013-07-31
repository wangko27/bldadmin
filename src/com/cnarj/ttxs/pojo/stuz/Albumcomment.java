package com.cnarj.ttxs.pojo.stuz;

import com.cnarj.ttxs.pojo.stuz.albums;
import com.cnarj.ttxs.pojo.user.Member;

import java.util.Date;

/**
 * Albumcomment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Albumcomment implements java.io.Serializable {

	// Fields

	private String commentedid;
	private Member member;
	private albums albums;
	private String commentedcontent;
	private String username;
	private String userip;
	private Date commenteddate;
	private String delflag;
	
//	private String parentcommentedid;
	private Albumcomment parent;

	// Constructors

	/** default constructor */
	public Albumcomment() {
	}

	/** full constructor */
	public Albumcomment(Member member, albums albums,
			String commentedcontent, String username, String userip,
			Date commenteddate, String delflag, Albumcomment parent) {
		this.member = member;
		this.albums = albums;
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

	public albums getAlbums() {
		return this.albums;
	}

	public void setAlbums(albums albums) {
		this.albums = albums;
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

	public Albumcomment getParent() {
		return parent;
	}

	public void setParent(Albumcomment parent) {
		this.parent = parent;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}