package com.cnarj.ttxs.service.imp.Article;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.servlet.ServletContext;
import java.io.BufferedWriter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.freemarker.FreemarkerManager;
import freemarker.template.Configuration;
import freemarker.template.Template;

import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.dao.Article.IArticleHandleRecDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleHandleRec;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.util.HttpUtil;

/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class ArticleServiceImpl extends BaseServiceImpl<ArticleSrc, String>
		implements IArticleService {

	public void setBaseDao(IArticleDao ArticleDao) {
		super.setBaseDao(ArticleDao);
	}

	private IArticleDao ArticleDao;
	private IArticleHandleRecDao ArticleHandleRecDao;
	private MemberDao memberDao;

	private FreemarkerManager freemarkerManager = new FreemarkerManager();

	public IArticleDao getArticleDao() {
		return ArticleDao;
	}

	public void setArticleDao(IArticleDao articleDao) {
		ArticleDao = articleDao;
	}

	public IArticleHandleRecDao getArticleHandleRecDao() {
		return ArticleHandleRecDao;
	}

	public void setArticleHandleRecDao(IArticleHandleRecDao articleHandleRecDao) {
		ArticleHandleRecDao = articleHandleRecDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public FreemarkerManager getFreemarkerManager() {
		return freemarkerManager;
	}

	public void setFreemarkerManager(FreemarkerManager freemarkerManager) {
		this.freemarkerManager = freemarkerManager;
	}

	public void buildHtml(String templateFilePath, String htmlFilePath,
			Map<String, Object> data) {
		// TODO Auto-generated method stub
		try {
			ServletContext servletContext = ServletActionContext
					.getServletContext();
			Configuration configuration = freemarkerManager
					.getConfiguration(servletContext);
			configuration.setDefaultEncoding("UTF-8");
			Template template = configuration.getTemplate(templateFilePath);
			template.setEncoding("UTF-8");
			File htmlFile = new File(servletContext.getRealPath(htmlFilePath));
			File htmlDirectory = htmlFile.getParentFile();
			if (!htmlDirectory.exists()) {
				htmlDirectory.mkdirs();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "UTF-8"));
			template.process(data, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获得评学论道关联文章
	 */
	public List<ArticleSrc> getArticleSrcRI(String articletype,Object value,String articlesrcid,String aritlcettitle, String metakeywords,String isrecommend, int shownum) {
		return ArticleDao.getArticleSrcRI(articletype, value, articlesrcid, aritlcettitle, metakeywords, isrecommend, shownum);
	}
	public Long getTotalCountByChildtypeList(String[] values) {
		// TODO Auto-generated method stub
		return ArticleDao.getTotalCountByChildtypeList(values);
	}

	public List<ArticleSrc> getShareArticleSrc(String articleType,
			String isrecommend, int num) {
		// TODO Auto-generated method stub
		return ArticleDao.getShareArticleSrc(articleType, isrecommend, num);
	}

	public List<ArticleSrc> getTopArticleSrc(String istop, String isrecommend,
			String orderBy, int start, int stop) {
		// TODO Auto-generated method stub
		return ArticleDao.getTopArticleSrc(istop, isrecommend, orderBy, start,
				stop);
	}

	public void saveArticlehandle(String articlesrcid, Long actiontype,
			String actionpath) throws Exception {
		ArticleSrc articleSrc = ArticleDao.get(articlesrcid);
		if (actiontype == 1) {// 修改分享次数（加1）
			articleSrc.setSharenum(articleSrc.getSharenum() + 1);
		} else if (actiontype == 2) {// 修改收藏次数（加1）
			articleSrc.setCollectionnum(articleSrc.getCollectionnum() + 1);
		}
		ArticleDao.update(articleSrc);

		// 添加分享/收藏记录
		ArticleHandleRec articleHandleRec = new ArticleHandleRec();
		articleHandleRec.setArticleSrc(articleSrc);
		articleHandleRec.setActiontype(actiontype);
		articleHandleRec.setActiondate(new Date());
		articleHandleRec.setActionpath(actionpath);
		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		Member member = memberDao.get(memberid);
		articleHandleRec.setMember(member);
		ArticleHandleRecDao.save(articleHandleRec);
	}

	public Result getarticlebyparentType(Page page, String articleTypeId) {
		// TODO Auto-generated method stub
		return ArticleDao.getarticlebyparentType(page, articleTypeId);
	}

	public Result searchArticle(String type, Object value, String metakeywords,
			Page page) {
		return ArticleDao.searchArticle(type, value, metakeywords, page);
	}

	public Long searchArticle(String type, Object value, String metakeywords) {
		return ArticleDao.searchArticle(type, value, metakeywords);
	}

	public List<ArticleSrc> getEducationByhql(String articleType, Object value,
			int num) {
		// TODO Auto-generated method stub
		String hql = "from ArticleSrc where articleType."
				+ articleType
				+ "='"
				+ value
				+ "' and ispublication='1' and  isrecommend='1'  order by istop desc, modifydate desc";
		return ArticleDao.getArticleByhql(hql,num);
	}

	public List<ArticleSrc> getPualArticle(int num) {
		// TODO Auto-generated method stub
		return ArticleDao.getPualArticle(num);
	}

	public List<ArticleSrc> getShareArticleSrc(String articleType, int num) {
		// TODO Auto-generated method stub
		return ArticleDao.getShareArticleSrc(articleType, num);
	}
	/*
	 * 生活百科-分页
	 * 
	 */
		public Result searchbaikelist(Page page, String articleTypeId) {
			StringBuffer sbHql = new StringBuffer();
			if (articleTypeId == null || "".equals(articleTypeId.trim())||articleTypeId.equals("8a80818c31bb7cc50131bb7fbde70002")) {
				sbHql
						.append("from ArticleSrc t where  t.articleType.articleType.articletypeid='8a80818c31bb7cc50131bb7fbde70002'")
								.append(" order by t.createdate desc");
			} else {
					sbHql.append("from ArticleSrc t where  t.articleType.articletypeid='")
							.append(articleTypeId).append("'").append(" order by t.createdate desc");
			}
			return ArticleDao.getarticle(page, sbHql.toString());	
		}
	/*
	 * 获得新闻动态相关内容-分页
	 * 
	 */
	public Result searchArticle(Page page, String articleTypeId) {
		StringBuffer sbHql = new StringBuffer();
		if (articleTypeId == null || "".equals(articleTypeId.trim())) {
			sbHql
					.append(
							"from ArticleSrc t where  t.articleType.articleType.articletypeid='8a8081a131cd5fcd0131cd6a83e40005'")
					.append(" order by t.createdate desc");
		} else {
			if (articleTypeId.equals("8a80818c31b6a6270131b6a835780012")) {
				sbHql
						.append(
								"from Article t where  t.articleType.articletypeid='")
						.append(articleTypeId).append("'").append(
								" order by t.createdate desc");
			} else {
				sbHql
						.append(
								"from ArticleSrc t where  t.articleType.articletypeid='")
						.append(articleTypeId).append("'").append(
								" order by t.createdate desc");
			}
		}
		return ArticleDao.getarticle(page, sbHql.toString());
	}
	/*
	 * 获得生活百科总数
	 * 
	 */
	public Long getbaikeTotalCount(String articleTypeId) {
		StringBuffer sbHql = new StringBuffer();
		if (articleTypeId == null || "".equals(articleTypeId.trim())||articleTypeId.equals("8a80818c31bb7cc50131bb7fbde70002")) {
			sbHql
					.append("select count(*) from ArticleSrc t where  t.articleType.articleType.articletypeid='8a80818c31bb7cc50131bb7fbde70002'");
		}else {
			sbHql
			.append(
					"select count(*) from ArticleSrc t where  t.articleType.articletypeid='")
			.append(articleTypeId).append("'");
		}
		return ArticleDao.geTotalCount(sbHql.toString());
	}
	/*
	 * 获得新闻总数
	 * 
	 */
	public Long getnewsTotalCount(String articleTypeId) {
		// TODO Auto-generated method stub
		StringBuffer sbHql = new StringBuffer();
		if (articleTypeId == null || "".equals(articleTypeId.trim())) {
			sbHql
					.append("select count(*) from ArticleSrc t where   t.articleType.articleType.articletypeid='8a8081a131cd5fcd0131cd6a83e40005' ");
		} else {
			if (articleTypeId.equals("8a80818c31b6a6270131b6a835780012")) {
				sbHql
						.append(
								"select count(*) from Article t where  t.articleType.articletypeid='")
						.append(articleTypeId).append("'");
			} else {
				sbHql
						.append(
								"select count(*) from ArticleSrc t where  t.articleType.articletypeid='")
						.append(articleTypeId).append("'");
			}
		}
		return ArticleDao.geTotalCount(sbHql.toString());
	}
}