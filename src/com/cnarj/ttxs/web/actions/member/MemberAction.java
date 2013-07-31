package com.cnarj.ttxs.web.actions.member;

import java.io.File;
import java.util.Date;
import java.util.List;



import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.pojo.user.MemberAddInfo;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.member.IAlbumsService;
import com.cnarj.ttxs.service.member.IFriendTypeService;
import com.cnarj.ttxs.service.member.IMemberAddInfoService;
import com.cnarj.ttxs.util.MD5;
import com.cnarj.ttxs.util.MailUtil;
import com.cnarj.ttxs.util.ValidateUtil;
import com.cnarj.ttxs.web.actions.base.BaseAction;

/**
 * 前台页面会员登录控制类
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author hedan
 * @version 1.0
 * @since 2011-08-12
 */
public class MemberAction extends BaseAction{

	private static final long serialVersionUID = 6718838811223344556L;
	
	private Member member = new Member();
	
	private MemberService memberService;
	
	private String nikename;//昵称
	
	private File headpath;//会员头像
	
	private String headpathFileName;//上传文件名属性
	
	private String headpathContentType;//上传文件类型属性
	
	
	
	
    /**
     * 用户中心首页
     * @return
     * @throws Exception
     */
	public String memberCenterIndex()throws Exception{
		try {
			
			
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		
		return CONTENT; 
	}
	
	
	/**
	 * 密码修改
	 * @return
	 * @throws Exception
	 */
	public String updatePwd()throws Exception{
		try {
			String memberid = getSessionMemberId();//得到session中的memberid
			if(memberid != null){
				Member l_member  = memberService.get(memberid);
				String l_loginpassword = getParameter("loginpassword");
				if(l_loginpassword != null){
					if(MD5.getMD5ofStr(l_loginpassword).equals(l_member.getMemberpassword())){//如果相等 则允许修改
						String newpassword = getParameter("newpassword");
						memberService.updatePwd(memberid, MD5.getMD5ofStr(newpassword));
						return ajaxJsonSuccessMessage("密码修改成功！");
					}else{
						return ajaxJsonErrorMessage("您输入的密码与登录密码不一致，请重新输入！");
					}
				}						
			}
		} catch (Exception e) {
			return ajaxJsonErrorMessage("修改密码失败！");
		}
		return null;
	}
	
	/**
	 * 游客查询会员详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail()throws Exception{
		try {
			String memberid = getSessionMemberId();//得到session中的memberid
			member = memberService.get(memberid);
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "detail";
	}
	
	/**
	 * 修改资料
	 * @return
	 * @throws Exception
	 */
	public String updateInfo()throws Exception{
		try {
			Long memberType = getSessionMemberType();//会员类型
			String memberid = getSessionMemberId();//得到session中的memberid
			if(memberType != null ){
				if(memberType == 1 || memberType == 2 || memberType == 3){
					String nikename = getParameter("nikename");
					memberService.updateNikename(memberid, nikename);
					setSession(Member.LOGIN_MEMBER_NIKENAME, nikename);
					addActionMessage("修改成功！");
					return "myinfo";
				}
				if(memberType == 4){
					String email = getParameter("email");
					String realname = getParameter("realname");
					String sex = getParameter("sex");
					String inaddr = getParameter("inaddr");
					String nikename = getParameter("nikename");
					member = memberService.get(memberid);
					member.setEmail(email);
					member.getMemberAddInfo().setRealname(realname);
					member.getMemberAddInfo().setSex(sex);
					member.getMemberAddInfo().setInaddr(inaddr);
					member.setNikename(nikename);
					memberService.update(member);
					setSession(Member.LOGIN_MEMBER_NIKENAME, nikename);
					addActionMessage("修改成功！");
					return "otherinfo";
				}
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return INPUT;
	}
	
	
	/**
	 * 更换头像
	 * @return
	 * @throws Exception
	 */
	public String changeHeadImage()throws Exception{
		try {
			if(headpath != null && headpath.length() > (256 * 1024)){
				addActionError("上传文件大小超出限制！");
				return WARN;
			}
			String realFilePath = memberService.updateheadimage(getSessionMemberId(), headpath, headpathFileName, headpathContentType);
			if(realFilePath != null){
				setSession(Member.LOGIN_MEMBER_HEADPATH, realFilePath);
			}
			addActionMessage("更换头像成功！");
			return SUCCESS;
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
	}
	
	/**
	 * 新增邮箱
	 * @return
	 * @throws Exception
	 */
	public String addEmail()throws Exception{
		try {
			String memberid = getSessionMemberId();
			String email = getParameter("email");
			memberService.updateEmail(memberid, email);
			setSession(Member.LOGIN_MEMBER_EMAIL, email);
			return ajaxJsonSuccessMessage("添加邮件成功！");
		} catch (Exception e) {
			return ajaxJsonErrorMessage("添加邮件失败！");
		}
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public File getHeadpath() {
		return headpath;
	}


	public void setHeadpath(File headpath) {
		this.headpath = headpath;
	}


	public String getHeadpathFileName() {
		return headpathFileName;
	}


	public void setHeadpathFileName(String headpathFileName) {
		this.headpathFileName = headpathFileName;
	}


	public String getHeadpathContentType() {
		return headpathContentType;
	}


	public void setHeadpathContentType(String headpathContentType) {
		this.headpathContentType = headpathContentType;
	}
	
	
	
}
