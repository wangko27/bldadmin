package com.cnarj.ttxs.admin.actions.interest;

import com.cnarj.ttxs.admin.service.interest.IActivityProgramaService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 兴趣频道后台Action类 - 活动栏目
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityProgramaAction extends PageAction implements
		ModelDriven<ActivityPrograma> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ActivityPrograma programa = new ActivityPrograma();

	IActivityProgramaService activityProgramaService;

	public ActivityPrograma getModel() {
		return programa;
	}

	public IActivityProgramaService getActivityProgramaService() {
		return activityProgramaService;
	}

	public void setActivityProgramaService(
			IActivityProgramaService activityProgramaService) {
		this.activityProgramaService = activityProgramaService;
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "proName", message = "栏目名称不能为空!", trim = true) })
	public String add() {
		try {
			activityProgramaService.savePrograma(programa);
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

			result = activityProgramaService.findProgramaByPager(page, programa
					.getProName(), programa.getProIsenable());

			setAttribute("list_programa", result.getContent());
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
			ActivityPrograma programaNew = activityProgramaService.get(programa
					.getProID());
			if (null != programaNew) {
				setAttribute("programa", programaNew);
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "proName", message = "栏目名称不能为空!", trim = true) })
	public String update() {
		try {
			activityProgramaService.updatePrograma(programa);
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
			ActivityPrograma programaNew = activityProgramaService.get(programa
					.getProID());
			if (programaNew.getActivitys().size() > 0
					|| programaNew.getActivityTypes().size() > 0) {
				this.addActionMessage("该类别下还有活动或活动分类，请先删除！");
			} else {
				activityProgramaService.deletePrograma(programa.getProID());
				this.addActionMessage("删除成功！");
			}
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

}
