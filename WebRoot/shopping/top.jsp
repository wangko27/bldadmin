<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<base href="<%=basePath%>"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/shopping_common.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script language="javascript" src="<%=basePath%>shopping/js/top.js"></script>
  </head>
  <body>
	
	    <jsp:include page="/base/top.jsp"></jsp:include>
		<jsp:include page="/base/toplink.jsp"></jsp:include>
		<div class="mainbody">
		  <div class="logo_ll">
		    <ul>
		      <li class="img"><a href="shopping/shoppingIndex_showIndex.action?t=" target="_blank"><img src="<%=basePath%>img/shopping_img/logo.gif" /></a></li>
		      <li>商品关键字:</li>
		      <li>
		      <form id="seaFor" method="post" action="<%=basePath%>shopping/shpping_searchResult.action">
		        <input id="key" name="searchKey" type="text" value="${empty searchKey ? '请输入关键词，如：儿童,书本': searchKey }" />
			  </form>
		        <a href="#" onclick="return false">
				<img id="seaImg" src="<%=basePath%>img/learning_img/go.gif" />
		        </a>
		      </li>
		    </ul>
		  </div>
		</div>
		<div class="mainbody">
		  <div class="learning_menu">
		    <ul>
		      <li><a href="shopping/shoppingIndex_showIndex.action?t=" class="${empty t ? 'dizhu':'' }">商城首页</a></li>
		      <li><a href="shopping/shpping_showShopList.action?t=1" class="${t eq '1' ? 'dizhu':'' }">商品列表</a></li>
		      <li><a href="shopping/shoppingArticle!list.action?t=2" class="${t eq '2' ? 'dizhu':'' }">购物资讯</a></li>
		      <li><a href="shopping/shoppingQuestion!list.action?t=3" class="${t eq '3' ? 'dizhu':'' }">热心解答</a></li>
		    </ul>
		    <%--
		    <p><span style="cursor: pointer;" id="ls">购物车 <b id="goodsNum">0</b> 件</span> <a href="shopping/shoppingCart_getCartInfo.action">去结算>></a></p>
		  	 --%>
		  	<p><span style="cursor: pointer;" id="ls">购物车 <b id="goodsNum">0</b> 件</span> </p>
		  
		  </div>
		  <div class="commongao">
		   <!--   <div class="llei">类别：<a href="#">航模配件</a> &nbsp;<a href="#">学习用品</a> &nbsp;<a href="#">工具书</a> &nbsp;<a href="#">科普读物</a> &nbsp;<a href="#">资源库题</a> &nbsp;<a href="#">教育电子</a></div>-->
		    <div class="tell">全国统一客户电话：<b>952116</b></div>
		    <div class="help"><a href="<%=basePath%>shopping/shoppingArticle!viewById.action?id=8a80801133065abd0133072ca0d20030">新手入门</a> | <a href="shopping/shoppingArticle!viewById.action?id=8a80801133065abd0133072c2dc5002f">配送</a> | <a href="shopping/shoppingArticle!viewById.action?id=8a80801133065abd0133072bac9f002e">支付</a> | <a href="shopping/shoppingArticle!viewById.action?id=8a80801133065abd01330729aa37002c">售后</a> | <a href="shopping/shoppingArticle!list.action?id=8a8081a131dfdsfdfs312sffndsds009&shownum=1">帮助</a></div>
		  </div>
		</div>
  	</body>
</html>
