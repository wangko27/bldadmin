package com.cnarj.ttxs.service.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.IBaseService;
/**
 * 商城模块service类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface IGoodsService extends IBaseService<Goods, String> {

	/**
	 * 
	 * @param byTopicId 按主题id来查看商品列表(比如 全部商品 资源库题 卡通人偶)
	 * @param byTermId 1为按销量  2为价格
	 * @param page 分页
	 * @return
	 */
	public Result getAllGoods(String byTopicId,String byMainTopicId, String byTermId, Page page);
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
	 * 得到商品的总数量
	 * @return
	 */
	public int getAllGoodsNumber();

	/**
	 * 查询本周的热销排行榜
	 * @return
	 */
	public List<Goods> getWeekHotGoods(int sNum);

	/**
	 * 查询购物咨询
	 * @param i 条数
	 * @return
	 */
	public List<Article> getShoppingSys(int i);
	/**
	 * 得到3个月的销量
	 * @param goodsid
	 * @return
	 */
	public Long getByGoodsIdBuy(String goodsid);
	/**
	 * 根据关键字查找页面
	 * @param searchKey
	 * @param page
	 * @return
	 */
	public Result getBySearchGoods(String searchKey, Page page);
	/**
	 * 根据主类别得到该类的热销商品10
	 * @param sortId
	 * @param i
	 * @return
	 */
	public List<Goods> getByMainSortGoods(String sortId, int i);
	/**
	 * 根据主类别的id得到最新的商品
	 * @param sortId
	 * @param i
	 * @return
	 */
	public List<Goods> getByMainSortNewGoods(String sortId, int i);
	/**
	 * 判断是否是最新的  还是 最热门
	 * @param page
	 * @param typeId
	 * @return
	 */
	public Result getTypeGoods(Page page, String typeId);
	/**
	 * 根据类别搜索商品
	 * @param page
	 * @param typeId
	 * @return
	 */
	public Result getTypeGoods(Page page, String goodsMianSrot,String goodsSrot);
	/**
	 * 得到商品的评论
	 * @param goodsId商品的id
	 * @param page商品分页
	 * @return
	 */
	public Result getGoodsRats(String goodsId, Page page);
	
}
