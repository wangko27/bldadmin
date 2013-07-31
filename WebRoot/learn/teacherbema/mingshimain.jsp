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
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/learning_common.css" rel="stylesheet" type="text/css" />
		<link href="css/bookmain.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="learn/js/zhankai.js"></script>
	</head>
	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<a href="learn/teacherbema_showTeachers.action?liindex=3">名师讲坛</a> >
				<span>${teahcer.username}</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="maind_6">
						<div class="mmimg">
							<img src="<%=basePath%>${teahcer.teacherPath }" />
						</div>
						<div class="nnr1">
							<h1>
								<b>${teahcer.teacherPost }：<span>${teahcer.username}
								</span> </b>
								<span>人气：${teahcer.peopleNum}</span>
							</h1>
							<ul>
								<li>
									职位：${teahcer.teacherPost }
								</li>
								<li>
									学校：${teahcer.inSchool }
								</li>
								<li>
									状态：${teahcer.flag eq '1' ? "在职":"不在职" }
								</li>
								<li>
									工龄：${teahcer.workyears }年
								</li>
							</ul>
							<p>
								教学理念：
							</p>
							<p class="lli">
								 ${teahcer.teaching_linian }
							</p>
						</div>
					</div>
					<div class="maind_7">
						<h1>
							自我介绍：
						</h1>
						<p id="content"
							style="height: 100px; overflow: hidden; text-overflow: ellipsis;">
							${teahcer.teacherIntroduction }
						</p>
						<p class="quan">
							<span id="key" onclick="shoppingcat(300);">全部展开</span>
						</p>
					</div>
					<div class="maindzz">
						<ul>
							<li class="bbt">
								他的讲坛：
							</li>
						</ul>
						<c:forEach items="${teahcer.superAticles}" varStatus="num"
							var="aricles">
							<c:if test="${num.index%5==0}">
								<ul>
							</c:if>
							<li class="video">
								<a
									href="<%=basePath%>learn/teacherbema_showTeacherArticleSrc.action?articId=${aricles.articleSrc.articlesrcid }&liindex=3">${aricles.articletitle
									}</a>
								<span><fmt:formatDate value="${aricles.createDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /> </span>
							</li>
							<c:if test="${num.index%5==4}">
								</ul>
							</c:if>
						</c:forEach>
					</div>
					<div class="page">
						<form id="form1"
							action="learn/teacherbema_showTeacherinfo.action?liindex=3"
							method="post">
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

