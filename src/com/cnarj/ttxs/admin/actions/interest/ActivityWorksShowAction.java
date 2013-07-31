package com.cnarj.ttxs.admin.actions.interest;

import java.io.File;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.admin.service.interest.IActivityWorksShowService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 兴趣频道后台Action类 - 首页活动作品展示
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityWorksShowAction extends PageAction implements
		ModelDriven<ActivityWorksShow> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ActivityWorksShow activityWorksShow = new ActivityWorksShow();

	IActivityWorksShowService activityWorksShowService;

	File cover;// 封面
	String coverFileName;
	String coverContentType;

	public ActivityWorksShow getModel() {
		return activityWorksShow;
	}

	public IActivityWorksShowService getActivityWorksShowService() {
		return activityWorksShowService;
	}

	public void setActivityWorksShowService(
			IActivityWorksShowService activityWorksShowService) {
		this.activityWorksShowService = activityWorksShowService;
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
	 * 添加
	 * 
	 * @return
	 */
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "showTitle", message = "显示标题不能为空!", trim = true) })
	public String add() {
		try {
			activityWorksShowService.saveActivityWorksShow(activityWorksShow,
					cover, coverFileName, coverContentType);
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

			// 总数目
			Long totalRecords = activityWorksShowService.getTotalCount();

			// 创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());

			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(ActivityWorksShow.class);
			detachedCriteria.addOrder(Order.desc("showModifydate"));
			result = activityWorksShowService.findByPager(page,
					detachedCriteria);

			setAttribute("list_worksShow", result.getContent());
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
			ActivityWorksShow activityWorksShowNew = activityWorksShowService
					.get(activityWorksShow.getShowId());
			if (null != activityWorksShowNew) {
				setAttribute("activityWorksShow", activityWorksShowNew);
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "showTitle", message = "显示标题不能为空!", trim = true) })
	public String update() {
		try {
			activityWorksShowService.updateActivityWorksShow(activityWorksShow,
					cover, coverFileName, coverContentType);
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
			activityWorksShowService.deleteActivityWorksShow(activityWorksShow
					.getShowId());
			this.addActionMessage("删除成功！");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

}
