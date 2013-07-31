package com.cnarj.ttxs.service.imp.Article;
import com.cnarj.ttxs.dao.Article.IArticleHandleRecDao;
import com.cnarj.ttxs.pojo.comm.ArticleHandleRec;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.Article.IArticleHandleRecService;




/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class ArticleHandleRecServiceImpl extends BaseServiceImpl<ArticleHandleRec,String> implements IArticleHandleRecService {
	
	public void setBaseDao(IArticleHandleRecDao ArticleHandleRecDao) {
		super.setBaseDao(ArticleHandleRecDao);
	}
	private IArticleHandleRecDao ArticleHandleRecDao;
	
	
	public IArticleHandleRecDao getArticleHandleRecDao() {
		return ArticleHandleRecDao;
	}


	public void setArticleHandleRecDao(IArticleHandleRecDao articleHandleRecDao) {
		ArticleHandleRecDao = articleHandleRecDao;
	}


	public boolean isExistByReadhandle(String articlesrcid, Long actiontype,
			String memberid) {
				return ArticleHandleRecDao.isExistisExistByReadhandle(articlesrcid, actiontype, memberid);		
	}
}