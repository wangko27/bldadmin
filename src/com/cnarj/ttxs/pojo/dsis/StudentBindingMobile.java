package com.cnarj.ttxs.pojo.dsis;

/**
 * StudentBindingMobile entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class StudentBindingMobile implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4945873234607178448L;
	private Long bindMobileId;
	private TStudent TStudent = new TStudent();
	private String mobile;
	private String phoneCardType;
	private String mainAssiType;
	private String holdCardName;
	private String relation;
	private String bindType;

	// Constructors

	/** default constructor */
	public StudentBindingMobile() {
	}

	/** minimal constructor */
	public StudentBindingMobile(TStudent TStudent) {
		this.TStudent = TStudent;
	}

	/** full constructor */
	public StudentBindingMobile(TStudent TStudent, String mobile,
			String phoneCardType, String mainAssiType, String holdCardName,
			String relation, String bindType) {
		this.TStudent = TStudent;
		this.mobile = mobile;
		this.phoneCardType = phoneCardType;
		this.mainAssiType = mainAssiType;
		this.holdCardName = holdCardName;
		this.relation = relation;
		this.bindType = bindType;
	}

	// Property accessors

	public Long getBindMobileId() {
		return this.bindMobileId;
	}

	public void setBindMobileId(Long bindMobileId) {
		this.bindMobileId = bindMobileId;
	}

	public TStudent getTStudent() {
		return this.TStudent;
	}

	public void setTStudent(TStudent TStudent) {
		this.TStudent = TStudent;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhoneCardType() {
		return this.phoneCardType;
	}

	public void setPhoneCardType(String phoneCardType) {
		this.phoneCardType = phoneCardType;
	}

	public String getMainAssiType() {
		return this.mainAssiType;
	}

	public void setMainAssiType(String mainAssiType) {
		this.mainAssiType = mainAssiType;
	}

	public String getHoldCardName() {
		return this.holdCardName;
	}

	public void setHoldCardName(String holdCardName) {
		this.holdCardName = holdCardName;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getBindType() {
		return this.bindType;
	}

	public void setBindType(String bindType) {
		this.bindType = bindType;
	}

}