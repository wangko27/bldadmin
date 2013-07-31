package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;

/**
 * SmsPublishedMsgBak entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SmsPublishedMsgBak implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long smsPublishId;// 信息编号
	private SmsSendLog smsSendLog;// 记录信息
	private String msmContent;// 内容
	private TStudent student;// 接收信息人（学生）
	private Date displayDate;// 发布时间
	private String mobilephone;// 手机号
	private long replySmsId;// 回复信息编号
	private String isaudit;// 审核情况，0审核中，1通过，2不通过，3已撤回
	private TTeacherinfo teacher;// 接收信息人（教师）

	// Constructors

	/** default constructor */
	public SmsPublishedMsgBak() {
	}

	/** full constructor */
	public SmsPublishedMsgBak(long smsPublishId, SmsSendLog smsSendLog,
			String msmContent, TStudent student, Date displayDate,
			String mobilephone, long replySmsId, String isaudit,
			TTeacherinfo teacher) {
		super();
		this.smsPublishId = smsPublishId;
		this.smsSendLog = smsSendLog;
		this.msmContent = msmContent;
		this.student = student;
		this.displayDate = displayDate;
		this.mobilephone = mobilephone;
		this.replySmsId = replySmsId;
		this.isaudit = isaudit;
		this.teacher = teacher;
	}

	// Property accessors
	public long getSmsPublishId() {
		return this.smsPublishId;
	}

	public void setSmsPublishId(long smsPublishId) {
		this.smsPublishId = smsPublishId;
	}

	public String getMsmContent() {
		return this.msmContent;
	}

	public void setMsmContent(String msmContent) {
		this.msmContent = msmContent;
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

	public String getIsaudit() {
		return this.isaudit;
	}

	public void setIsaudit(String isaudit) {
		this.isaudit = isaudit;
	}

	public SmsSendLog getSmsSendLog() {
		return smsSendLog;
	}

	public void setSmsSendLog(SmsSendLog smsSendLog) {
		this.smsSendLog = smsSendLog;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}

	public TTeacherinfo getTeacher() {
		return teacher;
	}

	public void setTeacher(TTeacherinfo teacher) {
		this.teacher = teacher;
	}

}