<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  	<head>
	    <base href="<%=basePath%>"/>
	    
	   	<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/interesting/interesting.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/interesting/interesting_common.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
        <script language="javascript" src="<%=basePath%>interest/js/index.js"></script>
        <script language="javascript" src="<%=basePath%>js/ad.js"></script>
	</head>
<body>
<s:action name="toppage" executeResult="false"></s:action>

<jsp:include page="/base/top.jsp"></jsp:include>
<jsp:include page="/base/toplink.jsp"></jsp:include>

<div class="mainbody">
  <div class="logo_ll">
  <form action="<%=basePath%>interest/activity_showActions.action" method="post" id="resForm" name="resForm">
    <ul>
      <li class="img"><a href="<%=basePath %>interest/XQ_index.action" target="_brank"><img src="<%=basePath%>img/interesting_img/l2.gif" /></a></li>
      <li>
        <select name="proID" id="resId">
        <c:if test="${empty proID}">
        	<option value="" selected="selected">请选择</option>
        </c:if>
         <c:forEach items="${actps}" var="actp">
         	<option value="1">全部</option>
         	<option value="${actp.proID }"  
         	<c:if test="${actp.proID eq proID}">
         		selected
         	</c:if>>
         		${actp.proName }
         	</option>
      	 </c:forEach>
        </select>
      </li>
      <li>
      <input type="hidden" id="path" value="<%=basePath%>" />
        <input type="text" value="${resKey }" name="resKey" id="resKey" />
        <a href="#" onclick="return false"><img src="<%=basePath%>img/learning_img/go.gif"  id="sumPic"/></a></li>
    </ul>
    </form>
  </div>
</div>
<div class="mainbody">
  <div class="learning_menu">
    <ul>
      <li><a href="interest/XQ_index.action" class="${empty proID ? 'dizhu' :'' }">兴趣首页</a></li>
      <%--
      <c:forEach items="${actps}" var="actp">
      	<li>
      	<c:choose>
      	<c:when test="${!empty actp.proUrl }">
      	<a href="${actp.proUrl }" class="${actp.proID eq proID ? 'dizhu':'' }">
      	</c:when>
      	<c:otherwise>
      	<a href="interest/activity_showActions.action?proID=${actp.proID }" class="${actp.proID eq proID ? 'dizhu':'' }">
      	</c:otherwise>
      	</c:choose>
      	${actp.proName }</a></li>
      </c:forEach>
       --%>
    </ul>
  </div>
  <div class="commongao"></div>
</div>
</body>
</html>
