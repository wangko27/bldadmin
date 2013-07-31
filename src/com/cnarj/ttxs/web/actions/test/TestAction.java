package com.cnarj.ttxs.web.actions.test;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.service.sys.IHtmlService;
import com.cnarj.ttxs.service.test.ITestService;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class TestAction extends PageAction{
	
	private ITestService testService;
	private IHtmlService htmlService;
	
	private String userName;
	private String password;
	private Integer age;
	private Date birthday;
	
	
	public IHtmlService getHtmlService() {		return htmlService;	}
	public void setHtmlService(IHtmlService htmlService) {		this.htmlService = htmlService;}
	public ITestService getTestService() {		return testService;	}
	public void setTestService(ITestService testService) {		this.testService = testService;}
	
	public String getUserName() {		return userName;	}
	public void setUserName(String userName) {		this.userName = userName;}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	public Integer getAge() {		return age;	}
	public void setAge(Integer age) {		this.age = age;	}
	public Date getBirthday() {		return birthday;	}
	public void setBirthday(Date birthday) {		this.birthday = birthday;	}
	
	
	/**
	 * 示例内容:
	 * 1. 业务流程 action-->service-->dao
	 * 2. 分页
	 * 3. 日志
	 * @return
	 */
	public String testMethod(){
		LogUtil.logger.info("记录日志信息!");
		// 设置每页显示的条数
		page.setEveryPage(CommStaticNum.PAGENUM_TEST);
		//设置排序的字段
		page.setOrderBy("createdate");
		//设置排序方法
		page.setOrderType(OrderType.desc);
		

		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}

		page.setCurrentPage(Integer.parseInt(gotoPage));

		//总数目
		Long totalRecords = testService.getTotalCount();  
		
		//创建页面
		page = PageUtil.createPage(page, totalRecords.intValue());  

		//根据页面查询数据
		result = testService.findByPager(page); 
		
		return SUCCESS;
	}
	
	/**
	 * 示例内容:
	 * 1. 验证 基于xml文件配置
	 * @return
	 */
	public String testProMethod(){
		
		
		
		return SUCCESS;
	}

	
	/**
	 * 返回到freemarker模板页
	 * @return
	 */
	public String testFtl(){
		
		return SUCCESS;
	}

	
	/**
	 * 生成静态页面
	 * @return
	 */
	public String testBuildHtml(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("password", password);
		
		htmlService.buildHtml("/WEB-INF/template/test.ftl","/template/test.html",map);
		
		return SUCCESS;
	}
	
	
}
