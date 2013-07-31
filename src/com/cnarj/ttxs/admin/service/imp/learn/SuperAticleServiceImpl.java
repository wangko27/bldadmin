package com.cnarj.ttxs.admin.service.imp.learn;

import java.util.Date;

import com.cnarj.ttxs.admin.service.learn.ISuperAticleService;
import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.dao.learn.IReadTeacherInfoDao;
import com.cnarj.ttxs.dao.learn.ISuperTeacherDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.Pubfun;

/**
 * 学习频道后台Service实现类 - 名师讲坛 - 名师讲坛信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月22日
 */
public class SuperAticleServiceImpl extends
		BaseServiceImpl<SuperAticle, String> implements ISuperAticleService {

	private IReadTeacherInfoDao readTeacherInfoDao;

	private IArticleDao articleDao;

	private ISuperTeacherDao superTeacherDao;

	public IReadTeacherInfoDao getReadTeacherInfoDao() {
		return readTeacherInfoDao;
	}

	public void setReadTeacherInfoDao(IReadTeacherInfoDao readTeacherInfoDao) {
		this.readTeacherInfoDao = readTeacherInfoDao;
	}

	public IArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public ISuperTeacherDao getSuperTeacherDao() {
		return superTeacherDao;
	}

	public void setSuperTeacherDao(ISuperTeacherDao superTeacherDao) {
		this.superTeacherDao = superTeacherDao;
	}

	public void deleteSuperAticle(String superAticleID) throws Exception {
		SuperAticle superAticle = readTeacherInfoDao.get(superAticleID);
		ArticleSrc articleSrc = articleDao.get(superAticle.getArticleSrc()
				.getArticlesrcid());
		// 删除文章
		articleDao.delete(articleSrc);
		// 删除名师讲坛信息
		readTeacherInfoDao.delete(superAticle);
	}

	public Result findSuperAticleByPage(Page page, String superTeacherID,
			Long flag, String articletitle) throws Exception {
		return readTeacherInfoDao.findSuperAticleByPage(page, superTeacherID,
				flag, articletitle);
	}

	public void saveSuperAticle(String superTeacherID, Long flag,
			ArticleSrc articleSrc) throws Exception {
		// 保存文章信息
		articleSrc.setCreatedate(new Date());// 创建日期
		articleSrc.setModifydate(new Date());// 修改日期
		articleSrc.setCollectionnum(new Long(0));// 收藏次数
		articleSrc.setSharenum(new Long(0));// 分享次数
		articleSrc.setUserpushnum(new Long(0));// 用户推荐次数
		articleSrc.setIspublication("1");// 是否发布
		String newContent = Pubfun.contentHandle(articleSrc
				.getArticlesrccontent());
		// 重新设置内容
		articleSrc.setArticlesrccontent(newContent);
		int pageCount = newContent
				.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
		articleSrc.setPagecount(new Long(pageCount));// 文章页数
		articleDao.save(articleSrc);

		// 保存讲坛信息
		SuperAticle superAticle = new SuperAticle();
		superAticle.setFlag(flag);
		superAticle.setSuperTeacher(superTeacherDao.get(superTeacherID));
		superAticle.setArticleSrc(articleSrc);
		superAticle.setCreateDate(new Date());
		superAticle.setModifyDate(new Date());
		superAticle.setIsenable("1");
		superAticle.setArticletitle(articleSrc.getArticletitle());
		readTeacherInfoDao.save(superAticle);
	}

	public void updateSuperAticle(String superAticleID, Long flag,
			ArticleSrc articleSrc) throws Exception {
		// 修改名师讲坛信息
		SuperAticle superAticle = readTeacherInfoDao.get(superAticleID);
		superAticle.setModifyDate(new Date());
		superAticle.setFlag(flag);
		superAticle.setArticletitle(articleSrc.getArticletitle());

		// 修改文章
		ArticleSrc articleSrcNew = superAticle.getArticleSrc();
		articleSrcNew.setModifydate(new Date());// 修改日期
		articleSrcNew.setArticletitle(articleSrc.getArticletitle());// 修改标题
		String newContent = Pubfun.contentHandle(articleSrc
				.getArticlesrccontent());
		// 重新设置内容
		articleSrcNew.setArticlesrccontent(newContent);

		int pageCount = newContent
				.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
		articleSrcNew.setPagecount(new Long(pageCount));// 文章页数

		articleSrcNew.setMetakeywords(articleSrc.getMetakeywords());// 修改关键字
		articleSrcNew.setIspublication(articleSrc.getIspublication());// 修改是否发布
		articleSrcNew.setIstop(articleSrc.getIstop());// 修改是否置顶
		articleSrcNew.setIsrecommend(articleSrc.getIsrecommend());// 修改是否推荐
		// 修改
		articleDao.update(articleSrcNew);
	}

	public void updateSuperAticleByEnable(String superAticleID)
			throws Exception {
		SuperAticle superAticle = readTeacherInfoDao.get(superAticleID);
		ArticleSrc articleSrc = articleDao.get(superAticle.getArticleSrc()
				.getArticlesrcid());
		articleSrc.setIspublication("0");
		articleDao.update(articleSrc);
		superAticle.setIsenable("0");
		readTeacherInfoDao.update(superAticle);

	}

}
