package com.cnarj.ttxs.service.imp.dsis;

import com.cnarj.ttxs.dao.StudentBindingMobileDao;
import com.cnarj.ttxs.pojo.dsis.StudentBindingMobile;
import com.cnarj.ttxs.service.StudentBindingMobileService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;

public class StudentBindingMobileServiceImpl extends BaseDsisServiceImpl<StudentBindingMobile, Long> implements StudentBindingMobileService{

	private StudentBindingMobileDao studentBindingMobileDao;

	public StudentBindingMobileDao getStudentBindingMobileDao() {
		return studentBindingMobileDao;
	}

	public void setStudentBindingMobileDao(
			StudentBindingMobileDao studentBindingMobileDao) {
		this.studentBindingMobileDao = studentBindingMobileDao;
		super.setBaseDao(studentBindingMobileDao);
	}

	
	
	
}
