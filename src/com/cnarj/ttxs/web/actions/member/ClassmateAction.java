package com.cnarj.ttxs.web.actions.member;


import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.dsis.TSchoolinfo;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.SchoolinfoService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.TClassesService;
import com.cnarj.ttxs.service.member.IActionRecService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 用户中心--同学录
 * @author hedan
 *
 */
public class ClassmateAction extends PageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8199907859521953618L;

	private TClassesService classService;
	
	private StudentService studentService;
	
	private SchoolinfoService schoolinfoService;
	
	private MemberService memberService;
	
	private IActionRecService actionRecService;
	
	private Long stuId;//学生id
	
	private TStudent student;
	
	private Long classId;//班级id
	
	private String gradeName;//年级名称
	
	private String className;//班级名称
	
	private String schoolName;//学校名称
	
	private List<ActionRec> listActionRecords;//空间动态
	
	
	public String list()throws Exception{
		try {
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_CLASSMATE);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			stuId = getDsisUserid();
			student = studentService.get(stuId); 
			if(student != null){
				classId = student.getTClasses().getBjId();
				className = student.getTClasses().getBjMcheng();
				gradeName = student.getTClasses().getTStugrade().getNjMcheng();
				result = studentService.getPager(page, classId);
			}
			TSchoolinfo school = schoolinfoService.get("xxid",getXxid());
			if(school != null){
				schoolName = school.getSchName();
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return LIST;
	}
	
	/**
	 * 他人空间
	 * @return
	 * @throws Exception
	 */
	public String otherspace()throws Exception{
		try {
			stuId = Long.valueOf(getParameter("dsisUserId"));
			Member l_member = memberService.getMember(stuId, getSessionMemberType());
			if(l_member != null){
				String memberId = l_member.getMemberid();
				listActionRecords = actionRecService.getList("member.memberid", memberId);//根基会员id获得会员动态
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return VIEW;
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

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
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

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public SchoolinfoService getSchoolinfoService() {
		return schoolinfoService;
	}

	public void setSchoolinfoService(SchoolinfoService schoolinfoService) {
		this.schoolinfoService = schoolinfoService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public IActionRecService getActionRecService() {
		return actionRecService;
	}

	public void setActionRecService(IActionRecService actionRecService) {
		this.actionRecService = actionRecService;
	}

	public List<ActionRec> getListActionRecords() {
		return listActionRecords;
	}

	public void setListActionRecords(List<ActionRec> listActionRecords) {
		this.listActionRecords = listActionRecords;
	}
	
	
}
