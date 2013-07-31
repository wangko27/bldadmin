package com.cnarj.ttxs.service.imp.Article;
import java.util.List;

import com.cnarj.ttxs.dao.Article.IArticleTypeDao;


import com.cnarj.ttxs.service.imp.BaseServiceImpl;

import com.cnarj.ttxs.service.Article.IArticleTypeService;
import com.cnarj.ttxs.pojo.comm.ArticleType;




/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class ArticleTypeServiceImpl extends BaseServiceImpl<ArticleType,String> implements IArticleTypeService {
	public void setBaseDao(IArticleTypeDao articleTypeDao) {
		super.setBaseDao(articleTypeDao);
	}
	private IArticleTypeDao articleTypeDao;
	
	public IArticleTypeDao getArticleTypeDao() {
		return articleTypeDao;
	}

	public void setArticleTypeDao(IArticleTypeDao articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}

	
	
	public Long getAllArticleParentTypeTotalCount() {
		// TODO Auto-generated method stub
		return articleTypeDao.getAllArticleParentTypeTotalCount();
	}

	public List<ArticleType> getAllArticleParentType() {
		// TODO Auto-generated method stub
		return articleTypeDao.getAllArticleParentType();
	}

}