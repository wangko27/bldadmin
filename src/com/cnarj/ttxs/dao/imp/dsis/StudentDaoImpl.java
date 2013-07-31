package com.cnarj.ttxs.dao.imp.dsis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.StudentDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学生接口实现类
 * @author hedans
 *
 */
public class StudentDaoImpl extends BaseDaoDsisImpl<TStudent, Long> implements StudentDao{

	@SuppressWarnings("unchecked")
	public List<TStudent> getStudentListByClassId(String xxid, Long classId) {
		Assert.notNull(xxid,"xxid is required");
		Assert.notNull(classId,"classId is required");
		try {
			String hql =" from TStudent t where 1=1 and t.TClasses.bjId = ? and t.xxid = ? and t.status = 1";
			List<TStudent> lst = getSession().createQuery(hql).setParameter(0, classId).setParameter(1, xxid).list();
			return lst;
		} catch (Exception e) {
			throw new BusinessException(e.toString());
		}
	}

	
	@SuppressWarnings("unchecked")
	public Result getPager(Page page, Long classId) {
		String hql = " from TStudent s where 1=1 and s.TClasses.bjId = ? ";
		List values = new ArrayList();
		values.add(classId);
		return findByPager(page, hql, values);
	}

}
