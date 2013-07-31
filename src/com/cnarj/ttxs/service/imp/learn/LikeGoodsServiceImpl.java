package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.ILikeGoodsDao;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.ILikeGoodsService;
/**
 * 学习频道Service实现类 - 畅销读物
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public class LikeGoodsServiceImpl extends BaseServiceImpl<Goods, String> implements
		ILikeGoodsService {

	private ILikeGoodsDao likeGoodsDao;
	public ILikeGoodsDao getLikeGoodsDao() {
		return likeGoodsDao;
	}
	public void setLikeGoodsDao(ILikeGoodsDao likeGoodsDao) {
		this.likeGoodsDao = likeGoodsDao;
	}
	public List<Goods> getLikeGoods(int num) {
		return likeGoodsDao.getLikeGoods(num);
	}


}
