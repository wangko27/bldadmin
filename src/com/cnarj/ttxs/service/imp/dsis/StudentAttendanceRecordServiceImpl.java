package com.cnarj.ttxs.service.imp.dsis;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cnarj.ttxs.dao.StudentAttendanceRecordDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.StudentAttendanceRecord;
import com.cnarj.ttxs.service.StudentAttendanceRecordService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 业务实现类
 * @author hedan
 *
 */
public class StudentAttendanceRecordServiceImpl extends BaseDsisServiceImpl<StudentAttendanceRecord, Long> implements StudentAttendanceRecordService{

	private StudentAttendanceRecordDao studentAttendanceRecordDao;
	
	protected static Logger logger = Logger.getLogger(StudentAttendanceRecordServiceImpl.class);

	public StudentAttendanceRecordDao getStudentAttendanceRecordDao() {
		return studentAttendanceRecordDao;
	}

	public void setStudentAttendanceRecordDao(
			StudentAttendanceRecordDao studentAttendanceRecordDao) {
		this.studentAttendanceRecordDao = studentAttendanceRecordDao;
		super.setBaseDao(studentAttendanceRecordDao);
	}

	
	@SuppressWarnings("unchecked")
	public Result getAttendanceRecordPager(Page page, String startDate, String endDate, Long xs_id)throws BusinessException{
		try {
			startDate = startDate.substring(0, 10)+" 00:00:00";
			endDate = endDate.substring(0, 10)+" 23:59:59";
			List values = new ArrayList();
			values.add(startDate);
			values.add(endDate);
			values.add(xs_id);
			return studentAttendanceRecordDao.getAttendanceRecordPager(page, values);
		} catch (Exception e) {
			logger.error("查询考勤记录出错！原因："+e.toString());
			throw new BusinessException("查询考勤记录出错！原因："+e.toString());
		}
		
	}


	public Result getAttendanceRecordPageByClass(Page page, Long classId,
			String startDate, String endDate) throws BusinessException {
		startDate = startDate.substring(0, 10)+" 00:00:00";
		endDate = endDate.substring(0, 10)+" 23:59:59";
		return studentAttendanceRecordDao.getAttendanceRecordPageByClass(page, classId, startDate, endDate);
	}
	
	
	
}
