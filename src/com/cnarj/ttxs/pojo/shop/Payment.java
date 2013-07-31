package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Payment entity. @author MyEclipse Persistence Tools
 */

public class Payment  implements java.io.Serializable {


    // Fields    

     private String paymentid;
     private Orders orders;
     private PaymentConfig paymentConfig;
     private Date createdate;
     private Date modifydate;
     private String paymentsn;
     private Long paymenttype;
     private String paymentconfigname;
     private String bankname;
     private String bankaccount;
     private Long totalamount;
     private Long paymentfee;
     private Long payer;
     private String operatorname;
     private String paymentmemo;
     private Long paymentstatus;
     private String depositid;
     private Set orderses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Payment() {
    }

    
    /** full constructor */
    public Payment(Orders orders, PaymentConfig paymentConfig, Date createdate, Date modifydate, String paymentsn, Long paymenttype, String paymentconfigname, String bankname, String bankaccount, Long totalamount, Long paymentfee, Long payer, String operatorname, String paymentmemo, Long paymentstatus, String depositid, Set orderses) {
        this.orders = orders;
        this.paymentConfig = paymentConfig;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.paymentsn = paymentsn;
        this.paymenttype = paymenttype;
        this.paymentconfigname = paymentconfigname;
        this.bankname = bankname;
        this.bankaccount = bankaccount;
        this.totalamount = totalamount;
        this.paymentfee = paymentfee;
        this.payer = payer;
        this.operatorname = operatorname;
        this.paymentmemo = paymentmemo;
        this.paymentstatus = paymentstatus;
        this.depositid = depositid;
        this.orderses = orderses;
    }

   
    // Property accessors

    public String getPaymentid() {
        return this.paymentid;
    }
    
    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public Orders getOrders() {
        return this.orders;
    }
    
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public PaymentConfig getPaymentConfig() {
        return this.paymentConfig;
    }
    
    public void setPaymentConfig(PaymentConfig paymentConfig) {
        this.paymentConfig = paymentConfig;
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

    public String getPaymentsn() {
        return this.paymentsn;
    }
    
    public void setPaymentsn(String paymentsn) {
        this.paymentsn = paymentsn;
    }

    public Long getPaymenttype() {
        return this.paymenttype;
    }
    
    public void setPaymenttype(Long paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getPaymentconfigname() {
        return this.paymentconfigname;
    }
    
    public void setPaymentconfigname(String paymentconfigname) {
        this.paymentconfigname = paymentconfigname;
    }

    public String getBankname() {
        return this.bankname;
    }
    
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccount() {
        return this.bankaccount;
    }
    
    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public Long getTotalamount() {
        return this.totalamount;
    }
    
    public void setTotalamount(Long totalamount) {
        this.totalamount = totalamount;
    }

    public Long getPaymentfee() {
        return this.paymentfee;
    }
    
    public void setPaymentfee(Long paymentfee) {
        this.paymentfee = paymentfee;
    }

    public Long getPayer() {
        return this.payer;
    }
    
    public void setPayer(Long payer) {
        this.payer = payer;
    }

    public String getOperatorname() {
        return this.operatorname;
    }
    
    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname;
    }

    public String getPaymentmemo() {
        return this.paymentmemo;
    }
    
    public void setPaymentmemo(String paymentmemo) {
        this.paymentmemo = paymentmemo;
    }

    public Long getPaymentstatus() {
        return this.paymentstatus;
    }
    
    public void setPaymentstatus(Long paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getDepositid() {
        return this.depositid;
    }
    
    public void setDepositid(String depositid) {
        this.depositid = depositid;
    }

    public Set getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }
   








}