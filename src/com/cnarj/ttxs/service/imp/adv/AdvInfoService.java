package com.cnarj.ttxs.service.imp.adv;

import com.cnarj.ttxs.dao.adv.IAdvInfoDao;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.service.adv.IAdvInfoService;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 广告Service实现类 - 广告
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月24日22:24:18
 */
public class AdvInfoService extends BaseServiceImpl<AdvInfo,String> implements IAdvInfoService {

	
	public void setBaseDao(IAdvInfoDao advInfoDao) {
		super.setBaseDao(advInfoDao);
	}

}
