package com.cnarj.ttxs.web.actions.dsis;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.dsis.ParentAccount;
import com.cnarj.ttxs.pojo.dsis.StudentBindingMobile;
import com.cnarj.ttxs.pojo.dsis.TClasses;
import com.cnarj.ttxs.pojo.dsis.TCourses;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.dsis.TStugrade;
import com.cnarj.ttxs.service.ParentAccountService;
import com.cnarj.ttxs.service.StudentBindingMobileService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.StugradeService;
import com.cnarj.ttxs.service.TClassesService;
import com.cnarj.ttxs.service.TCoursesService;
import com.cnarj.ttxs.web.actions.base.BaseAction;

/**
 * 课程表控制类
 * @author hedan
 *
 */
public class TCoursesAction extends BaseAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2175602173813645970L;

	private TCoursesService coursesService;
	
	private StugradeService stugradeService;
	
	private TClassesService classesService;
	
	private ParentAccountService parentAccountService;
	
	private StudentService studentService;
	
	private List<TStugrade> listGrades;//年级列表
	
	private List<TClasses> listClasses;//班级列表
	
	private List<TCourses> listCourses;
	
	private List<TStudent> listStudents;
	
	private StudentBindingMobileService studentBindingMobileService;
//	private List<ParentAccount> listParentAccounts;
	
	private Long classId;
	
	private String className;
	
	private Long gradeId;
	
	private String gradeName;
	
	private Long stuId;//学生id
	
	private int displayType;//显示类型，家长有多个孩子时displayType = 2;当家长只有一个孩子时 displayType = 1
	
	
	
	/**
	 * 学生查询课程表信息
	 * @return
	 */
	public String getCoursesByStu(){
		try {
			Long xs_id = getDsisUserid();//获得学生id
			listGrades = stugradeService.getList(xs_id);
			listClasses = classesService.getList(xs_id);
			if(listClasses != null && listClasses.size() > 0){
				classId = listClasses.get(0).getBjId();
				listCourses = coursesService.getList(classId);
				setAttribute("className", listClasses.get(0).getBjMcheng());
			}
			if(listGrades != null && listGrades.size() > 0){
				setAttribute("gradeName", listGrades.get(0).getNjMcheng());
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return LIST;
	}
	
	/**
	 * 家长查询孩子的课程表
	 * @return
	 * @throws Exception
	 */
	public String getCourseByPar()throws Exception{
		try {
			String moblie = getSessionMemberUsername();//得到家长的账号 即手机号码
			List<StudentBindingMobile> lst_bindmobile = studentBindingMobileService.getList("mobile", moblie);
			if(lst_bindmobile != null && lst_bindmobile.size() > 0){
				int size = lst_bindmobile.size();
				//如果size=1，则表明该手机绑定了一个的学生
				if(size == 1){
					displayType = 1;
					
				}else if(size > 1 ){//如果size>1，则表明该手机绑定了两个或以上的学生
					displayType = 2;
					listStudents = new ArrayList<TStudent>();
					//循环手机号码绑定列表
					for(StudentBindingMobile bingMobile : lst_bindmobile){
						listStudents.add(bingMobile.getTStudent());
					}
				}
				//如果stuId等于null，则是第一次进行查询，默认查询第一个学生
				if(stuId == null ){
					stuId = lst_bindmobile.get(0).getTStudent().getXsId();
				}
				listGrades = stugradeService.getList(stuId);
				listClasses = classesService.getList(stuId);
				if(listClasses != null && listClasses.size() > 0){
					classId = listClasses.get(0).getBjId();
					listCourses = coursesService.getList(classId);
					setAttribute("className", listClasses.get(0).getBjMcheng());
				}
				if(listGrades != null && listGrades.size() > 0){
					setAttribute("gradeName", listGrades.get(0).getNjMcheng());
				}
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "parList";
	}

	/**
	 * 老师查询班级的课程表
	 * @return
	 * @throws Exception
	 */
	public String getCourseByTea()throws Exception{
		try {
			Long teacherId = getDsisUserid();//教师id
			listGrades = stugradeService.getGradeListByBind(teacherId);//查询用户对应绑定的年级
			if(gradeId == null){
				gradeId = listGrades.get(0).getNjId();//默认查询第一个年级
				gradeName = listGrades.get(0).getNjMcheng();
			}else{
				gradeName = stugradeService.get(gradeId).getNjMcheng();
			}
			//根据年级查询班级列表
			listClasses = classesService.getClassesListByBindGrade(gradeId, teacherId);
			if(listClasses != null && listClasses.size() > 0){
				if(classId == null){
					classId = listClasses.get(0).getBjId();	//默认查询第一个班级
					className = listClasses.get(0).getBjMcheng();
				}else{
					className = classesService.get(classId).getBjMcheng();
				}
				listCourses = coursesService.getList(classId);
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "teaList";
	}
	
	/**
	 * 年级下拉触发事件
	 * @return
	 * @throws Exception
	 */
	public String onchageGradeBytea()throws Exception{
		try {
			Long teacherId = getDsisUserid();//教师id
			listGrades = stugradeService.getGradeListByBind(teacherId);//查询用户对应绑定的年级
			gradeName = stugradeService.get(gradeId).getNjMcheng();
			//根据年级查询班级列表
			listClasses = classesService.getClassesListByBindGrade(gradeId, teacherId);
			if(listClasses != null && listClasses.size() > 0){
				classId = listClasses.get(0).getBjId();	//默认查询第一个班级
				className = listClasses.get(0).getBjMcheng();
				listCourses = coursesService.getList(classId);
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "teaList";
	}
	
	public TCoursesService getCoursesService() {
		return coursesService;
	}

	public void setCoursesService(TCoursesService coursesService) {
		this.coursesService = coursesService;
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

	public StugradeService getStugradeService() {
		return stugradeService;
	}

	public void setStugradeService(StugradeService stugradeService) {
		this.stugradeService = stugradeService;
	}

	public TClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(TClassesService classesService) {
		this.classesService = classesService;
	}

	public List<TCourses> getListCourses() {
		return listCourses;
	}

	public void setListCourses(List<TCourses> listCourses) {
		this.listCourses = listCourses;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	public ParentAccountService getParentAccountService() {
		return parentAccountService;
	}

	public void setParentAccountService(ParentAccountService parentAccountService) {
		this.parentAccountService = parentAccountService;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public StudentBindingMobileService getStudentBindingMobileService() {
		return studentBindingMobileService;
	}

	public void setStudentBindingMobileService(
			StudentBindingMobileService studentBindingMobileService) {
		this.studentBindingMobileService = studentBindingMobileService;
	}
	
	
	
}
