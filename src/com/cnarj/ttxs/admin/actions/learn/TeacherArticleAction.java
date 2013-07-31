package com.cnarj.ttxs.admin.actions.learn;

import com.cnarj.ttxs.admin.service.learn.ISuperAticleService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.SuperAticle;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class TeacherArticleAction extends PageAction implements
		ModelDriven<ArticleSrc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleSrc articleSrc = new ArticleSrc();

	private ISuperAticleService superAticleService;

	private Long flag;;// 文章类别

	private String superTeacherID;// 名师ID

	private String superAticleID;// 名师讲坛信息ID

	public ArticleSrc getModel() {
		return articleSrc;
	}

	public ISuperAticleService getSuperAticleService() {
		return superAticleService;
	}

	public void setSuperAticleService(ISuperAticleService superAticleService) {
		this.superAticleService = superAticleService;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public String getSuperTeacherID() {
		return superTeacherID;
	}

	public void setSuperTeacherID(String superTeacherID) {
		this.superTeacherID = superTeacherID;
	}

	public String getSuperAticleID() {
		return superAticleID;
	}

	public void setSuperAticleID(String superAticleID) {
		this.superAticleID = superAticleID;
	}

	/**
	 * 为打开名师文章添加页面做准备
	 * 
	 * @return
	 */
	public String openAddTeacherArticle() {
		try {
			pisposeSuperTeacherInfo();
			return "add";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 添加名师讲坛文章
	 * 
	 * @return
	 */
	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "articletitle", message = "标题不能为空!", trim = true),
			@RequiredStringValidator(fieldName = "metakeywords", message = "资源关键字不能为空!", trim = true),
			@RequiredStringValidator(fieldName = "articlesrccontent", message = "内容详情不能为空!", trim = true) })
	public String toAddTeacherArticle() {
		try {
			superAticleService
					.saveSuperAticle(superTeacherID, flag, articleSrc);
			this.addActionMessage("添加成功！");
			return openAddTeacherArticle();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除名师讲坛文章
	 * 
	 * @return
	 */
	public String deleteTeacherArticle() {
		try {
			superAticleService.updateSuperAticleByEnable(superAticleID);
			this.addActionMessage("删除成功!");
			return openTeacherArticle();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}

	}

	/**
	 * 为打开名师文章修改页面做准备
	 * 
	 * @return
	 */
	public String openModifyTeacherArticle() {
		try {
			SuperAticle superAticle = superAticleService.get(superAticleID);
			setAttribute("superAticle", superAticle);
			pisposeSuperTeacherInfo();
			return "update";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 修改名师讲坛文章
	 * 
	 * @return
	 */
	public String toModifyTeacherArticle() {
		try {
			superAticleService.updateSuperAticle(superAticleID, flag,
					articleSrc);
			this.addActionMessage("修改成功!");
			return openModifyTeacherArticle();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 打开名师讲坛文章管理列表
	 * 
	 * @return
	 */
	public String openTeacherArticle() {
		try {
			// 查询所有名师
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			String articletitle = getParameter("articletitle");// 标题
			result = superAticleService.findSuperAticleByPage(page,
					superTeacherID, flag, articletitle);

			setAttribute("list_superAticle", result.getContent());

			pisposeSuperTeacherInfo();

			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 处理名师信息
	 */
	private void pisposeSuperTeacherInfo() throws Exception {
		String username = getParameter("username");
		setAttribute("superTeacherID", superTeacherID);
		setAttribute("username", username);
	}
}
