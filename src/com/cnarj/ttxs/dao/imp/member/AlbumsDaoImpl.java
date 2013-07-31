package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IAlbumsDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.albums;
/**
 * 会员Dao接口实现类 - 相册
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public class AlbumsDaoImpl extends BaseDaoImpl<albums,String> implements IAlbumsDao {

	public Result getAlbumList(Page page,String memberid){
		String hql = "from albums a where a.member.memberid = ? order by a.orderList,a.createdate";
		List list = new ArrayList();
		list.add(memberid);
		return super.findByPager(page, hql, list);
	}

	public void updateCommentNum(String albumid) {
		Assert.hasText(albumid, "albumid must not be empty");
		String hql = "update albums b set b.commentnum = b.commentnum + 1 where b.albumid = ?";
		getSession().createQuery(hql).setParameter(0, albumid).executeUpdate();
	}

	public void updateReadNum(String albumid) {
		Assert.hasText(albumid, "albumid must not be empty");
		String hql = "update albums b set b.readnum = b.readnum + 1 where b.albumid = ?";
		getSession().createQuery(hql).setParameter(0, albumid).executeUpdate();
	}

	
	/****************************他人空间***********************************/
	
	public Result opengetAlbumList(Page page, String memberid,List<Long> powerList) {
		Assert.hasText(memberid, "memberid must not be empty");
		Assert.notNull(powerList,"powerList must not null");
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from albums a where a.member.memberid = ? and ");

		List list = new ArrayList();
		list.add(memberid);
		
		for(int i = 0 ; i < powerList.size();i++){
			if(i == 0){
				hql.append(" ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" a.viewperm = ?");
			
			if(i == powerList.size()-1){
				hql.append(" ) ");
			}
			list.add(powerList.get(i));
		}
		
		hql.append(" order by a.orderList,a.createdate");
		
		return super.findByPager(page, hql.toString(), list);
	}

}
