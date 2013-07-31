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
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-相册列表</title>
    
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
    <jsp:include page="../header.jsp"></jsp:include> 
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		  <!-- 用户中心中部左边菜单栏 -->
		  <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		  <!-- 用户中心中部右边内容详细页 -->
	      <div class="right">
	        <div class="bobti">我的相册</div>
	        <div class="poth_1">
	          <ul>
	            <li><a href="myspace/comm/photoAddGo.action"><img src="img/user_img/cc.gif" width="80" height="24" /></a></li>
	            <li><a href="myspace/comm/albumadd.jsp">创建新相册</a></li>
	           	<%--
	            <li class="rr"><a href="#">查看好友相册</a></li>  --%>
	          </ul>
	        </div>
	        <div class="poth_2">
	          <ul>
	          
 			  <s:iterator value="result.content" status="st" id = "album">
	            <li>
	              <p class="ptu">
	              <s:if test='albumcoverpath == "" || albumcoverpath == null'>
	              <img src="userspacefile/default/albumcover.gif" width="435" height="327" />
	              </s:if>
	              <s:else>
	              <a href="myspace/comm/photoOfAlbum.action?albumid=${ albumid}"><img src="${albumcoverpath }" width="435" height="327" /></a>
	              </s:else>
	              </p>
	              <p class="mm"><a href="myspace/comm/photoOfAlbum.action?albumid=${ albumid}">${albumname }</a></p>
	              <p class="mm">(共${photonum }张)
	              <s:if test="isdefault==0">
	               | <a href="myspace/comm/albumEditUp.action?albumid=${albumid }">编辑</a> | <a href="myspace/comm/albumDel.action?albumid=${albumid }">删除</a>
	              </s:if>
	              </p>
	            </li>
	          </s:iterator>
	          </ul>
	        </div>
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="../footer.jsp"></jsp:include> 
  	
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
