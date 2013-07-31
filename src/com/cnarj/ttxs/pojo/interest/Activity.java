package com.cnarj.ttxs.pojo.interest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Activity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Activity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int isState;

	private String activityid;// 活动ID
	private String activitytitle;// 活动标题
	private String activityintro;// 活动简介
	private String activitysrc;// 标题图片路径
	private Date createdate;// 创建日期
	private Date modifydate;// 修改日期
	private Date begindate;// 开始时间
	private Date enddate;// 结束时间
	private String isshowpic;// 是否显示活动介绍图片 1显示 0不显示
	private ActivityPrograma programa;// 活动栏目
	private ActivityType activityType;// 类别
	private Set<ActivityTeacher> activityTeachers = new HashSet<ActivityTeacher>(
			0);// 指导老师
	private Set<ActivityWorks> activityWorkses = new HashSet<ActivityWorks>(0);// 活动作品

	private String sysnotesid;// [系统文章类别]活动公告类别ID
	private String industryid;// [系统文章类别]行业知识类别ID
	private String unlinepath;// 线下图片路径（相对路径）
	private String activetypeid;// [系统文章类别]活动类别ID

	/* 2011年9月6日20:22:06 sly */
	private String activitycode = "";
	private Long activitySeq = new Long("0");

	private String activityfeaphotopath;// 活动专题图片
	private String activityrule;// 活动规则

	// Constructors

	/** default constructor */
	public Activity() {
	}

	public int getIsState() {
		return isState;
	}

	public void setIsState(int isState) {
		this.isState = isState;
	}

	/** full constructor */
	public Activity(String activitytitle, String activityintro,
			String activitysrc, Date createdate, Date modifydate,
			Set<ActivityTeacher> activityTeachers, ActivityPrograma programa,
			Set<ActivityWorks> activityWorkses, ActivityType activityType,
			String sysnotesid, String industryid, String unlinepath,
			String activetypeid, String activitydode, Long activitySeq,
			String activityfeaphotopath, String activityrule) {
		this.activitytitle = activitytitle;
		this.activityintro = activityintro;
		this.activitysrc = activitysrc;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.activityTeachers = activityTeachers;
		this.programa = programa;
		this.activityWorkses = activityWorkses;
		this.activityType = activityType;
		this.sysnotesid = sysnotesid;
		this.industryid = industryid;
		this.unlinepath = unlinepath;
		this.activetypeid = activetypeid;
		this.activitycode = activitydode;
		this.activitySeq = activitySeq;
		this.activityfeaphotopath = activityfeaphotopath;
		this.activityrule = activityrule;
	}

	// Property accessors

	public String getActivityid() {
		return this.activityid;
	}

	public void setActivityid(String activityid) {
		this.activityid = activityid;
	}

	public String getActivitytitle() {
		return this.activitytitle;
	}

	public void setActivitytitle(String activitytitle) {
		this.activitytitle = activitytitle;
	}

	public String getActivityintro() {
		return this.activityintro;
	}

	public void setActivityintro(String activityintro) {
		this.activityintro = activityintro;
	}

	public String getActivitysrc() {
		return this.activitysrc;
	}

	public void setActivitysrc(String activitysrc) {
		this.activitysrc = activitysrc;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public Set<ActivityTeacher> getActivityTeachers() {
		return this.activityTeachers;
	}

	public void setActivityTeachers(Set<ActivityTeacher> activityTeachers) {
		this.activityTeachers = activityTeachers;
	}

	public Set<ActivityWorks> getActivityWorkses() {
		return this.activityWorkses;
	}

	public void setActivityWorkses(Set<ActivityWorks> activityWorkses) {
		this.activityWorkses = activityWorkses;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getIsshowpic() {
		return isshowpic;
	}

	public void setIsshowpic(String isshowpic) {
		this.isshowpic = isshowpic;
	}

	public ActivityPrograma getPrograma() {
		return programa;
	}

	public void setPrograma(ActivityPrograma programa) {
		this.programa = programa;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public String getSysnotesid() {
		return sysnotesid;
	}

	public void setSysnotesid(String sysnotesid) {
		this.sysnotesid = sysnotesid;
	}

	public String getIndustryid() {
		return industryid;
	}

	public void setIndustryid(String industryid) {
		this.industryid = industryid;
	}

	public String getUnlinepath() {
		return unlinepath;
	}

	public void setUnlinepath(String unlinepath) {
		this.unlinepath = unlinepath;
	}

	public String getActivetypeid() {
		return activetypeid;
	}

	public void setActivetypeid(String activetypeid) {
		this.activetypeid = activetypeid;
	}

	public String getActivitycode() {
		return activitycode;
	}

	public void setActivitycode(String activitycode) {
		this.activitycode = activitycode;
	}

	public Long getActivitySeq() {
		return activitySeq;
	}

	public void setActivitySeq(Long activitySeq) {
		this.activitySeq = activitySeq;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getActivityfeaphotopath() {
		return activityfeaphotopath;
	}

	public void setActivityfeaphotopath(String activityfeaphotopath) {
		this.activityfeaphotopath = activityfeaphotopath;
	}

	public String getActivityrule() {
		return activityrule;
	}

	public void setActivityrule(String activityrule) {
		this.activityrule = activityrule;
	}

}