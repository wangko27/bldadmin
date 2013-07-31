package com.cnarj.ttxs.dao.imp.adv;

import com.cnarj.ttxs.dao.adv.IAdvInfoDao;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.pojo.sys.LocationInfo;

import java.util.List;

/**
 * 广告Dao接口实现类 - 广告类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月24日22:07:19
 */
public class AdvInfoDaoImpl extends BaseDaoImpl<AdvInfo,String> implements IAdvInfoDao {

	/**
	 * 得到所有的广告位置
	 */
	@SuppressWarnings("unchecked")
	public List<LocationInfo> getAllLocationInfo(String hql) {
		return this.getSession().createQuery(hql).list();
	}
	/**
	 * 得到所有的广告并分页
	 */

	public Result getShowAllAdv(String hql, Page page) {
		//this.getSession().clear();//清理缓存
		return findByPager(page, hql);
	}
    public List<AdvInfo> getShowAllAdv(String hql) {
        //this.getSession().clear();//清理缓存
        return this.getSession().createQuery(hql).list();
    }

}
