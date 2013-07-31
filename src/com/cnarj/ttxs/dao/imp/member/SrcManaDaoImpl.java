package com.cnarj.ttxs.dao.imp.member;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.ISrcManaDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrcCommented;
import com.cnarj.ttxs.pojo.learn.ReadSrcDownRec;


/**
 * 空间Dao接口实现类 - 下载资源管理  (学习资源评论信息表)
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月30日
 */
public class SrcManaDaoImpl extends BaseDaoImpl<ReadSrcCommented,String> implements ISrcManaDao {

	public Result getDownList(Page page, String memberid) {
		String hql = "from ReadSrcDownRec as model where model.member.memberid = ? order by model.downloaddate desc";
		List value = new ArrayList();
		value.add(memberid);
		
		return super.findByPager(page, hql, value);
	}

}
