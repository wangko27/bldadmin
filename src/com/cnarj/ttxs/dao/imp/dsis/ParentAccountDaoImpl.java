package com.cnarj.ttxs.dao.imp.dsis;

import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.ParentAccountDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.ParentAccount;

/**
 * 家长账户接口实现类
 * @author Administrator
 *
 */
public class ParentAccountDaoImpl extends BaseDaoDsisImpl<ParentAccount, Long> implements ParentAccountDao{

	
	@SuppressWarnings("unchecked")
	public List<ParentAccount> getParengAccountList(String moblie) {
		Assert.notNull(moblie,"moblie is required");
		String hql = " from ParentAccount p where 1=1 and p.accountName = ? ";
		return getSession().createQuery(hql).setParameter(0, moblie).list();
	}

}
