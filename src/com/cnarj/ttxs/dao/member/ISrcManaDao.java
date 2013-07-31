package com.cnarj.ttxs.dao.member;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrcCommented;

/**
 * 空间Dao接口 - 下载资源管理 (学习资源评论信息表)
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月30日
 */
public interface ISrcManaDao extends IBaseDao<ReadSrcCommented,String> {

	/**
	 * 查询用户下载的资源信息 分页
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getDownList(Page page,String memberid) ;
}
