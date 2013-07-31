package com.cnarj.ttxs.dao.shopping;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.shop.Receiver;

/**
 * 商城频道Dao接口类 - 收货地址
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public interface IReceiverDao extends IBaseDao<Receiver, String> {

	/**
	 * 设置除该收货地址外的地址为非默认
	 * 
	 * @param receiverid
	 *            收货地址ID
	 * @throws Exception
	 */
	public void updateReceiverByNotDefault(String receiverid) throws Exception;
}
