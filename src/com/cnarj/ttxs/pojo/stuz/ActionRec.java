package com.cnarj.ttxs.pojo.stuz;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * ActionRec entity. @author MyEclipse Persistence Tools
 */

public class ActionRec  implements java.io.Serializable {


     private String actionrecid;
     /**
      * 1.上传相片到相册
		2.发表博文
		3.发表心情
      */
     private Long actiontype;
     private String actiontitle;
     private String actionpath1;
     private String username;
     private Date actiondate;
     private String actionpath2;

     private Member member;
     private albums album;
     private Photos photo;
     private Blog blog;
     private moods mood;
     
     private String otheractionpath1;
     private String otheractionpath2;




	/** default constructor */
    public ActionRec() {
    }

    
    /** full constructor */

	public ActionRec(Long actiontype, String actiontitle, String actionpath1,
			String username, Date actiondate, String actionpath2,
			Member member, albums album, Photos photo, Blog blog, moods mood,
			String otheractionpath1,String otheractionpath2) {
		super();
		this.actiontype = actiontype;
		this.actiontitle = actiontitle;
		this.actionpath1 = actionpath1;
		this.username = username;
		this.actiondate = actiondate;
		this.actionpath2 = actionpath2;
		this.member = member;
		this.album = album;
		this.photo = photo;
		this.blog = blog;
		this.mood = mood;
		this.otheractionpath1 = otheractionpath1;
		this.otheractionpath2 = otheractionpath2;
	}

   
    // Property accessors

    public String getActionrecid() {
        return this.actionrecid;
    }
    
    public void setActionrecid(String actionrecid) {
        this.actionrecid = actionrecid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public Long getActiontype() {
        return this.actiontype;
    }
    
    public void setActiontype(Long actiontype) {
        this.actiontype = actiontype;
    }

    public String getActiontitle() {
        return this.actiontitle;
    }
    
    public void setActiontitle(String actiontitle) {
        this.actiontitle = actiontitle;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public Date getActiondate() {
        return this.actiondate;
    }
    
    public void setActiondate(Date actiondate) {
        this.actiondate = actiondate;
    }


	public String getActionpath1() {
		return actionpath1;
	}


	public void setActionpath1(String actionpath1) {
		this.actionpath1 = actionpath1;
	}


	public String getActionpath2() {
		return actionpath2;
	}


	public void setActionpath2(String actionpath2) {
		this.actionpath2 = actionpath2;
	}


	public albums getAlbum() {
		return album;
	}


	public void setAlbum(albums album) {
		this.album = album;
	}


	public Photos getPhoto() {
		return photo;
	}


	public void setPhoto(Photos photo) {
		this.photo = photo;
	}


	public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}


	public moods getMood() {
		return mood;
	}


	public void setMood(moods mood) {
		this.mood = mood;
	}


	public String getOtheractionpath1() {
		return otheractionpath1;
	}


	public void setOtheractionpath1(String otheractionpath1) {
		this.otheractionpath1 = otheractionpath1;
	}


	public String getOtheractionpath2() {
		return otheractionpath2;
	}


	public void setOtheractionpath2(String otheractionpath2) {
		this.otheractionpath2 = otheractionpath2;
	}
   








}