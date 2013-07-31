package com.cnarj.ttxs.service.imp.dsis;

import java.lang.reflect.Field;

import com.cnarj.ttxs.dao.ExamQueryDao;
import com.cnarj.ttxs.dao.ExamSubInfoDao;
import com.cnarj.ttxs.dao.StudentExamresultDao;
import com.cnarj.ttxs.dao.SubjectDao;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.ExamSubInfo;
import com.cnarj.ttxs.pojo.dsis.StudentExamresult;
import com.cnarj.ttxs.pojo.dsis.TExamination;
import com.cnarj.ttxs.pojo.dsis.TSubject;
import com.cnarj.ttxs.service.ExamQueryService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

public class ExamQueryServiceImpl extends BaseDsisServiceImpl<TExamination,Long> implements ExamQueryService{

	private ExamQueryDao examQueryDao;
	 
	private StudentExamresultDao studentExamresultDao;
   
	private ExamSubInfoDao examSubInfoDao;
	
	private SubjectDao subjectDao;
	

	public StringBuffer getExaminationByStu(Long njId, Long xs_id, Long examId)
			throws BusinessException {
		StudentExamresult stuExamresult = null;
		ExamSubInfo examSubinfo  = null;
		StringBuffer l_strbuff = null;
		try {
			stuExamresult = studentExamresultDao.get(examId, xs_id);//获得学生考试成绩对象
			examSubinfo = examSubInfoDao.get(njId, examId);//获得考试科目对象
			if(stuExamresult != null && examSubinfo != null){
				String l_substr = examSubinfo.getSubstr();//获得该次考试的科目字符串
				l_strbuff = new StringBuffer("");
				if(l_substr != null && !"".equals(l_substr)){
					String[] substrArr = l_substr.split(",");
					TSubject l_subject = null;
					l_strbuff.append("<tr>");
					//循环科目id字符串数组得到科目id
					for(String subId : substrArr){
						l_subject = subjectDao.get(Long.parseLong(subId));
						l_strbuff.append("<td class='t1'>"+l_subject.getSubjectName()+"</td>");
						
					}
					l_strbuff.append("<td class='t1'>班级排名</td>");
					l_strbuff.append("<td class='t1'>年级排名</td>");
					l_strbuff.append("</tr>");
					if(stuExamresult != null ){
						l_strbuff.append("<tr>");
						Field l_field = null;
						for(int i = 0; i < substrArr.length; i++){
							l_field = stuExamresult.getClass().getDeclaredField("cj"+(i+1));
							l_field.setAccessible(true);//破解私有成员变量 ，使其成为可访问的成员变量
							if(l_field.get(stuExamresult) != null ){
								l_strbuff.append("<td>"+l_field.get(stuExamresult)+"</td>");
							}else{
								l_strbuff.append("<td>没有录分</td>");
							}
							
						}
						l_field = stuExamresult.getClass().getDeclaredField("classRank");//班级排名
						l_field.setAccessible(true);//破解私有成员变量 ，使其成为可访问的成员变量
						if(l_field.get(stuExamresult) != null ){
							l_strbuff.append("<td>"+l_field.get(stuExamresult)+"</td>");
						}else{
							l_strbuff.append("<td>&nbsp;</td>");
						}
						l_field = stuExamresult.getClass().getDeclaredField("njRank");//年级排名
						l_field.setAccessible(true);//破解私有成员变量 ，使其成为可访问的成员变量
						if(l_field.get(stuExamresult) != null ){
							l_strbuff.append("<td>"+l_field.get(stuExamresult)+"</td>");
						}else{
							l_strbuff.append("<td>&nbsp;</td>");
						}
						l_strbuff.append("</tr>");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("出错，原因："+e.toString());
		}
		return l_strbuff;
	}

	
	
	public Result getExaminationByTea(Long classId, Long xs_id, Long subjectId)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public ExamQueryDao getExamQueryDao() {
		return examQueryDao;
	}

	public void setExamQueryDao(ExamQueryDao examQueryDao) {
		this.examQueryDao = examQueryDao;
		super.setBaseDao(examQueryDao);
	}


	public StudentExamresultDao getStudentExamresultDao() {
		return studentExamresultDao;
	}

	public void setStudentExamresultDao(StudentExamresultDao studentExamresultDao) {
		this.studentExamresultDao = studentExamresultDao;
	}

	public ExamSubInfoDao getExamSubInfoDao() {
		return examSubInfoDao;
	}

	public void setExamSubInfoDao(ExamSubInfoDao examSubInfoDao) {
		this.examSubInfoDao = examSubInfoDao;
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}



	
	
}
