package com.cnarj.ttxs.dao.member;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;


/**
 * 空间dao接口 - 作品管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月6日
 */
public interface IWorksDao extends IBaseDao<ActivityWorks,String> {

	/**
	 * 查询用户的作品
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getWorksList(Page page,String memberid);
}
