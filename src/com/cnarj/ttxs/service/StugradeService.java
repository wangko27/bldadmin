package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TStugrade;
import com.cnarj.ttxs.util.BusinessException;

public interface StugradeService  extends BaseDsisService<TStugrade, Long>{

	/**
	 * 根据学生id获得年级实体对象
	 */
	public Long getStugrade(Long xs_id)throws BusinessException;
	
	/**
	 * 根据学生id获得年级列表
	 * @param xs_id
	 * @return
	 * @throws BusinessException
	 */
	public List<TStugrade> getList(Long xs_id)throws BusinessException;
	
	
	/**
	 * 根据教师账户得到该账户所绑定年级列表
	 * @param teacherId
	 * @return
	 * @throws BusinessException
	 */
	public List<TStugrade> getGradeListByBind(Long teacherId)throws BusinessException;
}
