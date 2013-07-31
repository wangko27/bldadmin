package com.cnarj.ttxs.web.actions.member;

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
import com.cnarj.ttxs.service.member.IAlbumCommentService;
import com.cnarj.ttxs.service.member.IAlbumsService;
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
 * 用户Action类 - 相册
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
@SuppressWarnings("serial")
@Validation
public class AlbumsAction extends PageAction {

	private IAlbumsService albumsService;
	private IPhotosService photosService;
	private IAlbumCommentService albumCommentService;
	private IPhotoCommentService photoCommentService;
	
	private albums album;
	private String albumid;
	private List<albums> albumList;
	private List<Albumcomment> albumComList;
	private List<Photocomment> photoComList;
	private String comcontent;
	private String comid;
	private String photoid;
	private String gotoPagephoto;
	private String albumid_p;
	
	private File filedata;
	private String Filename;
	
	private String memberid;


	
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public List<Photocomment> getPhotoComList() {		return photoComList;	}
	public void setPhotoComList(List<Photocomment> photoComList) {		this.photoComList = photoComList;	}
	public IPhotoCommentService getPhotoCommentService() {		return photoCommentService;	}
	public void setPhotoCommentService(IPhotoCommentService photoCommentService) {		this.photoCommentService = photoCommentService;	}
	public String getAlbumid_p() {		return albumid_p;	}
	public void setAlbumid_p(String albumid_p) {		this.albumid_p = albumid_p;	}
	public String getGotoPagephoto() {		return gotoPagephoto;	}
	public void setGotoPagephoto(String gotoPagephoto) {		this.gotoPagephoto = gotoPagephoto;	}
	public String getPhotoid() {		return photoid;	}
	public void setPhotoid(String photoid) {		this.photoid = photoid;	}
	public String getComcontent() {		return comcontent;	}
	public void setComcontent(String comcontent) {		this.comcontent = comcontent;	}
	public String getComid() {		return comid;	}
	public void setComid(String comid) {		this.comid = comid;	}
	public IAlbumCommentService getAlbumCommentService() {		return albumCommentService;	}
	public void setAlbumCommentService(IAlbumCommentService albumCommentService) {		this.albumCommentService = albumCommentService;	}
	public List<Albumcomment> getAlbumComList() {		return albumComList;	}
	public void setAlbumComList(List<Albumcomment> albumComList) {		this.albumComList = albumComList;	}
	public IPhotosService getPhotosService() {		return photosService;	}
	public void setPhotosService(IPhotosService photosService) {		this.photosService = photosService;	}
	public List<albums> getAlbumList() {		return albumList;	}
	public void setAlbumList(List<albums> albumList) {		this.albumList = albumList;	}
	public File getFiledata() {		return filedata;	}
	public void setFiledata(File filedata) {		this.filedata = filedata;	}
	public String getFilename() {		return Filename;	}
	public void setFilename(String filename) {		Filename = filename;	}
	public IAlbumsService getAlbumsService() {		return albumsService;	}
	public void setAlbumsService(IAlbumsService albumsService) {		this.albumsService = albumsService;}
	public albums getAlbum() {		return album;	}
	public void setAlbum(albums album) {		this.album = album;	}
	public String getAlbumid() {		return albumid;	}
	public void setAlbumid(String albumid) {		this.albumid = albumid;	}
	
	/**
	 * 增加相册
	 * @return
	 */
	@Validations( 
			requiredStrings={ 
					@RequiredStringValidator(fieldName="album.albumname",message="相册名称不能为空!",trim = true)
					},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="album.albumname",
							message = "相册名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "64"),
					@StringLengthFieldValidator(fieldName="album.albumnotes",
							message = "相册信息长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256")
					}
				) 
	public String addAlbum(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}
			
			
			//判断是否重名,根据用户名+相册名称
			Hashtable hash = new Hashtable();
			hash.put("member.memberid", memberid);
			hash.put("albumname", album.getAlbumname());
			boolean isexist = albumsService.isExist(hash);
			if(isexist){
				this.addActionMessage("该相册已经存在!");
				return ERROR;
			}
			
			//添加相册
			albumsService.saveAlbum(album,memberid);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败,请重试!");
			return ERROR;
		}
	}
	
	/**
	 * 编辑相册
	 * @return
	 */
	@Validations( 
			requiredStrings={ 
					@RequiredStringValidator(fieldName="album.albumname",message="相册名称不能为空!",trim = true)
					},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="album.albumname",
							message = "相册名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "64"),
					@StringLengthFieldValidator(fieldName="album.albumnotes",
							message = "相册信息长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256")
					}
				) 
	public String editAlbum(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}
			
			albumsService.updateAlbum(album);
			return SUCCESS;
			}catch(Exception e){
				e.printStackTrace();
				this.addActionMessage("修改失败,请重试");
				return ERROR;
			}
	}
	
	/**
	 * 跳转到编辑相册
	 * @return
	 */
	public String upEdit(){
		try{
			if(null == this.albumid || this.albumid.length() == 0){
				LogUtil.logger.error("跳转到编辑相册页面失败,未传入必须的相册主键!!");
				this.addActionMessage("抱歉出错了!");
				return ERROR;
			}
			this.album = albumsService.load(this.albumid);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("操作失败,请稍后重试..");
			return ERROR;
		}
	}
	
	/**
	 * 删除相册
	 * @return
	 */
	public String delAlbum(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("请登录!!");
				return ERROR;
			}
			
			albumsService.delAlbum(albumid, memberid);
			this.addActionMessage("删除成功");
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除失败");
			return ERROR;
		}
	}
	
	/**
	 * 相册列表
	 * @return
	 */
	public String listAlbum(){
		try{	
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}
			
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ALBUM);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = this.albumsService.getAlbumList(page, memberid);
			
			//查询数据
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获得数据失败,请稍后重试...");
			return ERROR;
		}
	}
	
	/**
	 * 发布图片
	 * @return
	 */
	public String addPhoto(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("请登录!!");
				return ERROR;
			}
			
			Member m = new Member();
			m.setMemberid(memberid);
			m.setNikename(nikename);

			//根据用户ID+相册ID,查询相册信息
			Hashtable table = new Hashtable();
			table.put("member.memberid", memberid);
			table.put("albumid", albumid);
			
			album = albumsService.get(table);
			if(null == album){
				LogUtil.logger.error("类:"+this.getClass().getName()+";方法:addPhoto"+";信息:用户ID没有匹配的相册信息.");
				this.addActionMessage("错误!");
				return ERROR;
			}
			
			photosService.savePhoto(album, Filename, filedata,m);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 跳转到发布图片页面
	 * @return
	 */
	public String toAddPhoto(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}
			
			//获取用户的相册列表 ALL
			albumList = albumsService.getList("member.memberid", memberid);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 相册中的图片列表 自己的
	 * @return
	 */
	public String listPhotos(){
		try{
			//相册ID,page信息
			page.setEveryPage(CommStaticNum.PAGENUM_PHOTO);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			
			//加载相册信息
			this.album = albumsService.get(albumid);
			
			//查询相册中的相片信息
			result = photosService.getPhotoList(page, albumid);
			
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
	 * 发表留言
	 * @return
	 */
	public void addAlbumComment(){
		try{
			//取会员信息
			Member m = new Member();
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			Long memberType = (Long)super.getSession(Member.LOGIN_MEMBER_TYPE);
			String headpath = (String)super.getSession(Member.LOGIN_MEMBER_HEADPATH);
			
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				super.ajaxHtml("exception");
				return;
			}
			m.setMemberid(memberid);
			m.setNikename(nikename);
			m.setMemberType(memberType);
			m.setHeadpath(headpath);
			
			
			String html = albumCommentService.saveCommentHtml(this.albumid, m,super.getRequest().getRemoteAddr(),this.comcontent,this.comid);
			
			//增加一个留言量
			albumsService.updateCommentNum(this.albumid);
			
			super.ajaxHtml(html);
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("发布留言失败");
		}
	}
	
	/**
	 * 图片详情展示
	 * @return
	 */
	public String getPhotoDetail(){
		try{
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

	/**
	 * 发表相片留言
	 * @return
	 */
	public void addPhotoComment(){
		try{
			//取会员信息
			Member m = new Member();
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			Long memberType = (Long)super.getSession(Member.LOGIN_MEMBER_TYPE);
			String headpath = (String)super.getSession(Member.LOGIN_MEMBER_HEADPATH);
			
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				super.ajaxHtml("exception");
				return;
			}
			m.setMemberid(memberid);
			m.setNikename(nikename);
			m.setMemberType(memberType);
			m.setHeadpath(headpath);
			
			
			String html = photoCommentService.saveCommentHtml(this.photoid, m,super.getRequest().getRemoteAddr(),this.comcontent,this.comid);
			
			//增加一个留言量
			photosService.updateCommentNum(this.photoid);
			
			super.ajaxHtml(html);
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("发布留言失败");
		}
	}
	
	/**
	 * 删除照片
	 * @return
	 */
	public String delPhoto(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("请登录!!");
				return ERROR;
			}
			
			String restr = photosService.delPhoto(albumid,photoid,memberid);
			this.albumid_p = albumid;
			this.addActionMessage(restr);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除照片失败");
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
