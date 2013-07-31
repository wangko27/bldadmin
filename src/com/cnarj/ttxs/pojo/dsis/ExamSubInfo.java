package com.cnarj.ttxs.pojo.dsis;

import java.io.Serializable;

public class ExamSubInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3291553579794901424L;
	private Long examsubid;
	private Long njId;
	private TExamination exam;
	private String substr;
	private String subtotal;
	private String xxid;
	private  Integer  isenter;

	public Long getNjId() {
		return njId;
	}

	public void setNjId(Long njId) {
		this.njId = njId;
	}

	public TExamination getExam() {
		return exam;
	}

	public void setExam(TExamination exam) {
		this.exam = exam;
	}

	public String getSubstr() {
		return substr;
	}

	public void setSubstr(String substr) {
		this.substr = substr;
	}

	public Long getExamsubid() {
		return examsubid;
	}

	public void setExamsubid(Long examsubid) {
		this.examsubid = examsubid;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getXxid() {
		return xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public Integer getIsenter() {
		return isenter;
	}

	public void setIsenter(Integer isenter) {
		this.isenter = isenter;
	}
    
}
