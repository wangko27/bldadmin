<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加管理员</title>
    
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
   <form action="admin/navigationAdd.action" method="post" enctype="multipart/form-data">
  <table>
  	<tr>
  		<td>广告位置:</td>
  		<td>
  			<select name="advInfo.locationInfo">
			 	<s:iterator value="locationInfoList" status="st" id = "adv">
			 	<option value="${locationid }">${locationname }</option>
			 	</s:iterator>
			</select>
		</td>
  	</tr>
  	<tr>
  		<td>广告链接:</td>
  		<td><input type="text" name="advInfo.hyperlink"></td>
  	</tr>
  	<tr>
  		<td>图片：</td>
  		<td><input type="file" name="filedir_" /></td>
  	</tr>
  	<tr>
  		<td colspan="2"><input type="submit" value="提  交"></td>  	
  	</tr>
  </table>
  	<jsp:include page="../comm/message.jsp"></jsp:include>  
  </form>
  </body>
</html>
