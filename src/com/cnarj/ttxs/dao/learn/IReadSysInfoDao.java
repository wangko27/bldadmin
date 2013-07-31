package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 学习频道Dao接口类 - 系统信息3条
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IReadSysInfoDao extends IBaseDao<Article, String>{

	/**
	 * 栏目条数  num
	 * 得到3条系统信息
	 * @return
	 */
	public List<Article> getArticle(int num);
	/**
	 * 按系统公告Id查询系统公告信息
	 */
	public Article getArticle(String articleId);
	/**
	 * 根据类别取得系统信息
	 * @return
	 */
	public List<Article> getArticle(String articletype, int num);
	
	
	/**
	 * 根据属性名和属性值获取相关实体对象集合.
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<Article> getArticleSrcRI(Object pagekeywords) ;
}
