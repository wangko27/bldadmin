package com.cnarj.ttxs.dao.sys;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.sys.Admin;

/**
 * 系统Dao接口类 - 管理员
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月13日10:49:41
 */
public interface IAdminDao extends IBaseDao<Admin, String> {

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
