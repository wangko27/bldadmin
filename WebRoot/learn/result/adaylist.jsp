<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
		<link href="<%=basePath%>css/adaylist.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<span>一天一课</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="titi">
						<img src="<%=basePath%>img/learning_img/tit_1.gif" />
					</div>
					<div class="dda">
						<ul>
							<li>
								搜索条件:
							</li>
						</ul>
					</div>
					<div class="list_1">
						<c:choose>
							<c:when test="${empty onedays}">
								<center>
									没有查到您想要的内容!
								</center>
							</c:when>
							<c:otherwise>
								<c:forEach items="${onedays}" var="oneday" varStatus="num">
									<c:choose>
										<c:when test="${(num.index+1) mod 2 != 0}">
											<ul>
										</c:when>
										<c:otherwise>
											<ul class="lv">
										</c:otherwise>
									</c:choose>
									<li class="biti">
										<a
											href="<%=basePath%>learn/oneday_showOneDayInfo.action?readId=${oneday.readsrcid }">${oneday.readsrctile
											}</a>
										<span class="time"> <fmt:formatDate
												value="${oneday.createdate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</span>
									</li>
									<li>
										<span>阅读(${oneday.readnum }) | 分享(${oneday.sharenum })
											| 收藏(${oneday.collectionnum })</span>
									</li>
									<li>
										简介：${oneday.contentintro }
									</li>
									</ul>
								</c:forEach>
							</c:otherwise>
						</c:choose>


					</div>
					<div class="page">

						<t:tpage pageDiv="page" page="${result.page}"
							goImg="img/learning_img/gog.gif" formId="form_readbook"></t:tpage>

					</div>
				</div>
				<jsp:include page="/learn/right.jsp" />

			</div>
		</div>
		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
