package com.cnarj.ttxs.service.member;

import java.io.File;
import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Photos;
import com.cnarj.ttxs.pojo.stuz.albums;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

public interface IPhotosService extends IBaseService<Photos,String> {


	/**
	 * 增加照片 图片上传,及数据库处理
	 * @param album 照片所在的相册信息
	 * @param Filename 上传时文件名称
	 * @param filedata 文件数据
	 * @throws Exception 
	 */
	public void savePhoto(albums album,String Filename,File filedata,Member member) throws Exception;
	
	/**
	 * 获取相册中所有图片
	 * 用户查看自己的相册
	 * @param albumid
	 * @return
	 */
	public Result getPhotoList(Page page, String albumid);
	
	/**
	 * 查询照片信息,分页 1条
	 * @param photoid 照片ID
	 * @param albumid 相册ID
	 * @param index 序列
	 */
	public Result getPhotoById(String albumid,Page pager);
	
	/**
	 * 增加一个评论数
	 * @param blog
	 */
	public void updateCommentNum(String photoid);
	
	/**
	 * 删除一个图片
	 * @param albumid
	 * @param photoid
	 * @return 返回信息
	 */
	public String delPhoto(String albumid,String photoid,String memberid);


	/**************************他人空间******************************************/
	
	/**
	 * 获取相册照片
	 * @param page
	 * @param albumid
	 * @param memberid
	 * @param TTid
	 * @return
	 */
	public Result opengetPhotoList(Page page, String albumid, String memberid, String TTid);
	
	/**
	 * 获取用户最新上传的照片 查看权限以内的
	 * @param memberid
	 * @param TTid
	 * @return
	 */
	public List<Photos> opengetNewPhotos( String memberid, String TTid);
}
