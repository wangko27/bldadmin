package com.cnarj.ttxs.pojo.learn;

import java.io.Serializable;
import java.util.Date;

import com.cnarj.ttxs.pojo.comm.ArticleSrc;

public class SuperAticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String superAticleID;
	private String articletitle;// 文章标题
	private SuperTeacher superTeacher;// 名师
	private ArticleSrc articleSrc = new ArticleSrc();// 文章
	private Long flag;// 文章类别 1图片+文字 2视频+文字 3文字 (此项必填)
	private Date createDate;// 创建日期
	private Date modifyDate;// 修改日期
	private String isenable;// 是否可用 1可用 0不可用

	public SuperAticle() {
	}

	public String getArticletitle() {
		return articletitle;
	}

	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	public SuperAticle(String articletitle, SuperTeacher superTeacher,
			ArticleSrc articleSrcId, Long flag, Date createDate,
			Date modifyDate, String isenable) {
		this.articletitle = articletitle;
		this.superTeacher = superTeacher;
		this.articleSrc = articleSrcId;
		this.flag = flag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.isenable = isenable;
	}

	public ArticleSrc getArticleSrcId() {
		return articleSrc;
	}

	public ArticleSrc getArticleSrc() {
		return articleSrc;
	}

	public String getSuperAticleID() {
		return superAticleID;
	}

	public void setSuperAticleID(String superAticleID) {
		this.superAticleID = superAticleID;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
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

	public SuperTeacher getSuperTeacher() {
		return superTeacher;
	}

	public void setSuperTeacher(SuperTeacher superTeacher) {
		this.superTeacher = superTeacher;
	}

	public void setArticleSrc(ArticleSrc articleSrc) {
		this.articleSrc = articleSrc;
	}

	public String getIsenable() {
		return isenable;
	}

	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}

}
