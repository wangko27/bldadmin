<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"  isELIgnored="false"%>

<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加网站位置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="admin/locationInfoEdit.action">

   
    网站位置名称:<input type="text" name="locationInfo.locationname" value="${locationInfo.locationname }"><br><br>
    上级位置:
	<select name="locationInfo.parentlocationid">
	  	<option value="0">无</option>
	 	<s:iterator value="locationInfoList" status="st" id = "location">
	 	<option value="${locationid }"  <s:if test="locationid == locationInfo.parentlocationid">selected="selected"</s:if>>${locationname }</option>
	 	</s:iterator>
	</select><br><br>
    网站位置介绍:<textarea rows="5" cols="50" name="locationInfo.locationintro" >${locationInfo.locationintro}</textarea><br><br>
    
    <input type="submit" value="提  交">
    
  	<jsp:include page="../comm/message.jsp"></jsp:include>  
    
   </form>
  </body>
</html>
