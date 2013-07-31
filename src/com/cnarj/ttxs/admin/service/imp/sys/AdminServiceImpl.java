package com.cnarj.ttxs.admin.service.imp.sys;

import com.cnarj.ttxs.admin.service.sys.IAdminService;
import com.cnarj.ttxs.dao.sys.IAdminDao;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 系统 后台Service实现类 - 管理员
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月15日
 */
public class AdminServiceImpl extends BaseServiceImpl<Admin, String> implements
		IAdminService {

	IAdminDao adminDao;

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Admin login(String username, String adminpassword) {
		return adminDao.login(username, adminpassword);
	}

}
