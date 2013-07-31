package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;
import com.cnarj.ttxs.service.IBaseService;

public interface IVisitService extends IBaseService<ZoneVisits,String> {

	/**
	 * 访问他人空间
	 * @param zonevis
	 */
	public void savevisit(ZoneVisits zonevis);
	
	/**
	 * 我访问过的
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getVisitOther(Page page,String memberid);

	/**
	 * 访问过我的
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getVisitMe(Page page,String memberid);
	
	/**
	 * 访问记录
	 * @param num
	 * @param memberid
	 * @return
	 */
	public List<ZoneVisits> getvisit(int num,String memberid);
}
