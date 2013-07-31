package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SmsSendLog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SmsSendLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long smsSendId;// 记录ID
	private SmsPublishedType smsPublishedType;// 发布类别
	private String sendnumber;// 发送号码数量（发送了几个号码），正确的号码
	private Date sendtime;// 发送时间
	private TSchoolinfo school;// 学校
	private String isaudit;// 审核状态，0审核中，1通过，2不通过，3已撤回
	private Set<SmsPublishedMsg> smsPublishedMsgs = new HashSet<SmsPublishedMsg>(
			0);// 发送详情
	private String recallReason;// 撤回理由
	private int smsObjectType;// 短信发送对象类别 1个人信息，2班级信息，3年级信息，4全校信息，5区域信息
	private String msmContent;// 发送原始内容
	private String receiveObject; // 接收对象 1家长 2教师
	private String sendObject;// 发送对象 如初一年级120班
	private long smssource;// 数据源：1:家校互动2:考勤短信,3:成绩短信,4:教师短信,5:个性短信,6:后台短信
	private String auditPerson;// 审核人
	private Date checkTime;// 审核时间
	private Date delaysendtime;// 延迟时间（定时发送时间）

	// Constructors

	/** default constructor */
	public SmsSendLog() {
	}

	/** minimal constructor */
	public SmsSendLog(String sendnumber, TSchoolinfo school, String isaudit) {
		this.sendnumber = sendnumber;
		this.school = school;
		this.isaudit = isaudit;
	}

	/** full constructor */
	public SmsSendLog(long smsSendId, SmsPublishedType smsPublishedType,
			String sendnumber, Date sendtime, TSchoolinfo school,
			String isaudit, Set<SmsPublishedMsg> smsPublishedMsgs,
			String recallReason, int smsObjectType, String msmContent, 
			String receiveObject, String sendObject, long smssource, 
			String auditPerson, Date checkTime, Date delaysendtime) {
		super();
		this.smsSendId = smsSendId;
		this.smsPublishedType = smsPublishedType;
		this.sendnumber = sendnumber;
		this.sendtime = sendtime;
		this.school = school;
		this.isaudit = isaudit;
		this.smsPublishedMsgs = smsPublishedMsgs;
		this.recallReason = recallReason;
		this.smsObjectType = smsObjectType;
		this.msmContent = msmContent;
		this.receiveObject = receiveObject;
		this.sendObject = sendObject;
		this.smssource = smssource;
		this.auditPerson = auditPerson;
		this.checkTime = checkTime;
		this.delaysendtime = delaysendtime;
	}

	// Property accessors

	public long getSmsSendId() {
		return this.smsSendId;
	}

	public void setSmsSendId(long smsSendId) {
		this.smsSendId = smsSendId;
	}

	public SmsPublishedType getSmsPublishedType() {
		return this.smsPublishedType;
	}

	public void setSmsPublishedType(SmsPublishedType smsPublishedType) {
		this.smsPublishedType = smsPublishedType;
	}

	public String getSendnumber() {
		return this.sendnumber;
	}

	public void setSendnumber(String sendnumber) {
		this.sendnumber = sendnumber;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public TSchoolinfo getSchool() {
		return school;
	}

	public void setSchool(TSchoolinfo school) {
		this.school = school;
	}

	public String getIsaudit() {
		return this.isaudit;
	}

	public void setIsaudit(String isaudit) {
		this.isaudit = isaudit;
	}

	public Set<SmsPublishedMsg> getSmsPublishedMsgs() {
		return this.smsPublishedMsgs;
	}

	public void setSmsPublishedMsgs(Set<SmsPublishedMsg> smsPublishedMsgs) {
		this.smsPublishedMsgs = smsPublishedMsgs;
	}

	public String getRecallReason() {
		return recallReason;
	}

	public void setRecallReason(String recallReason) {
		this.recallReason = recallReason;
	}

	public int getSmsObjectType() {
		return smsObjectType;
	}

	public void setSmsObjectType(int smsObjectType) {
		this.smsObjectType = smsObjectType;
	}

	public String getMsmContent() {
		return msmContent;
	}

	public void setMsmContent(String msmContent) {
		this.msmContent = msmContent;
	}

	public String getReceiveObject() {
		return receiveObject;
	}

	public void setReceiveObject(String receiveObject) {
		this.receiveObject = receiveObject;
	}

	public String getSendObject() {
		return sendObject;
	}

	public void setSendObject(String sendObject) {
		this.sendObject = sendObject;
	}

	public long getSmssource() {
		return smssource;
	}

	public void setSmssource(long smssource) {
		this.smssource = smssource;
	}

	public String getAuditPerson() {
		return auditPerson;
	}

	public void setAuditPerson(String auditPerson) {
		this.auditPerson = auditPerson;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getDelaysendtime() {
		return delaysendtime;
	}

	public void setDelaysendtime(Date delaysendtime) {
		this.delaysendtime = delaysendtime;
	}

}