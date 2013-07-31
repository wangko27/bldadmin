package com.cnarj.ttxs.dao.member;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Orders;

public interface IOrderDao extends IBaseDao<Orders,String> {

	/**
	 * 查询用户订单信息 根据用户ID及需要的状态(可以为多个)
	 * @param page 分页信息
	 * @param memberid 用户Id 
	 * @param statuList 订单状态列表
	 */
	public Result getOrderList(Page page, String memberid, List<Long> statuList);
}
