package com.cnarj.ttxs.dao.imp.interest;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.interest.IActivityDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;

/**
 * 兴趣频道Dao实现类 - 活动信息DaoImpl
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityDaoImpl extends BaseDaoImpl<Activity, String> implements
		IActivityDao {

	@SuppressWarnings("unchecked")
	public List<Activity> getActicity(int num) {

		String hql = "from Activity as a1 where  a1.programa.proID in('8a8081b121bd7ec20131bd7f78e50001','8a8081v131bd7eb20131bd7f78e50001','8a8086v231bd7ec20131bd7f78e50001','8a8081v231bf7ec20131bd7f78e50002','8a8081v231bd7eb20131bd7f78e50004','8a8081v231bd7ec20131bd7f78e5000b','8a8681v231bd7ec20133bd7f78e50008') order by a1.createdate desc";
		List<Activity> list = this.getSession().createQuery(hql).setMaxResults(
				num).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Activity> ShowindexActivity(int num){
		String hql="from Activity where begindate<sysdate order by begindate desc";
		List<Activity> list = this.getSession().createQuery(hql).setMaxResults(num).list();
		return list;
	}
	/**
	 * 
	 * @param hql
	 *            执行的hql语句
	 * @param page
	 *            分页信息
	 * @return 返回结果集
	 */
	public Result getActivitys(String hql, Page page) {
		return this.findByPager(page, hql);
	}

	/**
	 * 查询栏目名称
	 * 
	 * @param hql
	 * @return
	 */
	public ActivityPrograma getByIdActivityPrograma(String hql) {
		return (ActivityPrograma) this.getSession().createQuery(hql)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public Result findActivityByPager(Page pager, String activitytitle,
			String proID, String typeId) throws Exception {
		StringBuffer sbHql = new StringBuffer("from Activity a where 1=1 ");
		List values = new ArrayList();
		if (null != activitytitle && !"".equals(activitytitle)) {
			sbHql.append(" and a.activitytitle like ?");
			values.add('%' + activitytitle + '%');
		}
		if (null != proID && !"".equals(proID)) {
			sbHql.append(" and a.programa.proID=?");
			values.add(proID);
		}
		if (null != typeId && !"".equals(typeId)) {
			sbHql.append(" and a.activityType.typeId=?");
			values.add(typeId);
		}
		sbHql.append(" order by a.modifydate desc");
		return this.findByPager(pager, sbHql.toString(), values);
	}

	@SuppressWarnings("unchecked")
	public List<Activity> getByProIdAndCreateTime(String string) {
		
		return this.getSession().createQuery(string).list();
	}

	@SuppressWarnings("unchecked")
	public List<Activity> getCloseActivity(String hql) {
		return this.getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<ActivityTeacher> getTwoTeacher(String hql, int i) {
		return this.getSession().createQuery(hql).setMaxResults(i).list();
	}

	@SuppressWarnings("unchecked")
	public List<Activity> getActivityType(String hql) {
		
		return this.getSession().createQuery(hql).list();
	}

	public Result getAllCloseAct(String hql,Page pager) {
		return this.findByPager(pager, hql);
	}
	@SuppressWarnings("unchecked")
	public List<Activity> getActivity(String hql,int i) {
		// TODO Auto-generated method stub
		return this.getSession().createQuery(hql).setMaxResults(i).list();
	}
}
