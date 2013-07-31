package com.cnarj.ttxs.web.actions.learn;

import java.util.List;


import com.cnarj.ttxs.admin.service.learn.IReadbookTypeService;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.service.sys.IGradeCodeService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 学习频道Action类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public class ReadbookAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IReadbookService readbookService;

	private IReadbookTypeService readbookTypeService;

	private ISubjectCodeService subjectCodeService;

	private IGradeCodeService gradeCodeService;

	public IReadbookService getReadbookService() {
		return readbookService;
	}

	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
	}

	public IReadbookTypeService getReadbookTypeService() {
		return readbookTypeService;
	}

	public void setReadbookTypeService(IReadbookTypeService readbookTypeService) {
		this.readbookTypeService = readbookTypeService;
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

	/**
	 * 博览群书列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String list() {
		try {
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(8);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			String srctypeid = getParameter("srctypeid");// 类别
			String subjectcode = getParameter("subjectcode");// 科目
			String gradecode = getParameter("gradecode");// 年级
			String order = getParameter("order");// 排序
			if (null == order && !"".equals(order)) {
				order = "modifydate";
			}
			result = readbookService.listReadbookByPager(page, srctypeid,
					subjectcode, gradecode, order);
			
			List<ReadSrc> list_readbook=result.getContent();
			for(ReadSrc r:list_readbook){
				r.setContentintro(HtmlUtil.splitAndFilterString(r
						.getContentintro(), 110));
			}

			setAttribute("list_readSrc", list_readbook);
			return "list";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 群览群书详情
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String view() {
		try {
			String readsrcid = getParameter("readsrcid");
			ReadSrc readSrc = readbookService.get(readsrcid);
			// 阅读次数加一
			readSrc.setReadnum(readSrc.getReadnum() + 1);
			readbookService.update(readSrc);

			if (null != readSrc) {
				setAttribute("readSrc", readSrc);
			}

			// 查询相关阅读
			List list_correlateRead = readbookService.listCorrelateRead(
					readsrcid, readSrc.getSrckeywords(), 5);
			setAttribute("list_correlateRead", list_correlateRead);

			// 查询该文章的相关评论
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(10);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = readbookService.listReadCommentedByPager(page, readsrcid);

			setAttribute("list_readCommented", result.getContent());

			return "view";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
}
