package com.cnarj.ttxs.service.imp.dsis;

import com.cnarj.ttxs.dao.SchoolinfoDao;
import com.cnarj.ttxs.pojo.dsis.TSchoolinfo;
import com.cnarj.ttxs.service.SchoolinfoService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;

/**
 * 
 * @author hedan
 *
 */
public class SchoolinfoServiceImpl extends BaseDsisServiceImpl<TSchoolinfo, Long> implements SchoolinfoService{

	private SchoolinfoDao schoolinfoDao;

	public SchoolinfoDao getSchoolinfoDao() {
		return schoolinfoDao;
	}

	public void setSchoolinfoDao(SchoolinfoDao schoolinfoDao) {
		this.schoolinfoDao = schoolinfoDao;
		super.setBaseDao(schoolinfoDao);
	}
	
	
	
}
