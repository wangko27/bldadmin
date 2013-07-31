package com.cnarj.ttxs.pojo.interest;

import java.util.Date;

public class ActivityWorksType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String typeId;// 类别ID
	private String typeName;// 类别名称
	private Date typeCreatedate;// 创建时间
	private Date typeUpdatedate;// 修改时间
	private ActivityPrograma programa;// 所属栏目 为空为公用

	public ActivityWorksType() {
		super();
	}

	public ActivityWorksType(String typeId, String typeName,
			Date typeCreatedate, Date typeUpdatedate, ActivityPrograma programa) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeCreatedate = typeCreatedate;
		this.typeUpdatedate = typeUpdatedate;
		this.programa = programa;
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

}
