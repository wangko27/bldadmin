package com.cnarj.ttxs.pojo.sys;

import java.util.Date;


/**
 * LocContent entity. @author MyEclipse Persistence Tools
 */

public class LocContent  implements java.io.Serializable {


    // Fields    

     private String relatid;
     private LocationInfo locationInfo;
     private WebContent webContent;
     private Date createdate;
     private Date modifydate;


    // Constructors

    /** default constructor */
    public LocContent() {
    }

    
    /** full constructor */
    public LocContent(LocationInfo locationInfo, WebContent webContent, Date createdate, Date modifydate) {
        this.locationInfo = locationInfo;
        this.webContent = webContent;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

   
    // Property accessors

    public String getRelatid() {
        return this.relatid;
    }
    
    public void setRelatid(String relatid) {
        this.relatid = relatid;
    }

    public LocationInfo getLocationInfo() {
        return this.locationInfo;
    }
    
    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public WebContent getWebContent() {
        return this.webContent;
    }
    
    public void setWebContent(WebContent webContent) {
        this.webContent = webContent;
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