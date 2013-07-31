package com.cnarj.ttxs.admin.service.shopping;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 商城频道后台Service接口类 - 订单
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月14日
 */
public interface IOrderService extends IBaseService<Orders, String> {

	/**
	 * 查找订单（带分页）
	 * 
	 * @param pager
	 * 
	 * @param ordersn
	 *            订单号
	 * @param begindate
	 *            开始日期
	 * @param enddate
	 *            结束日期
	 * @param status
	 *            状态
	 * @return
	 * @throws Exception
	 */
	public Result findOrderByPager(Page pager, String ordersn,
			String begindate, String enddate, Long status) throws Exception;

	/**
	 * 发货
	 * 
	 * @param orders
	 * @throws Exception
	 */
	public void updateOrderByShipments(Orders orders) throws Exception;

	/**
	 * 退款
	 * 
	 * @param orders
	 * @throws Exception
	 */
	public void updateOrderByRefund(Orders orders) throws Exception;


    public Orders findById(String id);
}
