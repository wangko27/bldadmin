package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;

/**
 * StudentAttendanceRecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class StudentAttendanceRecord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4084250579026065984L;
	private String attenRecoId;
//	private Long xsId;
	private TStudent  TStudent;
	private Date readcardTime;
	private String inOutState;
	private String xxid;
	private String result;
	private String smsContent;
	private Long attenSetId;

	// Constructors

	/** default constructor */
	public StudentAttendanceRecord() {
	}

	/** minimal constructor */
	public StudentAttendanceRecord(TStudent  TStudent, Date readcardTime,
			String inOutState, String xxid, String result) {
		this.TStudent = TStudent;
		this.readcardTime = readcardTime;
		this.inOutState = inOutState;
		this.xxid = xxid;
		this.result = result;
	}

	/** full constructor */
	public StudentAttendanceRecord(TStudent  TStudent, Date readcardTime,
			String inOutState, String xxid, String result, String smsContent,
			Long attenSetId) {
		this.TStudent = TStudent;
		this.readcardTime = readcardTime;
		this.inOutState = inOutState;
		this.xxid = xxid;
		this.result = result;
		this.smsContent = smsContent;
		this.attenSetId = attenSetId;
	}

	// Property accessors

	public String getAttenRecoId() {
		return this.attenRecoId;
	}

	public void setAttenRecoId(String attenRecoId) {
		this.attenRecoId = attenRecoId;
	}

	public TStudent getTStudent() {
		return TStudent;
	}

	public void setTStudent(TStudent student) {
		TStudent = student;
	}

	public Date getReadcardTime() {
		return this.readcardTime;
	}

	public void setReadcardTime(Date readcardTime) {
		this.readcardTime = readcardTime;
	}

	public String getInOutState() {
		return this.inOutState;
	}

	public void setInOutState(String inOutState) {
		this.inOutState = inOutState;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSmsContent() {
		return this.smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public Long getAttenSetId() {
		return attenSetId;
	}

	public void setAttenSetId(Long attenSetId) {
		this.attenSetId = attenSetId;
	}

	

}