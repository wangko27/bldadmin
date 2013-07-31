package com.cnarj.ttxs.service.imp.dsis;

import com.cnarj.ttxs.dao.TTeacherinfoDao;
import com.cnarj.ttxs.pojo.dsis.TTeacherinfo;
import com.cnarj.ttxs.service.TTeacherinfoService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;

/**
 * 教师业务实现类
 * @author hedan
 *
 */
public class TTeacherinfoServiceImpl extends BaseDsisServiceImpl<TTeacherinfo, Long> implements TTeacherinfoService{

	private TTeacherinfoDao teacherinfoDao;

	public TTeacherinfoDao getTeacherinfoDao() {
		return teacherinfoDao;
	}

	public void setTeacherinfoDao(TTeacherinfoDao teacherinfoDao) {
		this.teacherinfoDao = teacherinfoDao;
		super.setBaseDao(teacherinfoDao);
	}
	
	
}
