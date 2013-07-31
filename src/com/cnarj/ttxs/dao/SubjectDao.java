package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TSubject;

/**
 * 科目对象实体接口
 * @author hedan
 *
 */
public interface SubjectDao extends BaseDsisDao<TSubject, Long>{

	/**
	 * 根据考次和年级查询该考次的科目
	 * @param examId
	 * @return
	 */
	public List<TSubject> getListByExamId(Long njId, Long examId);
}
