package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import org.apache.log4j.Logger;

import com.cnarj.ttxs.dao.TermSetDao;
import com.cnarj.ttxs.pojo.dsis.TTermSet;
import com.cnarj.ttxs.service.TermSetService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学校学期业务实现类
 * @author hedan
 */
public class TermSetServiceImpl extends BaseDsisServiceImpl<TTermSet, Long> implements TermSetService{

	private TermSetDao termSetDao;
	
	protected static Logger logger = Logger.getLogger(TermSetServiceImpl.class);
	
	
	public List<TTermSet> getTermListByXxid(String xxid)
			throws BusinessException {
		return termSetDao.getList("xxid", xxid);
	}


	public TermSetDao getTermSetDao() {
		return termSetDao;
	}


	public void setTermSetDao(TermSetDao termSetDao) {
		this.termSetDao = termSetDao;
		super.setBaseDao(termSetDao);
	}
	
	

}
