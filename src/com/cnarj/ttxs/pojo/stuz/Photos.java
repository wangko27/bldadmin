package com.cnarj.ttxs.pojo.stuz;

import com.cnarj.ttxs.pojo.stuz.albums;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Photos entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Photos implements java.io.Serializable {

	// Fields

	private String photoid;
	private albums albums;
	private String photoname;
	private String photopath;
	private Date createdate;
	private Date modifydate;
	private Set photocomments = new HashSet(0);
	private Long orderList;

	private Long readnum;
	private Long commentnum;
	// Constructors

	/** default constructor */
	public Photos() {
	}

	/** full constructor */
	public Photos(albums albums, String photoname, String photopath,Long readnum, Long commentnum,
			Date createdate, Date modifydate, Set photocomments,Long orderList) {
		this.albums = albums;
		this.photoname = photoname;
		this.photopath = photopath;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.photocomments = photocomments;
		this.orderList = orderList;

		this.readnum = readnum;
		this.commentnum = commentnum;
	}

	// Property accessors

	public String getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}

	public albums getAlbums() {
		return this.albums;
	}

	public void setAlbums(albums albums) {
		this.albums = albums;
	}

	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getPhotopath() {
		return this.photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
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

	public Set getPhotocomments() {
		return this.photocomments;
	}

	public void setPhotocomments(Set photocomments) {
		this.photocomments = photocomments;
	}

	public Long getOrderList() {
		return orderList;
	}

	public void setOrderList(Long orderList) {
		this.orderList = orderList;
	}

	public Long getReadnum() {
		return readnum;
	}

	public void setReadnum(Long readnum) {
		this.readnum = readnum;
	}

	public Long getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(Long commentnum) {
		this.commentnum = commentnum;
	}

}