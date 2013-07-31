package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道Service类 - 名校风采
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IReadShoolService extends IBaseService<ArticleSrc, String> {

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
	 * 按条件查询
	 * 
	 * @param liindex
	 *            查询那个板块
	 * @param subjectId
	 *            查询的科目
	 * @param selectInfo
	 *            查询的关键字
	 * @return 返回结果集
	 */
	public Result getAllResult(String liindex, String subjectId,
			String selectInfo);

}
