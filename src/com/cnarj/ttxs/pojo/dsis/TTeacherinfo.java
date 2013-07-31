package com.cnarj.ttxs.pojo.dsis;

import java.util.HashSet;
import java.util.Set;

/**
 * TTeacherinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TTeacherinfo implements java.io.Serializable {

	// Fields

	private long teacherid;
	private String name;
	private long sex;
	private String birthday;
	private long jobtilte;
	private long education;
	private String graduatesch;//��ҵѧУ
	private String duties;//��Уְ��
	private String resume;//���˼���
	private String photo;//������Ƭ
	private String officephone;//�칫�绰
	private String fax;//�칫����
	private String homephone;//��ͥ�绰
	private String moblie;//�ֻ�
	private String email;//�����ʼ�
	private String zipcode;//��ͥ�ʱ�
	private String address;//��ͥ��ַ
	private String otherlinks;//����jϵ
	private String xxid;
	private Set RTeacherClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TTeacherinfo() {
	}

	/** minimal constructor */
	public TTeacherinfo(String name, long sex) {
		
		this.name = name;
		this.sex = sex;
	}

	/** full constructor */
	public TTeacherinfo(String name,
			long sex, String birthday, long jobtilte, long education,
			String graduatesch, String duties, String resume, String photo,
			String officephone, String fax, String homephone, String moblie,
			String email, String zipcode, String address, String otherlinks,
			String xxid, Set RTeacherClasses) {
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.jobtilte = jobtilte;
		this.education = education;
		this.graduatesch = graduatesch;
		this.duties = duties;
		this.resume = resume;
		this.photo = photo;
		this.officephone = officephone;
		this.fax = fax;
		this.homephone = homephone;
		this.moblie = moblie;
		this.email = email;
		this.zipcode = zipcode;
		this.address = address;
		this.otherlinks = otherlinks;
		this.xxid = xxid;
		this.RTeacherClasses = RTeacherClasses;
	}

	// Property accessors

	public long getTeacherid() {
		return this.teacherid;
	}

	public void setTeacherid(long teacherid) {
		this.teacherid = teacherid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSex() {
		return this.sex;
	}

	public void setSex(long sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public long getJobtilte() {
		return this.jobtilte;
	}

	public void setJobtilte(long jobtilte) {
		this.jobtilte = jobtilte;
	}

	public long getEducation() {
		return this.education;
	}

	public void setEducation(long education) {
		this.education = education;
	}

	public String getGraduatesch() {
		return this.graduatesch;
	}

	public void setGraduatesch(String graduatesch) {
		this.graduatesch = graduatesch;
	}

	public String getDuties() {
		return this.duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getMoblie() {
		return this.moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOtherlinks() {
		return this.otherlinks;
	}

	public void setOtherlinks(String otherlinks) {
		this.otherlinks = otherlinks;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	@SuppressWarnings("unchecked")
	public Set getRTeacherClasses() {
		return this.RTeacherClasses;
	}

	@SuppressWarnings("unchecked")
	public void setRTeacherClasses(Set RTeacherClasses) {
		this.RTeacherClasses = RTeacherClasses;
	}


}