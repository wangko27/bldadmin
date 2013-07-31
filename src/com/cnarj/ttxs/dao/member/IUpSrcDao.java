package com.cnarj.ttxs.dao.member;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;

public interface IUpSrcDao extends IBaseDao<ReadSrc ,String> {

	/**
	 * 查询用户下载的资源信息 分页
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getUpList(Page page,String memberid) ;
	
	
}
