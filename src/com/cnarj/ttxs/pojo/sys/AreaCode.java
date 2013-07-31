package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * AreaCode entity. @author MyEclipse Persistence Tools
 */

public class AreaCode  implements java.io.Serializable {


    // Fields    

     private String areaid;
     private AreaCode areaCode;
     private String areaname;
     private String areapath;
     private Date createdate;
     private Date modifydate;
     private Set areaCodes = new HashSet(0);


    // Constructors

    /** default constructor */
    public AreaCode() {
    }

    
    /** full constructor */
    public AreaCode(AreaCode areaCode, String areaname, String areapath, Date createdate, Date modifydate, Set areaCodes) {
        this.areaCode = areaCode;
        this.areaname = areaname;
        this.areapath = areapath;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.areaCodes = areaCodes;
    }

   
    // Property accessors

    public String getAreaid() {
        return this.areaid;
    }
    
    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public AreaCode getAreaCode() {
        return this.areaCode;
    }
    
    public void setAreaCode(AreaCode areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaname() {
        return this.areaname;
    }
    
    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAreapath() {
        return this.areapath;
    }
    
    public void setAreapath(String areapath) {
        this.areapath = areapath;
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

    public Set getAreaCodes() {
        return this.areaCodes;
    }
    
    public void setAreaCodes(Set areaCodes) {
        this.areaCodes = areaCodes;
    }
   








}