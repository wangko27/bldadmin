package com.cnarj.ttxs.dao.imp.member;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IFriendTypeDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendType;
import com.cnarj.ttxs.pojo.user.Member;

public class FriendTypeDaoImpl extends BaseDaoImpl<FriendType,String> implements IFriendTypeDao {

	public Result getMemberList(Page page,String xm) {

		String hql = "from "+Member.class.getName()+" as model where model.nikename = ?";
		List list = new ArrayList();
		list.add(xm);
		
		return super.findByPager(page, hql, list);
	}


}
