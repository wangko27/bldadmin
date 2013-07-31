﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/baikelist.css" rel="stylesheet" type="text/css" />
		<script src="<%=basePath%>learn/teacherbema/js/xing.js"></script>
</head>
<body>
	<jsp:include page="news_top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="Article/Show_News_Index.action">资讯</a> > <span>教育看点</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
      <div class="titi"><img src="img/news_img/kanbj.gif" /></div>   
 		<div class="list_3">
 			<c:choose>
 				<c:when test="${fn:length(result.content)==0}">
 				 		<center>该类别下暂时没有数据</center>
 				</c:when>
 				<c:otherwise>
 					 <s:iterator value="result.content" status="st"> 
   			 			<s:if test="(#st.index)%5==0">
   						 <ul>
   					 	</s:if>	
   			 				<li><p><a href="${pageContext.request.contextPath }/Article/getArticleById.action?id=${articlesrcid}"><s:property value="articletitle" /></a></p><span><fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd"/></span></li>
   			 	 		<s:if test="(#st.index+1)%5==0"></ul></s:if>   
   			 		</s:iterator>
   				 	<s:if test="result.content.size()%5!=0"></ul></s:if> 
 				</c:otherwise>
 			</c:choose>
 		 </div>
 	   			<form id="form_kanlist" action="Article/getArticleByEducationType.action" method="post">
 	      			<input type="hidden" value="8a80818c31bb7cc50131bb805c4a0007" name="articletype" />
				<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form_kanlist"></t:tpage>
        		</form> 
    </div>
    <jsp:include page="news_right.jsp"></jsp:include>
  </div>
</div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
