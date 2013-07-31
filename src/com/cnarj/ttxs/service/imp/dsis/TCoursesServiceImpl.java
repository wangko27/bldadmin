package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.TCoursesDao;
import com.cnarj.ttxs.pojo.dsis.TCourses;
import com.cnarj.ttxs.service.TCoursesService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 课程表实现类
 * @author hedan
 *
 */
public class TCoursesServiceImpl extends BaseDsisServiceImpl<TCourses, Long> implements TCoursesService{

	
	private TCoursesDao coursesDao;

	public TCoursesDao getCoursesDao() {
		return coursesDao;
	}

	public void setCoursesDao(TCoursesDao coursesDao) {
		this.coursesDao = coursesDao;
		super.setBaseDao(coursesDao);
	}

	
	public List<TCourses> getList(Long bj_id) throws BusinessException {
		return coursesDao.getList(bj_id);
	}
	
	

	
}
