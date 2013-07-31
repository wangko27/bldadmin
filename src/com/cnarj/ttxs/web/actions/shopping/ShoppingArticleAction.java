package com.cnarj.ttxs.web.actions.shopping;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.Article.ISysArticleHandleService;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.Article.ISysArticleTypeService;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 购物资讯
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ShoppingArticleAction extends PageAction {
	private IGoodsService goodsService;//显示商品列表
	private ISysArticleService  sysarticleService;
	private ISysArticleTypeService sysArticleTypeService;
	private MemberService memberService;
	private ISysArticleHandleService sysarticleHandleService;
	private Article article;
	private String shownum;	
	private String id;
	
	private String t;
	
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ISysArticleTypeService getSysArticleTypeService() {
		return sysArticleTypeService;
	}
	public void setSysArticleTypeService(
			ISysArticleTypeService sysArticleTypeService) {
		this.sysArticleTypeService = sysArticleTypeService;
	}
	public String getShownum() {
		return shownum;
	}
	public void setShownum(String shownum) {
		this.shownum = shownum;
	}
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
	public String list(){
		try {
			List<Article> officialArticle=sysarticleService.getArticle("articletypeid","8a8081a131faef0701dfdsffndsds009" , 5);//查询官方资讯5条或全部
			this.setAttribute("officialArticle", officialArticle);
			String articleType=getParameter("articleType");
			if(articleType==null||articleType.equals("")){
				articleType=this.id;
			}
			//记录日志
			LogUtil.logger.info("记录日志信息!");
			// 设置每页查询的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
			//设置排序的字段
			page.setOrderBy("modifydate");
			//设置排序方法
			page.setOrderType(OrderType.desc);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			result = sysarticleService.getshoparticle(page,articleType );
			return "list";
		} catch (Exception e) {
			return "list";
		}
	}
	/*
	 * 
	 * 详情页面
	 * 
	 * 
	 * 
	 */
	public String viewById(){
		try {
//			article=sysarticleService.get(this.id);
//			final String stre=article.getArticlecontent();
//			String [] content=null;
//			if(stre!=null){
//				content=stre.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
//			}
//			setAttribute("srclength", stre!=null?content.length:0);
//			setAttribute("content", content);
//			//相关信息
//			List<Article> articleList=sysarticleService.getArticleRI(article.getArticleid(), article.getPagekeywords(), 5);
//			setAttribute("articleList", articleList);
			return "view";
		} catch (Exception e) {
			// TODO: handle exception
		    return "view";
		}
	}
	
	/**
	 * 分享
	 * 
	 * @return
	 */
	public String  Share(){
		try {
			if(null==getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
				getResponse().getWriter().print(-1);// 未登录
			}else {
				String articleid = getParameter("articleid");
				//文章处理记录
//				Article article =sysarticleService.get(articleid);
//				Long i=article.getSharenum();
//				if(i==null){
//					article.setSharenum(new Long(1));
//				}else{
//					article.setSharenum(article.getSharenum() + new Long(1));
//				}
				//修改文章分享次数
				sysarticleService.update(article);
				//修改处理表记录
				SysArticleHandleRec articleHandleRec=new SysArticleHandleRec();
				articleHandleRec.setArticle(article);
				articleHandleRec.setActiontype(new Long(1));
				articleHandleRec.setActiondate(new Date());
				String memberid = HttpUtil.getSession(
						Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
				//获得用户信息
				Member member =memberService.get(memberid);
				articleHandleRec.setMember(member);
				sysarticleHandleService.save(articleHandleRec);
				getResponse().getWriter().print(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 收藏
	 * 
	 * @return
	 */
	public String Collect() {
		try {
			setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME,
			"00000000000000000000000000000001");
			String memberid = HttpUtil.getSession(
					Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			//获得用户信息
			Member member =memberService.get(memberid);
			if (null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)) {
				getResponse().getWriter().print(-1);// 未登录
			} else {
				String articleid = getParameter("articleid");
				boolean b=sysarticleHandleService.isExistisExistByReadhandle(articleid, new Long(2), memberid);
				if (b==true) {					
					getResponse().getWriter().print(-2);// 已收藏
				} 
				else {
					//文章处理记录
					Article article =sysarticleService.get(articleid);
//					Long i=article.getCollectionnum();
//					if(i==null){
//						article.setCollectionnum(new Long(1));
//					}else{
//						article.setCollectionnum(article.getCollectionnum() + new Long(1));
//					}
					//修改文章分享次数
					sysarticleService.update(article);
					//修改处理表记录
					SysArticleHandleRec articleHandleRec=new SysArticleHandleRec();
					articleHandleRec.setArticle(article);
					articleHandleRec.setActiontype(new Long(2));
					articleHandleRec.setActiondate(new Date());
					articleHandleRec.setMember(member);
					sysarticleHandleService.save(articleHandleRec);
					getResponse().getWriter().print(1);
				}
			}
			getResponse().getWriter().close();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			
			e.printStackTrace();
			return ERROR;
		}
		return null;
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
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
