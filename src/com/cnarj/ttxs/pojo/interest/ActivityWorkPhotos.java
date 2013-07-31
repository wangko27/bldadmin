package com.cnarj.ttxs.pojo.interest;

import java.util.Date;

public class ActivityWorkPhotos {
	
	   
	   private String photoid;
	   private String photopath;
	   private String photoname;

	   private Date createdate;// 创建时间
	   private Date modifydate;// 修改时间
	   
	   private ActivityWorks work;

	public ActivityWorkPhotos() {
		super();
	}

	public ActivityWorkPhotos(String photoid, String photopath,
			String photoname, Date createdate, Date modifydate,
			ActivityWorks work) {
		super();
		this.photoid = photoid;
		this.photopath = photopath;
		this.photoname = photoname;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.work = work;
	}


	public String getPhotoid() {
		return photoid;
	}
	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public ActivityWorks getWork() {
		return work;
	}

	public void setWork(ActivityWorks work) {
		this.work = work;
	}
	   
	
}
