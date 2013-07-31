package com.cnarj.ttxs.web.actions.learn;


import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.Article.IArticleHandleRecService;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 学习频道Action类 - 有限制的，需要登录才进入的
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年10月10日
 */
public class RestrictionAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IReadbookService readbookService;

	private IArticleService articleService;

	private IArticleHandleRecService articleHandleRecService;

	// 要跳转的页面
	private String forwardurl;

	public IReadbookService getReadbookService() {
		return readbookService;
	}

	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public String getForwardurl() {
		return forwardurl;
	}

	public void setForwardurl(String forwardurl) {
		this.forwardurl = forwardurl;
	}

	public IArticleHandleRecService getArticleHandleRecService() {
		return articleHandleRecService;
	}

	public void setArticleHandleRecService(
			IArticleHandleRecService articleHandleRecService) {
		this.articleHandleRecService = articleHandleRecService;
	}

	/**
	 * 分享资源
	 * 
	 * @return
	 */
	public String toShareResource() {
		try {
			// 最后访问的地址 登录成功后要返回的页面
			String lastUrl = getRequest().getHeader("Referer");
			String readsrcid = getParameter("readsrcid");
			readbookService.saveReadhandle(readsrcid, new Long(1), lastUrl);
			this.addActionMessage("分享成功!");
			return forwardurl;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 分享文章
	 * 
	 * @return
	 */
	public String toShareArticle() {
		try {
			// 最后访问的地址 登录成功后要返回的页面
			String lastUrl = getRequest().getHeader("Referer");
			String articlesrcid = getParameter("articlesrcid");
			articleService
					.saveArticlehandle(articlesrcid, new Long(1), lastUrl);
			this.addActionMessage("分享成功!");
			setAttribute("flag", 1);
			return forwardurl;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 收藏资源
	 * 
	 * @return
	 */
	public String toCollectResource() {
		try {
			// 最后访问的地址 登录成功后要返回的页面
			String lastUrl = getRequest().getHeader("Referer");

			String readsrcid = getParameter("readsrcid");
			if (readbookService.isExistByReadhandle(readsrcid, new Long(2))) {
				this.addActionMessage("该资源已收藏,请不要重复收藏!");
			} else {
				readbookService.saveReadhandle(readsrcid, new Long(2), lastUrl);
				this.addActionMessage("收藏成功!");
			}

			return forwardurl;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 收藏文章
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String toCollectArticle() {
		try {
			// 最后访问的地址 登录成功后要返回的页面
			String lastUrl = getRequest().getHeader("Referer");

			String articlesrcid = getParameter("articlesrcid");
			// 用户ID
			String memberid = HttpUtil.getSession(
					Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			if (articleHandleRecService.isExistByReadhandle(articlesrcid,
					new Long(2), memberid)) {
				this.addActionMessage("该信息已收藏,请不要重复收藏!");
			} else {
				articleService.saveArticlehandle(articlesrcid, new Long(2),
						lastUrl);
				this.addActionMessage("收藏成功!");
			}

			return forwardurl;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 下载（更改相关下载记录）
	 * 
	 * @return
	 */
	public String toDownResource() {
		try {
			String readsrcid = getParameter("readsrcid");
			// 如果该资源未下载过，则会添下载记录
			if (!readbookService.isExistByReaddown(readsrcid)) {
				// 积分是否够用
				if (readbookService.isHaveByDownPoint(readsrcid)) {
					// 第一次下载
					readbookService.saveReaddown(readsrcid);
					return toDownFile();
				} else {
					this.addActionMessage("你的积分不够，无法下载!");
					return forwardurl;
				}
			} else {
				return toDownFile();
			}
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 下载文件
	 * 
	 * @return
	 */
	public String toDownFile() {
		try {
			String readsrcid = getParameter("readsrcid");
			// 下载资源
			readbookService.readdown(readsrcid);
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
		return forwardurl;
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		try {
			return "login";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 验证
	 */

	public void validate() {
		if (HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME) == null) {
			this.addActionError("请先登录!");
		}
	}

}
