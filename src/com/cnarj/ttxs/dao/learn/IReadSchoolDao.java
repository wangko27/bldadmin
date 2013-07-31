package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

/**
 * 学习频道Dao接口类 - 学校风采
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IReadSchoolDao extends IBaseDao<ArticleSrc, String> {

	/**
	 * 得到所有的学校(分页)
	 */
	public Result getSchools(Page page);

	/**
	 * 查询推荐的名校风采
	 * 
	 * @param shownum
	 *            显示条数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List listSchoolsByRecommend(int shownum);

	/**
	 * 查询置顶的名校风采
	 * 
	 * @param shownum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List listSchoolsByTop(int shownum);

	/**
	 * 根据不同条件查询不同结果(包括分页)
	 */
	public Result getAllResult(String hql, Page page);
}
