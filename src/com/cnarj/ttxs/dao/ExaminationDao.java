package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TExamination;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 考试信息接口类
 * @author hedan
 *
 */
public interface ExaminationDao extends BaseDsisDao<TExamination, Long>{

	/**
	 * 根据学期名称和月份获得考试信息列表
	 * @param termName 学期
	 * @param month 月份 -1代表所有月份
	 * @return
	 */
	public List<TExamination> getListByTerm(Long termId, String month);
	
	/**
	 * 根据学校id和班级id获得考试列表
	 * @param xxid
	 * @param ClassId
	 * @return
	 */
	public List<TExamination> getListByClassId(String xxid, Long classId);
	
	/**
	 * 根据学生id获得考试列表
	 * @param xs_id
	 * @return
	 */
	public List<TExamination> getListByStuid(Long xs_id);
	
	
	/**
	 * 根据班级和学期查询考次
	 * @param classId
	 * @param termId
	 * @return
	 * @throws BusinessException
	 */
	public List<TExamination> getListByClassAndTerm(String classId, Long termId);
}
