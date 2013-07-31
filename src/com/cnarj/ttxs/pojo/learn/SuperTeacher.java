package com.cnarj.ttxs.pojo.learn;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SuperTeacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String superTeacherID;
	private String username;// 姓名
	private String teacherPost;// 职位
	private String inSchool;// 所在学校
	private Long flag;// 状态 0不在职 1在职
	private Long workyears;// 工龄
	private String teaching_linian;// 教学理念
	private String teacherIntroduction;// 自我介绍
	private Long peopleNum;// 人气
	private String teacherPath;// 头像
	private String isenable;// 是否可用 1可用 0不可用
	private Set<SuperAticle> superAticles = new HashSet<SuperAticle>(0);
	
	private Date createDate;// 创建日期
	private Date modifyDate;// 修改日期

	public SuperTeacher(String username, String teacherPost, String inSchool,
			Long flag, Long workyears, String teaching_linian,
			String teacherIntroduction, Long peopleNum, String teacherPath,
			String isenable,Date createdate,Date modifydate) {
		this.username = username;
		this.teacherPost = teacherPost;
		this.inSchool = inSchool;
		this.flag = flag;
		this.workyears = workyears;
		this.teaching_linian = teaching_linian;
		this.teacherIntroduction = teacherIntroduction;
		this.peopleNum = peopleNum;
		this.teacherPath = teacherPath;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getWorkyears() {
		return workyears;
	}

	public String getTeacherPath() {
		return teacherPath;
	}

	public void setTeacherPath(String teacherPath) {
		this.teacherPath = teacherPath;
	}

	public void setWorkyears(Long workyears) {
		this.workyears = workyears;
	}

	public String getTeacherIntroduction() {
		return teacherIntroduction;
	}

	public void setTeacherIntroduction(String teacherIntroduction) {
		this.teacherIntroduction = teacherIntroduction;
	}

	public SuperTeacher() {
	}

	public String getSuperTeacherID() {
		return superTeacherID;
	}

	public void setSuperTeacherID(String superTeacherID) {
		this.superTeacherID = superTeacherID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTeacherPost() {
		return teacherPost;
	}

	public void setTeacherPost(String teacherPost) {
		this.teacherPost = teacherPost;
	}

	public String getInSchool() {
		return inSchool;
	}

	public void setInSchool(String inSchool) {
		this.inSchool = inSchool;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public String getTeaching_linian() {
		return teaching_linian;
	}

	public void setTeaching_linian(String teaching_linian) {
		this.teaching_linian = teaching_linian;
	}

	public Long getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Long peopleNum) {
		this.peopleNum = peopleNum;
	}

	public Set<SuperAticle> getSuperAticles() {
		return superAticles;
	}

	public void setSuperAticles(Set<SuperAticle> superAticles) {
		this.superAticles = superAticles;
	}

	public String getIsenable() {
		return isenable;
	}

	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}

}
