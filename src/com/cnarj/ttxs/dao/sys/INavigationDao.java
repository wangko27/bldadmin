package com.cnarj.ttxs.dao.sys;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.sys.Navigation;

/**
 * 系统Dao接口类 - 导航
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日11:02:49
 */
public interface INavigationDao extends IBaseDao<Navigation,String> {
	/**
	 * 获取顶部Navigation对象集合（只包含isVisible=true的对象）
	 * 
	 * @return Navigation对象集合
	 * 
	 */
	public List<Navigation> getTopNavigationList();
}
