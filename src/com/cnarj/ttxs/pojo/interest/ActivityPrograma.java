package com.cnarj.ttxs.pojo.interest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ActivityNumber entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ActivityPrograma implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	// Fields

	private String proID;// 栏目ID
	private String proName;// 栏目名称
	private String proUrl;// 栏目URL
	private Long proIsenable;// 是否启用
	private Long proSort;// 排序
	private Date proCreatedate;// 创建时间
	private Date proUpdatedate;// 修改时间
	private Set<Activity> activitys = new HashSet<Activity>(0);
	private Set<ActivityType> activityTypes = new HashSet<ActivityType>(0);
	private String proProgramatypeid;// [系统文章类别]活动栏目类别ID

	// Constructors

	/** default constructor */
	public ActivityPrograma() {
	}

	/** full constructor */
	public ActivityPrograma(String proID, String proName, String proUrl,
			Long proIsenable, Long proSort, Date proCreatedate,
			Date proUpdatedate, Set<Activity> activitys,
			Set<ActivityType> activityTypes, String proProgramatypeid) {
		super();
		this.proID = proID;
		this.proName = proName;
		this.proUrl = proUrl;
		this.proIsenable = proIsenable;
		this.proSort = proSort;
		this.proCreatedate = proCreatedate;
		this.proUpdatedate = proUpdatedate;
		this.activitys = activitys;
		this.activityTypes = activityTypes;
		this.proProgramatypeid = proProgramatypeid;
	}

	// Property accessors

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProUrl() {
		return proUrl;
	}

	public void setProUrl(String proUrl) {
		this.proUrl = proUrl;
	}

	public Long getProIsenable() {
		return proIsenable;
	}

	public void setProIsenable(Long proIsenable) {
		this.proIsenable = proIsenable;
	}

	public Long getProSort() {
		return proSort;
	}

	public void setProSort(Long proSort) {
		this.proSort = proSort;
	}

	public Date getProCreatedate() {
		return proCreatedate;
	}

	public void setProCreatedate(Date proCreatedate) {
		this.proCreatedate = proCreatedate;
	}

	public Date getProUpdatedate() {
		return proUpdatedate;
	}

	public void setProUpdatedate(Date proUpdatedate) {
		this.proUpdatedate = proUpdatedate;
	}

	public Set<Activity> getActivitys() {
		return activitys;
	}

	public void setActivitys(Set<Activity> activitys) {
		this.activitys = activitys;
	}

	public Set<ActivityType> getActivityTypes() {
		return activityTypes;
	}

	public void setActivityTypes(Set<ActivityType> activityTypes) {
		this.activityTypes = activityTypes;
	}

	public String getProProgramatypeid() {
		return proProgramatypeid;
	}

	public void setProProgramatypeid(String proProgramatypeid) {
		this.proProgramatypeid = proProgramatypeid;
	}

}