package com.cnarj.ttxs.admin.service.imp.comm;

import java.io.File;
import java.util.Date;

import com.cnarj.ttxs.admin.service.comm.IArticleService;
import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.dao.Article.IArticleTypeDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.Pubfun;

/**
 * 学习频道后台Service实现类 - 文章
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月17日
 */
public class ArticleServiceImpl extends BaseServiceImpl<ArticleSrc, String>
		implements IArticleService {

	IArticleDao articleDao;

	IArticleTypeDao articleTypeDao;

	public IArticleTypeDao getArticleTypeDao() {
		return articleTypeDao;
	}

	public void setArticleTypeDao(IArticleTypeDao articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}

	public IArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void setBaseDao(IArticleDao articleDao) {
		super.setBaseDao(articleDao);
	}

	public void saveArticleSrc(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception {
		articleSrc.setCreatedate(new Date());// 创建日期
		articleSrc.setModifydate(new Date());// 修改日期
		articleSrc.setCollectionnum(new Long(0));// 收藏次数
		articleSrc.setSharenum(new Long(0));// 分享次数
		articleSrc.setUserpushnum(new Long(0));// 用户推荐次数
		articleSrc.setIspublication("1");// 发布

		if (null == articleSrc.getArticleType()) {// 有类别就不在这里设置了
			// 第几级菜单
			String level = HttpUtil.getParameter("level");
			// 子级菜单
			String articletypeidChild = HttpUtil.getParameter("articletypeid"
					+ level);
			// 设置类别
			ArticleType articleType = articleTypeDao.get(articletypeidChild);
			articleSrc.setArticleType(articleType);
		}

		String newContent = Pubfun.contentHandle(articleSrc
				.getArticlesrccontent());
		// 重新设置内容
		articleSrc.setArticlesrccontent(newContent);

		int pageCount = newContent
				.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
		articleSrc.setPagecount(new Long(pageCount));// 文章页数

		// 保存
		String articlesrcid = articleDao.save(articleSrc);

		// 上传封面
		String coverPath = "uploadfiles/none.gif";// 封面路径

		if (null != cover) {// 有封面
			// 上传封面
			coverPath = FileOperate.uploadCover("information", new Date(),
					articlesrcid, cover, coverFileName, coverContentType);
		}
		articleSrc.setCoverpath(coverPath);
		articleDao.update(articleSrc);
	}

	public void updateArticleSrc(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception {
		ArticleSrc articleSrcNew = articleDao.get(articleSrc.getArticlesrcid());
		articleSrcNew.setModifydate(new Date());// 修改日期
		articleSrcNew.setArticletitle(articleSrc.getArticletitle());// 修改标题

		if (null == articleSrc.getArticleType()) {// 有类别就不在这里设置了
			// 第几级菜单
			String level = HttpUtil.getParameter("level");
			// 子级菜单
			String articletypeidChild = HttpUtil.getParameter("articletypeid"
					+ level);
			// 修改类别
			ArticleType articleType = articleTypeDao.get(articletypeidChild);
			articleSrcNew.setArticleType(articleType);
		}

		String newContent = Pubfun.contentHandle(articleSrc
				.getArticlesrccontent());
		// 重新设置内容
		articleSrcNew.setArticlesrccontent(newContent);

		int pageCount = newContent
				.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
		articleSrcNew.setPagecount(new Long(pageCount));// 文章页数

		articleSrcNew.setGradecode(articleSrc.getGradecode());// 修改年级
		articleSrcNew.setSubjectcode(articleSrc.getSubjectcode());// 修改科目
		articleSrcNew.setMetakeywords(articleSrc.getMetakeywords());// 修改关键字
		articleSrcNew.setIsrecommend(articleSrc.getIsrecommend());// 修改是否推荐
		articleSrcNew.setIstop(articleSrc.getIstop());// 修改是否置顶
		articleSrcNew.setArticleintro(articleSrc.getArticleintro());// 修改内容简介
		articleSrcNew.setArtfrom(articleSrc.getArtfrom());// 文章来源

		if (null != cover) {// 有封面
			// 删除原有封面
			if (null != articleSrcNew.getCoverpath()
					&& !"uploadfiles/none.gif".equals(articleSrcNew.getCoverpath())) {
				FileOperate.deleteFile(articleSrcNew.getCoverpath());
			}
			// 上传封面
			String coverPath = FileOperate.uploadCover("information",
					articleSrcNew.getCreatedate(), articleSrcNew
							.getArticlesrcid(), cover, coverFileName,
					coverContentType);
			articleSrcNew.setCoverpath(coverPath);
		}

		// 修改
		articleDao.update(articleSrcNew);
	}

	public Result listArticleByPxldArticlePage(Page page, Long memberType,
			String isrecommend, String articletypeid, String articletitle)
			throws Exception {
		return articleDao.listArticleByPxldArticlePage(page, memberType,
				isrecommend, articletypeid, articletitle);
	}

	public void updateArticleByPublication(String articlesrcid)
			throws Exception {
		ArticleSrc articleSrc = articleDao.get(articlesrcid);
		articleSrc.setIspublication("0");
		articleDao.update(articleSrc);
	}

	/**
	 * 查询资讯内容（带分页）
	 * 
	 * @param page
	 * @param memberType
	 * @param isrecommend
	 * @param articletypeid
	 * @return
	 */
	public Result listArticleByInformationPage(Page page, String articletypeid,
			String articletitle) throws Exception {
		return articleDao.listArticleByInformationPage(page, articletypeid,
				articletitle);
	}

	public void deleteArticle(String articlesrcid) throws Exception {

		ArticleSrc articleSrc = articleDao.get(articlesrcid);
		// 删除文章
		articleDao.delete(articleSrc);

		// 删除相关文件
		String uploadFilepath = Pubfun.structurePath("information", articleSrc
				.getCreatedate(), articleSrc.getArticlesrcid());
		File fileDirectory = new File(HttpUtil.getRealPath() + uploadFilepath);
		FileOperate.deleteDirectoryAndFile(fileDirectory);

	}

}
