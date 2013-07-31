package com.cnarj.ttxs.service.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.IBaseService;
/**
 * 商品模块service接口类 - 商品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface IGoodsSortService extends IBaseService<GoodesCategory, String> {

	/**
	 * 得到商品主类别
	 * @return
	 */
	public List<GoodesCategory> getMainList();

	/**
	 * 得到最新的热心解答i条
	 * @param i
	 * @return
	 */
	public List<ZealAnswer> getNewAnswer(int i);

	/**
	 * 得到子类别 并使热销的
	 * @return
	 */
	public List<GoodesCategory> getHotSrot();
	/**
	 * 根据上级类别得到子类别
	 * @return
	 */
	public List<GoodesCategory> getSrot(String goodsMianSrot);

	/**
	 * 电子和运动的热销类别
	 * @return
	 */
	public List<GoodesCategory> getDYHotSrot();
	/**
	 * 得到主类别的热销类别
	 */
	public List<GoodesCategory> getHotMainList();

	/**
	 * 得到最新的几条咨询
	 * @return
	 */
	public List<Article> getNewArticle(int i);

}
