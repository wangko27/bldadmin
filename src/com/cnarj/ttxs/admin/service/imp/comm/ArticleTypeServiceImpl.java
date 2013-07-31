package com.cnarj.ttxs.admin.service.imp.comm;

import java.util.Date;

import com.cnarj.ttxs.admin.service.comm.IArticleTypeService;
import com.cnarj.ttxs.dao.Article.IArticleTypeDao;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 学习频道后台Service实现类 - 文章类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月15日
 */
public class ArticleTypeServiceImpl extends
		BaseServiceImpl<ArticleType, String> implements IArticleTypeService {

	IArticleTypeDao articleTypeDao;

	public void setBaseDao(IArticleTypeDao articleTypeDao) {
		super.setBaseDao(articleTypeDao);
	}

	public IArticleTypeDao getArticleTypeDao() {
		return articleTypeDao;
	}

	public void setArticleTypeDao(IArticleTypeDao articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}

	/**
	 * 添加文章类别
	 * 
	 * @param readSrcType
	 */
	public void saveArticleType(ArticleType articleType) throws Exception {
		articleType.setCreatedate(new Date());
		articleType.setModifydate(new Date());
		articleTypeDao.save(articleType);
	}

	/**
	 * 修改文章类别
	 * 
	 * @param readSrcType
	 * @throws Exception
	 */
	public void updateArticleType(ArticleType articleType) throws Exception {
		ArticleType newArticleType = articleTypeDao.get(articleType
				.getArticletypeid());
		newArticleType.setArticletypename(articleType.getArticletypename());
		newArticleType.setArticlesort(articleType.getArticlesort());
		newArticleType.setModifydate(new Date());
		articleTypeDao.update(newArticleType);
	}

}
