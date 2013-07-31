package com.cnarj.ttxs.dao.shopping;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.shop.CarItem;

/**
 * 商城模块dao类 - 购物车  
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface ICartDao extends IBaseDao<CarItem, String>{

	/**
	 * 根据用户id  和  商品id得到对象
	 * @param goodsId
	 * @return
	 */
public 	CarItem getMemberGoodsId(String string);
}