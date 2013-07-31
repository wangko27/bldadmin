package com.cnarj.ttxs.dao.imp.Article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.dao.Article.ISysArticleDao;
import com.cnarj.ttxs.dao.Article.ISysArticleTypeDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;

/**
 * 测试实现类 - 用于测试的Dao实现类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */


public class SysArticleTypeDaoImpl extends BaseDaoImpl<SysArticleType, String> implements ISysArticleTypeDao {
	@SuppressWarnings("unchecked")
	public List<SysArticleType> listBychildtype(){
		String hql="from SysArticleType where articleType is null";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
		
	}
}
