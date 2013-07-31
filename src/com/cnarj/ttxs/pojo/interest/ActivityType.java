package com.cnarj.ttxs.pojo.interest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ActivityType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String typeId;// 类别ID
	private String typeName;// 类别名称
	private Date typeCreatedate;// 创建时间
	private Date typeUpdatedate;// 修改时间
	private ActivityPrograma programa;// 所属栏目 为空为公用
	private Set<Activity> activitys = new HashSet<Activity>(0);// 活动

	public ActivityType() {
		super();
	}

	public ActivityType(String typeId, String typeName, Date typeCreatedate,
			Date typeUpdatedate, ActivityPrograma programa,
			Set<Activity> activitys) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeCreatedate = typeCreatedate;
		this.typeUpdatedate = typeUpdatedate;
		this.programa = programa;
		this.activitys = activitys;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getTypeCreatedate() {
		return typeCreatedate;
	}

	public void setTypeCreatedate(Date typeCreatedate) {
		this.typeCreatedate = typeCreatedate;
	}

	public Date getTypeUpdatedate() {
		return typeUpdatedate;
	}

	public void setTypeUpdatedate(Date typeUpdatedate) {
		this.typeUpdatedate = typeUpdatedate;
	}

	public ActivityPrograma getPrograma() {
		return programa;
	}

	public void setPrograma(ActivityPrograma programa) {
		this.programa = programa;
	}

	public Set<Activity> getActivitys() {
		return activitys;
	}

	public void setActivitys(Set<Activity> activitys) {
		this.activitys = activitys;
	}

}
