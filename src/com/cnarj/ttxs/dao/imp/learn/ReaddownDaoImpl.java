package com.cnarj.ttxs.dao.imp.learn;

import org.hibernate.Query;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IReaddownDao;
import com.cnarj.ttxs.pojo.learn.ReadSrcDownRec;

/**
 * 学习频道Dao接口实现类 - 学习资源下载记录
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月19日
 */
public class ReaddownDaoImpl extends BaseDaoImpl<ReadSrcDownRec, String>
		implements IReaddownDao {

	public boolean isExistByReaddown(String readsrcid, String memberid)
			throws Exception {
		String hql = "select count(downrecid) from ReadSrcDownRec d where d.readSrc.readsrcid=? and d.member.memberid=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, readsrcid);
		query.setString(1, memberid);
		if (((Long) query.uniqueResult()) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
