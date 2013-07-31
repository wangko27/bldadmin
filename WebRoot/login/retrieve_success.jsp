<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />

		<title>您好，欢迎来到952116综合信息门户网！ -- 找回密码</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/login/common.css" rel="stylesheet" type="text/css" />
		<link href="css/login/log.css" rel="stylesheet" type="text/css" />

	</head>

	<body>

		<jsp:include page="/base/top.jsp"></jsp:include>

		<jsp:include page="/base/toplink.jsp"></jsp:include>

		<div class="mainbody">
			<div class="logo_1">
				家校快捷方便沟通的平台
			</div>
		</div>
		<div class="mainbody">
			<div class="zhuce">
				<div class="tit">
					<span>忘记密码</span>
					<a href="login/register.jsp">还没账号，请注册！</a>
				</div>
				<div class="xunmi">
					<div class="mibj">
						找回密码
					</div>
					<div class="tits">
						<p>
							<b>恭喜您！</b>
							<br />
							您的密码已经成功发送到您的邮箱里！
						</p>
						<p>
							<a href="login/login.jsp">返回登录界面</a> &nbsp;&nbsp;&nbsp;&nbsp;
						</p>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
