package com.cnarj.ttxs.pojo.dsis;

/**
 * StudentAttendanceSet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class StudentAttendanceSet implements java.io.Serializable {

	// Fields

	private Long attenSetId;
	private BasicAttendanceSet basicAttendanceSet;
	private Long njId;
	private Long bjId;
	private String weekDay;
	private String attenStartTime;
	private String attenEndTime;
	private String smsContent;
	private String isSend;
	private String smsSendScope;
	private String xxid;
	private Long seq;
	private String flag;
	private String startHour;
	private String startMinute;//
	private String endHour;//
	private String endMinute;

	// Constructors

	/** default constructor */
	public StudentAttendanceSet() {
	}

	/** full constructor */
	public StudentAttendanceSet(BasicAttendanceSet basicAttendanceSet,
			Long njId, Long bjId, String weekDay, String attenStartTime,
			String attenEndTime, String smsContent, String isSend,
			String smsSendScope, String xxid, Long seq, String flag) {
		this.basicAttendanceSet = basicAttendanceSet;
		this.njId = njId;
		this.bjId = bjId;
		this.weekDay = weekDay;
		this.attenStartTime = attenStartTime;
		this.attenEndTime = attenEndTime;
		this.smsContent = smsContent;
		this.isSend = isSend;
		this.smsSendScope = smsSendScope;
		this.xxid = xxid;
		this.seq = seq;
		this.flag = flag;
	}

	// Property accessors

	public Long getAttenSetId() {
		return this.attenSetId;
	}

	public void setAttenSetId(Long attenSetId) {
		this.attenSetId = attenSetId;
	}

	public BasicAttendanceSet getBasicAttendanceSet() {
		return this.basicAttendanceSet;
	}

	public void setBasicAttendanceSet(BasicAttendanceSet basicAttendanceSet) {
		this.basicAttendanceSet = basicAttendanceSet;
	}

	public Long getNjId() {
		return this.njId;
	}

	public void setNjId(Long njId) {
		this.njId = njId;
	}

	public Long getBjId() {
		return this.bjId;
	}

	public void setBjId(Long bjId) {
		this.bjId = bjId;
	}

	public String getWeekDay() {
		return this.weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getAttenStartTime() {
		return this.attenStartTime;
	}

	public void setAttenStartTime(String attenStartTime) {
		this.attenStartTime = attenStartTime;
	}

	public String getAttenEndTime() {
		return this.attenEndTime;
	}

	public void setAttenEndTime(String attenEndTime) {
		this.attenEndTime = attenEndTime;
	}

	public String getSmsContent() {
		return this.smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getIsSend() {
		return this.isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}

	public String getSmsSendScope() {
		return this.smsSendScope;
	}

	public void setSmsSendScope(String smsSendScope) {
		this.smsSendScope = smsSendScope;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(String startMinute) {
		this.startMinute = startMinute;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}