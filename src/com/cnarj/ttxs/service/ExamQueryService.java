package com.cnarj.ttxs.service;

import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.TExamination;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 考试查询业务接口
 * @author hedan
 *
 */
public interface ExamQueryService extends BaseDsisService<TExamination,Long>{

	/**
	 * 根据学生id和考试id查询成绩信息
	 * @param xs_id
	 * @param examId
	 * @return
	 * @throws BusinessException
	 */
	public StringBuffer getExaminationByStu(Long njId, Long xs_id, Long examId)throws BusinessException;
	
	/**
	 * 老师查询学生成绩
	 * @param classId
	 * @param xs_id
	 * @param subjectId
	 * @return
	 * @throws BusinessException
	 */
	public Result getExaminationByTea(Long classId, Long xs_id, Long subjectId)throws BusinessException;
}
