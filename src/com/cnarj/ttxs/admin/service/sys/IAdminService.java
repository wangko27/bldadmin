package com.cnarj.ttxs.admin.service.sys;

import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 系统 后台Service接口类 - 管理员
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月15日
 */
public interface IAdminService extends IBaseService<Admin, String> {

	/**
	 * 登录
	 * 
	 * @param username
	 *            用户名
	 * @param adminpassword
	 *            密码
	 * @return
	 */
	public Admin login(String username, String adminpassword);
}
