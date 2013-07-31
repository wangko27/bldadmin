package com.cnarj.ttxs.dao.imp.member;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IFavoritesDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;

/**
 * 收藏夹dao实现类
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author hedan
 * @version 1.0
 * @since 2011-08-11
 */
public class FavoritesDaoImpl extends BaseDaoImpl<ReadSrcHandleRec, String> implements IFavoritesDao {

	public Result getListFavorites(Page page, String memberID, Class classType) {
		String hql = "";
		if (classType==com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec.class) {
			hql = "from com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec where actiontype = ? and USERID = ? order by actiondate desc";
		} else if (classType==com.cnarj.ttxs.pojo.comm.ArticleHandleRec.class) {
			hql = "from com.cnarj.ttxs.pojo.comm.ArticleHandleRec where actiontype = ? and USERID = ? order by actiondate desc";
		} else if (classType==com.cnarj.ttxs.pojo.sys.SysArticleHandleRec.class) {
			hql = "from com.cnarj.ttxs.pojo.sys.SysArticleHandleRec where actiontype = ? and USERID = ? order by actiondate desc";
		}
		List list = new ArrayList();
		list.add((long)2);
		list.add(memberID);
		return super.findByPager(page, hql, list);
	}

}
