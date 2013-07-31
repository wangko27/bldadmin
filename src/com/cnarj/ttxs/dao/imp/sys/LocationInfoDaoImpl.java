package com.cnarj.ttxs.dao.imp.sys;


import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.sys.ILocationInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.LocationInfo;

import java.util.List;

/**
 * 系统Dao接口实现类 - 网站页面位置
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class LocationInfoDaoImpl extends BaseDaoImpl<LocationInfo,String> implements
		ILocationInfoDao {
    @Override
    public Result findByPage(String hql, Page page) {
         return   findByPager(page,hql);
    }

    @Override
    public LocationInfo findById(String hql) {
        return (LocationInfo)this.getSession().createQuery(hql).uniqueResult();
    }

    @Override
    public List<LocationInfo> findAll(String hql) {
        return this.getSession().createQuery(hql).list();
    }
}
