package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * GoodesType entity. @author MyEclipse Persistence Tools
 */

public class GoodesType  implements java.io.Serializable {


    // Fields    

     private String goodestypeid;
     private Date createdate;
     private Date modifydate;
     private String goodestypename;
     private Set goodses = new HashSet(0);
     private Set attributes = new HashSet(0);


    // Constructors

    /** default constructor */
    public GoodesType() {
    }

    
    /** full constructor */
    public GoodesType(Date createdate, Date modifydate, String goodestypename, Set goodses, Set attributes) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.goodestypename = goodestypename;
        this.goodses = goodses;
        this.attributes = attributes;
    }

   
    // Property accessors

    public String getGoodestypeid() {
        return this.goodestypeid;
    }
    
    public void setGoodestypeid(String goodestypeid) {
        this.goodestypeid = goodestypeid;
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

    public String getGoodestypename() {
        return this.goodestypename;
    }
    
    public void setGoodestypename(String goodestypename) {
        this.goodestypename = goodestypename;
    }

    public Set getGoodses() {
        return this.goodses;
    }
    
    public void setGoodses(Set goodses) {
        this.goodses = goodses;
    }

    public Set getAttributes() {
        return this.attributes;
    }
    
    public void setAttributes(Set attributes) {
        this.attributes = attributes;
    }
   








}