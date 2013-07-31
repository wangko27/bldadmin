package com.cnarj.ttxs.service.imp.dsis;

import com.cnarj.ttxs.dao.ExamSubInfoDao;
import com.cnarj.ttxs.pojo.dsis.ExamSubInfo;
import com.cnarj.ttxs.service.ExamSubInfoService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;

/**
 * 考试科目
 * @author Administrator
 *
 */
public class ExamSubInfoServiceImpl extends BaseDsisServiceImpl<ExamSubInfo, Long>implements ExamSubInfoService{

	private ExamSubInfoDao examSubInfoDao;

	public ExamSubInfoDao getExamSubInfoDao() {
		return examSubInfoDao;
	}

	public void setExamSubInfoDao(ExamSubInfoDao examSubInfoDao) {
		this.examSubInfoDao = examSubInfoDao;
		super.setBaseDao(examSubInfoDao);
	}
	
	
}
