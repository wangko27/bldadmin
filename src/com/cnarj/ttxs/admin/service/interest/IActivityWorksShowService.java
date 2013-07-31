package com.cnarj.ttxs.admin.service.interest;

import java.io.File;

import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道后台Service接口类 - 首页活动作品展示
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月30日
 */
public interface IActivityWorksShowService extends
		IBaseService<ActivityWorksShow, String> {

	/**
	 * 添加
	 * 
	 * @param activityWorksShow
	 * @param cover
	 * @param coverFileName
	 * @param coverContentType
	 * @throws Exception
	 */
	public void saveActivityWorksShow(ActivityWorksShow activityWorksShow,
			File cover, String coverFileName, String coverContentType)
			throws Exception;

	/**
	 * 修改
	 * 
	 * @param activityWorksShow
	 * @param cover
	 * @param coverFileName
	 * @param coverContentType
	 * @throws Exception
	 */
	public void updateActivityWorksShow(ActivityWorksShow activityWorksShow,
			File cover, String coverFileName, String coverContentType)
			throws Exception;

	/**
	 * 删除
	 * 
	 * @param showId
	 * @throws Exception
	 */
	public void deleteActivityWorksShow(String showId) throws Exception;

}
