package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * Goods entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GoodsRat implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String goodratid;
	private String ratmsg;
	private String nikename;
	private String flag;
	private String memberip;
	
	private Member member;
	private Goods good;
	
	private Date createdate;
	private Date modifydate;
	
	
	/** default constructor */
	public GoodsRat() {
		super();
	}

	/** full constructor */
	public GoodsRat(String goodratid, String ratmsg, String nikename,
			String flag, String memberip, Member member, Goods good,
			Date createdate, Date modifydate) {
		this.ratmsg = ratmsg;
		this.nikename = nikename;
		this.flag = flag;
		this.memberip = memberip;
		this.member = member;
		this.good = good;
		this.createdate = createdate;
		this.modifydate = modifydate;
	}

	public String getGoodratid() {
		return goodratid;
	}

	public void setGoodratid(String goodratid) {
		this.goodratid = goodratid;
	}

	public String getRatmsg() {
		return ratmsg;
	}

	public void setRatmsg(String ratmsg) {
		this.ratmsg = ratmsg;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMemberip() {
		return memberip;
	}

	public void setMemberip(String memberip) {
		this.memberip = memberip;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	// Property accessors

}