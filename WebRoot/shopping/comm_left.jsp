<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="/struts-tags" prefix="s"%>
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
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script src="<%=basePath%>shopping/js/xing.js"></script>
		<script language="javascript" src="<%=basePath%>js/ad.js"></script>
		<script type="text/javascript">
		function mouseOver(i,j){
			var showid=eval("show"+i);
			var hideid=eval("hide"+j);
			showid.style.display="none";
			hideid.style.display="";
		}
		function mouseOut(i,j){
			var showid=eval("show"+i);
			var hideid=eval("hide"+j);
			showid.style.display="";
			hideid.style.display="none";
		}
		</script>  
</head>
<body>
    <s:action name="common" executeResult="false"></s:action>
    <input type="hidden" id="path" value="<%=basePath%>" />
   <div class="listleft">
      <div class="xiaok">
        <p>热销产品</p>
        <div class="ccp">
        <c:choose>
        	<c:when test="${empty hotgoods}">
        		<center>暂时没有数据</center>
        	</c:when>
        	<c:otherwise>
	        <c:forEach items="${hotgoods}" var="hot" varStatus="st"> 
	           <ul>
	            <li class="tuimg"><a href="<%=basePath %>shopping/shpping_showGoods.action?goodsId=${hot.goodsid }"><img src="<%=basePath %>${hot.photospath}" /></a></li>
	            <li><a href="#">${hot.goodsname }</a></li>
	            <li class="ssc">市场价：￥${hot.marketprice }</li>
	            <li>商城价：<b>￥${hot.productprice }</b></li>
	          </ul>
	          </c:forEach>
        	</c:otherwise>
        </c:choose>
        </div>
      </div>
      <div class="banner">
      <img name="advertisement" title="shop-index-information-a" src="" />
      </div>
      <div class="xiaok">
        <p>本周畅销排行</p>
         <div class="dushu" >
		<br /><c:choose>
			<c:when test="${empty bestsales}">
				<center>暂时没有数据</center>
			</c:when>
			<c:otherwise>
				<c:forEach items="${bestsales}" var="bs" varStatus="vs">
					<ul class="zhai" style="display:" onmouseover="mouseOver(${vs.index+1 },${vs.index+1 })"  id="show${vs.index+1 }" >
           			 	<li class="hao">${vs.index+1}<br /></li>
            			<li><a href="<%=basePath%>shopping/shpping_showGoods.action?goodsId=${bs.goodsid }">${bs.goodsname }</a><br /></li>
         			</ul>
         			<ul class="kuan" id="hide${vs.index+1 }" style="display:none" onmouseout="mouseOut(${vs.index+1 },${vs.index+1 })">
           				<li class="hao1">${vs.index+1}<br /></li>
            			<li>${bs.goodsname }<br /></li>
            			<li class="tut"><a href="<%=basePath%>shopping/shpping_showGoods.action?goodsId=${bs.goodsid }"><img src="<%=basePath%>${bs.photospath }" /></a><br /></li>
            			<li class="shuzi">￥${bs.marketprice }<br /></li>
          			</ul>
				</c:forEach>
			</c:otherwise>
		</c:choose>
        </div>
      </div>
      <div class="xiaok">
        <p>购物资讯</p>
        <div class="gg"> 
        <c:choose>
			<c:when test="${empty sysofgoods}">
        	<center>暂是还没有排行信息</center>
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${sysofgoods}" var="sysgood" varStatus="vs">
        			<a href="<%=basePath%>shopping/shoppingArticle!viewById.action?id=${sysgood.articleid }" title="${sysgood.articletitle }">
        			${fn:substring(sysgood.articletitle , 0,15)}</a>
        		</c:forEach>
        	</c:otherwise>
        </c:choose>
	 	</div>
        <p class="an"><a href="#"><img src="img/shopping_img/tt.gif" /></a></p>
      </div>
   	</div>
</body>
</html>
