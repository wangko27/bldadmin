package com.cnarj.ttxs.dao.imp.member;


import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IAlbumCommentDao;
import com.cnarj.ttxs.pojo.stuz.Albumcomment;
import com.cnarj.ttxs.pojo.stuz.blogcomment;

/**
 * 空间Dao接口实现类 - 相册留言
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月28日15:29:01
 */
public class AlbumCommentDaoImpl extends BaseDaoImpl<Albumcomment,String> implements
		IAlbumCommentDao {

	public List<Albumcomment> getListByDate(String albumid) {
		Assert.hasText(albumid, "albumid must not be empty");
		String hql = "from Albumcomment where albums.albumid = ? order by commenteddate";
		return getSession().createQuery(hql).setParameter(0, albumid).list();
	}

}
