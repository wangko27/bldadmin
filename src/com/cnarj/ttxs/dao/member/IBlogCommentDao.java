package com.cnarj.ttxs.dao.member;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.stuz.blogcomment;
/**
 * 空间Dao接口 - 博文评论
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public interface IBlogCommentDao extends IBaseDao<blogcomment,String> {

	public List<blogcomment> getListByDate(String blogid);
}
