package com.cnarj.ttxs.pojo.info;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ArticleType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class QuestionType implements java.io.Serializable {

	// Fields

	private String questiontypeid;
	private String questiontypename;
	private String parentquestiontypeid;
	private Long typesort;
	private Date createdate;
	private Date modifydate;
	private Set questions = new HashSet(0);	
	private Long datanum;
	
	
	
	public QuestionType(String questiontypeid, String questiontypename,
			String parentquestiontypeid, Long typesort, Date createdate,
			Date modifydate, Set questions,Long datanum) {
		super();
		this.questiontypeid = questiontypeid;
		this.questiontypename = questiontypename;
		this.parentquestiontypeid = parentquestiontypeid;
		this.typesort = typesort;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.questions = questions;
		this.datanum = datanum;
	}
	
	
	public QuestionType() {
		super();
	}


	public Long getDatanum() {
		return datanum;
	}


	public void setDatanum(Long datanum) {
		this.datanum = datanum;
	}


	public String getQuestiontypeid() {
		return questiontypeid;
	}
	public void setQuestiontypeid(String questiontypeid) {
		this.questiontypeid = questiontypeid;
	}
	public String getQuestiontypename() {
		return questiontypename;
	}
	public void setQuestiontypename(String questiontypename) {
		this.questiontypename = questiontypename;
	}
	public String getParentquestiontypeid() {
		return parentquestiontypeid;
	}
	public void setParentquestiontypeid(String parentquestiontypeid) {
		this.parentquestiontypeid = parentquestiontypeid;
	}
	public Long getTypesort() {
		return typesort;
	}
	public void setTypesort(Long typesort) {
		this.typesort = typesort;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public Set getQuestions() {
		return questions;
	}
	public void setQuestions(Set questions) {
		this.questions = questions;
	}
	
	
}