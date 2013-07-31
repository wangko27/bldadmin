package com.cnarj.ttxs.admin.service.learn;

import java.io.File;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道后台Service接口类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public interface IReadbookService extends IBaseService<ReadSrc, String> {

	/**
	 * 添加博览群书
	 * 
	 * @param readSrc
	 * @param cover
	 *            封面
	 * @param coverFileName
	 * @param coverContentType
	 * @param resource
	 *            资源
	 * @param resourceFileName
	 * @param resourceContentType
	 * @throws Exception
	 */
	public void saveReadSrcByReadbook(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType, File resource,
			String resourceFileName, String resourceContentType)
			throws Exception;

	/**
	 * 添加一天一课
	 * 
	 * @param readSrc
	 * @param resource
	 *            资源
	 * @param resourceFileName
	 * @param resourceContentType
	 * @throws Exception
	 */
	public void saveReadSrcByOneday(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType, File resource,
			String resourceFileName, String resourceContentType)
			throws Exception;

	/**
	 * 修改博览群书
	 * 
	 * @param readSrc
	 * @param cover
	 *            封面
	 * @param coverFileName
	 * @param coverContentType
	 * @throws Exception
	 */
	public void updateReadSrcByReadbook(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 修改一天一课
	 * 
	 * @param readSrc
	 * @throws Exception
	 */
	public void updateReadSrcByOneday(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 查询一天一课（带分页）
	 * 
	 * @param page
	 * @param subjectcode
	 * @param isrecommend
	 * @param readsrctile
	 * @return
	 */
	public Result listReadsrcByOnedayPage(Page page, String subjectcode,
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
	public Result listReadsrcByReadbookPage(Page page, String subjectcode,
			String gradecode, String srctypeid, String readsrctile,
			String isenable) throws Exception;

	/**
	 * 删除群览博书和一天一课（真删）
	 * 
	 * @param readsrcid
	 */
	public void deleteReadsrc(String readsrcid) throws Exception;

	/**
	 * 禁用群览博书和一天一课（假删）
	 * 
	 * @param readsrcid
	 * @throws Exception
	 */
	public void updateReadsrcByEnable(String readsrcid) throws Exception;

}
