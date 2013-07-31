package com.cnarj.ttxs.admin.service.interest;


import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityType;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道后台Service接口类 - 活动类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public interface IActivityTypeService extends
		IBaseService<ActivityType, String> {

	/**
	 * 添加活动类别
	 * 
	 * @param activityType
	 * @throws Exception
	 */
	public void saveActivityType(ActivityType activityType) throws Exception;

	/**
	 * 修改活动类别
	 * 
	 * @param activityType
	 * @throws Exception
	 */
	public void updateActivityType(ActivityType activityType) throws Exception;

	/**
	 * 查找活动类别（带分页）
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
	public Result findActivityTypeByPager(Page pager, String typeName,
			String proID) throws Exception;

	/**
	 * 根据栏目查询所有类别和公用的 构建下拉选项
	 * 
	 * @param proID
	 *            栏目ID
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getActivityTypeByOption(String proID) throws Exception;
}
