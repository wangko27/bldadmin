package com.cnarj.ttxs.service.member;

import com.cnarj.ttxs.pojo.shop.Receiver;
import com.cnarj.ttxs.service.IBaseService;

public interface IReceiverService extends IBaseService<Receiver,String> {

	/**
	 * 删除收货地址
	 * @param receiverid 收货地址ID
	 * @param memberid 用户ID
	 */
	public void delReceiver(String receiverid,String memberid);
	
	/**
	 * 修改收货地址
	 * @param rec
	 * @param memberid
	 * @throws Exception
	 */
	public int updReceiver(Receiver rec ,String memberid) throws Exception;
}
