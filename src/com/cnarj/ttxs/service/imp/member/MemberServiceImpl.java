package com.cnarj.ttxs.service.imp.member;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.BusinessException;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.MD5;
import com.cnarj.ttxs.util.Pubfun;

/**
 * 会员管理业务实现类
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author hedan
 * @version 1.0
 * @since 2011-08-12
 * 
 */
public class MemberServiceImpl extends BaseServiceImpl<Member, String>  implements MemberService{

	private MemberDao memberDao;
	
	
	protected static Logger logger = Logger.getLogger(MemberServiceImpl.class);
	
	public Common loginMember(Member member) throws BusinessException {
		try {
			logger.debug("enter memberLogin");
			Member l_member = null;
			String l_memeberpassword = MD5.getMD5ofStr(member.getMemberpassword());//加密密码
			List<Member> lst_member = memberDao.checkMember(member.getUsername(),l_memeberpassword, member.getMemberType());
			if(lst_member == null || lst_member.size()<=0){
				common.setStatus(false);
				logger.info("登录失败！用户名或密码错误!");
				common.setMessage("登录失败！用户名或密码错误!");
				return common;
			}
			
			l_member = lst_member.get(0);  
			if(l_member.getIsaccountenabled()!= null && l_member.getIsaccountenabled().equals("0")){
				common.setStatus(false);
				logger.info("登录失败！该账户已禁用!");
				common.setMessage("登录失败！该账户已禁用,请与管理员联系!");
				return common;
			}
			
			if(l_member.getIsaccountlocked()!= null && l_member.getIsaccountlocked().equals("0")){
				common.setStatus(false);
				logger.info("登录失败！该账户已被锁定!");
				common.setMessage("登录失败！该账户已被锁定,请与管理员联系!");
				return common;
			}
			Date lastLoginDate = l_member.getLogindate();//该用户最后登录时间
			Long points = null;
			if(lastLoginDate != null){
				Date now = new Date();//系统当前时间
				int l = DateUtil.DateDiff(DateUtil.setDateFormat(lastLoginDate.toLocaleString(), "yyyy-MM-dd", "yyyy-MM-dd"), "yyyy-MM-dd", DateUtil.setDateFormat(now.toLocaleString(), "yyyy-MM-dd", "yyyy-MM-dd"), "yyyy-MM-dd", Calendar.DATE);//比较两天中的时间差
			    if(l >=1){
			    	points = l_member.getMemberpoint()+2;
			    }else{
			    	points = l_member.getMemberpoint();
			    }
			}else{
				points = l_member.getMemberpoint()+2;
			}
			//修改最后登录ip和最后登录日期
			l_member.setLoginip(member.getLoginip());
			l_member.setLogindate(member.getLogindate());
			l_member.setMemberpoint(points);
			memberDao.update(l_member);
			common.setStatus(true);
			common.setObj(l_member);
			logger.info(l_member.getUsername()+"于 "+Pubfun.getdatetime()+"登录！");
		} catch (Exception e) {
			common.setStatus(false);
			logger.info("登录失败！程序内部错误，原因："+e.toString());
			common.setMessage("登录失败！请与管理员联系!");
			throw new BusinessException("登录失败！程序内部错误，原因："+e.toString());
		}
		return common;
	}


	public void updatePwd(String memberid, String newpassword)
			throws BusinessException {
		memberDao.updatePwd(memberid, newpassword);
	}

	public void updateNikename(String memberid, String nikename)
		throws BusinessException {
		memberDao.updateNikename(memberid, nikename);
	}

	
	public Member getMember(Long dsisUserId, Long memberType)
			throws BusinessException {
		return memberDao.getMember(dsisUserId, memberType);
	}
	
	
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		super.setBaseDao(memberDao);
	}


	
	public String updateheadimage(String memberid, File photoFile,
			String uploadFileName, String uploadContentType)
			throws BusinessException,Exception {
		Member member = memberDao.get(memberid);
		if(member.getHeadpath() != null && !"".equals(member.getHeadpath())){
			FileOperate.deleteFile(member.getHeadpath());
		}
		//上传文件路径
		StringBuffer filePath = new StringBuffer("");
		filePath.append("uploadfiles/photos/user/");
		uploadFileName  = uploadFileName.toLowerCase();//转换为小写
		String fileName = FileOperate.generateFileName(uploadFileName);//文件名称
		String realFilePath = FileOperate.fileUpload(photoFile, uploadFileName, uploadContentType, filePath.toString(), fileName);//文件保存路径
		if(realFilePath != null ){
			memberDao.updateHeadpath(memberid, realFilePath);
		}
		return realFilePath == null ? null : realFilePath;
	}


	
	public void updateEmail(String memberid, String email)
			throws BusinessException {
		memberDao.updateEmail(memberid, email);
	}


	
	


	






}
