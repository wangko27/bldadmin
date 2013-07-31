package com.cnarj.ttxs.dao.imp.member;

import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IBlogCommentDao;
import com.cnarj.ttxs.pojo.stuz.blogcomment;
/**
 * 会员Dao接口 - 博文留言
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public class BlogCommentDaoImpl extends BaseDaoImpl<blogcomment,String> implements IBlogCommentDao {

	public List<blogcomment> getListByDate(String blogid) {
		Assert.hasText(blogid, "blogid must not be empty");
		String hql = "from blogcomment where blog.blogid = ? order by commenteddate";
		return getSession().createQuery(hql).setParameter(0, blogid).list();
	}

}
