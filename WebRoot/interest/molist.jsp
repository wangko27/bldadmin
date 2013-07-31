<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
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
    <jsp:include page="left.jsp"></jsp:include>
    </div>
    <div class="mmright">
    	<div class="ritu_3">
      <div class="ritu_2">
        <h1><span>参赛作品</span> </h1>
        <c:choose>
        	<c:when test="${empty actWorks}">
      			<center>该活动暂时没有活动作品!</center>
      		</c:when>
        	<c:otherwise>
        		 <c:forEach items="${actWorks}" var="actWork" varStatus="vs">
		        	<c:if test="${vs.index%5==0}">
		        		<ul>
		        	</c:if>
		        	<li>
			            <p class="tup"><a href="interest/Comm_showActivityWorkComm.action?workId=${actWork.worksid }&activitId=${activitId }"><img src="<%=basePath%>${actWork.showsrc }" /></a></p>
			            <p class="sekuai">编号：${actWork.worksnumber }</p>
			            <p class="bbtyi"><a href="interest/Comm_showActivityWorkComm.action?workId=${actWork.worksid }&activitId=${activitId }">${actWork.workstitle }</a></p>
			            <p class="bbtyi"><a href="interest/Comm_showActivityWorkComm.action?workId=${actWork.worksid }&activitId=${activitId }"><img src="<%=basePath%>img/interesting_img/byu.gif" /></a></p>
		         	</li>
		         	<c:if test="${vs.index%5==4}">
		         		</ul>
		         	</c:if>
		        </c:forEach>
        	</c:otherwise>
        </c:choose>
      </div>
      <div class="page">
        <c:choose>
      	<c:when test="${empty actWorks}">
      	</c:when>
      	<c:otherwise>
      	<form id="form1" action="interest/works_showAllActWorks.action" method="post">
				<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1">
			</t:tpage>
        </form>
      	</c:otherwise>
      </c:choose>
      </div>
      </div>
    </div>
  </div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>