package com.cnarj.ttxs.dao.learn;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

/**
 * 学习频道的品学论道
 * @author Administrator
 *李万余
 */
public interface IPinXueDao extends IBaseDao<ArticleSrc, String> {

	/**
	 * 
	 * @param hql hql语句
	 * @param page 分页
	 * @return 结果集
	 */
	public Result getAllPingArticle(String hql,Page page);
}
