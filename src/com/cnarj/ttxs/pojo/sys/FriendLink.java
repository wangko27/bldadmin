package com.cnarj.ttxs.pojo.sys;

import java.util.Date;


/**
 * FriendLink entity. @author MyEclipse Persistence Tools
 */

public class FriendLink  implements java.io.Serializable {


    // Fields    

     private String friendlinkid;
     private Date createdate;
     private Date modifydate;
     private String friendlinkname;
     private String logo;
     private String friendlinkurl;
     private Long orderlist;


    // Constructors

    /** default constructor */
    public FriendLink() {
    }

    
    /** full constructor */
    public FriendLink(Date createdate, Date modifydate, String friendlinkname, String logo, String friendlinkurl, Long orderlist) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.friendlinkname = friendlinkname;
        this.logo = logo;
        this.friendlinkurl = friendlinkurl;
        this.orderlist = orderlist;
    }

   
    // Property accessors

    public String getFriendlinkid() {
        return this.friendlinkid;
    }
    
    public void setFriendlinkid(String friendlinkid) {
        this.friendlinkid = friendlinkid;
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

    public String getFriendlinkname() {
        return this.friendlinkname;
    }
    
    public void setFriendlinkname(String friendlinkname) {
        this.friendlinkname = friendlinkname;
    }

    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFriendlinkurl() {
        return this.friendlinkurl;
    }
    
    public void setFriendlinkurl(String friendlinkurl) {
        this.friendlinkurl = friendlinkurl;
    }

    public Long getOrderlist() {
        return this.orderlist;
    }
    
    public void setOrderlist(Long orderlist) {
        this.orderlist = orderlist;
    }
   








}