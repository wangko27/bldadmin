package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IFriendsInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendsInfo;

public class FriendsInfoDaoImpl extends BaseDaoImpl<FriendsInfo,String> implements IFriendsInfoDao {

	public Result getFriendList(Page page, String memberid,String typeid) {
		Assert.notNull(page,"page对象不能为空");
		Assert.hasText(memberid,"用户ID为空");
		
		int temp = 0;
		
		String hql = "";
		if(null == typeid || typeid.length() == 0){
			hql = "from FriendsInfo a where a.memberByUserid.memberid = ? order by a.createdate desc";
		}
		else{
			temp = 1;
			hql = " from FriendsInfo a " +
					" where a.memberByUserid.memberid = ? " +
					" and a.friendtype.friendtypeid = ? " +
					" order by a.createdate desc";
		}
		List list = new ArrayList();
		list.add(memberid);
		if(temp == 1){
			list.add(typeid);
		}
		return super.findByPager(page, hql, list);
	}

}
