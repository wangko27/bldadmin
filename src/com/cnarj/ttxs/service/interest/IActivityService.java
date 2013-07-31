package com.cnarj.ttxs.service.interest;
import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.service.IBaseService;
/**
 * 兴趣频道service类 -  活动信息impl
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityService extends IBaseService<Activity, String> {
	/**
	 * 按栏目id得到已关闭的活动
	 * @param proId
	 * @return
	 */
	public List<Activity> getnewsActivity(int num);
	/*
	 * 获得正在进行的活动 
	 */
	public List<Activity> ShowindexActivity(int num);
	/**
	 * 查询最新的活动兴趣全部
	 * 
	 * @param proId 活动栏目的id号
	 * @return
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */	
	public List<Activity> getActicity(int num) ;
	/**
	 * 
	 * @param hql 执行的hql语句
	 * @param page 分页信息
	 * @return 返回结果集
	 */
	public Result getActivitys(String proId,String resKey,Page page);
	/**
	 * 根据proId得到栏目名称
	 */
	public ActivityPrograma getActivityProGramaName(String proId);
	/**
	 * 按栏目id得到最新的活动信息
	 * @param proId
	 * @return
	 */
	public Activity getByProIdAndCreateTime(String proId);
	/**
	 * 按栏目id得到已关闭的活动
	 * @param proId
	 * @return
	 */
	public List<Activity> getCloseActivity(String proId);
	/**
	 * 得到两位推荐的老师
	 */
	public List<ActivityTeacher> getTwoTeacher();
	/**
	 * 显示前三个月和后一个月的活动的类别
	 * @return
	 */
	public List<Activity> getActicityType();
	/**
	 * 得到所有的已经关闭了的活动
	 * @return
	 */
	public Result getcAllCloseAct(Page pager);
	/**
	 * 根据活动栏目查询 栏目下的精彩活动具体栏目下
	 * @return
	 */
	public List<Activity> getActivity(int i ,String programa );
	
}