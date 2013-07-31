package com.cnarj.ttxs.web.actions.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.shopping.ICartService;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.service.shopping.IGoodsSortService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 商品列表页
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ShoppingListAction extends PageAction {

	private String byTopicId;//按子类别
	private String byMainTopicId;//按主类别查找
	private String byTermId;//1为按销量  2为价格
	private IGoodsService goodsService;//显示商品列表
	private IGoodsSortService sortService;//商品类型列表
	private ICartService cartService;//购物车
	private String goodsId;//商品的id号
	private String searchKey;//搜索关键字
	private String typeId;//类型(最新的还是最热门的)
	private Long missnum;//想购买的人数
	
	private String t;
	
	public Long getMissnum() {
		return missnum;
	}
	public void setMissnum(Long missnum) {
		this.missnum = missnum;
	}
	public ICartService getCartService() {
		return cartService;
	}
	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getByMainTopicId() {
		return byMainTopicId;
	}
	public void setByMainTopicId(String byMainTopicId) {
		this.byMainTopicId = byMainTopicId;
	}
	public IGoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public String getByTopicId() {
		return byTopicId;
	}
	public void setByTopicId(String byTopicId) {
		this.byTopicId = byTopicId;
	}
	public String getByTermId() {
		return byTermId;
	}
	public void setByTermId(String byTermId) {
		this.byTermId = byTermId;
	}
	public IGoodsSortService getSortService() {
		return sortService;
	}
	public void setSortService(IGoodsSortService sortService) {
		this.sortService = sortService;
	}
	
	private void common(){
		List<GoodesCategory> gMains=sortService.getMainList();//得到商品的主类别树
		//byTopicId=byTermId=byMainTopicId=null;
		int allGoodsNum=goodsService.getAllGoodsNumber();//得到商品的总数量
		List<Goods> salabilityGoods=goodsService.getWeekHotGoods(9);//本周畅销排行
		List<Article> goShoppingSys=goodsService.getShoppingSys(7);//得到7条最新的购物咨询
		this.setAttribute("salabilityGoods", salabilityGoods);
		this.setAttribute("goShoppingSys", goShoppingSys);
		this.setAttribute("gMains", gMains);
		this.setAttribute("allGoodsNum", allGoodsNum);
	}
	/**
	 * 显示所有的商品
	 * @return
	 */
	public String showShopList(){
		
		page.setEveryPage(24);
		//设置page参数
		// 设置每页显示的条数
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		if(byTermId==null){//默认按销量
			byTermId="1";
		}
		result=goodsService.getAllGoods(byTopicId,byTermId,byMainTopicId,page);//查询商品列表
		common();
		if(byMainTopicId!=null&&!byMainTopicId.trim().equals("")){
			GoodesCategory mainC=sortService.get(byMainTopicId);
			setAttribute("mainC", mainC);
		}
		if(byTopicId!=null&&!byTopicId.trim().equals("")){
			GoodesCategory clidC=sortService.get(byTopicId);
			setAttribute("clidC", clidC);
		}
		return "allShop";
	}
	public String showGoods(){
		//热销产品
		List<Goods> hotGoods=goodsService.gethotGoods(6);//得到6条热销产品
		this.setAttribute("hotGoods", hotGoods);
		//本周排行
		List<Goods> salabilityGoods=goodsService.getWeekHotGoods(9);//本周畅销排行
		this.setAttribute("salabilityGoods", salabilityGoods);
		//购物咨询
		List<Article> goShoppingSys=goodsService.getShoppingSys(7);//得到7条最新的购物咨询
		this.setAttribute("goShoppingSys", goShoppingSys);
		//按id得到商品信息
		Goods goods=goodsService.get(goodsId);
		this.setAttribute("goods", goods);
		//三个月的总销量
		Long totalBySize=goodsService.getByGoodsIdBuy(goods.getGoodsid());
		this.setAttribute("totalBySize", totalBySize);
		//商品的热评(还没有建表)
		page.setEveryPage(8);
		//设置page参数
		// 设置每页显示的条数
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		if(byTermId==null){//默认按销量
			byTermId="1";
		}
		result=goodsService.getGoodsRats(goodsId,page);
		//goodsId=null;
		Result te=result;
		
		//想购买该商品的人数 update by sly 20111015上线前
		missnum = cartService.listCartByGoods(goodsId);
		
		return "goodsSucc";
	}
	
	public String searchResult(){
		page.setEveryPage(24);
		//设置page参数
		// 设置每页显示的条数
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		if(byTermId==null){//默认按销量
			byTermId="1";
		}
		result=goodsService.getBySearchGoods(searchKey,page);//查询商品列表
		common();
		return "searchSucc";
	}
	public String searchBytype(){
		try {
			page.setEveryPage(24);
			//设置page参数
			// 设置每页显示的条数
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			//默认为全部
			String goodsMianSrot = "";//上级类别
			String goodsSrot = "";//下级类别
			if (null != getParameter("goodsMianSrot")
					&& !"".equals(getParameter("goodsMianSrot"))) {
				goodsMianSrot = getParameter("goodsMianSrot");
			}
			if (null != getParameter("goodsSrot")
					&& !"".equals(getParameter("goodsSrot"))) {
				goodsSrot = getParameter("goodsSrot");
			}
			result=goodsService.getTypeGoods(page, goodsMianSrot, goodsSrot);//查询商品列表
			common();
			return "searchSucc";
		} catch (Exception e) {
			return "searchSucc";
		}
	}
	public String showNewGoods(){
		common();
		page.setEveryPage(24);
		//设置page参数
		// 设置每页显示的条数
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		if(byTermId==null){//默认按销量
			byTermId="1";
		}
		result=goodsService.getTypeGoods(page,typeId);
		return "goodsSh";
	}
}
