<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../../comm/common_tag.jsp" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！-- 同学录</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/classmate.css" rel="stylesheet" type="text/css" />
  </head>
  
 <body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="mainbody_1">
  <div class="dde">
    <div class="uuop">
	<jsp:include page="../content_leftmenu.jsp"></jsp:include>
	<div class="right">
        <div class="bobti">好友</div>
        <div class="dtai">
          <ul>
            <li><a href="myspace/comm/friendList.action">我的好友</a></li>
            <li class="bai"><a href="member/classmateAction!list.action">同学录</a></li>
            <li><a href="myspace/comm/visitMeList.action">访问脚步</a></li>
            <li><a href="myspace/comm/friendfind.jsp">查找朋友</a></li>
          </ul>
        </div>
		<div class="classmate">
        	<div class="anbootm">
        	<span>${schoolName}${gradeName}${className}</span>
        	<p ><a href="#"><img src="<%=basePath%>img/user_img/re1.gif" width="18" height="18" /></a>  <a href="#"><img src="<%=basePath%>img/user_img/re2.gif" width="18" height="18" /></a></p>
            </div>
            <div class="clmt">
            	<ul>
            		<c:forEach items="${result.content}" var="student" varStatus="i" >
            			<li>
		                    <p><a href="Zone/index.action?dsisid=${student.xsId}"><img  <c:if test="${not empty student.personalphoto}">src="<%=basePath%>${student.personalphoto}"</c:if> <c:if test="${empty student.personalphoto}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> width="75" height="75" /></a></p>
		                    <p><a href="Zone/index.action?dsisid=${student.xsId}"><c:out value="${student.xsXming}"></c:out> </a></p>
	                    </li>
	                    <c:if test="${(i.index+1)%7 == 0}"></ul><ul></c:if>
            		</c:forEach>
                </ul>
            </div>
        </div>
        <form action="member/classmateAction!list.action" id="formpage" method="post">
	        <t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="formpage"></t:tpage>
	    </form>
    </div>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
 </body>
</html>
