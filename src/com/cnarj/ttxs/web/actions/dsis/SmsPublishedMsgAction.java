package com.cnarj.ttxs.web.actions.dsis;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.dsis.TClasses;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.dsis.TStugrade;
import com.cnarj.ttxs.service.SmsPublishedMsgService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.StugradeService;
import com.cnarj.ttxs.service.TClassesService;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 
 * @author Administrator
 *
 */
public class SmsPublishedMsgAction extends PageAction{

	
	private static final long serialVersionUID = 1L;
	
	private SmsPublishedMsgService smsPublishedMsgService;
	
	private StugradeService stugradeService;
	
	private TClassesService classService;
	
	private StudentService studentService;
	
	private String startDate;
	
	private String endDate;
	
    private List<TStugrade> listGrades;
    
    private List<TClasses> listClasses;
    
    private List<TStudent> listStudents;
	
	private Long gradeId;//年级id
	
	private String gradeName;
	
	private Long classId;//班级id
	
	private String className;//班级名称
	
	private Long stuId;//学生id
	
	private String stuName;

	/**
	 * 学生查询短息记录
	 * @return
	 * @throws Exception
	 */
	public String stuQuery()throws Exception{
		String l_startDate = getParameter("startDate");
		String l_endDate = getParameter("endDate");
		try {
			if(l_startDate == null || "".equals(l_startDate)){
				startDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			if(l_endDate == null || "".equals(l_endDate)){
				endDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			Long l_xsid = getDsisUserid();
			page.setEveryPage(CommStaticNum.PAGENUM_SMS);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			result = smsPublishedMsgService.getSmsMsgPage(l_xsid, startDate, endDate, page);
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "stuSmsList";
	}

	/**
	 * 家长查询短信记录
	 * @return
	 * @throws Exception
	 */
	public String parQuery()throws Exception{
		String l_startDate = getParameter("startDate");
		String l_endDate = getParameter("endDate");
		try {
			if(l_startDate == null || "".equals(l_startDate)){
				startDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			if(l_endDate == null || "".equals(l_endDate)){
				endDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			String moblie = getSessionMemberUsername();//得到家长的账号 即手机号码
			page.setEveryPage(CommStaticNum.PAGENUM_SMS);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			result = smsPublishedMsgService.getSmsMsgPage(moblie, startDate, endDate, page);
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "parentSmsList";
	}

	/**
	 * 老师查询短信记录
	 * @return
	 * @throws Exception
	 */
	public String teaQuery()throws Exception{
		String l_startDate = getParameter("startDate");
		String l_endDate = getParameter("endDate");
		try {
			if(l_startDate == null || "".equals(l_startDate)){
				startDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			if(l_endDate == null || "".equals(l_endDate)){
				endDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			}
			Long teacherId = getDsisUserid();//教师id
			listGrades = stugradeService.getGradeListByBind(teacherId);//查询用户对应绑定的年级
			if(gradeId != null){
				gradeName = stugradeService.get(gradeId).getNjMcheng();
				//根据年级查询班级列表
				listClasses = classService.getClassesListByBindGrade(gradeId, teacherId);
			}
			if(listClasses != null && listClasses.size() > 0){
				if(classId == null){
				}else if(classId == -1){
					listStudents = null;
					className = null;
				}else{
					className = classService.get(classId).getBjMcheng();
					listStudents = studentService.getStudentListByClassId(getXxid(), classId);//根据班级id查询学生
				}
			}
			page.setEveryPage(CommStaticNum.PAGENUM_SMS);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			if(classId != null && classId != -1 && startDate != null && endDate != null){
				if(stuId == null || stuId == 0 || stuId == -1){
					stuId = new Long(-1);//默认查询全班学生
					stuName = "全部";
					result = smsPublishedMsgService.getSmsMsgPage(page, startDate, endDate, classId);
				}else{
					stuName = studentService.get(stuId).getXsXming();
					result = smsPublishedMsgService.getSmsMsgPage(stuId, startDate, endDate, page);
				}
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "teaSmsList";
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
				l_optionStr.append("<option value='0' selected='selected'>--可选--</option>");
				out.print(l_optionStr);
				out.flush();
			}
		} catch (Exception e) {
			out.print("error");
		}
		out.close();
		return null;
	}

	public SmsPublishedMsgService getSmsPublishedMsgService() {
		return smsPublishedMsgService;
	}

	public void setSmsPublishedMsgService(
			SmsPublishedMsgService smsPublishedMsgService) {
		this.smsPublishedMsgService = smsPublishedMsgService;
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

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public TClassesService getClassService() {
		return classService;
	}

	public void setClassService(TClassesService classService) {
		this.classService = classService;
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

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	
}
