package com.cnarj.ttxs.web.actions.shopping;



import java.util.List;

import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class CommleftAction extends PageAction{
		public IGoodsService goodsService;
		private ISysArticleService  sysarticleService;
		public IGoodsService getGoodsService() {
			return goodsService;
		}

		public void setGoodsService(IGoodsService goodsService) {
			this.goodsService = goodsService;
		}

		public ISysArticleService getSysarticleService() {
			return sysarticleService;
		}

		public void setSysarticleService(ISysArticleService sysarticleService) {
			this.sysarticleService = sysarticleService;
		}
		/**
		 * 公共的右边部分
		 */
		public String common(){
			
			List<Goods> hotgoods=goodsService.gethotGoods(6);//查询热销商品（推荐/最新）6条
			List<Goods> bestsales=goodsService.getbestsales(8);//查询本周畅销排行8条
			List<Article> sysofgoods=sysarticleService.getArticle("articleType.articletypeid", "8a8081a131hjrldd3211faf5f7f60009", 6);//查询购物资讯6条
			
			this.setAttribute("hotgoods", hotgoods);
			this.setAttribute("bestsales", bestsales);
			this.setAttribute("sysofgoods", sysofgoods);	
			return "success";
		}
}
