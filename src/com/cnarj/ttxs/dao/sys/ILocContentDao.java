package com.cnarj.ttxs.dao.sys;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.sys.LocContent;

import java.util.List;

/**
 * 系统Dao接口类 - 位置内容
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日11:02:49
 */
public interface ILocContentDao extends IBaseDao<LocContent,String> {

    public List<LocContent> findById(String hql);
}
