package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TStugrade;

public interface StugradeDao extends BaseDsisDao<TStugrade, Long>{

	/**
	 * 根据学生id获得年级实体对象
	 */
	public Long getStugrade(Long xs_id);
	
	/**
	 * 根据学生id得到年级列表
	 * @param xs_id
	 * @return
	 */
	public List<TStugrade> getList(Long xs_id);
	
	

	/**
	 * 根据教师账户得到该账户所绑定年级列表
	 * @param user
	 * @return
	 */
	public List<TStugrade> getGradeListByBind(Long teacherId);
}
