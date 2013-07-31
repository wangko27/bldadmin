package com.cnarj.ttxs.dao.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IReadSchoolDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

public class ReadSchoolDaoImpl extends BaseDaoImpl<ArticleSrc, String>
		implements IReadSchoolDao {

	public Result getSchools(Page page) {
		String hql = "from ArticleSrc a "
				+ "where a.articleType.articletypeid='8a8081a131cd5fcd0131cd69c8930002' and a.ispublication=1 order by a.createdate desc";
		return this.findByPager(page, hql);
	}

	@SuppressWarnings("unchecked")
	public List listSchoolsByRecommend(int shownum) {
		String hql = "from ArticleSrc a where a.articleType.articletypeid='8a8081a131cd5fcd0131cd69c8930002' and isrecommend=1 and a.ispublication=1 order by a.createdate desc";
		return this.getSession().createQuery(hql).setMaxResults(shownum).list();
	}

	@SuppressWarnings("unchecked")
	public List listSchoolsByTop(int shownum) {
		String hql = "from ArticleSrc a where a.articleType.articletypeid='8a8081a131cd5fcd0131cd69c8930002' and istop=1 and a.ispublication=1 order by a.istop desc, a.createdate desc";
		return this.getSession().createQuery(hql).setMaxResults(shownum).list();
	}

	public Result getAllResult(String hql, Page page) {
		return this.findByPager(page, hql);
	}
}
