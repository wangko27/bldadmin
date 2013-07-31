package com.cnarj.ttxs.admin.service.learn;

import java.io.File;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道后台Service接口类 - 名师讲坛 - 名师信息
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月21日
 */
public interface ISuperTeacherService extends
		IBaseService<SuperTeacher, String> {

	/**
	 * 添加名师信息
	 * 
	 * @param superTeacher
	 * @param cover
	 * @throws Exception
	 */
	public void saveSuperTeacher(SuperTeacher superTeacher, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 修改名师信息
	 * 
	 * @param superTeacher
	 * @param cover
	 * @throws Exception
	 */
	public void updateSuperTeacher(SuperTeacher superTeacher, File cover,
			String coverFileName, String coverContentType) throws Exception;

	/**
	 * 查找名师信息（带分页）
	 * 
	 * @param page
	 * @param username
	 *            姓名
	 * 
	 * @param flag
	 *            状态
	 * @param inSchool
	 *            所在学校
	 * @return
	 * @throws Exception
	 */
	public Result findSuperTeacherByPage(Page page, String username, Long flag,
			String inSchool) throws Exception;

	/**
	 * 删除名师信息
	 * 
	 * @param superTeacherID
	 *            名师信息ID
	 * @throws Exception
	 */
	public void deleteSuperTeacher(String superTeacherID) throws Exception;

	/**
	 * 设置不可用
	 * 
	 * @param superTeacherID
	 * @throws Exception
	 */
	public void updateSuperTeacherByEnable(String superTeacherID)
			throws Exception;
}
