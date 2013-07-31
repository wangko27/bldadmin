<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!他人空间-相册</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/pohto.css" rel="stylesheet" type="text/css" />
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
	        <div class="bobti">他的相册</div>
	        <div class="poth_2">
	          <ul>
 			  <s:iterator value="result.content" status="st" id = "album">
	            <li>
	              <p class="ptu"><a href="Zone/photoOfAlbum.action?albumid=${ albumid}&TTid=${TTid }"><img src="${albumpath }/${albumcoverpath }" width="435" height="327"  onerror="this.src='userspacefile/default/albumcover.gif'"/></a></p>
	              <p class="mm"><a href="Zone/photoOfAlbum.action?albumid=${ albumid}&TTid=${TTid }">${albumname }</a></p>
	              <p class="mm">(共${photonum }张)</p>
	            </li>
	          </s:iterator>
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
