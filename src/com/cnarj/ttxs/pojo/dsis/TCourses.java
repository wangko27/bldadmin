package com.cnarj.ttxs.pojo.dsis;

/**
 * TCourses entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCourses implements java.io.Serializable {

	// Fields

	private long courseId;
	private TClasses TClasses;
	private String courseSequence;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;

	// Constructors

	/** default constructor */
	public TCourses() {
	}

	/** minimal constructor */
	public TCourses(TClasses TClasses, String courseSequence, String monday,
			String tuesday, String wednesday) {
		this.TClasses = TClasses;
		this.courseSequence = courseSequence;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
	}

	/** full constructor */
	public TCourses(TClasses TClasses, String courseSequence, String monday,
			String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sunday) {
		this.TClasses = TClasses;
		this.courseSequence = courseSequence;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}

	// Property accessors

	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public TClasses getTClasses() {
		return this.TClasses;
	}

	public void setTClasses(TClasses TClasses) {
		this.TClasses = TClasses;
	}

	public String getCourseSequence() {
		return this.courseSequence;
	}

	public void setCourseSequence(String courseSequence) {
		this.courseSequence = courseSequence;
	}

	public String getMonday() {
		return this.monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return this.tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return this.wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return this.thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return this.friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return this.saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return this.sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

}