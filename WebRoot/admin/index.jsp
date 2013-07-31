<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>舒天便民后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="css/admin.css" type="text/css" rel="stylesheet">

  </head>
  
	<FRAMESET border=0 frameSpacing=0 rows="99, *" frameBorder=0>
	<FRAME name=header src="admin/top.jsp" frameBorder=0 noResize scrolling=no>
	<FRAMESET cols="220, *">
	<FRAME name=menu src="admin/menu.jsp" frameBorder=0 noResize>
	<FRAME name=main src="admin/main.jsp" frameBorder=0 noResize scrolling=yes>
	</FRAMESET>
	</FRAMESET>
	<noframes>
	</noframes>

</html>
