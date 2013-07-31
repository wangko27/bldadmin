package com.cnarj.ttxs.pojo.shop;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private String orderid;// 订单ID
	private DeliveryType deliveryType;// 配送方式
	private Payment payment;// 支付方式
	private Member member;// 会员
	private String ordersn;// 订单编号
	private Long orderstatus;// 订单状态 1交易成功 2等待付款 3已付款 未发货 4已付款 已发货 5已取消 6退款中 7已退款
	private Long paymentstatus;// 支付状态 0未支付 1已支付
	private Long shippingstatus;// 发货状态 0未发货 1已发货
	private String deliverytypename;// 配送方式名称
	private String paymentconfigname;// 支付方式名称
	private Long producttotalprice;// 商品总价格
	private Long deliveryfee;// 配送费用
	private Long paymentfee;// 支付费用
	private Long totalamount;// 订单总额
	private Long paidamount;// 已付金额
	private Long productweight;// 商品重量
	private Long productweightunit;// 商品重量单位
	private Long producttotalquantity;// 商品总数
	private String shipname;// 收货人姓名
	private String shiparea;// 收货地区
	private String shipareapath;// 收货地区路径
	private String shipaddress;// 收货地址
	private String shipzipcode;// 收货邮编
	private String shipphone;// 收货电话
	private String shipmobile;// 收货手机
	private String ordermemo;// 附言
	private Date createdate;// 创建日期
	private Date modifydate;// 修改日期
	
	private String israt;//是否评论
	
	private Set refunds = new HashSet(0);
	private Set shippings = new HashSet(0);
	private Set orderLogs = new HashSet(0);
	private Set payments = new HashSet(0);
	private Set reships = new HashSet(0);
	
	
	
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(DeliveryType deliveryType, Payment payment, Member member,
			String ordersn, Long orderstatus, Long paymentstatus,
			Long shippingstatus, String deliverytypename,
			String paymentconfigname, Long producttotalprice, Long deliveryfee,
			Long paymentfee, Long totalamount, Long paidamount,
			Long productweight, Long productweightunit,
			Long producttotalquantity, String shipname, String shiparea,
			String shipareapath, String shipaddress, String shipzipcode,
			String shipphone, String shipmobile, String ordermemo,
			Date createdate, Date modifydate, Set refunds, Set shippings,
			Set orderLogs, Set payments, Set reships,Set orderitems,String israt) {
		this.deliveryType = deliveryType;
		this.payment = payment;
		this.member = member;
		this.ordersn = ordersn;
		this.orderstatus = orderstatus;
		this.paymentstatus = paymentstatus;
		this.shippingstatus = shippingstatus;
		this.deliverytypename = deliverytypename;
		this.paymentconfigname = paymentconfigname;
		this.producttotalprice = producttotalprice;
		this.deliveryfee = deliveryfee;
		this.paymentfee = paymentfee;
		this.totalamount = totalamount;
		this.paidamount = paidamount;
		this.productweight = productweight;
		this.productweightunit = productweightunit;
		this.producttotalquantity = producttotalquantity;
		this.shipname = shipname;
		this.shiparea = shiparea;
		this.shipareapath = shipareapath;
		this.shipaddress = shipaddress;
		this.shipzipcode = shipzipcode;
		this.shipphone = shipphone;
		this.shipmobile = shipmobile;
		this.ordermemo = ordermemo;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.refunds = refunds;
		this.shippings = shippings;
		this.orderLogs = orderLogs;
		this.payments = payments;
		this.reships = reships;
		this.israt = israt;
		
		this.orderitems = orderitems;
	}

	// Property accessors

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public DeliveryType getDeliveryType() {
		return this.deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getOrdersn() {
		return this.ordersn;
	}

	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}

	public Long getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(Long orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Long getPaymentstatus() {
		return this.paymentstatus;
	}

	public void setPaymentstatus(Long paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Long getShippingstatus() {
		return this.shippingstatus;
	}

	public void setShippingstatus(Long shippingstatus) {
		this.shippingstatus = shippingstatus;
	}

	public String getDeliverytypename() {
		return this.deliverytypename;
	}

	public void setDeliverytypename(String deliverytypename) {
		this.deliverytypename = deliverytypename;
	}

	public String getPaymentconfigname() {
		return this.paymentconfigname;
	}

	public void setPaymentconfigname(String paymentconfigname) {
		this.paymentconfigname = paymentconfigname;
	}

	public Long getProducttotalprice() {
		return this.producttotalprice;
	}

	public void setProducttotalprice(Long producttotalprice) {
		this.producttotalprice = producttotalprice;
	}

	public Long getDeliveryfee() {
		return this.deliveryfee;
	}

	public void setDeliveryfee(Long deliveryfee) {
		this.deliveryfee = deliveryfee;
	}

	public Long getPaymentfee() {
		return this.paymentfee;
	}

	public void setPaymentfee(Long paymentfee) {
		this.paymentfee = paymentfee;
	}

	public Long getTotalamount() {
		return this.totalamount;
	}

	public void setTotalamount(Long totalamount) {
		this.totalamount = totalamount;
	}

	public Long getPaidamount() {
		return this.paidamount;
	}

	public void setPaidamount(Long paidamount) {
		this.paidamount = paidamount;
	}

	public Long getProductweight() {
		return this.productweight;
	}

	public void setProductweight(Long productweight) {
		this.productweight = productweight;
	}

	public Long getProductweightunit() {
		return this.productweightunit;
	}

	public void setProductweightunit(Long productweightunit) {
		this.productweightunit = productweightunit;
	}

	public Long getProducttotalquantity() {
		return this.producttotalquantity;
	}

	public void setProducttotalquantity(Long producttotalquantity) {
		this.producttotalquantity = producttotalquantity;
	}

	public String getShipname() {
		return this.shipname;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public String getShiparea() {
		return this.shiparea;
	}

	public void setShiparea(String shiparea) {
		this.shiparea = shiparea;
	}

	public String getShipareapath() {
		return this.shipareapath;
	}

	public void setShipareapath(String shipareapath) {
		this.shipareapath = shipareapath;
	}

	public String getShipaddress() {
		return this.shipaddress;
	}

	public void setShipaddress(String shipaddress) {
		this.shipaddress = shipaddress;
	}

	public String getShipzipcode() {
		return this.shipzipcode;
	}

	public void setShipzipcode(String shipzipcode) {
		this.shipzipcode = shipzipcode;
	}

	public String getShipphone() {
		return this.shipphone;
	}

	public void setShipphone(String shipphone) {
		this.shipphone = shipphone;
	}

	public String getShipmobile() {
		return this.shipmobile;
	}

	public void setShipmobile(String shipmobile) {
		this.shipmobile = shipmobile;
	}

	public String getOrdermemo() {
		return this.ordermemo;
	}

	public void setOrdermemo(String ordermemo) {
		this.ordermemo = ordermemo;
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

	public Set getRefunds() {
		return this.refunds;
	}

	public void setRefunds(Set refunds) {
		this.refunds = refunds;
	}

	public Set getShippings() {
		return this.shippings;
	}

	public void setShippings(Set shippings) {
		this.shippings = shippings;
	}

	public Set getOrderLogs() {
		return this.orderLogs;
	}

	public void setOrderLogs(Set orderLogs) {
		this.orderLogs = orderLogs;
	}

	public Set getPayments() {
		return this.payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

	public Set getReships() {
		return this.reships;
	}

	public void setReships(Set reships) {
		this.reships = reships;
	}

	public Set getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

	public String getIsrat() {
		return israt;
	}

	public void setIsrat(String israt) {
		this.israt = israt;
	}

}