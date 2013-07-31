package com.cnarj.ttxs.dao.imp.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.shopping.IGoodsSrotDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 商品模块dao实现类 - 商品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class GoodsSrotDaoImpl extends BaseDaoImpl<GoodesCategory, String> implements IGoodsSrotDao{

	/**
	 * 得到主类别
	 */
	@SuppressWarnings("unchecked")
	public List<GoodesCategory> getMainList(String hql) {
		return this.getSession().createQuery(hql).list();
	}

	/**
	 * 是否有同名的类型	 */
	public boolean isOccurSrot(String categoryname) {
		
		return this.getSession().createQuery(categoryname).list().size()<=0?false:true;
	}

	/**
	 * 按条件查询  并分页
	 * 
	 * @return 
	 */
	public Result byConditionSort(String hql, Page page) {
		return this.findByPager(page,hql);
	}

	/**
	 * 得到最新的热心解答i条
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZealAnswer> getNewAnswer(String string, int i) {
		
		return this.getSession().createQuery(string).setMaxResults(i).list();
	}
	/**
	 * 得到子类别 并使热销的
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodesCategory> getHotSrot(String hql) {
		return this.getSession().createQuery(hql).list();
	}

	/**
	 * 购物咨询
	 */
	@SuppressWarnings("unchecked")
	public List<Article> getNewArticle(String string, int i) {
		return this.getSession().createQuery(string).setMaxResults(i).list();
	}
	
}
