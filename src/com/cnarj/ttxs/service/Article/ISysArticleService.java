package com.cnarj.ttxs.service.Article;

import java.util.List;
import java.util.Map;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 用于测试的service接口
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public interface ISysArticleService extends IBaseService<Article, String>{
	/*
	 * 根据关键字 类别查询系统文章
	 * 
	 */
	public Result listArticleByInformationPage(Page page, String articleType,String articletitle) ;
	/*
	 * 查找 商城资讯
	 * 
	 */
	public Result getshoparticle(Page page, String articleType);
	/*
	 * 查询新知识
	 * 
	 */
	public List<Article> getactivitynews(int num);
	/*
	 * 获得系统文章相关文章
	 * 
	 */
	public   List<Article> getNewsNoticeRI(String articleid, String pagekeywords,int num);
	/**
	 * 查询系统所以系统公告.
	 * 
	 */
	
	public Result getallnotice(Page page,String  articleTypeId) ;
	/**
	 * 获得最新系统文章 
	 * 
	 */
	public  List<Article> getNewsNotice(int num);
	/**
	 * 根据上级类别分页
	 * @param propertyName
	 * 			属性名称
	 * @param value
	 * 			属性值
	 * @return 是实体对象总数
	 */
	public Result searchArticle(String type,Object value,String metakeywords,Page page);
	/**
	 * 根据类别
	 * @param propertyName和关键字查询对象总数
	 * 			属性名称
	 * @param value
	 * 			属性值
	 * @return 是实体对象总数
	 */
	public Long searchArticle(String type,Object value,String metakeywords);
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
	 * 根据列表查询系统文章.
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
	public List<Article> getArticleRI(String articleid, String pagekeywords,int shownum);

	/**
	 * 根据上级类别查询下级类别
	 * 
	 * @param articleTypeId
	 *            文章类别ID
     */
	public Result getarticlebyparentType(Page page,String  articleTypeId);
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
	/**
	 * 根据关键字查询文章总数
	 * 
	 */
	public Long getarticlebyRI(String metakeywords);
	/**
	 * 根据关键字查询分页
	 * 
	 */
	public Result getarticlebyRI(Page page,String metakeywords) ;
	/**
	 * 根据类别分页
	 * 
	 */
	
	public Result getarticlebyType(Page page,String type,Object value) ;
}
