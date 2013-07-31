package com.cnarj.ttxs.service.imp.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.shopping.IGoodsSrotDao;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.shopping.IGoodsSortService;

/**
 * 商品模块service实现类 - 商品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class GoodsSrotServiceImpl extends BaseServiceImpl<GoodesCategory, String> implements IGoodsSortService {

	private IGoodsSrotDao srotDao;
	public IGoodsSrotDao getSrotDao() {
		return srotDao;
	}
	public void setSrotDao(IGoodsSrotDao srotDao) {
		this.srotDao = srotDao;
	}
	/**
	 * 得到商品的主类别
	 */
	public List<GoodesCategory> getMainList() {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory c where c.goodesCategory.categoryid is null order by c.orderlist");
		return srotDao.getMainList(hql.toString());
	}
	/**
	 * 得到最新的热心解答i条
	 * @param i
	 * @return
	 */
	public List<ZealAnswer> getNewAnswer(int i) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ZealAnswer z order by z.createdate desc");
		return srotDao.getNewAnswer(hql.toString(),i);
	}
	/**
	 * 得到子类别 并使热销的
	 * @return
	 */
	public List<GoodesCategory> getHotSrot() {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory g where g.goodesCategory.categoryid is not null and ")
		.append("g.ishot='1'");
		return srotDao.getHotSrot(hql.toString());
	}
	/**
	 * 得到子类别 
	 * @return
	 */
	public List<GoodesCategory> getSrot(String goodsMianSrot) {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory g where g.goodesCategory.categoryid ='").append(goodsMianSrot).append("'");
		return srotDao.getHotSrot(hql.toString());
	}
	/**
	 * 电子和运动的热销类别
	 * @return
	 */
	public List<GoodesCategory> getDYHotSrot() {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory g where g.goodesCategory.categoryid in ('8a8080bf324c3b0e01324c3e2fe40002',")
		.append("'8a8080bf324c3b0e01324c3d9a2c0001') and ")
		.append("g.ishot='1'");
		return srotDao.getHotSrot(hql.toString());
	}
	/**
	 * 得到主类别的热销类别
	 */
	public List<GoodesCategory> getHotMainList() {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory c where c.goodesCategory.categoryid is null and c.ishot='1' order by c.orderlist");
		return srotDao.getMainList(hql.toString());
	}
	/**
	 * 得到最新的咨询
	 */
	public List<Article> getNewArticle(int i) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Article a where a.articleType.articleType.articletypeid='8a8081a131hjrldd3211faf5f7f60009' order by a.createdate desc");
		return srotDao.getNewArticle(hql.toString(),i);
	}

}
