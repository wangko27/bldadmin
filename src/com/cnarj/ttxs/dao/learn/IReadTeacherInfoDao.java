package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;

/**
 * 学习频道Dao接口类 - 右边的名师导航
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IReadTeacherInfoDao extends IBaseDao<SuperAticle, String> {

	/**
	 * 根据用户选择来查询信息(typeid=0 为人名,2 为文章名称)返回的是一个教师信息或者是文章信息
	 */
	public Result getTeacherAndText(String hql, Page page);

	/**
	 * 得到2条最新名校信息
	 */
	public List<ArticleSrc> getSuperSchools(int num);

	/**
	 * 得到2条最新名师信息
	 */
	public List<SuperAticle> getSuperAticle(int num);

	/**
	 * 查询名师热点人物
	 */
	public List<SuperTeacher> getSuperTeachers(int num);

	/**
	 * 根据老师的id得到老师信息
	 */
	public SuperTeacher getByIdSuperTeacher(String teacherId);

	/**
	 * 根据articlesrc得到学校的信息
	 * 
	 */
	public ArticleSrc getSuperSchool(String articlesrcId);

	/**
	 * 查询所有的名师信息 并分页
	 */
	public Result getSuperTeachers(Page page);

	/**
	 * 根据名师的Id的到名师的讲坛信息(含分页)
	 */
	public Result getSuperAticle(Page page, String teacherid);

	/**
	 * 根据学校的关键字寻找相关链接
	 */
	public List<ArticleSrc> getXianGuanSchool(String str, int num, String artic);

	/**
	 * 讲堂的详细信息()
	 */
	public ArticleSrc getTeacherArticleSrc(String articId);

	/**
	 * 得到相关联的5条信息
	 */
	public List<ArticleSrc> getTeacherARticleSrcs(String str, int num,
			String artic);

	/**
	 * 查找名师讲坛信息（带分页）
	 * 
	 * @param page
	 * @param superTeacherID
	 *            名师ID
	 * 
	 * @param flag
	 *            文章类别
	 * @param articletitle
	 *            标题
	 * @return
	 * @throws Exception
	 */
	public Result findSuperAticleByPage(Page page, String superTeacherID,
			Long flag, String articletitle) throws Exception;

	/**
	 * 查询名师热点人物(学习首页)
	 * 
	 * @param num
	 * @return
	 */
	public List<SuperTeacher> listSuperTeachersByHot(int num);
}
