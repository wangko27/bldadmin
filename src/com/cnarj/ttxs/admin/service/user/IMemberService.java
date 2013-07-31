package com.cnarj.ttxs.admin.service.user;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 用户频道后台Service接口类 - 会员
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月29日
 */
public interface IMemberService extends IBaseService<Member, String> {

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



}
