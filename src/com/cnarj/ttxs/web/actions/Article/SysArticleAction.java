package com.cnarj.ttxs.web.actions.Article;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;



import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.Article.IQuestionService;
import com.cnarj.ttxs.service.Article.ISysArticleHandleService;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.Article.ISysArticleTypeService;
import com.cnarj.ttxs.service.learn.ILikeGoodsService;
import com.cnarj.ttxs.service.learn.IReadSysInfoService;
import com.cnarj.ttxs.service.learn.IReadbookService;


/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class SysArticleAction extends PageAction{
	private ISysArticleService  sysarticleService;
	private ISysArticleTypeService sysArticleTypeService;
	private MemberService memberService;
	private ISysArticleHandleService sysarticleHandleService;
	private String id;
	
	public ISysArticleService getSysarticleService() {
		return sysarticleService;
	}

	public void setSysarticleService(ISysArticleService sysarticleService) {
		this.sysarticleService = sysarticleService;
	}

	public ISysArticleTypeService getSysArticleTypeService() {
		return sysArticleTypeService;
	}

	public void setSysArticleTypeService(
			ISysArticleTypeService sysArticleTypeService) {
		this.sysArticleTypeService = sysArticleTypeService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public ISysArticleHandleService getSysarticleHandleService() {
		return sysarticleHandleService;
	}

	public void setSysarticleHandleService(
			ISysArticleHandleService sysarticleHandleService) {
		this.sysarticleHandleService = sysarticleHandleService;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/*
	 * 
	 * 详情页面
	 * 
	 * 
	 * 
	 */

	
	/**
	 * 分享
	 * 
	 * @return
	 */

	/**
	 * 收藏
	 * 
	 * @return
	 */

}
	