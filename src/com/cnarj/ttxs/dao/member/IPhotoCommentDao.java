package com.cnarj.ttxs.dao.member;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.stuz.Photocomment;
/**
 * 空间service接口类 - 照片留言
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月29日19:25:37
 */
public interface IPhotoCommentDao extends IBaseDao<Photocomment,String> {

	/**
	 * 查询照片的留言,并按时间排序
	 * @param photoid 照片ID
	 * @return
	 */
	public List<Photocomment> getListByDate(String photoid) ;
}
