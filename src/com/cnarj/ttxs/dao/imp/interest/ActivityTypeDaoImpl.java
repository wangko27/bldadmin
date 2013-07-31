package com.cnarj.ttxs.dao.imp.interest;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.interest.IActivityTypeDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityType;

/**
 * 兴趣频道Dao实现类 - 活动分类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityTypeDaoImpl extends BaseDaoImpl<ActivityType, String>
		implements IActivityTypeDao {

	@SuppressWarnings("unchecked")
	public Result findActivityTypeByPager(Page pager, String typeName,
			String proID) throws Exception {
		StringBuffer sbHql = new StringBuffer("from ActivityType at where 1=1 ");
		List values = new ArrayList();
		if (null != typeName && !"".equals(typeName)) {
			sbHql.append(" and at.typeName like ?");
			values.add('%' + typeName + '%');
		}
		if (null != proID && !"".equals(proID)) {
			sbHql.append(" and at.programa.proID=?");
			values.add(proID);
		}
		sbHql.append(" order by typeUpdatedate desc");
		return this.findByPager(pager, sbHql.toString(), values);
	}

	@SuppressWarnings("unchecked")
	public List<ActivityType> listActivityTypeByPrograma(String proID) throws Exception {
		String hql = "from ActivityType at where at.programa.proID='" + proID
				+ "' or at.programa.proID is null";
		return this.getSession().createQuery(hql).list();
	}

}
