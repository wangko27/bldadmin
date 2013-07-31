package com.cnarj.ttxs.web.actions.member;

import java.sql.Date;
import java.util.List;

import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;
import com.cnarj.ttxs.pojo.shop.Receiver;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.dsis.IXzqhService;
import com.cnarj.ttxs.service.member.IReceiverService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 用户Action类 - 收货地址管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class ReceiverAction extends PageAction {

	private IReceiverService receiverService;
	private IXzqhService xzqhService;
	
	private Receiver receiver;
	private List<Receiver> receiverList;
	private String memberid;
	private String receiverid;
	
	public IXzqhService getXzqhService() {		return xzqhService;	}
	public void setXzqhService(IXzqhService xzqhService) {		this.xzqhService = xzqhService;	}
	public String getReceiverid() {		return receiverid;	}
	public void setReceiverid(String receiverid) {		this.receiverid = receiverid;}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public void setReceiverList(List<Receiver> receiverList) {		this.receiverList = receiverList;	}
	public IReceiverService getReceiverService() {		return receiverService;	}
	public void setReceiverService(IReceiverService receiverService) {		this.receiverService = receiverService;	}
	public Receiver getReceiver() {		return receiver;	}
	public void setReceiver(Receiver receiver) {		this.receiver = receiver;	}
	public List<Receiver> getReceiverList() {		return receiverList;	}
	
	/**
	 * 查询收货地址
	 * @return
	 */
	public String list(){
		try{
			//查询我的所有地址
			this.receiverList = receiverService.getList("member.memberid", this.memberid);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改收货地址
	 * @return
	 */
	public String update(){
		try{

			//1 取当前时间
			Date now = new Date(System.currentTimeMillis());

			String areapath = "";
			CoChinaXzqh zqhx_province = xzqhService.get("bm",getParameter("province"));
			areapath += zqhx_province.getMc();
			areapath+=" ";
			CoChinaXzqh zqhx_city = xzqhService.get("bm", getParameter("city"));
			areapath += zqhx_city.getMc();
			areapath+=" ";
			CoChinaXzqh zqhx_county = xzqhService.get("bm",getParameter("county"));
			areapath += zqhx_county.getMc();
			
			receiver.setAreapath(areapath);
			receiver.setModifydate(now);
			
			int suc = receiverService.updReceiver(receiver, memberid);
			if(suc == 0){
				this.addActionMessage("修改后的地址已经存在，不能重复添加！");
				return ERROR;
			}

			this.addActionMessage("修改成功！");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("修改失败！");
			return ERROR;
		}
	}
	
	/**
	 * 修改之前
	 * @return
	 */
	public String updateGo(){
		try{
			// 查询行政区域
			// 查询省份
			List<CoChinaXzqh> list_province = xzqhService.listProvinceAll();
			setAttribute("list_province", list_province);
			
			StringBuffer sbpro = new StringBuffer();
			for (CoChinaXzqh pro : list_province) {
				sbpro.append("<option value=\"");
				sbpro.append(pro.getBm());
				sbpro.append("\">");
				sbpro.append(pro.getMc());
				sbpro.append("</option>");
			}
			
			return super.ajaxText(sbpro.toString());
		}catch(Exception e){
			e.printStackTrace();
			return super.ajaxText("exception");
		}
	}
	
	/**
	 * 删除收货地址
	 * @return
	 */
	public String delete(){
		try{
			this.receiverService.delReceiver(receiverid, memberid);
			
			this.addActionMessage("删除成功！");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除失败！");
			return ERROR;
		}
	}
	public void validateDelete(){
		if(this.receiverid == null || receiverid.length() == 0){
			this.addActionError("错误");
		}
	}
	
	@Override
	/**
	 * 所有的方法都要判断用户信息
	 */
	public void validate() {
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
		}
	}
}
