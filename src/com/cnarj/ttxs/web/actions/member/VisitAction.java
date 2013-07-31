package com.cnarj.ttxs.web.actions.member;

import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.service.member.IVisitService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;
import com.cnarj.ttxs.pojo.user.Member;

/**
 * 用户Action类 - 访问脚步
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class VisitAction extends PageAction {

	private IVisitService visitService;
	
	private List<ZoneVisits> visitList;
	private String memberid;
	private int visittype;
	
	public int getVisittype() {		return visittype;	}
	public void setVisittype(int visittype) {		this.visittype = visittype;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public List<ZoneVisits> getVisitList() {		return visitList;	}
	public void setVisitList(List<ZoneVisits> visitList) {		this.visitList = visitList;	}
	public IVisitService getVisitService() {		return visitService;	}
	public void setVisitService(IVisitService visitService) {		this.visitService = visitService;	}

	/**
	 * 我看过的
	 * @return
	 */
	public String visitOther(){
		try{
			//page信息
			page.setEveryPage(CommStaticNum.PAGENUM_VISIT);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			//查询
			result = visitService.getVisitOther(page, memberid);
			this.visitList = result.getContent();
			
			this.visittype = 1;
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 看过我的
	 * @return
	 */
	public String visitMe(){
		try{

			//page信息
			page.setEveryPage(CommStaticNum.PAGENUM_VISIT);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			this.visittype = 2;
			
			//查询
			result = visitService.getVisitMe(page, memberid);
			this.visitList = result.getContent();
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
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
