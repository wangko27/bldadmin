package com.cnarj.ttxs.pojo.learn;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * ReadSrcType entity. @author MyEclipse Persistence Tools
 */

public class ReadSrcType  implements java.io.Serializable {


    // Fields    

     private String srctypeid;
     private ReadSrcType readSrcType;
     private String srctype;
     private Date createdate;
     private Date modifydate;
     private Set readSrcTypes = new HashSet(0);
     private Set readSrcs = new HashSet(0);


    // Constructors

    /** default constructor */
    public ReadSrcType() {
    }

    
    /** full constructor */
    public ReadSrcType(ReadSrcType readSrcType, String srctype, Date createdate, Date modifydate, Set readSrcTypes, Set readSrcs) {
        this.readSrcType = readSrcType;
        this.srctype = srctype;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.readSrcTypes = readSrcTypes;
        this.readSrcs = readSrcs;
    }

   
    // Property accessors

    public String getSrctypeid() {
        return this.srctypeid;
    }
    
    public void setSrctypeid(String srctypeid) {
        this.srctypeid = srctypeid;
    }

    public ReadSrcType getReadSrcType() {
        return this.readSrcType;
    }
    
    public void setReadSrcType(ReadSrcType readSrcType) {
        this.readSrcType = readSrcType;
    }

    public String getSrctype() {
        return this.srctype;
    }
    
    public void setSrctype(String srctype) {
        this.srctype = srctype;
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

    public Set getReadSrcTypes() {
        return this.readSrcTypes;
    }
    
    public void setReadSrcTypes(Set readSrcTypes) {
        this.readSrcTypes = readSrcTypes;
    }

    public Set getReadSrcs() {
        return this.readSrcs;
    }
    
    public void setReadSrcs(Set readSrcs) {
        this.readSrcs = readSrcs;
    }
   








}