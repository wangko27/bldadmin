package com.cnarj.ttxs.pojo.user;

import java.util.Date;


/**
 * MemberAttribute entity. @author MyEclipse Persistence Tools
 */

public class MemberAttribute  implements java.io.Serializable {


    // Fields    

     private String memberattributeid;
     private Date createdate;
     private Date modifydate;
     private String attributename;
     private Long attributetype;
     private String isrequired;
     private String isenabled;
     private Long orderlist;
     private String attributeoptionstore;


    // Constructors

    /** default constructor */
    public MemberAttribute() {
    }

    
    /** full constructor */
    public MemberAttribute(Date createdate, Date modifydate, String attributename, Long attributetype, String isrequired, String isenabled, Long orderlist, String attributeoptionstore) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.attributename = attributename;
        this.attributetype = attributetype;
        this.isrequired = isrequired;
        this.isenabled = isenabled;
        this.orderlist = orderlist;
        this.attributeoptionstore = attributeoptionstore;
    }

   
    // Property accessors

    public String getMemberattributeid() {
        return this.memberattributeid;
    }
    
    public void setMemberattributeid(String memberattributeid) {
        this.memberattributeid = memberattributeid;
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
   








}