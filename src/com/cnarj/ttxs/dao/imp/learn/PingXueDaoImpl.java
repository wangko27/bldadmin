package com.cnarj.ttxs.dao.imp.learn;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IPinXueDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

/**
 * 品学论道的实现类 * @author Administrator
 *
 */
public class PingXueDaoImpl extends BaseDaoImpl<ArticleSrc, String> implements IPinXueDao {

	/**
	 * 实现方法
	 */
	public Result getAllPingArticle(String hql, Page page) {
		return this.findByPager(page, hql);
	}

}
