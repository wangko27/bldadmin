package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.StudentExamresult;

/**
 * 学生考试详细信息接口
 * @author hedan
 *
 */
public interface StudentExamresultDao extends BaseDsisDao<StudentExamresult, Long>{

	/**
	 * 根据考试id和学生id查询学生成绩对象
	 * @param examId
	 * @param xs_id
	 * @return
	 */
	public StudentExamresult get(Long examId, Long xs_id);
	
	
	@SuppressWarnings("unchecked")
	public Result getStuExamresultPager(Page page, Long classId, Long examId, Long xs_id, Long subjectId);
	
}
