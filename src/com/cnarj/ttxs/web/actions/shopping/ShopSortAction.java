package com.cnarj.ttxs.web.actions.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.service.shopping.IGoodsSortService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 商品类别action
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ShopSortAction extends PageAction {

	private IGoodsSortService sortService;//商品类别
	
	public IGoodsSortService getSortService() {
		return sortService;
	}

	public void setSortService(IGoodsSortService sortService) {
		this.sortService = sortService;
	}

	public String showSort(){
		List<GoodesCategory> sortMainList=sortService.getMainList();//得到主类别
		//得到全部的数量
		int allUnmber=0;
		for(GoodesCategory category:sortMainList){
			allUnmber=allUnmber+category.getGoodsnum().intValue();
		}
		this.setAttribute("allUnmber", allUnmber);
		this.setAttribute("sortMainList", sortMainList);
		return "sort";
	}
}
