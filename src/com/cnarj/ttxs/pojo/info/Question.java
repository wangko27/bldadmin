package com.cnarj.ttxs.pojo.info;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cnarj.ttxs.pojo.user.Member;


/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question  implements java.io.Serializable {


    // Fields    

     private String questionid;
     private String question;
     private String explanation;
     private Long questionpoint;
     private Date begindate;
     private Date enddate;
     private String asker;
     private Long visittime;
     private String questionstatus;
     private Date createdate;
     private Date modifydate;
     private Set answers = new HashSet(0);
     private QuestionType questionType;
     private Member member;
     private Long answernum;





	/** default constructor */
    public Question() {
    }

    
    /** full constructor */
    // Constructors
	public Question(String questionid, String question, String explanation,
			Long questionpoint, Date begindate, Date enddate, String asker,
			Long visittime, String questionstatus, Date createdate,
			Date modifydate, Set answers, QuestionType questionType, Member member,
			Long answernum) {
		super();
		this.questionid = questionid;
		this.question = question;
		this.explanation = explanation;
		this.questionpoint = questionpoint;
		this.begindate = begindate;
		this.enddate = enddate;
		this.asker = asker;
		this.visittime = visittime;
		this.questionstatus = questionstatus;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.answers = answers;
		this.questionType = questionType;
		this.member = member;
		this.answernum = answernum;
	}
    
   
    // Property accessors

    public String getQuestionid() {
        return this.questionid;
    }
    
    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExplanation() {
        return this.explanation;
    }
    
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Long getQuestionpoint() {
        return this.questionpoint;
    }
    
    public void setQuestionpoint(Long questionpoint) {
        this.questionpoint = questionpoint;
    }

    public Date getBegindate() {
        return this.begindate;
    }
    
    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getAsker() {
        return this.asker;
    }
    
    public void setAsker(String asker) {
        this.asker = asker;
    }

    public Long getVisittime() {
        return this.visittime;
    }
    
    public void setVisittime(Long visittime) {
        this.visittime = visittime;
    }

    public String getQuestionstatus() {
        return this.questionstatus;
    }
    
    public void setQuestionstatus(String questionstatus) {
        this.questionstatus = questionstatus;
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

    public Set getAnswers() {
        return this.answers;
    }
    
    public void setAnswers(Set answers) {
        this.answers = answers;
    }


	public QuestionType getQuestionType() {
		return questionType;
	}


	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Long getAnswernum() {
		return answernum;
	}


	public void setAnswernum(Long answernum) {
		this.answernum = answernum;
	}
   








}