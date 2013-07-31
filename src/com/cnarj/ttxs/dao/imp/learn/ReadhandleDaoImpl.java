package com.cnarj.ttxs.dao.imp.learn;

import org.hibernate.Query;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IReadhandleDao;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;

/**
 * 学习频道Dao接口实现类 - 博览群书处理记录(收藏,分享)
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月18日
 */
public class ReadhandleDaoImpl extends BaseDaoImpl<ReadSrcHandleRec, String>
		implements IReadhandleDao {

	public boolean isExistByReadhandle(String readsrcid, Long actiontype,
			String memberid) throws Exception {
		String hql = "select count(recid) from ReadSrcHandleRec h where h.readSrc.readsrcid=? and h.actiontype=? and h.member.memberid=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, readsrcid);
		query.setLong(1, actiontype);
		query.setString(2, memberid);
		if (((Long) query.uniqueResult()) > 0) {
			return true;
		} else {
			return false;
		}
	}

}
