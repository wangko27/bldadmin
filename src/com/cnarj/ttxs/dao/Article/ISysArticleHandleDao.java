package com.cnarj.ttxs.dao.Article;




import com.cnarj.ttxs.dao.IBaseDao;

import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;

/**
 * 测试Dao接口 - 用于测试的Dao接口
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public interface ISysArticleHandleDao extends IBaseDao<SysArticleHandleRec,String>{
	/**
	 * 系统文章处理记录是否存在
	 * 
	 * @param articlesrcid
	 *            文章ID
	 * @param actiontype
	 *            处理类型 1分享 2收藏
	 * @param memberid
	 *            用户ID
	 * @return
	 * @throws Exception
	 */
	public boolean isExistisExistByReadhandle(String articleid,
			Long actiontype, String memberid);
}
