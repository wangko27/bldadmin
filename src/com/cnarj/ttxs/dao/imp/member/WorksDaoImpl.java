package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IWorksDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;


/**
 * 空间dao接口实现类 - 作品管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月6日
 */
public class WorksDaoImpl extends BaseDaoImpl<ActivityWorks,String> implements IWorksDao {

	public Result getWorksList(Page page, String memberid) {
		String hql = "from ActivityWorks as model where model.member.memberid = ? order by model.createdate desc";
		List value = new ArrayList();
		value.add(memberid);
		
		return super.findByPager(page, hql, value);
	}

}
