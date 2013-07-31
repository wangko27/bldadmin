package com.cnarj.ttxs.admin.actions.learn;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.admin.service.comm.IArticleService;
import com.cnarj.ttxs.admin.service.learn.ISchoolService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class SchoolAction extends PageAction implements ModelDriven<ArticleSrc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArticleSrc articleSrc = new ArticleSrc();

	private ISchoolService schoolService;
	private IArticleService articleService;

	File cover;// 封面
	String coverFileName;
	String coverContentType;

	public ArticleSrc getModel() {
		return articleSrc;
	}

	public ISchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
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

	/**
	 * 添加风校风采
	 * 
	 * @return
	 */
	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "schoolname", message = "学校名称不能为空!", trim = true),
			@RequiredStringValidator(fieldName = "metakeywords", message = "资源关键字不能为空!", trim = true),
			@RequiredStringValidator(fieldName = "articlesrccontent", message = "内容详情不能为空!", trim = true) })
	public String toAddSchool() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionMessage("封面最大只能上传50K!");
				return "add";
			}
			schoolService.saveArticleSrcBySchool(articleSrc, cover,
					coverFileName, coverContentType);
			this.addActionMessage("添加成功！");
			return "add";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除风校风采
	 * 
	 * @return
	 */
	public String deleteSchool() {
		try {
			articleService.updateArticleByPublication(articleSrc
					.getArticlesrcid());
			this.addActionMessage("删除成功！");
			return openSchool();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}

	}

	/**
	 * 为打开风校风采修改页面做准备
	 * 
	 * @return
	 */
	public String openModifySchool() {
		try {
			ArticleSrc articleSrcNew = schoolService.get(articleSrc
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
	 * 修改风校风采
	 * 
	 * @return
	 */
	public String toModifySchool() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionMessage("封面最大只能上传50K!");
				return openModifySchool();
			}
			schoolService.updateArticleSrcBySchool(articleSrc, cover,
					coverFileName, coverContentType);
			this.addActionMessage("修改成功!");
			return openModifySchool();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 打开风校风采管理列表
	 * 
	 * @return
	 */
	public String openSchool() {
		try {
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = schoolService.listArticleBySchoolPage(page, articleSrc
					.getIstop(), articleSrc.getIsrecommend(), "1", articleSrc
					.getSchoolname());

			setAttribute("list_articleSrc", result.getContent());
			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 打开相册管理
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String openPhotoManage() {
		try {
			ArticleSrc articleSrcNew = schoolService.get(articleSrc
					.getArticlesrcid());
			String albumspath = articleSrcNew.getAlbumspath();
			if (null != albumspath) {
				articleSrcNew.setAlbumspath(albumspath.replaceAll("\\\\", "/"));
			}
			if (null != articleSrcNew) {
				setAttribute("articleSrc", articleSrcNew);
			}
			// 获取所有相片的绝对路径
			File file = new File(getRealPath() + articleSrcNew.getAlbumspath());
			File[] filelist = file.listFiles();
			// 存储相片路径（相对路径）
			List list_photopath = new ArrayList();
			if (null != filelist && filelist.length > 0) {
				for (int i = 0; i < filelist.length; i++) {
					String relative = filelist[i].getAbsolutePath();
					relative=relative.replaceAll("\\\\", "/");
					if (relative.indexOf("/cover.jpg") == -1) {// 封面不显示
						if (null != relative) {
							relative = relative.substring(relative
									.indexOf("uploadfiles"), relative.length());
						}
						list_photopath.add(relative);
					}
				}
			}
			setAttribute("list_photopath", list_photopath);
			return "photoManage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

}
