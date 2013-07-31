package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * WebContent entity. @author MyEclipse Persistence Tools
 */

public class WebContent  implements java.io.Serializable {


    // Fields    

     private String contentid;
     private String contentname;
     private Date createdate;
     private Date modifydate;
     private String contentintro;
     private String contenturl;
     private Set locContents = new HashSet(0);


    // Constructors

    /** default constructor */
    public WebContent() {
    }

    
    /** full constructor */
    public WebContent(String contentname, Date createdate, Date modifydate, String contentintro, String contenturl, Set locContents) {
        this.contentname = contentname;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.contentintro = contentintro;
        this.contenturl = contenturl;
        this.locContents = locContents;
    }

   
    // Property accessors

    public String getContentid() {
        return this.contentid;
    }
    
    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getContentname() {
        return this.contentname;
    }
    
    public void setContentname(String contentname) {
        this.contentname = contentname;
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

    public String getContentintro() {
        return this.contentintro;
    }
    
    public void setContentintro(String contentintro) {
        this.contentintro = contentintro;
    }

    public String getContenturl() {
        return this.contenturl;
    }
    
    public void setContenturl(String contenturl) {
        this.contenturl = contenturl;
    }

    public Set getLocContents() {
        return this.locContents;
    }
    
    public void setLocContents(Set locContents) {
        this.locContents = locContents;
    }
   








}