package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.ParentAccountDao;
import com.cnarj.ttxs.pojo.dsis.ParentAccount;
import com.cnarj.ttxs.service.ParentAccountService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 家长账户业务实现类
 * @author Administrator
 *
 */
public class ParentAccountServiceImpl extends BaseDsisServiceImpl<ParentAccount, Long> implements ParentAccountService{

	
	private ParentAccountDao parentAccountDao;

	public ParentAccountDao getParentAccountDao() {
		return parentAccountDao;
	}

	public void setParentAccountDao(ParentAccountDao parentAccountDao) {
		this.parentAccountDao = parentAccountDao;
		super.setBaseDao(parentAccountDao);
	}

	
	public List<ParentAccount> getParengAccountList(String moblie)
			throws BusinessException {
		return parentAccountDao.getParengAccountList(moblie);
	}
	
	
}
