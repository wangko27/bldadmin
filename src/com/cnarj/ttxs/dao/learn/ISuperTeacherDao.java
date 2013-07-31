package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;

public interface ISuperTeacherDao extends IBaseDao<SuperTeacher, String> {
	/**
	 * 获得人气最好的6个老师 推荐到首页
	 * @param teacher
	 */
	public List<SuperTeacher> getsuperteacher(int num);
	
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
	public Result findSuperTeacherByPage(Page page, String username,
			Long flag, String inSchool) throws Exception;
	/**
	 * 获得最新的推荐老师到首页
	 * @param teacher
	 */
	public List<SuperTeacher> getnewteacher(int num);
}

