<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>您好，欢迎来到952116综合信息门户网！</title>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/interesting/moban.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/interesting/motyss.css" rel="stylesheet" type="text/css" />
  </head>
<body>
<s:action name="toppage" executeResult="false"></s:action>
<jsp:include page="/base/top.jsp"></jsp:include>

<div class="menubody">
  <div class="combig">
    <div class="llog"><a href="<%=basePath %>interest/XQ_index.action" target="_brank"><img src="<%=basePath%>img/interesting_img/ll.gif" /></a></div>
    <div class="llmen">
      <ul>
      <li><a href="interest/XQ_index.action" class="${empty activitPro ? 'ddcc' :'' }">兴趣首页</a></li>
      <li>|</li>
      <c:forEach items="${actps}" var="actp" varStatus="vs">
	       <li>
	       <c:choose>
	       <c:when test="${!empty actp.proUrl }">
	      	<a href="${actp.proUrl }" class="${actp.proID eq proID ? 'dizhu':'' }">
	      	</c:when>
	      	<c:otherwise>
	      	<a href="interest/activity_showActions.action?proID=${actp.proID }" class="${actp.proID eq activitPro ? 'ddcc':'' }">
	      	</c:otherwise>
	      	</c:choose>
	       ${actp.proName }</a></li>
      		<c:if test="${(vs.index+1)!=actpsize}">
      			<li>|</li>
      		</c:if>
      </c:forEach>
      </ul>
    </div>
    <div class="ddmen">
      <ul>
        <li><a target="_brank" href="<%=basePath %>index/index.action">首页</a></li>
        <li><a target="_brank" href="<%=basePath %>learn/xx_index.action?liindex=0">学习</a></li>
        <li><a target="_brank" href="<%=basePath %>interest/XQ_index.action">兴趣</a></li>
        <li><a target="_brank" href="<%=basePath %>Article/Show_News_Index.action">资讯</a></li>
        <li><a target="_brank" href="<%=basePath %>shopping/shoppingIndex_showIndex.action?t=">商城</a></li>
        <li><a target="_brank" href="<%=basePath %>openzone/zoneIndexAction!userCenterIndex.action">空间</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="bbj">
  <div class="bjitu" style="width:960px; margin:0px auto; background:url(<%=basePath %>${activityfeaphotopath }) no-repeat; height:45px; padding:278px 0px 0px 0px;">
    <ul>
      <li><a href="<%=basePath%>interest/works_showActionWorks.action?activitId=${activitId }&activitPro=${activitPro }">活动首页</a></li>
      <li><a href="<%=basePath%>interest/works_showAllActWorks.action?activitId=${activitId }&activitPro=${activitPro }">活动作品</a></li>
      <li><a href="<%=basePath%>interest/activity_showactintro.action?activitId=${activitId }&activitPro=${activitPro }">活动介绍</a></li>
      <li><a href="<%=basePath%>interest/activity_showActivityrule.action?activitId=${activitId }&activitPro=${activitPro }">活动规则</a></li>
      <li><a href="<%=basePath%>interest/list.action?id=${hangye }&proID=${activitId }">行业知识</a></li>
    </ul>
  </div>
  </body></html>