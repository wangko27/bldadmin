<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<base href="<%=basePath%>"/>
	<link href="<%=basePath%>css/shopping/shlist_2.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script language="javascript" src="<%=basePath%>shopping/js/shanglist.js"></script>
	<script language="javascript" src="<%=basePath%>shopping/js/shangmaid.js"></script>
	<script language="javascript" src="<%=basePath%>js/ad.js"></script>
	</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="shopping/shoppingIndex_showIndex.action?t=">商城</a> > <span>商品列表</span></div>
</div> 
<div class="mainbody">
  <div class="shbiglist">
    <div class="listleft">
      <div class="shanglei">
        <p>全部商品分类</p>
        <div class="alllei">
          <ul>
            <li class="tb1"><a href="shopping/shpping_showShopList.action?byTopicId=&byMainTopicId=&t=1">全部</a>(${allGoodsNum })</li>
          </ul>
          <c:choose>
          <c:when test="${empty gMains}">没有类型</c:when>
          <c:otherwise>
         <c:forEach items="${gMains}" var="mainSrot" varStatus="vs">
          <ul style="display: ${(empty byMainTopicId || mainSrot.categoryid!=byMainTopicId )? '':'none' }">
          <li class="tb${vs.index+2 }"><a href="shopping/shpping_showShopList.action?byMainTopicId=${mainSrot.categoryid }&t=1&byTopicId=">${mainSrot.categoryname }</a>(${mainSrot.goodsnum })</li>
          </ul>
          <ul class="uty" style="display: ${(empty byMainTopicId || mainSrot.categoryid!=byMainTopicId )? 'none':'' }">
            <li class="tb${vs.index+2 }_1"><a href="shopping/shpping_showShopList.action?byMainTopicId=${mainSrot.categoryid }&t=1&byTopicId=">${mainSrot.categoryname }</a>(${mainSrot.goodsnum })</li>
            <li>
            <c:choose>
            <c:when test="${empty mainSrot.goodesCategories}">没有子类</c:when>
            <c:otherwise>
            	<c:forEach items="${mainSrot.goodesCategories}" var="srot" varStatus="vs">
            	
            	<p><a href="shopping/shpping_showShopList.action?byTopicId=${srot.categoryid }&t=1&byMainTopicId=${mainSrot.categoryid }">
            	${srot.categoryname }</a> <span>(${srot.goodsnum })</span></p>
            	
            	</c:forEach>
            </c:otherwise>
            </c:choose>
            </li>
          </ul>
          </c:forEach>
          </c:otherwise>
          </c:choose>
        </div>
      </div>
      <div class="xiaok">
	  <input type="hidden" id="path" value="<%=basePath%>" />
        <p>本周畅销排行</p>
        <div class="dushu">
        <c:choose>
        <c:when test="${empty salabilityGoods}">暂无排行</c:when>
        <c:otherwise>
        <c:forEach items="${salabilityGoods}" var="salgoods" varStatus="vs">
          <ul class="zhai">
            <li class="hao">${vs.index+1 }</li>
            <li><a href="shopping/shpping_showGoods.action?goodsId=${salgoods.goodsid }&t=1">${salgoods.goodsname }</a></li>
          </ul>
          <ul class="kuan" style="display:none">
            <li class="hao1">${vs.index+1 }</li>
            <li>${salgoods.goodsname }</li>
            <li class="tut"><a href="shopping/shpping_showGoods.action?goodsId=${salgoods.goodsid }&t=1"><img src="<%=basePath%>${salgoods.photospath }" /></a></li>
            <li class="shuzi">￥${salgoods.productprice }</li>
          </ul>
       </c:forEach>
       </c:otherwise>
       </c:choose>
        </div>
      </div>
      <div class="banner"><img name="advertisement" title="shop-list-a" src="" />
<input type="hidden" id="path" value="<%=basePath%>" /></div>
      <div class="xiaok">
        <p>购物资讯</p>
        <div class="gg">
        <c:choose>
        <c:when test="${empty goShoppingSys}">没有新的咨询</c:when>
        <c:otherwise>
		<c:forEach items="${goShoppingSys}" var="sys">
		 	<a href="shopping/shoppingArticle!viewById.action?id=${sys.articleid }&t=2" >
		 	${fn:substring(sys.articletitle , 0,15)}
		 </a> 
		</c:forEach>
		</c:otherwise>
		</c:choose>
        </div>
        <p class="an" ><a href="#"><img src="<%=basePath%>img/shopping_img/tt.gif" /></a></p>
      </div>
    </div>
    <div class="listright">
      <div class="sskl"><a href="shopping/shpping_showShopList.action?byTopicId=&byMainTopicId=&t=1">全部商品</a>
       <a href="shopping/shpping_showShopList.action?byMainTopicId=${mainC.categoryid }&t=1&byTopicId=">${mainC.categoryname }</a> <span>${clidC. categoryname}</span> <span class="sprr">相关商品
       <c:choose>
       	<c:when test="${empty clidC && empty mainC}">
       		${allGoodsNum }
       	</c:when>
       	<c:otherwise>
       	${empty clidC ? mainC.goodsnum : clidC.goodsnum}
       	</c:otherwise>
       </c:choose>
       件</span></div>
      <div class="stytu">
      	  <div class="stytumeun">
      	  <a href="shopping/shpping_showShopList.action?byTermId=1&t=1" class=" ${(byTermId==1 ||empty byTermId)? 'dbai':''}">按销量</a>
      	  <a href="shopping/shpping_showShopList.action?byTermId=2&t=1" class="${(byTermId==2)? 'dbai':''}">按价格</a></div>
          <div class="page_1">
            
           </div>
          <div class="spintu">
          <c:choose>
          <c:when test="${empty result.content}"><cent>没有查看信息</cent></c:when>
          <c:otherwise>
          <c:forEach items="${result.content}" var="goods" varStatus="vs">
          <c:if test="${vs.index%4==0}">
          	<ul>
          </c:if>
            	<li>
                	<p class="p1tu"><a href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1"><img src="<%=basePath%>${goods.photospath }" /></a></p>
                    <p class="p2zi"><a href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1">${goods.goodsname } </a></p>
                    <p><span class="hong">￥${goods.productprice }</span>  <span class="shan">￥${goods.marketprice }</span></p>
                </li>
          <c:if test="${vs.index%4==3}">
            </ul>
          </c:if>   
            </c:forEach>
          </c:otherwise>
          </c:choose>
          </div>
         <div class="page">
        <c:choose>
      	<c:when test="${empty result.content}">
      	</c:when>
      	<c:otherwise>
			<form id="form1" action="shopping/shpping_showShopList.action" method="post">
				<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1">
			</t:tpage>
       		</form>
      	</c:otherwise>
     	</c:choose>
          </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
