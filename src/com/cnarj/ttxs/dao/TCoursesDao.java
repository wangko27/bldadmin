package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TCourses;

/**
 * 课程表接口类
 * @author hedan
 *
 */
public interface TCoursesDao extends BaseDsisDao<TCourses, Long>{

	/**
	 * 根据班级id获得课程表列表
	 * @param bj_id
	 * @return
	 */
	public List<TCourses> getList(Long bj_id);
}
