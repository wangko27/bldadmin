package com.cnarj.ttxs.web.actions.member;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.msg.MimiInfo;
import com.cnarj.ttxs.pojo.msg.RemimiInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.member.MimiInfoService;
import com.cnarj.ttxs.service.member.RemimiInfoService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 秘密空间
 * @author hedan
 *
 */
public class SecretZoneAction extends PageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1837865529066943554L;
	
	
	private MemberService memberService;
	private MimiInfoService mimiInfoService;
	private RemimiInfoService remimiInfoService;
	private StudentService studentService;
	private Long stuId;//学生id
	
	private TStudent student;
	private Long classId;//班级id
	private String className;//班级名称
	private Long totalcount;
	
	public String list()throws Exception{
		try {
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_SECRET);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			stuId = getDsisUserid();
			student = studentService.get(stuId); //得到学生对象
			if(student != null){
				classId = student.getTClasses().getBjId();
				className = student.getTClasses().getBjMcheng();
				result = mimiInfoService.getPager(page,classId);
				totalcount = mimiInfoService.getTotalCount("classid", classId);
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 发表留言
	 * @return
	 * @throws Exception
	 */
	public String leavemessage()throws Exception{
		try {
			
			String msgcontent = getParameter("msgcontent");
			if(msgcontent == "" || msgcontent == null){
				return ajaxJsonErrorMessage("请输入留言内容！");
			}else{
				if(classId == null ){stuId = getDsisUserid();classId = studentService.get(stuId).getTClasses().getBjId(); }//得到学生对象
				MimiInfo miniInfo = new MimiInfo();
				miniInfo.setClassid(classId);
				Member sendmember = new Member();
				sendmember.setMemberid(getSessionMemberId());
				miniInfo.setSendmember(sendmember);
				miniInfo.setMsgcontent(msgcontent);
				miniInfo.setMsgdate(new Date());
				miniInfo.setDelstatus(Long.valueOf(0));
				miniInfo.setApprostatus(Long.valueOf(2));
				miniInfo.setIsshow("1");
				mimiInfoService.save(miniInfo);
				return ajaxJsonSuccessMessage("留言成功！");
			}
		} catch (Exception e) {
			return ajaxJsonErrorMessage("留言失败！请与管理员联系！");
		}
		
	}

	/**
	 * 回复留言
	 * @return
	 * @throws Exception
	 */
	public String revert()throws Exception{
		try {
			String msgid = getParameter("msgid");
			String leavemsgcontent = getParameter("leavemsg_"+msgid);
			RemimiInfo remimiInfo = new RemimiInfo();
			Member sendmember = new Member();
			sendmember.setMemberid(getSessionMemberId());
			remimiInfo.setSendmember(sendmember);
			MimiInfo miniInfo = new MimiInfo();
			miniInfo.setMsgid(msgid);
			remimiInfo.setMimi(miniInfo);
			remimiInfo.setRemsgdate(new Date());
			remimiInfo.setRemsgcontent(leavemsgcontent);
			remimiInfo.setSendusername(getSession(Member.LOGIN_MEMBER_NIKENAME)+"");
			remimiInfo.setIsshow("1");
			miniInfo.setDelstatus(Long.valueOf(0));
			miniInfo.setApprostatus(Long.valueOf(2));
			remimiInfoService.save(remimiInfo);
			return list();
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public MimiInfoService getMimiInfoService() {
		return mimiInfoService;
	}

	public void setMimiInfoService(MimiInfoService mimiInfoService) {
		this.mimiInfoService = mimiInfoService;
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

	public RemimiInfoService getRemimiInfoService() {
		return remimiInfoService;
	}

	public void setRemimiInfoService(RemimiInfoService remimiInfoService) {
		this.remimiInfoService = remimiInfoService;
	}

	public Long getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}

	
	
	
}
