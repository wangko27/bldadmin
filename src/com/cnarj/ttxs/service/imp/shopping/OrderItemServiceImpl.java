package com.cnarj.ttxs.service.imp.shopping;

import com.cnarj.ttxs.dao.shopping.IOrderItemDao;
import com.cnarj.ttxs.pojo.shop.OrderItem;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.shopping.IOrderItemService;

/**
 * 商城频道后台Service实现类 - 订单项
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月9日
 */
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem, String>
		implements IOrderItemService {

	IOrderItemDao orderItemDao;

	public IOrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	public void setOrderItemDao(IOrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

}
