package com.cnarj.ttxs.pojo.shop;

import java.util.Date;


/**
 * Refund entity. @author MyEclipse Persistence Tools
 */

public class Refund  implements java.io.Serializable {


    // Fields    

     private String refundid;
     private Orders orders;
     private PaymentConfig paymentConfig;
     private Deposit deposit;
     private Date createdate;
     private Date modifydate;
     private String refundsn;
     private Long refundtype;
     private String paymentconfigname;
     private String bankname;
     private String bankaccount;
     private Long totalamount;
     private String payee;
     private String refundoperator;
     private String refundmemo;


    // Constructors

    /** default constructor */
    public Refund() {
    }

    
    /** full constructor */
    public Refund(Orders orders, PaymentConfig paymentConfig, Deposit deposit, Date createdate, Date modifydate, String refundsn, Long refundtype, String paymentconfigname, String bankname, String bankaccount, Long totalamount, String payee, String refundoperator, String refundmemo) {
        this.orders = orders;
        this.paymentConfig = paymentConfig;
        this.deposit = deposit;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.refundsn = refundsn;
        this.refundtype = refundtype;
        this.paymentconfigname = paymentconfigname;
        this.bankname = bankname;
        this.bankaccount = bankaccount;
        this.totalamount = totalamount;
        this.payee = payee;
        this.refundoperator = refundoperator;
        this.refundmemo = refundmemo;
    }

   
    // Property accessors

    public String getRefundid() {
        return this.refundid;
    }
    
    public void setRefundid(String refundid) {
        this.refundid = refundid;
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

    public Deposit getDeposit() {
        return this.deposit;
    }
    
    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
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

    public String getRefundsn() {
        return this.refundsn;
    }
    
    public void setRefundsn(String refundsn) {
        this.refundsn = refundsn;
    }

    public Long getRefundtype() {
        return this.refundtype;
    }
    
    public void setRefundtype(Long refundtype) {
        this.refundtype = refundtype;
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

    public String getPayee() {
        return this.payee;
    }
    
    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getRefundoperator() {
        return this.refundoperator;
    }
    
    public void setRefundoperator(String refundoperator) {
        this.refundoperator = refundoperator;
    }

    public String getRefundmemo() {
        return this.refundmemo;
    }
    
    public void setRefundmemo(String refundmemo) {
        this.refundmemo = refundmemo;
    }
   








}