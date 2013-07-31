package com.cnarj.ttxs.admin.service.imp.learn;

import java.io.File;
import java.util.Date;

import com.cnarj.ttxs.admin.service.learn.ISuperTeacherService;
import com.cnarj.ttxs.dao.learn.ISuperTeacherDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.Pubfun;

/**
 * 学习频道后台Service实现类 - 名师讲坛 - 名师信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月21日
 */
public class SuperTeacherServiceImpl extends
		BaseServiceImpl<SuperTeacher, String> implements ISuperTeacherService {

	ISuperTeacherDao superTeacherDao;

	public ISuperTeacherDao getSuperTeacherDao() {
		return superTeacherDao;
	}

	public void setSuperTeacherDao(ISuperTeacherDao superTeacherDao) {
		this.superTeacherDao = superTeacherDao;
	}

	public void deleteSuperTeacher(String superTeacherID) throws Exception {
		SuperTeacher superTeacher = superTeacherDao.get(superTeacherID);
		superTeacherDao.delete(superTeacher);

		// 删除头像
		if (!"uploadfiles/none.gif".equals(superTeacher.getTeacherPath())) {
			// 删除该名师目录及文件
			String uploadFilepath = Pubfun.structurePath("superteacher",
					superTeacher.getCreateDate(), superTeacher
							.getSuperTeacherID());
			File fileDirectory = new File(uploadFilepath);
			FileOperate.deleteDirectoryAndFile(fileDirectory);
		}
	}

	public Result findSuperTeacherByPage(Page page, String username, Long flag,
			String inSchool) throws Exception {
		return superTeacherDao.findSuperTeacherByPage(page, username, flag,
				inSchool);
	}

	public void saveSuperTeacher(SuperTeacher superTeacher, File cover,
			String coverFileName, String coverContentType) throws Exception {
		superTeacher.setPeopleNum(new Long(0));// 设置人气
		superTeacher.setCreateDate(new Date());// 创建时间
		superTeacher.setModifyDate(new Date());// 修改时间
		superTeacher.setIsenable("1");// 启用
		// 上传封面
		String coverPath = "uploadfiles/none.gif";// 封面路径

		superTeacher.setTeacherPath(coverPath);// 封面路径
		String superTeacherID = superTeacherDao.save(superTeacher);

		if (null != cover) {// 上传头像
			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("superteacher",
					new Date(), superTeacherID, cover, coverFileName,
					coverContentType);
			if (coverUploadPath.length() > 0) {
				coverPath = coverUploadPath;
			}
			superTeacher.setTeacherPath(coverPath);// 封面路径
			superTeacherDao.update(superTeacher);
		}

	}

	public void updateSuperTeacher(SuperTeacher superTeacher, File cover,
			String coverFileName, String coverContentType) throws Exception {
		SuperTeacher superTeacherNew = superTeacherDao.get(superTeacher
				.getSuperTeacherID());
		superTeacherNew.setUsername(superTeacher.getUsername());
		superTeacherNew.setFlag(superTeacher.getFlag());
		superTeacherNew.setTeacherIntroduction(superTeacher
				.getTeacherIntroduction());
		superTeacherNew.setInSchool(superTeacher.getInSchool());
		superTeacherNew.setTeacherPost(superTeacher.getTeacherPost());
		superTeacherNew.setTeaching_linian(superTeacher.getTeaching_linian());
		superTeacherNew.setWorkyears(superTeacher.getWorkyears());
		superTeacherNew.setModifyDate(new Date());// 修改时间

		if (null != cover) {// 上传头像

			// 已经上传过头像，删除原有头像
			String teacherPath = superTeacherNew.getTeacherPath();// 上传文件目录
			if (null != teacherPath
					&& !"uploadfiles/none.gif".equals(teacherPath)) {
				FileOperate.deleteFile(teacherPath);
			}

			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("superteacher",
					superTeacherNew.getCreateDate(), superTeacherNew
							.getSuperTeacherID(), cover, coverFileName,
					coverContentType);
			superTeacherNew.setTeacherPath(coverUploadPath);// 封面路径
		}
		superTeacherDao.update(superTeacherNew);
	}

	public void updateSuperTeacherByEnable(String superTeacherID)
			throws Exception {
		SuperTeacher superTeacher = superTeacherDao.get(superTeacherID);
		superTeacher.setIsenable("0");
		superTeacherDao.update(superTeacher);
	}

}
