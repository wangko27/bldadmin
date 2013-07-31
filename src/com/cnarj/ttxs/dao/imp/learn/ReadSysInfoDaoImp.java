package com.cnarj.ttxs.dao.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IReadSysInfoDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 学习频道Dao接口类实现类 - 系统信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public class ReadSysInfoDaoImp extends BaseDaoImpl<Article, String> implements IReadSysInfoDao {
	
	@SuppressWarnings("unchecked")
	public List<Article> getArticle(int num) {
		List<Article> list=this.getSession().
		createQuery("from Article as a1 where a1.ispublication=1 and a1.articleType.articletypeid='8a80818c31b6a6270131b6a835780012' order by a1.modifydate desc")
		.setMaxResults(num).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Article> getArticle(String articletype, int num){
		List<Article> list=this.getSession().
		createQuery("from Article as a1 where a1.ispublication=1 and a1.articleType.articletypename='"+articletype+"' order by a1.createdate desc")
		.setMaxResults(num).list();
		return list;
		}
	public Article getArticle(String articleId) {
		return (Article) this.getSession().createQuery("from Article a where a.articleid=?").setParameter(0, articleId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Article> getXingGuanArticle(int num, String keyString,
			String articleId) {
		List<Article> list=this.getSession().
		createQuery("from Article as a1 " +
				"where a1.ispublication=1 and a1.articleType.articletypeid='8a80818c31b6a6270131b6a835780012' " +
				"and a1.pagekeywords=? and a1.articleid<>? order by a1.createdate desc")
		.setParameter(0, keyString).setParameter(1, articleId).setMaxResults(num).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Article> getArticleSrcRI(Object pagekeywords) {
		// TODO Auto-generated method stub
		String hql ="from Article where pagekeywords like '"+pagekeywords+"'  and rownum <=5 order by createdate desc";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
	}
}
