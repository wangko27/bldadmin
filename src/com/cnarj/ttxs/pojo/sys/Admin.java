package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private String adminid;// 管理员ID
	private String username;// 用户名
	private String adminpassword;// 密码
	private String email;// E-mail
	private String adminname;// 姓名
	private String department;// 部门
	private String isaccountenabled;// 账号是否启用 1启用 0不启用
	private String isaccountlocked;// 账号是否锁定 1未锁定 0锁定
	private String isaccountexpired;// 账号是否过期 1未过期 0已过期
	private String iscredentialsexpired;// 凭证是否过期 1未过期 0已过期
	private Long loginfailurecount;// 连续登录失败的次数
	private Date lockeddate;// 账号锁定日期
	private Date logindate;// 最后登录日期
	private String loginip;// 最后登录IP
	private Date createdate;// 创建日期
	private Date modifydate;// 修改日期
	private Set msgInfos = new HashSet(0);
	private Set articles = new HashSet(0);
	private Set advInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String username, String adminpassword, String email,
			String adminname, String department, String isaccountenabled,
			String isaccountlocked, String isaccountexpired,
			String iscredentialsexpired, Long loginfailurecount,
			Date lockeddate, Date logindate, String loginip, Date createdate,
			Date modifydate, Set msgInfos, Set articles, Set advInfos) {
		this.username = username;
		this.adminpassword = adminpassword;
		this.email = email;
		this.adminname = adminname;
		this.department = department;
		this.isaccountenabled = isaccountenabled;
		this.isaccountlocked = isaccountlocked;
		this.isaccountexpired = isaccountexpired;
		this.iscredentialsexpired = iscredentialsexpired;
		this.loginfailurecount = loginfailurecount;
		this.lockeddate = lockeddate;
		this.logindate = logindate;
		this.loginip = loginip;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.msgInfos = msgInfos;
		this.articles = articles;
		this.advInfos = advInfos;
	}

	// Property accessors

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdminpassword() {
		return this.adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIsaccountenabled() {
		return this.isaccountenabled;
	}

	public void setIsaccountenabled(String isaccountenabled) {
		this.isaccountenabled = isaccountenabled;
	}

	public String getIsaccountlocked() {
		return this.isaccountlocked;
	}

	public void setIsaccountlocked(String isaccountlocked) {
		this.isaccountlocked = isaccountlocked;
	}

	public String getIsaccountexpired() {
		return this.isaccountexpired;
	}

	public void setIsaccountexpired(String isaccountexpired) {
		this.isaccountexpired = isaccountexpired;
	}

	public String getIscredentialsexpired() {
		return this.iscredentialsexpired;
	}

	public void setIscredentialsexpired(String iscredentialsexpired) {
		this.iscredentialsexpired = iscredentialsexpired;
	}

	public Long getLoginfailurecount() {
		return this.loginfailurecount;
	}

	public void setLoginfailurecount(Long loginfailurecount) {
		this.loginfailurecount = loginfailurecount;
	}

	public Date getLockeddate() {
		return this.lockeddate;
	}

	public void setLockeddate(Date lockeddate) {
		this.lockeddate = lockeddate;
	}

	public Date getLogindate() {
		return this.logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}

	public String getLoginip() {
		return this.loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public Set getMsgInfos() {
		return this.msgInfos;
	}

	public void setMsgInfos(Set msgInfos) {
		this.msgInfos = msgInfos;
	}

	public Set getArticles() {
		return this.articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

	public Set getAdvInfos() {
		return this.advInfos;
	}

	public void setAdvInfos(Set advInfos) {
		this.advInfos = advInfos;
	}

}