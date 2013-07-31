package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;

/**
 * SmsPublishedMsg entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SmsPublishedMsg implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private Long smsPublishId;
	private SmsSendLog smsSendLog;
	private String msmContent;
	private TStudent student;// 接收信息人（学生）
	private Date displayDate;
	private String mobilephone;
	private long replySmsId;
	private String xxid;
	private String delaysendtime;
	private String isaudit;
	private Date checkTime;
	private long smssource;
	private String auditPerson;
	private SmsPublishedType smsType;//  短信类别
	private TTeacherinfo teacher;//接收信息人（教师）

	// Constructors

	/** default constructor */
	public SmsPublishedMsg() {
	}

	/** minimal constructor */
	public SmsPublishedMsg(String msmContent, TStudent student,
			Date displayDate, String mobilephone, long replySmsId, String xxid,
			String isaudit) {
		this.msmContent = msmContent;
		this.student = student;
		this.displayDate = displayDate;
		this.mobilephone = mobilephone;
		this.replySmsId = replySmsId;
		this.xxid = xxid;
		this.isaudit = isaudit;
	}

	/** full constructor */
	public SmsPublishedMsg(SmsSendLog smsSendLog, String msmContent,
			TStudent student, Date displayDate, String mobilephone,
			long replySmsId, String xxid, String delaysendtime, String isaudit,
			Date checkTime, long smssource, String auditPerson,
			SmsPublishedType smsType, TTeacherinfo teacher) {
		this.smsSendLog = smsSendLog;
		this.msmContent = msmContent;
		this.student = student;
		this.displayDate = displayDate;
		this.mobilephone = mobilephone;
		this.replySmsId = replySmsId;
		this.xxid = xxid;
		this.delaysendtime = delaysendtime;
		this.isaudit = isaudit;
		this.checkTime = checkTime;
		this.smssource = smssource;
		this.auditPerson = auditPerson;
		this.smsType = smsType;
		this.teacher = teacher;
	}

	// Property accessors

	public Long getSmsPublishId() {
		return this.smsPublishId;
	}

	public void setSmsPublishId(Long smsPublishId) {
		this.smsPublishId = smsPublishId;
	}

	public SmsSendLog getSmsSendLog() {
		return this.smsSendLog;
	}

	public void setSmsSendLog(SmsSendLog smsSendLog) {
		this.smsSendLog = smsSendLog;
	}

	public String getMsmContent() {
		return this.msmContent;
	}

	public void setMsmContent(String msmContent) {
		this.msmContent = msmContent;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}

	

	public Date getDisplayDate() {
		return this.displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}

	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public long getReplySmsId() {
		return this.replySmsId;
	}

	public void setReplySmsId(long replySmsId) {
		this.replySmsId = replySmsId;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public String getDelaysendtime() {
		return this.delaysendtime;
	}

	public void setDelaysendtime(String delaysendtime) {
		this.delaysendtime = delaysendtime;
	}

	public String getIsaudit() {
		return this.isaudit;
	}

	public void setIsaudit(String isaudit) {
		this.isaudit = isaudit;
	}

	public Date getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public long getSmssource() {
		return this.smssource;
	}

	public void setSmssource(long smssource) {
		this.smssource = smssource;
	}

	public String getAuditPerson() {
		return this.auditPerson;
	}

	public void setAuditPerson(String auditPerson) {
		this.auditPerson = auditPerson;
	}

	public SmsPublishedType getSmsType() {
		return smsType;
	}

	public void setSmsType(SmsPublishedType smsType) {
		this.smsType = smsType;
	}

	public TTeacherinfo getTeacher() {
		return teacher;
	}

	public void setTeacher(TTeacherinfo teacher) {
		this.teacher = teacher;
	}

}