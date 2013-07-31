package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * PaymentConfig entity. @author MyEclipse Persistence Tools
 */

public class PaymentConfig  implements java.io.Serializable {


    // Fields    

     private String paymentconfigid;
     private Date createdate;
     private Date modifydate;
     private Long paymentconfigtype;
     private String paymentconfigname;
     private Long paymentfeetype;
     private Long paymentfee;
     private String configdescription;
     private Long orderlist;
     private String configobjectstore;
     private Set payments = new HashSet(0);
     private Set refunds = new HashSet(0);


    // Constructors

    /** default constructor */
    public PaymentConfig() {
    }

    
    /** full constructor */
    public PaymentConfig(Date createdate, Date modifydate, Long paymentconfigtype, String paymentconfigname, Long paymentfeetype, Long paymentfee, String configdescription, Long orderlist, String configobjectstore, Set payments, Set refunds) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.paymentconfigtype = paymentconfigtype;
        this.paymentconfigname = paymentconfigname;
        this.paymentfeetype = paymentfeetype;
        this.paymentfee = paymentfee;
        this.configdescription = configdescription;
        this.orderlist = orderlist;
        this.configobjectstore = configobjectstore;
        this.payments = payments;
        this.refunds = refunds;
    }

   
    // Property accessors

    public String getPaymentconfigid() {
        return this.paymentconfigid;
    }
    
    public void setPaymentconfigid(String paymentconfigid) {
        this.paymentconfigid = paymentconfigid;
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

    public Long getPaymentconfigtype() {
        return this.paymentconfigtype;
    }
    
    public void setPaymentconfigtype(Long paymentconfigtype) {
        this.paymentconfigtype = paymentconfigtype;
    }

    public String getPaymentconfigname() {
        return this.paymentconfigname;
    }
    
    public void setPaymentconfigname(String paymentconfigname) {
        this.paymentconfigname = paymentconfigname;
    }

    public Long getPaymentfeetype() {
        return this.paymentfeetype;
    }
    
    public void setPaymentfeetype(Long paymentfeetype) {
        this.paymentfeetype = paymentfeetype;
    }

    public Long getPaymentfee() {
        return this.paymentfee;
    }
    
    public void setPaymentfee(Long paymentfee) {
        this.paymentfee = paymentfee;
    }

    public String getConfigdescription() {
        return this.configdescription;
    }
    
    public void setConfigdescription(String configdescription) {
        this.configdescription = configdescription;
    }

    public Long getOrderlist() {
        return this.orderlist;
    }
    
    public void setOrderlist(Long orderlist) {
        this.orderlist = orderlist;
    }

    public String getConfigobjectstore() {
        return this.configobjectstore;
    }
    
    public void setConfigobjectstore(String configobjectstore) {
        this.configobjectstore = configobjectstore;
    }

    public Set getPayments() {
        return this.payments;
    }
    
    public void setPayments(Set payments) {
        this.payments = payments;
    }

    public Set getRefunds() {
        return this.refunds;
    }
    
    public void setRefunds(Set refunds) {
        this.refunds = refunds;
    }
   








}