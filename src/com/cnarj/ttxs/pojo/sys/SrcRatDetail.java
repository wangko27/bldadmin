package com.cnarj.ttxs.pojo.sys;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * SrcRatDetail entity. @author MyEclipse Persistence Tools
 */

public class SrcRatDetail  implements java.io.Serializable {


    // Fields    

     private String ratdetailid;
     private Member member;
     private String userid;
     private String username;
     private Long scoring;
     private String ip;
     private Date ratdate;
     private String srcid;


    // Constructors

    /** default constructor */
    public SrcRatDetail() {
    }

    
    /** full constructor */
    public SrcRatDetail(Member member, String userid, String username, Long scoring, String ip, Date ratdate, String srcid) {
        this.member = member;
        this.userid = userid;
        this.username = username;
        this.scoring = scoring;
        this.ip = ip;
        this.ratdate = ratdate;
        this.srcid = srcid;
    }

   
    // Property accessors

    public String getRatdetailid() {
        return this.ratdetailid;
    }
    
    public void setRatdetailid(String ratdetailid) {
        this.ratdetailid = ratdetailid;
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

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public Long getScoring() {
        return this.scoring;
    }
    
    public void setScoring(Long scoring) {
        this.scoring = scoring;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getRatdate() {
        return this.ratdate;
    }
    
    public void setRatdate(Date ratdate) {
        this.ratdate = ratdate;
    }

    public String getSrcid() {
        return this.srcid;
    }
    
    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }
   








}