package com.cnarj.ttxs.service;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.StudentAttendanceRecord;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学生考勤记录业务处理接口
 * @author hedan
 *
 */
public interface StudentAttendanceRecordService extends BaseDsisService<StudentAttendanceRecord, Long>{

	/**
	 * 根据学生id获得某时间段内的考勤记录
	 * @param startDate
	 * @param endDate
	 * @param xs_id
	 * @return
	 */
	public Result getAttendanceRecordPager(Page page, String startDate, String endDate, Long xs_id)throws BusinessException;
	
	/**
	 * 查询某班级的一段时间内的学生考勤记录
	 * @param page
	 * @param classId
	 * @param stratDate
	 * @param endDate
	 * @return
	 * @throws BusinessException
	 */
	public Result getAttendanceRecordPageByClass(Page page, Long classId, String startDate, String endDate)throws BusinessException;
}
