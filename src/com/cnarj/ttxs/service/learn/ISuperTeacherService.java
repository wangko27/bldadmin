package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.service.IBaseService;

public interface ISuperTeacherService extends IBaseService<SuperTeacher, String> {

	/**
	 * 添加人气
	 * @param teacher
	 */
	public void updateHuman(SuperTeacher teacher);

	/**
	 * 获得人气最好的6个老师 推荐到首页
	 * @param teacher
	 */
	public List<SuperTeacher> getsuperteacher(int  num);
	/**
	 * 获得最新的推荐老师到首页
	 * @param teacher
	 */
	public List<SuperTeacher> getnewteacher(int num);
}
