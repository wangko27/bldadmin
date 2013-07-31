package com.cnarj.ttxs.dao.adv;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.pojo.sys.LocationInfo;


/**
 * 广告Dao接口类 - 广告类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月24日22:06:40
 */
public interface IAdvInfoDao extends IBaseDao<AdvInfo,String> {
	/**
	 * 广告的所有位置
	 * @param string
	 * @return
	 */
	public List<LocationInfo> getAllLocationInfo(String string);

	/**
	 * 得到所有的广告并分页
	 * @param string
	 * @param page
	 * @return
	 */
	public Result getShowAllAdv(String hql, Page page);


    /**
     * 根据广告位置id 获取所有广告
     * @param hql
     * @return
     */
    public List<AdvInfo> getShowAllAdv(String hql);

}
