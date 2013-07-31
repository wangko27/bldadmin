package com.cnarj.ttxs.pojo.shop;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * ZealAnswer entity. @author MyEclipse Persistence Tools
 */

public class ZealAnswer  implements java.io.Serializable {


    // Fields    

     private String zealanswerid;
     private Member member;
     private String questiontitle;
     private String questiondetails;
     private String answer;
     private Date questiondate;
     private String askerusername;
     private Date createdate;
     private Date modifydate;


    // Constructors

    /** default constructor */
    public ZealAnswer() {
    }

    
    /** full constructor */
    public ZealAnswer(Member member, String questiontitle, String questiondetails, String answer, Date questiondate, String askerusername, Date createdate, Date modifydate) {
        this.member = member;
        this.questiontitle = questiontitle;
        this.questiondetails = questiondetails;
        this.answer = answer;
        this.questiondate = questiondate;
        this.askerusername = askerusername;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

   
    // Property accessors

    public String getZealanswerid() {
        return this.zealanswerid;
    }
    
    public void setZealanswerid(String zealanswerid) {
        this.zealanswerid = zealanswerid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public String getQuestiontitle() {
        return this.questiontitle;
    }
    
    public void setQuestiontitle(String questiontitle) {
        this.questiontitle = questiontitle;
    }

    public String getQuestiondetails() {
        return this.questiondetails;
    }
    
    public void setQuestiondetails(String questiondetails) {
        this.questiondetails = questiondetails;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getQuestiondate() {
        return this.questiondate;
    }
    
    public void setQuestiondate(Date questiondate) {
        this.questiondate = questiondate;
    }

    public String getAskerusername() {
        return this.askerusername;
    }
    
    public void setAskerusername(String askerusername) {
        this.askerusername = askerusername;
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