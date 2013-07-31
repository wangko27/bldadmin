//package com.cnarj.ttxs.web.actions.interest;
//
//
//import java.util.Date;
//import java.util.List;
//
//import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.criterion.Restrictions;
//
//import com.cnarj.ttxs.comm.CommStaticNum;
//import com.cnarj.ttxs.pojo.Page.OrderType;
//
//import com.cnarj.ttxs.pojo.interest.Activity;
//import com.cnarj.ttxs.pojo.sys.Article;
//import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;
//import com.cnarj.ttxs.pojo.sys.SysArticleType;
//import com.cnarj.ttxs.pojo.user.Member;
//
//import com.cnarj.ttxs.service.MemberService;
//import com.cnarj.ttxs.service.Article.ISysArticleHandleService;
//import com.cnarj.ttxs.service.Article.ISysArticleService;
//import com.cnarj.ttxs.service.Article.ISysArticleTypeService;
//import com.cnarj.ttxs.service.interest.IActivityService;
//
//import com.cnarj.ttxs.util.HttpUtil;
//import com.cnarj.ttxs.util.LogUtil;
//import com.cnarj.ttxs.util.PageUtil;
//import com.cnarj.ttxs.web.actions.base.PageAction;
//
///**
// * 兴趣Action类 - 首页
// *
// * @copyright 湖南爱瑞杰科技发展股份有限公司
// * @author 唐其
// * @version 1.0
// * @since 2011年8月22日
// */
//@SuppressWarnings("serial")
//public class ModelAction extends PageAction {
//	private ISysArticleService  sysarticleService;
//	private ISysArticleTypeService sysArticleTypeService;
//	private MemberService memberService;
//	private ISysArticleHandleService sysarticleHandleService;
//	private IActivityService activityService;
//
//	private String proID;
//	private Article article;
//	private List<Article> articleList;
//
//	private String id;
//
//	public String getProID() {
//		return proID;
//	}
//	public void setProID(String proID) {
//		this.proID = proID;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public Article getArticle() {
//		return article;
//	}
//	public void setArticle(Article article) {
//		this.article = article;
//	}
//	public List<Article> getArticleList() {
//		return articleList;
//	}
//	public void setArticleList(List<Article> articleList) {
//		this.articleList = articleList;
//	}
//	public ISysArticleTypeService getSysArticleTypeService() {
//		return sysArticleTypeService;
//	}
//	public MemberService getMemberService() {
//		return memberService;
//	}
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
//	public void setSysArticleTypeService(
//			ISysArticleTypeService sysArticleTypeService) {
//		this.sysArticleTypeService = sysArticleTypeService;
//	}
//	public ISysArticleService getSysarticleService() {
//		return sysarticleService;
//	}
//	public void setSysarticleService(ISysArticleService sysarticleService) {
//		this.sysarticleService = sysarticleService;
//	}
//	public ISysArticleHandleService getSysarticleHandleService() {
//		return sysarticleHandleService;
//	}
//	public void setSysarticleHandleService(
//			ISysArticleHandleService sysarticleHandleService) {
//		this.sysarticleHandleService = sysarticleHandleService;
//	}
//	/*
//	 *
//	 * 行业知识列表
//	 *
//	 *
//	 */
//	public String list(){
//		String articletype=getParameter("articletype");
//		if(articletype==null){
//			articletype=this.id;
//		}
//		Activity activity=activityService.get(this.proID);
//		this.setAttribute("activity", activity);
//		SysArticleType articleType=new SysArticleType();
//		articleType=sysArticleTypeService.get(articletype);
//		this.setAttribute("articleType", articleType);
//		if(articleType==null){
//			return "list";
//		}
//		LogUtil.logger.info("记录日志信息!");
//		// 设置每页查询的条数
//		page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
//		//设置排序的字段
//		page.setOrderBy("createdate");
//			//设置排序方法
//		page.setOrderType(OrderType.desc);
//		// 根据statePage进行Page对象设置，并查询
//		if (gotoPage == null || gotoPage.length() == 0) {
//			gotoPage = "1";
//		}
//		page.setCurrentPage(Integer.parseInt(gotoPage));
//
//		Long totalRecords = sysarticleService.getTotalCount("articleType.articletypeid",articleType.getArticletypeid() );
//
//		//创建页面
//		page = PageUtil.createPage(page, totalRecords.intValue());
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
//		detachedCriteria.add(Restrictions.eq("articleType", articleType));
//		//根据页面查询数据
//		 result = sysarticleService.findByPager(page,detachedCriteria);
//		 this.setAttribute("result", result);
//		 return "list";
//	}
//
//	/*
//	 *
//	 * 详情页面
//	 *
//	 *
//	 *
//	 */
//	public String viewById(){
//		article=sysarticleService.get(this.id);
//		final String stre=article.getArticlecontent();
//		String [] content=null;
//		if(stre!=null){
//			content=stre.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
//		}
//		//Activity activity=activityService.get(this.proID);
//		//this.setAttribute("activity", activity);
//		//相关信息
//		articleList=sysarticleService.getArticleRI(article.getArticleid(), article.getPagekeywords(), 5);
//		setAttribute("srclength", stre!=null?content.length:0);
//		setAttribute("content", content);
//		return "view";
//	}
//
//	/**
//	 * 分享
//	 *
//	 * @return
//	 */
//	public String  Share(){
//		try {
//			setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME,
//			"00000000000000000000000000000001");
//			if(null==getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
//				getResponse().getWriter().print(-1);// 未登录
//			}else {
//				String articleid = getParameter("articleid");
//				//文章处理记录
//				Article article =sysarticleService.get(articleid);
//				Long i=article.getSharenum();
//				if(i==null){
//					article.setSharenum(new Long(1));
//				}else{
//					article.setSharenum(article.getSharenum() + new Long(1));
//				}
//				//修改文章分享次数
//				sysarticleService.update(article);
//				//修改处理表记录
//				SysArticleHandleRec articleHandleRec=new SysArticleHandleRec();
//				articleHandleRec.setArticle(article);
//				articleHandleRec.setActiontype(new Long(1));
//				articleHandleRec.setActiondate(new Date());
//				String memberid = HttpUtil.getSession(
//						Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
//				//获得用户信息
//				Member member =memberService.get(memberid);
//				articleHandleRec.setMember(member);
//				sysarticleHandleService.save(articleHandleRec);
//				getResponse().getWriter().print(1);
//			}
//		} catch (Exception e) {
//		}
//		return null;
//	}
//
//	/**
//	 * 收藏
//	 *
//	 * @return
//	 */
//	public String Collect() {
//		try {
//			setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME,
//			"00000000000000000000000000000001");
//			String memberid = HttpUtil.getSession(
//					Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
//			//获得用户信息
//			Member member =memberService.get(memberid);
//			if (null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)) {
//				getResponse().getWriter().print(-1);// 未登录
//			} else {
//				String articleid = getParameter("articleid");
//				boolean b=sysarticleHandleService.isExistisExistByReadhandle(articleid, new Long(2), memberid);
//				if (b==true) {
//					getResponse().getWriter().print(-2);// 已收藏
//				}
//				else {
//					//文章处理记录
//					Article article =sysarticleService.get(articleid);
//					Long i=article.getCollectionnum();
//					if(i==null){
//						article.setCollectionnum(new Long(1));
//					}else{
//						article.setCollectionnum(article.getCollectionnum() + new Long(1));
//					}
//					//修改文章分享次数
//					sysarticleService.update(article);
//					//修改处理表记录
//					SysArticleHandleRec articleHandleRec=new SysArticleHandleRec();
//					articleHandleRec.setArticle(article);
//					articleHandleRec.setActiontype(new Long(2));
//					articleHandleRec.setActiondate(new Date());
//					articleHandleRec.setMember(member);
//					sysarticleHandleService.save(articleHandleRec);
//					getResponse().getWriter().print(1);
//				}
//			}
//			getResponse().getWriter().close();
//		} catch (Exception e) {
//			getRequest().setAttribute("exception", e.toString());
//
//			e.printStackTrace();
//			return ERROR;
//		}
//		return null;
//	}
//	public IActivityService getActivityService() {
//		return activityService;
//	}
//	public void setActivityService(IActivityService activityService) {
//		this.activityService = activityService;
//	}
//}
