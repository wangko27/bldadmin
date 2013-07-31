package com.cnarj.ttxs.service.shopping;

import com.cnarj.ttxs.pojo.shop.Receiver;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 商城频道后台Service接口类 - 收货地址
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月7日
 */
public interface IReceiverService extends IBaseService<Receiver, String> {

	/**
	 * 添加收货地址
	 * 
	 * @param receiver
	 * @throws Exception
	 */
	public void saveReceiver(Receiver receiver) throws Exception;

	/**
	 * 更改地址为默认
	 * 
	 * @param receiverid
	 *            收货地址ID
	 * @throws Exception
	 */
	public void updateReceiverByDefault(String receiverid) throws Exception;

}
