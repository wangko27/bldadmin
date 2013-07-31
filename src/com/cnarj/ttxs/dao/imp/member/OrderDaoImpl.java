package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IOrderDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Orders;

public class OrderDaoImpl extends BaseDaoImpl<Orders,String> implements IOrderDao {

	public Result getOrderList(Page page, String memberid, List<Long> statuList) {
		Assert.notNull(page,"page对象不能为空");
		Assert.hasText(memberid, "memberid 不能为空");
		

		StringBuffer hql = new StringBuffer();
		hql.append("from Orders as model where model.member.memberid = ? ");
		
		if(statuList != null && statuList.size() > 0){
			hql.append(" and ");
			hql.append(" ( 0 = 1 ");
			
			for(Long l : statuList){
				hql.append(" or orderstatus = ? ");
			}
			hql.append(" ) ");
			
		}
		
		hql.append(" order by model.createdate desc ");

		List list = new ArrayList();
		list.add(memberid);
		if(statuList != null && statuList.size() > 0){
			for(Long l : statuList){
				list.add(l);
			}
		}
		
		return super.findByPager(page, hql.toString(), list);
	}

}
