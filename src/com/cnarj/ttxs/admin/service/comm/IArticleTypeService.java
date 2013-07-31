package com.cnarj.ttxs.admin.service.comm;

import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道后台Service接口类 - 文章类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月15日
 */
public interface IArticleTypeService extends IBaseService<ArticleType, String> {

	/**
	 * 添加文章类别
	 * 
	 * @param readSrcType
	 */
	public void saveArticleType(ArticleType articleType) throws Exception;

	/**
	 * 修改文章类别
	 * 
	 * @param readSrcType
	 * @throws Exception
	 */
	public void updateArticleType(ArticleType articleType) throws Exception;

}
