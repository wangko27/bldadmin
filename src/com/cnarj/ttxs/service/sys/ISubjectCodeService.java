package com.cnarj.ttxs.service.sys;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 系统Service接口类 - 科目代码
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public interface ISubjectCodeService extends IBaseService<SubjectCode,String> {

/*
 * 根据数组查询科目
 * 
 */
	public List<SubjectCode> getsubject(String[] values);
}
