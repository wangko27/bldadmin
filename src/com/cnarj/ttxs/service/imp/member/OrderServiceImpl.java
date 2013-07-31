package com.cnarj.ttxs.service.imp.member;


import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.dao.member.IOrderDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IOrderService;

public class OrderServiceImpl extends BaseServiceImpl<Orders,String> implements IOrderService {

	private IOrderDao morderDao;
	
	
	public IOrderDao getMorderDao() {
		return morderDao;
	}
	public void setMorderDao(IOrderDao morderDao) {
		this.morderDao = morderDao;
	}
	public void setBaseDao(IOrderDao morderDao) {
		super.setBaseDao(morderDao);
	}
	
	public Result getOrderList(Page page, String memberid, List<Long> statuList) {
		// TODO Auto-generated method stub
		return morderDao.getOrderList(page, memberid, statuList);
	}
	
	public int updateOrder(String memberid, String orderid, Long toType) {
		
		//查询订单
		Orders ord;
		Hashtable table = new Hashtable();
		table.put("member.memberid", memberid);
		table.put("orderid", orderid);
		ord = morderDao.get(table);
		
		if(ord == null){
			return 0;//订单不存在
		}
		//修改订单
		ord.setOrderstatus(toType);
		morderDao.update(ord);
		return 1;
	}
	
	
	
}
