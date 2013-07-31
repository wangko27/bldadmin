package com.cnarj.ttxs.pojo.dsis;

import java.util.HashSet;
import java.util.Set;

/**
 * TClasses entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TClasses implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 312846243795957934L;
	private Long bjId;
	private TStugrade TStugrade;
	private String bjBma;
	private String bjMcheng;
	private Long bjZtai;
	private String xxid;
	private Set TCourseses = new HashSet(0);
	private Set RTeacherClasses = new HashSet(0);
	private Set TStudents = new HashSet(0);
	private Set studentExamresults = new HashSet(0);

	// Constructors

	/** default constructor */
	public TClasses() {
	}

	/** minimal constructor */
	public TClasses(TStugrade TStugrade, String xxid) {
		this.TStugrade = TStugrade;
		this.xxid = xxid;
	}

	/** full constructor */
	public TClasses(TStugrade TStugrade, String bjBma, String bjMcheng,
			Long bjZtai, String xxid, Set TCourseses, Set RTeacherClasses,
			Set TStudents, Set studentExamresults) {
		this.TStugrade = TStugrade;
		this.bjBma = bjBma;
		this.bjMcheng = bjMcheng;
		this.bjZtai = bjZtai;
		this.xxid = xxid;
		this.TCourseses = TCourseses;
		this.RTeacherClasses = RTeacherClasses;
		this.TStudents = TStudents;
		this.studentExamresults = studentExamresults;
	}

	// Property accessors

	public Long getBjId() {
		return this.bjId;
	}

	public void setBjId(Long bjId) {
		this.bjId = bjId;
	}

	public TStugrade getTStugrade() {
		return this.TStugrade;
	}

	public void setTStugrade(TStugrade TStugrade) {
		this.TStugrade = TStugrade;
	}

	public String getBjBma() {
		return this.bjBma;
	}

	public void setBjBma(String bjBma) {
		this.bjBma = bjBma;
	}

	public String getBjMcheng() {
		return this.bjMcheng;
	}

	public void setBjMcheng(String bjMcheng) {
		this.bjMcheng = bjMcheng;
	}

	public Long getBjZtai() {
		return this.bjZtai;
	}

	public void setBjZtai(Long bjZtai) {
		this.bjZtai = bjZtai;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public Set getTCourseses() {
		return this.TCourseses;
	}

	public void setTCourseses(Set TCourseses) {
		this.TCourseses = TCourseses;
	}

	public Set getRTeacherClasses() {
		return this.RTeacherClasses;
	}

	public void setRTeacherClasses(Set RTeacherClasses) {
		this.RTeacherClasses = RTeacherClasses;
	}

	public Set getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(Set TStudents) {
		this.TStudents = TStudents;
	}

	public Set getStudentExamresults() {
		return this.studentExamresults;
	}

	public void setStudentExamresults(Set studentExamresults) {
		this.studentExamresults = studentExamresults;
	}

}