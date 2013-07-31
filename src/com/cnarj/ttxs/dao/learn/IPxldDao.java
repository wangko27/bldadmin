package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

/**
 * 学习频道Dao接口类 - 品学论道
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月20日
 */
public interface IPxldDao extends IBaseDao<ArticleSrc, String> {
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
