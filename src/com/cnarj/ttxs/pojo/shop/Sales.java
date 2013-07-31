package com.cnarj.ttxs.pojo.shop;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * 商品销售情况
 * 
 * @author 唐其
 * 
 */
public class Sales implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String salesid;// 销售ID
	private Goods goods;// 购买的商品
	private Member member;// 购买者用户
	private String username;// 购买者用户姓名
	private String userip;// 购买时Ip
	private Date buydate;// 购买时间
	private Long unitprice;// 购买时商品单价
	private Long buynum;// 购买数量

	public Sales() {
		super();
	}

	public Sales(String salesid, Goods goods, Member member, String username,
			String userip, Date buydate, Long unitprice, Long buynum) {
		super();
		this.salesid = salesid;
		this.goods = goods;
		this.member = member;
		this.username = username;
		this.userip = userip;
		this.buydate = buydate;
		this.unitprice = unitprice;
		this.buynum = buynum;
	}

	public Sales(String salesid, Goods goods, String userip, Long unitprice) {
		this.salesid = salesid;
		this.goods = goods;
		this.userip = userip;
		this.unitprice = unitprice;
	}

	public String getSalesid() {
		return salesid;
	}

	public void setSalesid(String salesid) {
		this.salesid = salesid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public Date getBuydate() {
		return buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	public Long getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Long unitprice) {
		this.unitprice = unitprice;
	}

	public Long getBuynum() {
		return buynum;
	}

	public void setBuynum(Long buynum) {
		this.buynum = buynum;
	}

}
