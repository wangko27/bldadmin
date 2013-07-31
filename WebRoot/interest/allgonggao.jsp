<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="interest/XQ_index.action">兴趣</a> >	<span>${activity.activitytitle }活动公告列表</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
      <div class="titi">
     	${activity.activitytitle }活动公告列表
      </div>
      <div class="list_3">
      	<c:choose>
            <c:when test="${empty actList}">
            	<center>暂时还没有${activity.activitytitle }活动公告列表!</center>
            </c:when>
            <c:otherwise>
            <c:forEach items="${actList}" var="act" varStatus="vs"> 
   			 <c:if test="${(vs.index+1)%6==0||vs.index==0}">
   			 <ul>
   			 </c:if>	
   			 	<li>
   			 	<p>
   			 	<a href="interest/viewById.action?id=${act.articleid }">
   			 	${act.articletitle }
   			 	</a>
   			 	</p>
   			 	<span>
   			 	<fmt:formatDate value="${act.createdate}" pattern="yyyy-MM-dd"/>
   			 	</span>
   			 	</li>
   			 <c:if test="${(vs.index+1)%5==0 && vs.index!=44}">
   				 </ul>
   			 </c:if> 
   			 </c:forEach>
   			 	</ul>
   			</c:otherwise>
   		</c:choose>
      </div>
      <div class="page">
      <c:choose>
      	<c:when test="${empty actList}">
      	</c:when>
      	<c:otherwise>
      		<form id="form1" action="interest/index!getAllColseAct.action" method="post">
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
<div class="mainbody">
	<jsp:include page="bottom.jsp"></jsp:include>
</div>
</body>
</html>