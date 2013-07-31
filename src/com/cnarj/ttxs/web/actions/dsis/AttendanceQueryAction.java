package com.cnarj.ttxs.web.actions.dsis;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.ParentAccount;
import com.cnarj.ttxs.pojo.dsis.StudentBindingMobile;
import com.cnarj.ttxs.pojo.dsis.TClasses;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.dsis.TStugrade;
import com.cnarj.ttxs.service.ParentAccountService;
import com.cnarj.ttxs.service.StudentAttendanceRecordService;
import com.cnarj.ttxs.service.StudentBindingMobileService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.StugradeService;
import com.cnarj.ttxs.service.TClassesService;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 学生考勤查询控制类
 * @author hedan
 *
 */
public class AttendanceQueryAction extends PageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentAttendanceRecordService stuAttenRecordService;
	
	private ParentAccountService parentAccountService;
	
	private StudentService studentService;
	
	private StugradeService stugradeService;
	
	private TClassesService classService;
	
	private StudentBindingMobileService studentBindingMobileService;
	
//	private List<ParentAccount> listParentAccounts;
	
	private Long stuId;//学生id
	
	private String stuName;
	
	private int displayType;//显示类型，家长有多个孩子时displayType = 2;当家长只有一个孩子时 displayType = 1
	
	private List<TStudent> listStudents;
	
	private List<TClasses> listClasses;
	
	private String startDate;
	
	private String endDate;
	
	private Result studentAttenRecordPager;
	
	private List<TStugrade> listGrades;
	
	private Long gradeId;//年级id
	
	private String gradeName;
	
	private Long classId;//班级id
	
	private String className;//班级名称
	
	/**
	 * 学生会员查询本人考勤记录
	 * @return
	 */
	public String stuAttendancePager()throws Exception{
		try {
			if(startDate == null || "".equals(startDate)){
				startDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			if(endDate == null || "".equals(endDate)){
				endDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			Long xs_id = getDsisUserid();
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ATTENDANCE);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			studentAttenRecordPager = stuAttenRecordService.getAttendanceRecordPager(page, startDate, endDate, xs_id);
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return LIST;
	}
	
	
    /**
     * 学生家长查询孩子的考勤信息
     * @return
     * @throws Exception
     */
	public String parAttendancePager()throws Exception{
		try {
			String moblie = getSessionMemberUsername();//得到家长的账号 即手机号码
			List<StudentBindingMobile> lst_bindmobile = studentBindingMobileService.getList("mobile", moblie);
//			listParentAccounts = parentAccountService.getParengAccountList(moblie);
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
				
				if(startDate == null || "".equals(startDate)){
					startDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
				}
				if(endDate == null || "".equals(endDate)){
					endDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
				}
				// 设置每页显示的条数
				page.setEveryPage(CommStaticNum.PAGENUM_ATTENDANCE);
				// 根据statePage进行Page对象设置，并查询
				if (gotoPage == null || gotoPage.length() == 0) {
					gotoPage = "1";
				}
				page.setCurrentPage(Integer.parseInt(gotoPage));
				studentAttenRecordPager = stuAttenRecordService.getAttendanceRecordPager(page, startDate, endDate, stuId);
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "parList";
	}
	
	/**
	 * 教师查询学生考勤初始化
	 * @return
	 * @throws Exception
	 */
	public String teaAttendancePager()throws Exception{
		try {
			
			if(startDate == null || "".equals(startDate)){
				startDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			if(endDate == null || "".equals(endDate)){
				endDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			Long teacherId = getDsisUserid();//教师id
			listGrades = stugradeService.getGradeListByBind(teacherId);//查询用户对应绑定的年级
			if(gradeId == null){
				gradeId = listGrades.get(0).getNjId();//默认查询第一个年级
				gradeName = listGrades.get(0).getNjMcheng();
			}else{
				gradeName = stugradeService.get(gradeId).getNjMcheng();
			}
			//根据年级查询班级列表
			listClasses = classService.getClassesListByBindGrade(gradeId, teacherId);
			if(listClasses != null && listClasses.size() > 0){
				if(classId == null){
					classId = listClasses.get(0).getBjId();	//默认查询第一个班级
					className = listClasses.get(0).getBjMcheng();
				}else if(classId == -1){
					listStudents = null;
					className = null;
				}else{
					className = classService.get(classId).getBjMcheng();
					listStudents = studentService.getStudentListByClassId(getXxid(), classId);//根据班级id查询学生
				}
			}
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ATTENDANCE);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			if(classId != null && classId != -1 && startDate != null && endDate != null){
				if(stuId == null || stuId == 0 || stuId == -1){
					stuId = new Long(-1);//默认查询全班学生
					stuName = "全部";
					studentAttenRecordPager = stuAttenRecordService.getAttendanceRecordPageByClass(page, classId, startDate, endDate);
				}else{
					stuName = studentService.get(stuId).getXsXming();
					studentAttenRecordPager = stuAttenRecordService.getAttendanceRecordPager(page, startDate, endDate, stuId);
				}
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "teaList";
	}
	
	/**
	 * 根据年级查询班级
	 * @return
	 * @throws Exception
	 */
	public String ajaxClassByGrade()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			Long teacherId = getDsisUserid();//教师id
			listClasses = classService.getClassesListByBindGrade(gradeId, teacherId);
			StringBuffer optionStr = new StringBuffer("");
			if(listClasses != null && listClasses.size()>0){
				for(TClasses classes : listClasses){
					optionStr.append("<option value='"+classes.getBjId()+"'>"+classes.getBjMcheng()+"</option>");
				}
				optionStr.append(" <option value='-1' selected='selected'>--必选--</option>");
			}else{
				optionStr.append(" <option value='0'>没有班级</option>");
			}
			out.print(optionStr);
		} catch (Exception e) {
			out.print("error");
		}
		out.close();
		return null;
	}
	
	/**
	 * 根据班级查询学生
	 * @return
	 * @throws Exception
	 */
	public String ajaxStudentByClass()throws Exception{
		PrintWriter out  = null;
		try {
			out = getResponse().getWriter();
			listStudents= studentService.getStudentListByClassId(getXxid(), classId);
			StringBuffer l_optionStr = new StringBuffer("");
			if(listStudents != null && listStudents.size() > 0){
				for(TStudent student : listStudents){
					l_optionStr.append(" <option value='"+student.getXsId()+"'>"+student.getXsXming()+"</option> \r\n ");
				}
				out.print(l_optionStr);
				out.flush();
			}
		} catch (Exception e) {
			out.print("error");
		}
		out.close();
		return null;
	}
	
//	/**
//	 * 老师查询学生考勤信息
//	 * @return
//	 * @throws Exception
//	 */
//	public String teaAttendancePager()throws Exception{
//		try {
//			if(startDate == null || "".equals(startDate)){
//				startDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
//			}
//			if(endDate == null || "".equals(endDate)){
//				endDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
//			}
//			//page分页信息
//			// 设置每页显示的条数
//			page.setEveryPage(CommStaticNum.PAGENUM_ATTENDANCE);
//			// 根据statePage进行Page对象设置，并查询
//			if (gotoPage == null || gotoPage.length() == 0) {
//				gotoPage = "1";
//			}
//			page.setCurrentPage(Integer.parseInt(gotoPage));
////			studentAttenRecordPager = stuAttenRecordService.getAttendanceRecordPager(page, startDate, endDate, xs_id);
//			
//			
//		} catch (Exception e) {
//			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
//			return ERROR;
//		}
//		return "teaList";
//	}
	
	public String onchangeGradeByTea()throws Exception{
		try {
			Long teacherId = getDsisUserid();//教师id
			listGrades = stugradeService.getGradeListByBind(teacherId);//查询用户对应绑定的年级
			gradeName = stugradeService.get(gradeId).getNjMcheng();
			//根据年级查询班级列表
			listClasses = classService.getClassesListByBindGrade(gradeId, teacherId);
			if(listClasses != null && listClasses.size() > 0){
				classId = listClasses.get(0).getBjId();	//默认查询第一个班级
				className = listClasses.get(0).getBjMcheng();
				listStudents = studentService.getStudentListByClassId(getXxid(), classId);//根据班级id查询学生
			}
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ATTENDANCE);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			if(classId != null && classId != -1 && startDate != null && endDate != null){
				stuId = new Long(-1);//默认查询全班学生
				stuName = "全部";
				studentAttenRecordPager = stuAttenRecordService.getAttendanceRecordPageByClass(page, classId, startDate, endDate);
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "teaList";
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public StudentAttendanceRecordService getStuAttenRecordService() {
		return stuAttenRecordService;
	}

	public void setStuAttenRecordService(
			StudentAttendanceRecordService stuAttenRecordService) {
		this.stuAttenRecordService = stuAttenRecordService;
	}

	public Result getStudentAttenRecordPager() {
		return studentAttenRecordPager;
	}

	public void setStudentAttenRecordPager(Result studentAttenRecordPager) {
		this.studentAttenRecordPager = studentAttenRecordPager;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	public List<TStudent> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<TStudent> listStudents) {
		this.listStudents = listStudents;
	}

	public ParentAccountService getParentAccountService() {
		return parentAccountService;
	}

	public void setParentAccountService(ParentAccountService parentAccountService) {
		this.parentAccountService = parentAccountService;
	}

	public StugradeService getStugradeService() {
		return stugradeService;
	}

	public void setStugradeService(StugradeService stugradeService) {
		this.stugradeService = stugradeService;
	}

	public TClassesService getClassService() {
		return classService;
	}

	public void setClassService(TClassesService classService) {
		this.classService = classService;
	}

	public List<TClasses> getListClasses() {
		return listClasses;
	}

	public void setListClasses(List<TClasses> listClasses) {
		this.listClasses = listClasses;
	}

	public List<TStugrade> getListGrades() {
		return listGrades;
	}

	public void setListGrades(List<TStugrade> listGrades) {
		this.listGrades = listGrades;
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

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
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


	public StudentBindingMobileService getStudentBindingMobileService() {
		return studentBindingMobileService;
	}


	public void setStudentBindingMobileService(
			StudentBindingMobileService studentBindingMobileService) {
		this.studentBindingMobileService = studentBindingMobileService;
	}
    
	
	
}
