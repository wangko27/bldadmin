<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page isELIgnored="false" %>
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
  </head>
  <body>
    <div class="mmleft">
       <div class="kuang2">
        <h1><span><strong>排行榜</strong></span> <a href="interest/toppage!showAllFera.action?actId=${activitId }">更多</a></h1>
        <ul>
        <c:choose>
        	<c:when test="${empty fareList}">
        		暂是还没有排行信息
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${fareList}" var="fare" varStatus="vs">
        	<c:choose>
        	<c:when test="${vd.index<3}">
        		<li> <span class="tuy3">${vs.index+1 }</span> <span class="tuy1"><a href="interest/Comm_showActivityWorkComm.action?workId=${fare.worksid }">${fare.workstitle }</a></span> <span class="tuy2">${fare.votes }</span> </li>
        	</c:when>
        	<c:otherwise>
        	  	<li> <span class="tuy">${vs.index+1 }</span> <span class="tuy1"><a href="interest/Comm_showActivityWorkComm.action?workId=${fare.worksid }">${fare.workstitle }</a></span> <span class="tuy2">${fare.votes }</span> </li>
        	</c:otherwise>
        	</c:choose>
       		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </ul>
      </div>
      <div class="kuang1">
        <h1><span><strong>行业知识</strong></span> <a href="<%=basePath%>interest/list.action?id=${hangye }">更多</a></h1>
        <ul>
        <c:choose>
        	<c:when test="${empty harticles}">
        	暂时还没有行业知识
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${harticles}" var="hart">
       		<li><a href="<%=basePath %>interest/viewById.action?id=${hart.articleid }&proID=${activitPro }">${fn:substring(hart.articletitle, 0, 10) }</a></li>
       		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </ul>
      </div>
      <div class="kuang3">
        <h1><span><strong>老师</strong></span> </h1>
         <c:choose>
        	<c:when test="${empty teachers}">
        		暂时还没有行业导航老师
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${teachers}" var="teacher">
        	<ul>
	          <li class="tu"><a href="#"><img src="<%=basePath %>${teacher.member.headpath }" /></a></li>
	          <li>
	            <p class="cose">[航模老师] <b><a href="#">${teacher.member.username }</a></b></p>
	            <p>${empty blogcontent ? "暂无信息":blogcontent}</p>
	            <p class="rr"><a href="#"><img src="<%=basePath %>img/interesting_img/ty.gif" /></a></p>
	          </li>
	        </ul>
        	</c:forEach>
        	</c:otherwise>
        </c:choose>
      </div>
    </div>
  </body>
</html>
