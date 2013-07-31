<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>
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
<link href="<%=basePath%>css/interesting/motyss_1.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="top2.jsp"></jsp:include>
  <div class="mmaind">
    
    <div class="ritu_3">
        <h1><span>排行榜</span> </h1>
    <div class="meter">
			<ul>
				<li>排名</li>
				<li>编号</li>
				<li>标题</li>
				<li>总票数</li>
				<li class="ri">操作</li>
			</ul>
     </div>
        <div class="meter_nn">
        <c:choose>
        <c:when test="${empty feraActionWorks}"><ul><li>没有排行信息</li></ul></c:when>
        <c:otherwise>
        <c:forEach items="${feraActionWorks}" var="works" varStatus="vs">
        	<ul>
				<li><span>第${(vs.index*gotoPage)+1 }名</span></li>
				<li>${ works.worksnumber}</li>
				<li><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }"><span>${works.author }</span>/${works.workstitle }</a></li>
				<li>${works.votes }</li>
				<li class="ri"><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }"><img src="<%=basePath %>img/interesting_img/vote_1.gif" width="68" height="23" /></a></li>
			</ul>
		</c:forEach>
		</c:otherwise>
		</c:choose>
	  </div>
    </div>
    <c:choose>
    <c:when test="${empty feraActionWorks}"></c:when>
    <c:otherwise>
     <div class="page">
      	<form id="form1" action="interest/toppage!showAllFera.action" method="post">
				<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1">
				</t:tpage>
        </form>
      </div>
     </c:otherwise>
     </c:choose>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
