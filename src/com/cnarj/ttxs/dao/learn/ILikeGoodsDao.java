package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.shop.Goods;

/**
 * 学习频道Dao接口类 - 畅销读物
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface ILikeGoodsDao extends IBaseDao<Goods, String> {

	/**
	 * num 显示条数
	 * 得到9条畅销的读物
	 * @return
	 */
	public List<Goods> getLikeGoods(int num);
	
}
