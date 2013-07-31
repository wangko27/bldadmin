package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Attribute entity. @author MyEclipse Persistence Tools
 */

public class Attribute  implements java.io.Serializable {


    // Fields    

     private String attributeid;
     private GoodesType goodesType;
     private Date createdate;
     private Date modifydate;
     private String attributename;
     private Long attributetype;
     private String isrequired;
     private String isenabled;
     private Long orderlist;
     private String attributeoptionstore;
     private Set goodsAttrs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Attribute() {
    }

    
    /** full constructor */
    public Attribute(GoodesType goodesType, Date createdate, Date modifydate, String attributename, Long attributetype, String isrequired, String isenabled, Long orderlist, String attributeoptionstore, Set goodsAttrs) {
        this.goodesType = goodesType;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.attributename = attributename;
        this.attributetype = attributetype;
        this.isrequired = isrequired;
        this.isenabled = isenabled;
        this.orderlist = orderlist;
        this.attributeoptionstore = attributeoptionstore;
        this.goodsAttrs = goodsAttrs;
    }

   
    // Property accessors

    public String getAttributeid() {
        return this.attributeid;
    }
    
    public void setAttributeid(String attributeid) {
        this.attributeid = attributeid;
    }

    public GoodesType getGoodesType() {
        return this.goodesType;
    }
    
    public void setGoodesType(GoodesType goodesType) {
        this.goodesType = goodesType;
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

    public String getAttributename() {
        return this.attributename;
    }
    
    public void setAttributename(String attributename) {
        this.attributename = attributename;
    }

    public Long getAttributetype() {
        return this.attributetype;
    }
    
    public void setAttributetype(Long attributetype) {
        this.attributetype = attributetype;
    }

    public String getIsrequired() {
        return this.isrequired;
    }
    
    public void setIsrequired(String isrequired) {
        this.isrequired = isrequired;
    }

    public String getIsenabled() {
        return this.isenabled;
    }
    
    public void setIsenabled(String isenabled) {
        this.isenabled = isenabled;
    }

    public Long getOrderlist() {
        return this.orderlist;
    }
    
    public void setOrderlist(Long orderlist) {
        this.orderlist = orderlist;
    }

    public String getAttributeoptionstore() {
        return this.attributeoptionstore;
    }
    
    public void setAttributeoptionstore(String attributeoptionstore) {
        this.attributeoptionstore = attributeoptionstore;
    }

    public Set getGoodsAttrs() {
        return this.goodsAttrs;
    }
    
    public void setGoodsAttrs(Set goodsAttrs) {
        this.goodsAttrs = goodsAttrs;
    }
   








}