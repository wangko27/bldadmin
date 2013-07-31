package com.cnarj.ttxs.service.imp.member;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.dao.member.IActionRecDao;
import com.cnarj.ttxs.dao.member.IAlbumCommentDao;
import com.cnarj.ttxs.dao.member.IAlbumsDao;
import com.cnarj.ttxs.dao.member.IFriendsInfoDao;
import com.cnarj.ttxs.dao.member.IPhotoCommentDao;
import com.cnarj.ttxs.dao.member.IPhotosDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.stuz.Photos;
import com.cnarj.ttxs.pojo.stuz.albums;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IAlbumsService;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.LogUtil;
/**
 * 会员service接口实现类 - 相册
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public class AlbumsServiceImpl extends BaseServiceImpl<albums,String> implements
		IAlbumsService {

	private IAlbumsDao albumsDao;
	private IPhotosDao photosDao;
	private IPhotoCommentDao photoCommentDao;
	private IAlbumCommentDao albumCommentDao;
	private IFriendsInfoDao friendDao;
	private IActionRecDao actionRecDao;
	
	
	public IActionRecDao getActionRecDao() {
		return actionRecDao;
	}

	public void setActionRecDao(IActionRecDao actionRecDao) {
		this.actionRecDao = actionRecDao;
	}

	public IFriendsInfoDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(IFriendsInfoDao friendDao) {
		this.friendDao = friendDao;
	}

	public IPhotosDao getPhotosDao() {
		return photosDao;
	}

	public void setPhotosDao(IPhotosDao photosDao) {
		this.photosDao = photosDao;
	}

	public IPhotoCommentDao getPhotoCommentDao() {
		return photoCommentDao;
	}

	public void setPhotoCommentDao(IPhotoCommentDao photoCommentDao) {
		this.photoCommentDao = photoCommentDao;
	}

	public IAlbumCommentDao getAlbumCommentDao() {
		return albumCommentDao;
	}

	public void setAlbumCommentDao(IAlbumCommentDao albumCommentDao) {
		this.albumCommentDao = albumCommentDao;
	}

	public IAlbumsDao getAlbumsDao() {
		return albumsDao;
	}

	public void setAlbumsDao(IAlbumsDao albumsDao) {
		this.albumsDao = albumsDao;
	}

	public void setBaseDao(IAlbumsDao albumsDao) {
		super.setBaseDao(albumsDao);
	}
	
	public void saveAlbum(albums album,String memberid){
		//准备数据
		Member m = new Member();
		m.setMemberid(memberid);
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		//组织数据
		album.setMember(m);
		album.setCreatedate(now);
		album.setCommentnum(Long.parseLong("0"));
		album.setPhotonum(Long.parseLong("0"));
		album.setReadnum(Long.parseLong("0"));
		album.setAlbumpath("userspacefile/"+memberid+"/album/"+album.getAlbumname());
		album.setIsdefault("0");
		
		//记录数据
		albumsDao.save(album);
	}
	
	public void updateAlbum(albums album){

		//获取原始相册信息
		albums tempalbum = albumsDao.get(album.getAlbumid());
		
		if(null == tempalbum){
			LogUtil.logger.error("类名:"+this.getClass().getName()+" 方法名:updateAlbum " +
			"将要修改的相册在数据库中不存在!!");
		}
		
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		//设置数据
		tempalbum.setModifydate(now);
		tempalbum.setAlbumname(album.getAlbumname());
		tempalbum.setAlbumnotes(album.getAlbumnotes());
		tempalbum.setViewperm(album.getViewperm());
		
		//修改
		albumsDao.update(tempalbum);
	}
	
	public Result getAlbumList(Page page,String memberid) {

		return albumsDao.getAlbumList(page, memberid);
	}
	
	/**
	 * 生成用户默认相册
	 * @param memberid
	 */
	public void saveAlbumDefault(String memberid){
		//准备数据
		Member m = new Member();
		m.setMemberid(memberid);
		
		Date now = new Date(System.currentTimeMillis());
		
		albums alb = new albums();
		alb.setAlbumname("默认相册");
		alb.setAlbumnotes("默认相册");
		alb.setAlbumpath("userspacefile/"+memberid+"/album/default");
		alb.setCommentnum(Long.parseLong("0"));
		alb.setPhotonum(Long.parseLong("0"));
		alb.setReadnum(Long.parseLong("0"));
		alb.setCreatedate(now);
		alb.setIsdefault("1");
		alb.setMember(m);
		alb.setViewperm(Long.parseLong("1"));//所有人

		//记录数据
		albumsDao.save(alb);
	}
	
	/**
	 * 删除用户相册
	 * @param albumid 相册ID
	 * @param memberid 用户ID
	 * @return
	 */
	public boolean delAlbum(String albumid,String memberid){
		//根据用户ID+相册ID,查询相册
		Hashtable table = new Hashtable();
		table.put("member.memberid", memberid);
		table.put("albumid", albumid);
		
		albums al = albumsDao.get(table);
		
		if(null == al){
			LogUtil.logger.error("类名:"+this.getClass().getName()+" 方法名:delAlbum " +
					"错误信息:当前用户和要删除的相册不相匹配!");
			return false;
		}

		//处理相册文件夹
		File file = new File(al.getAlbumpath());
		FileOperate.deleteDirectoryAndFile(file);
		
		//删除数据
		//1.删除相片记录,相片评论,相册评论
		//①得到相片List
		List<Photos> ph = photosDao.getList("albums.albumid", al.getAlbumid());
		//②循环删除相片及评论及添加相片的动作
		for(Photos p : ph){
			table = new Hashtable();
			table.put("photos.photoid", p.getPhotoid());
			photoCommentDao.delete(table);
			
			table = new Hashtable();
			table.put("photo.photoid", p.getPhotoid());
			actionRecDao.delete(table);

			photosDao.delete(p);
		}
		//④删除相册评论
		table = new Hashtable();
		table.put("albums.albumid", al.getAlbumid());
		albumCommentDao.delete(table);
		//⑤删除添加相册的记录
		table = new Hashtable();
		table.put("album.albumid", al.getAlbumid());
		actionRecDao.delete(table);
		
		//2.删除相册信息
		albumsDao.delete(al);

		
		return true;
	}

	/**
	 * 更新相册留言数量
	 */
	public void updateCommentNum(String albumid) {
		// TODO Auto-generated method stub
		albumsDao.updateCommentNum(albumid);
	}

	/**
	 * 更新相册阅读数量
	 */
	public void updateReadNum(albums album) {
		// TODO Auto-generated method stub
		albumsDao.updateReadNum(album.getAlbumid());
	}
	

	/**************************他人空间******************************************/

	public Result opengetAlbumList(Page page, String memberid, String TTid) {

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
		
		return albumsDao.opengetAlbumList(page, TTid, powerList);
	}
}
