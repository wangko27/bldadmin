package com.cnarj.ttxs.pojo.info;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * Answer entity. @author MyEclipse Persistence Tools
 */

public class Answer  implements java.io.Serializable {


    // Fields    

     private String answerid;
     private Question question;
     private Member member;
     private String answer;
     private String photopath;
     private String answerusername;
     private Date answerdate;
     private String isbest;


    // Constructors

    /** default constructor */
    public Answer() {
    }

    
    /** full constructor */
    public Answer(Question question, Member member, String answer, String photopath, String answerusername, Date answerdate, String isbest) {
        this.question = question;
        this.member = member;
        this.answer = answer;
        this.photopath = photopath;
        this.answerusername = answerusername;
        this.answerdate = answerdate;
        this.isbest = isbest;
    }

   
    // Property accessors

    public String getAnswerid() {
        return this.answerid;
    }
    
    public void setAnswerid(String answerid) {
        this.answerid = answerid;
    }

    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPhotopath() {
        return this.photopath;
    }
    
    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public String getAnswerusername() {
        return this.answerusername;
    }
    
    public void setAnswerusername(String answerusername) {
        this.answerusername = answerusername;
    }

    public Date getAnswerdate() {
        return this.answerdate;
    }
    
    public void setAnswerdate(Date answerdate) {
        this.answerdate = answerdate;
    }

    public String getIsbest() {
        return this.isbest;
    }
    
    public void setIsbest(String isbest) {
        this.isbest = isbest;
    }
   








}