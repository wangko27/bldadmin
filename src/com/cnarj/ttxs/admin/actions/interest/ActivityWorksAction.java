package com.cnarj.ttxs.admin.actions.interest;

import java.io.File;
import java.util.List;

import com.cnarj.ttxs.admin.service.interest.IActivityService;
import com.cnarj.ttxs.admin.service.interest.IActivityWorksService;
import com.cnarj.ttxs.admin.service.user.IMemberService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 兴趣频道后台Action类 - 活动作品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityWorksAction extends PageAction implements
		ModelDriven<ActivityWorks> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ActivityWorks activityWorks = new ActivityWorks();

	IActivityWorksService activityWorksService;

	IActivityService activityService;

	IMemberService memberService;

	File cover;// 封面
	String coverFileName;
	String coverContentType;

	File show;// 封面
	String showFileName;
	String showContentType;

	public ActivityWorks getModel() {
		return activityWorks;
	}

	public IActivityWorksService getActivityWorksService() {
		return activityWorksService;
	}

	public void setActivityWorksService(
			IActivityWorksService activityWorksService) {
		this.activityWorksService = activityWorksService;
	}

	public IActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
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

	public File getShow() {
		return show;
	}

	public void setShow(File show) {
		this.show = show;
	}

	public String getShowFileName() {
		return showFileName;
	}

	public void setShowFileName(String showFileName) {
		this.showFileName = showFileName;
	}

	public String getShowContentType() {
		return showContentType;
	}

	public void setShowContentType(String showContentType) {
		this.showContentType = showContentType;
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
			String activityid = getParameter("activityid");

			Activity activity = activityService.get(activityid);
			setAttribute("activity", activity);

			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = activityWorksService.findActivityWorksByPager(page,
					activityid, activityWorks.getWorksnumber(), activityWorks
							.getWorkstitle(), activityWorks.getAuthor());

			setAttribute("list_activityWorks", result.getContent());
			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 打开作品审核管理页面
	 * 
	 * @return
	 */
	public String openWorksAudit() {
		try {
			String activityid = getParameter("activityid");

			Activity activity = activityService.get(activityid);
			setAttribute("activity", activity);

			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = activityWorksService.findActivityWorksByPager(page,
					activityid, activityWorks.getWorksnumber(), activityWorks
							.getWorkstitle(), activityWorks.getAuthor());

			setAttribute("list_activityWorks", result.getContent());
			return "auditManage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 审核作品
	 * 
	 * @return
	 */
	public String toAuditWorks() {
		try {
			ActivityWorks activityWorksNew = activityWorksService
					.get(activityWorks.getWorksid());
			activityWorksNew.setApprostatu(activityWorks.getApprostatu());// 审核通过
			activityWorksService.update(activityWorksNew);
			this.addActionMessage("审核成功!");
			return openWorksAudit();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 作品预览
	 * 
	 * @return
	 */
	public String openWorksView() {
		try {
			ActivityWorks activityWorksNew = activityWorksService
					.get(activityWorks.getWorksid());
			setAttribute("works", activityWorksNew);
			return "view";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
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
			String activityid = getParameter("activityid");

			Activity activity = activityService.get(activityid);
			setAttribute("activity", activity);

			// 查询会员
			Long memberType = new Long(1);
			if (null != getParameter("memberType")) {
				memberType = new Long(getParameter("memberType"));
			}
			List list_member = memberService.getList("memberType", memberType);
			setAttribute("list_member", list_member);

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
	public String add() {
		try {
			if (null != cover && ((cover.length() / 1024) > 300)) {
				this.addActionMessage("封面最大只能上传300K!");
			} else {
				if (null != show && (show.length() / 1024) > 300) {
					this.addActionMessage("展示图片最大只能上传300K!");
				} else {

					List<ActivityWorks> list_workds = activityWorksService
							.getList("member.memberid", activityWorks
									.getMember().getMemberid());
					if (null != list_workds && list_workds.size() >= 10) {
						this.addActionMessage("一个作者最多只能有10副作品，该作者已添加"
								+ list_workds.size() + "副作品!");
					} else {
						// 添加
						activityWorksService.saveActivityWorks(activityWorks,
								cover, coverFileName, coverContentType, show,
								showFileName, showContentType);
						this.addActionMessage("添加成功!");
					}
				}
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
	 */
	public String updatePage() {
		try {

			String activityid = getParameter("activityid");

			Activity activity = activityService.get(activityid);
			setAttribute("activity", activity);

			ActivityWorks activityWorksNew = activityWorksService
					.get(activityWorks.getWorksid());
			setAttribute("activityWorks", activityWorksNew);

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
	 */
	public String update() {
		try {
			activityWorksService.updateActivityWorks(activityWorks, cover,
					coverFileName, coverContentType, show, showFileName,
					showContentType);
			this.addActionMessage("修改成功!");
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
			activityWorksService
					.deleteActivityWorks(activityWorks.getWorksid());
			this.addActionMessage("删除成功!");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 根据类别会员选项（下拉菜单）
	 * 
	 * @return
	 */
	public String getMemberOption() {
		try {
			Long memberType = new Long(1);
			if (null != getParameter("memberType")) {
				memberType = new Long(getParameter("memberType"));
			}
			// 查询会员
			List<Member> list_member = memberService.getList("memberType",
					memberType);
			StringBuffer sbOption = new StringBuffer();
			for (Member m : list_member) {
				sbOption.append("<option value=\"");
				sbOption.append(m.getMemberid());
				sbOption.append("\">");
				sbOption.append(m.getUsername());
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
}
