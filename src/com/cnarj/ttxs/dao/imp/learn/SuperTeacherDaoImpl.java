package com.cnarj.ttxs.dao.imp.learn;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.ISuperTeacherDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;

public class SuperTeacherDaoImpl extends BaseDaoImpl<SuperTeacher, String>
		implements ISuperTeacherDao {
	@SuppressWarnings("unchecked")
	public List<SuperTeacher> getsuperteacher(int num) {
		// TODO Auto-generated method stub
		String hql = "from SuperTeacher s where s.isenable=1 and order by s.peopleNum ";

		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}
	@SuppressWarnings("unchecked")
	public List<SuperTeacher> getnewteacher(int num) {
		// TODO Auto-generated method stub
		String hql = "from SuperTeacher s where s.isenable='1' order by createDate desc ";

		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}
	@SuppressWarnings("unchecked")
	public Result findSuperTeacherByPage(Page page, String username,
			Long flag, String inSchool) throws Exception {
		StringBuffer sbHql = new StringBuffer("from SuperTeacher s where s.isenable=1 ");
		List values = new ArrayList();
		if (null != username && !"".equals(username)) {
			sbHql.append(" and s.username like ?");
			values.add('%' + username + '%');
		}

		if (null != flag) {
			sbHql.append(" and s.flag=?");
			values.add(flag);
		}
		if (null != inSchool && !"".equals(inSchool)) {
			sbHql.append(" and s.inSchool like ?");
			values.add('%' + inSchool + '%');
		}

		sbHql.append(" order by s.peopleNum desc");
		return this.findByPager(page, sbHql.toString(), values);
	}

}
