package com.cnarj.ttxs.pojo.user;

import java.util.Date;


/**
 * MemberPoint entity. @author MyEclipse Persistence Tools
 */

public class MemberPoint  implements java.io.Serializable {


    // Fields    

     private String memberpointid;
     private Member member;
     private Long memberpoint;
     private Long pointtype;
     private Date createdate;
     private Date modifydate;
     private String ispointlocked;
     private Date lockeddate;


    // Constructors

    /** default constructor */
    public MemberPoint() {
    }

    
    /** full constructor */
    public MemberPoint(Member member, Long memberpoint, Long pointtype, Date createdate, Date modifydate, String ispointlocked, Date lockeddate) {
        this.member = member;
        this.memberpoint = memberpoint;
        this.pointtype = pointtype;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.ispointlocked = ispointlocked;
        this.lockeddate = lockeddate;
    }

   
    // Property accessors

    public String getMemberpointid() {
        return this.memberpointid;
    }
    
    public void setMemberpointid(String memberpointid) {
        this.memberpointid = memberpointid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public Long getMemberpoint() {
        return this.memberpoint;
    }
    
    public void setMemberpoint(Long memberpoint) {
        this.memberpoint = memberpoint;
    }

    public Long getPointtype() {
        return this.pointtype;
    }
    
    public void setPointtype(Long pointtype) {
        this.pointtype = pointtype;
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

    public String getIspointlocked() {
        return this.ispointlocked;
    }
    
    public void setIspointlocked(String ispointlocked) {
        this.ispointlocked = ispointlocked;
    }

    public Date getLockeddate() {
        return this.lockeddate;
    }
    
    public void setLockeddate(Date lockeddate) {
        this.lockeddate = lockeddate;
    }
   








}