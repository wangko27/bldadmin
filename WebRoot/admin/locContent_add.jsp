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
    
    <title>添加位置与内容的关联</title>
    
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
  <form action="admin/locContentAdd.action">
   <table>
	   <tr>
		   <td align="left">请选择位置:</td>
		   <td align="right">
		   <select name="locContent.locationInfo.locationid">
			 	<s:iterator value="locationInfoList" status="st" id = "location">
			 	<option value="${locationid }">${locationname }</option>
			 	</s:iterator>
			</select>
			</td>
	   </tr>
	   <tr>
		   <td align="left">请选择内容:</td>
		   <td align="right">
		   <select name="locContent.webContent.contentid">
			 	<s:iterator value="webContentList" status="st" id = "webcon">
			 	<option value="${contentid }">${contentname }</option>
			 	</s:iterator>
			</select>
		   </td>
	   </tr>
	   <tr>
	   		<s:token />
	   		<td align="center" colspan="2"><input type="submit" value="关  联"></td>
	   </tr>
   </table>
  
   
  	<jsp:include page="../comm/message.jsp"></jsp:include>  
    
    
   </form>
  </body>
</html>
