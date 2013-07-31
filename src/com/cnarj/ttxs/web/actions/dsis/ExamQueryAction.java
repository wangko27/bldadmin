package com.cnarj.ttxs.web.actions.dsis;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.ParentAccount;
import com.cnarj.ttxs.pojo.dsis.StudentBindingMobile;
import com.cnarj.ttxs.pojo.dsis.StudentExamresult;
import com.cnarj.ttxs.pojo.dsis.TClasses;
import com.cnarj.ttxs.pojo.dsis.TExamination;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.dsis.TStugrade;
import com.cnarj.ttxs.pojo.dsis.TSubject;
import com.cnarj.ttxs.pojo.dsis.TTermSet;
import com.cnarj.ttxs.service.ExamQueryService;
import com.cnarj.ttxs.service.ExaminationService;
import com.cnarj.ttxs.service.ParentAccountService;
import com.cnarj.ttxs.service.StudentBindingMobileService;
import com.cnarj.ttxs.service.StudentExamresultService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.StugradeService;
import com.cnarj.ttxs.service.SubjectService;
import com.cnarj.ttxs.service.TClassesService;
import com.cnarj.ttxs.service.TermSetService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 成绩查询控制类
 * @author Administrator
 *
 */
public class ExamQueryAction extends PageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4712956045228267364L;
	
	private TermSetService termSetService;
	
	private ExaminationService examinationService;
	
	private ExamQueryService examQueryService;
	
	private StugradeService stugradeService;
	
	private TClassesService classService;
	
	private ParentAccountService parentAccountService;
	
	private StudentBindingMobileService studentBindingMobileService;
	
	private StudentExamresultService stuExamresultService;
	
	private StudentService studentService;
	
	private SubjectService subjectService;
	
	private List<TTermSet> listTermsets;
	
	private List<TExamination> listExaminations;
	
//	private List<ParentAccount> listParentAccounts;
	
	private Long termId;//学期id
	
	private String examDate;
	
	private String examDateId;
	
	private Long examId;
	
	private String examName;//考试名称
	 
	private String termName;//学期名称
	
	private Long stuId;//学生id
	
	private int displayType;//显示类型，家长有多个孩子时displayType = 2;当家长只有一个孩子时 displayType = 1
	
	private List<TStudent> listStudents;
	
	private List<TStugrade> listGrades;
	
	private List<TClasses> listClasses;
	
	private List<TSubject> listSubjects;
 	
	private Long gradeId;//年级id
	
	private String gradeName;
	
	private Long classId;//班级id
	
	private String className;
	
	private Long subjectId;//科目id
	
	private String subjectName;
	
	private StudentExamresult studentExamresult;
	
	
	/**
	 * 学生会员成绩查询
	 * @return
	 * @throws Exception
	 */
	public String stuExamList()throws Exception{
		try {
			listTermsets = termSetService.getTermListByXxid(getXxid());//查询该学校的学期列表
			if(listTermsets != null && listTermsets.size() > 0){
				termId = listTermsets.get(0).getTermId();
				termName =  listTermsets.get(0).getTermName();
				listExaminations = examinationService.getListByTerm(termId, "-1");//查询所有月份的烤次成绩
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return LIST;
	}
	
	/**
	 * 学生家长查询孩子的成绩
	 * @return
	 * @throws Exception
	 */
	public String parExamList()throws Exception{
		try {
			String moblie = getSessionMemberUsername();//得到家长的账号 即手机号码
			List<StudentBindingMobile> lst_bindmobile = studentBindingMobileService.getList("mobile", moblie);
//			listParentAccounts = parentAccountService.getParengAccountList(moblie);
			if(lst_bindmobile != null && lst_bindmobile.size() > 0){
				String l_xxid = null;
				int size = lst_bindmobile.size();
				//如果size=1，则表明该手机绑定了一个的学生
				if(size == 1){
					displayType = 1;
					l_xxid = lst_bindmobile.get(0).getTStudent().getXxid();//学校id
					stuId = lst_bindmobile.get(0).getTStudent().getXsId();
					listTermsets = termSetService.getTermListByXxid(l_xxid);//查询该家长孩子所在学校的学期列表
					if(listTermsets != null && listTermsets.size() > 0){
						termId = listTermsets.get(0).getTermId();
						termName =  listTermsets.get(0).getTermName();
						listExaminations = examinationService.getListByTerm(termId, "-1");//查询所有月份的烤次成绩
					}
				}else if(size > 1 ){//如果size>1，则表明该手机绑定了两个或以上的学生
					displayType = 2;
					listStudents = new ArrayList<TStudent>();
					//循环手机号码绑定列表
					for(StudentBindingMobile bingMobile : lst_bindmobile){
						listStudents.add(bingMobile.getTStudent());
					}
					//默认查询第一个孩子所在学校的学期信息
					l_xxid = lst_bindmobile.get(0).getTStudent().getXxid();//学校id
					stuId = lst_bindmobile.get(0).getTStudent().getXsId();
					listTermsets = termSetService.getTermListByXxid(l_xxid);//查询该家长孩子所在学校的学期列表
					if(listTermsets != null && listTermsets.size() > 0){
						termId = listTermsets.get(0).getTermId();
						termName =  listTermsets.get(0).getTermName();
						listExaminations = examinationService.getListByTerm(termId, "-1");//查询所有月份的烤次成绩
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "parList";
	}
	
	
	/**
	 * 教师查询班级学生成绩
	 * @return
	 * @throws Exception
	 */
	public String teaExamList()throws Exception{
		try {
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_EXAM);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			result = new Result();
			listTermsets = termSetService.getTermListByXxid(getXxid());//查询该学校的学期列表
			if(listTermsets != null && listTermsets.size() > 0){
				if(termId ==  null){//第一次默认查询
					termId = listTermsets.get(0).getTermId();  //默认查询第一个学期
					termName =  listTermsets.get(0).getTermName();
				}else{
					termName = termSetService.get(termId).getTermName();
				}
			}
			Long teacherId = getDsisUserid();//教师id
			listGrades = stugradeService.getGradeListByBind(teacherId);//查询用户对应绑定的年级
			if(listGrades != null && listGrades.size()>0){
				if(gradeId == null){
					gradeId = listGrades.get(0).getNjId();//默认查询第一个年级
					gradeName = listGrades.get(0).getNjMcheng();
				}else{
					gradeName = stugradeService.get(gradeId) == null ? null :stugradeService.get(gradeId).getNjMcheng();
				}
				//根据年级查询班级列表
				listClasses = classService.getClassesListByBindGrade(gradeId, teacherId);
				if(listClasses != null && listClasses.size() > 0){
					if(classId == null){
						classId = listClasses.get(0).getBjId();	//默认查询第一个班级
						className = listClasses.get(0).getBjMcheng();
					}else{
						className = classService.get(classId) ==  null ? null : classService.get(classId).getBjMcheng();
					}
					listStudents = studentService.getStudentListByClassId(getXxid(), classId);//根据班级id查询学生
					
				}
			}
			if(stuId == null || stuId == -1 ){
				stuId = null;
			}
			if(classId != null && termId != null && gradeId != null){
				listExaminations = examinationService.getListByClassAndTerm(classId+"", termId);//根据班级id和学期id查询考次信息
				if(listExaminations != null && listExaminations.size() > 0){
					if(examId == null ){
						examId = listExaminations.get(0).getExamId();
						examName  = listExaminations.get(0).getExamName();
					}else{
						examName = examinationService.get(examId).getExamName();
					}
					listSubjects = subjectService.getListByExamId(gradeId, examId);
					result = stuExamresultService.getStuExamresultPager(page, classId, examId, stuId, null);
				}
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "teaList";
	}
	
	/**
	 * ajax更改年级下拉列表得到班级列表
	 * @return
	 * @throws Exception
	 */
	public String ajaxClassByGrade()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			Long teacherId = getDsisUserid();//教师id
			//根据年级查询班级列表
			listClasses = classService.getClassesListByBindGrade(gradeId, teacherId);
			StringBuffer sb = new StringBuffer("");
			sb.append("<option value='0'>--必选--</option>");
			if(listClasses != null && listClasses.size() > 0){
				for(TClasses classes : listClasses){
					sb.append("<option value='"+classes.getBjId()+"'>"+classes.getBjMcheng()+"</option>");
				}
			}
			out.print(sb);
			out.flush();
		} catch (Exception e) {
			out.print(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME);
		}
		out.close();
		return null;
	}
	
	/**
	 * ajax更改班级下拉列表得到学生 和 考次信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String ajaxStuAndExamByClass()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			StringBuffer sb1 = new StringBuffer("");
			sb1.append("<option value='-1'>--全部--</option>");
			listStudents = studentService.getStudentListByClassId(getXxid(), classId);//根据班级id查询学生
			if(listStudents != null && listStudents.size()>0){
				for(TStudent student : listStudents){
					sb1.append("<option value='"+student.getXsId()+"'>"+student.getXsXming()+"</option>");
				}
			}
			StringBuffer sb2 = new StringBuffer("");
			sb2.append("<option value='0'>--请选择--</option>");
			listExaminations = examinationService.getListByClassAndTerm(classId+"", termId);//根据班级id和学期id查询考次信息
			if(listExaminations != null && listExaminations.size() > 0){
				for(TExamination exam : listExaminations){
					sb2.append("<option value='"+exam.getExamId()+"'>"+exam.getExamName()+"</option>");
				}
			} 
			Map map = new HashMap();
			map.put("stuList", sb1.toString());
			map.put("examList", sb2.toString());
			JSONObject jsonobj = JSONObject.fromObject(map);
			out.print(jsonobj);
			out.flush();
		} catch (Exception e) {
			out.print(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME);
		}
		out.close();
		return null;
	}
	
	/**
	 * 根据学期和班级得到考次
	 * @return
	 * @throws Exception
	 */
	public String ajaxExamByTerm()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			StringBuffer sb = new StringBuffer("");
			sb.append("<option value='0'>--请选择--</option>");
			listExaminations = examinationService.getListByClassAndTerm(classId+"", termId);//根据班级id和学期id查询考次信息
			if(listExaminations != null && listExaminations.size() > 0){
				for(TExamination exam : listExaminations){
					sb.append("<option value='"+exam.getExamId()+"'>"+exam.getExamName()+"</option>");
				}
			}
			out.print(sb);
			out.flush();
		} catch (Exception e) {
			out.print(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME);
		}
		out.close();
		return null;
	}
	
	/**
	 * 根据考次得到该考次的科目列表
	 * @return
	 * @throws Exception
	 */
	public String ajaxSubjectByExam()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			StringBuffer sb = new StringBuffer("");
			sb.append(" <option value='-1'>全部科目</option>");
			listSubjects = subjectService.getListByExamId(gradeId, examId);
			if(listSubjects != null && listSubjects.size() > 0){
				for(TSubject subject : listSubjects){
					sb.append("<option value='"+subject.getSubjectId()+"'>"+subject.getSubjectName()+"</option>");
				}
			}
			out.print(sb);
			out.flush();
		} catch (Exception e) {
			out.print(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME);
		}
		out.close();
		return null;
	}
	
	public String onchangeExamByTeacher()throws Exception{
		try {
			listTermsets = termSetService.getTermListByXxid(getXxid());//查询该学校的学期列表
			Long teacherId = getDsisUserid();//教师id
			listGrades = stugradeService.getGradeListByBind(teacherId);//查询用户对应绑定的年级
			if(listGrades != null && listGrades.size()>0){
				//根据年级查询班级列表
				listClasses = classService.getClassesListByBindGrade(gradeId, teacherId);
				if(listClasses != null && listClasses.size() > 0){
					listStudents = studentService.getStudentListByClassId(getXxid(), classId);//根据班级id查询学生
					listExaminations = examinationService.getListByClassAndTerm(classId+"", termId);//根据班级id和学期id查询考次信息
					if(listExaminations != null && listExaminations.size()>0){
						if(examId != null && examId != 0){
							listSubjects = subjectService.getListByExamId(gradeId, examId);
							result = stuExamresultService.getStuExamresultPager(page, classId, examId, stuId, null);
						}else{
							listSubjects = null;
						}
					}else{
						listSubjects = null;
					}
				}
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "teaList";
	}
	
	/**
	 * 根据学生所在学校来获得考次信息
	 * @return
	 * @throws Exception
	 */
	public String getExamListChangeStuId()throws Exception{
		try {
			String moblie = getSessionMemberUsername();//得到家长的账号 即手机号码
			List<StudentBindingMobile> lst_bindmobile = studentBindingMobileService.getList("mobile", moblie);
//			listParentAccounts = parentAccountService.getParengAccountList(moblie);
			if(lst_bindmobile != null && lst_bindmobile.size() > 0){
				displayType = 2;
				listStudents = new ArrayList<TStudent>();
				//循环家长账户
				for(StudentBindingMobile bingMobile : lst_bindmobile){
					listStudents.add(bingMobile.getTStudent());
				}
			}
			TStudent l_stu = studentService.get(stuId);
			if(l_stu != null){
				listTermsets = termSetService.getTermListByXxid(l_stu.getXxid());//查询该学校的学期列表
				if(listTermsets != null && listTermsets.size() > 0){
					termId = listTermsets.get(0).getTermId();
					termName =  listTermsets.get(0).getTermName();
					listExaminations = examinationService.getListByTerm(termId, "-1");//查询所有月份的烤次成绩
				}
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "parList";
	}
	
	/**
	 * 根据学期查询考试成绩
	 * @return
	 */
	public String ajaxExaminationByTerm(){
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			listExaminations = examinationService.getListByTerm(termId, examDate);//根据学期id和月份查询考次
			StringBuffer sb = new StringBuffer("");
			sb.append("<option value='0'>--请选择--</option>");
			if(listExaminations != null && listExaminations.size() > 0){
				for(TExamination examination : listExaminations){
					sb.append("<option value='"+examination.getExamId()+"'>"+examination.getExamName()+"</option>");
				}
			}
			out.print(sb);
			out.flush();
		} catch (Exception e) {
			out.print(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME);
		}
		out.close();
		return null;
	}
	
	/**
	 * 获得单个学生成绩信息
	 * @return
	 * @throws Exception
	 */
	public String getStuExamination()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			Long xs_id = getDsisUserid();//从session中获得学生id
			Long njId = stugradeService.getStugrade(xs_id);
			StringBuffer result = null;
			if(njId != null ){
				StringBuffer sb = new StringBuffer("");
				sb.append("<h1><span>查询结果：</span>(");
				if(termName != null && !"".equals(termName)){
					sb.append(termName);
				}
				if(examDateId != null && !"-1".equals(examDateId)){
					sb.append(" ").append(examDate).append("份");
				}
				if(examName != null && !"".equals(examName)){
					sb.append(" + ").append(examName);
				}
				sb.append(")</h1>");
				sb.append("<table width='720' border='0' cellspacing='0' cellpadding='0'>");
					result = examQueryService.getExaminationByStu(njId, xs_id, examId);
					if(result != null && !"".equals(result)){
						sb.append(result);
					}else{
						sb.append("<tr><td colspan='12' align='center'>没有数据</td></tr>");
					}
				
				sb.append("</table>");
				out.print(sb);
				out.flush();
			}
		} catch (Exception e) {
			out.print(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME);
			out.close();
		}
		out.close();
		return null;
	}
	
	//家长查询孩子的成绩信息
	public String getStuExamByParent()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			Long njId = stugradeService.getStugrade(stuId);
			StringBuffer result = null;
			if(njId != null ){
				StringBuffer sb = new StringBuffer("");
				sb.append("<h1><span>查询结果：</span>(");
				if(termName != null && !"".equals(termName)){
					sb.append(termName);
				}
				if(examDateId != null && !"-1".equals(examDateId)){
					sb.append(" ").append(examDate).append("份");
				}
				if(examName != null && !"".equals(examName)){
					sb.append(" + ").append(examName);
				}
				sb.append(")</h1>");
				sb.append("<table width='720' border='0' cellspacing='0' cellpadding='0'>");
					result = examQueryService.getExaminationByStu(njId, stuId, examId);
					if(result != null && !"".equals(result)){
						sb.append(result);
					}else{
						sb.append("<tr><td colspan='12' align='center'>没有数据</td></tr>");
					}
				
				sb.append("</table>");
				out.print(sb);
				out.flush();
			}
		} catch (Exception e) {
			out.print(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME);
			out.close();
		}
		out.close();
		return null;
	}


	/**
	 * 查询考试详细信息
	 * @return
	 * @throws Exception
	 */
	public String getExaminationDetail()throws Exception{
		try {
			studentExamresult = stuExamresultService.getExamDetail(Long.parseLong(getParameter("exam_id")));
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "examDetail";
	}

	public TermSetService getTermSetService() {
		return termSetService;
	}

	public void setTermSetService(TermSetService termSetService) {
		this.termSetService = termSetService;
	}

	public ExaminationService getExaminationService() {
		return examinationService;
	}

	public void setExaminationService(ExaminationService examinationService) {
		this.examinationService = examinationService;
	}


	public List<TExamination> getListExaminations() {
		return listExaminations;
	}

	public void setListExaminations(List<TExamination> listExaminations) {
		this.listExaminations = listExaminations;
	}

	public List<TTermSet> getListTermsets() {
		return listTermsets;
	}

	public void setListTermsets(List<TTermSet> listTermsets) {
		this.listTermsets = listTermsets;
	}

	public Long getTermId() {
		return termId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public ExamQueryService getExamQueryService() {
		return examQueryService;
	}

	public void setExamQueryService(ExamQueryService examQueryService) {
		this.examQueryService = examQueryService;
	}

	public StugradeService getStugradeService() {
		return stugradeService;
	}

	public void setStugradeService(StugradeService stugradeService) {
		this.stugradeService = stugradeService;
	}

	public String getExamDateId() {
		return examDateId;
	}

	public void setExamDateId(String examDateId) {
		this.examDateId = examDateId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public ParentAccountService getParentAccountService() {
		return parentAccountService;
	}

	public void setParentAccountService(ParentAccountService parentAccountService) {
		this.parentAccountService = parentAccountService;
	}

//	public List<ParentAccount> getListParentAccounts() {
//		return listParentAccounts;
//	}
//
//	public void setListParentAccounts(List<ParentAccount> listParentAccounts) {
//		this.listParentAccounts = listParentAccounts;
//	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public int getDisplayType() {
		return displayType;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<TStudent> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<TStudent> listStudents) {
		this.listStudents = listStudents;
	}

	public TClassesService getClassService() {
		return classService;
	}

	public void setClassService(TClassesService classService) {
		this.classService = classService;
	}

	public List<TStugrade> getListGrades() {
		return listGrades;
	}

	public void setListGrades(List<TStugrade> listGrades) {
		this.listGrades = listGrades;
	}

	public List<TClasses> getListClasses() {
		return listClasses;
	}

	public void setListClasses(List<TClasses> listClasses) {
		this.listClasses = listClasses;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}


	public StudentExamresultService getStuExamresultService() {
		return stuExamresultService;
	}

	public void setStuExamresultService(
			StudentExamresultService stuExamresultService) {
		this.stuExamresultService = stuExamresultService;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public List<TSubject> getListSubjects() {
		return listSubjects;
	}

	public void setListSubjects(List<TSubject> listSubjects) {
		this.listSubjects = listSubjects;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public StudentExamresult getStudentExamresult() {
		return studentExamresult;
	}

	public void setStudentExamresult(StudentExamresult studentExamresult) {
		this.studentExamresult = studentExamresult;
	}

	public StudentBindingMobileService getStudentBindingMobileService() {
		return studentBindingMobileService;
	}

	public void setStudentBindingMobileService(
			StudentBindingMobileService studentBindingMobileService) {
		this.studentBindingMobileService = studentBindingMobileService;
	}
	
	
	
}
