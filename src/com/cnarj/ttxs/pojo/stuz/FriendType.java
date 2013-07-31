package com.cnarj.ttxs.pojo.stuz;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;


/**
 * FriendType entity. @author MyEclipse Persistence Tools
 */

public class FriendType  implements java.io.Serializable {


    // Fields    

     private String friendtypeid;
     private String friendtypename;
     private Date createdate;
     private Date modifydate;

     private Member member;
     private Long friendnum;
     private String isdefault;


    // Constructors

    /** default constructor */
    public FriendType() {
    }

    
    /** full constructor */
    public FriendType(String friendtypename, Date createdate, Date modifydate,Member member
    		,Long friendnum,String isdefault) {
        this.friendtypename = friendtypename;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.member = member;
        this.friendnum = friendnum;
        this.isdefault = isdefault;
    }

   
    // Property accessors

    public String getFriendtypeid() {
        return this.friendtypeid;
    }
    
    public void setFriendtypeid(String friendtypeid) {
        this.friendtypeid = friendtypeid;
    }

    public String getFriendtypename() {
        return this.friendtypename;
    }
    
    public void setFriendtypename(String friendtypename) {
        this.friendtypename = friendtypename;
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


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Long getFriendnum() {
		return friendnum;
	}


	public void setFriendnum(Long friendnum) {
		this.friendnum = friendnum;
	}


	public String getIsdefault() {
		return isdefault;
	}


	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}









}