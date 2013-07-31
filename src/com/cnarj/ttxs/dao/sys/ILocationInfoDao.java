package com.cnarj.ttxs.dao.sys;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.LocationInfo;

import java.util.List;

/**
 * Dao接口类 - 网站位置
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日10:37:25
 */
public interface ILocationInfoDao extends IBaseDao<LocationInfo,String> {

    public  Result findByPage(String hql, Page page);

    public LocationInfo findById(String hql);

    public List<LocationInfo> findAll(String hql);
}
