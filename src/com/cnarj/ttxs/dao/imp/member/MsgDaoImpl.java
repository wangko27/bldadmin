package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IMsgDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MsgInfo;

public class MsgDaoImpl extends BaseDaoImpl<MsgInfo,String> implements IMsgDao {

	public Result listUserMsg(Page page,String memberid) {
		Assert.notNull(page,"page对象不能为空");
		Assert.hasText(memberid, "memberid 不能为空");
		
		String hql = "from MsgInfo where memberByRecuserid.memberid = ? " +
				" and delstatus = 0 and ischat='0' and approstatus = 2 and isshow = '1'" +
				" order by msgdate desc";

		List list = new ArrayList();
		list.add(memberid);
		
		return super.findByPager(page, hql, list);
	}

}
