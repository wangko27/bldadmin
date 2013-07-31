package com.cnarj.ttxs.dao.Article;




import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 测试Dao接口 - 用于测试的Dao接口
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public interface ISysArticleDao extends IBaseDao<Article,String>{
	/*
	 * 根据hql分页
	 */
	public Result getarticle(Page page,String hql);
	public List<Article> getarticle(String hql,int num);
	/*
	 * 获得系统文章相关文章
	 * 
	 */
	public   List<Article> getNewsNoticeRI(String articleid, String pagekeywords,int num);
	/**
	 * 根据文章类别和关键字分页
	 * @param propertyName
	 * 			属性名称
	 * @param value
	 * 			属性值
	 * @return 是实体对象总数
	 */
	public Result searchArticle(String type,Object value,String metakeywords,Page page);
	/**
	 * 根据HQL获取实体对象总数
	 * @param propertyName
	 * 			属性名称
	 * @param value
	 * 			属性值
	 * @return 是实体对象总数
	 */
	public Long searchArticle(String type,Object value,String metakeywords);
	/**
	 * 根据关键字查询分页
	 * 
	 */
	
	public Result getarticlebyRI(Page page,String metakeywords) ;
	/**
	 * 根据文章的类别分页.
	 * 
	 */
	
	public Result getarticlebyType(Page page,String type,Object value) ;
	/**
	 * 根据关键字查询总数——分页
	 * 
	 */
	
	public Long getarticlebyRI(String metakeywords) ;
	/**
	 * 根据文章的上级类别分页.
	 * 
	 */
	
	public Result getarticlebyparentType(Page page,String  articleTypeId) ;
	/**
	 * 查询所有系统公告.
	 * 
	 */
	
	public Result getallnotice(Page page,String  articletypepath) ;
	/**
	 * 获得最新系统文章 
	 * 
	 */
	public  List<Article> getNewsNotice(int num);
	/**
	 * 根据上级类别获取所有对象总数
	 * @param propertyName
	 * 			属性名称
	 * @param value
	 * 			属性值
	 * @return 是实体对象总数
	 */
	public Long getTotalCountByChildtypeList(String[] values) ;
	/**
	 * 根据类别查询系统文章.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value    置顶，类别，是否发布，是否推荐，排序字段， 查询开始位置，查询结束位置
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<Article> getArticle(String articletype,Object value, int num);
	/**
	 * 系统文章相关信息.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value    置顶，类别，是否发布，是否推荐，排序字段， 查询开始位置，查询结束位置
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<Article> getArticleRI(String articleid, String pagekeywords,int shownum) ;
	/**
	 * 根据类别查询系统文章.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value    置顶，类别，是否发布，是否推荐，排序字段， 查询开始位置，查询结束位置
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<Article> getArticle(int num);	
}
