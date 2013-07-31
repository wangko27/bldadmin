package com.cnarj.ttxs.web.actions.shopping;

import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;
import com.cnarj.ttxs.pojo.shop.Receiver;
import com.cnarj.ttxs.service.dsis.IXzqhService;
import com.cnarj.ttxs.service.shopping.IReceiverService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

public class ReceiverAction extends PageAction implements ModelDriven<Receiver> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Receiver receiver = new Receiver();

	IReceiverService receiverService;

	IXzqhService xzqhService;

	public Receiver getModel() {
		return receiver;
	}

	public IReceiverService getReceiverService() {
		return receiverService;
	}

	public void setReceiverService(IReceiverService receiverService) {
		this.receiverService = receiverService;
	}

	public IXzqhService getXzqhService() {
		return xzqhService;
	}

	public void setXzqhService(IXzqhService xzqhService) {
		this.xzqhService = xzqhService;
	}

	/**
	 * 添加收货地址
	 * 
	 * @return
	 */
	public String add() {
		try {
			String areapath = "";
			CoChinaXzqh zqhx_province = xzqhService.get("bm",
					getParameter("province"));
			areapath += zqhx_province.getMc();
			areapath+=" ";
			CoChinaXzqh zqhx_city = xzqhService.get("bm", getParameter("city"));
			areapath += zqhx_city.getMc();
			areapath+=" ";
			CoChinaXzqh zqhx_county = xzqhService.get("bm",
					getParameter("county"));
			areapath += zqhx_county.getMc();
			receiver.setAreapath(areapath);
			receiverService.saveReceiver(receiver);
			return "deliverMode";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 修改默认地址
	 * 
	 * @return
	 */
	public String update() {
		try {
			receiverService.updateReceiverByDefault(receiver.getReceiverid());
			return "deliverMode";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 验证
	 */
	/*public void validate() {
		if (HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME) == null) {
			this.addActionError("请先登录!");
		}
	}*/

}
