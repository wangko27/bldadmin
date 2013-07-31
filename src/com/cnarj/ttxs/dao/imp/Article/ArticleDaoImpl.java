package com.cnarj.ttxs.dao.imp.Article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;

/**
 * 测试实现类 - 用于测试的Dao实现类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class ArticleDaoImpl extends BaseDaoImpl<ArticleSrc, String> implements
		IArticleDao {
	private Class<ArticleSrc> entityClass;

	public Class<ArticleSrc> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<ArticleSrc> entityClass) {
		this.entityClass = entityClass;
	}

	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getArticleByhql(String hql,int num) {
		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}

	public Long getTotalCountBytype(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName must not be empty");
		Assert.notNull(value, "value is required");
		String hql = "select count(*) from ArticleSrc a left join ArticleType at on a.articleType=at.articleType where a."
				+ propertyName + "=?";
		Long lo = (Long) getSession().createQuery(hql).setParameter(0, value)
				.uniqueResult();
		return lo;
	}
	//查询推荐文章相关文章
	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getArticleSrcRI(String articletype,Object value,String articlesrcid,String aritlcettitle, String metakeywords,String isrecommend, int shownum) {
		String hql = "from ArticleSrc  where articleType."+articletype+"='"+value+"' and isrecommend='"+isrecommend+"' and ispublication='1'  and  articlesrcid!='"
				+ articlesrcid + "'";
		StringBuffer sbWhere = new StringBuffer(" and ( ");
		if(metakeywords!=null){
			String[] keys = metakeywords.split(" ");
			for (int i = 0; i < keys.length; i++) {
				String key = keys[i];
				if (null != key && !"".equals(key)) {
					if (i != 0) {
						sbWhere.append(" or ");
					}
					sbWhere.append(" metakeywords like '%" + key
							+ "%' or articletitle like '%" + key + "%'");
				}
			}
			if (sbWhere.indexOf("or") != -1) {// 有条件
				sbWhere.append(" )  order by createdate desc");
				hql += sbWhere.toString();
			}
		}else{
			sbWhere.append("articletitle like '%" + aritlcettitle + "%'");
			sbWhere.append(" )  order by createdate desc");
			hql += sbWhere.toString();
		}
		return this.getSession().createQuery(hql).setMaxResults(shownum).list();
	}

	public Long getTotalCountByChildtypeList(String[] values) {
		// TODO Auto-generated method stub
		Assert.notEmpty(values, "values must not be empty");
		String hql = "select count(*) from ArticleSrc where articleType.articletypeid in(:values)";
		return (Long) getSession().createQuery(hql).setParameterList("values",
				values).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getShareArticleSrc(String articleType,
			String isrecommend, int num) {
		// TODO Auto-generated method stub
		String hql;
			hql = "from ArticleSrc where  articleType.articletypename='"+ articleType + "' and ispublication='1' and isrecommend='"+isrecommend+"' order by istop desc,modifydate desc";
			List list = getSession().createQuery(hql).setMaxResults(num).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getShareArticleSrc(String articleType, int num) {
		// TODO Auto-generated method stub
		String hql;
			hql = "from ArticleSrc where  articleType.articletypename='"+ articleType + "' and ispublication='1'  order by modifydate desc";
		List list = getSession().createQuery(hql).setMaxResults(num).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getPualArticle(int num) {
		String hql = "from ArticleSrc where articleType.articletypeid='8a8081a131cd5fcd0131cd6a83e40004' and ispublication='1' and isrecommend='1' order by createdate desc";
		List list = getSession().createQuery(hql).setMaxResults(num).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getTopArticleSrc(String istop, String isrecommend,
			String orderBy, int start, int stop) {
		// TODO Auto-generated method stub
		String hql;
		hql = "from( select row_.*, rownum rownum_ from (from  ArticleSrc t where isrecommend='1' and articleType.articletypeid='8a80818c31bb7cc50131bb805c4a0007'  and ispublication='1' and  istop='1' order by createdate desc )row_ where rownum <= 10)where rownum_ >2";
		List list = getSession().createQuery(hql).list();
		return list;
	}
	public Result searchArticle(String type, Object value, String metakeywords,
			Page page) {
		// TODO Auto-generated method stub
		String hql = "from ArticleSrc a where a.ispublication='1' and a.articleType."
				+ type + "='" + value + "'";
		StringBuffer sbWhere = new StringBuffer(" and ( ");
		String[] keys = metakeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" metakeywords like '%" + key
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
		String hql = "select count (*) from ArticleSrc a where a.ispublication=1 and a.articleType."
				+ type + "='" + value + "'";
		StringBuffer sbWhere = new StringBuffer(" and ( ");
		String[] keys = metakeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" metakeywords like '%" + key
						+ "%' or articletitle like '%" + key + "%'");
			}
		}
		if (sbWhere.indexOf("or") != -1) {// 有条件
			sbWhere.append(" ) ");
			hql += sbWhere.toString();
		}
		return (Long) getSession().createQuery(hql).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public Result getarticlebyparentType(Page page, String articleTypeId) {
		StringBuffer sbHql = new StringBuffer();
		if(articleTypeId==null||"".equals(articleTypeId.trim())){
			sbHql.append("from ArticleSrc t where t.ispublication='1' and t.articleType.articleType.articletypeid='").append(articleTypeId)
			.append("' order by t.createdate desc");
		}else{
			if(articleTypeId.equals("8a80818c31b6a6270131b6a835780012")){
				sbHql.append("from Article t where t.ispublication='1' and t.articleType.articletypeid='")
				.append(articleTypeId).append("'").append(" order by t.createdate desc");
			}
			else{
				sbHql.append("from ArticleSrc t where t.ispublication='1' and t.articleType.articletypeid='")
				.append(articleTypeId).append("'").append(" order by t.createdate desc");
			}
		}
		return this.findByPager(page, sbHql.toString());
	}
	@SuppressWarnings("unchecked")
	public Result listArticleByPxldArticlePage(Page page, Long memberType,
			String isrecommend, String articletypeid, String articletitle)
			throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ArticleSrc a where a.ispublication='1' ");
		List values = new ArrayList();
		if (null != articletitle && !"".equals(articletitle)) {
			sbHql.append(" and a.articletitle like ?");
			values.add('%' + articletitle + '%');
		}
		if (null != memberType) {
			sbHql.append(" and a.member.memberType=?");
			values.add(memberType);
		}
		if (null != articletypeid && !"".equals(articletypeid)) {
			sbHql.append(" and a.articleType.articletypeid=?");
			values.add(articletypeid);
		}
		if (null != isrecommend && !"".equals(isrecommend)) {
			sbHql.append(" and a.isrecommend=?");
			values.add(isrecommend);
		}
		sbHql.append(" order by a.userpushnum,createdate desc");
		return this.findByPager(page, sbHql.toString(), values);
	}

	@SuppressWarnings("unchecked")
	public Result listArticleBySchoolPage(Page page, String istop,
			String isrecommend, String ispublication, String schoolname)
			throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ArticleSrc a where a.articleType.articletypeid='8a8081a131cd5fcd0131cd69c8930002' ");
		List values = new ArrayList();
		if (null != schoolname && !"".equals(schoolname)) {
			sbHql.append(" and a.schoolname like ?");
			values.add('%' + schoolname + '%');
		}
		if (null != istop && !"".equals(istop)) {
			sbHql.append(" and a.istop=?");
			values.add(istop);
		}
		if (null != isrecommend && !"".equals(isrecommend)) {
			sbHql.append(" and a.isrecommend=?");
			values.add(isrecommend);
		}
		if (null != ispublication && !"".equals(ispublication)) {
			sbHql.append(" and a.ispublication=?");
			values.add(ispublication);
		}
		sbHql.append(" order by a.createdate desc"); 
		return this.findByPager(page, sbHql.toString(), values);
	}

	@SuppressWarnings("unchecked")
	public Result listArticleByInformationPage(Page page, String articletypeid,
			String articletitle) throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ArticleSrc a where (a.articleType.articleType.articletypeid='8a80818c31bb7cc50131bb7fbde70001' or a.articleType.articleType.articleType.articletypeid='8a80818c31bb7cc50131bb7fbde70001') and a.ispublication=1");
		List values = new ArrayList();
		if (null != articletitle && !"".equals(articletitle)) {
			sbHql.append(" and a.articletitle like ?");
			values.add('%' + articletitle + '%');
		}
		if (null != articletypeid && !"".equals(articletypeid)) {
			sbHql.append(" and (");
			sbHql.append(" a.articleType.articletypeid=?");
			values.add(articletypeid);
			sbHql.append(" or a.articleType.articleType.articletypeid=?");
			values.add(articletypeid);
			sbHql.append(" )");
		}

		sbHql.append(" order by a.createdate desc");
		return this.findByPager(page, sbHql.toString(), values);
	}
	/*
	 * 根据查询语句分页
	 */
	public Result getarticle(Page page, String hql){
		// TODO Auto-generated method stub
		return this.findByPager(page, hql.toString());
	}

	public Long geTotalCount(String hql) {
		// TODO Auto-generated method stub
		return (Long) getSession()
		.createQuery(hql).
		uniqueResult();
	}
}
