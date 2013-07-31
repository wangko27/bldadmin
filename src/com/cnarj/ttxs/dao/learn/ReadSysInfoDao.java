package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 学习频道Dao接口类 - 系统信息3条
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public interface ReadSysInfoDao extends IBaseDao<Article, Long>{

	/**
	 * 得到3条系统信息
	 * @return
	 */
	public List<Article> get3Article();
	/**
	 * 根据类别取得系统信息
	 * @return
	 */
	public List<Article> getArticle(String articletype, int num);
}
