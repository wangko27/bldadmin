package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TParentinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TParentinfo implements java.io.Serializable {

	// Fields

	private long parentsId;
	private long xsId;
	private String parentsName;
	private java.util.Date birthday;
	private String officephone;
	private String mobliephone;
	private String email;
	private String parentsCaller;
	private long professional;
	private String workaddress;
	private String remarks;
	private Set parentAccounts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TParentinfo() {
	}

	/** minimal constructor */
	public TParentinfo(long xsId, String parentsName, Date birthday,
			String officephone, String mobliephone, String email,
			String parentsCaller, String workaddress, String remarks,
			Set parentAccounts) {
		this.xsId = xsId;
		this.parentsName = parentsName;
		this.birthday = birthday;
		this.officephone = officephone;
		this.mobliephone = mobliephone;
		this.email = email;
		this.parentsCaller = parentsCaller;
		this.workaddress = workaddress;
		this.remarks = remarks;
		this.parentAccounts = parentAccounts;
	}

	/** full constructor */
	public TParentinfo(long xsId, String parentsName, Date birthday,
			String officephone, String mobliephone, String email,
			String parentsCaller, long professional, String workaddress,
			String remarks, Set parentAccounts) {
		this.xsId = xsId;
		this.parentsName = parentsName;
		this.birthday = birthday;
		this.officephone = officephone;
		this.mobliephone = mobliephone;
		this.email = email;
		this.parentsCaller = parentsCaller;
		this.professional = professional;
		this.workaddress = workaddress;
		this.remarks = remarks;
		this.parentAccounts = parentAccounts;
	}

	// Property accessors

	public long getParentsId() {
		return this.parentsId;
	}

	public void setParentsId(long parentsId) {
		this.parentsId = parentsId;
	}

	public long getXsId() {
		return this.xsId;
	}

	public void setXsId(long xsId) {
		this.xsId = xsId;
	}

	public String getParentsName() {
		return this.parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public java.util.Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getMobliephone() {
		return this.mobliephone;
	}

	public void setMobliephone(String mobliephone) {
		this.mobliephone = mobliephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParentsCaller() {
		return this.parentsCaller;
	}

	public void setParentsCaller(String parentsCaller) {
		this.parentsCaller = parentsCaller;
	}

	public long getProfessional() {
		return this.professional;
	}

	public void setProfessional(long professional) {
		this.professional = professional;
	}

	public String getWorkaddress() {
		return this.workaddress;
	}

	public void setWorkaddress(String workaddress) {
		this.workaddress = workaddress;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getParentAccounts() {
		return parentAccounts;
	}

	public void setParentAccounts(Set parentAccounts) {
		this.parentAccounts = parentAccounts;
	}
	
	

}