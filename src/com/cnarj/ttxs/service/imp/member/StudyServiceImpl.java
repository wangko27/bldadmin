package com.cnarj.ttxs.service.imp.member;


import java.sql.Date;

import com.cnarj.ttxs.dao.member.IStudyDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IStudyService;
import com.cnarj.ttxs.util.Pubfun;

public class StudyServiceImpl extends BaseServiceImpl<ArticleSrc,String> implements IStudyService {

	private IStudyDao studyDao;
	
	public IStudyDao getStudyDao() {
		return studyDao;
	}

	public void setStudyDao(IStudyDao studyDao) {
		this.studyDao = studyDao;
	}

	public void setBaseDao(IStudyDao studyDao) {
		super.setBaseDao(studyDao);
	}

	public Result getStudyListByM(Page page, String memberid) {
		
		return studyDao.getStudyListByM(page, memberid);
	}

	public String saveStudy(String title, String content, String memberid,Long membertype,ArticleSrc article) {

		//1 取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		ArticleSrc art = new ArticleSrc();
		ArticleType ty = new ArticleType();
		ty.setArticletypeid("8a8081a131cd5fcd0131cd6a83e40004");//文章为品学论道类别
		
		Member m = new Member();
		m.setMemberid(memberid);
		
		art.setMember(m);//会员
		art.setCreatedate(now);//上传时间
		art.setArticletitle(title);//标题
		art.setArticlesrccontent(content);//内容
		art.setArticleType(ty); //文章类别
		art.setUserpushnum(new Long("0"));//用户推荐数
		art.setIsrecommend("0");//是否推荐
		art.setIspublication("1");//是否发布
		art.setPublishertype(membertype);//发布者类型
		art.setIstop("0");//是否置顶
		art.setCollectionnum(new Long("0"));//收藏次数
		art.setSharenum(new Long("0"));//分享次数
		art.setArticleintro(article.getArticleintro());//简介
		art.setMetakeywords(article.getMetakeywords());//关键字
		
		//文章分页处理
		String newContent = Pubfun.contentHandle(content);
		art.setArticlesrccontent(newContent);
		String[] conList = newContent.split("<div style=\"page-break-after: always;\"><span style=\"display: none;\">&nbsp;</span></div>");
		art.setPagecount(new Long(String.valueOf(conList.length)));
		
		return studyDao.save(art);
	}

	public void updateStudy(ArticleSrc article) {
		//1 根据ID取出数据库中的文章
		ArticleSrc old = new ArticleSrc();
		old = studyDao.get(article.getArticlesrcid());
		
		//2 修改用户已修改的字段
		old.setArticletitle(article.getArticletitle());
		old.setArticleintro(article.getArticleintro());
		old.setMetakeywords(article.getMetakeywords());

		//文章分页处理
		String newContent = Pubfun.contentHandle(article.getArticlesrccontent());
		old.setArticlesrccontent(newContent);
		String[] conList = newContent.split("<div style=\"page-break-after: always;\"><span style=\"display: none;\">&nbsp;</span></div>");
		old.setPagecount(new Long(String.valueOf(conList.length)));
		
		
		//3 修改数据库
		studyDao.update(old);
	}

}
