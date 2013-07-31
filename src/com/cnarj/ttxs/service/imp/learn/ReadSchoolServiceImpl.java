package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.IReadSchoolDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IReadShoolService;

public class ReadSchoolServiceImpl extends BaseServiceImpl<ArticleSrc, String>
		implements IReadShoolService {

	private IReadSchoolDao readSchoolDao;

	public IReadSchoolDao getReadSchoolDao() {
		return readSchoolDao;
	}

	public void setReadSchoolDao(IReadSchoolDao readSchoolDao) {
		this.readSchoolDao = readSchoolDao;
	}

	public Result getSchools(Page page) {

		return readSchoolDao.getSchools(page);
	}

	@SuppressWarnings("unchecked")
	public List listSchoolsByRecommend(int shownum) {
		return readSchoolDao.listSchoolsByRecommend(shownum);
	}

	@SuppressWarnings("unchecked")
	public List listSchoolsByTop(int shownum) {
		return readSchoolDao.listSchoolsByTop(shownum);
	}

	public Result getAllResult(String liindex, String subjectId,
			String selectInfo) {
		StringBuffer hql = new StringBuffer();
		Page page = new Page();
		if (liindex.trim().equals("0")) {// 为首页面

		} else if (liindex.trim().equals("1")) {// 一天一课
			page.setEveryPage(10);
			page.setCurrentPage(0);
			hql
					.append("from ReadSrc r where r.readSrcType.srctypeid='8a8081a131bbd5780131bbd5cdc30001'");
			if (subjectId != null && !subjectId.equals("")) {
				hql.append(" and r.subjectCode.subjectcode='")
						.append(subjectId).append("'");
			}
			if (selectInfo != null || selectInfo.equals("")) {
				hql.append(" and r.readsrctile like '%").append(selectInfo)
						.append("%' or r.srckeywords like '%").append(
								selectInfo).append("%'");
			}

		} else if (liindex.trim().equals("2")) {// 评学论道
			page.setEveryPage(28);
			page.setCurrentPage(0);
			hql
					.append(
							"from ArticleSrc a where a.articleType.articletypeid='8a8081a131cd5fcd0131cd6a83e40004'")
					.append(" and a.schoolname like '%").append(selectInfo)
					.append("%' or a.metakeywords like '%").append(selectInfo)
					.append("%'");
		} else if (liindex.trim().equals("3")) {// 名师讲堂
			page.setEveryPage(28);
			page.setCurrentPage(0);
			hql.append("from SuperTeacher s where s.username like '%").append(
					selectInfo).append("%'");
		} else if (liindex.trim().equals("4")) {// 名校风采
			page.setEveryPage(28);
			page.setCurrentPage(0);
			hql
					.append(
							"from ArticleSrc a where a.articleType.articletypeid='8a8081a131cd5fcd0131cd69c8930002'")
					.append(" and a.schoolname like '%").append(selectInfo)
					.append("%' or a.metakeywords like '%").append(selectInfo)
					.append("%'");
		} else if (liindex.trim().equals("5")) {// 群拦帛书
			page.setEveryPage(10);
			page.setCurrentPage(0);
			hql
					.append("from ReadSrc r where r.readSrcType.srctypeid='8a8081a131bbac4d0131bbac8f5a0001'");
			if (subjectId != null && !subjectId.equals("")) {
				hql.append(" and r.subjectCode.subjectcode='")
						.append(subjectId).append("'");
			}
			if (selectInfo != null || selectInfo.equals("")) {
				hql.append(" and r.readsrctile like '%").append(selectInfo)
						.append("%' or r.srckeywords like '%").append(
								selectInfo).append("%'");
			}
			// / System.out.println(hql.toString());
		}
		return readSchoolDao.getAllResult(hql.toString(), page);
	}

}
