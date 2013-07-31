package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.service.IBaseService;

public interface IOrderService extends IBaseService<Orders,String> {

	/**
	 * 查询用户订单信息 根据用户ID及需要的状态(可以为多个)
	 * @param page 分页信息
	 * @param memberid 用户Id 
	 * @param statuList 订单状态列表
	 */
	public Result getOrderList(Page page, String memberid, List<Long> statuList);
	
	/**
	 * 修改订单的状态
	 * @param memberid 会员Id 
	 * @param orderid 订单Id 
	 * @param toType 要修改到的状态
	 */
	public int updateOrder(String memberid,String orderid,Long toType);
}
