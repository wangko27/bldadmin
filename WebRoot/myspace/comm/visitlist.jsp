<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-访问脚步</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/classmate.css" rel="stylesheet" type="text/css" />
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
	        <div class="bobti">好友</div>
	        <div class="dtai">
	          <ul>
	            <li><a href="myspace/comm/friendList.action">我的好友</a></li>
	            <li><a href="member/classmateAction!list.action">同学录</a></li>
	            <li class="bai">访问脚步</li>
	            <li><a href="myspace/comm/friendfind.jsp">查找朋友</a></li>
	          </ul>
	        </div>
	        <div class="classmate">
	          <div class="qunbu">
	            <ul>
	              <li><a <s:if test="visittype == 2">class="dbu" href="javascript:;" </s:if><s:else> href="myspace/comm/visitMeList.action" </s:else> >看过我的</a></li>
	              <li>|</li>
	              <li><a <s:if test="visittype == 1">class="dbu" href="javascript:;"</s:if><s:else> href="myspace/comm/visitOtherList.action" </s:else> >我看过的</a></li>
	            </ul>
	          </div>
	          <div class="clmt">
	            <ul>
	        	<s:iterator value="visitList" status="st" id = "vis">
	        	<!-- 我看过的 -->
	        	<s:if test="visittype == 1">
	        	  <li>
	                <p><a href="Zone/index.action?TTid=${memberByIntervieweesuserid.memberid }"><img src="${memberByIntervieweesuserid.headpath }"  onerror="this.src='userspacefile/default/imgmo.gif'"  width="75" height="75" /></a></p>
	                <p><a href="Zone/index.action?TTid=${memberByIntervieweesuserid.memberid }">${memberByIntervieweesuserid.nikename }</a></p>
	                <p><fmt:formatDate value="${visitdate}" pattern="yy-MM HH:mm"/></p>
	              </li>
	        	</s:if>
	        	<!-- 看过我的 -->
	        	<s:elseif test="visittype == 2">
	        	  <li>
	                <p><a href="Zone/index.action?TTid=${memberByVisitorsuserid.memberid }"><img src="${memberByVisitorsuserid.headpath }"  onerror="this.src='userspacefile/default/imgmo.gif'"  width="75" height="75" /></a></p>
	                <p><a href="Zone/index.action?TTid=${memberByVisitorsuserid.memberid }">${memberByVisitorsuserid.nikename }</a></p>
	                <p><fmt:formatDate value="${visitdate}" pattern="yy-MM HH:mm"/></p>
	              </li>
	        	</s:elseif>
	        	  
	        	</s:iterator>
	        	
	            </ul>
	          </div>
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
