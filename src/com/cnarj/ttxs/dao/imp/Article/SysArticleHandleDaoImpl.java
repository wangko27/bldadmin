package com.cnarj.ttxs.dao.imp.Article;
import org.hibernate.Query;

import com.cnarj.ttxs.dao.Article.ISysArticleHandleDao;
import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;

/**
 * 测试实现类 - 用于测试的Dao实现类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */


public class SysArticleHandleDaoImpl extends BaseDaoImpl<SysArticleHandleRec, String> implements ISysArticleHandleDao{

	public boolean isExistisExistByReadhandle(String articleid,
			Long actiontype, String memberid) {
		// TODO Auto-generated method stub
		String hql = "select count(*)  from SysArticleHandleRec h where h.article.articleid=? and h.actiontype=? and h.member.memberid=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, articleid);
		query.setLong(1, actiontype);
		query.setString(2, memberid);
		if (((Long) query.uniqueResult()) > new Long(0)) {
			return true;
		} else {
			return false;
		}
	}
}
