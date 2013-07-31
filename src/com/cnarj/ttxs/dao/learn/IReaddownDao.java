package com.cnarj.ttxs.dao.learn;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.learn.ReadSrcDownRec;

/**
 * 学习频道Dao接口类 - 学习资源下载记录
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月19日
 */
public interface IReaddownDao extends IBaseDao<ReadSrcDownRec, String> {

	/**
	 * 该博览群书处理该用户是否已下载过
	 * 
	 * @param readsrcid
	 *            博览群书ID
	 * @param memberid
	 *            用户ID
	 * @return
	 * @throws Exception
	 */
	public boolean isExistByReaddown(String readsrcid, String memberid)
			throws Exception;
}
