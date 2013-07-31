<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/learning_common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/bolist.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<a href="learn/teacherbema_showTeachers.action?liindex=3">名师讲坛</a>>
				文章搜索列表
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="titi">
						<img src="<%=basePath%>img/learning_img/tit_4.gif" />
					</div>
					<div class="dda">
						文章
					</div>
					<div class="list_3">
						<c:forEach items="${pins}" var="pin" varStatus="vs">
							<c:if test="${vs.index%5==0}">
								<ul>
							</c:if>
							<li>
								<p>
									<a
										href="<%=basePath%>learn/teacherbema_showTeacherArticleSrc.action?articId=${pin.articleSrc.articlesrcid}&liindex=3">${pin.articletitle
										}【${pin.superTeacher.username }】</a>
								</p>
								<span><fmt:formatDate value="${pin.createDate}"
										pattern="yyyy-MM-dd" />
								</span>
							</li>
							<c:if test="${vs.index%5==4}">
								</ul>
							</c:if>
						</c:forEach>
					</div>
					<div class="page">
						<form action="learn/teacherbema_showTerm.action" method="post"
							id="articlelist" name="articlelist">
							<input type="hidden" name="liindex" value="3" />
							<t:tpage formId="articlelist" pageDiv="page"
								page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
						</form>
					</div>

				</div>
				<jsp:include page="/learn/right.jsp" />
	</body>
</html>