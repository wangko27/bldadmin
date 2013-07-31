package com.cnarj.ttxs.pojo.interest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * ActivityWorks entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ActivityWorks implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String worksid;// 作品ID
	private Member member;// 用户
	private Activity activity;// 活动
	private String worksnumber;// 作品编号
	private String author;// 作者姓名
	private String workstitle;// 作品标题
	private String worksintro;// 作品简介
	private String workscontent;// 作品介绍
	private String showsrc;// 展示图片路径
	private Long votes;// 总票数
	private Date createdate;// 创建时间
	private Date modifydate;// 修改时间
	private Set<ActivityVotes> activityVoteses = new HashSet<ActivityVotes>(0);// 投票记录
	private String facepath;// 封面路径
	private int order;//排名
	private String approstatu;//审核状态 0 审核中 1 审核通过	2 审核未通过
	private String schoolName;//作者的学校
	// Constructors

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/** default constructor */
	public ActivityWorks() {
	}

	/** full constructor */
	public ActivityWorks(Member member, Activity activity, String worksnumber,
			String author, String workstitle, String worksintro,
			String workscontent, String showsrc, Long votes, Date createdate,
			Date modifydate, Set<ActivityVotes> activityVoteses, String facepath,
			String approstatu) {
		this.member = member;
		this.activity = activity;
		this.worksnumber = worksnumber;
		this.author = author;
		this.workstitle = workstitle;
		this.worksintro = worksintro;
		this.workscontent = workscontent;
		this.showsrc = showsrc;
		this.votes = votes;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.activityVoteses = activityVoteses;
		this.facepath = facepath;
		this.approstatu = approstatu;
	}

	// Property accessors

	public String getWorksid() {
		return this.worksid;
	}

	public void setWorksid(String worksid) {
		this.worksid = worksid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getWorksnumber() {
		return this.worksnumber;
	}

	public void setWorksnumber(String worksnumber) {
		this.worksnumber = worksnumber;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getWorkstitle() {
		return this.workstitle;
	}

	public void setWorkstitle(String workstitle) {
		this.workstitle = workstitle;
	}

	public String getWorksintro() {
		return this.worksintro;
	}

	public void setWorksintro(String worksintro) {
		this.worksintro = worksintro;
	}

	public String getWorkscontent() {
		return this.workscontent;
	}

	public void setWorkscontent(String workscontent) {
		this.workscontent = workscontent;
	}

	public String getShowsrc() {
		return this.showsrc;
	}

	public void setShowsrc(String showsrc) {
		this.showsrc = showsrc;
	}

	public Long getVotes() {
		return this.votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
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

	public Set<ActivityVotes> getActivityVoteses() {
		return this.activityVoteses;
	}

	public void setActivityVoteses(Set<ActivityVotes> activityVoteses) {
		this.activityVoteses = activityVoteses;
	}

	public String getFacepath() {
		return facepath;
	}

	public void setFacepath(String facepath) {
		this.facepath = facepath;
	}

	public String getApprostatu() {
		return approstatu;
	}

	public void setApprostatu(String approstatu) {
		this.approstatu = approstatu;
	}

}