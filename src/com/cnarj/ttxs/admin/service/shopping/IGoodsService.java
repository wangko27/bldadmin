package com.cnarj.ttxs.admin.service.shopping;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 商城频道后台Service接口类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface IGoodsService extends IBaseService<Goods, String>{

	/**
	 * 分页
	 * @param page
	 * @param goodsKey  条件搜索
	 * @return
	 */
	public Result getByTrimGoods(Page page, String goodsKey);

    public Result findAllGoods(Page page);

    public Goods findById(String goodsId);

    public Result findAllRecommendGoods(Page page);


    public Result findAllHotGoods(Page page);

    public Result findByCategoryName(Page page, String categoryName);
}
