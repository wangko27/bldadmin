package com.cnarj.ttxs.admin.service.adv;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.service.IBaseService;

import java.util.List;
 
/**
 * 广告Service类 - 广告
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年7月24日22:24:18
 */
public interface IAdvInfoService extends IBaseService<AdvInfo, String> {

	/**
	 * 得到所有的广告位置
	 * @return
	 */
	public List<LocationInfo> getAllLocationInfo(String sel);

	/**
	 * 得到所有的广告  并分页
	 * @param locationId
	 * @param page
	 * @return
	 */
	public Result getShowAllAdv(String locationId, Page page);

    /**
     * 根据广告位置id获取所有的广告
     * @param locationId
     * @return
     */
    public List<AdvInfo> getShowAllAdv(String locationId);

}
