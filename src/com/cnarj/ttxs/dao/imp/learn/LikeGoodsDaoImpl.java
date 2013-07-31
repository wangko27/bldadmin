package com.cnarj.ttxs.dao.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.ILikeGoodsDao;
import com.cnarj.ttxs.pojo.shop.Goods;

public class LikeGoodsDaoImpl extends BaseDaoImpl<Goods, String> implements ILikeGoodsDao {

	@SuppressWarnings("unchecked")
	public List<Goods> getLikeGoods(int num) {
		return this.getSession().
		createQuery("from Goods g where g.isadded=1 order by g.productsales desc")
		.setMaxResults(num).list();
	}

	
}
