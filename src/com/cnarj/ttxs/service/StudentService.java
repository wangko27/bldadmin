package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学生实体业务接口
 * @author hedan
 *
 */
public interface StudentService extends BaseDsisService<TStudent, Long>{

	
	/**
	 * 根据班级id和学校id查询在校生列表
	 * @param xxid
	 * @param classId
	 * @return
	 */
	public List<TStudent> getStudentListByClassId(String xxid,Long classId)throws BusinessException;
	
	
	/**
	 * 根据班级查询学生信息-带分页
	 * @param page
	 * @param classId
	 * @return
	 */
	public Result getPager(Page page, Long classId);
}
