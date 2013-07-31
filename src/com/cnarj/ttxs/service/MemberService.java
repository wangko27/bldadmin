package com.cnarj.ttxs.service;

import java.io.File;

import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 前台会员业务接口
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author hedan
 * @version 1.0
 * @since 2011-08-12
 */
public interface MemberService extends IBaseService<Member, String>{

	/**
	 * 前台页面用户登录
	 * @param username
	 * @param memberpassword
	 * @param memberType
	 * @return
	 * @throws BusinessException
	 */
	public Common loginMember(Member member)throws BusinessException;
	
	/**
	 * 根据会员类型和dsisUserId获得会员实体对象
	 * @param dsisUserId 
	 * @param memberType 会员类型
	 * @return
	 */
	public Member getMember(Long dsisUserId, Long memberType)throws BusinessException;
	
	/**
	 * 修改会员密码
	 * @param memberid
	 * @param newpassword
	 * @throws BusinessException
	 */
	public void updatePwd(String memberid, String newpassword)throws BusinessException;
	
	
	/**
	 * 修改昵称
	 * @param memberid
	 * @param nikename
	 */
	public void updateNikename(String memberid, String nikename)throws BusinessException;
	
	/**
	 * 更换头像
	 * @param memberid
	 * @param stuPhotoFile
	 * @param uploadFileName
	 * @param uploadContentType
	 * @throws BusinessException
	 */
	public String updateheadimage(String memberid, File photoFile, String uploadFileName, String uploadContentType)throws BusinessException,Exception;
	
	/**
	 * 修改邮件
	 * @param memberid
	 * @param email
	 */
	public void updateEmail(String memberid, String email)throws BusinessException;
}
