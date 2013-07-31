package com.cnarj.ttxs.dao.learn;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;

/**
 * 学习频道Dao接口类 - 博览群书处理记录(收藏,分享)
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月18日
 */
public interface IReadhandleDao extends IBaseDao<ReadSrcHandleRec, String> {

	/**
	 * 博览群书处理记录是否存在
	 * 
	 * @param readsrcid
	 *            博览群书ID
	 * @param actiontype
	 *            处理类型 1分享 2收藏
	 * @param memberid
	 *            用户ID
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByReadhandle(String readsrcid, Long actiontype,
			String memberid) throws Exception;

}
