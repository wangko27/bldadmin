package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.SubjectDao;
import com.cnarj.ttxs.pojo.dsis.TSubject;
import com.cnarj.ttxs.service.SubjectService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 科目业务实现类
 * @author hedan
 *
 */
public class SubjectServiceImpl extends BaseDsisServiceImpl<TSubject, Long> implements SubjectService{

	private SubjectDao subjectDao;
	
	
	
	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
		super.setBaseDao(subjectDao);
	}



	public List<TSubject> getListByExamId(Long njId, Long examId)
			throws BusinessException {
		return subjectDao.getListByExamId(njId, examId);
	}

}
