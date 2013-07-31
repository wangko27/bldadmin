package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;

/**
 * ParentAccount entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ParentAccount implements java.io.Serializable {

	// Fields

	private Long zhId;
	private Long xsId;
	private String accountName;
	private String accountPwd;
	private Date startDate;
	private Date endDate;
	private String accountState;
	private String isOpen;
	private Long monthsSendNumber;
	private String xxid;
	private TParentinfo parentinfo;
	

	// Constructors

	/** default constructor */
	public ParentAccount() {
	}

	/** full constructor */
	public ParentAccount(Long xsId, String accountName, String accountPwd,
			Date startDate, Date endDate, String accountState, String isOpen,
			Long monthsSendNumber, String xxid, TParentinfo parentinfo) {
		this.xsId = xsId;
		this.accountName = accountName;
		this.accountPwd = accountPwd;
		this.startDate = startDate;
		this.endDate = endDate;
		this.accountState = accountState;
		this.isOpen = isOpen;
		this.monthsSendNumber = monthsSendNumber;
		this.xxid = xxid;
		this.parentinfo = parentinfo;
	}

	// Property accessors

	public Long getZhId() {
		return this.zhId;
	}

	public void setZhId(Long zhId) {
		this.zhId = zhId;
	}

	public Long getXsId() {
		return this.xsId;
	}

	public void setXsId(Long xsId) {
		this.xsId = xsId;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPwd() {
		return this.accountPwd;
	}

	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAccountState() {
		return this.accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}

	public String getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public Long getMonthsSendNumber() {
		return this.monthsSendNumber;
	}

	public void setMonthsSendNumber(Long monthsSendNumber) {
		this.monthsSendNumber = monthsSendNumber;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public TParentinfo getParentinfo() {
		return parentinfo;
	}

	public void setParentinfo(TParentinfo parentinfo) {
		this.parentinfo = parentinfo;
	}

	

}