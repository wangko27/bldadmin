package com.cnarj.ttxs.admin.service.learn;

import java.io.File;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道后台Service接口类 - 名校风采
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月24日
 */
public interface ISchoolService extends IBaseService<ArticleSrc, String> {

	/**
	 * 添加名校风采
	 * 
	 * @param readSrc
	 * @param cover
	 *            封面
	 * @param coverFileName
	 * @param coverContentType
	 * @throws Exception
	 */
	public void saveArticleSrcBySchool(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 修改文章-名校风采
	 * 
	 * @param readSrc
	 * @param cover
	 *            封面
	 * @param coverFileName
	 * @param coverContentType
	 * @throws Exception
	 */
	public void updateArticleSrcBySchool(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 查询名校风采（带分页）
	 * 
	 * @param page
	 * @param istop
	 * @param isrecommend
	 * @param ispublication
	 * @param articletypeid
	 * @param schoolname
	 * @return
	 */
	public Result listArticleBySchoolPage(Page page, String istop,
			String isrecommend, String ispublication, String schoolname)
			throws Exception;

	/**
	 * 删除名校风采
	 * 
	 * @param articlesrcid
	 */
	public void deleteSchool(String articlesrcid);

}
