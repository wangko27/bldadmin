package com.cnarj.ttxs.admin.actions.comm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.admin.service.comm.IArticleService;
import com.cnarj.ttxs.admin.service.comm.IArticleTypeService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 学习频道后台Action类 - 文章类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public class ArticleTypeAction extends PageAction implements
		ModelDriven<ArticleType> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArticleType articleType = new ArticleType();

	IArticleTypeService articleTypeService;

	IArticleService articleService;

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

	public ArticleType getModel() {
		return articleType;
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "articletypename", message = "类别名称不能为空!", trim = true) })
	public String add() {
		try {
			/*
			 * // 判断名称是否存在 boolean isexist =
			 * articleTypeService.isExist("articletypename",
			 * articleType.getArticletypename()); if (isexist) {
			 * this.addActionError("该类别名称已经存在!"); } else { }
			 */
			articleTypeService.saveArticleType(articleType);
			this.addActionMessage("添加成功！");
			return addPage();
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
			ArticleType articleTypeNew = articleTypeService.get(articleType
					.getArticletypeid());
			if (null != articleTypeNew) {
				setAttribute("articleType", articleTypeNew);
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "articletypename", message = "类别名称不能为空!", trim = true) })
	public String update() {
		try {
			/*
			 * ArticleType articleTypeNew = articleTypeService.get(articleType
			 * .getArticletypeid()); if
			 * (!articleTypeNew.getArticletypename().equals(
			 * articleType.getArticletypename())) { // 判断名称是否存在 boolean isexist =
			 * articleTypeService.isExist("articletypename",
			 * articleType.getArticletypename()); if (isexist) {
			 * 
			 * this.addActionError("该类别名称已经存在!"); } } else { }
			 */
			articleTypeService.updateArticleType(articleType);
			this.addActionMessage("修改成功！");
			return updatePage();
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
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String manage() {
		try {
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			// 总数目
			Long totalRecords = articleTypeService.getTotalCount();

			// 创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());

			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(ArticleType.class);
			detachedCriteria.addOrder(Order.asc("articlesort"));
			result = articleTypeService.findByPager(page, detachedCriteria);

			setAttribute("list_articleType", result.getContent());
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
			// 判断该类型下面是否有文章
			boolean result = articleService
					.isExist("articleType.articletypeid", articleType
							.getArticletypeid());
			if (result) {
				this.addActionMessage("该类别下还有文章，请先删除！");
			} else {
				articleTypeService.delete(articleType.getArticletypeid());
				this.addActionMessage("删除成功！");
			}
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 获取所有类别
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getArticleTypeAll() {
		try {
			// 查询所有类别
			List<ArticleType> list_articleType = articleTypeService.getAll();
			return list_articleType;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return new ArrayList();
	}

	/**
	 * 类别级联
	 * 
	 * @return
	 */
	public String getArticleTypeOption() {
		try {
			List<ArticleType> list_articleType = articleTypeService
					.getList("articleType.articletypeid", articleType
							.getArticletypeid());
			StringBuffer sbOption = new StringBuffer();
			for (ArticleType at : list_articleType) {
				if (!at.getArticletypeid().equals(
						"8a8081a131cd5fcd0131cd69c8930002")) {// 不显示名校风采类别
					sbOption.append("<option value=\"" + at.getArticletypeid()
							+ "\">");
					sbOption.append(at.getArticletypename());
					sbOption.append("</option>");
				}
			}
			getResponse().getWriter().print(sbOption.toString());
			getResponse().getWriter().close();
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 根据类别ID，初始化类别级联
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String loadArticleTypeOption() {
		try {

			// 当前类别
			ArticleType articleTypeCurr = articleTypeService.get(articleType
					.getArticletypeid());

			List articletypeidParent = articleTypeRecursion(articleType
					.getArticletypeid());
			StringBuffer sbOption = new StringBuffer();
			int j = 0;// 第几级菜单
			for (int i = articletypeidParent.size() - 1; i >= 0; i--) {
				List<ArticleType> list_articleType = articleTypeService
						.getList("articleType.articletypeid",
								articletypeidParent.get(i));
				if (null != articletypeidParent.get(i)) {
					sbOption.append("<span id=\"spantype" + (j - 1) + "\">");
					sbOption.append("<select name=\"articletypeid" + j
							+ "\" id=\"articletypeid" + j + "\" ");
					sbOption.append(" onchange=\"typeChange(this.value," + j
							+ ")\"");
					sbOption.append(" >");

					for (ArticleType at : list_articleType) {
						sbOption.append("<option value=\""
								+ at.getArticletypeid() + "\" ");
						// 当前子类选中，当前父类选中
						if (at.getArticletypeid().equals(
								articleType.getArticletypeid())
								|| at.getArticletypeid().equals(
										articleTypeCurr.getArticleType()
												.getArticletypeid())) {
							sbOption.append("selected");
						}
						sbOption.append(" >");
						sbOption.append(at.getArticletypename());
						sbOption.append("</option>");
					}
					sbOption.append("</select>");
					sbOption.append("</span>");
					if (i == 0) {
						sbOption.append("<span id=\"spantype" + (j) + "\">");
						sbOption.append("</span>");
					}
					sbOption.append(" <script>$(\"#level\").val(\"" + j
							+ "\")</script>");
				}
				j++;
			}
			getResponse().getWriter().print(sbOption.toString());
			getResponse().getWriter().close();
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	@SuppressWarnings("unchecked")
	List list_type = new ArrayList();

	/**
	 * 获取该类别所有父级(父级递归，一直到没有父级为止)
	 * 
	 * @param articletypeid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List articleTypeRecursion(String articletypeid) {
		if (null == articletypeid) {
			articletypeid = "";
		}
		ArticleType articleType = articleTypeService.get("articletypeid",
				articletypeid);
		if (null != articleType) {
			String parentid = null;
			if (null != articleType.getArticleType()) {// 有父级
				parentid = articleType.getArticleType().getArticletypeid();
			}
			list_type.add(parentid);
			articleTypeRecursion(parentid);
		}

		return list_type;
	}

}
