package com.cnarj.ttxs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台登录过滤器
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月15日
 */
public class AdminLoginFilter implements Filter {
	/**
	 * 由Web容器调用，销毁此Filter
	 */
	public void destroy() {

	}

	/**
	 * 具体过滤处理代码 需要登录才能访问的
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		if (request.getSession().getAttribute("admin") == null) {
			// 重定向
			//response.sendRedirect(request.getContextPath() + "/adminLogin.jsp");

			// 跑出框架使用以下
			response.getWriter().print(
					"<script>window.parent.parent.location.href='"
							+ request.getContextPath()
							+ "/adminLogin.jsp'</script>");
			response.getWriter().close();
		}

		chain.doFilter(request, response);

	}

	/**
	 * 由Web容器调用，初始化此Filter
	 */
	public void init(FilterConfig arg0) throws ServletException {

	}
}
