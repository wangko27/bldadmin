package com.cnarj.ttxs.filter;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnarj.ttxs.pojo.stuz.ZoneVisits;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IVisitService;

/**
 * 后台登录过滤器
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月20日
 */
public class VisitFilter implements Filter {
	
	private IVisitService visitService;
	
	public IVisitService getVisitService() {		return visitService;	}
	public void setVisitService(IVisitService visitService) {		this.visitService = visitService;	}

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


		//判断用户是否登录
		String memberid = (String) request.getSession().getAttribute(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		//取出被访问者Id
		String TTid = request.getParameter("TTid");
		
		
		//如果已登录，则记录访问脚步,不是自己访问自己
		if(null != memberid && null != TTid && memberid.length() > 0 && TTid.length() > 0 && !memberid.equals(TTid)){
			
			//访问者
			String ip = request.getRemoteAddr();
			String nikename = (String) request.getSession().getAttribute(Member.LOGIN_MEMBER_NIKENAME);
			String headpath = (String) request.getSession().getAttribute(Member.LOGIN_MEMBER_HEADPATH);
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			
			Member m1 = new Member();
			Member m2 = new Member();
			m1.setMemberid(TTid);
			m2.setMemberid(memberid);
			
			ZoneVisits vis = new ZoneVisits();
			vis.setMemberByIntervieweesuserid(m1);
			vis.setMemberByVisitorsuserid(m2);
			vis.setVisitdate(now);
			vis.setVisitip(ip);
			vis.setVisitorspicture(headpath);
			vis.setVisitorsusername(nikename);
			
			visitService.savevisit(vis);
		}

		chain.doFilter(request, response);

	}

	/**
	 * 由Web容器调用，初始化此Filter
	 */
	public void init(FilterConfig arg0) throws ServletException {

	}
}
