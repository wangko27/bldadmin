package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TExamination entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExamination implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3202481716969716342L;
	private Long examId;
	private TTermSet TTermSet;
	private String examName;
	private Long typeId;
	private Long creatorId;
	private Long creatorRoleId;
	private String idstr;
	private String examDate;
	private String xxid;
	private String isRecordScore;
	private String isFinalExam;
	private Date createExamDate;
	private String idstr2;
	private Set studentExamresults = new HashSet(0);

	// Constructors

	/** default constructor */
	public TExamination() {
	}

	/** minimal constructor */
	public TExamination(String examName, Long typeId, Long creatorId,
			String idstr, String examDate) {
		this.examName = examName;
		this.typeId = typeId;
		this.creatorId = creatorId;
		this.idstr = idstr;
		this.examDate = examDate;
	}

	/** full constructor */
	public TExamination(TTermSet TTermSet, String examName, Long typeId,
			Long creatorId, Long creatorRoleId, String idstr, String examDate,
			String xxid, String isRecordScore, String isFinalExam,
			Date createExamDate, String idstr2, Set studentExamresults) {
		this.TTermSet = TTermSet;
		this.examName = examName;
		this.typeId = typeId;
		this.creatorId = creatorId;
		this.creatorRoleId = creatorRoleId;
		this.idstr = idstr;
		this.examDate = examDate;
		this.xxid = xxid;
		this.isRecordScore = isRecordScore;
		this.isFinalExam = isFinalExam;
		this.createExamDate = createExamDate;
		this.idstr2 = idstr2;
		this.studentExamresults = studentExamresults;
	}

	// Property accessors

	public Long getExamId() {
		return this.examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public TTermSet getTTermSet() {
		return this.TTermSet;
	}

	public void setTTermSet(TTermSet TTermSet) {
		this.TTermSet = TTermSet;
	}

	public String getExamName() {
		return this.examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getCreatorRoleId() {
		return this.creatorRoleId;
	}

	public void setCreatorRoleId(Long creatorRoleId) {
		this.creatorRoleId = creatorRoleId;
	}

	public String getIdstr() {
		return this.idstr;
	}

	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}

	public String getExamDate() {
		return this.examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public String getIsRecordScore() {
		return this.isRecordScore;
	}

	public void setIsRecordScore(String isRecordScore) {
		this.isRecordScore = isRecordScore;
	}

	public String getIsFinalExam() {
		return this.isFinalExam;
	}

	public void setIsFinalExam(String isFinalExam) {
		this.isFinalExam = isFinalExam;
	}

	public Date getCreateExamDate() {
		return this.createExamDate;
	}

	public void setCreateExamDate(Date createExamDate) {
		this.createExamDate = createExamDate;
	}

	public String getIdstr2() {
		return this.idstr2;
	}

	public void setIdstr2(String idstr2) {
		this.idstr2 = idstr2;
	}

	@SuppressWarnings("unchecked")
	public Set getStudentExamresults() {
		return this.studentExamresults;
	}

	@SuppressWarnings("unchecked")
	public void setStudentExamresults(Set studentExamresults) {
		this.studentExamresults = studentExamresults;
	}


}