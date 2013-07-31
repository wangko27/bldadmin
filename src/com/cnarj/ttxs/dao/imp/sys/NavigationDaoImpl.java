package com.cnarj.ttxs.dao.imp.sys;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.sys.INavigationDao;
import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.pojo.sys.Navigation.Position;

/**
 * 系统Dao接口实现类 - 导航
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class NavigationDaoImpl extends BaseDaoImpl<Navigation,String> implements INavigationDao {
	
	/**
	 * 查询展示的顶部导航,按orderlist排序
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Navigation> getTopNavigationList() {
		String hql = "from Navigation as navigation where navigation.navigationposition = ? and navigation.isvisible = 1 order by navigation.orderlist asc";
		Long lo = new Long(Position.top.ordinal()+1);
		return getSession().createQuery(hql).setParameter(0, lo).list();
	}
	// 根据orderList排序
	@SuppressWarnings("unchecked")
	@Override
	public List<Navigation> getAll() {
		String hql = "from Navigation navigation order by navigation.navigation.navigationid asc navigation.orderlist asc";
		return getSession().createQuery(hql).list();
	}
	
	// 根据orderList排序 isvisible为true 1
	@Override
	@SuppressWarnings("unchecked")
	public List<Navigation> getList(String propertyName, Object value) {
		String hql = "from Navigation navigation where navigation." + propertyName + "=? and navigation.isvisible = 1 order by navigation.orderlist asc navigation.createdate desc";
		return getSession().createQuery(hql).setParameter(0, value).list();
	}
}
