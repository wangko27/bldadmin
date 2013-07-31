package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * LocationInfo entity. @author MyEclipse Persistence Tools
 */

public class LocationInfo  implements java.io.Serializable {


    // Fields    

     private String locationid;
     private String locationname; //位置代码
     private String parentlocationid;
     private Date createdate;
     private Date modifydate;
     private String locationintro; //位置名称
     private Set advInfos = new HashSet(0);
     private String locationSize; //广告位置尺寸
     private Integer num;//可放广告数量 默认为1
//     private Set locContents = new HashSet(0);
    // Constructors

    /** default constructor */
    public LocationInfo() {
    }


    public LocationInfo(String locationid, String locationname, String parentlocationid, Date createdate,
                        Date modifydate, String locationintro, Set advInfos, String locationSize, Integer num) {
        this.locationid = locationid;
        this.locationname = locationname;
        this.parentlocationid = parentlocationid;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.locationintro = locationintro;
        this.advInfos = advInfos;
        this.locationSize = locationSize;
        this.num = num;
    }

    /** full constructor */


   
    // Property accessors


    public String getLocationSize() {
        return locationSize;
    }public void setLocationSize(String locationSize) {
        this.locationSize = locationSize;
    }public Integer getNum() {
        return num;
    }public void setNum(Integer num) {
        this.num = num;
    }public String getLocationid() {
        return this.locationid;
    }
    
    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getLocationname() {
        return this.locationname;
    }
    
    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getParentlocationid() {
        return this.parentlocationid;
    }
    
    public void setParentlocationid(String parentlocationid) {
        this.parentlocationid = parentlocationid;
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

    public String getLocationintro() {
        return this.locationintro;
    }
    
    public void setLocationintro(String locationintro) {
        this.locationintro = locationintro;
    }

    public Set getAdvInfos() {
        return this.advInfos;
    }
    
    public void setAdvInfos(Set advInfos) {
        this.advInfos = advInfos;
    }

//    public Set getLocContents() {
//        return this.locContents;
//    }
//
//    public void setLocContents(Set locContents) {
//        this.locContents = locContents;
//    }
//








}