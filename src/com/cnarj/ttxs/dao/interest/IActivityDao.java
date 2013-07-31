package com.cnarj.ttxs.dao.interest;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;

/**
 * 兴趣频道Dao接口类 - 活动信息Dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityDao extends IBaseDao<Activity, String> {
	/*
	 * 获得正在进行的活动 
	 */
	public List<Activity> ShowindexActivity(int num);
	/**
	 * 
	 * @param hql
	 *            执行的hql语句
	 * @param page
	 *            分页信息
	 * @return 返回结果集
	 */
	public Result getActivitys(String hql, Page page);

	/**
	 * 查询栏目名称
	 * 
	 * @param hql
	 * @return
	 */
	public ActivityPrograma getByIdActivityPrograma(String hql);

	public List<Activity> getActicity(int num);

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

	public List<Activity> getByProIdAndCreateTime(String string);
/**
 * 得到该栏目关闭的活动
 * @param hql
 * @return
 */
	public List<Activity> getCloseActivity(String hql);
	/**
	 * 得到两位推荐的老师
	 */
	public List<ActivityTeacher> getTwoTeacher(String hql, int i);

	/**
	 * 显示正在进行的活动 按时间排序
	 * @return
	 */
	public List<Activity> getActivityType(String hql);

	/**
	 * 显示 正在进行的活动 6条
	 * @return
	 */
	public List<Activity> getActivity(String hql,int i);

	/**
	 *得到所有已经关闭了的活动
	 * @param string
	 * @return
	 */
	public Result getAllCloseAct(String hql,Page pager);
}
