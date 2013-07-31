package com.cnarj.ttxs.dao.imp.sys;


import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.sys.ILocContentDao;
import com.cnarj.ttxs.pojo.sys.LocContent;

import java.util.List;

/**
 * 系统Dao接口实现类 - 位置内容
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class LocContentDaoImpl extends BaseDaoImpl<LocContent,String> implements ILocContentDao {
    @Override
    public List<LocContent> findById(String hql) {
        return this.getSession().createQuery(hql).list();
    }
}
