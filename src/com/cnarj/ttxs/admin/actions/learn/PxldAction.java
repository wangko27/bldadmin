package com.cnarj.ttxs.admin.actions.learn;

import com.cnarj.ttxs.admin.service.comm.IArticleService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 学习频道后台Action类 - 品学论道
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月23日
 * 
 */
public class PxldAction extends PageAction implements ModelDriven<ArticleSrc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArticleSrc articleSrc = new ArticleSrc();

	private IArticleService articleService;

	public ArticleSrc getModel() {
		return articleSrc;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * 打开品学论道管理列表页面
	 * 
	 * @return
	 */
	public String openPxld() {
		try {
			// 查询所有名师
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			Long memberType = null;
			if (null != getParameter("memberType")
					&& !"".equals(getParameter("memberType"))) {
				memberType = new Long(getParameter("memberType"));
			}
			// 品学论道
			String articletypeid = "8a8081a131cd5fcd0131cd6a83e40004";
			result = articleService.listArticleByPxldArticlePage(page,
					memberType, articleSrc.getIsrecommend(), articletypeid,
					articleSrc.getArticletitle());

			setAttribute("list_pxld_article", result.getContent());

			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 取消推荐
	 * 
	 * @return
	 */
	public String cancelRecommendPxld() {
		try {
			ArticleSrc articleSrcNew = articleService.get(articleSrc
					.getArticlesrcid());
			articleSrcNew.setIsrecommend("0");
			articleService.update(articleSrcNew);
			this.addActionMessage("移除成功!");
			return openPxld();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 取消推荐
	 * 
	 * @return
	 */
	public String recommendPxld() {
		try {
			ArticleSrc articleSrcNew = articleService.get(articleSrc
					.getArticlesrcid());
			articleSrcNew.setIsrecommend("1");
			articleService.update(articleSrcNew);
			this.addActionMessage("推荐成功!");
			return openPxld();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

}
