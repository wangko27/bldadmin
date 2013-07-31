package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.service.IBaseService;


/**
 * 空间service接口 - 作品管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月6日
 */
public interface IWorksService extends IBaseService<ActivityWorks,String> {

	/**
	 * 查询用户的作品
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getWorksList(Page page,String memberid);
	
	/**
	 * 查询当前活动列表
	 * @return
	 */
	public List<Activity> getActivityList();
	
	/**
	 * 取消添加作品
	 */
	public void cancel(ActivityWorks work,List<ActivityWorkPhotos> list);
	
	/**
	 * 添加作品
	 */
	public void addWork(ActivityWorks work,List<ActivityWorkPhotos> list);
}
