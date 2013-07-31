package com.cnarj.ttxs.pojo.shop;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Deposit entity. @author MyEclipse Persistence Tools
 */

public class Deposit  implements java.io.Serializable {


    // Fields    

     private String depositid;
     private Member member;
     private Date createdate;
     private Date modifydate;
     private Long deposittype;
     private Long credit;
     private Long debit;
     private Long balance;
     private Set refunds = new HashSet(0);


    // Constructors

    /** default constructor */
    public Deposit() {
    }

    
    /** full constructor */
    public Deposit(Member member, Date createdate, Date modifydate, Long deposittype, Long credit, Long debit, Long balance, Set refunds) {
        this.member = member;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.deposittype = deposittype;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
        this.refunds = refunds;
    }

   
    // Property accessors

    public String getDepositid() {
        return this.depositid;
    }
    
    public void setDepositid(String depositid) {
        this.depositid = depositid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
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

    public Long getDeposittype() {
        return this.deposittype;
    }
    
    public void setDeposittype(Long deposittype) {
        this.deposittype = deposittype;
    }

    public Long getCredit() {
        return this.credit;
    }
    
    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getDebit() {
        return this.debit;
    }
    
    public void setDebit(Long debit) {
        this.debit = debit;
    }

    public Long getBalance() {
        return this.balance;
    }
    
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Set getRefunds() {
        return this.refunds;
    }
    
    public void setRefunds(Set refunds) {
        this.refunds = refunds;
    }
   








}