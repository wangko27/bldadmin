package com.cnarj.ttxs.dao.interest;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 兴趣频道Dao接口类 - 活动作品Dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityWorksDao extends IBaseDao<ActivityWorks, String> {

	/**
	 * 得到该栏目所有的参赛作品(分页)
	 * 
	 * @return
	 */
	public Result getActivityWorkses(String hql, Page page);

	/**
	 * 根据票数来显示参赛作品(num 条)
	 */
	public List<ActivityWorks> getByFareActivityWorkses(int num, String hql);

	/**
	 * 根据活动的Id得到活动的详细信息
	 * 
	 * @param hql
	 * @param actId
	 *            活动id
	 * @return
	 */
	public Activity getByIdActivity(String hql, String actId);

	/**
	 * 根据活动的Id得到指导老师
	 * 
	 * @param string
	 * @return
	 */
	public List<ActivityTeacher> getByActIdActivityTeacher(String string);

	/**
	 * 的到相关
	 * 
	 * @param hql
	 *            执行的hql
	 * @param num
	 *            限制行数
	 * @return
	 */
	public List<ActivityWorkCommented> getByActIdActivityWorkCommented(
			String hql, int num);

	/**
	 * 
	 * 按活动的id号 得到num条的参赛作品
	 * 
	 * @param num
	 * @return
	 * 
	 */
	public List<ActivityWorks> getActivityWorkses(String hql, int num);

	/**
	 * 根据老师的id得到最新的博文信息 并限定行数
	 * 
	 * @param hql
	 * @param i
	 * @return
	 */
	public List<Blog> getByTeacherIdBlog(String hql, int i);

	/**
	 * 根据活动公告的id查找信息信息
	 * 
	 * @param hql
	 * @param num
	 * @return
	 */
	public List<Article> getBySysnotesidArticles(String hql, int num);

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

	public Result getAllActivityBulletin(String hql, Page page);

	/**
	 * 得到该活动的总的评论数量
	 * @param activitId
	 * @return
	 */
	public Long getByActIdActivityWorkCommentedNum(String hql);
}
