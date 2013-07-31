package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道Service接口类 - 右边的名师
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IReadTeacherInfoService extends IBaseService<SuperAticle, String> {

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
	 * 得到所有的名师讲坛信息(包含分页)
	 */
	public Result getSuperAticles(Page page);
	/**
	 * 根据teacherid得到teacher信息
	 */
	public SuperTeacher getBySuperTeacher(String teacherid);
	/**
	 * 根据Id得到具体学校的信息
	 */
	public ArticleSrc getsuperSchool(String articlesrcId);
	/**
	 * 根据名师的Id的到名师的讲坛信息(含分页)
	 */
	public Result getSuperAticle(Page page,String teacherid);
	/**
	 * 读相关的信息(名校风采)
	 */
	public List<ArticleSrc> getXianGuanSchool(String str,int num,String artic) ;
	/**
	 * 讲堂的详细信息()
	 */
	public ArticleSrc getTeacherArticleSrc(String articId);
	
	/**
	 * 得到相关联的5条信息
	 */
	public List<ArticleSrc> getTeacherARticleSrcs(String str,int num,String artic);
	/**
	 * 根据用户选择来查询信息(typeid=0 为人名,2 为文章名称)返回的是一个教师信息或者是文章信息
	 */
	public Result getTeacherAndText(String typeid,String tj,Page page);
	
	/**
	 * 查询名师热点人物(学习首页)
	 * 
	 * @param num
	 * @return
	 */
	public List<SuperTeacher> listSuperTeachersByHot(int num);
}
