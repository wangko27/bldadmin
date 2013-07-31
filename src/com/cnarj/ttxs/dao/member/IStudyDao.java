package com.cnarj.ttxs.dao.member;


import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

public interface IStudyDao extends IBaseDao<ArticleSrc,String> {

	/**
	 * 查询品学论道 
	 * 根据用户ID
	 * @param page
	 * @param values
	 * @return
	 */
	public Result getStudyListByM(Page page, String memberid);
}
