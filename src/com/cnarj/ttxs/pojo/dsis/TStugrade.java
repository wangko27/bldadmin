package com.cnarj.ttxs.pojo.dsis;

import java.util.HashSet;
import java.util.Set;

/**
 * TStugrade entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TStugrade implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long njId;
	private String njMcheng;
	private String njBma;
	private long njZtai;
	private long sffban;
	private String njXsming;
	private String xxid;
	private long kqrule;
	private Set TClasseses = new HashSet(0);
	private Set studentExamresults = new HashSet(0);
	private Set RTeacherClasses = new HashSet(0);
  
	// Constructors

	/** default constructor */
	public TStugrade() {
	}

	/** minimal constructor */
	public TStugrade(String njMcheng, long njZtai, long sffban, String njXsming) {
		this.njMcheng = njMcheng;
		this.njZtai = njZtai;
		this.sffban = sffban;
		this.njXsming = njXsming;
	}

	/** full constructor */
	public TStugrade(String njMcheng, String njBma, long njZtai, long sffban,
			String njXsming, String xxid, long kqrule, Set TClasseses,
			Set studentExamresults, Set RTeacherClasses) {
		this.njMcheng = njMcheng;
		this.njBma = njBma;
		this.njZtai = njZtai;
		this.sffban = sffban;
		this.njXsming = njXsming;
		this.xxid = xxid;
		this.kqrule = kqrule;
		this.TClasseses = TClasseses;
		this.studentExamresults = studentExamresults;
		this.RTeacherClasses = RTeacherClasses;
	}

	// Property accessors

	public long getNjId() {
		return this.njId;
	}

	public void setNjId(long njId) {
		this.njId = njId;
	}

	public String getNjMcheng() {
		return this.njMcheng;
	}

	public void setNjMcheng(String njMcheng) {
		this.njMcheng = njMcheng;
	}

	public String getNjBma() {
		return this.njBma;
	}

	public void setNjBma(String njBma) {
		this.njBma = njBma;
	}

	public long getNjZtai() {
		return this.njZtai;
	}

	public void setNjZtai(long njZtai) {
		this.njZtai = njZtai;
	}

	public long getSffban() {
		return this.sffban;
	}

	public void setSffban(long sffban) {
		this.sffban = sffban;
	}

	public String getNjXsming() {
		return this.njXsming;
	}

	public void setNjXsming(String njXsming) {
		this.njXsming = njXsming;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public long getKqrule() {
		return this.kqrule;
	}

	public void setKqrule(long kqrule) {
		this.kqrule = kqrule;
	}

	public Set getTClasseses() {
		return this.TClasseses;
	}

	public void setTClasseses(Set TClasseses) {
		this.TClasseses = TClasseses;
	}

	public Set getStudentExamresults() {
		return this.studentExamresults;
	}

	public void setStudentExamresults(Set studentExamresults) {
		this.studentExamresults = studentExamresults;
	}
	
	public Set getRTeacherClasses() {
		return RTeacherClasses;
	}

	public void setRTeacherClasses(Set teacherClasses) {
		RTeacherClasses = teacherClasses;
	}

	

	

}