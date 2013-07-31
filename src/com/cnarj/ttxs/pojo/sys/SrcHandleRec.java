package com.cnarj.ttxs.pojo.sys;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * SrcHandleRec entity. @author MyEclipse Persistence Tools
 */

public class SrcHandleRec  implements java.io.Serializable {


    // Fields    

     private String recid;
     private Src src;
     private Member member;
     private String userid;
     private Long actiontype;
     private Date actiondate;


    // Constructors

    /** default constructor */
    public SrcHandleRec() {
    }

    
    /** full constructor */
    public SrcHandleRec(Src src, Member member, String userid, Long actiontype, Date actiondate) {
        this.src = src;
        this.member = member;
        this.userid = userid;
        this.actiontype = actiontype;
        this.actiondate = actiondate;
    }

   
    // Property accessors

    public String getRecid() {
        return this.recid;
    }
    
    public void setRecid(String recid) {
        this.recid = recid;
    }

    public Src getSrc() {
        return this.src;
    }
    
    public void setSrc(Src src) {
        this.src = src;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Long getActiontype() {
        return this.actiontype;
    }
    
    public void setActiontype(Long actiontype) {
        this.actiontype = actiontype;
    }

    public Date getActiondate() {
        return this.actiondate;
    }
    
    public void setActiondate(Date actiondate) {
        this.actiondate = actiondate;
    }
   








}