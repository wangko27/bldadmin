package com.cnarj.ttxs.dao.member;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;
/**
 * 收藏夹dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月03日
 */
public interface IFavoritesDao extends IBaseDao<ReadSrcHandleRec,String> {

	/**
	 * 查询收藏夹
	 * @param memberID member id
	 * @return
	 */
	public Result getListFavorites(Page page, String memberID, Class clazz) ;
}
