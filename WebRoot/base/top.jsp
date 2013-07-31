<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript">
	<!--
	function AddFavorite(sURL, sTitle)
	{
	   try
	   {
	       window.external.addFavorite(sURL, sTitle);
	   }
	   catch (e)
	   {
	       try
	       {
	           window.sidebar.addPanel(sTitle, sURL, "");
	       }
	       catch (e)
	       {
	           alert("加入收藏失败，请使用Ctrl+D进行添加");
	       }
	   }
	}
	//-->
	</script>

	<div class="ding">
	  <div>
	    <ul>
	      <li class="dd">
	      <c:choose>
      		<c:when test="${fn:length(loginMemberNikename)>0}">
      		<p>${loginMemberNikename} 同学 ，欢迎您登录952116综合信息门户网综合信息门户网站。<a href="loginout.action"><span>退出</span></a></p>
      		</c:when>
      		<c:otherwise>
      		<p>您好，欢迎来到952116综合信息门户网！请<a href="login/login.jsp"><span>登录</span></a>。新用户，请<a href="login/register.jsp">免费注册</a>！</p>
      		</c:otherwise> 
      		</c:choose>
	      </li>
	      <li><a target="_self" href="javascript:AddFavorite('http://www.952116.com','《952116综合信息门户网》')">收藏我们</a> </li>
	      <li><a target="_self" href="index/index.action"><span class="home">返回首页</span></a></li>
	      <li><a target="_blank" href="http://dsis.952116.com/DSIS_system/">数字化校园系统</a></li>
	      <li><a target="_blank" href="login/navigation.jsp">网站导航</a></li>
	    </ul>
	  </div>
	</div>
