package com.cnarj.ttxs.dao.imp.sys;


import org.hibernate.Query;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.sys.IAdminDao;
import com.cnarj.ttxs.pojo.sys.Admin;

/**
 * 系统Dao接口实现类 - 管理员
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月13日11:00:18
 */
public class AdminDaoImpl extends BaseDaoImpl<Admin, String> implements
		IAdminDao {

	public Admin login(String username, String adminpassword) {
		String hql = "from Admin where username=? and adminpassword=?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, adminpassword);
		Object obj = query.uniqueResult();
		if (null != obj) {
			return (Admin) obj;
		} else {
			return null;
		}
	}

}
