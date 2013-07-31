package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.user.Member;

/**
 * 会员接口类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author hedan
 * @version 1.0
 * @since 2011年8月11日
 */
public interface MemberDao extends IBaseDao<Member, String> {

	/**
	 * 检查会员是否存在
	 * 
	 * @param userName
	 *            用户名
	 * @param memberPassword
	 *            用户密码
	 * @param memberType
	 *            用户类型
	 */
	public List<Member> checkMember(String userName, String memberPassword,
			Long memberType);

	/**
	 * 根据用户名称查找会员
	 * 
	 * @param username
	 *            用户名
	 * @param memberType
	 *            会员类型 1. 教师 2. 家长 3. 学生 4. 其他注册用户
	 * @return
	 * @throws Exception
	 */
	public List<Member> listMemberByUsername(String username, Long memberType)
			throws Exception;

	/**
	 * 根据用户昵称查找会员
	 * 
	 * @param username
	 *            用户名
	 * @param memberType
	 *            会员类型 1. 教师 2. 家长 3. 学生 4. 其他注册用户
	 * @return
	 * @throws Exception
	 */
	public List<Member> listMemberByNikename(String nikename, Long memberType)
			throws Exception;

	/**
	 * 查询所有名师
	 * @param page
	 * @return
	 */
	public Result listMemberByMastersPage(Page page);

	/**
	 * 根据会员类型和dsisUserId获得会员实体对象
	 * 
	 * @param dsisUserId
	 * @param memberType
	 *            会员类型
	 * @return
	 */
	public Member getMember(Long dsisUserId, Long memberType);
	
	/**
	 * 修改密码
	 * @param memberid
	 * @param newpassword
	 */
	public void updatePwd(String memberid, String newpassword);
	
	/**
	 * 修改昵称
	 * @param memberid
	 * @param nikename
	 */
	public void updateNikename(String memberid, String nikename);
	
	/**
	 * 更换头像
	 * @param memberid
	 * @param headpath
	 */
	public void updateHeadpath(String memberid, String headpath);
	
	/**
	 * 修改邮件
	 * @param memberid
	 * @param email
	 */
	public void updateEmail(String memberid, String email);
}
