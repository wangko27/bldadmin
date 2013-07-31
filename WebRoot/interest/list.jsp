<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/interesting_common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/zslist.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="interest/XQ_index.action">兴趣</a> >	<span>${activity.activitytitle}</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
      <div class="titi">
      </div>
      <div class="list_3">
            <c:if test="${fn:length(result.content)==0}">
            	<center>该活动暂时没有活动作品!</center>
            </c:if>
            <s:iterator value="result.content" status="st"> 
   			 <s:if test="(#st.index)%5==0">
   			 <ul>
   			 </s:if>	
   			 	<li><p><a href="interest/viewById.action?id=${articleid}&proID=${activity.activityid}"><s:property value="articletitle" /></a></p><span><fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd"/></span></li>
   			 	 <s:if test="(#st.index+1)%5==0"></ul></s:if>   
   			 </s:iterator>
   			 <s:if test="result.content.size()%5!=0"></ul></s:if> 
      </div>
      <div class="page">
      		<form id="form1" action="interest/list.action" method="post">
      			<input  type="hidden" name="articletype" value="${articleType.articletypeid}" />
				<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1">
				</t:tpage>
        	</form>    
      </div>
    </div>
        	<jsp:include page="right.jsp"></jsp:include>
  </div>
</div>
<div class="mainbody">
	<jsp:include page="bottom.jsp"></jsp:include>
</div>
</body>
</html>
