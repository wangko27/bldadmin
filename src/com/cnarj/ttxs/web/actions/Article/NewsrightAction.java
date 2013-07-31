package com.cnarj.ttxs.web.actions.Article;

import java.util.List;



import com.cnarj.ttxs.web.actions.base.PageAction;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.Article.IQuestionService;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.interest.IActivityService;
import com.cnarj.ttxs.service.learn.ILikeGoodsService;
import com.cnarj.ttxs.service.learn.IReadbookService;


/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class NewsrightAction extends PageAction{
	private ISysArticleService  sysarticleService;//显示3条公告的
	private IReadbookService readbookService;//显示5条书籍
	private ILikeGoodsService likeGoodsService;//显示9本畅销的读物
	private IQuestionService questionService;//答疑小博士10条
	private  IActivityService activityService;//兴趣活动
	
	public ISysArticleService getSysarticleService() {
		return sysarticleService;
	}

	public void setSysarticleService(ISysArticleService sysarticleService) {
		this.sysarticleService = sysarticleService;
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

	public IQuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	public IActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

	public String rightList(){
		System.out.println("sss");
		System.out.println(sysarticleService);
		List<Article> newsSysarticle=sysarticleService.getNewsNotice(3);//显示3条公告的
		List<ReadSrc> readSrcList=readbookService.get5ReadSrc(5);//5本畅销读物
		List<Goods> goodsList=likeGoodsService.getLikeGoods(9);//
		List<Question> questionhotlist=questionService.getHOTQuestion("visittime", "answernum", "begindate", 10);//10条最新问题	
		this.setAttribute("newsSysarticle", newsSysarticle);
		List<Activity> rightActivitylist=activityService.getnewsActivity(4);//四条兴趣活动
		if(goodsList.size()==0){
			this.setAttribute("nog", "yes");
		}
		this.setAttribute("rightActivitylist", rightActivitylist);
		this.setAttribute("questionhotlist", questionhotlist);
		this.setAttribute("readSrcs", readSrcList);
		this.setAttribute("goodsList", goodsList);
		return"rightlist";
	}
}
	