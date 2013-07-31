package com.cnarj.ttxs.admin.service.interest;

import java.io.File;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道后台Service接口类 - 活动作品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public interface IActivityWorksService extends
		IBaseService<ActivityWorks, String> {
	/**
	 * 查找作品（带分页）
	 * 
	 * @param pager
	 * @param activityid
	 * @param worksnumber
	 * @param workstitle
	 * @param author
	 * @return
	 * @throws Exception
	 */
	public Result findActivityWorksByPager(Page pager, String activityid,
			String worksnumber, String workstitle, String author)
			throws Exception;

	/**
	 * 添加作品
	 * 
	 * @param activityWorks
	 * @param cover
	 * @param coverFileName
	 * @param coverContentType
	 * @param show
	 * @param showFileName
	 * @param showContentType
	 * @throws Exception
	 */
	public void saveActivityWorks(ActivityWorks activityWorks, File cover,
			String coverFileName, String coverContentType, File show,
			String showFileName, String showContentType) throws Exception;

	/**
	 * 修改作品
	 * 
	 * @param activityWorks
	 * @param cover
	 * @param coverFileName
	 * @param coverContentType
	 * @param show
	 * @param showFileName
	 * @param showContentType
	 * @throws Exception
	 */
	public void updateActivityWorks(ActivityWorks activityWorks, File cover,
			String coverFileName, String coverContentType, File show,
			String showFileName, String showContentType) throws Exception;

	/**
	 * 删除作品
	 * 
	 * @param worksid
	 * @throws Exception
	 */
	public void deleteActivityWorks(String worksid) throws Exception;
}
