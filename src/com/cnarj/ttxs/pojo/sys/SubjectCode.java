package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * SubjectCode entity. @author MyEclipse Persistence Tools
 */

public class SubjectCode  implements java.io.Serializable {


    // Fields    

     private String subjectcode;
     private String subjectname;
     private String subjectintro;
     private Date createdate;
     private Date modifydate;
     private String subjectpath;
     private Set articleSrcs = new HashSet(0);
     private Set readSrcs = new HashSet(0);


    // Constructors

    /** default constructor */
    public SubjectCode() {
    }

	/** minimal constructor */
    public SubjectCode(String subjectname) {
        this.subjectname = subjectname;
    }
    
    /** full constructor */
    public SubjectCode(String subjectname,String subjectpath, String subjectintro, Date createdate, Date modifydate, Set articleSrcs, Set readSrcs) {
        this.subjectname = subjectname;
        this.subjectintro = subjectintro;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.articleSrcs = articleSrcs;
        this.readSrcs = readSrcs;
        this.subjectpath =  subjectpath;
    }

   
    // Property accessors

    public String getSubjectcode() {
        return this.subjectcode;
    }
    
    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectname() {
        return this.subjectname;
    }
    
    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectintro() {
        return this.subjectintro;
    }
    
    public void setSubjectintro(String subjectintro) {
        this.subjectintro = subjectintro;
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

    public Set getArticleSrcs() {
        return this.articleSrcs;
    }
    
    public void setArticleSrcs(Set articleSrcs) {
        this.articleSrcs = articleSrcs;
    }

    public Set getReadSrcs() {
        return this.readSrcs;
    }
    
    public void setReadSrcs(Set readSrcs) {
        this.readSrcs = readSrcs;
    }

	public String getSubjectpath() {
		return subjectpath;
	}

	public void setSubjectpath(String subjectpath) {
		this.subjectpath = subjectpath;
	}
   








}