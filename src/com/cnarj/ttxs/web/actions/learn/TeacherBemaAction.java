package com.cnarj.ttxs.web.actions.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.Album;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.learn.ISuperTeacherService;

/**
 * 学习频道Action类 - 名师讲堂
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
@SuppressWarnings("serial")
public class TeacherBemaAction extends TogetherAction {
	private String teacherId;// 得到老师的编号
	private String nowpage;// 当前页
	private String pagesize;// 页面大小
	private String sysInfoId;// 系统信息的Id
	private String articlesrcId;
	private String articId;// 得到讲堂id号
	private String typeid;// 查询类型
	private String termString;// 查询条件
	private ISuperTeacherService superTeacherService;

	public ISuperTeacherService getSuperTeacherService() {
		return superTeacherService;
	}

	public void setSuperTeacherService(ISuperTeacherService superTeacherService) {
		this.superTeacherService = superTeacherService;
	}

	public String getArticlesrcId() {
		return articlesrcId;
	}

	public String getTermString() {
		return termString;
	}

	public void setTermString(String termString) {
		this.termString = termString;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		System.out.println(typeid);
		this.typeid = typeid;
	}

	public void setArticlesrcId(String articlesrcId) {
		this.articlesrcId = articlesrcId;
	}

	public String getSysInfoId() {
		return sysInfoId;
	}

	public void setSysInfoId(String sysInfoId) {
		this.sysInfoId = sysInfoId;
	}

	public String getNowpage() {
		return nowpage;
	}

	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * 按條件搜索名师信息
	 */
	@SuppressWarnings("unchecked")
	public String showTerm() {
		// 设置page参数
		// 设置每页显示的条数
		page.setEveryPage(30);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		if (typeid.equals("0")) {// 为人名
			result = this.getReadTeacherInfoService().getTeacherAndText(typeid,
					termString, page);
			if (result.getContent().size() != 0) {
				List list = result.getContent();
				this.setAttribute("aticless", list);
				return "teach";
			} else {
				setAttribute("errorinfo", "没有搜索到你要的信息!");
				return showTeachers();
			}
		} else if (typeid.equals("1")) {// 为文章名称
			result = this.getReadTeacherInfoService().getTeacherAndText(typeid,
					termString, page);
			if (result.getContent().size() != 0) {
				List srcs = result.getContent();
				setAttribute("pins", srcs);
				return "text";
			} else {
				setAttribute("errorinfo", "没有搜索到你要的信息!");
				return showTeachers();
			}
		}
		return null;
	}

	/**
	 * 名校的信息内页
	 * 
	 * @return
	 */

	public String showSchool() {
		Album album = new Album();
		if (articlesrcId != null) {
			ArticleSrc articleSrc = this.getReadTeacherInfoService()
					.getsuperSchool(articlesrcId);
			connMethod();
			String picPath = articleSrc.getAlbumspath();
			if (picPath != null) {
				album.setAlbumPath(picPath);
				String[] pics = getPictres(picPath);// 得到picpath目录中的文件名称
				StringBuffer str_pics = new StringBuffer();
				if (pics != null) {
					for (int i = 0; i < pics.length; i++) {
						if (i == (pics.length - 1)) {
							str_pics.append("'").append(pics[i]).append("'");
							break;
						}
						str_pics.append("'").append(pics[i]).append("',");
					}
					album.setPictures(pics);
					album.setStr_picture(str_pics.toString());
				}
			}
			List<ArticleSrc> listsrc = null;
			if (articleSrc.getMetakeywords() != null
					|| !articleSrc.getMetakeywords().trim().equals("")) {
				listsrc = this.getReadTeacherInfoService().getXianGuanSchool(
						articleSrc.getMetakeywords(), 0,
						articleSrc.getArticlesrcid());
			}
			//
			String[] content = articleSrc
					.getArticlesrccontent()
					.split(
							"<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
			setAttribute("content", content);

			this.setAttribute("school", articleSrc);
			this.setAttribute("album", album);
			if (album.getPictures() != null) {
				this.setAttribute("numPic", album.getPictures().length);
			}
			this.setAttribute("listsrc", listsrc);
			this.setAttribute("srclength", content.length);
			return "schoolinfo";
		}
		return null;
	}

	/**
	 * 系统信息的内页
	 * 
	 * @return
	 */
	public String showSysInfo() {
//		if (sysInfoId != null) {
//			connMethod();
//			Article article = this.getReadInfoService().getArticle(sysInfoId);
//			List<Article> list = this.getReadInfoService().getXingGuanArticle(
//					5, article.getPagekeywords(), article.getArticleid());
//			String[] content = article
//					.getArticlecontent()
//					.split(
//							"<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
//			setAttribute("content", content);
//			setAttribute("srclength", content.length);
//			this.setAttribute("list", list);
//			this.setAttribute("article", article);
//			return "sysInfo";
//		}
		return null;
	}

	/**
	 * 名师讲坛的内页(老师的详细信息)
	 * 
	 * @return
	 */
	public String showTeacherinfo() {// 看一次 增加一次人气
		connMethod();
		if (teacherId != null) {
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(20);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			SuperTeacher teacher = this.getReadTeacherInfoService()
					.getBySuperTeacher(teacherId);
			superTeacherService.updateHuman(teacher);
			result = this.getReadTeacherInfoService().getSuperAticle(page,
					teacher.getSuperTeacherID());
			this.setAttribute("teahcer", teacher);
			return "teacheinfo";
		}
		return null;
	}

	/**
	 * 名师讲坛的主页面
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showTeachers() {
		// 设置page参数
		// 设置每页显示的条数
		page.setEveryPage(28);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		result = this.getReadTeacherInfoService().getSuperAticles(page);
		List<SuperTeacher> aticless = result.getContent();
		connMethod();
		List<SuperTeacher> superts = this.getReadTeacherInfoService()
				.getSuperTeachers(13);// 得到13条名师名称
		this.setAttribute("superts", superts);
		this.setAttribute("aticless", aticless);
		return SUCCESS;
	}

	/**
	 * 名师讲堂的详细信息
	 */
	public String showTeacherArticleSrc() {
		ArticleSrc articleSrc = this.getReadTeacherInfoService()
				.getTeacherArticleSrc(articId);// 得到详细信息
		List<ArticleSrc> list = this.getReadTeacherInfoService()
				.getTeacherARticleSrcs(articleSrc.getMetakeywords(), 5,
						articleSrc.getArticlesrcid());
		// 老师信息
		SuperAticle superAticle = this.getReadTeacherInfoService().get(
				"articleSrc.articlesrcid", articId);

		String stre = articleSrc.getArticlesrccontent();
		String[] content = null;
		if (stre != null) {
			content = stre
					.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");
		}
		setAttribute("srclength", stre != null ? content.length : 0);
		setAttribute("content", content);
		setAttribute("art", articleSrc);
		setAttribute("srcs", list);
		setAttribute("superAticle", superAticle);

		return "teaart";
	}

	public String getArticId() {
		return articId;
	}

	public void setArticId(String articId) {
		this.articId = articId;
	}
}
