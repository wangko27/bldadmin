package com.cnarj.ttxs.service.imp.test;

import com.cnarj.ttxs.dao.test.ITestDao;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.test.ITestService;


/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class TestServiceImpl extends BaseServiceImpl<SubjectCode,String> implements ITestService {
	
	public void setBaseDao(ITestDao testDao) {
		super.setBaseDao(testDao);
	}

}
