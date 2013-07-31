package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TClasses;

/**
 * 班级接口类
 * @author hedan
 *
 */
public interface TClassesDao extends BaseDsisDao<TClasses, Long>{

	/**
	 * 根据学生id获得班级实体列表
	 * @param xs_id
	 * @return
	 */
	public List<TClasses> getList(Long xs_id);
	
	
	/**
	 * 根据教师账户绑定的年级得到班级列表
	 * @param gradeId 年级id
	 * @param teacherId 教师账户id
	 * @return 班级列表
	 */
	public List<TClasses> getClassesListByBindGrade(Long gradeId, Long teacherId);
}
