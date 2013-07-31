package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.learn.ReadSrcType;

/**
 * 学习频道Dao接口类 - 博览群书类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public interface IReadbookTypeDao extends IBaseDao<ReadSrcType, String> {

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
