package com.cnarj.ttxs.pojo.learn;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;

/**
 * ReadSrcDownRec entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ReadSrcDownRec implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields

	private String downrecid;// 主键
	private ReadSrc readSrc;// 资源
	private Member member;// 用户
	private Long downrecpoint;// 下载积分
	private Date downloaddate;// 下载时间
	private String iscommented;// 是否已经评论 0未评论 1已评论
	private String israting;// 是否已评分 0未评分 1已评分

	// Constructors

	/** default constructor */
	public ReadSrcDownRec() {
	}

	/** full constructor */
	public ReadSrcDownRec(ReadSrc readSrc, Member member, Long downrecpoint,
			Date downloaddate, String iscommented, String israting) {
		this.readSrc = readSrc;
		this.member = member;
		this.downrecpoint = downrecpoint;
		this.downloaddate = downloaddate;
		this.iscommented = iscommented;
		this.israting = israting;
	}

	// Property accessors

	public String getDownrecid() {
		return this.downrecid;
	}

	public void setDownrecid(String downrecid) {
		this.downrecid = downrecid;
	}

	public ReadSrc getReadSrc() {
		return this.readSrc;
	}

	public void setReadSrc(ReadSrc readSrc) {
		this.readSrc = readSrc;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Long getDownrecpoint() {
		return this.downrecpoint;
	}

	public void setDownrecpoint(Long downrecpoint) {
		this.downrecpoint = downrecpoint;
	}

	public Date getDownloaddate() {
		return this.downloaddate;
	}

	public void setDownloaddate(Date downloaddate) {
		this.downloaddate = downloaddate;
	}

	public String getIscommented() {
		return this.iscommented;
	}

	public void setIscommented(String iscommented) {
		this.iscommented = iscommented;
	}

	public String getIsrating() {
		return this.israting;
	}

	public void setIsrating(String israting) {
		this.israting = israting;
	}

}