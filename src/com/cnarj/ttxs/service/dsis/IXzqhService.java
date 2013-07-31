package com.cnarj.ttxs.service.dsis;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;
import com.cnarj.ttxs.service.BaseDsisService;

/**
 * 数字化校园Service接口 - 行政区号
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public interface IXzqhService extends BaseDsisService<CoChinaXzqh, String> {
	/**
	 * 查询所有省份
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CoChinaXzqh> listProvinceAll() throws Exception;

	/**
	 * 根据省份查询城市
	 * 
	 * @param provinceBm
	 *            省份编码
	 * @return
	 * @throws Exception
	 */
	public List<CoChinaXzqh> listCityByBm(String provinceBm) throws Exception;

	/**
	 * 根据城市查询县
	 * 
	 * @param cityBm
	 *            城市编码
	 * @return
	 * @throws Exception
	 */
	public List<CoChinaXzqh> listCountyByBm(String cityBm) throws Exception;
}
