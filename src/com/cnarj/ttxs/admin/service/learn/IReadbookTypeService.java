package com.cnarj.ttxs.admin.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.learn.ReadSrcType;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道后台Service接口类 - 博览群书类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public interface IReadbookTypeService extends IBaseService<ReadSrcType, String> {

	/**
	 * 添加博览群书类别
	 * 
	 * @param readSrcType
	 */
	public void saveReadSrcType(ReadSrcType readSrcType) throws Exception;

	/**
	 * 修改博览群书类别
	 * 
	 * @param readSrcType
	 * @throws Exception
	 */
	public void updateReadSrcType(ReadSrcType readSrcType) throws Exception;

	/**
	 * 根据博览群书类别ID删除博览群书类别
	 * 
	 * @param srctypeid
	 *            博览群书类别ID
	 * @throws Exception
	 */
	public void deleteReadSrcType(String srctypeid) throws Exception;

	/**
	 * 根据博览群书类别ID获取博览群书类别信息
	 * 
	 * @param srctypeid
	 *            博览群书类别ID
	 * @return
	 * @throws Exception
	 */
	public ReadSrcType getReadSrcTypeByTypeid(String srctypeid)
			throws Exception;

	/**
	 * 根据博览群书类别名称获取博览群书类别信息
	 * 
	 * @param srctypename
	 *            博览群书类别名称
	 * @return
	 * @throws Exception
	 */
	public ReadSrcType getReadSrcTypeByTypename(String srctypename)
			throws Exception;

	/**
	 * 获取所有博览群书类别信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReadSrcType> listReadSrcTypeAll() throws Exception;

	/**
	 * 获取所有博览群书类别信息(第一级父类，上级类别)
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReadSrcType> listReadSrcTypeByParent() throws Exception;

	/**
	 * 根据上级类别查询所有博览群书类别信息
	 * 
	 * @param srctypeid
	 *            博览群书类别ID
	 * @return
	 * @throws Exception
	 */
	public List<ReadSrcType> listReadSrcTypeByChild(String srctypeid)
			throws Exception;
}
