package com.cnarj.ttxs.dao.imp.Article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.dao.Article.ISysArticleDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;

/**
 * 测试实现类 - 用于测试的Dao实现类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author slygetNewsNotice
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */


public class SysArticleDaoImpl extends BaseDaoImpl<Article, String> implements ISysArticleDao {
	@SuppressWarnings("unchecked")
	public List<Article> getarticle(String hql,int num){
		List list = getSession().
		createQuery(hql).setMaxResults(num).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public   List<Article> getNewsNotice(int num){
		String hql ; 
		hql="from Article where articleType.articletypeid='8a80818c31b6a6270131b6a835780012' and ispublication='1' order by  modifydate desc";
	List list = getSession().
	createQuery(hql).
	setMaxResults(num).list();
	return list;
	}
	@SuppressWarnings("unchecked")
	public   List<Article> getNewsNoticeRI(String articleid, String pagekeywords,int num){
		String hql ; 
		hql="from Article where articleType.articletypeid='8a80818c31b6a6270131b6a835780012' and ispublication='1' and articleid!='"
		+articleid+"'";
		StringBuffer sbWhere = new StringBuffer(" and ( ");
		String[] keys = pagekeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" pagekeywords like '%" + key
						+ "%' or articletitle like '%" + key + "%'");
			}
		}
		if (sbWhere.indexOf("or") != -1) {// 有条件
			sbWhere.append(" ) ");
			hql += sbWhere.toString();
		}
		List list = getSession().
		createQuery(hql).
		setMaxResults(num).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Article> getArticleRI(String articleid, String pagekeywords,int shownum){
		String hql ="from Article a where a.articleType.articleType.articletypeid='8a8081a131f9e2370131fa261a850001' and a.ispublication='1' and a.isrecommend='1'  and a.articleid!='"
			+ articleid + "'";
			StringBuffer sbWhere = new StringBuffer(" and ( ");
			String[] keys = pagekeywords.split(" ");
			for (int i = 0; i < keys.length; i++) {
				String key = keys[i];
				if (null != key && !"".equals(key)) {
					if (i != 0) {
						sbWhere.append(" or ");
					}
					sbWhere.append(" pagekeywords like '%" + key
							+ "%' or articletitle like '%" + key + "%'");
				}
			}
			if (sbWhere.indexOf("or") != -1) {// 有条件
				sbWhere.append(" ) ");
				hql += sbWhere.toString();
			}

			return this.getSession().
			createQuery(hql).
			setMaxResults(shownum).list();
	}
	@SuppressWarnings("unchecked")
	public List<Article> getArticle(String articletype,Object value, int num){
		String hql="from Article as a1 where a1.ispublication='1' and a1.isrecommend='1' and a1.articleType."+articletype+"='"+value+"' order by a1.modifydate desc";
		List<Article> list=this.getSession().
		createQuery(hql)
		.setMaxResults(num).list();
		return list;
		}
	public Long getTotalCountByChildtypeList(String[] values)  {
		// TODO Auto-generated method stub
		Assert.notEmpty(values, "values must not be empty");
		String hql="select count(*) from Article where articleType.articletypeid in(:values)";
		return (Long) getSession().
		createQuery(hql).setParameterList("values", values).
		uniqueResult();
	}
	public Result getarticlebyparentType(Page page,String  articleTypeId) {
		// TODO Auto-generated method stub
		StringBuffer sbHql = new StringBuffer("from Article t where t.articleType.articleType.articletypeid='").append(articleTypeId).append("'");		
		return this.findByPager(page, sbHql.toString());
	}
	public Result searchArticle(String type,Object value, String metakeywords ,Page page) {
		// TODO Auto-generated method stub
		String hql ="from Article a where a.articleType."+type+"='"+value+"'";
		StringBuffer sbWhere = new StringBuffer(" and ( ");
		String[] keys = metakeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" pagekeywords like '%" + key
						+ "%' or articletitle like '%" + key + "%'");
			}
		}
		if (sbWhere.indexOf("or") != -1) {// 有条件
			sbWhere.append(" ) ");
			hql += sbWhere.toString();
		}
		return this.findByPager(page, hql);
	}
	public Long searchArticle(String type, Object value, String metakeywords) {
		// TODO Auto-generated method stub
		String hql ="select count (*) from Article a where a.articleType."+type+"='"+value+"'";
		StringBuffer sbWhere = new StringBuffer(" and ( ");
		String[] keys = metakeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" pagekeywords like '%" + key
						+ "%' or articletitle like '%" + key + "%'");
			}
		}
		if (sbWhere.indexOf("or") != -1) {// 有条件
			sbWhere.append(" ) ");
			hql += sbWhere.toString();
		}
		return  (Long) getSession().createQuery(hql).uniqueResult();
	}
	public Result getallnotice(Page page, String articletypepath) {
		// TODO Auto-generated method stub
		String hql ="from Article a where a.articleType.articleType is null and a.articleType.articletypepath='"+articletypepath+"'";
		return this.findByPager(page, hql);
	}
	@SuppressWarnings("unchecked")
	public List<Article> getArticle(int num) {
		// TODO Auto-generated method stub
		String hql ="from Article a where a.articleType.articleType is null and isrecommend='1' and a.articleType.articletypepath='sys'and ispublication='1'  order by istop desc, a.modifydate desc";
		
		return this.getSession().
		createQuery(hql).
		setMaxResults(num).list();
	}
	public Long getarticlebyRI(String metakeywords) {
		// TODO Auto-generated method stub
		String hql ="select count (*) from Article ";
		StringBuffer sbWhere = new StringBuffer();
		String[] keys = metakeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				sbWhere.append(" where ");
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" pagekeywords like '%" + key
						+ "%' or articletitle like '%" + key + "%'");
			}
		}
		if (sbWhere.indexOf("or") != -1) {// 有条件
			sbWhere.append(" ) ");
			hql += sbWhere.toString();
		}
		
		return  (Long) getSession().createQuery(hql).uniqueResult();
	}
	public Result getarticlebyType(Page page, String type, Object value) {
		// TODO Auto-generated method stub
		StringBuffer sbHql = new StringBuffer("from Article t where t.articleType."+type+"='").append(value).append("'");		
		return this.findByPager(page, sbHql.toString());
	}
	public Result getarticlebyRI(Page page, String metakeywords) {
		// TODO Auto-generated method stub
		String hql ="select count (*) from Article ";
		StringBuffer sbWhere = new StringBuffer();
		String[] keys = metakeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				sbWhere.append(" where ");
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" pagekeywords like '%" + key
						+ "%' or articletitle like '%" + key + "%'");
			}
		}
		if (sbWhere.indexOf("or") != -1) {// 有条件
			sbWhere.append(" ) ");
		}
		sbWhere.append(" order by createdate desc");
		hql += sbWhere.toString();
		return this.findByPager(page, hql);
	}
	/*
	 * 根据hql分页
	 */
	public Result getarticle(Page page,String hql){
		return this.findByPager(page, hql);
	}
}
