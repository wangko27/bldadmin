package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.TClassesDao;
import com.cnarj.ttxs.pojo.dsis.TClasses;
import com.cnarj.ttxs.service.TClassesService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 班级业务实现类
 * @author hedan
 *
 */
public class TClassesServiceImpl extends BaseDsisServiceImpl<TClasses, Long> implements TClassesService{

	private TClassesDao classesDao;

	public TClassesDao getClassesDao() {
		return classesDao;
	}

	public void setClassesDao(TClassesDao classesDao) {
		this.classesDao = classesDao;
		super.setBaseDao(classesDao);
	}

	
	public List<TClasses> getList(Long xs_id) throws BusinessException {
		return classesDao.getList(xs_id);
	}

	
	public List<TClasses> getClassesListByBindGrade(Long gradeId, Long teacherId)
			throws BusinessException {
		return classesDao.getClassesListByBindGrade(gradeId, teacherId);
	}
	
	
}
