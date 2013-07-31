package com.cnarj.ttxs.admin.service.imp.shopping;

import com.cnarj.ttxs.admin.service.shopping.IOrderService;
import com.cnarj.ttxs.dao.shopping.IOrderDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

import java.util.Date;

/**
 * 商城频道后台Service实现类 - 订单
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public class OrderServiceImpl extends BaseServiceImpl<Orders, String> implements
		IOrderService {

	private IOrderDao orderDao;

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Result findOrderByPager(Page pager, String ordersn,
			String begindate, String enddate, Long status) throws Exception {
		return orderDao.findOrderByPager(pager, ordersn, begindate, enddate,
				status);
	}

	public void updateOrderByRefund(Orders orders) throws Exception {
		Orders ordersNew = orderDao.get(orders.getOrderid());
		ordersNew.setModifydate(new Date());
		ordersNew.setOrderstatus(new Long(6));// 订单状态改为退款中
		orderDao.update(ordersNew);
	}

	public void updateOrderByShipments(Orders orders) throws Exception {
		Orders ordersNew = orderDao.get(orders.getOrderid());
		ordersNew.setModifydate(new Date());
		ordersNew.setShippingstatus(new Long(1));// 发货状态改为已发货
		ordersNew.setOrderstatus(new Long(4));// 订单状态改为已付款 已发货
		orderDao.update(ordersNew);
	}

    @Override
    public Orders findById(String id) {
        if(id != null && !"".equals(id.trim())){
            return orderDao.findById(id);
        }else{
            return null;
        }

    }
}
