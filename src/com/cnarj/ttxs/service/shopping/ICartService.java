package com.cnarj.ttxs.service.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 商城模块service类 - 购物车
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface ICartService extends IBaseService<CarItem, String> {

	/**
	 * 根据用户id  和  商品id得到对象
	 * @param goodsId
	 * @return
	 */
	public CarItem getMemberGoodsId(String goodsId,String mebid);

	/**
	 * 根据商品ID查询购物车信息
	 * 
	 * @param goodsid
	 *            商品ID
	 * @return
	 * @throws Exception
	 */
	public List<CarItem> listCartByGoods(String[] goodsid) throws Exception;
	
	/**
	 * 根据商品ID查询购物车信息 想购买该商品
	 * update by sly 2011年10月15日18:54:59 上线之前
	 * @param goodsId
	 * @return
	 */
	public Long listCartByGoods(String goodsId);

}
