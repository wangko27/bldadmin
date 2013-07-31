package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.ParentAccount;

/**
 * 家长账户接口
 * @author hedan
 *
 */
public interface ParentAccountDao extends BaseDsisDao<ParentAccount, Long> {

	/**
	 * 根据绑定的手机号码得到家长账户列表
	 */
	public List<ParentAccount> getParengAccountList(String moblie);
}
