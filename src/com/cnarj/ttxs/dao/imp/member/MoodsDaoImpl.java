package com.cnarj.ttxs.dao.imp.member;


import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IMoodsDao;
import com.cnarj.ttxs.pojo.stuz.moods;
import com.cnarj.ttxs.util.BusinessException;

public class MoodsDaoImpl extends BaseDaoImpl<moods,String> implements IMoodsDao {

	
	public moods getMood(String memberid) {
		StringBuffer hql = new StringBuffer();
		hql.append(" from moods as model where model.member.memberid = ? order by createdate desc");
		List<moods> list = super.getSession().createQuery(hql.toString()).setParameter(0, memberid).setFirstResult(0).setMaxResults(1).list();
		
		if(list.size() > 0){
			return list.get(0);
		}
		else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<moods> getListByMaxResults(String memberid, int length) {
		Assert.notNull(memberid, "会员id不能为空！");
		String hql = "from moods m where 1=1 and m.member.memberid = ? order by m.createdate desc ";
		return getSession().createQuery(hql).setParameter(0, memberid).setMaxResults(length).list();
	}

}
