package com.cnarj.ttxs.dao.imp.learn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IReadTeacherInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;

/**
 * 学习频道Dao接口类实现类 - 右边名师信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public class ReadTeacherInfoDaoImpl extends BaseDaoImpl<SuperAticle, String>
		implements IReadTeacherInfoDao {

	/**
	 * 得到2条学校信息
	 */
	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getSuperSchools(int num) {
		return this
				.getSession()
				.createQuery(
						"from ArticleSrc s where s.ispublication=1 and s.articleType.articletypeid='8a8081a131cd5fcd0131cd69c8930002' order by s.createdate desc")
				.setMaxResults(num).list();

	}

	/**
	 * 查询名师热点人物
	 */
	@SuppressWarnings("unchecked")
	public List<SuperTeacher> getSuperTeachers(int num) {
		return this
				.getSession()
				.createQuery(
						"from SuperTeacher s where s.isenable=1 and s.flag=1 order by s.peopleNum desc")
				.setMaxResults(num).list();
	}

	/**
	 * 得到2条最新名师信息
	 */
	@SuppressWarnings("unchecked")
	public List<SuperAticle> getSuperAticle(int num) {
		return this
				.getSession()

				.createQuery(
						"from SuperAticle s where s.isenable=1 and s.articleSrc.ispublication=1 order by s.createDate desc")
				.setMaxResults(num).list();
	}

	@SuppressWarnings("unchecked")
	public SuperTeacher getByIdSuperTeacher(String teacherId) {
		return (SuperTeacher) this.getSession().load(SuperTeacher.class,
				teacherId);
	}

	/**
	 * 得到具体的学校信息
	 */
	public ArticleSrc getSuperSchool(String articlesrcId) {
		return (ArticleSrc) this.getSession().get(ArticleSrc.class,
				articlesrcId);
	}

	/**
	 * 得到所有的名师并分页
	 */

	public Result getSuperTeachers(Page page) {
		String hql = "from SuperTeacher s where s.isenable=1 ";
		Result result = this.findByPager(page, hql);
		return result;
	}

	/**
	 * 根据名师的Id的到名师的讲坛信息(含分页)
	 */
	public Result getSuperAticle(Page page, String teacherid) {
		String hql = "from SuperAticle s "
				+ "where s.isenable=1 and s.superTeacher.superTeacherID='"
				+ teacherid + "' " + "order by s.createDate desc";
		return this.findByPager(page, hql);
	}

	/**
	 * 读相关的信息
	 */

	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getXianGuanSchool(String str, int num, String srtic) {
		Query query = this
				.getSession()
				.createQuery(
						"from ArticleSrc s "
								+ "where s.ispublication=1 and s.articleType.articletypeid='8a8081a131cd5fcd0131cd69c8930002' and s.metakeywords=? and s.articlesrcid<>?")
				.setParameter(0, str).setParameter(1, srtic);
		return num == 0 ? query.list() : query.setMaxResults(num).list();
	}

	/**
	 * 根据Id得到讲堂的详细信息
	 */

	public ArticleSrc getTeacherArticleSrc(String articId) {
		return (ArticleSrc) this.getSession().get(ArticleSrc.class, articId);

	}

	/**
	 * 得到相关联的5条信息
	 */

	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getTeacherARticleSrcs(String str, int num,
			String artic) {
		Query query = this
				.getSession()
				.createQuery(
						"from ArticleSrc s "
								+ "where s.ispublication=1 and s.articleType.articletypeid='8a8081a131cd5fcd0131cd6a4b400003' and s.metakeywords=? and s.articlesrcid<>?")
				.setParameter(0, str).setParameter(1, artic);
		return query.list();
	}

	public Result getTeacherAndText(String hql, Page page) {
		return this.findByPager(page, hql);
	}

	@SuppressWarnings("unchecked")
	public Result findSuperAticleByPage(Page page, String superTeacherID,
			Long flag, String articletitle) throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from SuperAticle s where s.isenable=1 ");
		List values = new ArrayList();
		if (null != articletitle && !"".equals(articletitle)) {
			sbHql.append(" and s.articletitle like ?");
			values.add('%' + articletitle + '%');
		}
		if (null != superTeacherID && !"".equals(superTeacherID)) {
			sbHql.append(" and s.superTeacher.superTeacherID=?");
			values.add(superTeacherID);
		}
		if (null != flag && !"".equals(flag)) {
			sbHql.append(" and s.flag=?");
			values.add(flag);
		}
		sbHql.append(" order by s.modifyDate desc");
		return this.findByPager(page, sbHql.toString(), values);
	}

	/**
	 * 查询名师热点人物(学习首页)
	 */
	@SuppressWarnings("unchecked")
	public List<SuperTeacher> listSuperTeachersByHot(int num) {
		return this.getSession().createQuery(
				"from SuperTeacher s where s.isenable=1 and s.flag=1")
				.setMaxResults(num).list();
	}
}
