package com.cnarj.ttxs.service.imp.member;


import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.dao.member.IVisitDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IVisitService;

public class VisitServiceImpl extends BaseServiceImpl<ZoneVisits,String> implements IVisitService {

	private IVisitDao visitDao;
	
	public IVisitDao getVisitDao() {
		return visitDao;
	}
	public void setVisitDao(IVisitDao visitDao) {
		this.visitDao = visitDao;
	}
	public void setBaseDao(IVisitDao visitDao) {
		super.setBaseDao(visitDao);
	}
	
	public void savevisit(ZoneVisits zonevis){
		//判断用户是否已经访问过 一天一次
		boolean isv = visitDao.isvisited(zonevis.getMemberByIntervieweesuserid().getMemberid(), zonevis.getMemberByVisitorsuserid().getMemberid());
		//如果未记录访问信息，则记录
		if(!isv){
			visitDao.save(zonevis);
		}
	}
	
	public Result getVisitOther(Page page,String memberid){
		
		return visitDao.getVisitOther(page, memberid);
	}

	public Result getVisitMe(Page page,String memberid){
		
		return visitDao.getVisitMe(page, memberid);
	}
	
	public List<ZoneVisits> getvisit(int num,String memberid){
		Page page = new Page();
		page.setEveryPage(num);
		page.setCurrentPage(1);
		
		Result r = visitDao.getVisitMe(page, memberid);
		
		return r.getContent();
	}
	
}
