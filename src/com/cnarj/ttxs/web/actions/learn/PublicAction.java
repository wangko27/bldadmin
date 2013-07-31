package com.cnarj.ttxs.web.actions.learn;

import java.util.List;

import com.cnarj.ttxs.admin.service.learn.IReadbookTypeService;
import com.cnarj.ttxs.pojo.learn.ReadSrcType;
import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.sys.IGradeCodeService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 学习频道Action类 - 公用的
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月18日
 */
public class PublicAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IReadbookTypeService readbookTypeService;

	private ISubjectCodeService subjectCodeService;

	private IGradeCodeService gradeCodeService;

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
	 * 获取博览群书下面的所有类别
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getReadsrctypeAllByBook() {
		try {
			// 查询所有类别
			List<ReadSrcType> list_readType = readbookTypeService
					.listReadSrcTypeByChild("8a8081a131bbac4d0131bbac8f5a0001");
			setAttribute("list_readType", list_readType);
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 获取所有科目
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getSubjectCodeAll() {
		try {
			List<SubjectCode> list_subjictCode = subjectCodeService.getAll();
			setAttribute("list_subjictCode", list_subjictCode);
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 获取所有年级
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getGradeCodeAll() {
		try {
			List<GradeCode> list_gradeCode = gradeCodeService.getAll();
			setAttribute("list_gradeCode", list_gradeCode);
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		try {
			return "login";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

}
