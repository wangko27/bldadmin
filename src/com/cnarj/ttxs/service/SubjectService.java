package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TSubject;
import com.cnarj.ttxs.util.BusinessException;

public interface SubjectService extends BaseDsisService<TSubject, Long>{


	/**
	 * 根据考次和年级查询该考次的科目
	 * @param examId
	 * @return
	 */
	public List<TSubject> getListByExamId(Long njId, Long examId)throws BusinessException;
}
