package com.cnarj.ttxs.service.imp.shopping;

import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.shopping.*;
import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.pojo.shop.OrderItem;
import com.cnarj.ttxs.pojo.shop.OrderLog;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.shopping.IOrderService;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.HttpUtil;

import java.util.Date;
import java.util.List;

/**
 * 商城频道Service实现类 - 订单
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public class OrderServiceImpl extends BaseServiceImpl<Orders, String> implements
		IOrderService {

	private IOrderDao orderDao;

	private MemberDao memberDao;

	private IOrderLogDao orderLogDao;

	private IOrderItemDao orderItemDao;

	private IGoodsDao goodsDao;

	private ICartDao cartDao;

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public IOrderLogDao getOrderLogDao() {
		return orderLogDao;
	}

	public void setOrderLogDao(IOrderLogDao orderLogDao) {
		this.orderLogDao = orderLogDao;
	}

	public IOrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	public void setOrderItemDao(IOrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	public IGoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public ICartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}

	@SuppressWarnings("unchecked")
	public void saveOrders(Orders orders, List<CarItem> list_car)
			throws Exception {
		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		Member member = memberDao.get(memberid);
		orders.setMember(member);

		orders.setCreatedate(new Date());
		orders.setModifydate(new Date());

		// 订单状态，等待付款
		orders.setOrderstatus(new Long(2));

		// 支付状态 未支付
		orders.setPaymentstatus(new Long(0));
		// 发货状态 未发货
		orders.setShippingstatus(new Long(0));
		// 配送费用
		orders.setDeliveryfee(new Long(0));
		// 支付费用
		orders.setPaymentfee(new Long(0));
		// 订单总额
		orders.setTotalamount(orders.getProducttotalprice());
		// 已付金额
		orders.setPaidamount(new Long(0));

		orderDao.save(orders);

		// 订单项
		for (CarItem car : list_car) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCreatedate(new Date());
			orderItem.setModifydate(new Date());
			orderItem.setProductsn(car.getGoods().getProductsn());
			orderItem.setGoodsname(car.getGoods().getGoodsname());
//			orderItem.setOrderitemprice(car.getGoods().getProductprice());
			orderItem.setGoodsnum(car.getQuantity());
			orderItem.setShipnum(car.getQuantity());
			orderItem.setTotalshipnum(car.getQuantity());
			orderItem.setGoods(car.getGoods());
			orderItem.setOrder(orders);
			orderItemDao.save(orderItem);

			// 删除购物车信息
			cartDao.delete(car);
		}

		// 订单日志
		OrderLog orderLog = new OrderLog();
		orderLog.setCreatedate(new Date());
		orderLog.setModifydate(new Date());
		orderLog.setOrdersn(orders.getOrdersn());
		orderLog.setOrders(orders);
		orderLog.setOrderoperator(member.getUsername());
		orderLog.setOrderloginfo("您在"
				+ DateUtil.setDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "时候下单");
		orderLog.setOrderlogtype(new Long(1));// 会员操作
		orderLogDao.save(orderLog);

	}
}
