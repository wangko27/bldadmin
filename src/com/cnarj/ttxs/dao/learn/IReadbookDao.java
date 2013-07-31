package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;

/**
 * 学习频道Dao接口类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IReadbookDao extends IBaseDao<ReadSrc, String> {
	/**
	 * num 显示多少条 按时间排序 查找推荐书籍
	 * 
	 * @return
	 */
	public List<ReadSrc> getRReadsrc(int num);

	/**
	 * num显示多少条 按时间 排序 查找普通书籍
	 * 
	 * @return
	 */
	public List<ReadSrc> getReadsrc(int num);

	/**
	 * 获取博览群书列表（带分页）
	 * 
	 * @param page
	 * @param srctypeid
	 *            类别ID 查询所有传null
	 * @param subjectcode
	 *            科目ID 查询所有传null
	 * @param gradeCode
	 *            年级ID 查询所有传null
	 * @param gradeCode
	 *            排序字段
	 * @return
	 * @throws Exception
	 */
	public Result listReadbook(Page page, String srctypeid, String subjectcode,
			String gradeCode, String order) throws Exception;

	/**
	 * 根据关键字匹配相关阅读
	 * 
	 * @param readsrcid
	 *            博览群书ID 关键字
	 * @param srckeywords
	 *            关键字
	 * @param shownum
	 *            显示数量
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List listCorrelateRead(String readsrcid, String srckeywords,
			int shownum) throws Exception;

	/**
	 * 获取博览群书相关评论（带分页）
	 * 
	 * @param page
	 * @param readsrcid
	 *            博览群书ID
	 * @return
	 * @throws Exception
	 */
	public Result listReadCommentedByPager(Page page, String readsrcid)
			throws Exception;

	/**
	 * 根据年级查博览群书
	 * 
	 * @param gradecode
	 *            年级ID
	 * @param shownum
	 *            显示数量
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List listReadbookByGrade(String[] gradecode, int shownum)
			throws Exception;

	/**
	 * 查询推荐的博览群书，如果推荐数不足，则用普通的补足
	 * 
	 * @param shownum
	 *            显示数量
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List listReadbookByRecommend(int shownum) throws Exception;

	/**
	 * 查询一天一课（带分页）
	 * 
	 * @param page
	 * @param subjectcode
	 * @param isrecommend
	 * @param readsrctile
	 * @return
	 */
	public Result listReadbookByOnedayPage(Page page, String subjectcode,
			String gradecode, String readsrctile, String isenable)
			throws Exception;

	/**
	 * 查询博览群书（带分页）
	 * 
	 * @param page
	 * @param subjectcode
	 * @param gradecode
	 * @param srctypeid
	 * @param readsrctile
	 * @return
	 */
	public Result listReadbookByReadbookPage(Page page, String subjectcode,
			String gradecode, String srctypeid, String readsrctile,
			String isenable) throws Exception;

}
