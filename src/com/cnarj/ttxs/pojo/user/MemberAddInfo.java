package com.cnarj.ttxs.pojo.user;

import java.util.Date;


/**
 * MemberAttribute entity. @author MyEclipse Persistence Tools
 */

public class MemberAddInfo  implements java.io.Serializable {

    // Fields    

     
	 private static final long serialVersionUID = -384970497331809934L;
	
	 private String addinfoid;
     private Member member;
     private String phone;
     private String inaddr;
     private String realname;
     private String childname;
     private String school;
     private String grade;
     private String classes;
     private String postoffice;
     private Long mage;//年龄
     private String sex;//性别
     private String identity;//身份



    // Constructors
	/** default constructor */
    public MemberAddInfo() {
    	
    }

    /** full constructor */
    public MemberAddInfo(String addinfoid, Member member, String phone,
			String inaddr, String realname, String childname, String school,
			String grade, String classes, String postoffice, Long mage,
			String sex, String identity) {
		super();
		this.addinfoid = addinfoid;
		this.member = member;
		this.phone = phone;
		this.inaddr = inaddr;
		this.realname = realname;
		this.childname = childname;
		this.school = school;
		this.grade = grade;
		this.classes = classes;
		this.postoffice = postoffice;
		this.mage = mage;
		this.sex = sex;
		this.identity = identity;
	}

	public String getAddinfoid() {
		return addinfoid;
	}

	public void setAddinfoid(String addinfoid) {
		this.addinfoid = addinfoid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInaddr() {
		return inaddr;
	}

	public void setInaddr(String inaddr) {
		this.inaddr = inaddr;
	}
	
	public String getRealname() {
		return realname;
	}
	
	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getChildname() {
		return childname;
	}

	public void setChildname(String childname) {
		this.childname = childname;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}
	public Long getMage() {
		return mage;
	}

	public void setMage(Long mage) {
		this.mage = mage;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
    // Property accessors


}