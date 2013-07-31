package com.cnarj.ttxs.service.imp.member;

import com.cnarj.ttxs.dao.RemimiInfoDao;
import com.cnarj.ttxs.pojo.msg.RemimiInfo;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.RemimiInfoService;

public class RemimiInfoServiceImpl extends BaseServiceImpl<RemimiInfo, String> implements RemimiInfoService{

	private RemimiInfoDao remimiInfoDao;

	public RemimiInfoDao getRemimiInfoDao() {
		return remimiInfoDao;
	}

	public void setRemimiInfoDao(RemimiInfoDao remimiInfoDao) {
		this.remimiInfoDao = remimiInfoDao;
		super.setBaseDao(remimiInfoDao);
	}
	
	
}
