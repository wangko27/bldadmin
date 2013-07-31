package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.TStudent;

/**
 * 学生接口类
 * @author hedan
 *
 */
public interface StudentDao extends BaseDsisDao<TStudent, Long>{

	
	/**
	 * 根据班级id和学校id查询在校生列表
	 * @param xxid
	 * @param classId
	 * @return
	 */
	public List<TStudent> getStudentListByClassId(String xxid,Long classId);
	
	/**
	 * 根据班级查询学生信息 -- 带分页
	 * @param page
	 * @param classId
	 * @return
	 */
	public Result getPager(Page page, Long classId);
}
