package com.cnarj.ttxs.dao.member;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.stuz.Albumcomment;
/**
 * 空间Dao接口 - 相册评论
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public interface IAlbumCommentDao extends IBaseDao<Albumcomment,String> {
	
	/**
	 * 查询相册的留言,并按时间排序
	 * @param albumid 相册ID
	 * @return
	 */
	public List<Albumcomment> getListByDate(String albumid) ;
}
