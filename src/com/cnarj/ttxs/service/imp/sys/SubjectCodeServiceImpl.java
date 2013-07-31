package com.cnarj.ttxs.service.imp.sys;

import java.util.List;

import com.cnarj.ttxs.dao.sys.ISubjectCodeDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;

/**
 * 系统Service实现类 - 科目代码
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class SubjectCodeServiceImpl extends BaseServiceImpl<SubjectCode,String> implements
		ISubjectCodeService {
	
	private ISubjectCodeDao subjectCodeDao;
	
	public ISubjectCodeDao getSubjectCodeDao() {
		return subjectCodeDao;
	}

	public void setSubjectCodeDao(ISubjectCodeDao subjectCodeDao) {
		this.subjectCodeDao = subjectCodeDao;
	}

	public void setBaseDao(ISubjectCodeDao subjectCodeDao) {
		super.setBaseDao(subjectCodeDao);
	}

	public String savetest(String id, SubjectCode s) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 根据数组查询科目
	 * 
	 */
	public List<SubjectCode> getsubject(String[] values){
		String hql="from SubjectCode s where s.subjectcode in(:values)";
		
		return subjectCodeDao.getList(hql);
		
	}

}
