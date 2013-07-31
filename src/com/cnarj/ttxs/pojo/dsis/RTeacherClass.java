package com.cnarj.ttxs.pojo.dsis;

/**
 * RTeacherClass entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RTeacherClass implements java.io.Serializable {

	// Fields

	private long teacClassId;
	private TClasses TClasses ;
	private TTeacherinfo TTeacherinfo;
	private TStugrade TStugrade;

	// Constructors

	

	/** default constructor */
	public RTeacherClass() {
	}

	/** full constructor */
	public RTeacherClass(long teacClassId, TClasses classes,
			TTeacherinfo teacherinfo, TStugrade stugrade) {
		super();
		this.teacClassId = teacClassId;
		TClasses = classes;
		TTeacherinfo = teacherinfo;
		TStugrade = stugrade;
	}
	// Property accessors

	public long getTeacClassId() {
		return this.teacClassId;
	}

	public void setTeacClassId(long teacClassId) {
		this.teacClassId = teacClassId;
	}

	public TClasses getTClasses() {
		return this.TClasses;
	}

	public void setTClasses(TClasses TClasses) {
		this.TClasses = TClasses;
	}

	public TTeacherinfo getTTeacherinfo() {
		return this.TTeacherinfo;
	}

	public void setTTeacherinfo(TTeacherinfo TTeacherinfo) {
		this.TTeacherinfo = TTeacherinfo;
	}

	public TStugrade getTStugrade() {
		return TStugrade;
	}

	public void setTStugrade(TStugrade stugrade) {
		TStugrade = stugrade;
	}

	
}