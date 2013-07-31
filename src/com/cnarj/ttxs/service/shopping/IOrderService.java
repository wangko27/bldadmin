package com.cnarj.ttxs.service.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 商城频道Service接口类 - 订单
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public interface IOrderService extends IBaseService<Orders, String> {

	/**
	 * 添加订单
	 * 
	 * @param orders
	 *            订单信息
	 * @param list_car
	 *            购物车 商品清单
	 * @throws Exception
	 */
	public void saveOrders(Orders orders, List<CarItem> list_car)
			throws Exception;
}
