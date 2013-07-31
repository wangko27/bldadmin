package com.cnarj.ttxs.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @description：编码过滤器，用于过滤从客户端发来的请求
 * @author 湖南爱瑞杰科技发展股份有限公司技术部
 * @version 1.0
 * History:         // 历史修改记录
 * <author>  <time>   <version >   <desc>
 * Hedan    11/04/18     1.0     build this moudle  
 *
 */
public class EncodeFilter implements Filter{

	private FilterConfig config ;//过滤器配置对象
	
	private static String encoding = "UTF-8";//编码的字符串
	
	protected boolean ignore = true;//是否忽略客户端的编码

	/**
	 * @description:销毁FilterConfig(过滤器)
	 */
	public void destroy() {
		config = null;
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//ignore为true使用编码过滤,为false就不使用编码过滤
		if(isIgnore()==true){
			//过滤器统一设置字符编码
			request.setCharacterEncoding(getEncoding());
		}
		//传给下一个过滤器
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//设置config属性
		setConfig(config);
		//获得WEB.XML编码Encoding的属性,并设置encoding属性
		setEncoding((String)this.getInitParam("Encoding"));
		//获得WEB.XML编码Ignore的属性,并设置ignore属性		
		setIgnore(Boolean.valueOf((String)this.getInitParam("Ignore")));
	}
	
	/**
	 * 获得过滤器属性
	 * @param name
	 * @return
	 */
	public Object getInitParam(String name){
		Object obj=(Object)config.getInitParameter(name);		
		return obj;
	}

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}

	public static String getEncoding() {
		return encoding;
	}

	public static void setEncoding(String encoding) {
		EncodeFilter.encoding = encoding;
	}

	public boolean isIgnore() {
		return ignore;
	}

	public void setIgnore(boolean ignore) {
		this.ignore = ignore;
	}
	
	
}
