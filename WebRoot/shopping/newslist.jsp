<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String articleType=request.getParameter("articleType");
		if(articleType==null){
			articleType="";
		}
	String shownum=request.getParameter("shownum");
		if(shownum==null){
			shownum="0";
		}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/shopping/shopping_common.css" rel="stylesheet" type="text/css" />
<link href="css/shopping/shlist_1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script language="javascript" src="<%=basePath%>shopping/js/shangmaid.js"></script>
		<script type="text/javascript">
			//设置查询类别
			function articleType(articleType,shownum){
				$("#articleType").val(articleType);
				$("#shownum").val(shownum);	
				$("#articlelist").submit();				
				return false;
			}			
			//设置当前选中的选项
			function show(index){
				$(".dda ul li").each(function(i){
					if(index==i){
						$(this).addClass("dibai");
					}else{
						$(this).removeClass("dibai");
					}
				});
			}
			$().ready(function(){
				show(<%=shownum%>);
			});
		</script>
</head>
<body> 
<jsp:include page="top.jsp"></jsp:include>
<input type="hidden" id="path" value="<%=basePath%>" />
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="#">商城</a> > <span>购物资讯</span></div>
</div>
<div class="mainbody">
  <div class="shbiglist">
   <jsp:include page="comm_left.jsp"></jsp:include>
    <div class="listright">
      <div class="titi"><img src="img/shopping_img/zix.gif" /></div>
      <div class="guanf">
      	<ul>
      	<c:choose>
      		<c:when test="${empty officialArticle}">
      			<center>暂时没有数据</center>
      		</c:when>
      		<c:otherwise>
      			<c:forEach items="${officialArticle}" var="oa" varStatus="vs">
      			   <li>
            		<p><a href="<%=basePath %>shopping/shoppingArticle!viewById.action?id=${oa.articleid}" title="${oa.articletitle }">${fn:substring(oa.articletitle  , 0,30)}</a></p>
           		  <span><fmt:formatDate value="${oa.createdate}" pattern="yyyy-MM-dd"/></span></li>	
      			</c:forEach>
      		</c:otherwise>
      	</c:choose>
        </ul>
      </div>
      <div class="dda">
        <ul>
          <li class="dibai"><a href="#" onclick="return articleType('','0')">全部</a></li>
          <li><a href="#" onclick="return articleType('8a8081a131dfdsfdfs312sffndsds009','1')">商城帮助</a></li>
          <li><span>|</span></li>
          <li><a href="#" onclick="return articleType('8a808333vggfdsfdfs312sffndsds009','3')">网购知识</a></li>
        </ul>
      </div>
      <div class="list_3">
      <c:choose>
      	<c:when test="${empty result.content}">
      		<center>暂时没有数据</center>
      	</c:when>
		<c:otherwise>
			<s:iterator value="result.content" status="st"> 
   			 <s:if test="(#st.index)%5==0">
   			 <ul>
   			 </s:if>	
   			 	<li><p><a href="<%=basePath %>shopping/shoppingArticle!viewById.action?id=${articleid}" title="${articletitle }">${fn:substring(articletitle  , 0,30)}</a></p><span><fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd"/></span></li>
   			 	 <s:if test="(#st.index+1)%5==0"></ul></s:if>   
   			 </s:iterator>
   			 <s:if test="result.content.size()%5!=0"></ul></s:if> 
		</c:otherwise>
      </c:choose>
      </div>
      <div class="page">
        <ul>
        <form action="<%=basePath %>shopping/shoppingArticle!list.action" method="post" name="articlelist" id="articlelist">
			<input type="hidden" name="articleType" id="articleType" value="<%=articleType %>"/>
			<input type="hidden" name="shownum" id="shownum" value="<%=shownum %>"/>
        	<t:tpage formId="articlelist" pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
		</form>
        </ul>
      </div>
    </div>
  </div>
</div>
<jsp:include page="/base/bottom.jsp"></jsp:include>
</html>
