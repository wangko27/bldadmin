package com.cnarj.ttxs.service.imp.Article;

import java.util.List;
import com.cnarj.ttxs.dao.Article.ISysArticleDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.Article.ISysArticleService;



/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class SysArticleServiceImpl extends BaseServiceImpl<Article,String> implements ISysArticleService {
	public void setBaseDao(ISysArticleDao sysarticleDao) {
		super.setBaseDao(sysarticleDao);
	}
	private ISysArticleDao sysarticleDao;
	public ISysArticleDao getSysarticleDao() {
		return sysarticleDao;
	}

	public void setSysarticleDao(ISysArticleDao sysarticleDao) {
		this.sysarticleDao = sysarticleDao;
	}
	/*
	 * 查询新知识
	 * 
	 */
	public List<Article> getactivitynews(int num){
		//获得所有活动公告id
		String hql="from Article where articleType.articleType.articleType.articleType.articletypeid='8a80818c31b6a6270131b6a835780013' order by createdate desc";
		return	sysarticleDao.getarticle(hql,num);
	}
	/*
	 * 查找 商城资讯
	 * 
	 */
	public Result getshoparticle(Page page, String articleType) {
		StringBuffer sbHql = new StringBuffer();
		if (articleType == null || "".equals(articleType.trim())) {
			sbHql.append("from Article t where  t.articleType.articleType.articletypeid='8a8081a131hjrldd3211faf5f7f60009'").append(" order by t.createdate desc");
		}
		else{
			sbHql.append("from Article t where  t.articleType.articletypeid='").append(articleType).append("'").append(" order by t.createdate desc");
		}
		return sysarticleDao.getarticle(page, sbHql.toString());
	}
	/*
	 * 根据关键字 类别查询系统文章
	 * 
	 */
	public Result listArticleByInformationPage(Page page, String articleType,String articletitle) {
		StringBuffer sbHql = new StringBuffer("from Article a where 1=1");
		if (null != articletitle && !"".equals(articletitle.trim())) {
			sbHql.append(" and a.articletitle like '%"+articletitle+"%'");
		}
		if (null != articleType && !"".equals(articleType)) {
			if(articleType.equals("8a80818c31b6a6270131b6a835780013")){
				sbHql.append(" or a.articleType.articleType.articleType.articleType.articletypeid='"+articleType+"'");//兴趣频道
			}
			else if(articleType.equals("8a8081a131sssddd3211faf5f7f60009")){
				sbHql.append(" and( a.articleType.articleType.articletypeid='"+articleType+"'  or  a.articleType.articleType.articleType.articletypeid='"+articleType+"')");//商城频道
			}else if(articleType.equals("8a8081a131f9e2370131fa261a850002")){
				sbHql.append(" and( a.articleType.articleType.articletypeid='"+articleType+"')");//系统公告
			}
			else{
				
			}
		}
		sbHql.append(" order by a.modifydate desc");
		return sysarticleDao.getarticle(page, sbHql.toString());
	}
	public List<Article> getArticle(String articletype,Object value, int num) {
		// TODO Auto-generated method stub
		return sysarticleDao.getArticle(articletype, value, num);
	}
	public List<Article> getArticleRI(String articleid, String pagekeywords,int shownum) {
		// TODO Auto-generated method stub
		return sysarticleDao.getArticleRI(articleid, pagekeywords, shownum);
	}

	public Long getTotalCountByChildtypeList(String[] values) {
		return sysarticleDao.getTotalCountByChildtypeList(values);
	}
	public Result getarticlebyparentType(Page page, String articleTypeId) {
		// TODO Auto-generated method stub
		return sysarticleDao.getarticlebyparentType(page, articleTypeId);
	}

	public Result searchArticle(String type, Object value, String metakeywords,
			Page page) {
		// TODO Auto-generated method stub
		return sysarticleDao.searchArticle(type, value, metakeywords, page);
	}

	public Long searchArticle(String type, Object value, String metakeywords) {
		// TODO Auto-generated method stub
		return sysarticleDao.searchArticle(type, value, metakeywords);
	}

	public Result getallnotice(Page page, String articleTypeId) {
		// TODO Auto-generated method stub
		return sysarticleDao.getallnotice(page, articleTypeId);
	}

	public List<Article> getArticle(int num) {
		// TODO Auto-generated method stub
		return sysarticleDao.getArticle(num);
	}

	public List<Article> getNewsNotice(int num) {
		// TODO Auto-generated method stub
		return sysarticleDao.getNewsNotice(num);
	}

	public Result getarticlebyRI(Page page, String metakeywords) {
		// TODO Auto-generated method stub
		return sysarticleDao.getarticlebyRI(page, metakeywords);
	}

	public Result getarticlebyType(Page page, String type, Object value) {
		// TODO Auto-generated method stub
		return sysarticleDao.getarticlebyType(page, type, value);
	}

	public Long getarticlebyRI(String metakeywords) {
		// TODO Auto-generated method stub
		return sysarticleDao.getarticlebyRI(metakeywords);
	}

	public List<Article> getNewsNoticeRI(String articleid, String pagekeywords,
			int num) {
		// TODO Auto-generated method stub
		return sysarticleDao.getNewsNoticeRI(articleid, pagekeywords, num);
	}
}