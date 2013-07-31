package com.cnarj.ttxs.admin.service.imp.learn;

import java.io.File;
import java.util.Date;

import com.cnarj.ttxs.admin.service.learn.ISchoolService;
import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.Pubfun;

/**
 * 学习频道后台Service实现类 - 名校风采
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月24日
 */
public class SchoolServiceImpl extends BaseServiceImpl<ArticleSrc, String>
		implements ISchoolService {

	IArticleDao articleDao;

	public IArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void deleteSchool(String articlesrcid) {
		ArticleSrc articleSrc = articleDao.get(articlesrcid);
		// 删除名校风采
		articleDao.delete(articleSrc);
		// 删除名校风采相册
		// 文件保存路径
		File fileDirectory = new File(HttpUtil.getRealPath()
				+ articleSrc.getAlbumspath());
		FileOperate.deleteDirectoryAndFile(fileDirectory);

	}

	public Result listArticleBySchoolPage(Page page, String istop,
			String isrecommend, String ispublication, String schoolname)
			throws Exception {
		return articleDao.listArticleBySchoolPage(page, istop, isrecommend,
				ispublication, schoolname);
	}

	public void saveArticleSrcBySchool(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception {
		articleSrc.setCreatedate(new Date());// 创建日期
		articleSrc.setModifydate(new Date());// 修改日期
		articleSrc.setCollectionnum(new Long(0));// 收藏次数
		articleSrc.setSharenum(new Long(0));// 分享次数
		articleSrc.setUserpushnum(new Long(0));// 用户推荐次数
		articleSrc.setIspublication("1");// 发布

		String newContent = Pubfun.contentHandle(articleSrc
				.getArticlesrccontent());
		// 重新设置内容
		articleSrc.setArticlesrccontent(newContent);

		int pageCount = newContent
				.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
		articleSrc.setPagecount(new Long(pageCount));// 文章页数

		// 保存并返回名校风采ID
		String articlesrcid = articleDao.save(articleSrc);

		// 文件保存路径
		String uploadFilepath = Pubfun.structurePath("schoolstyle", new Date(),
				articlesrcid + "/album");
		String uploadCoverpath = Pubfun.structurePath("schoolstyle",
				new Date(), articlesrcid);

		articleSrc.setAlbumspath(uploadFilepath);// 相册路径
		articleSrc.setCoverpath(uploadCoverpath + "cover.jpg");

		if (null != cover) {// 有封面
			// 上传封面
			FileOperate.uploadCover("schoolstyle", new Date(), articlesrcid,
					cover, coverFileName, coverContentType);
		} else {// 无封面
			File file = new File(HttpUtil.getRealPath()
					+ "/uploadfiles/none.jpg");
			FileOperate.fileCopy(file, HttpUtil.getRealPath() + File.separator
					+ uploadCoverpath);
		}

		articleDao.update(articleSrc);
	}

	public void updateArticleSrcBySchool(ArticleSrc articleSrc, File cover,
			String coverFileName, String coverContentType) throws Exception {
		ArticleSrc articleSrcNew = articleDao.get(articleSrc.getArticlesrcid());
		articleSrcNew.setModifydate(new Date());// 修改日期

		String newContent = Pubfun.contentHandle(articleSrc
				.getArticlesrccontent());
		// 重新设置内容
		articleSrcNew.setArticlesrccontent(newContent);

		int pageCount = newContent
				.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
		articleSrcNew.setPagecount(new Long(pageCount));// 文章页数

		articleSrcNew.setMetakeywords(articleSrc.getMetakeywords());// 修改关键字
		articleSrcNew.setIsrecommend(articleSrc.getIsrecommend());// 修改是否推荐
		articleSrcNew.setIstop(articleSrc.getIstop());// 修改是否置顶
		articleSrcNew.setSchoolname(articleSrc.getSchoolname());// 修改学校名称

		if (null != cover) {// 有封面
			// 上传封面
			String uploadFilepath = FileOperate.uploadCover("schoolstyle",
					articleSrcNew.getCreatedate(), articleSrcNew
							.getArticlesrcid(), cover, coverFileName,
					coverContentType);
			articleSrcNew.setCoverpath(uploadFilepath);
		}

		// 修改
		articleDao.update(articleSrcNew);

	}

}
