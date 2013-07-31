package com.cnarj.ttxs.pojo.sys;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.HashSet;
import java.util.Set;


/**
 * Src entity. @author MyEclipse Persistence Tools
 */

public class Src  implements java.io.Serializable {


    // Fields    

     private String srcid;
     private Member member;
     private String srcname;
     private String srcintro;
     private Long needpoint;
     private Long collectionnum;
     private Long sharenum;
     private Long downloadnum;
     private Double generalscore;
     private String uploadusername;
     private Set srcHandleRecs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Src() {
    }

    
    /** full constructor */
    public Src(Member member, String srcname, String srcintro, Long needpoint, Long collectionnum, Long sharenum, Long downloadnum, Double generalscore, String uploadusername, Set srcHandleRecs) {
        this.member = member;
        this.srcname = srcname;
        this.srcintro = srcintro;
        this.needpoint = needpoint;
        this.collectionnum = collectionnum;
        this.sharenum = sharenum;
        this.downloadnum = downloadnum;
        this.generalscore = generalscore;
        this.uploadusername = uploadusername;
        this.srcHandleRecs = srcHandleRecs;
    }

   
    // Property accessors

    public String getSrcid() {
        return this.srcid;
    }
    
    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public String getSrcname() {
        return this.srcname;
    }
    
    public void setSrcname(String srcname) {
        this.srcname = srcname;
    }

    public String getSrcintro() {
        return this.srcintro;
    }
    
    public void setSrcintro(String srcintro) {
        this.srcintro = srcintro;
    }

    public Long getNeedpoint() {
        return this.needpoint;
    }
    
    public void setNeedpoint(Long needpoint) {
        this.needpoint = needpoint;
    }

    public Long getCollectionnum() {
        return this.collectionnum;
    }
    
    public void setCollectionnum(Long collectionnum) {
        this.collectionnum = collectionnum;
    }

    public Long getSharenum() {
        return this.sharenum;
    }
    
    public void setSharenum(Long sharenum) {
        this.sharenum = sharenum;
    }

    public Long getDownloadnum() {
        return this.downloadnum;
    }
    
    public void setDownloadnum(Long downloadnum) {
        this.downloadnum = downloadnum;
    }

    public Double getGeneralscore() {
        return this.generalscore;
    }
    
    public void setGeneralscore(Double generalscore) {
        this.generalscore = generalscore;
    }

    public String getUploadusername() {
        return this.uploadusername;
    }
    
    public void setUploadusername(String uploadusername) {
        this.uploadusername = uploadusername;
    }

    public Set getSrcHandleRecs() {
        return this.srcHandleRecs;
    }
    
    public void setSrcHandleRecs(Set srcHandleRecs) {
        this.srcHandleRecs = srcHandleRecs;
    }
   








}