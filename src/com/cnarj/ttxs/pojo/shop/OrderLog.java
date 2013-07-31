package com.cnarj.ttxs.pojo.shop;

import java.util.Date;

/**
 * OrderLog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class OrderLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderlogid;// 订单日志ID
	private Orders orders;// 订单
	private Date createdate;// 创建日期
	private Date modifydate;// 修改日期
	private Long orderlogtype;// 订单日志类型 1会员 2管理员
	private String ordersn;// 订单编号
	private String orderoperator;// 操作员
	private String orderloginfo;// 日志信息

	// Constructors

	/** default constructor */
	public OrderLog() {
	}

	/** full constructor */
	public OrderLog(Orders orders, Date createdate, Date modifydate,
			Long orderlogtype, String ordersn, String orderoperator,
			String orderloginfo) {
		this.orders = orders;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.orderlogtype = orderlogtype;
		this.ordersn = ordersn;
		this.orderoperator = orderoperator;
		this.orderloginfo = orderloginfo;
	}

	// Property accessors

	public String getOrderlogid() {
		return this.orderlogid;
	}

	public void setOrderlogid(String orderlogid) {
		this.orderlogid = orderlogid;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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

	public Long getOrderlogtype() {
		return this.orderlogtype;
	}

	public void setOrderlogtype(Long orderlogtype) {
		this.orderlogtype = orderlogtype;
	}

	public String getOrdersn() {
		return this.ordersn;
	}

	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}

	public String getOrderoperator() {
		return this.orderoperator;
	}

	public void setOrderoperator(String orderoperator) {
		this.orderoperator = orderoperator;
	}

	public String getOrderloginfo() {
		return this.orderloginfo;
	}

	public void setOrderloginfo(String orderloginfo) {
		this.orderloginfo = orderloginfo;
	}

}