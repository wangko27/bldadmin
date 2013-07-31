package com.cnarj.ttxs.service.imp.sys;

import java.util.List;

import org.hibernate.Hibernate;

import com.cnarj.ttxs.dao.sys.INavigationDao;
import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.sys.INavigationService;

/**
 * 系统Service实现类 - 导航
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class NavigationServiceImpl extends BaseServiceImpl<Navigation,String> implements
		INavigationService {
	
	private INavigationDao navigationDao;
	
	public void setBaseDao(INavigationDao navigationDao) {
		super.setBaseDao(navigationDao);
	}

	public List<Navigation> getTopNavigationList() {
		List<Navigation> topNavigationList = navigationDao.getTopNavigationList();
		if (topNavigationList != null) {
			for (Navigation topNavigation : topNavigationList) {
				Hibernate.initialize(topNavigation);
			}
		}
		return topNavigationList;
	}

	public INavigationDao getNavigationDao() {
		return navigationDao;
	}

	public void setNavigationDao(INavigationDao navigationDao) {
		this.navigationDao = navigationDao;
	}
	
}
