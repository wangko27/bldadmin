package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.ParentAccount;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 家长账户业务接口
 * @author hedan
 *
 */
public interface ParentAccountService extends BaseDsisService<ParentAccount, Long>{

	/**
	 * 根据手机号码查询家长账户列表
	 * @param moblie
	 * @return
	 * @throws BusinessException
	 */
	public List<ParentAccount> getParengAccountList(String moblie)throws BusinessException;
}
