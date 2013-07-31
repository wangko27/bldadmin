package com.cnarj.ttxs.pojo.sys;

import java.util.Date;


/**
 * LogConfig entity. @author MyEclipse Persistence Tools
 */

public class LogConfig  implements java.io.Serializable {


    // Fields    

     private String logconfigid;
     private Date createdate;
     private Date modifydate;
     private String operationname;
     private String actionclassname;
     private String actionmethodname;
     private String logdescription;


    // Constructors

    /** default constructor */
    public LogConfig() {
    }

    
    /** full constructor */
    public LogConfig(Date createdate, Date modifydate, String operationname, String actionclassname, String actionmethodname, String logdescription) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.operationname = operationname;
        this.actionclassname = actionclassname;
        this.actionmethodname = actionmethodname;
        this.logdescription = logdescription;
    }

   
    // Property accessors

    public String getLogconfigid() {
        return this.logconfigid;
    }
    
    public void setLogconfigid(String logconfigid) {
        this.logconfigid = logconfigid;
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

    public String getLogdescription() {
        return this.logdescription;
    }
    
    public void setLogdescription(String logdescription) {
        this.logdescription = logdescription;
    }
   








}