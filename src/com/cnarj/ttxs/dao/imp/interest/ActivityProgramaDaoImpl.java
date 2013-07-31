package com.cnarj.ttxs.dao.imp.interest;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.interest.IActivityProgramaDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;

/**
 * 兴趣频道Dao实现类 - 活动栏目Daoimpl
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityProgramaDaoImpl extends
		BaseDaoImpl<ActivityPrograma, String> implements IActivityProgramaDao {

	/**
	 * 
	 * 得到活动栏目信息 isNumber 是否启用限行
	 * 
	 * @param hql
	 *            要执行的sql语句
	 * @param number
	 *            显示行数
	 * @return 返回结果
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityPrograma> getActivityProgramas(boolean isNumber,
			String hql, int number) {
		if (isNumber) {
			return getSession().createQuery(hql).setMaxResults(number).list();
		} else {
			return getSession().createQuery(hql).list();
		}
	}
	/**
	 * 查找活动栏目（带分页）
	 * 
	 * @param proName
	 *            栏目名称
	 * @param proIsenable
	 *            状态
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Result findProgramaByPager(Page pager, String proName,
			Long proIsenable) throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ActivityPrograma ap where 1=1 ");
		List values = new ArrayList();
		if (null != proName && !"".equals(proName)) {
			sbHql.append(" and ap.proName like ?");
			values.add('%' + proName + '%');
		}
		if (null != proIsenable) {
			sbHql.append(" and proIsenable=?");
			values.add(proIsenable);
		}
		sbHql.append(" order by proSort ");
		return this.findByPager(pager, sbHql.toString(), values);
	}
	/**
	 * 得到展示图片
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityWorksShow> getShowPics(String hql) {
		return this.getSession().createQuery(hql).list();
	}
	/**
	 * 得到所有的排行榜
	 */
	public Result getAllFera(String hql, Page page) {
		return this.findByPager(page, hql);
	}
}
