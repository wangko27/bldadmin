package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IUpSrcDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;

public class UpSrcDaoImpl extends BaseDaoImpl<ReadSrc ,String> implements IUpSrcDao {

	public Result getUpList(Page page, String memberid) {
		String hql = "from ReadSrc as model where model.member.memberid = ? order by model.createdate desc";
		List value = new ArrayList();
		value.add(memberid);
		
		return super.findByPager(page, hql, value);
	}

}
