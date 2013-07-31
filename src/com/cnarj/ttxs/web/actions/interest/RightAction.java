package com.cnarj.ttxs.web.actions.interest;

import java.util.List;

import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.interest.IActivityService;
import com.cnarj.ttxs.service.learn.ILikeGoodsService;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 兴趣Action类 - 首页
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月22日
 */
public class RightAction extends PageAction {
	private ISysArticleService  sysarticleService;//显示3条公告的
	private  IActivityService activityService;//四条兴趣活动
	private IReadbookService readbookService;//5条博览群书
	private ILikeGoodsService likeGoodsService;//9本畅销读物
	private List<Article> newknows;
	
	public List<Article> getNewknows() {
		return newknows;
	}
	public void setNewknows(List<Article> newknows) {
		this.newknows = newknows;
	}
	public IActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}
	public IReadbookService getReadbookService() {
		return readbookService;
	}
	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
	}
	public ILikeGoodsService getLikeGoodsService() {
		return likeGoodsService;
	}
	public void setLikeGoodsService(ILikeGoodsService likeGoodsService) {
		this.likeGoodsService = likeGoodsService;
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
		List<Article> activitySysarticle=sysarticleService.getNewsNotice(3);//显示3条公告的
		//List<Activity> rightActivitylist=activityService.getActicity(4);//四条兴趣活动
		List<Activity> rightActivitylist=activityService.getnewsActivity(4);
		List<ReadSrc> readSrcs=readbookService.get5ReadSrc(5);//5条博览群书
		List<Goods> goodsList=likeGoodsService.getLikeGoods(9);//9本畅销读物
		List<Article> newknows=sysarticleService.getArticle("articleType.articletypeid", "8a8081a131f9e2370131fa261a850001", 10);//10条新知识
		this.setAttribute("activitySysarticle", activitySysarticle);
		this.setAttribute("rightActivitylist", rightActivitylist);
		this.setAttribute("goodsList", goodsList);
		this.setAttribute("newknows", newknows);
		this.setAttribute("readSrcs", readSrcs);		
		return "success";
	}
}
