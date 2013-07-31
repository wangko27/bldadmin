package com.cnarj.ttxs.service.imp.member;


import com.cnarj.ttxs.dao.member.IRemsgDao;
import com.cnarj.ttxs.pojo.msg.RemsgInfo;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IRemsgService;

public class RemsgServiceImpl extends BaseServiceImpl<RemsgInfo,String> implements IRemsgService {


	public void setBaseDao(IRemsgDao remsgDao) {
		super.setBaseDao(remsgDao);
	}
	
}
