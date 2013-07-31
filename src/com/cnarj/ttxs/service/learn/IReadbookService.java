package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道Service接口类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IReadbookService extends IBaseService<ReadSrc, String> {

	/**
	 * 显示书的数量 num 得到5条博览群书最新或推荐的信息
	 * 
	 * @return
	 */
	public List<ReadSrc> get5ReadSrc(int num);

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
	public Result listReadbookByPager(Page page, String srctypeid,
			String subjectcode, String gradeCode, String order)
			throws Exception;

	/**
	 * 添加博览群书处理记录(收藏,分享)
	 * 
	 * @param readsrcid
	 *            群览博书ID
	 * @param readsrcid
	 *            博览群书处理类型(2收藏,1分享)
	 * @param actionpath
	 * 
	 * @throws Exception
	 */
	public void saveReadhandle(String readsrcid, Long actiontype,
			String actionpath) throws Exception;

	/**
	 * 博览群书处理记录是否存在
	 * 
	 * @param readsrcid
	 *            博览群书ID
	 * @param actiontype
	 *            处理类型 1分享 2收藏
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByReadhandle(String readsrcid, Long actiontype)
			throws Exception;

	/**
	 * 添加博览群书下载记录
	 * 
	 * @param readsrcid
	 *            博览群书ID
	 * @param actionpath
	 * 
	 * @throws Exception
	 */
	public void saveReaddown(String readsrcid) throws Exception;

	/**
	 * 该博览群书处理该用户是否已下载过
	 * 
	 * @param readsrcid
	 *            博览群书ID
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByReaddown(String readsrcid) throws Exception;

	/**
	 * 下载资源
	 * 
	 * @param readsrcid
	 *            博览群书ID
	 * @return
	 * @throws Exception
	 */
	public String readdown(String readsrcid) throws Exception;

	/**
	 * 下载该资源积分是否够用
	 * 
	 * @param readsrcid
	 * @return
	 */
	public boolean isHaveByDownPoint(String readsrcid) throws Exception;

	/**
	 * 根据关键字匹配相关阅读
	 * 
	 * @param readsrcid
	 *            当前查看的博览群书ID
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
}
