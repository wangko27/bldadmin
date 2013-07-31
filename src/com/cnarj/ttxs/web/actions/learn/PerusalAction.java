package com.cnarj.ttxs.web.actions.learn;

import java.util.Date;
import java.util.List;



import com.cnarj.ttxs.pojo.comm.ArticleHandleRec;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.Article.IArticleHandleRecService;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.service.Article.IArticleTypeService;
import com.cnarj.ttxs.util.HttpUtil;

import com.cnarj.ttxs.web.actions.base.PageAction;

public class PerusalAction extends PageAction {
	private IArticleService articleService;
	private IArticleTypeService articleTypeService;
	private IArticleHandleRecService articleHandleRecService;
	private MemberService memberService;
	private String id;
	private String liindex;
	public String getLiindex() {
		return liindex;
	}

	public void setLiindex(String liindex) {
		this.liindex = liindex;
	}

	public IArticleHandleRecService getArticleHandleRecService() {
		return articleHandleRecService;
	}

	public void setArticleHandleRecService(
			IArticleHandleRecService articleHandleRecService) {
		this.articleHandleRecService = articleHandleRecService;
	}
	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
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
	
	
	/**
	 * 文章详情和关联查询 
	 * 
	 * @return
	 */
	
	public String getArticleById(){
		//根据id查询文章详情
		
	   ArticleSrc articleSrc=articleService.get(this.id);
	   System.out.println(this.id);
	   this.setAttribute("articleSrc", articleSrc);
		String stre=articleSrc.getArticlesrccontent();
		String [] content=null;
		if(stre!=null){
			content=stre.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
		}
		setAttribute("srclength", stre!=null?content.length:0);
		setAttribute("content", content);
		//查询评学了论道关联查询
		List<ArticleSrc> articleList=articleService.getArticleSrcRI("articletypeid", articleSrc.getArticleType().getArticletypeid(), articleSrc.getArticlesrcid(),articleSrc.getArticletitle(), articleSrc.getMetakeywords(),articleSrc.getIsrecommend(), 5);
		this.setAttribute("articleList", articleList);
		return "View";		
	}
	
	/**
	 * 推荐
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
				if(articleSrc.getUserpushnum()==null){
					articleSrc.setUserpushnum(new Long(1));
				}else{
					articleSrc.setUserpushnum(articleSrc.getUserpushnum() + new Long(1));
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
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
