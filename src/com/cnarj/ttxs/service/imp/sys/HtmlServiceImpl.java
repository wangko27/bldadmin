package com.cnarj.ttxs.service.imp.sys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.freemarker.FreemarkerManager;

import com.cnarj.ttxs.service.sys.IHtmlService;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 系统Service实现类 - 静态页面处理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月4日11:02:31
 */
public class HtmlServiceImpl implements IHtmlService {

	private FreemarkerManager freemarkerManager = new FreemarkerManager();
	
	public void buildHtml(String templateFilePath, String htmlFilePath,
			Map<String, Object> data) {
		// TODO Auto-generated method stub
		try {
			ServletContext servletContext = ServletActionContext.getServletContext();
			Configuration configuration = freemarkerManager.getConfiguration(servletContext);
			configuration.setDefaultEncoding("UTF-8");
			Template template = configuration.getTemplate(templateFilePath);
			template.setEncoding("UTF-8");
			File htmlFile = new File(servletContext.getRealPath(htmlFilePath));
			File htmlDirectory = htmlFile.getParentFile();
			if (!htmlDirectory.exists()) {
				htmlDirectory.mkdirs();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
			template.process(data, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
