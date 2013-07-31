<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	</head>

	<body>
		<%
			if (request
					.getSession()
					.getAttribute(
							(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_ID_SESSION_NAME)) == null) {
		%>
		<p>
			<a href="learn/filter/restriction.action"> <img
					src="img/${param.pathitem }/an.gif" /> </a>
		</p>
		<ul>
			<li>
				登陆后，您可以：
			</li>
			<li>
				·&nbsp;与您的朋友进行交流
			</li>
			<li>
				·&nbsp;下载资源、博览群书
			</li>
			<li>
				·&nbsp;查看您的积分记录、查询成绩
			</li>
			<li>
				&nbsp;
			</li>
			<li>
				·&nbsp;解答孩子问题
			</li>
			<li>
				·&nbsp;上传您的资源、分享快乐
			</li>
			<li>
				·&nbsp;与您的朋友进行交流
			</li>
		</ul>
		<%
			} else {
		%>
		<table width="80%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<div class="ru1">
						<img
							src="<%=session
										.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_HEADPATH)%>" />
						<p>
							<b><%=session
										.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_NIKENAME)%></b>
							<%
								Object type = session
											.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_TYPE);
									if ("1".equals(type.toString())) {
							%>同学
							<%
								} else if ("2".equals(type.toString())) {
							%>家长
							<%
								} else if ("3".equals(type.toString())) {
							%>教师
							<%
								}
							%>，欢迎您登录952116综合信息门户网综合门户网站。
							<br />
							当前积分：
							<span><%=session
										.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_POINT)%></span>
						</p>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="green">
								&nbsp;&nbsp;
								<img src="img/${param.pathitem }/d_03.gif" width="3" height="3" />
								&nbsp;&nbsp;
								<a href="member/myinformation!myInfo.action">我的资料</a>
							</td>
							<td class="green">
								&nbsp;&nbsp;
								<img src="img/${param.pathitem }/d_03.gif" width="3" height="3" />
								&nbsp;&nbsp;
								<a href="myspace/updatepwd.jsp">修改密码</a>
							</td>
						</tr>
						<tr>
							<td class="green">
								&nbsp;&nbsp;
								<img src="img/${param.pathitem }/d_03.gif" width="3" height="3" />
								&nbsp;&nbsp;
								<a href="myspace/comm/uploadSrcGo.action">上传资源</a>
							</td>
							<td class="green">
								&nbsp;&nbsp;
								<img src="img/${param.pathitem }/d_03.gif" width="3" height="3" />
								&nbsp;&nbsp;
								<a href="member/loginout.action">用户退出</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="45">
								<img src="img/${param.pathitem }/bz.gif" width="34" height="17" />
							</td>
							<td align="left" class="hui">
								<a href="#">什么是数字化校园？</a>
							</td>
						</tr>
						<tr>
							<td>
								<img src="img/${param.pathitem }/cx.gif" alt="" width="34"
									height="16" />
							</td>
							<td align="left" class="hui">
								<a href="#">如何查询成绩？</a>
							</td>
						</tr>
						<tr>
							<td>
								<img src="img/${param.pathitem }/jl.gif" alt="" width="34"
									height="17" />
							</td>
							<td align="left" class="hui">
								<a href="#">与您的朋友进行交流</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<%
			}
		%>
	</body>
</html>
