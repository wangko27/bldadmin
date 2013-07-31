package com.cnarj.ttxs.dao.imp.member;


import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IPhotoCommentDao;
import com.cnarj.ttxs.pojo.stuz.Photocomment;

/**
 * 空间dao接口实现类 - 照片留言
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月29日19:25:37
 */
public class PhotoCommentDaoImpl extends BaseDaoImpl<Photocomment,String> implements
		IPhotoCommentDao {

	public List<Photocomment> getListByDate(String photoid) {
		Assert.hasText(photoid, "photoid must not be empty");
		String hql = "from Photocomment where photos.photoid = ? order by commenteddate";
		return getSession().createQuery(hql).setParameter(0, photoid).list();
	}
}
