package com.cnarj.ttxs.service.imp.Article;
import com.cnarj.ttxs.dao.Article.ISysArticleHandleDao;
import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.Article.ISysArticleHandleService;




/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class SysArticleHandleServiceImpl extends BaseServiceImpl<SysArticleHandleRec,String> implements ISysArticleHandleService{
	
	public void setBaseDao(ISysArticleHandleDao SysArticleHandleDao) {
		super.setBaseDao(SysArticleHandleDao);
	}
	private ISysArticleHandleDao SysArticleHandleDao;
	public ISysArticleHandleDao getSysArticleHandleDao() {
		return SysArticleHandleDao;
	}
	public void setSysArticleHandleDao(ISysArticleHandleDao sysArticleHandleDao) {
		SysArticleHandleDao = sysArticleHandleDao;
	}
	

	public boolean isExistisExistByReadhandle(String articleid,
			Long actiontype, String memberid) {
				return SysArticleHandleDao.isExistisExistByReadhandle(articleid, actiontype, memberid);		
	}
}