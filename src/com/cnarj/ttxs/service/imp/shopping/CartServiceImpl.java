package com.cnarj.ttxs.service.imp.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.shopping.ICartDao;
import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.shopping.ICartService;
import com.cnarj.ttxs.util.HttpUtil;

/**
 * 商城模块实现类 -购物车
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class CartServiceImpl extends BaseServiceImpl<CarItem, String> implements
		ICartService {

	private ICartDao cartDao;

	public ICartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * 根据用户id 和 商品id得到对象
	 * 
	 * @param goodsId
	 * @return
	 */
	public CarItem getMemberGoodsId(String goodsId, String mebid) {
		StringBuffer hql = new StringBuffer();
		hql.append("from CarItem c where c.member.memberid='").append(mebid)
				.append("'and c.goods.goodsid='").append(goodsId).append("'");
		return cartDao.getMemberGoodsId(hql.toString());
	}

	public List<CarItem> listCartByGoods(String[] goodsid) throws Exception {
		StringBuffer sbGoodsid = new StringBuffer();
		if (null != goodsid && goodsid.length > 0) {
			for (int i = 0; i < goodsid.length; i++) {
				sbGoodsid.append("'");
				sbGoodsid.append(goodsid[i]);
				sbGoodsid.append("'");
				if (i != goodsid.length - 1) {
					sbGoodsid.append(",");
				}
			}
			// 用户ID
			String memberid = HttpUtil.getSession(
					Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			String hql = "from CarItem c where c.goods.goodsid in ("
					+ sbGoodsid.toString() + ") and c.member.memberid='"
					+ memberid + "'";
			return cartDao.getList(hql);
		}
		return null;
	}

	public Long listCartByGoods(String goodsId) {
		// TODO Auto-generated method stub
		return cartDao.getTotalCount("goods.goodsid", goodsId);
	}
}
