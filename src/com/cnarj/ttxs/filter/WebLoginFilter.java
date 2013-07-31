package com.cnarj.ttxs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * WEB前台登录过滤器
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月15日
 */
public class WebLoginFilter implements Filter {

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
		try {
			HttpServletRequest request = (HttpServletRequest) req;

			HttpServletResponse response = (HttpServletResponse) res;

			if (request.getSession().getAttribute(
					(Member.LOGIN_MEMBER_ID_SESSION_NAME)) == null) {
				// 最后访问的地址 登录成功后要返回的页面
				String lastUrl = request.getHeader("Referer");
				Cookie cookie = new Cookie("lastUrl", lastUrl);
				cookie.setMaxAge(90);// 90秒生存期
				cookie.setPath("/");// 设置Cookie路径
				response.addCookie(cookie);// 发送cookie文件
				// request.getSession().setAttribute("lastUrl", lastUrl);
				request.setAttribute("msg", "您还没有登录，请先登录！");
				// 请求派发
				request.getRequestDispatcher("/login/login.jsp").forward(
						request, response);
			}
			chain.doFilter(request, response);

		} catch (Exception e) {
		}

	}

	/**
	 * 由Web容器调用，初始化此Filter
	 */
	public void init(FilterConfig arg0) throws ServletException {

	}

}
