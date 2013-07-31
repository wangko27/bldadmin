<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"  isELIgnored="false"%>
<%@page import="com.cnarj.ttxs.pojo.sys.Navigation.Position;"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加网站导航</title>
    
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
  <form action="admin/navigationAdd.action" >
  <table>
  	<tr>
  		<td>导航名称:</td>
  		<td><input type="text" name="navigation.navigationname"></td>
  	</tr>
  	<tr>
  		<td>导航位置:</td>
  		<td>
  			<select name="navigation.navigationposition">
			 	<option value="<%=Position.top.ordinal()+1 %>">顶部</option>
			 	<option value="<%=Position.middle.ordinal()+1 %>">中间</option>
			 	<option value="<%=Position.bottom.ordinal()+1 %>">底部</option>
			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>上一级导航:</td>
  		<td>
  			<select name="navigation.navigation.navigationid">
  				<option value="">无</option>
  			<s:iterator value="navigationList" status="st" id = "nav">
			 	<option value="${navigationid }">${navigationname }</option>
			 	</s:iterator>
			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>导航链接:</td>
  		<td><input type="text" name="navigation.navigationurl"></td>
  	</tr>
  	<tr>
  		<td>是否显示:</td>
  		<td>
	  		<select name="navigation.isvisible">
		  	<option value="1">是</option>
		 	<option value="0">否</option>
			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>是否在新窗口中打开:</td>
  		<td>
	  		<select name="navigation.isblanktarget">
		  	<option value="1">是</option>
		 	<option value="0">否</option>
			</select>
		</td>
  	</tr>
  	<tr>
  		<td>排序:</td>
  		<td><input type="text" name="navigation.orderlist" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
  	</tr>
  	<tr>
  		<td colspan="2"><input type="submit" value="提  交"></td>  	
  	</tr>
  </table>
  	<jsp:include page="../comm/message.jsp"></jsp:include>  
  </form>
  </body>
</html>
