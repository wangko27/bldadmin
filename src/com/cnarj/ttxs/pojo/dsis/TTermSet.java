package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TTermSet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TTermSet implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1718996073837912000L;
	private Long termId;
	private String termName;
	private String termYear;
	private Long termType;
	private String isCurrentTerm;
	private String xxid;
	private Date holidayBegin;
	private Date holidayEnd;
	private Set TExaminations = new HashSet(0);

	// Constructors

	/** default constructor */
	public TTermSet() {
	}

	/** minimal constructor */
	public TTermSet(String termName, String termYear, Long termType) {
		this.termName = termName;
		this.termYear = termYear;
		this.termType = termType;
	}

	/** full constructor */
	public TTermSet(String termName, String termYear, Long termType,
			String isCurrentTerm, String xxid, Date holidayBegin,
			Date holidayEnd, Set TExaminations) {
		this.termName = termName;
		this.termYear = termYear;
		this.termType = termType;
		this.isCurrentTerm = isCurrentTerm;
		this.xxid = xxid;
		this.holidayBegin = holidayBegin;
		this.holidayEnd = holidayEnd;
		this.TExaminations = TExaminations;
	}

	// Property accessors

	public Long getTermId() {
		return this.termId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public String getTermName() {
		return this.termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getTermYear() {
		return this.termYear;
	}

	public void setTermYear(String termYear) {
		this.termYear = termYear;
	}

	public Long getTermType() {
		return this.termType;
	}

	public void setTermType(Long termType) {
		this.termType = termType;
	}

	public String getIsCurrentTerm() {
		return this.isCurrentTerm;
	}

	public void setIsCurrentTerm(String isCurrentTerm) {
		this.isCurrentTerm = isCurrentTerm;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public Date getHolidayBegin() {
		return this.holidayBegin;
	}

	public void setHolidayBegin(Date holidayBegin) {
		this.holidayBegin = holidayBegin;
	}

	public Date getHolidayEnd() {
		return this.holidayEnd;
	}

	public void setHolidayEnd(Date holidayEnd) {
		this.holidayEnd = holidayEnd;
	}

	@SuppressWarnings("unchecked")
	public Set getTExaminations() {
		return this.TExaminations;
	}

	@SuppressWarnings("unchecked")
	public void setTExaminations(Set TExaminations) {
		this.TExaminations = TExaminations;
	}

}