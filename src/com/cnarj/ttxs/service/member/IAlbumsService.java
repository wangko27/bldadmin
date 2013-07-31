package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.stuz.Photos;
import com.cnarj.ttxs.pojo.stuz.albums;
import com.cnarj.ttxs.service.IBaseService;
/**
 * 会员service接口 - 相册
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public interface IAlbumsService extends IBaseService<albums,String> {
	
	/**
	 * 增加相册
	 * @param album
	 * @param memberid
	 */
	public void saveAlbum(albums album,String memberid);
	
	/**
	 * 修改相册
	 * @param album
	 */
	public void updateAlbum(albums album);
	
	/**
	 * 用户查询自己的相册列表
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getAlbumList(Page page,String memberid);
	
	/**
	 * 用户注册时生成默认相册
	 * @param memberid
	 */
	public void saveAlbumDefault(String memberid);

	/**
	 * 增加一个阅读数
	 * @param blog
	 */
	public void updateReadNum(albums album);
	
	/**
	 * 增加一个评论数
	 * @param blog
	 */
	public void updateCommentNum(String albumid);
	
	/**
	 * 删除相册
	 * @param albumid
	 * @param memberid
	 * @return
	 */
	public boolean delAlbum(String albumid,String memberid);
	
	

	/**************************他人空间******************************************/
	
	/**
	 * 查询相册列表
	 * @param page
	 * @param memberid
	 * @param TTid
	 * @return
	 */
	public Result opengetAlbumList(Page page,String memberid,String TTid);
}
