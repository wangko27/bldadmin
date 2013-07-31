package com.cnarj.ttxs.admin.actions.learn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.admin.service.learn.IReadbookService;
import com.cnarj.ttxs.admin.service.learn.IReadbookTypeService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.learn.ReadSrcType;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 学习频道后台Action类 - 博览群书类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public class ReadbookTypeAction extends PageAction implements
		ModelDriven<ReadSrcType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ReadSrcType readSrcType = new ReadSrcType();

	IReadbookTypeService readbookTypeService;

	IReadbookService readbookService;

	public IReadbookTypeService getReadbookTypeService() {
		return readbookTypeService;
	}

	public void setReadbookTypeService(IReadbookTypeService readbookTypeService) {
		this.readbookTypeService = readbookTypeService;
	}

	public IReadbookService getReadbookService() {
		return readbookService;
	}

	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
	}

	public ReadSrcType getModel() {
		return readSrcType;
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "srctype", message = "类别名称不能为空!", trim = true) })
	public String add() {
		try {
			// 判断名称是否存在
			boolean isexist = readbookTypeService.isExist("srctype",
					readSrcType.getSrctype());
			if (isexist) {
				this.addActionError("该类别名称已经存在!");
			} else {
				readbookTypeService.saveReadSrcType(readSrcType);
				this.addActionMessage("添加成功！");
			}
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
			ReadSrcType readSrcTypeNew = readbookTypeService
					.getReadSrcTypeByTypeid(readSrcType.getSrctypeid());
			if (null != readSrcTypeNew) {
				setAttribute("readSrcType", readSrcTypeNew);
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "srctype", message = "类别名称不能为空!", trim = true) })
	public String update() {
		try {
			// 判断名称是否存在
			boolean isexist = readbookTypeService.isExist("srctype",
					readSrcType.getSrctype());
			if (isexist) {
				this.addActionError("该类别名称已经存在!");
			} else {
				readbookTypeService.updateReadSrcType(readSrcType);
				this.addActionMessage("修改成功！");
			}
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
			Long totalRecords = readbookTypeService.getTotalCount();

			// 创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());

			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(ReadSrcType.class);
			detachedCriteria.addOrder(Order.asc("modifydate"));
			result = readbookTypeService.findByPager(page, detachedCriteria);

			setAttribute("list_readType", result.getContent());
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
			boolean result = readbookService.isExist("readSrcType.srctypeid",
					readSrcType.getSrctypeid());
			if (result) {
				this.addActionMessage("该类别下还有书籍，请先删除！");
			} else {
				readbookTypeService.deleteReadSrcType(readSrcType
						.getSrctypeid());
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
	public List getReadsrctype() {
		try {
			// 查询所有类别
			List<ReadSrcType> list_readType = readbookTypeService
					.listReadSrcTypeAll();
			return list_readType;
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
	public String getReadsrctypeOption() {
		try {
			List<ReadSrcType> list_readSrcType = readbookTypeService.getList(
					"readSrcType.srctypeid", readSrcType.getSrctypeid());
			StringBuffer sbOption = new StringBuffer();
			for (ReadSrcType rt : list_readSrcType) {
				sbOption.append("<option value=\"" + rt.getSrctypeid() + "\">");
				sbOption.append(rt.getSrctype());
				sbOption.append("</option>");
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
	public String loadReadTypeOption() {
		try {

			List readtypeidParent = readSrcTypeRecursion(readSrcType
					.getSrctypeid());
			StringBuffer sbOption = new StringBuffer();
			int j = 0;// 第几级菜单
			for (int i = readtypeidParent.size() - 1; i >= 0; i--) {
				List<ReadSrcType> list_readSrcType = readbookTypeService
						.getList("readSrcType.srctypeid", readtypeidParent
								.get(i));
				if (j != 0) {
					sbOption.append("<span id=\"spantype" + (j - 1) + "\">");
				}

				sbOption.append("<select name=\"srctypeid" + j
						+ "\" id=\"srctypeid" + j + "\" ");
				sbOption.append(" onchange=\"typeChange(this.value," + j
						+ ")\"");
				sbOption.append(" >");

				for (ReadSrcType rt : list_readSrcType) {
					sbOption.append("<option value=\"" + rt.getSrctypeid()
							+ "\" ");
					if (rt.getSrctypeid().equals(readSrcType.getSrctypeid())) {
						sbOption.append("selected");
					}
					sbOption.append(" >");
					sbOption.append(rt.getSrctype());
					sbOption.append("</option>");
				}
				sbOption.append("</select>");
				sbOption.append("</span>");
				sbOption.append(" <script>$(\"#level\").val(\"" + j
						+ "\")</script>");
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
	public List readSrcTypeRecursion(String srctypeid) {
		if (null == srctypeid) {
			srctypeid = "";
		}
		ReadSrcType readSrcType = readbookTypeService.get("srctypeid",
				srctypeid);
		if (null != readSrcType) {
			String parentid = null;
			if (null != readSrcType.getReadSrcType()) {// 有父级
				parentid = readSrcType.getReadSrcType().getSrctypeid();
			}
			list_type.add(parentid);
			readSrcTypeRecursion(parentid);
		}

		return list_type;
	}

}
