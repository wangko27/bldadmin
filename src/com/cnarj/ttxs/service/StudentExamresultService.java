package com.cnarj.ttxs.service;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.StudentExamresult;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学生考试成绩信息业务接口类
 * @author hedan
 *
 */
public interface StudentExamresultService extends BaseDsisService<StudentExamresult, Long>{

	/**
	 * 分页查询学生考试成绩
	 * @param page
	 * @param classId
	 * @param xs_id
	 * @param subjectId
	 * @return
	 * @throws BusinessException
	 */
	public Result getStuExamresultPager(Page page, Long classId, Long examId, Long xs_id, Long subjectId)throws BusinessException;
	
	/**
	 * 按科目查询成绩详细信息
	 * @param examId
	 * @return
	 * @throws BusinessException
	 */
	public StudentExamresult getExamDetail(Long examId)throws BusinessException;
}
