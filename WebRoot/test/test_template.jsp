<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test_template.jsp' starting page</title>
    
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
		
  	<form action="testBuildHtml.action" method="post">
  		<table>
  			<tr>
  				<td>userName:</td>
  				<td>
  					<input type="text" name="userName">
  				</td>
  			</tr>
  			<tr>
  				<td>password:</td>
  				<td>
  					<input type="text" name="password">
  				</td>
  			</tr>
  			
  			<tr>
  				<td colspan="2">
  					<s:submit value="登录"></s:submit><br>
  					<s:submit value="生成静态页"></s:submit>
  				</td>
  			</tr>
  		</table>
   	</form>
  </body>
</html>
