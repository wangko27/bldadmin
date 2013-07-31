package com.cnarj.ttxs.dao.imp.shopping;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.shopping.ICartDao;
import com.cnarj.ttxs.pojo.shop.CarItem;

/**
 * 商城模块实现类 - 购物车  
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class CartDaoImpl extends BaseDaoImpl<CarItem, String> implements ICartDao {
	/**
	 * 根据用户id  和  商品id得到对象
	 * @param goodsId
	 * @return
	 */
	public CarItem getMemberGoodsId(String string) {
		return (CarItem) this.getSession().createQuery(string).uniqueResult();
	}

}
