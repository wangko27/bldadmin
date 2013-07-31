package com.cnarj.ttxs.service.imp.dsis;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.ExamSubInfoDao;
import com.cnarj.ttxs.dao.StudentExamresultDao;
import com.cnarj.ttxs.dao.SubjectDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.ExamSubInfo;
import com.cnarj.ttxs.pojo.dsis.ExaminationSubjectBean;
import com.cnarj.ttxs.pojo.dsis.StudentExamresult;
import com.cnarj.ttxs.pojo.dsis.TSubject;
import com.cnarj.ttxs.service.StudentExamresultService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学生成绩业务处理实现类
 * @author hedan
 *
 */
public class StudentExamresultServiceImpl extends BaseDsisServiceImpl<StudentExamresult, Long> implements StudentExamresultService{

	private StudentExamresultDao studentExamresultDao;
	
	private SubjectDao subjectDao;
	
	private ExamSubInfoDao examSubInfoDao;

	public StudentExamresultDao getStudentExamresultDao() {
		return studentExamresultDao;
	}

	public void setStudentExamresultDao(StudentExamresultDao studentExamresultDao) {
		this.studentExamresultDao = studentExamresultDao;
		super.setBaseDao(studentExamresultDao);
	}
	
	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public ExamSubInfoDao getExamSubInfoDao() {
		return examSubInfoDao;
	}

	public void setExamSubInfoDao(ExamSubInfoDao examSubInfoDao) {
		this.examSubInfoDao = examSubInfoDao;
	}

	public Result getStuExamresultPager(Page page, Long classId, Long examId, Long xs_id, 
			Long subjectId) throws BusinessException {
		return studentExamresultDao.getStuExamresultPager(page, classId, examId, xs_id, subjectId);
	}
	
	public StudentExamresult getExamDetail(Long examId)throws BusinessException{
		try {
			StudentExamresult stuExamresult = studentExamresultDao.get(examId);
	//		List<TSubject> lstSubject = subjectDao.getListByExamId(exam.getTStugrade().getNjId(), exam.getTExamination().getExamId());
			ExamSubInfo examSubinfo  = examSubInfoDao.get(stuExamresult.getTStugrade().getNjId(), stuExamresult.getTExamination().getExamId());//获得考试科目对象;
			List<ExaminationSubjectBean> listExamSubject = new ArrayList<ExaminationSubjectBean>();
			if(stuExamresult != null && examSubinfo != null){
				String l_subjectstr = examSubinfo.getSubstr();//获得该次考试的科目字符串
				if(l_subjectstr != null && !"".equals(l_subjectstr)){
					ExaminationSubjectBean examSubjectBean = null;
					TSubject l_subject = null;
					String[] strArr = l_subjectstr.split(",");
					if(strArr != null && strArr.length > 0){
						int size = strArr.length;
						Field l_cjField = null;
						Long score = null;
						for(int i=0; i < size ; i++){
							examSubjectBean = new ExaminationSubjectBean();
							l_subject = subjectDao.get(Long.parseLong(strArr[i]));
							examSubjectBean.setSubject(l_subject);
							l_cjField = stuExamresult.getClass().getDeclaredField("cj"+(i+1));
							l_cjField.setAccessible(true);//破解私有成员变量 ，使其成为可访问的成员变量
							score = l_cjField.get(stuExamresult) == null ? new Long(0) : Float.valueOf(l_cjField.get(stuExamresult)+"").longValue();
							examSubjectBean.setScore(score);
							listExamSubject.add(examSubjectBean);
						}
					}
					
				}
				stuExamresult.setListExamSubject(listExamSubject);
			}
			return stuExamresult;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("出错，原因："+e.toString());
		}
	}
	
}
