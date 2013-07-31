package com.cnarj.ttxs.admin.service.learn;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道后台Service接口类 - 名师讲坛 - 名师讲坛信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月22日
 */
public interface ISuperAticleService extends IBaseService<SuperAticle, String> {

	/**
	 * 添加名师讲坛信息
	 * 
	 * @param superTeacherID
	 * @param flag
	 * @param articleSrc
	 * @throws Exception
	 */
	public void saveSuperAticle(String superTeacherID, Long flag,
			ArticleSrc articleSrc) throws Exception;

	/**
	 * 修改名师讲坛信息
	 * 
	 * @param superAticleID
	 * @param flag
	 * @param articleSrc
	 * @throws Exception
	 */
	public void updateSuperAticle(String superAticleID, Long flag,
			ArticleSrc articleSrc) throws Exception;

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
	 * 删除名师讲坛信息
	 * 
	 * @param superAticleID
	 *            名师讲坛ID
	 * @throws Exception
	 */
	public void deleteSuperAticle(String superAticleID) throws Exception;

	/**
	 * 设置不可用
	 * 
	 * @param superAticleID
	 * @throws Exception
	 */
	public void updateSuperAticleByEnable(String superAticleID)
			throws Exception;
}
