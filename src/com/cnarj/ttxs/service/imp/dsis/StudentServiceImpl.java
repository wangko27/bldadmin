package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.StudentDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学生业务实现类
 * @author hedan
 *
 */
public class StudentServiceImpl extends BaseDsisServiceImpl<TStudent, Long> implements StudentService{

	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
		super.setBaseDao(studentDao);
	}

	
	public List<TStudent> getStudentListByClassId(String xxid, Long classId)
			throws BusinessException {
		return studentDao.getStudentListByClassId(xxid, classId);
	}

	
	public Result getPager(Page page, Long classId) {
		return studentDao.getPager(page, classId);
	}
	
	
}
