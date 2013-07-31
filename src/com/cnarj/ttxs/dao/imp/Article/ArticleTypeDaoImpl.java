package com.cnarj.ttxs.dao.imp.Article;

import java.util.List;

import com.cnarj.ttxs.dao.Article.IArticleTypeDao;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.pojo.comm.ArticleType;
/**
 * 测试实现类 - 用于测试的Dao实现类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */


public class ArticleTypeDaoImpl extends BaseDaoImpl<ArticleType, String> implements IArticleTypeDao {

	public Long getAllArticleParentTypeTotalCount() {
		String hql="Select count(*) from ArticleType where articleType is null and articletypename is not null";
		Long lo=(Long) getSession().
		createQuery(hql).
		uniqueResult();
		 if(null==lo){
			 return lo;
		 }
		return lo;
	}
	@SuppressWarnings("unchecked")
	public List<ArticleType> getAllArticleParentType() {
		// TODO Auto-generated method stub
		String hql="from ArticleType where articleType is null and articletypename is not null";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
	}
	
}
	

