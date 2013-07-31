package com.cnarj.ttxs.service.interest;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道Service类 - 活动作品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityWorksService extends IBaseService<ActivityWorks, String>{

	/**
	 * 按活动的id号  得到所有的参赛作品
	 * @param workId 
	 * @return
	 */
	public Result getByActivityIdWorks(String activityId,Page page);
	/**
	 * 根据活动票数得到规定的num条数据
	 * isPro 是否按栏目来查
	 * pro  栏目的id
	 * @param num
	 * @return
	 */
	public List<ActivityWorks> getByFareActivityWorks(int num,boolean isPro,String pro);
	/**
	 * 根据活动的id得到活动的详细信息
	 * @param actId 活动Id
	 * @return
	 */
	public Activity getByIdActivity(String actId);
	/**
	 * 获得最新通过审核的活动作品
	 * @param actId 活动Id
	 * @return
	 */
	public List<ActivityWorks> getnewsWorks(int num) ;
	/**
	 * 根据活动的id 得到所有的活动的指导老师
	 * @param actId 活动的id
	 * @return
	 */
	public List<ActivityTeacher> getByActIdActivityTeacher(String actId);
	/**
	 * 根据活动的Id得到num条用户拼论
	 * @param stypeId 查询评论的条件
	 * @param num
	 * @param isSelect 是否是单个作品的评论
	 * @return
	 */
	public List<ActivityWorkCommented> getByActIdActivityWorkCommented(String stypeId,int num,boolean isSelect );
	/**
	 * 按活动的id号  得到num条的参赛作品,descType为排序类型
	 * @param num
	 * @return
	 */
	public List<ActivityWorks> getByActivityIdWorks(String actId,int num ,String descType);
	/**
	 * 根据老师的id得到他的最新博文信息
	 */
	public Blog getByTeacherIdBlog(String teacherid);
	/**
	 * 根据活动系统的id得到活动公告
	 */
	public List<Article> getBySysnotesidArticles(String actId,int num);
	/**
	 * 根据行业知识的id得到行业知识
	 * 
	 */
	public List<Article> getByIndustryidArticles(String actid,int num,boolean isAll);
	/**
	 *按作品id修改投票次数
	 *并返回修改后的值
	 */
	public ActivityWorks updateActivityWorksFare(String worksId);
	/**
	 * 得到所有的活动公告(根据活动)
	 * @param sysnotesid
	 * @return
	 */
	public Result getAllActivityBulletin(String sysnotesid,Page page);
	/**
	 * 得到该活动的总的评论数量
	 * @param activitId
	 * @return
	 */
	public Long getByActIdActivityWorkCommentedNum(String activitId);
	
}