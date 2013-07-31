package com.cnarj.ttxs.service.imp.sys;

import com.cnarj.ttxs.dao.sys.ILocContentDao;
import com.cnarj.ttxs.pojo.sys.LocContent;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.sys.ILocContentService;

import java.util.List;

/**
 * 系统Service实现类 - 位置内容
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class LocContentServiceImpl extends BaseServiceImpl<LocContent,String> implements ILocContentService {
    private ILocContentDao locContentDao;

    @Override
    public List<LocContent> findByLocationId(String locationId) {
        StringBuffer hql = new StringBuffer();
        if(locationId != null && !"".equals(locationId.trim())){
            hql.append("from LocContent  where locationInfo.locationid = '").append(locationId).append("'");
            return locContentDao.findById(hql.toString());
        }
        return null;
    }


    public ILocContentDao getLocContentDao() {
        return locContentDao;
    }

    public void setLocContentDao(ILocContentDao locContentDao) {
        this.locContentDao = locContentDao;
    }
}
