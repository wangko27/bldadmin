package com.cnarj.ttxs.service.imp.sys;

import com.cnarj.ttxs.dao.sys.IGradeCodeDao;
import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.sys.IGradeCodeService;

/**
 * 系统Service实现类 - 年级代码
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class GradeCodeServiceImpl extends BaseServiceImpl<GradeCode,String> implements
IGradeCodeService {
	
	public void setBaseDao(IGradeCodeDao gradeCodeDao) {
		super.setBaseDao(gradeCodeDao);
	}
}
