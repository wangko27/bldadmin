package com.cnarj.ttxs.dao.imp.dsis;

import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.TCoursesDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.TCourses;

/**
 * 接口实现类
 * @author Administrator
 *
 */
public class TCoursesDaoImpl extends BaseDaoDsisImpl<TCourses, Long> implements TCoursesDao{

	
	@SuppressWarnings("unchecked")
	public List<TCourses> getList(Long bj_id){
		Assert.notNull(bj_id, "bj_id is required");
		String hql = " from TCourses c where 1=1 and c.TClasses.bjId = ? ";
		return getSession().createQuery(hql).setParameter(0, bj_id).list();
	}
}
