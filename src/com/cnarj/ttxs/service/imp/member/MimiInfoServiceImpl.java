package com.cnarj.ttxs.service.imp.member;

import com.cnarj.ttxs.dao.MimiInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MimiInfo;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.MimiInfoService;

public class MimiInfoServiceImpl extends BaseServiceImpl<MimiInfo, String> implements MimiInfoService{

	private MimiInfoDao mimiInfoDao;

	public MimiInfoDao getMimiInfoDao() {
		return mimiInfoDao;
	}

	public void setMimiInfoDao(MimiInfoDao mimiInfoDao) {
		this.mimiInfoDao = mimiInfoDao;
		super.setBaseDao(mimiInfoDao);
	}


	public Result getPager(Page pager, Long classId) {
		return mimiInfoDao.getPager(pager, classId);
	}
	

}
