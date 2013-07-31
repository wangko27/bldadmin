package com.cnarj.ttxs.web.actions.member;

import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.dsis.ParentAccount;
import com.cnarj.ttxs.pojo.dsis.TSchoolinfo;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.dsis.TTeacherinfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.ParentAccountService;
import com.cnarj.ttxs.service.SchoolinfoService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.TTeacherinfoService;
import com.cnarj.ttxs.web.actions.base.BaseAction;

/**
 * 我的资料
 * @author hedan
 *
 */
public class MyInformationAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8749124087626264065L;

	private MemberService memberService;
	
	private StudentService studentService;
	
	private SchoolinfoService schoolinfoService;
	
	private ParentAccountService parentAccountService;
	
	private TTeacherinfoService teacherinfoService;
	
	private Long memberType;//会员类型
	
	private TStudent student;
	
	private Member member;
	
	private TSchoolinfo schoolinfo;
	
	private ParentAccount parentAccount;
	
	private TTeacherinfo teacherinfo;
	
	/**
	 * 我的资料
	 * @return
	 * @throws Exception
	 */
	public String myInfo()throws Exception{
		try {
			memberType = getSessionMemberType();
			Long dsisUserid = getDsisUserid();
			if(memberType != null){
				if( memberType == 1){
					student = studentService.get(dsisUserid);
					schoolinfo = schoolinfoService.get("xxid",getXxid());
				}
				if(memberType == 2){//家长资料
					parentAccount = parentAccountService.get(dsisUserid);//家长账户实体对象
					Long xsId = parentAccount.getXsId();
					if(xsId != null){
						student = studentService.get(xsId);
					}else{
						student = null;
					}
				}
				if(memberType == 3){//老师资料
					teacherinfo = teacherinfoService.get(dsisUserid);//教师账户信息
					schoolinfo = schoolinfoService.get("xxid",getXxid());
				}
				if(memberType == 4){//游客资料
					member = memberService.get(getSessionMemberId());
				}
			}else{
				this.addActionError("请登录!!");
				sendRedirect("/login/login.jsp");
				return null;
			}
		
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		try {
			//取当前用户ID
			String memberId = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberId || memberId.length() == 0){
				this.addActionError("请登录!!");
				sendRedirect("/login/login.jsp");
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
		}
		
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Long getMemberType() {
		return memberType;
	}

	public void setMemberType(Long memberType) {
		this.memberType = memberType;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public SchoolinfoService getSchoolinfoService() {
		return schoolinfoService;
	}

	public void setSchoolinfoService(SchoolinfoService schoolinfoService) {
		this.schoolinfoService = schoolinfoService;
	}

	public TSchoolinfo getSchoolinfo() {
		return schoolinfo;
	}

	public void setSchoolinfo(TSchoolinfo schoolinfo) {
		this.schoolinfo = schoolinfo;
	}

	public ParentAccountService getParentAccountService() {
		return parentAccountService;
	}

	public void setParentAccountService(ParentAccountService parentAccountService) {
		this.parentAccountService = parentAccountService;
	}

	public TTeacherinfoService getTeacherinfoService() {
		return teacherinfoService;
	}

	public void setTeacherinfoService(TTeacherinfoService teacherinfoService) {
		this.teacherinfoService = teacherinfoService;
	}

	public ParentAccount getParentAccount() {
		return parentAccount;
	}

	public void setParentAccount(ParentAccount parentAccount) {
		this.parentAccount = parentAccount;
	}

	public TTeacherinfo getTeacherinfo() {
		return teacherinfo;
	}

	public void setTeacherinfo(TTeacherinfo teacherinfo) {
		this.teacherinfo = teacherinfo;
	}
	
	
	
}
