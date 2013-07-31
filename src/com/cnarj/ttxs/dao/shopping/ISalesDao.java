package com.cnarj.ttxs.dao.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.Sales;

/**
 * 商品模块Dao接口类 - 商品dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface ISalesDao extends IBaseDao<Sales, String>{

	/**
	 * 查询本周热销排行
	 * @param hql
	 * @param page
	 * @return
	 */
	public List<Goods> getweekssales(int num);
	/**
	 * 查询本周热销排行
	 * @param hql
	 * @param page
	 * @return
	 */
	public List<Goods> getbestssales(int num);
}
