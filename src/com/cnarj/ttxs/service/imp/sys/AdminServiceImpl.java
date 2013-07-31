package com.cnarj.ttxs.service.imp.sys;

import com.cnarj.ttxs.dao.sys.IAdminDao;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.sys.IAdminService;

/**
 * 系统Service实现类 - 管理员
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月13日11:03:51
 */
public class AdminServiceImpl extends BaseServiceImpl<Admin,String> implements IAdminService 
{

	public void setBaseDao(IAdminDao adminDao) {
		super.setBaseDao(adminDao);
	}
}
