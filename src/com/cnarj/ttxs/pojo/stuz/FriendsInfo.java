package com.cnarj.ttxs.pojo.stuz;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * FriendsInfo entity. @author MyEclipse Persistence Tools
 */

public class FriendsInfo  implements java.io.Serializable {


    // Fields    

     private String friendsinfoid;
     private Member memberByUserid;
     private Member memberByFrienduserid;

     private String friendusername;
     private Date createdate;
     private Date modifydate;
     
     private FriendType friendtype;


    // Constructors

    /** default constructor */
    public FriendsInfo() {
    }

    
    /** full constructor */
    public FriendsInfo(Member memberByUserid, Member memberByFrienduserid, FriendType friendtype, String friendusername, Date createdate, Date modifydate) {
        this.memberByUserid = memberByUserid;
        this.memberByFrienduserid = memberByFrienduserid;
        this.friendtype = friendtype;
        this.friendusername = friendusername;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

   
    // Property accessors

    public String getFriendsinfoid() {
        return this.friendsinfoid;
    }
    
    public void setFriendsinfoid(String friendsinfoid) {
        this.friendsinfoid = friendsinfoid;
    }

    public Member getMemberByUserid() {
        return this.memberByUserid;
    }
    
    public void setMemberByUserid(Member memberByUserid) {
        this.memberByUserid = memberByUserid;
    }

    public Member getMemberByFrienduserid() {
        return this.memberByFrienduserid;
    }
    
    public void setMemberByFrienduserid(Member memberByFrienduserid) {
        this.memberByFrienduserid = memberByFrienduserid;
    }

    public FriendType getFriendtype() {
		return friendtype;
	}


	public void setFriendtype(FriendType friendtype) {
		this.friendtype = friendtype;
	}


	public String getFriendusername() {
        return this.friendusername;
    }
    
    public void setFriendusername(String friendusername) {
        this.friendusername = friendusername;
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
   








}