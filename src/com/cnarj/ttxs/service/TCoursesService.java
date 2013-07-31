package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TCourses;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 课程表实现类
 * @author Administrator
 *
 */
public interface TCoursesService extends BaseDsisService<TCourses, Long>{

	/**
	 * 根据班级id获得课程表列表
	 * @param bj_id
	 * @return
	 */
	public List<TCourses> getList(Long bj_id)throws BusinessException;
}
