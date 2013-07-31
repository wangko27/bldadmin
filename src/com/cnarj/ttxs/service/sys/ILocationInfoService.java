package com.cnarj.ttxs.service.sys;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.service.IBaseService;

import java.util.*;

/**
 * 系统Service接口类 - 网站位置
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public interface ILocationInfoService extends IBaseService<LocationInfo,String> {

    public  Result getAllLocation(Page page);
    public LocationInfo getById(String locationId);
    public List<LocationInfo> getAllLocation();
}
