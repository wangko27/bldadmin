package com.cnarj.ttxs.dao.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.dsis.IXzqhDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;

/**
 * 数字化校园Dao接口实现类 - 行政区号
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public class XzqhDaoImpl extends BaseDaoDsisImpl<CoChinaXzqh, String> implements
		IXzqhDao {

	@SuppressWarnings("unchecked")
	public List<CoChinaXzqh> listCityByBm(String provinceBm) throws Exception {
		String hql = "from CoChinaXzqh where bm like '" + provinceBm
				+ "__' order by bm";
		return this.getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<CoChinaXzqh> listCountyByBm(String cityBm) throws Exception {
		String hql = "from CoChinaXzqh where bm like '" + cityBm
				+ "__'  order by bm";
		return this.getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<CoChinaXzqh> listProvinceAll() throws Exception {
		String hql = "from CoChinaXzqh where length(bm)=2 order by bm";
		return this.getSession().createQuery(hql).list();
	}

}
