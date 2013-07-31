package com.cnarj.ttxs.dao.member;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;

public interface IVisitDao extends IBaseDao<ZoneVisits,String> {

	/**
	 * 是否访问过？
	 * @param memberid 被访问者ID
	 * @param vmemberid 访问者ID
	 * @return 
	 * 		true 今天已访问
	 * 		false 今天未访问
	 */
	public boolean isvisited(String memberid,String vmemberid);
	
	/**
	 * 查询我访问过的
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getVisitOther(Page page,String memberid);
	
	/**
	 * 查询访问过我的
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getVisitMe(Page page,String memberid);
}
