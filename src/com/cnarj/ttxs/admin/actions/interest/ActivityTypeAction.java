package com.cnarj.ttxs.admin.actions.interest;

import java.util.List;

import com.cnarj.ttxs.admin.service.interest.IActivityProgramaService;
import com.cnarj.ttxs.admin.service.interest.IActivityTypeService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.interest.ActivityType;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 兴趣频道后台Action类 - 活动分类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityTypeAction extends PageAction implements
		ModelDriven<ActivityType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ActivityType activityType = new ActivityType();

	IActivityTypeService activityTypeService;

	IActivityProgramaService activityProgramaService;

	public ActivityType getModel() {
		return activityType;
	}

	public IActivityTypeService getActivityTypeService() {
		return activityTypeService;
	}

	public void setActivityTypeService(IActivityTypeService activityTypeService) {
		this.activityTypeService = activityTypeService;
	}

	public IActivityProgramaService getActivityProgramaService() {
		return activityProgramaService;
	}

	public void setActivityProgramaService(
			IActivityProgramaService activityProgramaService) {
		this.activityProgramaService = activityProgramaService;
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	public String addPage() {
		try {
			// 查询栏目
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
	 */
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "typeName", message = "类别名称不能为空!", trim = true) })
	public String add() {
		try {
			activityTypeService.saveActivityType(activityType);
			this.addActionMessage("添加成功!");
			return "add";
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

			String proID = "";
			if (null != activityType.getPrograma()) {
				proID = activityType.getPrograma().getProID();
			}

			result = activityTypeService.findActivityTypeByPager(page,
					activityType.getTypeName(), proID);

			setAttribute("list_activityType", result.getContent());
			return "manage";
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
			ActivityType activityTypeNew = activityTypeService.get(activityType
					.getTypeId());
			if (null != activityTypeNew) {
				setAttribute("activityType", activityTypeNew);
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "typeName", message = "类别名称不能为空!", trim = true) })
	public String update() {
		try {
			activityTypeService.updateActivityType(activityType);
			this.addActionMessage("修改成功！");
			return updatePage();
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
			// 判断该类型下面是否有活动
			ActivityType activityTypeNew = activityTypeService.get(activityType
					.getTypeId());
			if (activityTypeNew.getActivitys().size() > 0) {
				this.addActionMessage("该类别下还有活动,请先删除！");
			} else {
				activityTypeService.delete(activityType.getTypeId());
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
	 * 查询某栏目下面所有类别(下拉选项)
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getActivityTypeByOption() {
		try {
			String proID = getParameter("proID");
			String str_option = activityTypeService
					.getActivityTypeByOption(proID);
			getResponse().getWriter().print(str_option);
			getResponse().getWriter().close();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
		return null;
	}

	/**
	 * 查询所有可用的栏目
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getProgramaAll() {
		try {
			List list_programa = activityProgramaService.getList("proIsenable",
					new Long(1));
			return list_programa;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
