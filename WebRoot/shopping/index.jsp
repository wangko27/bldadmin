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
	<title>您好，欢迎来到952116综合信息门户网！</title>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/shopping_common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/shopping.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/bb.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script language="javascript" src="<%=basePath%>shopping/js/shanglist.js"></script>
	<script language="javascript" src="<%=basePath%>shopping/js/shangmaid.js"></script>
	<script language="javascript" src="<%=basePath%>js/ad.js"></script>
	</head>
	<body>
	<jsp:include page="top.jsp"></jsp:include>
	<input type="hidden" id="path" value="<%=basePath%>" />
	<div class="mainbody">
	  <div class="shbig">
	    <div class="shleft">
	      <div class="qlei">
	        <p class="pbj1">全部商品分类</p>
	        <div class="fenle">
	        <c:forEach begin="1" end="${size}" varStatus="vs">
	          <ul>
	            <li class="tt${vs.index-1==0 ? '' : vs.index-1 }">${goodsMianSrot[vs.index-1].categoryname }</li>
	            <li class="taat">
	            <c:choose>
	            <c:when test="${empty goodsMianSrot[vs.index-1].goodesCategories}">暂无子类</c:when>
	            <c:otherwise>
	            <c:forEach items="${goodsMianSrot[vs.index-1].goodesCategories}" var="goodsSrot" varStatus="vs">
	            <c:if test="${vs.index<4}">
	            	<c:if test="${goodsSrot.categoryname!='其他' }">
		            	<a href="shopping/shpping_showShopList.action?byTopicId=${goodsSrot.categoryid }&t=1&byMainTopicId=${goodsMianSrot[vs.index-1].categoryid }">
		            	${goodsSrot.categoryname }</a>
	            	</c:if> 
	            	<c:if test="${(vs.index+1)%2==0}">
            			<br/>
            		</c:if>
            	</c:if>	
	            </c:forEach>
	            </c:otherwise>
	            </c:choose>
	            </li>
	          </ul>
	          </c:forEach>
	        </div>
	        <p class="pbj2">&nbsp;</p>
	      </div>
	      <div class="banner"><img name="advertisement" title="shop-index-b" src="" /></div>
	    </div>
	    <div class="shright">
	      <div class="up">
	        <div class="uphh">
	        <div id="player">
						<ul class="Limg">
						<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="shop-index-a1" src="" width="480" height="190"/><p>宣传新专辑与徐静蕾合作很紧张 </p></a></li>
						<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="shop-index-a2" src="" width="480" height="190"/><p>尚雯婕为演唱会携天价古董拍海报</p></a></li>
						<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="shop-index-a3" src="" width="480" height="190"/><p>爸妈齐助阵周杰伦2010年新专辑MV</p></a></li>
						<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="shop-index-a4" src="" width="480" height="190"/><p>阿朵唱功遭质疑撩裙露臀卖肉博眼球</p></a></li>
						</ul>
					<cite class="Nubbt"><span class="on">1</span><span >2</span><span >3</span><span >4</span></cite> 
			</div>
				<script language="javascript" src="<%=basePath%>js/bb.js"></script>
	        </div>
	        <div class="login_1">
	        	<jsp:include page="/base/logging_status.jsp?pathitem=shopping_img"></jsp:include>
	        </div>
	      </div>
	      <div class="donw">
	        <div class="donqie"> 
	        <c:choose>
	        <c:when test="${empty hotMainsrot}">暂无热销类别</c:when>
	        <c:otherwise>
	        <c:forEach items="${hotMainsrot}" var="hs" varStatus="vs">
	        	 <a href="shopping/shoppingIndex_showSortIndex.action?sortId=${hs.categoryid }" onclick="return false" name="cate" class="${vs.index==0 ? 'dind':''}">${hs.categoryname }</a> 
	        </c:forEach>
	        </c:otherwise>
	        </c:choose>
	        </div>
	        <div class="donwmaid">
	        <c:choose>
	        <c:when test="${empty hotGoodses}">没有热销产品</c:when>
	        <c:otherwise>
	        <c:forEach items="${hotGoodses}" var="hg" varStatus="vs">
	        	<c:if test="${vs.index%5==0}">
	        		<ul>
	        	</c:if>
	        	<li> 
	        	<a href="shopping/shpping_showGoods.action?goodsId=${hg.goodsid }&t=1"><img src="<%=basePath%>${hg.photospath }" /></a>
	              <p><a href="shopping/shpping_showGoods.action?goodsId=${hg.goodsid }&t=1">${fn:substring(hg.goodsname,0,12) }</a></p>
	              <p class="shanzi">市场价：￥${hg.marketprice } 元</p>
	              <p>商城价：<b>￥${hg.productprice } 元</b></p>
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
	  </div>
	</div>
	<div class="mainbody">
	  <div class="news11">
	    <c:choose>
	    <c:when test="${empty newArticle}"></c:when>
	    <c:otherwise>
	     <ul>
	    <c:forEach items="${newArticle }" var="na">
	    	<c:if test="${!empty na.articletitle}">
	    	<li>${fn:substring( na.articletitle , 0,10) }</li>
	    	</c:if>
	    </c:forEach>
	    </ul>
	    </c:otherwise>
	    </c:choose>
	    
	    <p><a href="#"><img src="<%=basePath%>img/shopping_img/dd.gif" /></a></p>
	  </div>
	</div>
	<div class="mainbody">
	  <div class="shbig_1">
	    <div class="guanzi">
	      <p>
	      <c:choose>
	      <c:when test="${empty hotSrot}"></c:when>
	      <c:otherwise>
	      <c:forEach items="${hotSrot}" var="hs" varStatus="vs">
	      	<a href="shopping/shpping_showShopList.action?byTopicId=${hs.categoryid }&t=1&byMainTopicId=${hs.goodesCategory.categoryid }">
	      	${hs.categoryname }</a>${(vs.index+1)==hotSrotsize ? '' : '-' }
	      </c:forEach>
	      </c:otherwise>
	      </c:choose>
	      </p>
	      <span><a href="<%=basePath %>shopping/shpping_showNewGoods.action?typeId=1&t=1"><img src="<%=basePath%>img/home_img/more.gif" /></a></span></div>
	    <div class="donwxia">
	      <div class="donwleft">
	        <div class="titi1">本周畅销排行</div>
	        <div class="dushu">
	          <c:choose>
		        <c:when test="${empty salabilityGoods}">暂无排行</c:when>
		        <c:otherwise>
		        <c:forEach items="${salabilityGoods}" var="salgoods" varStatus="vs">
		          <ul class="zhai">
		            <li class="hao">
		            ${vs.index+1 }
		            </li><li>
		            <a href="shopping/shpping_showGoods.action?goodsId=${salgoods.goodsid }&t=1">
		            ${fn:substring(salgoods.goodsname,0,12) }</a></li>
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
	      <div class="donwright">
	        <div class="scmenu">
	        <ul>
	        <c:choose>
	        <c:when test="${empty goodsMianSrot}">暂无类别</c:when>
	        <c:otherwise>
	        <c:forEach items="${goodsMianSrot}" var="gs">
	         	<li class="${gs.categoryid eq newId ? 'mmbj':'' }"><a href="shopping/shoppingIndex_showIndex.action?newId=${gs.categoryid}&t=">${gs.categoryname }</a></li>
	        </c:forEach>
	        </c:otherwise>
	        </c:choose>
	        </ul>
	        </div>
	        <div class="shutu">
	        <c:choose>
	        <c:when test="${empty newGoodses}">没有最新产品</c:when>
	        <c:otherwise>
	        <c:forEach items="${newGoodses}" var="hg" varStatus="vs">
	        	<c:if test="${vs.index%5==0}">
	        		<ul>
	        	</c:if>
	        	<li> 
	        	<a href="shopping/shpping_showGoods.action?goodsId=${hg.goodsid }&t=1"><img src="<%=basePath%>${hg.photospath }" /></a>
	              <p><a href="shopping/shpping_showGoods.action?goodsId=${hg.goodsid }&t=1">${fn:substring(hg.goodsname,0,10) }</a></p>
	              <p class="shanzi">市场价：￥${hg.marketprice }</p>
	              <p>商城价：<b>￥${hg.productprice }</b></p>
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
	  </div>
	</div>
	<div class="mainbody">
	  <div class="shbig_2">
	    <div class="guanzi">
	      <p>
	      <c:choose>
	      <c:when test="${empty dyHotSrot}"></c:when>
	      <c:otherwise>
	      <c:forEach items="${dyHotSrot}" var="hs" varStatus="vs">
	      	<a href="shopping/shpping_showShopList.action?byTopicId=${hs.categoryid }&t=1&byMainTopicId=${hs.goodesCategory.categoryid }">${hs.categoryname }</a> ${(vs.index+1)==dyHotSrotSize ? '' : '-' }
	      </c:forEach>
	      </c:otherwise>
	      </c:choose>
	      </p>
	      <span><a href="<%=basePath %>shopping/shpping_showNewGoods.action?typeId=2&t=1"><img src="<%=basePath%>img/home_img/more.gif" /></a></span></div>
	    <div class="donwxia">
	      <div class="donwleft">
	        <div class="titi1">热心解答</div>
	        <div class="answo">
	          <p><a href="<%=basePath %>shopping/shoppingQuestion!list.action?t=3" class="wen">我要提问</a> | <a href="<%=basePath %>shopping/shoppingQuestion!list.action?t=3">查看全部</a></p>
	          <ul>
	          <c:choose>
	          <c:when test="${empty newAnswer}">暂无热心解答</c:when>
	          <c:otherwise>
	          <c:forEach items="${newAnswer}" var="answer">
	          	<li><a href="<%=basePath %>shopping/shoppingQuestion!getQuestionById.action?id=${answer.zealanswerid }&t=3">
	          	${fn:substring(answer.questiontitle,0,16)}
	          </a></li>
	          </c:forEach>
	          </c:otherwise>
	          </c:choose>
	          </ul>
	         </div>
	      </div>
	      <div class="donwright">
	        <div class="scmenu">
	          <ul>
	            <li class="${dzSortId eq '8a8080bf324c3b0e01324c3d9a2c0001' ? 'mmbj':' ' }"><a href="shopping/shoppingIndex_showIndex.action?dzSortId=8a8080bf324c3b0e01324c3d9a2c0001&t=">电子教育</a></li>
	            <li class="${dzSortId eq '8a8080bf324c3b0e01324c3d9a2c0001' ? ' ':'mmbj' }"><a href="shopping/shoppingIndex_showIndex.action?dzSortId=8a8080bf324c3b0e01324c3e2fe40002&t=">运动生活</a></li>
	          </ul>
	        </div>
	        <div class="shutu_1">
	          <ul>
	          <c:choose>
		        <c:when test="${empty dyHotGoods}">没有最新产品</c:when>
		        <c:otherwise>
			    <c:forEach items="${dyHotGoods}" var="hg">
		        	<li> 
		        	<a href="shopping/shpping_showGoods.action?goodsId=${hg.goodsid }&t=1"><img src="<%=basePath%>${hg.photospath }" /></a>
		              <p><a href="shopping/shpping_showGoods.action?goodsId=${hg.goodsid }&t=1">
		              ${fn:substring(hg.goodsname,0,12) }</a></p>
		              <p class="shanzi">市场价：￥${hg.marketprice }</p>
		              <p>商城价：<b>￥${hg.productprice }</b></p>
		            </li>
		        </c:forEach>
		        </c:otherwise>
		        </c:choose>
	            </ul>
	         </div>
	      </div>
	    </div>
	  </div>
	</div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
	</html>