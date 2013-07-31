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
					<div class="flei_1">
						<form name="sForm"
							action="<%=basePath%>learn/teacherbema_showTerm.action"
							method="post">
							<ul class="lui1">
								<li>
									<span> <input name="typeid" type="radio" value="0"
											checked="checked" /> <input type="hidden" name="liindex"
											value="3" /> </span><span>人名</span><span> <input
											name="typeid" type="radio" value="1" /> </span><span>文章</span>
								</li>
								<li>
									<input type="text" class="ssk" name="termString"
										id="termString" />
									<a href="javascript:commit('<%=basePath%>')"> <img
											src="<%=basePath%>img/learning_img/ssbj.gif" />
									</a>
								</li>
							</ul>
						</form>
						<p class="lui2">
							<b>热门搜索：</b>
							<c:forEach items="${superts}" var="supert">
								<a
									href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${supert.superTeacherID}&liindex=3">${supert.username
									}</a> | 
        </c:forEach>
						</p>
					</div>
					<div class="list_5">
						<c:choose>
							<c:when test="${!empty errorinfo}">
								<font style="font-size: 20px;">
									<center>
										${errorinfo }
									</center>
								</font>
							</c:when>
							<c:otherwise>
								<c:forEach items="${aticless}" varStatus="num" var="aticles">
									<c:if test="${num.index%4==0}">
										<ul>
									</c:if>
									<li>
										<p>
											<a
												href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${aticles.superTeacherID}&liindex=3"><img
													src="<%=basePath%>${aticles.teacherPath }" width="100"
													height="120" />
											</a>
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
							</c:otherwise>
						</c:choose>
					</div>
					<div class="page">
						<c:if test="${empty errorinfo}">
							<form id="form1"
								action="learn/teacherbema_showTeachers.action?liindex=3"
								method="post">
								<t:tpage pageDiv="page" page="${result.page}"
									goImg="img/learning_img/gog.gif" formId="form1"></t:tpage>
							</form>
						</c:if>

					</div>
				</div>
				<jsp:include page="/learn/right.jsp" />
	</body>
</html>

