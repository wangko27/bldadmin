package com.cnarj.ttxs.service.member;


import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;
import com.cnarj.ttxs.service.IBaseService;
/**
 * 收藏夹业务接口类
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月03日
 * 
 */
public interface IFavoritesService extends IBaseService<ReadSrcHandleRec,String> {


	/**
	 * 查询收藏夹
	 * @param memberId
	 * @param type=src、type=sa、type=ca
	 * @return
	 */
	public Result getFavList(Page page, String memberId, Class classType);
}
