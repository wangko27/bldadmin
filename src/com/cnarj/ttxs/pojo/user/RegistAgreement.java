package com.cnarj.ttxs.pojo.user;

import java.util.Date;


/**
 * RegistAgreement entity. @author MyEclipse Persistence Tools
 */

public class RegistAgreement  implements java.io.Serializable {


    // Fields    

     private String registagreementid;
     private String agreementcontent;
     private Date createdate;
     private Date modifydate;


    // Constructors

    /** default constructor */
    public RegistAgreement() {
    }

    
    /** full constructor */
    public RegistAgreement(String agreementcontent, Date createdate, Date modifydate) {
        this.agreementcontent = agreementcontent;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

   
    // Property accessors

    public String getRegistagreementid() {
        return this.registagreementid;
    }
    
    public void setRegistagreementid(String registagreementid) {
        this.registagreementid = registagreementid;
    }

    public String getAgreementcontent() {
        return this.agreementcontent;
    }
    
    public void setAgreementcontent(String agreementcontent) {
        this.agreementcontent = agreementcontent;
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
   








}