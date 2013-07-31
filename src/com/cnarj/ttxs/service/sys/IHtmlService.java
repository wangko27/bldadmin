package com.cnarj.ttxs.service.sys;

import java.util.Map;

/**
 * 系统Service接口类 - 静态页面处理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public interface IHtmlService {
	/**
	 * 根据Freemarker模板文件路径、Map数据生成HTML静态文件
	 * 
	 * @param templateFilePath
	 *            Freemarker模板文件路径
	 *            
	 * @param htmlFilePath
	 *            生成HTML静态文件存放路径
	 * 
	 * @param data
	 *            Map数据
	 * 
	 */
	public void buildHtml(String templateFilePath, String htmlFilePath, Map<String, Object> data);
	
}
