package com.cnarj.ttxs.pojo.dsis;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TStudent entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TStudent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7671162300475472627L;
	
	// Fields
	private Long xsId;
	private TClasses TClasses;
	private String xjBhao;
	private String xsXming;
	private String birthplace;
	private String politicalface;
	private String idcard;
	private String accountplace;
	private String sex;
	private Date birthday;
	private String accommodation;
	private Date dateintosch;
	private String mzhu;
	private String hobby;
	private String personalphoto;
	private String homephone;
	private String zip;
	private String homeaddress;
	private String otherlinks;
	private String healthstate;
	private String xxid;
	private String banganbuid;
	private String ybhao;
	private String status;
	private String isSendSms;
	private Set studentExamResult=new HashSet(0);
	private Set studentAttendanceRecords = new HashSet(0);
	private Set studentBindingMobiles = new HashSet(0);

	// Constructors

	/** default constructor */
	public TStudent() {
	}

	/** minimal constructor */
	public TStudent(TClasses TClasses, String accommodation) {
		this.TClasses = TClasses;
		this.accommodation = accommodation;
	}

	/** full constructor */
	public TStudent(TClasses TClasses, String xjBhao, String xsXming,
			String birthplace, String politicalface, String idcard,
			String accountplace, String sex, Date birthday,
			String accommodation, Date dateintosch, String mzhu, String hobby,
			String personalphoto, String homephone, String zip,
			String homeaddress, String otherlinks, String healthstate,
			String xxid, String banganbuid, String ybhao, String status,
			String isSendSms, Set studentExamresult, Set studentAttendanceRecords,
			Set studentBindingMobiles) {
		
		this.TClasses = TClasses;
		this.xjBhao = xjBhao;
		this.xsXming = xsXming;
		this.birthplace = birthplace;
		this.politicalface = politicalface;
		this.idcard = idcard;
		this.accountplace = accountplace;
		this.sex = sex;
		this.birthday = birthday;
		this.accommodation = accommodation;
		this.dateintosch = dateintosch;
		this.mzhu = mzhu;
		this.hobby = hobby;
		this.personalphoto = personalphoto;
		this.homephone = homephone;
		this.zip = zip;
		this.homeaddress = homeaddress;
		this.otherlinks = otherlinks;
		this.healthstate = healthstate;
		this.xxid = xxid;
		this.banganbuid = banganbuid;
		this.ybhao = ybhao;
		this.status = status;
		this.isSendSms = isSendSms;
		this.studentExamResult = studentExamresult;
		this.studentAttendanceRecords = studentAttendanceRecords;
		this.studentBindingMobiles = studentBindingMobiles;
	}

	// Property accessors

	public Long getXsId() {
		return this.xsId;
	}

	public void setXsId(Long xsId) {
		this.xsId = xsId;
	}


	public TClasses getTClasses() {
		return this.TClasses;
	}

	public void setTClasses(TClasses TClasses) {
		this.TClasses = TClasses;
	}

	public String getXjBhao() {
		return this.xjBhao;
	}

	public void setXjBhao(String xjBhao) {
		this.xjBhao = xjBhao;
	}

	public String getXsXming() {
		return this.xsXming;
	}

	public void setXsXming(String xsXming) {
		this.xsXming = xsXming;
	}

	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getPoliticalface() {
		return this.politicalface;
	}

	public void setPoliticalface(String politicalface) {
		this.politicalface = politicalface;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAccountplace() {
		return this.accountplace;
	}

	public void setAccountplace(String accountplace) {
		this.accountplace = accountplace;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAccommodation() {
		return this.accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public Date getDateintosch() {
		return this.dateintosch;
	}

	public void setDateintosch(Date dateintosch) {
		this.dateintosch = dateintosch;
	}

	public String getMzhu() {
		return this.mzhu;
	}

	public void setMzhu(String mzhu) {
		this.mzhu = mzhu;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getPersonalphoto() {
		return this.personalphoto;
	}

	public void setPersonalphoto(String personalphoto) {
		this.personalphoto = personalphoto;
	}

	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getHomeaddress() {
		return this.homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getOtherlinks() {
		return this.otherlinks;
	}

	public void setOtherlinks(String otherlinks) {
		this.otherlinks = otherlinks;
	}

	public String getHealthstate() {
		return this.healthstate;
	}

	public void setHealthstate(String healthstate) {
		this.healthstate = healthstate;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public String getBanganbuid() {
		return this.banganbuid;
	}

	public void setBanganbuid(String banganbuid) {
		this.banganbuid = banganbuid;
	}

	public String getYbhao() {
		return this.ybhao;
	}

	public void setYbhao(String ybhao) {
		this.ybhao = ybhao;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getIsSendSms() {
		return isSendSms;
	}

	public void setIsSendSms(String isSendSms) {
		this.isSendSms = isSendSms;
	}

	@SuppressWarnings("unchecked")
	public Set getStudentExamResult() {
		return studentExamResult;
	}

	@SuppressWarnings("unchecked")
	public void setStudentExamResult(Set studentExamResult) {
		this.studentExamResult = studentExamResult;
	}

	@SuppressWarnings("unchecked")
	public Set getStudentAttendanceRecords() {
		return studentAttendanceRecords;
	}

	@SuppressWarnings("unchecked")
	public void setStudentAttendanceRecords(Set studentAttendanceRecords) {
		this.studentAttendanceRecords = studentAttendanceRecords;
	}

	@SuppressWarnings("unchecked")
	public Set getStudentBindingMobiles() {
		return studentBindingMobiles;
	}

	@SuppressWarnings("unchecked")
	public void setStudentBindingMobiles(Set studentBindingMobiles) {
		this.studentBindingMobiles = studentBindingMobiles;
	}
    

}