package com.cnarj.ttxs.web.actions.Article;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;




import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.Article.IAnswerService;
import com.cnarj.ttxs.service.Article.IArticleHandleRecService;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.service.Article.IArticleTypeService;
import com.cnarj.ttxs.service.Article.IQuestionService;
import com.cnarj.ttxs.service.sys.IHtmlService;

import com.cnarj.ttxs.comm.CommStaticNum;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.comm.*;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.user.Member;
/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class ArticleAction extends PageAction{
	private IArticleService articleService;
	private IQuestionService questionService;
	private IAnswerService answerServive;
	private IArticleTypeService articleTypeService;
	private List<ArticleSrc> articleList;
	private ArticleHandleRec articleHandleRec;
	private MemberService memberService;
	private IArticleHandleRecService articleHandleRecService;
	private IHtmlService htmlService;
	private List<ArticleType> articleTypeList;
	private String id;
	private String shownum;
	
	public String getShownum() {
		return shownum;
	}
	public void setShownum(String shownum) {
		this.shownum = shownum;
	}
	public List<ArticleSrc> getArticleList() {
		return articleList;
	}
	public List<ArticleType> getArticleTypeList() {
		return articleTypeList;
	}
	public IArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	public IAnswerService getAnswerServive() {
		return answerServive;
	}
	public void setAnswerServive(IAnswerService answerServive) {
		this.answerServive = answerServive;
	}
	public IArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}
	public void setArticleTypeService(IArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setArticleList(List<ArticleSrc> articleList) {
		this.articleList = articleList;
	}
	public void setArticleTypeList(List<ArticleType> articleTypeList) {
		this.articleTypeList = articleTypeList;
	}

	public ArticleHandleRec getArticleHandleRec() {
		return articleHandleRec;
	}
	public IArticleHandleRecService getArticleHandleRecService() {
		return articleHandleRecService;
	}
	public void setArticleHandleRec(ArticleHandleRec articleHandleRec) {
		this.articleHandleRec = articleHandleRec;
	}
	public void setArticleHandleRecService(
			IArticleHandleRecService articleHandleRecService) {
		this.articleHandleRecService = articleHandleRecService;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 获得最新新闻列表
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String listNews(){
		try {
			//获得上级类别
			articleTypeList=articleTypeService.getList("articleType.articletypeid", "8a8081a131cd5fcd0131cd6a83e40005");
			setAttribute("articleType", articleTypeList);
			String articleTypeId=getParameter("articleTypeId");
			if(null==articleTypeId||"".equals(articleTypeId.trim())){
				articleTypeId=this.id;
			}
			this.setAttribute("articleTypeId", articleTypeId);
			LogUtil.logger.info("记录日志信息!");
			// 设置每页查询的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
			//设置排序的字段
			page.setOrderBy("createdate");
			//设置排序方法
			page.setOrderType(OrderType.desc);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			//查找文章集合
			Long totalRecords=articleService.getnewsTotalCount(articleTypeId);
			page= PageUtil.createPage(page, totalRecords.intValue()); 
			result = articleService.searchArticle(page, articleTypeId);
			setAttribute("result", result);
			return "listnews";
		} catch (Exception e) {
			// TODO: handle exception
			return "listnews";
		}
	}
	
	
	
	/**
	 * 根据教育看点类别分页查找文章- 内容
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */
	public String getArticleByEducationType(){
		try {
			String articleTypeId=getParameter("articletype");
			if(articleTypeId==null){
				articleTypeId=this.id;
			}
			ArticleType articleType=articleTypeService.get("articletypeid",articleTypeId);
			if(articleType==null){
				return "success";
			}
			ArticleSrc articleSrc1=new ArticleSrc();
			articleSrc1.setArticleType(articleType);
			//获得页面总数
			Long totalRecords = articleService.getTotalCount("articleType", articleSrc1.getArticleType());		
			System.out.println(totalRecords);	
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
			//设置排序的字段
			page.setOrderBy("createdate");
			//设置排序方法
			page.setOrderType(OrderType.desc);
			//创建页面
			page = PageUtil.createPage(page, totalRecords.intValue()); 	
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArticleSrc.class);
			detachedCriteria.add(Restrictions.eq("articleType", articleType));
			result = articleService.findByPager(page, detachedCriteria);
			setAttribute("result", result);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			this.setAttribute("Isempty", "yes");
			return "success";
		}
		
	}	
	/**
	 * 根据上级类别分页查找文章
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */	
	public String list(){
		try {
			articleTypeList=articleTypeService.getList("articleType.articletypeid", "8a80818c31bb7cc50131bb7fbde70002");
			this.setAttribute("articleType", articleTypeList);
			String articleTypeId=getParameter("articleTypeId");
			String shownum=getParameter("shownum");
			if(articleTypeId==null||!this.id.equals("")){
				articleTypeId=this.id;
				shownum=this.shownum;
			}
			LogUtil.logger.info("记录日志信息!");
			// 设置每页查询的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
			//设置排序的字段
			page.setOrderBy("createdate");
			//设置排序方法
			page.setOrderType(OrderType.desc);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			page.setOrderType(OrderType.desc);
			//创建页面
			//查找文章集合
			Long totalRecords=articleService.getbaikeTotalCount(articleTypeId);
			page= PageUtil.createPage(page, totalRecords.intValue()); 
			result = articleService.searchbaikelist(page, articleTypeId);
			this.setAttribute("shownum", shownum);
			this.setAttribute("result", result);
			return "list";
		} catch (Exception e) {
			// TODO: handle exception
			return "list";	
		}
	}
	/**
	 * 根据文章id查询文字内容- 内容分页
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */	
	
	public String getArticleById(){
		try {
			ArticleSrc articleSrc=articleService.get(this.id);
			this.setAttribute("articleSrc", articleSrc);
			String stre=articleSrc.getArticlesrccontent();
			String [] content=null;
			if(stre!=null){
				content=stre.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
			}
			setAttribute("srclength", stre!=null?content.length:0);
			setAttribute("content", content);
			//查询文章相关内容
			List<ArticleSrc> articleList=articleService.getArticleSrcRI("articletypeid", articleSrc.getArticleType().getArticletypeid(), articleSrc.getArticlesrcid(),articleSrc.getArticletitle(), articleSrc.getMetakeywords(), articleSrc.getIsrecommend(), 5);
			this.setAttribute("articleList", articleList);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";		
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
				String articlesrcid = getParameter("articlesrcid");
				//文章处理记录
				ArticleSrc articleSrc =articleService.get(articlesrcid);
				if(articleSrc.getSharenum()==null){
					articleSrc.setSharenum( new Long(1));
				}
				else{
					articleSrc.setSharenum(articleSrc.getSharenum() + new Long(1));
				}
				articleSrc.setModifydate(new Date());
				//修改文章分享次数
				articleService.update(articleSrc);
				//修改处理表记录
				ArticleHandleRec articleHandleRec = new ArticleHandleRec();
				articleHandleRec.setArticleSrc(articleSrc);
				articleHandleRec.setActiontype(new Long(1));
				articleHandleRec.setActiondate(new Date());
				String memberid = HttpUtil.getSession(
						Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
				//获得用户信息
				Member member =memberService.get(memberid);
				articleHandleRec.setMember(member);
				articleHandleRecService.save(articleHandleRec);
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
			if (null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)) {
				getResponse().getWriter().print(-1);// 未登录
			} else {
				String memberid = HttpUtil.getSession(
						Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
				//获得用户信息
				Member member =memberService.get(memberid);
				String articlesrcid = getParameter("articlesrcid");
				boolean b=articleHandleRecService.isExistByReadhandle(articlesrcid, new Long(2), memberid);
				if (b==true) {					
					getResponse().getWriter().print(-2);// 已收藏
				} 
				else {
					//文章处理记录
					ArticleSrc articleSrc =articleService.get(articlesrcid);
					articleSrc.setSharenum(articleSrc.getCollectionnum() + new Long(1));
					//修改文章分享次数
					articleService.update(articleSrc);
					//修改处理表记录
					ArticleHandleRec articleHandleRec = new ArticleHandleRec();
					articleHandleRec.setArticleSrc(articleSrc);
					articleHandleRec.setActiontype(new Long(2));
					articleHandleRec.setActiondate(new Date());
					articleHandleRec.setMember(member);
					articleHandleRecService.save(articleHandleRec);
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
	public IHtmlService getHtmlService() {
		return htmlService;
	}
	public void setHtmlService(IHtmlService htmlService) {
		this.htmlService = htmlService;
	}
	
}
	