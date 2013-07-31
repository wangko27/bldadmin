<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		<%
			String articleTypeId = request.getParameter("articleTypeId");
			if (null == articleTypeId) {
				articleTypeId = "";
			}
			String shownum = request.getParameter("shownum");
			if (null == shownum) {
				shownum = "0";
			}
		%>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="css/mshimain.css" rel="stylesheet" type="text/css" />
<link href="css/news/baikelist.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript">
		//设置查询类别
			function articleType(articleTypeId,shownum){
				$("#articleTypeId").val(articleTypeId);
				$("#shownum").val(shownum);			
				$("#articlesrclist").submit();				
				return false;
			}			
			//设置当前选中的选项
			function showorder(index){
				$(".dda ul li").each(function(i){
					if(index==i){
						$(this).addClass("dibai");
					}else{
						$(this).removeClass("dibai");
					}
				});
			}
			$().ready(function(){
				showorder(<%=shownum%>);
			});		
		</script>
</head>
<body>

	<jsp:include page="news_top.jsp"></jsp:include>
	<div class="mainbody">
  <div class="seat"><a href="<%=basePath %>index/index.action">952116综合信息门户网首页</a> > <a href="Article/Show_News_Index.action">资讯</a> > <span>生活百科</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
      <div class="titi"><img src="img/news_img/baitit.gif" /></div>
      <c:if test="${not empty articleType}">
       <div class="dda">
        <ul>
          <li class="dibai" ><a onclick="return articleType('8a80818c31bb7cc50131bb7fbde70002','0')">全部</a></li>
          <c:forEach items="${articleType}" var="at" varStatus="vs">
           	<li><a onclick="return articleType('${at.articletypeid }','${vs.index+1 }')">${at.articletypename }</a></li>
          </c:forEach>
        </ul>
      </div> 
      </c:if>
      <div class="list_3">
       <c:if test="${empty result.content}">
       		<center>该类别暂时没有数据</center>
       </c:if>
       <c:if test="${not empty result.content}">
      		<c:forEach items="${result.content}" var="vt" varStatus="vs">
        		<ul>
        		<li><p>
        			<a href="<%=basePath %>Article/getArticleById.action?id=${vt.articlesrcid}" title="${vt.articletitle }">
        			${fn:substring(vt.articletitle , 0,30)}</a>
        		</p><span>
      			 <fmt:formatDate value="${vt.createdate}" pattern="yyyy-MM-dd"/>
      			 </span></li>
        	</ul>
    	</c:forEach>
   	</c:if>
      </div>
      <div class="page">
     		<form action="Article/list.action?id=" method="post"
			name="articlesrclist" id="articlesrclist">
			<input name="articleTypeId" id="articleTypeId" type="hidden" value="<%=articleTypeId%>"/>
			<input name="shownum" id="shownum" type="hidden" value="<%=shownum%>"/>
  			<t:tpage formId="articlesrclist" pageDiv="page" page="${result.page}"	goImg="img/learning_img/gog.gif"></t:tpage>
			</form>		 
      </div>
    </div>
        <jsp:include page="news_right.jsp"></jsp:include>
  </div>
</div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
