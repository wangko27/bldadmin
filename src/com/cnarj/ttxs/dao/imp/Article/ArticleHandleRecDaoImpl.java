package com.cnarj.ttxs.dao.imp.Article;
import org.hibernate.Query;

import com.cnarj.ttxs.dao.Article.IArticleHandleRecDao;
import com.cnarj.ttxs.pojo.comm.ArticleHandleRec;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;

/**
 * 测试实现类 - 用于测试的Dao实现类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */


public class ArticleHandleRecDaoImpl extends BaseDaoImpl<ArticleHandleRec, String> implements IArticleHandleRecDao {


	public boolean isExistisExistByReadhandle(String articlesrcid,
			Long actiontype, String memberid) {
		// TODO Auto-generated method stub
		String hql = "select count(*)  from ArticleHandleRec h where h.articleSrc.articlesrcid=? and h.actiontype=? and h.member.memberid=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, articlesrcid);
		query.setLong(1, actiontype);
		query.setString(2, memberid);
		if (((Long) query.uniqueResult()) > new Long(0)) {
			return true;
		} else {
			return false;
		}
	}


}
