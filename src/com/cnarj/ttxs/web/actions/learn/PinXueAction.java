package com.cnarj.ttxs.web.actions.learn;

import com.cnarj.ttxs.service.learn.IPingXueService;
import com.cnarj.ttxs.web.actions.base.PageAction;

@SuppressWarnings("serial")
public class PinXueAction extends PageAction {

	private String type;//类型 是否为全部
	private String id;//角色// 1. 学生, 2. 家长,  3. 教师
	private IPingXueService xueService;
	private String liindex; 
	public String getLiindex() {
		return liindex;
	}
	public void setLiindex(String liindex) {
		this.liindex = liindex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public IPingXueService getXueService() {
		return xueService;
	}
	public void setXueService(IPingXueService xueService) {
		this.xueService = xueService;
	}
	public String showPinXue(){
		//设置page参数
		// 设置每页显示的条数
		page.setEveryPage(45);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		result=xueService.getAllPinXue(type, id,page);
		this.setAttribute("pins", result.getContent());
		return "pinxue";
	}
}
