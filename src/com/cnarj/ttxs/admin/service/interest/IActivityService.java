package com.cnarj.ttxs.admin.service.interest;

import java.io.File;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道后台Service接口类 - 活动
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public interface IActivityService extends IBaseService<Activity, String> {
	/**
	 * 添加活动
	 * 
	 * @param activity
	 * @param cover
	 * @throws Exception
	 */
	public void saveActivity(Activity activity, File cover,
			String coverFileName, String coverContentType, File featured,
			String featuredFileName, String featuredContentType)
			throws Exception;

	/**
	 * 修改活动
	 * 
	 * @param activity
	 * @param cover
	 * @throws Exception
	 */
	public void updateActivity(Activity activity, File cover,
			String coverFileName, String coverContentType, File featured,
			String featuredFileName, String featuredContentType)
			throws Exception;

	/**
	 * 查找活动（带分页）
	 * 
	 * @param pager
	 * 
	 * @param typeName
	 *            活动名称
	 * @param proID
	 *            栏目ID
	 * @return
	 * @throws Exception
	 */
	public Result findActivityByPager(Page pager, String activitytitle,
			String proID, String typeId) throws Exception;

	/**
	 * 删除活动
	 * 
	 * @param activityid
	 *            活动ID
	 * @throws Exception
	 */
	public void deleteActivity(String activityid) throws Exception;

}
