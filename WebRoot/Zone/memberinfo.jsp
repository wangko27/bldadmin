<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!他人空间-他的资料</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/zzll.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/Zone/header.jsp"></jsp:include> 
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		    <!-- 他人空间中部左边菜单栏 -->
		    <jsp:include page="/Zone/content_leftmenu.jsp"></jsp:include>
		    <!-- 他人空间中部右边内容详细页 -->
		    
		 	<div class="right">
		       
		        <div class="bobti">他的资料</div>
		        <div class="zzll">
		          <ul>
		            <li>他的身份：
		            
		            <s:if test="TTUser.memberType == 1">学生</s:if>
		            <s:if test="TTUser.memberType == 2">家长</s:if>
		            <s:if test="TTUser.memberType == 3">教师</s:if>
		            <s:if test="TTUser.memberType == 4">其他注册用户</s:if>
		            
		            </li>
		            <li>手机号码：${TTUser.memberAddInfo.phone }</li>
		            <li>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：${TTUser.memberAddInfo.sex }</li>
		            <li>所&nbsp;&nbsp;在&nbsp;&nbsp;地：${TTUser.memberAddInfo.inaddr } </li>
		            <li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：${TTUser.nikename }</li>
		          </ul>
		        </div>
		        
	        </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/Zone/footer.jsp"></jsp:include> 
	
  	
	<!-- 信息显示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
