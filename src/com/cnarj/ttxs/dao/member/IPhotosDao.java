package com.cnarj.ttxs.dao.member;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Photos;
/**
 * 空间Dao接口 - 照片
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public interface IPhotosDao extends IBaseDao<Photos,String> {

	/**
	 * 获取相册中所有图片
	 * 用户查看自己的相册
	 * @param albumid
	 * @return
	 */
	public Result getPhotoList(Page page,String albumid);
	
	/**
	 * 查询相册图片
	 * @param albumid
	 * @param pager
	 * @return
	 */
	public Result getPhotoById(String albumid, Page pager);
	/**
	 * 增加一个评论数
	 * @param blog
	 */
	public void updateCommentNum(String photoid);
	

	/**************************他人空间******************************************/
	
	/**
	 * 查询用户最新上传的照片 权限判断
	 * @param memberid
	 * @param powerList
	 * @return
	 */
	public List opengetNewPhotos(String memberid,List powerList);
	
}
