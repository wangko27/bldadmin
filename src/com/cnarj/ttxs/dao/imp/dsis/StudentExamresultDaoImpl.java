package com.cnarj.ttxs.dao.imp.dsis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.StudentExamresultDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.StudentExamresult;

/**
 * 学生成绩信息详细接口实现类
 * @author hedan
 *
 */
public class StudentExamresultDaoImpl extends BaseDaoDsisImpl<StudentExamresult, Long> implements StudentExamresultDao{


	@SuppressWarnings("unchecked")
	public StudentExamresult get(Long examId, Long xs_id) {
		String hql =" from StudentExamresult se where 1=1 and se.TExamination.examId = ? and se.TStudent.xsId = ? ";
		List<StudentExamresult> lst = getSession().createQuery(hql).setParameter(0, examId).setParameter(1, xs_id).list();
		return (lst != null && lst.size() > 0) ? lst.get(0) : null;
	}

	
	@SuppressWarnings("unchecked")
	public Result getStuExamresultPager(Page page, Long classId, Long examId, Long xs_id, Long subjectId) {
		Assert.notNull(page, "page is required");
		List values = new ArrayList();
		StringBuffer hql = new StringBuffer("from StudentExamresult s where 1=1"); 
		if(classId != null && classId != 0){
			values.add(classId);
			hql.append(" and s.TClasses.bjId = ? ");
		}
		if(examId != null && examId != 0){
			values.add(examId);
			hql.append(" and s.TExamination.examId = ? ");
		}
		if(xs_id != null && xs_id != -1){
			values.add(xs_id);
			hql.append(" and s.TStudent.xsId = ? ");
		}
		if(subjectId != null){
			values.add(subjectId);
		}
		return findByPager(page, hql.toString(), values);
	}
	
	
}
