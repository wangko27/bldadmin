package com.cnarj.ttxs.web.actions.member;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleHandleRec;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;
import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IFavoritesService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * 收藏夹Action类 
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月03日
 */
@SuppressWarnings("serial")
@Validation
public class FavoritesAction extends PageAction {

	private IFavoritesService favoritesService;
	
	private String memberid;
	

	/**
	 * 查询收藏夹
	 * @return
	 */
	public String listFavoritesSrc(){
		try{
			
			//相册ID,page信息
			page.setEveryPage(CommStaticNum.PAGENUM_FAR);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			
			//查询相册中的相片信息
			result = favoritesService.getFavList(page, memberid, ReadSrcHandleRec.class);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询收藏夹失败");
			return ERROR;
		}
	}
	
	/**
	 * 查询收藏夹
	 * @return
	 */
	public String listFavoritesSA(){
		try{
			
			//相册ID,page信息
			page.setEveryPage(CommStaticNum.PAGENUM_FAR);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			
			//查询相册中的相片信息
			result = favoritesService.getFavList(page, memberid, SysArticleHandleRec.class);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询收藏夹失败");
			return ERROR;
		}
	}
	
	/**
	 * 查询收藏夹
	 * @return
	 */
	public String listFavoritesCA(){
		try{
			//相册ID,page信息
			page.setEveryPage(CommStaticNum.PAGENUM_FAR);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			
			//查询相册中的相片信息
			result = favoritesService.getFavList(page, memberid, ArticleHandleRec.class);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询收藏夹失败");
			return ERROR;
		}
	}

	public IFavoritesService getFavoritesService() {
		return favoritesService;
	}

	public void setFavoritesService(IFavoritesService favoritesService) {
		this.favoritesService = favoritesService;
	}
	
	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
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
