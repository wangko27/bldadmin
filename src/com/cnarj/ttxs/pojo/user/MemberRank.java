package com.cnarj.ttxs.pojo.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * MemberRank entity. @author MyEclipse Persistence Tools
 */

public class MemberRank  implements java.io.Serializable {


    // Fields    

     private String memberrankid;
     private Date createdate;
     private Date modifydate;
     private String rankname;
     private Long preferentialscale;
     private Long rankpoint;
     private String isdefault;
     private Set members = new HashSet(0);


    // Constructors

    /** default constructor */
    public MemberRank() {
    }

    
    /** full constructor */
    public MemberRank(Date createdate, Date modifydate, String rankname, Long preferentialscale, Long rankpoint, String isdefault, Set members) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.rankname = rankname;
        this.preferentialscale = preferentialscale;
        this.rankpoint = rankpoint;
        this.isdefault = isdefault;
        this.members = members;
    }

   
    // Property accessors

    public String getMemberrankid() {
        return this.memberrankid;
    }
    
    public void setMemberrankid(String memberrankid) {
        this.memberrankid = memberrankid;
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

    public String getRankname() {
        return this.rankname;
    }
    
    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public Long getPreferentialscale() {
        return this.preferentialscale;
    }
    
    public void setPreferentialscale(Long preferentialscale) {
        this.preferentialscale = preferentialscale;
    }

    public Long getRankpoint() {
        return this.rankpoint;
    }
    
    public void setRankpoint(Long rankpoint) {
        this.rankpoint = rankpoint;
    }

    public String getIsdefault() {
        return this.isdefault;
    }
    
    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    public Set getMembers() {
        return this.members;
    }
    
    public void setMembers(Set members) {
        this.members = members;
    }
   








}