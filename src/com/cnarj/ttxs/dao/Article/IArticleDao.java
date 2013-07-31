package com.cnarj.ttxs.dao.Article;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.dao.IBaseDao;

/**
 * 测试Dao接口 - 用于测试的Dao接口
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public interface IArticleDao extends IBaseDao<ArticleSrc, String> {
	/**
	 * 根据HQL获取实体对象总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 是实体对象总数
	 */
	public Result searchArticle(String type, Object value, String metakeywords,
			Page page);

	/**
	 * 根据HQL获取实体对象总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 是实体对象总数
	 */
	public Long searchArticle(String type, Object value, String metakeywords);
	/**
	 * 根据HQL获取所有对象总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 是实体对象总数
	 */
	public List<ArticleSrc> getArticleByhql(String hql,int num);

	/**
	 * 根据类别获取所有对象总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 是实体对象总数
	 */
	public Long getTotalCountBytype(String propertyName, Object value);

	/*
	 * 根据关键字 类别， 是否推荐 查询相关文章
	 */
	public List<ArticleSrc> getArticleSrcRI(String articletype,Object value,String articlesrcid,String aritlcettitle, String metakeywords,String isrecommend, int shownum) ;
	/*
	 * 获得最新资料
	 * 
	 */
	public List<ArticleSrc> getShareArticleSrc(String articleType, int num);
	/**
	 * 根据类别获取所有对象总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 是实体对象总数
	 */
	public Long getTotalCountByChildtypeList(String[] values);

	/**
	 * 首页推荐文章.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            置顶，类别，是否发布，是否推荐，排序字段， 查询开始位置，查询结束位置 属性值
	 * @return 实体对象集合
	 */
	public List<ArticleSrc> getShareArticleSrc(String articleType,
			String isrecommend, int num);

	/**
	 * 根据文章的分享次数，文章的发布时间查找文章列表.
	 * 
	 * @param 属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<ArticleSrc> getTopArticleSrc(String istop, String isrecommend,
			String orderBy, int start, int stop);

	/*
	 * 查询品学论道
	 * 
	 */
	public List<ArticleSrc> getPualArticle(int num);

	/**
	 * 根据文章的上级类别分页.
	 * 
	 */
	public Result getarticlebyparentType(Page page, String articleTypeId);

	/**
	 * 查询品学论道（带分页）
	 * 
	 * @param page
	 * @param memberType
	 * @param isrecommend
	 * @param articletypeid
	 * @param articletitle
	 * @return
	 */
	public Result listArticleByPxldArticlePage(Page page, Long memberType,
			String isrecommend, String articletypeid, String articletitle)
			throws Exception;

	/**
	 * 查询名校风采（带分页）
	 * 
	 * @param page
	 * @param istop
	 * @param isrecommend
	 * @param ispublication
	 * @param schoolname
	 * @return
	 */
	public Result listArticleBySchoolPage(Page page, String istop,
			String isrecommend, String ispublication, String schoolname)
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
	/*
	 * 根据hql查询分页
	 */
	public Result getarticle(Page page, String hql);
	/*
	 * 根据hql查询分页
	 */
	public Long geTotalCount(String hql);
}
