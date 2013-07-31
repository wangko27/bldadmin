package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TExamination;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 考试信息业务接口
 * @author hedan
 *
 */
public interface ExaminationService extends BaseDsisService<TExamination, Long>{

	
	/**
	 * 根据学生和月份得到考次列表
	 * @param termId
	 * @param month
	 * @return
	 * @throws BusinessException
	 */
	public List<TExamination> getListByTerm(Long termId, String month)throws BusinessException;
	
	
	/**
	 * 根据学校id和班级id获得考试列表
	 * @param xxid
	 * @param ClassId
	 * @return
	 */
	public List<TExamination> getListByClassId(String xxid, Long classId)throws BusinessException;
	
	
	/**
	 * 根据班级和学期查询考次
	 * @param classId
	 * @param termId
	 * @return
	 * @throws BusinessException
	 */
	public List<TExamination> getListByClassAndTerm(String classId, Long termId)throws BusinessException;
	
	
}
