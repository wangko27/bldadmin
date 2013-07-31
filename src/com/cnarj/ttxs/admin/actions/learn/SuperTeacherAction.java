package com.cnarj.ttxs.admin.actions.learn;

import java.io.File;
import java.util.Hashtable;

import com.cnarj.ttxs.admin.service.learn.ISuperAticleService;
import com.cnarj.ttxs.admin.service.learn.ISuperTeacherService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

public class SuperTeacherAction extends PageAction implements
		ModelDriven<SuperTeacher> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SuperTeacher superTeacher = new SuperTeacher();

	private ISuperTeacherService superTeacherService;

	private ISuperAticleService superAticleService;

	File cover;// 封面
	String coverFileName;
	String coverContentType;

	public SuperTeacher getModel() {
		return superTeacher;
	}

	public ISuperTeacherService getSuperTeacherService() {
		return superTeacherService;
	}

	public void setSuperTeacherService(ISuperTeacherService superTeacherService) {
		this.superTeacherService = superTeacherService;
	}

	public ISuperAticleService getSuperAticleService() {
		return superAticleService;
	}

	public void setSuperAticleService(ISuperAticleService superAticleService) {
		this.superAticleService = superAticleService;
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
	 * 打开名师讲论管理列表页面
	 * 
	 * @return
	 */
	public String openSuperTeacher() {
		try {
			// 查询所有名师
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = superTeacherService.findSuperTeacherByPage(page,
					superTeacher.getUsername(), superTeacher.getFlag(),
					superTeacher.getInSchool());

			setAttribute("list_superTeacher", result.getContent());

			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 添加名师信息
	 * 
	 * @return
	 */
	public String toAddSuperTeacher() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionError("封面最大只能上传50KB!");
			}
			superTeacherService.saveSuperTeacher(superTeacher, cover,
					coverFileName, coverContentType);
			this.addActionMessage("添加成功!");
			return "add";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 为打开名师修改页面做准备
	 * 
	 * @return
	 */
	public String openModifySuperTeacher() {
		try {
			SuperTeacher superTeacherNew = superTeacherService.get(superTeacher
					.getSuperTeacherID());
			setAttribute("superTeacher", superTeacherNew);
			return "update";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 修改名师信息
	 * 
	 * @return
	 */
	public String toModifySuperTeacher() {
		try {
			if (null != cover && ((cover.length() / 1024) > 50)) {
				this.addActionError("封面最大只能上传50KB!");
			}
			superTeacherService.updateSuperTeacher(superTeacher, cover,
					coverFileName, coverContentType);
			this.addActionMessage("修改成功!");
			return openModifySuperTeacher();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除名师信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String deleteSuperTeacher() {
		try {
			// 判断该名师下面是否还有文章
			Hashtable table = new Hashtable();
			table.put("isenable", "1");
			table.put("superTeacher.superTeacherID", superTeacher
					.getSuperTeacherID());
			if (superAticleService.isExist(table)) {
				this.addActionMessage("该名师下面还有文章，请先删除!");
			} else {
				superTeacherService.updateSuperTeacherByEnable(superTeacher
						.getSuperTeacherID());
				this.addActionMessage("删除成功!");
			}
			return openSuperTeacher();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
}
