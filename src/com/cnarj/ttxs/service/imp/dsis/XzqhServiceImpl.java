package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.dsis.IXzqhDao;
import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;
import com.cnarj.ttxs.service.dsis.IXzqhService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;

/**
 * 数字化校园Service实现类 - 行政区号
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public class XzqhServiceImpl extends BaseDsisServiceImpl<CoChinaXzqh, String>
		implements IXzqhService {

	IXzqhDao xzqhDao;

	public IXzqhDao getXzqhDao() {
		return xzqhDao;
	}

	public void setXzqhDao(IXzqhDao xzqhDao) {
		this.xzqhDao = xzqhDao;
	}

	public List<CoChinaXzqh> listCityByBm(String provinceBm) throws Exception {
		return xzqhDao.listCityByBm(provinceBm);
	}

	public List<CoChinaXzqh> listCountyByBm(String cityBm) throws Exception {
		return xzqhDao.listCountyByBm(cityBm);
	}

	public List<CoChinaXzqh> listProvinceAll() throws Exception {
		return xzqhDao.listProvinceAll();
	}

}
