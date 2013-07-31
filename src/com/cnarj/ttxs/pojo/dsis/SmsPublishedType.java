package com.cnarj.ttxs.pojo.dsis;


/**
 * SmsPublishedType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SmsPublishedType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long publishTypeId;
	private String categoryName;
	private long displayWay;
	private String xxid;
	private long objectType;

	// Constructors

	/** default constructor */
	public SmsPublishedType() {
	}

	/** minimal constructor */
	public SmsPublishedType(String categoryName) {
		this.categoryName = categoryName;
	}

	/** full constructor */
	public SmsPublishedType(String categoryName, long displayWay, String xxid,
			long objectType) {
		this.categoryName = categoryName;
		this.displayWay = displayWay;
		this.xxid = xxid;
		this.objectType = objectType;
	}

	// Property accessors

	public Long getPublishTypeId() {
		return this.publishTypeId;
	}

	public void setPublishTypeId(Long publishTypeId) {
		this.publishTypeId = publishTypeId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getDisplayWay() {
		return this.displayWay;
	}

	public void setDisplayWay(long displayWay) {
		this.displayWay = displayWay;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public long getObjectType() {
		return this.objectType;
	}

	public void setObjectType(long objectType) {
		this.objectType = objectType;
	}


}