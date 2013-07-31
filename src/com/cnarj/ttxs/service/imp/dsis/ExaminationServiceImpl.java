package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import org.apache.log4j.Logger;

import com.cnarj.ttxs.dao.ExaminationDao;
import com.cnarj.ttxs.pojo.dsis.TExamination;
import com.cnarj.ttxs.service.ExaminationService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;
import com.cnarj.ttxs.util.HttpUtil;

/**
 * 考试信息实现类
 * @author hedan
 *
 */
public class ExaminationServiceImpl extends BaseDsisServiceImpl<TExamination, Long> implements ExaminationService{

	private ExaminationDao examinationDao;
	
	protected static Logger logger = Logger.getLogger(ExaminationServiceImpl.class);
	
	
	public ExaminationDao getExaminationDao() {
		return examinationDao;
	}

	public void setExaminationDao(ExaminationDao examinationDao) {
		this.examinationDao = examinationDao;
		super.setBaseDao(examinationDao);
	}



	public List<TExamination> getListByTerm(Long termId, String month)
			throws BusinessException {
		try {
			logger.info(HttpUtil.getMemberUsername()+":查询考试列表");
			return examinationDao.getListByTerm(termId, month);
		} catch (Exception e) {
			logger.error("查询考试列表信息异常："+e.toString());
			throw new BusinessException("查询考试信息异常："+e.toString());
		}
		
	}


	public List<TExamination> getListByClassId(String xxid, Long classId)
			throws BusinessException {
		return examinationDao.getListByClassId(xxid, classId);
	}

	
	public List<TExamination> getListByClassAndTerm(String classId, Long termId)
			throws BusinessException {
		return examinationDao.getListByClassAndTerm(classId, termId);
	}

}
