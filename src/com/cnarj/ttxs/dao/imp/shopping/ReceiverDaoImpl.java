package com.cnarj.ttxs.dao.imp.shopping;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.shopping.IReceiverDao;
import com.cnarj.ttxs.pojo.shop.Receiver;

/**
 * 商城频道Dao接口实现类 - 收货地址
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月7日
 */
public class ReceiverDaoImpl extends BaseDaoImpl<Receiver, String> implements
		IReceiverDao {

	public void updateReceiverByNotDefault(String receiverid) throws Exception {
		String sql = "update TTXS_SHOP_RECEIVER set ISDEFAULT=0 where RECEIVERID!='"
				+ receiverid + "'";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
}
