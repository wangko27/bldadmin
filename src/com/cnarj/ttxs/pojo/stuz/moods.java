package com.cnarj.ttxs.pojo.stuz;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;


/**
 * moods entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class moods  implements java.io.Serializable {


    // Fields

     private String moodid;
     private String moodtext;
     private Date createdate;
     private Date modifydate;
     private String pathmoodid;
     
     private Member member;
	


    // Constructors
     public moods() {
 	}



	public moods(String moodtext, Date createdate,
			Date modifydate, String pathmoodid,Member member) {
		super();
		this.moodtext = moodtext;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.pathmoodid = pathmoodid;
		this.member = member;
	}



	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	public String getMoodid() {
		return moodid;
	}



	public void setMoodid(String moodid) {
		this.moodid = moodid;
	}




	public String getMoodtext() {
		return moodtext;
	}



	public void setMoodtext(String moodtext) {
		this.moodtext = moodtext;
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



	public String getPathmoodid() {
		return pathmoodid;
	}



	public void setPathmoodid(String pathmoodid) {
		this.pathmoodid = pathmoodid;
	}




}