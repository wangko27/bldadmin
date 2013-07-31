package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.IReadSysInfoDao;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IReadSysInfoService;

public class ReadSysServiceInfoImpl extends BaseServiceImpl<Article, String> 
implements IReadSysInfoService {
	IReadSysInfoDao infoDao;
	public IReadSysInfoDao getInfoDao() {
		return infoDao;
	}
	public void setInfoDao(IReadSysInfoDao infoDao) {
		this.infoDao = infoDao;
	}
	
	
	public List<Article> getArticle(int num) {
		return infoDao.getArticle(num);
	}
	public Article getArticle(String articleId) {
		return infoDao
		.getArticle(articleId);
	}
	public List<Article>  getArticle(String articletype,int num) {
		return infoDao
		.getArticle(articletype,num);
	}
	public List<Article> getArticleSrcRI(Object pagekeywords) {
		return infoDao.getArticleSrcRI(pagekeywords);
	}
	public List<Article> getXingGuanArticle(int num, String keyString,
			String articleId) {
		return null;
	}
}
