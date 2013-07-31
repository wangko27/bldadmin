package com.cnarj.ttxs.pojo.dsis;

/**
 * RStudentAttencard entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RStudentAttencard implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2835858402685179104L;
	private Long stuAttenId;
	private TStudent TStudent;
	private String bindCardid;

	// Constructors

	/** default constructor */
	public RStudentAttencard() {
	}

	/** minimal constructor */
	public RStudentAttencard(String bindCardid) {
		this.bindCardid = bindCardid;
	}

	/** full constructor */
	public RStudentAttencard(TStudent TStudent, String bindCardid) {
		this.TStudent = TStudent;
		this.bindCardid = bindCardid;
	}

	// Property accessors

	public Long getStuAttenId() {
		return this.stuAttenId;
	}

	public void setStuAttenId(Long stuAttenId) {
		this.stuAttenId = stuAttenId;
	}

	public TStudent getTStudent() {
		return this.TStudent;
	}

	public void setTStudent(TStudent TStudent) {
		this.TStudent = TStudent;
	}

	public String getBindCardid() {
		return this.bindCardid;
	}

	public void setBindCardid(String bindCardid) {
		this.bindCardid = bindCardid;
	}

}