package com.cnarj.ttxs.pojo.sys;

import java.util.Date;


/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log  implements java.io.Serializable {


    // Fields    

     private String logid;
     private Date createdate;
     private Date modifydate;
     private String operationname;
     private String logoperator;
     private String actionclassname;
     private String actionmethodname;
     private String ip;
     private String loginfo;


    // Constructors

    /** default constructor */
    public Log() {
    }

    
    /** full constructor */
    public Log(Date createdate, Date modifydate, String operationname, String logoperator, String actionclassname, String actionmethodname, String ip, String loginfo) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.operationname = operationname;
        this.logoperator = logoperator;
        this.actionclassname = actionclassname;
        this.actionmethodname = actionmethodname;
        this.ip = ip;
        this.loginfo = loginfo;
    }

   
    // Property accessors

    public String getLogid() {
        return this.logid;
    }
    
    public void setLogid(String logid) {
        this.logid = logid;
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

    public String getOperationname() {
        return this.operationname;
    }
    
    public void setOperationname(String operationname) {
        this.operationname = operationname;
    }

    public String getLogoperator() {
        return this.logoperator;
    }
    
    public void setLogoperator(String logoperator) {
        this.logoperator = logoperator;
    }

    public String getActionclassname() {
        return this.actionclassname;
    }
    
    public void setActionclassname(String actionclassname) {
        this.actionclassname = actionclassname;
    }

    public String getActionmethodname() {
        return this.actionmethodname;
    }
    
    public void setActionmethodname(String actionmethodname) {
        this.actionmethodname = actionmethodname;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoginfo() {
        return this.loginfo;
    }
    
    public void setLoginfo(String loginfo) {
        this.loginfo = loginfo;
    }
   








}