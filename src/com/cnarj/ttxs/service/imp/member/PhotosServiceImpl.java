package com.cnarj.ttxs.service.imp.member;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.dao.member.IActionRecDao;
import com.cnarj.ttxs.dao.member.IAlbumsDao;
import com.cnarj.ttxs.dao.member.IFriendsInfoDao;
import com.cnarj.ttxs.dao.member.IPhotoCommentDao;
import com.cnarj.ttxs.dao.member.IPhotosDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.stuz.Photos;
import com.cnarj.ttxs.pojo.stuz.albums;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IPhotosService;
import com.cnarj.ttxs.util.FileOperate;

public class PhotosServiceImpl extends BaseServiceImpl<Photos,String> implements IPhotosService {

	private IPhotosDao photosDao;
	private IAlbumsDao albumsDao;
	private IPhotoCommentDao photoCommentDao;
	private IActionRecDao actionRecDao;
	private IFriendsInfoDao friendDao;
	

	public IFriendsInfoDao getFriendDao() {
		return friendDao;
	}
	public void setFriendDao(IFriendsInfoDao friendDao) {
		this.friendDao = friendDao;
	}
	public IActionRecDao getActionRecDao() {
		return actionRecDao;
	}
	public void setActionRecDao(IActionRecDao actionRecDao) {
		this.actionRecDao = actionRecDao;
	}
	public IPhotoCommentDao getPhotoCommentDao() {
		return photoCommentDao;
	}
	public void setPhotoCommentDao(IPhotoCommentDao photoCommentDao) {
		this.photoCommentDao = photoCommentDao;
	}
	public void setBaseDao(IPhotosDao photosDao) {
		super.setBaseDao(photosDao);
	}
	public IPhotosDao getPhotosDao() {
		return photosDao;
	}
	public void setPhotosDao(IPhotosDao photosDao) {
		this.photosDao = photosDao;
	}
	public IAlbumsDao getAlbumsDao() {
		return albumsDao;
	}
	public void setAlbumsDao(IAlbumsDao albumsDao) {
		this.albumsDao = albumsDao;
	}
	
	
	public void savePhoto(albums album,String Filename,File filedata,Member member) throws Exception {

		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		String realname = FileOperate.generateFileName(Filename);
		//上传图片
		FileOperate.fileUpload(filedata,null,null,album.getAlbumpath()+"/",realname);
		
		//处理数据库
		Photos ph = new Photos();
		ph.setAlbums(album);
		ph.setCreatedate(now);
		ph.setPhotoname(Filename.substring(0,Filename.indexOf(".")));
		ph.setPhotopath(album.getAlbumpath()+"/"+realname);
		photosDao.save(ph);
		
		//记录封面图片 增加照片计数
		if(null == album.getAlbumcoverpath() || album.getAlbumcoverpath().length() == 0){
			//上传封面照片，第一次上传的照片作为封面照片
			//上传图片
			FileOperate.fileUpload(filedata,null,null,album.getAlbumpath()+"/","cover.jpg");
			
			album.setAlbumcoverpath(album.getAlbumpath()+"/"+"cover.jpg");
		}

//		//记录封面图片 增加照片计数
//		//上传封面照片，最新上传的照片作为封面照片
//		//上传图片
//		FileOperate.fileUpload(filedata,null,null,album.getAlbumpath()+"/","cover.jpg");
		
		album.setAlbumcoverpath(album.getAlbumpath()+"/"+"cover.jpg");

		
		album.setPhotonum(album.getPhotonum()+1);
		albumsDao.update(album);
		
		
		//记录上传相片的动作
		ActionRec actionrec = new ActionRec();
		actionrec.setActiondate(now);
		actionrec.setActionpath1("myspace/comm/photoOfAlbum.action?albumid="+album.getAlbumid());//相册路径
		actionrec.setActionpath2("myspace/comm/photoDetail.action?albumid_p="+album.getAlbumid());//相片路径
		actionrec.setActiontitle("上传照片到相册：");
		actionrec.setActiontype(new Long(1));
		actionrec.setAlbum(album);
		actionrec.setPhoto(ph);
		actionrec.setMember(member);
		actionrec.setUsername(member.getNikename());
		actionrec.setOtheractionpath1("Zone/photoOfAlbum.action?albumid="+album.getAlbumid()+"&TTid="+member.getMemberid());
		actionrec.setOtheractionpath2("Zone/photoDetail.action?albumid_p="+album.getAlbumid()+"&TTid="+member.getMemberid());
		
		actionRecDao.save(actionrec);
		
	}
	
	public Result getPhotoList(Page page, String albumid) {
		// TODO Auto-generated method stub
		return photosDao.getPhotoList(page, albumid);
	}
	public Result getPhotoById(String albumid, Page pager) {
		return photosDao.getPhotoById( albumid,  pager);
	}
	public void updateCommentNum(String photoid) {
		photosDao.updateCommentNum(photoid);
		
	}
	public String delPhoto(String albumid, String photoid,String memberid) {
		//查询要删除的图片
		Hashtable table = new Hashtable();
		table.put("photoid", photoid);
		table.put("albums.albumid", albumid);
		Photos a = photosDao.get(table);
		
		if(null == a){
			return "相册和照片不匹配!";
		}
		
		//1.删除留言
		table = new Hashtable();
		table.put("photos.photoid", photoid);
		photoCommentDao.delete(table);
		
		//2.删除文件夹中的图片
		FileOperate.deleteFile(a.getPhotopath());
		
		//3.删除发布照片的动作记录
		table = new Hashtable();
		table.put("photo.photoid", photoid);
		actionRecDao.delete(table);
		
		//4.修改相册中照片张数
		albums alb = a.getAlbums();
		alb.setPhotonum(alb.getPhotonum() - 1);
		albumsDao.update(alb);
		
		//删除图片
		photosDao.delete(a);
		
		return "删除照片成功!";
	}

	/**************************他人空间******************************************/

	
	public Result opengetPhotoList(Page page, String albumid, String memberid, String TTid) {

		//1 加载相册信息
		albums album = albumsDao.get(albumid);
		
		//2 判断用户是否有权限
		if(album.getViewperm() == 3){//仅自己
			return null;
		}
		else if(album.getViewperm() == 2){//所有好友
			//判断是否是他人好友 他人ID+自己ID
			if(memberid != null && memberid.length() > 0){
				Hashtable table = new Hashtable();
				table.put("memberByUserid.memberid", TTid);
				table.put("memberByFrienduserid.memberid", memberid);
				
				boolean isfri = friendDao.isExist(table);
				
				if(!isfri){
					return null;//非好友
				}
			}
		}
		
		//3 查询照片信息
		return getPhotoList(page,albumid);
	}
	
	public List<Photos> opengetNewPhotos( String memberid, String TTid){

		//浏览权限List
		List<Long> powerList = new ArrayList<Long>();
		powerList.add(new Long("1"));//所有人可看权限

		//判断是否是他人好友 他人ID+自己ID
		if(memberid != null && memberid.length() > 0){
			Hashtable table = new Hashtable();
			table.put("memberByUserid.memberid", TTid);
			table.put("memberByFrienduserid.memberid", memberid);
			
			boolean isfri = friendDao.isExist(table);
			if(isfri){
				powerList.add(new Long("2"));//仅好友
			}
		}
		
		return photosDao.opengetNewPhotos(TTid, powerList);
	}
	
}
