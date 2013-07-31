package com.cnarj.ttxs.admin.actions.interest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.admin.service.interest.IActivityProgramaService;
import com.cnarj.ttxs.admin.service.interest.IActivityService;
import com.cnarj.ttxs.admin.service.interest.IActivityTypeService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 兴趣频道后台Action类 - 活动
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityAction extends PageAction implements ModelDriven<Activity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Activity activity = new Activity();

	private IActivityService activityService;

	private IActivityProgramaService activityProgramaService;

	private IActivityTypeService activityTypeService;

	private ISysArticleService sysarticleService;

	private File cover;// 封面
	private String coverFileName;
	private String coverContentType;

	private File featured;// 活动专题图片
	private String featuredFileName;
	private String featuredContentType;

	public Activity getModel() {
		return activity;
	}

	public IActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

	public IActivityProgramaService getActivityProgramaService() {
		return activityProgramaService;
	}

	public void setActivityProgramaService(
			IActivityProgramaService activityProgramaService) {
		this.activityProgramaService = activityProgramaService;
	}

	public ISysArticleService getSysarticleService() {
		return sysarticleService;
	}

	public void setSysarticleService(ISysArticleService sysarticleService) {
		this.sysarticleService = sysarticleService;
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

	public IActivityTypeService getActivityTypeService() {
		return activityTypeService;
	}

	public void setActivityTypeService(IActivityTypeService activityTypeService) {
		this.activityTypeService = activityTypeService;
	}

	public File getFeatured() {
		return featured;
	}

	public void setFeatured(File featured) {
		this.featured = featured;
	}

	public String getFeaturedFileName() {
		return featuredFileName;
	}

	public void setFeaturedFileName(String featuredFileName) {
		this.featuredFileName = featuredFileName;
	}

	public String getFeaturedContentType() {
		return featuredContentType;
	}

	public void setFeaturedContentType(String featuredContentType) {
		this.featuredContentType = featuredContentType;
	}

	/**
	 * 添加页面
	 * 
	 * @return
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
	 */
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "activitytitle", message = "类别名称不能为空!", trim = true) })
	public String add() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionError("封面最大只能上传50KB!");
				return "add";
			}
			if (null != featured && ((featured.length() / 1024) > 200)) {
				this.addActionError("活动专题图片最大只能上传200KB!");
				return "add";
			}
			// 活动名称是否存在
			if (null != activityService.get("activitytitle", activity
					.getActivitytitle())) {
				this.addActionMessage("活动名称已存在!");
			} else {
				activityService.saveActivity(activity, cover, coverFileName,
						coverContentType, featured, featuredFileName,
						featuredContentType);
				this.addActionMessage("添加成功!");
			}
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
			if (null != activity.getPrograma()) {
				proID = activity.getPrograma().getProID();
			}
			String typeId = "";
			if (null != activity.getActivityType()) {
				typeId = activity.getActivityType().getTypeId();
			}

			result = activityService.findActivityByPager(page, activity
					.getActivitytitle(), proID, typeId);

			setAttribute("list_activity", result.getContent());
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
			Activity activityNew = activityService
					.get(activity.getActivityid());
			if (null != activityNew) {
				setAttribute("activity", activityNew);
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
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "activitytitle", message = "类别名称不能为空!", trim = true) })
	public String update() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionError("封面最大只能上传50KB!");
				return updatePage();
			}
			if (null != featured && ((featured.length() / 1024) > 200)) {
				this.addActionError("活动专题图片最大只能上传200KB!");
				return updatePage();
			}
			// 活动名称是否存在
			Activity activityNew = activityService.get("activitytitle",
					activity.getActivitytitle());
			if (null != activityNew
					&& !activity.getActivityid().equals(
							activityNew.getActivityid())) {
				this.addActionMessage("活动名称已存在!");
			} else {
				activityService.updateActivity(activity, cover, coverFileName,
						coverContentType, featured, featuredFileName,
						featuredContentType);
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
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		try {
			// 判断该活动下面是否有作品
			Activity activityNew = activityService
					.get(activity.getActivityid());
			if (activityNew.getActivityWorkses().size() > 0) {
				this.addActionMessage("该活动下还有作品,请先删除！");
				return manage();
			} else {

				// 判断该活动下面是否还有行业知识和活动公告
				List<Article> list_article = sysarticleService.getList(
						"articleType.articletypeid", activityNew
								.getSysnotesid());
				if (null != list_article && list_article.size() > 0) {
					this.addActionMessage("该活动下还有活动公告,请先删除！");
					return manage();
				}

				list_article = sysarticleService.getList(
						"articleType.articletypeid", activityNew
								.getIndustryid());
				if (null != list_article && list_article.size() > 0) {
					this.addActionMessage("该活动下还有行业知识,请先删除！");
					return manage();
				}

				activityService.deleteActivity(activity.getActivityid());
				this.addActionMessage("删除成功！");
				return manage();
			}
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 线下图片管理
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String picManage() {
		try {
			Activity activityNew = activityService
					.get(getParameter("activityid"));
			if (null != activityNew) {
				setAttribute("activity", activityNew);
			}

			// 获取所有线下图片的绝对路径
			File file = new File(getRealPath() + activityNew.getUnlinepath());
			File[] filelist = file.listFiles();
			// 存储活动线下图片路径（相对路径）
			List list_unlinepath = new ArrayList();
			if (null != filelist && filelist.length > 0) {
				for (int i = 0; i < filelist.length; i++) {
					String relative = filelist[i].getAbsolutePath();
					if (null != relative) {
						relative = relative.substring(relative
								.indexOf("uploadfiles"), relative.length());
					}
					list_unlinepath.add(relative);
				}
			}
			setAttribute("list_unlinepath", list_unlinepath);
			return "picManage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
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
