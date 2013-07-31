package com.cnarj.ttxs.admin.actions.learn;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.admin.service.learn.IReadbookService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.sys.IGradeCodeService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 学习频道后台Action类 - 一天一课
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月23日
 * 
 */
public class OnedayAction extends PageAction implements ModelDriven<ReadSrc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IReadbookService readbookService;

	private ISubjectCodeService subjectCodeService;

	private IGradeCodeService gradeCodeService;

	ReadSrc readSrc = new ReadSrc();

	File cover;// 封面
	String coverFileName;
	String coverContentType;

	File resource;// 资源（书籍）
	String resourceFileName;
	String resourceContentType;

	public IReadbookService getReadbookService() {
		return readbookService;
	}

	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
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

	public ReadSrc getModel() {
		return readSrc;
	}

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public String getResourceFileName() {
		return resourceFileName;
	}

	public void setResourceFileName(String resourceFileName) {
		this.resourceFileName = resourceFileName;
	}

	public String getResourceContentType() {
		return resourceContentType;
	}

	public void setResourceContentType(String resourceContentType) {
		this.resourceContentType = resourceContentType;
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
	 * 为打开一天一课添加页面做准备
	 * 
	 * @return
	 * @throws Exception
	 */
	public String openAddOneday() {
		try {
			return "add";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 添加一天一课文件上传大小验证
	 */
	public void validateToAddOneday() {
		// cover.length() 为字节
		if (null != cover && ((cover.length() / 1024) > 50)) {
			this.addActionError("封面最大只能上传50KB!");
		}
		if (null != resource) {
			// 获得文件后缀名
			String extension = resourceFileName.substring(resourceFileName
					.lastIndexOf(".") + 1);
			extension = extension.toUpperCase();
			if ("RAR".equals(extension) || "ZIP".equals(extension)) {
				if (((resource.length() / 1024) / 1024) > 10) {
					this.addActionError("课件RAR格式最大只能上传10M!");
				}
			}
			if ("PPT".equals(extension)) {
				if (((resource.length() / 1024) / 1024) > 5) {
					this.addActionError("课件PPT格式最大只能上传5M!");
				}
			}
			if ("DOC".equals(extension) || "TXT".equals(extension)
					|| "XLS".equals(extension) || "PDF".equals(extension)) {
				if (((resource.length() / 1024) / 1024) > 1) {
					this.addActionError("课件DOC、TXT、XLS、PDF格式最大只能上传1M!");
				}
			}
			if ("JPG".equals(extension) || "GIF".equals(extension)
					|| "PNG".equals(extension) || "BMP".equals(extension)) {
				if (((resource.length() / 1024) / 1024) > 2) {
					this.addActionError("课件JPG、GIF、PNG、BMP格式最大只能上传2M!");
				}
			}
		}
	}

	/**
	 * 添加一天一课
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toAddOneday() {
		try {

			readbookService.saveReadSrcByOneday(readSrc, cover, coverFileName,
					coverContentType, resource, resourceFileName,
					resourceContentType);

			this.addActionMessage("添加成功！");
			return "add";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 打开一天一课管理页面
	 * 
	 * @return
	 */
	public String openOneday() {
		try {// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			String subjectcode = getParameter("subjectcode");
			String gradecode = getParameter("gradecode");
			result = readbookService.listReadsrcByOnedayPage(page, subjectcode,
					gradecode, readSrc.getReadsrctile(), "1");

			setAttribute("list_readSrc", result.getContent());
			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除一天一课
	 * 
	 * @return
	 */
	public String deleteOneday() {
		try {
			readbookService.updateReadsrcByEnable(readSrc.getReadsrcid());
			this.addActionMessage("删除成功！");
			return openOneday();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 为打开一天一课修改页面做准备
	 * 
	 * @return
	 * @throws Exception
	 */
	public String openModifyOneday() {
		try {
			ReadSrc readSrcNew = readbookService.get(readSrc.getReadsrcid());
			if (null != readSrcNew) {
				setAttribute("readSrc", readSrcNew);
			}
			return "update";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 修改一天一课
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toModifyOneday() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionMessage("封面最大只能上传50K!");
				return openModifyOneday();
			}
			readbookService.updateReadSrcByOneday(readSrc, cover,
					coverFileName, coverContentType);
			this.addActionMessage("修改成功！");
			return openModifyOneday();
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
	public List getSubjectCodeAll() {
		try {
			List<SubjectCode> list_subjictCode = subjectCodeService.getAll();
			return list_subjictCode;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return new ArrayList();
	}

	/**
	 * 获取所有年级
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getGradeCodeAll() {
		try {
			List<GradeCode> list_gradeCode = gradeCodeService.getAll();
			return list_gradeCode;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return new ArrayList();
	}
}
