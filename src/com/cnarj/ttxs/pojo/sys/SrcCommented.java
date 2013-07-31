package com.cnarj.ttxs.pojo.sys;

import java.util.Date;


/**
 * SrcCommented entity. @author MyEclipse Persistence Tools
 */

public class SrcCommented  implements java.io.Serializable {


    // Fields    

     private String commentedid;
     private String srcid;
     private String commcontent;
     private String username;
     private String ip;
     private String userid;
     private Date commenteddate;
     private String delflag;


    // Constructors

    /** default constructor */
    public SrcCommented() {
    }

    
    /** full constructor */
    public SrcCommented(String srcid, String commcontent, String username, String ip, String userid, Date commenteddate, String delflag) {
        this.srcid = srcid;
        this.commcontent = commcontent;
        this.username = username;
        this.ip = ip;
        this.userid = userid;
        this.commenteddate = commenteddate;
        this.delflag = delflag;
    }

   
    // Property accessors

    public String getCommentedid() {
        return this.commentedid;
    }
    
    public void setCommentedid(String commentedid) {
        this.commentedid = commentedid;
    }

    public String getSrcid() {
        return this.srcid;
    }
    
    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    public String getCommcontent() {
        return this.commcontent;
    }
    
    public void setCommcontent(String commcontent) {
        this.commcontent = commcontent;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
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
   








}