<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/baikelist.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script src="<%=basePath%>learn/teacherbema/js/xing.js"></script>
		<script type="text/javascript">
			function articleType(articleTypeId,shownum){
				$("#articleTypeId").val(articleTypeId);
				$("#shownum").val(shownum);			
				$("#newslist").submit();				
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
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="<%=basePath%>Article/Show_News_Index.action">资讯</a> > <span>今日新闻</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
      <div class="titi"><img src="img/news_img/news.gif" /></div>
      <c:if test="${not empty articleType}">
       <div class="dda">
        <ul>
          <li class="dibai" ><a onclick="return articleType('','0')">全部</a></li>
          <li class="dibai" ><a onclick="return articleType('8a80818c31b6a6270131b6a835780012','1')">系统公告</a></li>
          <c:forEach items="${articleType}" var="at" varStatus="vs">
           	<li><a onclick="return articleType('${at.articletypeid }','${vs.index+2 }')">${at.articletypename }</a></li>
          </c:forEach>
        </ul>
      </div> 
      </c:if>
      	<%
     		if(!articleTypeId.equals("8a80818c31b6a6270131b6a835780012")){
     	 %>
      	<div class="list_3">
 			<s:if test="result.content.size()<=0">
 				暂无数据
 			</s:if>
 			<s:else>
 			 	<s:iterator value="result.content" status="st" var="a"> 
   				 <s:if test="(#st.index)%5==0">
   					 <ul>
   				 </s:if>	
   			 	<li><p><a href="${pageContext.request.contextPath }/Article/getArticleById.action?id=${a.articlesrcid}">${fn:substring(a.articletitle,0,30 )}</a></p><span><fmt:formatDate value="${a.createdate}" pattern="yyyy-MM-dd"/></span></li>
   			 	 <s:if test="(#st.index+1)%5==0"></ul></s:if>   
   			 </s:iterator>
   			  <s:if test="result.content.size()%5!=0"></ul></s:if>
 			</s:else>
 		 </div>
 		 <%} %>
     	<%
     		if(articleTypeId.equals("8a80818c31b6a6270131b6a835780012")){
     	 %>
      	<div class="list_3">
 			<s:if test="result.content.size()<=0">
 				暂无数据
 			</s:if>
 			<s:else>
 			 	<s:iterator value="result.content" status="st" var="a"> 
   				 <s:if test="(#st.index)%5==0">
   					 <ul>
   				 </s:if>
   			 	<li><p><a href="Article/viewSysById.action?id=${a.articleid}">${fn:substring(a.articletitle,0,30 )}</a></p><span><fmt:formatDate value="${a.createdate}" pattern="yyyy-MM-dd"/></span></li>
   			 	 <s:if test="(#st.index+1)%5==0"></ul></s:if>   
   			 </s:iterator>
   			  <s:if test="result.content.size()%5!=0"></ul></s:if>
 			</s:else>
 		 </div>
		<%} %> 
				<form id="newslist" action="Article/listNews.action" method="post" name="newslist">
 	      			<input name="articleTypeId" id="articleTypeId" type="hidden" value="<%=articleTypeId%>"/>
 	      			<input name="shownum" id="shownum" type="hidden" value="<%=shownum%>"/>
					<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="newslist"></t:tpage>
       			 </form> 
    </div>
    <jsp:include page="news_right.jsp"></jsp:include>
  </div>
</div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
