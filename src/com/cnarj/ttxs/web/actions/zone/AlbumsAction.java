package com.cnarj.ttxs.web.actions.zone;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.stuz.Albumcomment;
import com.cnarj.ttxs.pojo.stuz.Photocomment;
import com.cnarj.ttxs.pojo.stuz.Photos;
import com.cnarj.ttxs.pojo.stuz.albums;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.member.IAlbumCommentService;
import com.cnarj.ttxs.service.member.IAlbumsService;
import com.cnarj.ttxs.service.member.IFriendsInfoService;
import com.cnarj.ttxs.service.member.IPhotoCommentService;
import com.cnarj.ttxs.service.member.IPhotosService;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
/**
 * 他人空间Action类 - 相册
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
@SuppressWarnings("serial")
public class AlbumsAction extends PageAction {

	private IAlbumsService albumsService;
	private IPhotosService photosService;
	private IAlbumCommentService albumCommentService;
	private IPhotoCommentService photoCommentService;
	private IFriendsInfoService friendService;
	private MemberService memberService;
	
	private albums album;
	private String albumid;
	private List<albums> albumList;
	private List<Albumcomment> albumComList;
	private List<Photocomment> photoComList;
	private String gotoPagephoto;
	private String albumid_p;
	
	private String TTid;//所访问的用户Id 
	private Member TTUser;//所访问的用户对象
	private boolean friendsign = false;//是否已是好友标志
	
	public boolean isFriendsign() {		return friendsign;	}
	public void setFriendsign(boolean friendsign) {		this.friendsign = friendsign;	}
	public MemberService getMemberService() {		return memberService;	}
	public void setMemberService(MemberService memberService) {		this.memberService = memberService;	}
	public IFriendsInfoService getFriendService() {		return friendService;	}
	public void setFriendService(IFriendsInfoService friendService) {		this.friendService = friendService;	}
	public String getTTid() {	return TTid;	}
	public void setTTid(String tid) {		TTid = tid;	}
	public Member getTTUser() {		return TTUser;	}
	public void setTTUser(Member user) {		TTUser = user;	}
	public IAlbumsService getAlbumsService() {		return albumsService;	}
	public void setAlbumsService(IAlbumsService albumsService) {		this.albumsService = albumsService;	}
	public IPhotosService getPhotosService() {		return photosService;	}
	public void setPhotosService(IPhotosService photosService) {		this.photosService = photosService;	}
	public IAlbumCommentService getAlbumCommentService() {		return albumCommentService;	}
	public void setAlbumCommentService(IAlbumCommentService albumCommentService) {		this.albumCommentService = albumCommentService;	}
	public IPhotoCommentService getPhotoCommentService() {		return photoCommentService;	}
	public void setPhotoCommentService(IPhotoCommentService photoCommentService) {	this.photoCommentService = photoCommentService;	}
	public albums getAlbum() {		return album;}
	public void setAlbum(albums album) {		this.album = album;	}
	public String getAlbumid() {		return albumid;	}
	public void setAlbumid(String albumid) {		this.albumid = albumid;	}
	public List<albums> getAlbumList() {		return albumList;	}
	public void setAlbumList(List<albums> albumList) {		this.albumList = albumList;	}
	public List<Albumcomment> getAlbumComList() {		return albumComList;	}
	public void setAlbumComList(List<Albumcomment> albumComList) {		this.albumComList = albumComList;	}
	public List<Photocomment> getPhotoComList() {		return photoComList;	}
	public void setPhotoComList(List<Photocomment> photoComList) {		this.photoComList = photoComList;	}
	public String getGotoPagephoto() {		return gotoPagephoto;	}
	public void setGotoPagephoto(String gotoPagephoto) {		this.gotoPagephoto = gotoPagephoto;	}
	public String getAlbumid_p() {		return albumid_p;	}
	public void setAlbumid_p(String albumid_p) {		this.albumid_p = albumid_p;	}

	/**
	 * 相册列表
	 * @return
	 */
	public String listAlbum(){
		try{	
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ALBUM);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = this.albumsService.opengetAlbumList(page, memberid, TTid);
			
			//查询数据
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获得数据失败,请稍后重试...");
			return ERROR;
		}
	}
	
	
	/**
	 * 相册中的图片列表 可以看的
	 * @return
	 */
	public String listPhotos(){
		try{			
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			
			//相册ID,page信息
			page.setEveryPage(CommStaticNum.PAGENUM_PHOTO);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			
			//查询相册中的相片信息
			result = photosService.opengetPhotoList(page, albumid, memberid, TTid);
			if(null == result){
				this.addActionMessage("获取相册图片失败!无权限！");
				return ERROR;
			}

			//加载相册信息
			this.album = albumsService.get(albumid);
			
			//相册留言内容
			this.albumComList = this.albumCommentService.getListByAlbum(albumid);
		
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获取相册图片失败!");
			return ERROR;
		}
	}

	/**
	 * 图片详情展示
	 * @return
	 */
	public String getPhotoDetail(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			
			//相册ID,page信息
			page.setEveryPage(CommStaticNum.PAGENUM_PHOTODETAIL);
			// 根据statePage进行Page对象设置，并查询
			gotoPage = gotoPagephoto;
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			
			//加载相册信息
			this.album = albumsService.get(albumid_p);

			//2 判断用户是否有权限
			if(album.getViewperm() == 3){//仅自己
				this.addActionMessage("无权限查看!");
				return ERROR;
			}
			else if(album.getViewperm() == 2){//所有好友
				//判断是否是他人好友 他人ID+自己ID
				if(memberid != null && memberid.length() > 0){
					Hashtable table = new Hashtable();
					table.put("memberByUserid.memberid", TTid);
					table.put("memberByFrienduserid.memberid", memberid);
					
					boolean isfri = friendService.isExist(table);
					
					if(!isfri){
						this.addActionMessage("无权限查看!");
						return ERROR;
					}
				}
			}
			
			//查询相册中的相片信息
			result = photosService.getPhotoList(page, albumid_p);

			//照片留言内容
			this.photoComList = this.photoCommentService.getListByPhoto(((Photos)result.getContent().get(0)).getPhotoid());
		
		
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("错误!");
			return ERROR;
		}
	}
	
	@Override
	/**
	 * 所有的方法都要判断他人用户信息
	 */
	public void validate() {
		if(this.TTid == null || this.TTid.length() == 0){
			this.addActionError("错误！需指定他人ID");
		}
		else{
			if(null == TTUser){
				TTUser = memberService.get(this.TTid);
				
				String mid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
				if(null != mid && mid.length() > 0){

					//判断是否是好友
					Hashtable table = new Hashtable();
					table.put("memberByUserid.memberid", mid);
					table.put("memberByFrienduserid.memberid", TTid);
					
					this.friendsign = this.friendService.isExist(table);
				}
				
			}
		}
	}
}
