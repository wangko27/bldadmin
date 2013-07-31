package com.cnarj.ttxs.dao.imp.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.shopping.IGoodsDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 商品模块Dao实现类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class GoodsDaoImpl extends BaseDaoImpl<Goods, String> implements IGoodsDao {

	/**
	 * 查询商品列表
	 */
	public Result getAllGoods(String hql, Page page) {
		return this.findByPager(page, hql);
	}
	/**
	 * 分页
	 * @param page
	 * @param goodsKey  条件搜索
	 * @return
	 */
	public Result getByTrimGoods(String hql, Page page) {
		return this.findByPager(page, hql);
	}
	@SuppressWarnings("unchecked")
	public List<Goods> gethotGoods(int num) {
		// TODO Auto-generated method stub
		String hql="from Goods g where g.ishot='1' and g.isnew='1' order by g.modifydate desc";
		List<Goods> list = this.getSession().createQuery(hql).setMaxResults(
				num).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Goods> getbestsales(int num) {
		// TODO Auto-generated method stub
		String hql="from Goods g where g.ishot='1' and g.isnew='1' order by g.productsales,g.modifydate desc";
		List<Goods> list = this.getSession().createQuery(hql).setMaxResults(
				num).list();
		return list;
	}
	/**
	 * 得到9条畅销的商品
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> getWeekHotGoods(String hql,Object[] goodsId) {
		return this.getSession().createQuery(hql).setParameterList("goodsId", goodsId).list();
	}
	/**
	 * 得到几条购物咨询
	 */
	@SuppressWarnings("unchecked")
	public List<Article> getShoppingSys(String hql, int i) {
		return this.getSession().createQuery(hql).setMaxResults(i).list();
	}
	/**
	 * 得到一周的销售排行信息
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getWeekHotSales(String hql, int num) {
		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}
	/**
	 * 得到3个月的销量
	 * @param goodsid
	 * @return
	 */
	public Long getByGoodsIdBuy(String hql) {
		Long di=(Long) this.getSession().createQuery(hql).uniqueResult();
		return di;
	}
	/**
	 * 根据主类别得到该类的热销商品10
	 * @param sortId
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> getByMainSortGoods(String hql, int i) {
		return this.getSession().createQuery(hql).setMaxResults(i).list();
		 
	}

    @Override
    public Object findById(String hql) {
        return this.getSession().createQuery(hql).uniqueResult();
    }
}
