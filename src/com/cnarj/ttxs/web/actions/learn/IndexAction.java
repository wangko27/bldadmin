package com.cnarj.ttxs.web.actions.learn;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.admin.service.learn.IReadbookTypeService;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.learn.IOneDayOneTextService;
import com.cnarj.ttxs.service.learn.IPxldService;
import com.cnarj.ttxs.service.learn.IReadShoolService;
import com.cnarj.ttxs.service.learn.IReadTeacherInfoService;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.service.sys.IGradeCodeService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 学习频道Action类 - 首页
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月18日
 */
public class IndexAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IReadbookService readbookService;

	private IReadbookTypeService readbookTypeService;

	private ISubjectCodeService subjectCodeService;

	private IGradeCodeService gradeCodeService;

	private IReadTeacherInfoService readTeacherInfoService;

	private IReadShoolService readSchoolService;

	private IOneDayOneTextService oneTextService;

	private IPxldService pxldService;

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

	public IReadTeacherInfoService getReadTeacherInfoService() {
		return readTeacherInfoService;
	}

	public void setReadTeacherInfoService(
			IReadTeacherInfoService readTeacherInfoService) {
		this.readTeacherInfoService = readTeacherInfoService;
	}

	public IReadShoolService getReadSchoolService() {
		return readSchoolService;
	}

	public void setReadSchoolService(IReadShoolService readSchoolService) {
		this.readSchoolService = readSchoolService;
	}

	public IOneDayOneTextService getOneTextService() {
		return oneTextService;
	}

	public void setOneTextService(IOneDayOneTextService oneTextService) {
		this.oneTextService = oneTextService;
	}

	public IPxldService getPxldService() {
		return pxldService;
	}

	public void setPxldService(IPxldService pxldService) {
		this.pxldService = pxldService;
	}

	/**
	 * 首页
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String index() {
		try {

			// 存储当前日期
			Date nowdate=new Date();
			setAttribute("nowdate", nowdate);

			// 查询一天一课内容(显示最新两条)按创建时间
			// 默认查一年级的
			String gradecode = "8a8081a131bd7ec20131bd1234560001";
			if (null != getParameter("gradecode")
					&& !"".equals(getParameter("gradecode"))) {
				gradecode = getParameter("gradecode");
			}
			setAttribute("gradecode", gradecode);
			List<ReadSrc> list_oneday_new = oneTextService.listReadOnedayByNew(
					gradecode, 2);
			for (ReadSrc r : list_oneday_new) {
				r.setContentintro(HtmlUtil.splitAndFilterString(r
						.getContentintro(), 110));
			}
			setAttribute("list_oneday_new", list_oneday_new);

			// 查询最新的品学论道信息 按发表时间降序
			List list_pxld_recommend = pxldService.listArticleByRecommend(8);
			setAttribute("list_pxld_recommend", list_pxld_recommend);

			// 查询推荐的博览群书 按发表时间降序 如果不足12条则用最新的补充
			List list_book_recommend = readbookService
					.listReadbookByRecommend(12);
			setAttribute("list_book_recommend", list_book_recommend);
			// 查询小学的博览群书 按发表时间降序
			String[] gradecodes_xx = new String[] {
					"8a8081a131bd7ec20131bd1234560001",
					"8a8081a131bd7ec20131bd7f78e53331",
					"8a8081a131bd7ec20131bd7f78e50221",
					"8a8081a131bd7ec20131bd7f78e50001",
					"8a8081a131bd7ec20131bd7f78e50002",
					"8a8081a131bd7ec20131bd7f78e50003" };
			List list_readbook_xx = readbookService.listReadbookByGrade(
					gradecodes_xx, 5);
			setAttribute("list_readbook_xx", list_readbook_xx);
			// 查询中学的博览群书 按发表时间降序
			String[] gradecodes_zx = new String[] {
					"8a8081a131bd7ec20131bd7f78e50004",
					"8a8081a131bd7ec20131bd7f78e50005",
					"8a8081a131bd7ec20131bd7f78e50006" };
			List list_readbook_zx = readbookService.listReadbookByGrade(
					gradecodes_zx, 5);
			setAttribute("list_readbook_zx", list_readbook_zx);
			// 查询高中的博览群书 按发表时间降序
			String[] gradecodes_gz = new String[] {
					"8a8081a131bd7ec20131bd7f78e50007",
					"8a8081a131bd7ec20131bd7f78e50008",
					"8a8081a131bd7ec20131bd7f78e50009" };
			List list_readbook_gz = readbookService.listReadbookByGrade(
					gradecodes_gz, 5);
			setAttribute("list_readbook_gz", list_readbook_gz);

			// 查询最新的名校信息
			List<ArticleSrc> list_school_new = readTeacherInfoService.getSuperSchools(5);
			// 去除学校介绍HTML代码
			for (ArticleSrc a : list_school_new) {
				a.setArticlesrccontent(HtmlUtil.splitAndFilterString(a
						.getArticlesrccontent(), 150));
			}
			setAttribute("list_school_new", list_school_new);

			// 查询推荐的名校信息 按发表时间降序
			List<ArticleSrc> list_school_recommend = readSchoolService
					.listSchoolsByRecommend(4);
			setAttribute("list_school_recommend", list_school_recommend);

			// 查询置顶的四条名校信息
			//List list_school_top = readSchoolService.listSchoolsByTop(4);
			//setAttribute("list_school_top", list_school_top);
			//查询推荐的名校信息
			List<ArticleSrc> list_school_recommend1 = readSchoolService
			.listSchoolsByRecommend(12);
			setAttribute("list_school_recommend1", list_school_recommend1);

			// 查询最新的名师信息
			List list_teacher = readTeacherInfoService.getSuperAticle(5);
			setAttribute("list_teacher", list_teacher);

			// 查询热点人物
			List list_teacher_hot = readTeacherInfoService
					.listSuperTeachersByHot(50);
			setAttribute("list_teacher_hot", list_teacher_hot);
			return "index";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
}
