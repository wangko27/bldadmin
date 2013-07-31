package com.cnarj.ttxs.dao.imp.dsis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.StudentAttendanceRecordDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.StudentAttendanceRecord;

/**
 * 学生考勤记录实现类
 * 
 * @author hedan
 * 
 */
public class StudentAttendanceRecordDaoImpl extends
		BaseDaoDsisImpl<StudentAttendanceRecord, Long> implements
		StudentAttendanceRecordDao {

	@SuppressWarnings("unchecked")
	public Result getAttendanceRecordPager(Page page, List values) {
		Assert.notNull(page, "page is required");
		Assert.notNull(values, "values is required");
		String hql = " from StudentAttendanceRecord s where 1=1 and s.readcardTime >= to_date(?, 'yyyy-MM-dd HH24:mi:ss') and s.readcardTime <= to_date(?, 'yyyy-MM-dd HH24:mi:ss')  and s.TStudent.xsId = ? order by s.readcardTime asc";
		return findByPager(page, hql, values);
	}

	
	@SuppressWarnings("unchecked")
	public Result getAttendanceRecordPageByClass(Page page, Long classId, String startDate, String endDate) {
		Assert.notNull(page, "page is required");
		Assert.notNull(classId, "classId is required");
		Assert.notNull(startDate, "stratDate is required");
		Assert.notNull(endDate, "endDate is required");
		List values = new  ArrayList();
		values.add(startDate);
		values.add(endDate);
		values.add(classId);
		StringBuffer hql = new StringBuffer(" from StudentAttendanceRecord s where 1=1 ");
		hql.append(" and s.readcardTime >= to_date(?, 'yyyy-MM-dd HH24:mi:ss') and s.readcardTime <= to_date(?, 'yyyy-MM-dd HH24:mi:ss') "); 
		hql.append(" and s.TStudent.TClasses.bjId = ?  order by s.TStudent.xsId, s.readcardTime asc ");
//		hql.append(" and s.xsId in ( select t.xsId from  TStudent t where 1=1 and t.TClasses.bjId = ? )  order by s.readcardTime asc ");
		return findByPager(page, hql.toString(), values);
	}

}
