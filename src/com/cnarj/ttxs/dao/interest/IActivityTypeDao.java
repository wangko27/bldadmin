package com.cnarj.ttxs.dao.interest;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityType;

/**
 * 兴趣频道Dao接口类 - 活动分类Dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public interface IActivityTypeDao extends IBaseDao<ActivityType, String> {
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
	 * 根据栏目查询所有类别和公用的
	 * 
	 * @param proID
	 *            栏目ID
	 * @return
	 * @throws Exception
	 */
	public List<ActivityType> listActivityTypeByPrograma(String proID) throws Exception;
}
