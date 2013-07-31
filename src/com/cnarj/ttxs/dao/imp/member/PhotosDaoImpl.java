package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IPhotosDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Photos;
/**
 * 空间Dao接口实现类 - 照片
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月28日15:27:04
 */
public class PhotosDaoImpl extends BaseDaoImpl<Photos,String> implements IPhotosDao {


	public Result getPhotoList(Page page, String albumid) {
		String hql = "from Photos where albums.albumid = ? order by createdate desc";
		List list = new ArrayList();
		list.add(albumid);
		return super.findByPager(page, hql, list);
	}

	public Result getPhotoById(String albumid, Page pager) {
		String hql = "from Photos where albums.albumid = ? order by createdate desc";
		List list = new ArrayList();
		list.add(albumid);
		return super.findByPager(pager, hql, list);
	}

	public void updateCommentNum(String photoid) {
		Assert.hasText(photoid, "photoid must not be empty");
		String hql = "update Photos b set b.commentnum = b.commentnum + 1 where b.photoid = ?";
		getSession().createQuery(hql).setParameter(0, photoid).executeUpdate();
		
	}

	
	public List opengetNewPhotos(String memberid, List powerList) {

		StringBuffer hql = new StringBuffer();
		hql.append(" from Photos p where p.albums.member.memberid = ? and ");

		for(int i = 0 ; i < powerList.size();i++){
			if(i == 0){
				hql.append(" ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" p.albums.viewperm = ?");
			
			if(i == powerList.size()-1){
				hql.append(" ) ");
			}
		}
		
		hql.append("order by createdate desc");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter(0, memberid);
		for(int i = 0;i < powerList.size();i++){
			query.setParameter(i+1, powerList.get(i));
		}
		
		return query.setFirstResult(0).setMaxResults(5).list();
	}

}
