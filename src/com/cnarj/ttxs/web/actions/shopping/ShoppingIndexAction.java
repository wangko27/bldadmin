package com.cnarj.ttxs.web.actions.shopping;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.service.shopping.IGoodsSortService;
import com.cnarj.ttxs.web.actions.base.PageAction;

@SuppressWarnings("serial")
public class ShoppingIndexAction extends PageAction {

	private IGoodsSortService sortService;//商品类型
	private IGoodsService goodsService;//商品表
	private String sortId;//类别的Id(畅销)
	private String newId;//最新类别的id
	private String dzSortId;//电子的类别
	
	private String t;
	
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getDzSortId() {
		return dzSortId;
	}
	public void setDzSortId(String dzSortId) {
		this.dzSortId = dzSortId;
	}
	
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getSortId() {
		return sortId;
	}
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
	public IGoodsSortService getSortService() {
		return sortService;
	}
	public void setSortService(IGoodsSortService sortService) {
		this.sortService = sortService;
	}
	public IGoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}
	/**
	 * 根据主类别的id 得到10条热销商
	 * @return
	 */
	public String showSortIndex(){
		List<Goods> hotGoodses=goodsService.getByMainSortGoods(sortId,10);
		StringBuffer json=new StringBuffer();
		json.append("{goods:[");
		for(int i=0;i<hotGoodses.size();i++){
			Goods g=hotGoodses.get(i);
			json.append("{\"id\":\"").append(g.getGoodsid()).append("\",\"picPath\":\"")
			.append(g.getPhotospath()).append("\",\"name\":\"").append(g.getGoodsname()).append("\",\"sPic\":\"")
			.append(g.getMarketprice()).append("\",\"pic\":\"").append(g.getProductprice()).append("\"}");
			if(i==(hotGoodses.size()-1)){
				break;
			}
			json.append(",");
		}
		json.append("]}");
		sortId=null;
		return this.ajaxJson(json.toString());
	}
	/*
	 * 主页的显示
	 */
	public String showIndex(){
		//得到所有的主类别
		List<GoodesCategory> goodsMianSrot=sortService.getMainList();
		this.setAttribute("size", goodsMianSrot.size());
		this.setAttribute("goodsMianSrot", goodsMianSrot);
		//得到主类别的热销类别
		List<GoodesCategory> hotMainsrot=sortService.getHotMainList();
		this.setAttribute("hotMainsrot", hotMainsrot);
		//根据主类别的id 得到10条热销商
		if(hotMainsrot!=null&&hotMainsrot.size()>0){
			if(sortId==null||sortId.trim().equals("")){
				sortId=hotMainsrot.get(0).getCategoryid();
			}
			List<Goods> hotGoodses=goodsService.getByMainSortGoods(sortId,10);
			this.setAttribute("hotGoodses", hotGoodses);
			sortId=null;
		}
		//本周畅销排行榜
		List<Goods> salabilityGoods=goodsService.getWeekHotGoods(9);//本周畅销排行
		this.setAttribute("salabilityGoods", salabilityGoods);
		//按类别得到最新读物10
		if(goodsMianSrot!=null&&goodsMianSrot.size()>0){
			if(newId==null||newId.trim().equals("")){
				newId=goodsMianSrot.get(0).getCategoryid();
			}
			List<Goods> newGoodses=goodsService
			             .getByMainSortNewGoods(newId,10);
			this.setAttribute("newGoodses", newGoodses);
		}
		//得到6条最新的热心解答
		List<ZealAnswer> newAnswer=sortService.getNewAnswer(6);
		this.setAttribute("newAnswer", newAnswer);
		//得到电子和运动生活的5条畅销或最新的信息
		show5DzGoods();
		//热销的类别但不是主类别
		List<GoodesCategory> hotSrot=sortService.getHotSrot();
		this.setAttribute("hotSrot", hotSrot);
		this.setAttribute("hotSrotsize", hotSrot.size());
		//电子与运动的热销子类别
		List<GoodesCategory> dyHotSrot=sortService.getDYHotSrot();
		this.setAttribute("dyHotSrot", dyHotSrot);
		this.setAttribute("dyHotSrotSize", dyHotSrot.size());
		//得到最新的六条购物咨询
		List<Article> newArticle=sortService.getNewArticle(6);
		this.setAttribute("newArticle", newArticle);
		return "indexSucc";
	}
	//得到电子和运动生活的5条畅销或最新的信息
	public String show5DzGoods(){
		if(dzSortId==null||dzSortId.trim().equals("")){
			dzSortId="8a8080bf324c3b0e01324c3d9a2c0001";
		}
		List<Goods> dyHotGoods=new ArrayList<Goods>();
		dyHotGoods=goodsService.getByMainSortGoods(dzSortId,5);//5条最热门的
		if(dyHotGoods.size()<=5){
			List<Goods> zxlist=goodsService.getByMainSortNewGoods(dzSortId,5-dyHotGoods.size());
			if(zxlist.size()!=0){
				dyHotGoods.addAll(zxlist);
			}
		}
		setAttribute("dyHotGoods", dyHotGoods);
		return null;
	}
}
