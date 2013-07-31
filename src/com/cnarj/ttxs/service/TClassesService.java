package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TClasses;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 班级业务接口
 * @author hedan
 *
 */
public interface TClassesService extends BaseDsisService<TClasses, Long>{

	/**
	 * 根据班级id获得班级对象列表
	 * @param xs_id
	 * @return
	 * @throws BusinessException
	 */
	public List<TClasses> getList(Long xs_id)throws BusinessException;
	
	
	/**
	 * 根据教师账户绑定的年级得到班级列表
	 * @param gradeId 年级id
	 * @param teacherId 教师账户id
	 * @return 班级列表
	 */
	public List<TClasses> getClassesListByBindGrade(Long gradeId, Long teacherId)throws BusinessException;
}
