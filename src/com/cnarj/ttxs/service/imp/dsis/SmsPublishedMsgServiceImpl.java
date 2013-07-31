package com.cnarj.ttxs.service.imp.dsis;

import com.cnarj.ttxs.dao.SmsPublishedMsgDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.SmsPublishedMsg;
import com.cnarj.ttxs.service.SmsPublishedMsgService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

public class SmsPublishedMsgServiceImpl extends BaseDsisServiceImpl<SmsPublishedMsg, Long> implements SmsPublishedMsgService{

	private SmsPublishedMsgDao smsPublishedMsgDao;

	public SmsPublishedMsgDao getSmsPublishedMsgDao() {
		return smsPublishedMsgDao;
	}

	public void setSmsPublishedMsgDao(SmsPublishedMsgDao smsPublishedMsgDao) {
		this.smsPublishedMsgDao = smsPublishedMsgDao;
		super.setBaseDao(smsPublishedMsgDao);
	}

	
	public Result getSmsMsgPage(String mobile, String startDate,
			String endDate, Page page) throws BusinessException {
		return smsPublishedMsgDao.getSmsMsgPage(mobile, startDate, endDate, page);
	}

	
	public Result getSmsMsgPage(Long xsId, String startDate, String endDate,
			Page page) throws BusinessException {
		return smsPublishedMsgDao.getSmsMsgPage(xsId, startDate, endDate, page);
	}

	
	public Result getSmsMsgPage(Page page, String startDate, String endDate,
			Long classId) throws BusinessException {
		return smsPublishedMsgDao.getSmsMsgPage(page, startDate, endDate, classId);
	}
	
	
	
}
