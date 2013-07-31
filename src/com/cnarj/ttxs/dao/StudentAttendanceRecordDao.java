package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.StudentAttendanceRecord;

/**
 * 学生考勤记录接口
 * @author Administrator
 *
 */
public interface StudentAttendanceRecordDao extends BaseDsisDao<StudentAttendanceRecord, Long> {

	/**
	 * 根据学生id获得某时间段内的考勤记录-带分页
	 * @param startDate
	 * @param endDate
	 * @param xs_id
	 * @return
	 */
	public Result getAttendanceRecordPager(Page page, List values);
	
	/**
	 * 查询某班级某时间段内的考勤记录-带分页
	 * @param page
	 * @param values
	 * @return
	 */
	public Result getAttendanceRecordPageByClass(Page page, Long classId, String startDate, String endDate);
}
