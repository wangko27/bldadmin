package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * DeliveryCorp entity. @author MyEclipse Persistence Tools
 */

public class DeliveryCorp  implements java.io.Serializable {


    // Fields    

     private String deliverycorpid;
     private String deliverycorpname;
     private String deliverycorpurl;
     private Long orderlist;
     private Date createdate;
     private Date modifydate;
     private Set deliveryTypes = new HashSet(0);


    // Constructors

    /** default constructor */
    public DeliveryCorp() {
    }

    
    /** full constructor */
    public DeliveryCorp(String deliverycorpname, String deliverycorpurl, Long orderlist, Date createdate, Date modifydate, Set deliveryTypes) {
        this.deliverycorpname = deliverycorpname;
        this.deliverycorpurl = deliverycorpurl;
        this.orderlist = orderlist;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.deliveryTypes = deliveryTypes;
    }

   
    // Property accessors

    public String getDeliverycorpid() {
        return this.deliverycorpid;
    }
    
    public void setDeliverycorpid(String deliverycorpid) {
        this.deliverycorpid = deliverycorpid;
    }

    public String getDeliverycorpname() {
        return this.deliverycorpname;
    }
    
    public void setDeliverycorpname(String deliverycorpname) {
        this.deliverycorpname = deliverycorpname;
    }

    public String getDeliverycorpurl() {
        return this.deliverycorpurl;
    }
    
    public void setDeliverycorpurl(String deliverycorpurl) {
        this.deliverycorpurl = deliverycorpurl;
    }

    public Long getOrderlist() {
        return this.orderlist;
    }
    
    public void setOrderlist(Long orderlist) {
        this.orderlist = orderlist;
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

    public Set getDeliveryTypes() {
        return this.deliveryTypes;
    }
    
    public void setDeliveryTypes(Set deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }
   








}