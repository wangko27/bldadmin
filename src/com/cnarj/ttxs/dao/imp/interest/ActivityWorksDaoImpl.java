package com.cnarj.ttxs.dao.imp.interest;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.interest.IActivityWorksDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 兴趣频道Dao实现类 - 活动作品Daoimpl
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityWorksDaoImpl extends BaseDaoImpl<ActivityWorks, String>
		implements IActivityWorksDao {

	/**
	 * 得到该栏目所有的参赛作品(分页)
	 * 
	 * @return
	 */
	public Result getActivityWorkses(String hql, Page page) {
		return this.findByPager(page, hql);
	}

	/**
	 * 根据票数得到显示的行
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityWorks> getByFareActivityWorkses(int num, String hql) {
		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}

	/**
	 * 根据活动的Id得到活动的详细信息
	 * 
	 * @param hql
	 * @param actId
	 *            活动id
	 * @return
	 */
	public Activity getByIdActivity(String hql, String actId) {
		return (Activity) this.getSession().createQuery(hql).setParameter(0,
				actId).uniqueResult();
	}

	/**
	 * 根据活动的Id得到指导老师
	 * 
	 * @param string
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityTeacher> getByActIdActivityTeacher(String hql) {
		return this.getSession().createQuery(hql).list();
	}

	/**
	 * 的到相关拼论
	 * 
	 * @param hql
	 *            执行的hql
	 * @param num
	 *            限制行数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityWorkCommented> getByActIdActivityWorkCommented(
			String hql, int num) {
		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}

	/**
	 * 
	 * 按活动的id号 得到num条的参赛作品
	 * 
	 * @param num
	 * @return
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityWorks> getActivityWorkses(String hql, int num) {
		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}

	/**
	 * 根据老师的id得到最新的博文信息 并限定行数
	 * 
	 * @param hql
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Blog> getByTeacherIdBlog(String hql, int i) {
		return this.getSession().createQuery(hql).setMaxResults(i).list();
	}

	/**
	 * 根据活动公告的id查找信息信息
	 * 
	 * @param hql
	 * @param num
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Article> getBySysnotesidArticles(String hql, int num) {
		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}

	@SuppressWarnings("unchecked")
	public Result findActivityWorksByPager(Page pager, String activityid,
			String worksnumber, String workstitle, String author)
			throws Exception {
		StringBuffer sbHql = new StringBuffer("from ActivityWorks aw where aw.activity.activityid='"+activityid+"' ");
		List values = new ArrayList();
		if (null != workstitle && !"".equals(workstitle)) {
			sbHql.append(" and aw.workstitle like ?");
			values.add('%' + workstitle + '%');
		}
		if (null != worksnumber && !"".equals(worksnumber)) {
			sbHql.append(" and aw.worksnumber like ?");
			values.add('%' + worksnumber + '%');
		}
		if (null != author && !"".equals(author)) {
			sbHql.append(" and aw.author=?");
			values.add(author);
		}
		sbHql.append(" order by aw.approstatu desc");
		return this.findByPager(pager, sbHql.toString(), values);
	}

	public Result getAllActivityBulletin(String hql, Page page) {	
		return this.findByPager(page, hql);
	}
	/**
	 * 得到该活动的总的评论数量
	 * @param activitId
	 * @return
	 */
	public Long getByActIdActivityWorkCommentedNum(String hql) {
		return (Long) this.getSession().createQuery(hql).uniqueResult();
	}

}
