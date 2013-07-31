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
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-我的博文</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/usermaid.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script language="javascript" src="<%=basePath%>js/ad.js"></script>

  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/myspace/header.jsp"></jsp:include> 
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		    <!-- 用户中心中部左边菜单栏 -->
		    <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		    <!-- 用户中心中部右边内容详细页 -->
		 	<div class="right">
		        <div class="bobti"> 博文 </div>
		        <div class="dtai">
		          <ul>
		          <s:if test="blogtype == 1">
		            <li class="bai">我的博文</li>
		            <li><a href="myspace/comm/blogList.action?blogtype=2">好友博文</a></li>
		            <li><a href="myspace/comm/blogList.action?blogtype=3">大家的博文</a></li>
		          </s:if>
		          <s:elseif test="blogtype == 2">
		            <li><a href="myspace/comm/blogList.action?blogtype=1">我的博文</a></li>
		            <li class="bai">好友博文</a></li>
		            <li><a href="myspace/comm/blogList.action?blogtype=3">大家的博文</a></li>
		          </s:elseif>
		          <s:elseif test="blogtype == 3">
		            <li><a href="myspace/comm/blogList.action?blogtype=1">我的博文</a></li>
		            <li><a href="myspace/comm/blogList.action?blogtype=2">好友博文</a></li>
		            <li class="bai">大家的博文</li>
		          </s:elseif>
		            <li><a href="myspace/comm/editblog.jsp">发表博文</a></li>
		          </ul>
		        </div>
		        <div class="bbowen">
		          <div class="opous">
		          
 				  <s:iterator value="bloglist" status="st" id = "blog">
		            <div class="zhz">
		             <ul class="wenzi_1">
		                <li class="bh"><a href="myspace/comm/blogDetail.action?blog.blogid=${blogid }&blogtype=${blogtype }">${blogtitle }</a></li>
		                <li class="time">${createdate }</li>
		                <li>
		                 <p> ${blogcontent } </p>
		                </li>
		                <li><a href="myspace/comm/blogDetail.action?blog.blogid=${blogid }&blogtype=${blogtype }">阅读</a>(${readnum }) | <a href="myspace/comm/blogDetail.action?blog.blogid=${blogid }&blogtype=${blogtype }&Aname#Aid">评论</a>(${commentnum })</li>
		              </ul>
		            </div>
		          </s:iterator>
		            
				  <form id="form1" action="myspace/comm/blogList.action" method="post">
				  	<input type="hidden"  name="blogtype" value="${blogtype }"/>
					<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1"></t:tpage>
			      </form>
		        </div>
		          
		        <!-- 我的博文 -->
		        <s:if test="blogtype == 1">
		        <div class="banner">
		          <img name="advertisement" title="user-bolg-a1"  src="" width="272" height="124" />
		          <img name="advertisement" title="user-bolg-a2"  src="" width="272" height="124" />
		        </div>
		        </s:if>
		        <!-- 好友博文 -->
		        <s:if test="blogtype == 2">
		        <div class="banner">
		          <img name="advertisement" title="friend-bolg-a1"  src="" width="272" height="124" />
		          <img name="advertisement" title="friend-bolg-a2"  src="" width="272" height="124" />
		        </div>
		        </s:if>
		        <!-- 大家的博文 -->
		        <s:if test="blogtype == 3">
		        <div class="banner">
		          <img name="advertisement" title="all-blog-a1"  src="" width="272" height="124" />
		          <img name="advertisement" title="all-blog-a2"  src="" width="272" height="124" />
		        </div>
		        </s:if>
	        </div>
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
	
  	
	<!-- 信息显示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
