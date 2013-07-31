<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<base href="<%=basePath%>"/>
  	
    <title>您好，欢迎来到952116综合信息门户网！用户中心</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/user/zuo.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/user/zzll.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>comm/js/jquery-1.4.2.js"></script>
	<script src="<%=basePath%>learn/teacherbema/js/xing.js"></script>
  </head>
  
  <body>
    <!-- 用户中心顶部 -->
    <jsp:include page="header.jsp"></jsp:include>
<div class="mainbody_1">
  <div class="dde">
    <div class="uuop">
	    <!-- 用户中心中部左边菜单栏 -->
	    <jsp:include page="content_leftmenu.jsp"></jsp:include>
	    <!-- 用户中心中部右边内容详细页 -->
	    <jsp:include page="content_index_right.jsp"></jsp:include>
    </div>
  </div>
</div>
    <!-- 用户中心底部 -->
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
