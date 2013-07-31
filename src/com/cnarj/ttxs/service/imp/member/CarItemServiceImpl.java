package com.cnarj.ttxs.service.imp.member;
 
import com.cnarj.ttxs.dao.member.ICarItemDao;
import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.ICarItemService;

public class CarItemServiceImpl extends BaseServiceImpl<CarItem,String> implements
		ICarItemService {

	public void setBaseDao(ICarItemDao carItemDao) {
		super.setBaseDao(carItemDao);
	}

}
