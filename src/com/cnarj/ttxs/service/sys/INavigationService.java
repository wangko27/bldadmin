package com.cnarj.ttxs.service.sys;

import java.util.List;

import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 系统Service接口类 - 导航
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public interface INavigationService extends IBaseService<Navigation,String> {

	/**
	 * 获取顶部Navigation对象集合（只包含isVisible=true的对象）
	 * 
	 * @return Navigation对象集合
	 * 
	 */
	public List<Navigation> getTopNavigationList();
}
