package com.cnarj.ttxs.web.actions.learn;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.learn.ILikeGoodsService;
import com.cnarj.ttxs.service.learn.ILiveEncyclopediaService;
import com.cnarj.ttxs.service.learn.IReadSysInfoService;
import com.cnarj.ttxs.service.learn.IReadTeacherInfoService;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.web.actions.base.PageAction;
/**
 * 右边所有的功能模块
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class TogetherAction extends PageAction {
	private IReadSysInfoService readInfoService;//显示3条公告的
	private IReadbookService readbookService;//显示5天书籍
	private ILikeGoodsService likeGoodsService;//显示9本畅销的读物
	private ILiveEncyclopediaService encyclopediaService;//得到3条生活百科
	private ISubjectCodeService subjectCodeService;//得到科目
	private IReadTeacherInfoService readTeacherInfoService;//得到右边名师信息
	private ISysArticleService  sysarticleService;//显示3条公告的
	
	public ISysArticleService getSysarticleService() {
		return sysarticleService;
	}
	public void setSysarticleService(ISysArticleService sysarticleService) {
		this.sysarticleService = sysarticleService;
	}
	public IReadSysInfoService getReadInfoService() {
		return readInfoService;
	}
	public void setReadInfoService(IReadSysInfoService readInfoService) {
		this.readInfoService = readInfoService;
	}
	public IReadbookService getReadbookService() {
		return readbookService;
	}
	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
	}
	public ILikeGoodsService getLikeGoodsService() {
		return likeGoodsService;
	}
	public void setLikeGoodsService(ILikeGoodsService likeGoodsService) {
		this.likeGoodsService = likeGoodsService;
	}
	public ILiveEncyclopediaService getEncyclopediaService() {
		return encyclopediaService;
	}
	public void setEncyclopediaService(ILiveEncyclopediaService encyclopediaService) {
		this.encyclopediaService = encyclopediaService;
	}
	public ISubjectCodeService getSubjectCodeService() {
		return subjectCodeService;
	}
	public void setSubjectCodeService(ISubjectCodeService subjectCodeService) {
		this.subjectCodeService = subjectCodeService;
	}
	public IReadTeacherInfoService getReadTeacherInfoService() {
		return readTeacherInfoService;
	}
	public void setReadTeacherInfoService(
			IReadTeacherInfoService readTeacherInfoService) {
		this.readTeacherInfoService = readTeacherInfoService;
	}
	/**
	 * 获取所有科目
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getSubjectCodeAll() {
		try {
			List<SubjectCode> list_subjictCode = subjectCodeService.getAll();
			return list_subjictCode;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return new ArrayList();
	}
	/**
	 * 公共的右边部分
	 */
	public String connMethod(){
		List<Article> activitySysarticle=readInfoService.getArticle(3);//显示3条公告的
		List<ReadSrc> readSrcList=readbookService.get5ReadSrc(5);
		List<Goods> goodsList=likeGoodsService.getLikeGoods(9);
		List<ArticleSrc> articleList=encyclopediaService.getLiveEncyclopedia(3);
		
		List<ArticleSrc> arts=readTeacherInfoService.getSuperSchools(2);//得到两条最新学校信息
		List<SuperAticle> aticles=readTeacherInfoService.getSuperAticle(2);//得到2条最新名师讲坛信息
		List<SuperTeacher> supert=readTeacherInfoService.getSuperTeachers(9);//得到9条名师信息
		this.setAttribute("infos", activitySysarticle);
		this.setAttribute("readSrcs", readSrcList);
		this.setAttribute("goodsList", goodsList);
		this.setAttribute("articls", articleList);
		this.setAttribute("schools", arts);
		this.setAttribute("teachers", supert);
		this.setAttribute("aticles", aticles);
		return "right";
	}
	/**
	 * 获得某文件下所有文件名
	 * @param path
	 * @return
	 */

	public String[] getPictres(String path){
		File file=new File(this.getRealPath()+path);
		String[] pics=file.list();//得到picpath目录中的文件名称
		return pics;
	}
	/**
	 * //得到13条名师名称
	 */
	public void getComTeachers(){
		List<SuperTeacher> superts=this.getReadTeacherInfoService().getSuperTeachers(13);
		this.setAttribute("superts", superts);
	}
}
