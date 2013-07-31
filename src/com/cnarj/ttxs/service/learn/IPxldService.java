package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道Service接口类 - 品学论道
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月20日
 */
public interface IPxldService extends IBaseService<ArticleSrc, String> {

	/**
	 * 查询推荐的品学论道文章
	 * 
	 * @param shownum
	 *            显示数量
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List listArticleByRecommend(int shownum) throws Exception;

}
