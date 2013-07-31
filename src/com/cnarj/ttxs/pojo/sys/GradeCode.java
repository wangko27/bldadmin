package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * GradeCode entity. @author MyEclipse Persistence Tools
 */

public class GradeCode  implements java.io.Serializable {


    // Fields    

     private String gradecode;
     private String gradename;
     private String gradeintro;
     private Date createdate;
     private Date modifydate;
     private Set readSrcs = new HashSet(0);
     private Set articleSrcs = new HashSet(0);


    // Constructors

    /** default constructor */
    public GradeCode() {
    }

	/** minimal constructor */
    public GradeCode(String gradename) {
        this.gradename = gradename;
    }
    
    /** full constructor */
    public GradeCode(String gradename, String gradeintro, Date createdate, Date modifydate, Set readSrcs, Set articleSrcs) {
        this.gradename = gradename;
        this.gradeintro = gradeintro;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.readSrcs = readSrcs;
        this.articleSrcs = articleSrcs;
    }

   
    // Property accessors

    public String getGradecode() {
        return this.gradecode;
    }
    
    public void setGradecode(String gradecode) {
        this.gradecode = gradecode;
    }

    public String getGradename() {
        return this.gradename;
    }
    
    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public String getGradeintro() {
        return this.gradeintro;
    }
    
    public void setGradeintro(String gradeintro) {
        this.gradeintro = gradeintro;
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

    public Set getReadSrcs() {
        return this.readSrcs;
    }
    
    public void setReadSrcs(Set readSrcs) {
        this.readSrcs = readSrcs;
    }

    public Set getArticleSrcs() {
        return this.articleSrcs;
    }
    
    public void setArticleSrcs(Set articleSrcs) {
        this.articleSrcs = articleSrcs;
    }
   








}