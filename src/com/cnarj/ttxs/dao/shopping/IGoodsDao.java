package com.cnarj.ttxs.dao.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 商品模块Dao接口类 - 商品dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface IGoodsDao extends IBaseDao<Goods, String>{

	/**
	 * 查询商品列表  并分页
	 * @param hql
	 * @param page
	 * @return
	 */
	public Result getAllGoods(String hql, Page page);

	/**
	 * 分页
	 * @param page
	 * @param goodsKey  条件搜索
	 * @return
	 */
	public Result getByTrimGoods(String hql, Page page);

	
	/**
	 * 查询热销商品（推荐/最新）
	 * @param hql
	 * @param page
	 * @return
	 */
	public List<Goods> gethotGoods(int num);
	/**
	 * 查询本周热销排行
	 * @param hql
	 * @param page
	 * @return
	 */
	public List<Goods> getbestsales(int num);

	/**
	 * 得到9条畅销的商品
	 * @param hql
	 * @return
	 */
	public List<Goods> getWeekHotGoods(String hql,Object[] goodsId);

	/**
	 * 得到i 条购物咨询
	 * @param hql
	 * @param i
	 * @return
	 */
	public List<Article> getShoppingSys(String hql, int i);

	/**
	 * 得到一周的销售排行信息
	 */
	public List<Object[]> getWeekHotSales(String hql,int num);
	/**
	 * 得到3个月的销量
	 * @param goodsid
	 * @return
	 */
	public Long getByGoodsIdBuy(String hql);

	/**
	 * 根据主类别得到该类的热销商品10
	 * @param sortId
	 * @param i
	 * @return
	 */
	public List<Goods> getByMainSortGoods(String hql, int i);


    public Object findById(String hql);
}
