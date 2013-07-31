package com.cnarj.ttxs.dao.member;

import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.albums;
/**
 * 会员Dao接口 - 相册
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public interface IAlbumsDao extends IBaseDao<albums,String> {
	
	
	public Result getAlbumList(Page page,String memberid);
	
	/**
	 * 更新阅读数 +1
	 * @param blogid
	 */
	public void updateReadNum(String albumid);
	/**
	 * 增加一个评论数
	 * @param blog
	 */
	public void updateCommentNum(String albumid);
	
	/****************************他人空间***********************************/
	/**
	 * 查询好友相册列表
	 * @param page
	 * @param memberid
	 * @param powerList
	 * @return
	 */
	public Result opengetAlbumList(Page page,String memberid, List<Long> powerList);
}
