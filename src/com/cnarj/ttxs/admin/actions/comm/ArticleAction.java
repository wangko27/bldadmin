package com.cnarj.ttxs.admin.actions.comm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.admin.service.comm.IArticleService;
import com.cnarj.ttxs.admin.service.comm.IArticleTypeService;
import com.cnarj.ttxs.admin.service.user.IMemberService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.sys.IGradeCodeService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 学习频道后台Action类 - 文章
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月17日
 */
public class ArticleAction extends PageAction implements
		ModelDriven<ArticleSrc> {
	private static final long serialVersionUID = 1L;

	ArticleSrc articleSrc = new ArticleSrc();

	private IArticleTypeService articleTypeService;

	private IArticleService articleService;

	private ISubjectCodeService subjectCodeService;

	private IGradeCodeService gradeCodeService;

	private IMemberService memberService;

	File cover;// 封面
	String coverFileName;
	String coverContentType;

	public IArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}

	public void setArticleTypeService(IArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public ArticleSrc getModel() {
		return articleSrc;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public String getCoverContentType() {
		return coverContentType;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}

	public ISubjectCodeService getSubjectCodeService() {
		return subjectCodeService;
	}

	public void setSubjectCodeService(ISubjectCodeService subjectCodeService) {
		this.subjectCodeService = subjectCodeService;
	}

	public IGradeCodeService getGradeCodeService() {
		return gradeCodeService;
	}

	public void setGradeCodeService(IGradeCodeService gradeCodeService) {
		this.gradeCodeService = gradeCodeService;
	}

	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addPage() {
		try {
			return "add";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionMessage("封面最大只能上传50K!");
				return addPage();
			}
			articleService.saveArticleSrc(articleSrc, cover, coverFileName,
					coverContentType);
			this.addActionMessage("添加成功！");
			return addPage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 管理
	 * 
	 * @return
	 */
	public String manage() {
		try {// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			String articletypeid = getParameter("articletypeid");

			result = articleService.listArticleByInformationPage(page,
					articletypeid, articleSrc.getArticletitle());

			setAttribute("list_articleSrc", result.getContent());
			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		try {
			articleService.deleteArticle(articleSrc.getArticlesrcid());
			this.addActionMessage("删除成功！");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePage() {
		try {
			ArticleSrc articleSrcNew = articleService.get(articleSrc
					.getArticlesrcid());
			if (null != articleSrcNew) {
				setAttribute("articleSrc", articleSrcNew);
			}

			return "update";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionMessage("封面最大只能上传50K!");
				return updatePage();
			}
			articleService.updateArticleSrc(articleSrc, cover, coverFileName,
					coverContentType);
			this.addActionMessage("修改成功！");
			return updatePage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 获取资讯频道所有类别
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getArticleTypeAll() {
		try {
			// 查询资讯频道所有类别
			List<ArticleType> list_articleType = articleTypeService.getList(
					"articleType.articletypeid",
					"8a80818c31bb7cc50131bb7fbde70001");
			return list_articleType;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return new ArrayList();
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
	 * 获取所有年级
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getGradeCodeAll() {
		try {
			List<GradeCode> list_gradeCode = gradeCodeService.getAll();
			return list_gradeCode;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return new ArrayList();
	}

}
