package com.cnarj.ttxs.dao.imp.learn;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IReadbookDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;

/**
 * 学习频道Dao接口实现类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public class ReadbookDaoImpl extends BaseDaoImpl<ReadSrc, String> implements
		IReadbookDao {
	@SuppressWarnings("unchecked")
	public List<ReadSrc> getRReadsrc(int num) {
		return this
				.getSession()
				.createQuery(
						"from ReadSrc r where r.isrecommend=1 and r.isenable=1 and r.readSrcType.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001' and r.isenable=1 order by r.createdate desc")
				.setMaxResults(num).list();

	}

	@SuppressWarnings("unchecked")
	public List<ReadSrc> getReadsrc(int num) {
		return this
				.getSession()
				.createQuery(
						"from ReadSrc r where r.isrecommend=0 and r.readSrcType.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001' and r.isenable=1 order by r.createdate desc")
				.setMaxResults(num).list();
	}

	public Result listReadbook(Page page, String srctypeid, String subjectcode,
			String gradeCode, String order) throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ReadSrc r where r.readSrcType.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001' and r.isenable=1");
		if (null != srctypeid && !"".equals(srctypeid)) {
			sbHql.append(" and r.readSrcType.srctypeid='" + srctypeid + "'");
		}

		if (null != subjectcode && !"".equals(subjectcode)) {
			sbHql
					.append(" and r.subjectCode.subjectcode='" + subjectcode
							+ "'");
		}
		if (null != gradeCode && !"".equals(gradeCode)) {
			sbHql.append(" and r.gradeCode.gradecode='" + gradeCode + "'");
		}

		if (null != order && !"".equals(order)) {
			sbHql.append(" order by r." + order + " desc");
		}
		return this.findByPager(page, sbHql.toString());
	}

	@SuppressWarnings("unchecked")
	public List listCorrelateRead(String readsrcid, String srckeywords,
			int shownum) throws Exception {
		String hql = "from ReadSrc r where r.readSrcType.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001' and r.isenable=1 and r.readsrcid!='"
				+ readsrcid + "'";
		StringBuffer sbWhere = new StringBuffer(" and ( ");
		String[] keys = srckeywords.split(" ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (null != key && !"".equals(key)) {
				if (i != 0) {
					sbWhere.append(" or ");
				}
				sbWhere.append(" srckeywords like '%" + key
						+ "%' or readsrctile like '%" + key + "%'");
			}
		}
		if (sbWhere.indexOf("or") != -1) {// 有条件
			sbWhere.append(" ) ");
			hql += sbWhere.toString();
		}

		return this.getSession().createQuery(hql).setMaxResults(shownum).list();
	}

	public Result listReadCommentedByPager(Page page, String readsrcid)
			throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ReadSrcCommented r where r.readSrc.readsrcid='"
						+ readsrcid + "' ");

		return this.findByPager(page, sbHql.toString());
	}

	@SuppressWarnings("unchecked")
	public List listReadbookByGrade(String[] gradecodes, int shownum)
			throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ReadSrc r where r.readSrcType.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001' and r.isenable=1");
		if (null != gradecodes && gradecodes.length > 0) {
			sbHql.append(" and (");
			for (int i = 0; i < gradecodes.length; i++) {
				if (i != 0) {
					sbHql.append(" or ");
				}
				sbHql.append("  r.gradeCode.gradecode='" + gradecodes[i] + "'");
			}
			sbHql.append(" ) ");
		}
		sbHql.append(" order by r.createdate desc");
		return this.getSession().createQuery(sbHql.toString()).setMaxResults(
				shownum).list();
	}

	@SuppressWarnings("unchecked")
	public List listReadbookByRecommend(int shownum) throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ReadSrc r where r.readSrcType.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001' and r.isenable=1 order by r.isrecommend,r.createdate desc");
		return this.getSession().createQuery(sbHql.toString()).setMaxResults(
				shownum).list();
	}

	@SuppressWarnings("unchecked")
	public Result listReadbookByOnedayPage(Page page, String subjectcode,
			String gradecode, String readsrctile, String isenable)
			throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ReadSrc r where r.readSrcType.srctypeid='8a8081a131bbd5780131bbd5cdc30001' and r.isenable=1 ");
		List values = new ArrayList();
		if (null != readsrctile && !"".equals(readsrctile)) {
			sbHql.append(" and r.readsrctile like ?");
			values.add('%' + readsrctile + '%');
		}
		if (null != subjectcode && !"".equals(subjectcode)) {
			sbHql.append(" and r.subjectCode.subjectcode=?");
			values.add(subjectcode);
		}
		if (null != gradecode && !"".equals(gradecode)) {
			sbHql.append(" and r.gradeCode.gradecode=?");
			values.add(gradecode);
		}
		if (null != isenable && !"".equals(isenable)) {
			sbHql.append(" and r.isenable=?");
			values.add(isenable);
		}
		sbHql.append(" order by r.createdate desc");
		return this.findByPager(page, sbHql.toString(), values);
	}

	@SuppressWarnings("unchecked")
	public Result listReadbookByReadbookPage(Page page, String subjectcode,
			String gradecode, String srctypeid, String readsrctile,
			String isenable) throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ReadSrc r where r.readSrcType.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001' ");
		List values = new ArrayList();
		if (null != readsrctile && !"".equals(readsrctile)) {
			sbHql.append(" and r.readsrctile like ?");
			values.add('%' + readsrctile + '%');
		}
		if (null != subjectcode && !"".equals(subjectcode)) {
			sbHql.append(" and r.subjectCode.subjectcode=?");
			values.add(subjectcode);
		}
		if (null != gradecode && !"".equals(gradecode)) {
			sbHql.append(" and r.gradeCode.gradecode=?");
			values.add(gradecode);
		}
		if (null != srctypeid && !"".equals(srctypeid)) {
			sbHql.append(" and r.readSrcType.srctypeid=?");
			values.add(srctypeid);
		}
		if (null != isenable && !"".equals(isenable)) {
			sbHql.append(" and r.isenable=?");
			values.add(isenable);
		}
		sbHql.append(" order by r.createdate desc");
		return this.findByPager(page, sbHql.toString(), values);
	}
}
