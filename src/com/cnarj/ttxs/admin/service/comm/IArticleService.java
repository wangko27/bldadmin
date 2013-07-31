package com.cnarj.ttxs.admin.service.comm;

import java.io.File;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道后台Service接口类 - 文章
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月15日
 */
public interface IArticleService extends IBaseService<ArticleSrc, String> {

	/**
	 * 添加文章
	 * 
	 * @param readSrc
	 * @throws Exception
	 */
	public void saveArticleSrc(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 修改文章
	 * 
	 * @param readSrc
	 * @throws Exception
	 */
	public void updateArticleSrc(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 查询品学论道（带分页）
	 * 
	 * @param page
	 * @param memberType
	 * @param isrecommend
	 * @param articletypeid
	 * @return
	 */
	public Result listArticleByPxldArticlePage(Page page, Long memberType,
			String isrecommend, String articletypeid, String articletitle)
			throws Exception;

	/**
	 * 查询资讯内容（带分页）
	 * 
	 * @param page
	 * @param memberType
	 * @param isrecommend
	 * @param articletypeid
	 * @return
	 */
	public Result listArticleByInformationPage(Page page, String articletypeid,
			String articletitle) throws Exception;

	/**
	 * 删除文章（真删）
	 * 
	 * @param articlesrcid
	 * @throws Exception
	 */
	public void deleteArticle(String articlesrcid) throws Exception;

	/**
	 * 禁用文章（假删）
	 * 
	 * @param articlesrcid
	 * @throws Exception
	 */
	public void updateArticleByPublication(String articlesrcid)
			throws Exception;
}
