<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  	<head>
	    <base href="<%=basePath%>"/>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/interesting_common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/zslist.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="interest/XQ_index.action">兴趣</a> > <span>${programa.proName }</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
      <div class="titi"><img src="<%=basePath%>img/interesting_img/t4.gif" width="83" height="19" /></div>
      <div class="tulist">
      <c:choose>
      	<c:when test="${empty actis}">
      		<center>该模块没有活动!</center>
      	</c:when>
      	<c:otherwise>
      		<c:forEach items="${actis}" var="act">
      		<ul>
	        	<li class="tu">
	            	<a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${act.activityid }&activitPro=${act.programa.proID }">
	            	<img src="<%=basePath%>${act.activitysrc }" width="186" height="220" /></a>
	            </li>
	            <li class="zit">${act.activitytitle }</li>
	            <li class="an">
	            <a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${act.activityid }&activitPro=${act.programa.proID }">
	            <c:choose>
	            	<c:when test="${act.isState==0}"><!-- 没开始 -->
		            	<img src="<%=basePath%>img/interesting_img/jj2.gif" width="84" height="33" />
		           	</c:when>
	           		<c:when test="${act.isState==1}"><!-- 活动结束了 -->
		            	<img src="<%=basePath%>img/interesting_img/jj11.gif" width="84" height="33" />
		           	</c:when>
	           		<c:otherwise>
		            	<img src="<%=basePath%>img/interesting_img/jj.gif" width="84" height="33" /><!-- 进行中 -->
		           	</c:otherwise>
	           	</c:choose>
	           	</a>
	           	</li>
        	</ul>
      	</c:forEach>
      	</c:otherwise>
      </c:choose>
      </div>
      <div class="page">
       <c:choose>
      	<c:when test="${empty actis}">
      	</c:when>
      	<c:otherwise>
      	<form id="form1" action="interest/activity_showActions.action" method="post">
      		<input type="hidden" name="proID"  value="${proID }"/>
			<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1">
			</t:tpage>
		</form>
      	</c:otherwise>
      </c:choose>
      </div>
    </div>
    <jsp:include page="right.jsp"></jsp:include>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
