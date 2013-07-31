package com.cnarj.ttxs.pojo.dsis;

import java.util.HashSet;
import java.util.Set;

/**
 * BasicAttendanceSet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BasicAttendanceSet implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8542060670883666672L;
	private Long basicAttenId;
	private String attenName;
	private String inOutSign;
	private String flag;
	private String xxid;
	private Set studentAttendanceSets = new HashSet(0);
	private int alreadyReadCardNum = 0;//�Ѷ�����
	private int notReadCardNum = 0;//δ������
	

	// Constructors

	/** default constructor */
	public BasicAttendanceSet() {
	}

	/** minimal constructor */
	public BasicAttendanceSet(String attenName) {
		this.attenName = attenName;
	}

	/** full constructor */
	public BasicAttendanceSet(String attenName, String inOutSign, String flag,
			String xxid, Set studentAttendanceSets, int alreadyReadCardNum,
			int notReadCardNum) {
		this.attenName = attenName;
		this.inOutSign = inOutSign;
		this.flag = flag;
		this.xxid = xxid;
		this.studentAttendanceSets = studentAttendanceSets;
		this.alreadyReadCardNum = alreadyReadCardNum;
		this.notReadCardNum = notReadCardNum;
	}

	// Property accessors

	public Long getBasicAttenId() {
		return this.basicAttenId;
	}

	public void setBasicAttenId(Long basicAttenId) {
		this.basicAttenId = basicAttenId;
	}

	public String getAttenName() {
		return this.attenName;
	}

	public void setAttenName(String attenName) {
		this.attenName = attenName;
	}

	public String getInOutSign() {
		return this.inOutSign;
	}

	public void setInOutSign(String inOutSign) {
		this.inOutSign = inOutSign;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public Set getStudentAttendanceSets() {
		return this.studentAttendanceSets;
	}

	public void setStudentAttendanceSets(Set studentAttendanceSets) {
		this.studentAttendanceSets = studentAttendanceSets;
	}

	public int getAlreadyReadCardNum() {
		return alreadyReadCardNum;
	}

	public void setAlreadyReadCardNum(int alreadyReadCardNum) {
		this.alreadyReadCardNum = alreadyReadCardNum;
	}

	public int getNotReadCardNum() {
		return notReadCardNum;
	}

	public void setNotReadCardNum(int notReadCardNum) {
		this.notReadCardNum = notReadCardNum;
	}

	
}