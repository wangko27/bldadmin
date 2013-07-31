package com.cnarj.ttxs.service.imp.member;

import java.util.List;

import com.cnarj.ttxs.dao.member.IFavoritesDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IFavoritesService;

/**
 * 收藏夹业务类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月03日
 */
public class FavoritesServiceImpl extends BaseServiceImpl<ReadSrcHandleRec,String> implements IFavoritesService {

	private IFavoritesDao favoritesDao;
	public IFavoritesDao getFavoritesDao() {
		return favoritesDao;
	}
	public void setFavoritesDao(IFavoritesDao favoritesDao) {
		this.favoritesDao = favoritesDao;
	}
	public void setBaseDao(IFavoritesDao favoritesDao) {
		super.setBaseDao(favoritesDao);
	}
	
	public Result getFavList(Page page, String memberId, Class classType) {
		
		return favoritesDao.getListFavorites(page, memberId, classType);
	}

	
}
