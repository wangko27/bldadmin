<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/learning_common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/xuelist.css" rel="stylesheet"
			type="text/css" />
		<script language="javascript"
			src="<%=basePath%>learn/teacherbema/js/subi.js"></script>
	</head>
	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<span>名师讲坛</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="titi">
						<img src="<%=basePath%>img/learning_img/tit_4.gif" />
					</div>
					<div class="list_5">
						<c:forEach items="${aticless}" varStatus="num" var="aticles">
							<c:if test="${num.index%4==0}">
								<ul>
							</c:if>
							<li>
								<p>
									<a
										href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${aticles.superTeacherID}&liindex=3"><img
											src="<%=basePath%>${aticles.teacherPath }" width="100"
											height="120" /> </a>
								</p>
								<p>
									<a
										href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${aticles.superTeacherID}&liindex=3">${aticles.username
										}</a>
								</p>
							</li>
							<c:if test="${num.index%4==3}">
								</ul>
							</c:if>
						</c:forEach>
					</div>
					<div class="page">
						<form id="form1" action="learn/teacherbema_showTerm.action"
							method="post">
							<input type="hidden" name="liindex" value="3" />
							<t:tpage pageDiv="page" page="${result.page}"
								goImg="img/learning_img/gog.gif" formId="form1"></t:tpage>
						</form>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp" />

			</div>
		</div>
		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>

