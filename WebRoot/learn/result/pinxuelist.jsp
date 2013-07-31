<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//类别id
	String articleTypeid = request.getParameter("articleTypeid");
	if (null == articleTypeid) {
		articleTypeid = "";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/learning_common.css" rel="stylesheet" type="text/css" />
		<link href="css/bolist.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<span>品学论道</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="titi">
						<img src="img/learning_img/tit_3.gif" />
					</div>

					<div class="dda">
						<ul>
							<li>
								搜索结果:
							</li>
						</ul>
					</div>
					<div class="list_3">
						<s:iterator value="result.content" id="art" status="ind">
							<s:if test="#ind.index%5==0">
								<ul>
							</s:if>
							<li>
								<p>
									<a
										href="<%=basePath%>Article/getArticleById.action?id=${articlesrcid}">${fn:substring(art.articletitle
										, 0,30)}<s:if test="%{article.length()>30}">...</s:if> </a>
								</p>
								<span><fmt:formatDate value="${createdate}"
										pattern="yyyy-MM-dd" /> </span>
							</li>
							<s:if test="(#ind.index+1)%5==0">
								</ul>
							</s:if>
						</s:iterator>
						<s:if test="articlelist.size()%5!=0">
							</ul>
						</s:if>
					</div>
					<div class="page">
						<t:tpage formId="articlelist" pageDiv="page" page="${result.page}"
							goImg="img/learning_img/gog.gif"></t:tpage>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>