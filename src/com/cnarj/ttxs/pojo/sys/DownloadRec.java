package com.cnarj.ttxs.pojo.sys;

import java.util.Date;


/**
 * DownloadRec entity. @author MyEclipse Persistence Tools
 */

public class DownloadRec  implements java.io.Serializable {


    // Fields    

     private String downrecid;
     private String userid;
     private String srcid;
     private Long downrecpoint;
     private Date downloaddate;
     private String iscommented;
     private String israting;


    // Constructors

    /** default constructor */
    public DownloadRec() {
    }

    
    /** full constructor */
    public DownloadRec(String userid, String srcid, Long downrecpoint, Date downloaddate, String iscommented, String israting) {
        this.userid = userid;
        this.srcid = srcid;
        this.downrecpoint = downrecpoint;
        this.downloaddate = downloaddate;
        this.iscommented = iscommented;
        this.israting = israting;
    }

   
    // Property accessors

    public String getDownrecid() {
        return this.downrecid;
    }
    
    public void setDownrecid(String downrecid) {
        this.downrecid = downrecid;
    }

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSrcid() {
        return this.srcid;
    }
    
    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    public Long getDownrecpoint() {
        return this.downrecpoint;
    }
    
    public void setDownrecpoint(Long downrecpoint) {
        this.downrecpoint = downrecpoint;
    }

    public Date getDownloaddate() {
        return this.downloaddate;
    }
    
    public void setDownloaddate(Date downloaddate) {
        this.downloaddate = downloaddate;
    }

    public String getIscommented() {
        return this.iscommented;
    }
    
    public void setIscommented(String iscommented) {
        this.iscommented = iscommented;
    }

    public String getIsrating() {
        return this.israting;
    }
    
    public void setIsrating(String israting) {
        this.israting = israting;
    }
   








}