package com.cnarj.ttxs.dao.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 商品模块dao类 - 商品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface IGoodsSrotDao extends IBaseDao<GoodesCategory, String> {

	/**
	 * 得到商品的主类别
	 * @param hql
	 * @return
	 */
	public List<GoodesCategory> getMainList(String hql);

	/**
	 * 是否有同名类别
	 * @param categoryname
	 * @return
	 */
	public boolean isOccurSrot(String categoryname);

	/**
	 * 按条件查询  并分页
	 * 
	 * @return 
	 */
	public Result byConditionSort(String hql, Page page);

	/**
	 * 得到最新的热心解答i条
	 * @param i
	 * @return
	 */
	public List<ZealAnswer> getNewAnswer(String string, int i);

	/**
	 * 得到子类别 并使热销的
	 * @return
	 */
	public List<GoodesCategory> getHotSrot(String hql);

	/**
	 * 购物咨询
	 * @param string
	 * @param i
	 * @return
	 */
	public List<Article> getNewArticle(String string, int i);

}
