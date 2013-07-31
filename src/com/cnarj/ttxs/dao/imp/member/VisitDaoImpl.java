package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IVisitDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;

public class VisitDaoImpl extends BaseDaoImpl<ZoneVisits,String> implements IVisitDao {

	/**
	 * 是否访问过？
	 * @param memberid 被访问者ID
	 * @param vmemberid 访问者ID
	 * @return 
	 * 		true 今天已访问
	 * 		false 今天未访问
	 */
	public boolean isvisited(String memberid,String vmemberid){
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from ZoneVisits as model ");
		hql.append(" where model.memberByIntervieweesuserid.memberid = ? ");
		hql.append(" and model.memberByVisitorsuserid.memberid = ? ");
		hql.append(" and to_char(model.visitdate,'yyyy-MM-dd') = to_char(sysdate,'yyyy-MM-dd') ");
		
		List list = super.getSession().createQuery(hql.toString())
		.setParameter(0, memberid)
		.setParameter(1, vmemberid)
		.list();
		
		return (null != list && list.size() > 0);
	}

	public Result getVisitOther(Page page, String memberid) {
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from ZoneVisits as model ");
		hql.append(" where model.memberByVisitorsuserid.memberid = ? ");
		hql.append(" order by model.visitdate desc ");
		
		List list = new ArrayList();
		list.add(memberid);
		return super.findByPager(page, hql.toString(), list);
	}
	
	public Result getVisitMe(Page page,String memberid){

		StringBuffer hql = new StringBuffer();
		hql.append(" from ZoneVisits as model ");
		hql.append(" where model.memberByIntervieweesuserid.memberid = ? ");
		hql.append(" order by model.visitdate desc ");
		
		List list = new ArrayList();
		list.add(memberid);
		return super.findByPager(page, hql.toString(), list);
	}
}
