package com.cnarj.ttxs.web.actions.shopping;

import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;
import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.pojo.shop.Receiver;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.dsis.IXzqhService;
import com.cnarj.ttxs.service.shopping.ICartService;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.service.shopping.IOrderService;
import com.cnarj.ttxs.service.shopping.IReceiverService;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.Pubfun;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商城频道Action类 - 订单管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public class OrderAction extends PageAction implements ModelDriven<Orders> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Orders orders = new Orders();

	private IOrderService orderService;

	private IReceiverService receiverService;

	private IXzqhService xzqhService;

	private ICartService cartService;

	private IGoodsService goodsService;

	private String buytype;// 购买类别 1直接购买付款 2添加到购物车后购买付款

	private String[] goodsids;// 要购买的商品ID(多个)

	private String goodsid;// 要购买的商品ID，多个以,号分隔

	private Long goodsnum = new Long(0);// 购买数量，直接购买才会有

	// 商品总价
	private Long totalprice = new Long(0);

	// 购物信息
	private List<CarItem> list_cart = new ArrayList<CarItem>();

	public Orders getModel() {
		return orders;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public IReceiverService getReceiverService() {
		return receiverService;
	}

	public void setReceiverService(IReceiverService receiverService) {
		this.receiverService = receiverService;
	}

	public IXzqhService getXzqhService() {
		return xzqhService;
	}

	public void setXzqhService(IXzqhService xzqhService) {
		this.xzqhService = xzqhService;
	}

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public String getBuytype() {
		return buytype;
	}

	public void setBuytype(String buytype) {

		this.buytype = buytype;
		if (null != buytype) {
			// 设置商品ID
			if ("1".equals(buytype)) {// 直接购买
				this.goodsids = new String[] { getParameter("goodsid") };
			} else if ("2".equals(buytype)) {// 从购物车购买
				if (null != getParameter("goodsid")) {
					this.goodsids = getParameter("goodsid").split(",");
				}
			}

			setList_cart(new ArrayList<CarItem>());
			setTotalprice(new Long(0));
		}
	}

	public Long getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(Long goodsnum) {
		this.goodsnum = goodsnum;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public Long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Long totalprice) {
		totalprice = new Long(0);
//		for (CarItem car : list_cart) {
//			totalprice += car.getQuantity() * car.getGoods().getProductprice();
//		}
		this.totalprice = totalprice;
	}

	public List<CarItem> getList_cart() {
		return list_cart;
	}

	public void setList_cart(List<CarItem> list_cart) {
		this.list_cart = new ArrayList<CarItem>();

		try {
			// 查询商品清单
			if (null != buytype) {
				if ("1".equals(buytype)) {// 直接购买
					if (null != goodsids && goodsids.length > 0) {
						// 商品信息
						Goods goods = goodsService.get(goodsids[0]);

						// 临时构建购物信息
						CarItem car = new CarItem();
						car.setQuantity(goodsnum);
						car.setGoods(goods);
						this.list_cart.add(car);
					}
				} else if ("2".equals(buytype)) {// 从购物车购买
					this.list_cart = cartService.listCartByGoods(goodsids);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 收货地址
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showReceiver() {
		try {
			// 查询行政区域
			// 查询省份
			List<CoChinaXzqh> list_province = xzqhService.listProvinceAll();
			setAttribute("list_province", list_province);

			// 查询城市
			String provinceBm = " ";
			if (null != list_province && list_province.size() > 0) {
				CoChinaXzqh area = list_province.get(0);
				provinceBm = area.getBm();
			}
			List<CoChinaXzqh> list_city = xzqhService.listCityByBm(provinceBm);
			setAttribute("list_city", list_city);

			// 查询县、区
			String cityBm = " ";
			if (null != list_city && list_city.size() > 0) {
				CoChinaXzqh area = list_city.get(0);
				cityBm = area.getBm();
			}
			List<CoChinaXzqh> list_county = xzqhService.listCountyByBm(cityBm);
			setAttribute("list_county", list_county);

			// 查询自己已有的收货地址
			String memberid=HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			List list_receiver = receiverService.getList("member.memberid", memberid);
			setAttribute("list_receiver", list_receiver);

			return "receiver";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 送货方式
	 * 
	 * @return
	 */
	public String showDeliverMode() {
		try {
			return "deliverMode";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 支付方式
	 * 
	 * @return
	 */
	public String showPayment() {
		try {
			setAttribute("deliverytypename", orders.getDeliverytypename());
			return "paymentMode";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 确认订单
	 * 
	 * @return
	 */
	public String showOrderOk() {
		try {
			// 查询收货地址
			Receiver receiver = receiverService.get("isdefault", "1");
			setAttribute("receiver", receiver);

			setAttribute("deliverytypename", orders.getDeliverytypename());

			// 订单编号
			StringBuffer sbSn = new StringBuffer();
			sbSn.append(DateUtil.setDateFormat(new Date(), "yyyyMMddHHmmss"));
			sbSn.append("-");
			sbSn.append(Pubfun.getRandomNumber(6));
			setAttribute("ordersn", sbSn.toString());
			return "orderOk";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 添加订单
	 * 
	 * @return
	 */
	public String add() {
		try {
			orderService.saveOrders(orders, this.list_cart);
			setAttribute("ordersn", orders.getOrdersn());
			setAttribute("producttotalprice", orders.getProducttotalprice());
			return "orderSuccess";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 显示订单成功页面
	 * 
	 * @return
	 */
	public String showOrderSuccess() {
		try {
			setAttribute("ordersn", getAttribute("ordersn"));
			setAttribute("producttotalprice", getAttribute("producttotalprice"));
			return "orderSuccess";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 获取商品清单
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showGoodsBill() {
		try {
			// 购物车 商品清单
			setAttribute("list_cart", list_cart);
			// 商品总价
			setAttribute("totalprice", totalprice);
			// 商品ID
			setAttribute("goodsid", goodsid);
			// 购买类别
			setAttribute("buytype", buytype);
			// 购买数量
			setAttribute("goodsnum", goodsnum);

			return "bill";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}

	}

	/**
	 * 验证
	 */

	public void validate() {
		if (HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME) == null) {
			this.addActionError("请先登录!");
		}
	}

}
