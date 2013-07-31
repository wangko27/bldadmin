package com.cnarj.ttxs.web.actions.dsis;

import java.io.PrintWriter;
import java.util.List;

import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;
import com.cnarj.ttxs.service.dsis.IXzqhService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

public class XzqhAction extends PageAction implements ModelDriven<CoChinaXzqh> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IXzqhService xzqhService;

	CoChinaXzqh xzqh = new CoChinaXzqh();

	public CoChinaXzqh getModel() {
		return xzqh;
	}

	public IXzqhService getXzqhService() {
		return xzqhService;
	}

	public void setXzqhService(IXzqhService xzqhService) {
		this.xzqhService = xzqhService;
	}



	/**
	 * 取得城市选项
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getCityOption() throws Exception {
		try {
			String provinceBm = getParameter("provinceBm");
			List<CoChinaXzqh> list_xzqh_city = xzqhService
					.listCityByBm(provinceBm);
			StringBuffer sbCity = new StringBuffer();
			for (CoChinaXzqh city : list_xzqh_city) {
				sbCity.append("<option value=\"");
				sbCity.append(city.getBm());
				sbCity.append("\">");
				sbCity.append(city.getMc());
				sbCity.append("</option>");
			}
			PrintWriter out = getResponse().getWriter();
			out.print(sbCity.toString());
			out.close();
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			return ERROR;
		}
	}

	/**
	 * 取得县选项
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getCountyOption() throws Exception {
		try {
			String cityBm = getParameter("cityBm");
			List<CoChinaXzqh> list_xzqh_county = xzqhService
					.listCountyByBm(cityBm);
			StringBuffer sbCounty = new StringBuffer();
			for (CoChinaXzqh county : list_xzqh_county) {
				sbCounty.append("<option value=\"");
				sbCounty.append(county.getBm());
				sbCounty.append("\">");
				sbCounty.append(county.getMc());
				sbCounty.append("</option>");
			}
			PrintWriter out = getResponse().getWriter();
			out.print(sbCounty.toString());
			out.close();
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			return ERROR;
		}
	}
}
