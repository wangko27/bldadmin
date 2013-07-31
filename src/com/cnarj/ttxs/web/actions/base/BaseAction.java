package com.cnarj.ttxs.web.actions.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import com.cnarj.ttxs.pojo.user.Member;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;


@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements Preparable {

	public static final String VIEW = "view";
	public static final String LIST = "list";
	public static final String STATUS = "status";
	public static final String WARN = "warn";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final String CONTENT = "content";
	
	// 获取Attribute
	public Object getAttribute(String name) {
		return ServletActionContext.getRequest().getAttribute(name);
	}

	// 设置Attribute
	public void setAttribute(String name, Object value) {
		ServletActionContext.getRequest().setAttribute(name, value);
	}

	// 获取Parameter
	public String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	// 获取Parameter数组
	public String[] getParameterValues(String name) {
		return getRequest().getParameterValues(name);
	}

	// 获取Session
	public Object getSession(String name) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		return session.get(name);
	}

	// 获取Session
	public Map<String, Object> getSession() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		return session;
	}

	// 设置Session
	public void setSession(String name, Object value) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put(name, value);
	}

	// 获取Request
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	// 获取Response
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	// 获取Application
	public ServletContext getApplication() {
		return ServletActionContext.getServletContext();
	}
	
	//重定向
	public void sendRedirect(String path)throws IOException{
		getResponse().sendRedirect(path);
	}
	
	
	//请求派发
	public void dispatcher(String path)throws ServletException,IOException{
		getRequest().getRequestDispatcher(path).forward(getRequest(), getResponse());
	}
	
	//从session中获得会员所属学校id
	public String getXxid(){
		Object obj = getSession(Member.LOGIN_MEMBER_SESSION_XXID);
		return obj == null ? null : obj+"";
	}
	
	//从session中获得从数字化校园获得的userid
	public Long getDsisUserid(){
		Object obj = getSession(Member.LOGIN_MEMBER_SESSION_DSISUSERID);
		return obj == null ? null : Long.parseLong(obj.toString());
	}
	
	//从session中获得memberType
	public Long getSessionMemberType(){
		Object obj = getSession(Member.LOGIN_MEMBER_TYPE);
		return obj == null ? null : Long.valueOf(obj+"");
	}
	
	//从session中获得会员主键id值
	public String getSessionMemberId(){
		Object obj = getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		return obj == null ? null : obj.toString();
	}

	//从session中获得会员用户名
	public String getSessionMemberUsername(){
		Object obj = getSession(Member.LOGIN_MEMBER_USERNAME_COOKIE_NAME);
		return obj == null ? null : obj.toString();
	}
	
	// AJAX输出，返回null
	public String ajax(String content, String type) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// AJAX输出文本，返回null
	public String ajaxText(String text) {
		return ajax(text, "text/plain");
	}

	// AJAX输出HTML，返回null
	public String ajaxHtml(String html) {
		return ajax(html, "text/html");
	}

	// AJAX输出XML，返回null
	public String ajaxXml(String xml) {
		return ajax(xml, "text/xml");
	}

	// 根据字符串输出JSON，返回null
	public String ajaxJson(String jsonString) {
		return ajax(jsonString, "text/html");
	}
	
	// 根据Map输出JSON，返回null
	public String ajaxJson(Map<String, String> jsonMap) {
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return ajax(jsonObject.toString(), "text/html");
	}
	
	// 输出JSON警告消息，返回null
	public String ajaxJsonWarnMessage(String message) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return ajax(jsonObject.toString(), "text/html");
	}
	
	// 输出JSON成功消息，返回null
	public String ajaxJsonSuccessMessage(String message) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, message);
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return ajax(jsonObject.toString(), "text/html");
	}
	
	// 输出JSON错误消息，返回null
	public String ajaxJsonErrorMessage(String message) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGE, message);
		JSONObject jsonObject = null;
		jsonObject = JSONObject.fromObject(jsonMap);
		return ajax(jsonObject.toString(), "text/html");
	}
	
	// 设置页面不缓存
	public void setResponseNoCache() {
		getResponse().setHeader("progma", "no-cache");
		getResponse().setHeader("Cache-Control", "no-cache");
		getResponse().setHeader("Cache-Control", "no-store");
		getResponse().setDateHeader("Expires", 0);
	}

	/**
	 * 获取某目录在服务器的绝对路径
	 * 
	 * @param filepath
	 * @return
	 */
	public String getRealPath(String filepath) {
		return getRequest().getSession().getServletContext().getRealPath(
				filepath);
	}

	/**
	 * 获取服务器的绝对路径
	 * 
	 * @param filepath
	 * @return
	 */
	public String getRealPath() {
		return getRequest().getSession().getServletContext().getRealPath("/");
	}

	
	 public String getWebPath(){

	       HttpServletRequest request = ServletActionContext.getRequest ();

	       String path = request.getContextPath();

	       String basePath = request.getScheme() + "://"

	              + request.getServerName() + ":" + request.getServerPort()

	              + path + "/";

	       return basePath;

	}
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
