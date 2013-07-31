package com.cnarj.ttxs.pojo.dsis;


/**
 * TSubject entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSubject implements java.io.Serializable {

	// Fields

	private long subjectId;
	private String subjectName;
	private String subjectCode;
	private String xxid;
	private String isCommonUse;

	// Constructors

	/** default constructor */
	public TSubject() {
	}

	/** minimal constructor */
	public TSubject(String subjectName, String subjectCode) {
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}

	/** full constructor */
	public TSubject(String subjectName, String subjectCode, 
			String xxid, String isCommonUse) {
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.xxid = xxid;
		this.isCommonUse = isCommonUse;
	}

	// Property accessors

	public long getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public String getIsCommonUse() {
		return this.isCommonUse;
	}

	public void setIsCommonUse(String isCommonUse) {
		this.isCommonUse = isCommonUse;
	}


}