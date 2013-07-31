package com.cnarj.ttxs.service.Article;

import java.util.List;
import java.util.Map;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 用于测试的service接口
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public interface IArticleService extends IBaseService<ArticleSrc, String> {
	/*
	 * 生活百科-分页
	 * 
	 */
		public Result searchbaikelist(Page page, String articleTypeId) ;
		/*
		 * 获得新闻总数
		 * 
		 */
		public Long getbaikeTotalCount(String articleTypeId) ;
	/*
	 * 获得最新资料
	 * 
	 */
	public List<ArticleSrc> getShareArticleSrc(String articleType, int num);

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
	 * 根据HQL获取实体对象总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 是实体对象总数
	 */
	public Long getnewsTotalCount(String articleTypeId);

	/**
	 * 根据Freemarker模板文件路径、Map数据生成HTML静态文件
	 * 
	 * @param templateFilePath
	 *            Freemarker模板文件路径
	 * 
	 * @param htmlFilePath
	 *            生成HTML静态文件存放路径
	 * 
	 * @param data
	 *            Map数据
	 * 
	 */
	public void buildHtml(String templateFilePath, String htmlFilePath,
			Map<String, Object> data);

	/*
	 * 根据关键字 类别， 是否推荐 查询相关文章
	 */
	public List<ArticleSrc> getArticleSrcRI(String articletype,Object value,String articlesrcid,String aritlcettitle, String metakeywords,String isrecommend, int shownum) ;

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
	 * 根据类别获取所有对象总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 是实体对象总数
	 */
	public List<ArticleSrc> getEducationByhql(String articleType, Object value,
			int num);

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
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<ArticleSrc> getTopArticleSrc(String istop, String isrecommend,
			String orderBy, int start, int stop);

	/**
	 * 文章处理记录(收藏,分享)
	 * 
	 * @param articlesrcid
	 *            ID
	 * @param actiontype
	 *            处理类型(2收藏,1分享)
	 * @throws Exception
	 */
	public void saveArticlehandle(String articlesrcid, Long actiontype,
			String actionpath) throws Exception;

	/*
	 * 查询品学论道
	 * 
	 */
	public List<ArticleSrc> getPualArticle(int num);

	/**
	 * 根据上级类别查询下级类别
	 * 
	 * @param articleTypeId
	 *            文章类别ID
	 */
	public Result getarticlebyparentType(Page page, String articleTypeId);

	/*
	 * 获得新闻动态相关内容
	 * 
	 */
	public Result searchArticle(Page page, String articleTypeId);
}
