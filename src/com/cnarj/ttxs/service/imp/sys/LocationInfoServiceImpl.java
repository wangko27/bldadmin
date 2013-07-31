package com.cnarj.ttxs.service.imp.sys;


import com.cnarj.ttxs.dao.sys.ILocationInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.sys.ILocationInfoService;

import java.util.List;

/**
 * 系统Service实现类 - 位置
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class LocationInfoServiceImpl extends BaseServiceImpl<LocationInfo,String> implements
		ILocationInfoService {
    private ILocationInfoDao locationInfoDao;

    public ILocationInfoDao getLocationInfoDao() {
        return locationInfoDao;
    }

    public void setLocationInfoDao(ILocationInfoDao locationInfoDao) {
        this.locationInfoDao = locationInfoDao;
    }

    //分页获取所有网站位置
    @Override
    public Result getAllLocation(Page page) {
        StringBuffer hql = new StringBuffer();
        hql.append("from LocationInfo where 1=1 order by createdate ");
        return locationInfoDao.findByPage(hql.toString(), page);
    }

    //根据网站位置id获取网站位置
    public LocationInfo getById(String locationId) {
        StringBuffer hql = new StringBuffer();
        hql.append("from LocationInfo ");
        if(locationId != null && !locationId.trim().equals("")){
           hql.append("where locationid ='").append(locationId).append("'");
            return locationInfoDao.findById(hql.toString());
        }else {
               return null;
        }
    }

    //获取所有网站位置的集合


    @Override
    public List<LocationInfo> getAllLocation() {
        StringBuffer hql = new StringBuffer();
        hql.append("from LocationInfo where 1=1");
        return locationInfoDao.findAll(hql.toString());
    }
}
