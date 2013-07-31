<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<jsp:include page="top2.jsp"></jsp:include>
  <div class="mmaind">
    <div class="mmleft">
      <div class="kuang1">
        <h1><span><strong>活动简介</strong></span> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${activitId }">更多</a></h1>
        <ul>
          <li>${activityInfo}</li>
        </ul>
      </div>
      <div class="kuang1">
        <h1><span><strong>活动公告</strong></span> <a href="<%=basePath %>interest/bulletin.action?activityId=${activitId }">更多</a></h1>
        <ul>
        <c:choose>
        	<c:when test="${empty darticles}">
        		暂无活动公告
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${darticles}" var="dart">
        		<li><a href="interest/viewById.action?id=${dart.articleid }&proID=${activitPro }">${fn:substring(dart.articletitle, 0, 10) }</a></li>
       		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </ul>
      </div>
      <div class="kuang2">
        <h1><span><strong>排行榜</strong></span> <a href="interest/toppage!showAllFera.action?actId=${activitId }">更多</a></h1>
        <ul>
        <c:choose>
        	<c:when test="${empty fareList}">
        		暂是还没有排行信息
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${fareList}" var="fare" varStatus="vs">
        	<c:choose>
        	<c:when test="${vd.index<3}">
        		<li> <span class="tuy3">${vs.index+1 }</span> <span class="tuy1"><a href="interest/Comm_showActivityWorkComm.action?workId=${fare.worksid }">${fare.workstitle }</a></span> <span class="tuy2">${fare.votes }</span> </li>
        	</c:when>
        	<c:otherwise>
        	  	<li> <span class="tuy">${vs.index+1 }</span> <span class="tuy1"><a href="interest/Comm_showActivityWorkComm.action?workId=${fare.worksid }">${fare.workstitle }</a></span> <span class="tuy2">${fare.votes }</span> </li>
        	</c:otherwise>
        	</c:choose>
       		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </ul>
      </div>
      <div class="kuang1">
        <h1><span><strong>行业知识</strong></span> <a href="<%=basePath%>interest/list.action?id=${hangye }">更多</a></h1>
        <ul>
        <c:choose>
        	<c:when test="${empty harticles}">
        	暂时还没有行业知识
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${harticles}" var="hart">
       		<li><a href="<%=basePath %>interest/viewById.action?id=${hart.articleid }&proID=${activitPro }">${fn:substring(hart.articletitle, 0, 10) }</a></li>
       		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </ul>
      </div>
      <div class="kuang3">
        <h1><span><strong>老师</strong></span> </h1>
         <c:choose>
        	<c:when test="${empty teachers}">
        		暂时还没有行业导航老师
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${teachers}" var="teacher">
        	<ul>
	          <li class="tu"><a href="#"><img src="<%=basePath%>${teacher.member.headpath }" /></a></li>
	          <li>
	            <p class="cose">[航模老师] <b><a href="#">${teacher.member.username }</a></b></p>
	            <p>${empty blogcontent ? "暂无信息":blogcontent}</p>
	            <p class="rr"><a href="#"><img src="<%=basePath%>img/interesting_img/ty.gif" /></a></p>
	          </li>
	        </ul>
        	</c:forEach>
        	</c:otherwise>
        </c:choose>
      </div>
    </div>
    <div class="mmright">
      <div class="ritu">
        <h1><span>参赛作品</span> <a href="<%=basePath%>interest/works_showAllActWorks.action?activitId=${activitId }">全部</a></h1>
        <c:choose>
        	<c:when test="${empty actWorks}">
        		暂无参赛作品!
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${actWorks}" var="actWs" varStatus="vs">
        	<c:if test="${vs.index%5==0}">
        		<ul>
        	</c:if>
	        	<li>
	            <p class="tup"><a href="interest/Comm_showActivityWorkComm.action?workId=${actWs.worksid }"><img src="<%=basePath%>${actWs.showsrc }" /></a></p>
	            <p class="sekuai">编号：${actWs.worksnumber }</p>
	            <p class="bbtyi">
	            <a href="interest/Comm_showActivityWorkComm.action?workId=${actWs.worksid }">${actWs.workstitle }</a></p>
	             <p class="bbtyi"><a href="interest/Comm_showActivityWorkComm.action?workId=${actWs.worksid }"><img src="<%=basePath%>img/interesting_img/byu.gif" /></a></p>
	          	</li>
	       	<c:if test="${vs.index%5==4}">
	       		</ul>
	       	</c:if>
	        </c:forEach>
        	</c:otherwise>
        </c:choose>
      </div>
</div>
  </div>
<div class="mainbody">
	<div class="messpp">
    	 <div class="maind_8">
        <h1>用户热评：</h1>
        
      </div>
      <div class="maind_13" style="width: 900px;"><span>有${workCommentsNum }条评论在讨论</span> </div>
	<div class="maind_10">
	<c:choose>
		<c:when test="${empty workComments}">
			暂无评论!
		</c:when>
		<c:otherwise>
			<c:forEach items="${workComments}" var="workcomm">
				<ul>
		          <li class="tu"><a href="#"><img src="<%=basePath%>${workcomm.member.headpath }" /></a></li>
		          <li class="liuzi"><a href="#">${workcomm.comUserName}</a>：${workcomm.comContent }<br/>
		            ${workcomm.comDate }</li>
		        </ul>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
    </div>
    </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>