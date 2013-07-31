package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.IReadTeacherInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IReadTeacherInfoService;

public class ReadTeacherInfoServiceImpl extends
		BaseServiceImpl<SuperAticle, String> implements IReadTeacherInfoService {

	private IReadTeacherInfoDao readTeacherInfoDao;

	public IReadTeacherInfoDao getReadTeacherInfoDao() {
		return readTeacherInfoDao;
	}

	public void setReadTeacherInfoDao(IReadTeacherInfoDao readTeacherInfoDao) {
		this.readTeacherInfoDao = readTeacherInfoDao;
		super.setBaseDao(readTeacherInfoDao);
	}

	public List<SuperAticle> getSuperAticle(int num) {
		return readTeacherInfoDao.getSuperAticle(num);
	}

	public List<ArticleSrc> getSuperSchools(int num) {
		return readTeacherInfoDao.getSuperSchools(num);
	}

	public List<SuperTeacher> getSuperTeachers(int num) {
		return readTeacherInfoDao.getSuperTeachers(num);
	}

	public SuperTeacher getBySuperTeacher(String teacherid) {
		return readTeacherInfoDao.getByIdSuperTeacher(teacherid);

	}

	public ArticleSrc getsuperSchool(String articlesrcId) {
		return readTeacherInfoDao.getSuperSchool(articlesrcId);
	}

	public Result getSuperAticles(Page page) {
		return readTeacherInfoDao.getSuperTeachers(page);
	}

	public Result getSuperAticle(Page page, String teacherid) {

		return readTeacherInfoDao.getSuperAticle(page, teacherid);
	}

	public List<ArticleSrc> getXianGuanSchool(String str, int num, String artic) {
		return readTeacherInfoDao.getXianGuanSchool(str, num, artic);
	}

	public ArticleSrc getTeacherArticleSrc(String articId) {
		return readTeacherInfoDao.getTeacherArticleSrc(articId);
	}

	public List<ArticleSrc> getTeacherARticleSrcs(String str, int num,
			String artic) {
		return readTeacherInfoDao.getTeacherARticleSrcs(str, num, artic);
	}

	/**
	 * 根据用户选择来查询信息(typeid=0 为人名,2 为文章名称)返回的是一个教师信息或者是文章信息
	 */
	public Result getTeacherAndText(String typeid, String tj, Page page) {
		StringBuffer hql_b = new StringBuffer();
		if (tj != null && !tj.trim().equals("")) {
			if (typeid.equals("0")) {
				hql_b.append("from SuperTeacher s where s.username like '%").append(
						tj).append("%'");
			} else if (typeid.equals("1")) {
				hql_b.append("from SuperAticle s where s.articletitle like '%")
						.append(tj).append("%'");
			}
			return readTeacherInfoDao.getTeacherAndText(hql_b.toString(), page);
		}
		return null;
	}

	/**
	 * 查询名师热点人物(学习首页)
	 * 
	 * @param num
	 * @return
	 */
	public List<SuperTeacher> listSuperTeachersByHot(int num) {
		return readTeacherInfoDao.listSuperTeachersByHot(num);
	}

}
