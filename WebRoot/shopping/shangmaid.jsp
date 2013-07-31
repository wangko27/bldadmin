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
	<title>您好，欢迎来到952116综合信息门户网！</title>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/shopping_common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/shangmiad.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script language="javascript" src="<%=basePath%>shopping/js/shanglist.js"></script>
	<script language="javascript" src="<%=basePath%>shopping/js/shangmaid.js"></script>
	<script language="javascript" src="<%=basePath%>js/ad.js"></script>
	
	<script type="text/javascript">
		//购买
		function buy(goodsid){
			
			if($("#goodNum").val()==''||isNaN($("#goodNum").val())){
				alert("请输入正确的数目!");
				$("#goodNum").val('1')
				return false;
			}
			if(parseInt($("#goodNum").val())<=0){
				alert("请输入正整数!");
				$("#goodNum").val('1');
				return false;
			}
			
			$("#goodsid").val(goodsid);
			$("#goodsnum").val($("#goodNum").val());
			$("#form_GoodsBuy").submit();
			return false;
		}
	</script>
	
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>


<form action="shopping/buy/order!showReceiver.action" method="post" name="form_GoodsBuy" id="form_GoodsBuy">

	<input type="hidden" name="goodsid" id="goodsid" />
	<input type="hidden" name="goodsnum" id="goodsnum" />
	<input type="hidden" name="buytype" id="buytype" value="1" />
</form>


<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="#">商城</a> > <span>商品</span></div>
</div>
<div class="mainbody">
  <div class="shbiglist">
    <div class="listleft">
      <div class="xiaok">
        <p>热销产品</p>
        <div class="ccp">
        <c:choose>
        <c:when test="${empty hotGoods}">暂无热销产品</c:when>
        <c:otherwise>
        <c:forEach items="${hotGoods}" var="goods">
          <ul>
            <li class="tuimg"><a href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1"><img src="<%=basePath%>${goods.photospath }" /></a></li>
            <li><a href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1">${goods.goodsname }</a></li>
            <li class="ssc">市场价：￥${goods.marketprice }</li>
            <li>商城价：<b>￥${goods.productprice }</b></li>
          </ul>
         </c:forEach>
         </c:otherwise>
         </c:choose>
        </div>
      </div>
      <div class="banner"><img name="advertisement" title="shop-a" src="" /></div>
      <div class="xiaok">
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
        <p class="an"><a href="#"><img src="<%=basePath%>img/shopping_img/tt.gif" /></a></p>
      </div>
    </div>
    <div class="listright">
      <div class="biti">${goods.goodsname }</div>
      <div class="neixin">
        <div class="zitu"><img src="<%=basePath%>${goods.photospath }" /></div>
        <div class="cebb">
          <p><img src="<%=basePath%>img/shopping_img/ttxs.gif" /></p>
          <ul class="liang">
            <li>商&nbsp;&nbsp;城&nbsp;&nbsp;价：<span class="tt1">￥${goods.productprice }</span></li>
            <li>市&nbsp;&nbsp;场&nbsp;&nbsp;价：<span>￥${goods.marketprice }（为您节省￥${goods.marketprice-goods.productprice }）</span></li>
            <li>新旧程度：<span>${goods.condition }</span></li>
            <%-- 
            <li>顾客评论：<span><a href="#">已有${goods.commentsnum }人评论</a></span></li>
            <li>库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存：<span>${goods.stocknum>0 ? '有货':'没货' }，${goods.stocknum }库存</span></li>
          	--%>
          </ul>
          <!-- 
          <ul class="kuai">
            <li><span>购买数量：</span>

			<span>
			<input type="hidden" id="path" value="<%=basePath%>" />
			  <input type="hidden" id="goodsid1" value="${goods.goodsid }" />
              <input value="1" id="goodNum" type="text" />
              </span><span>件</span></li>
            <li class="ddu"><a href="#" onclick="return buy('${goods.goodsid }')"><img src="<%=basePath%>img/shopping_img/gg.gif" /></a>
			 <a href="#?goodsid=${goods.goodsid }" onclick="return false"><img id="ffPic" src="<%=basePath%>img/shopping_img/ff.gif" /></a>
			 
			 </li>

          </ul>
          
          <ul class="liang">
            <li>近期销量：<span>三个月内售出<b>${empty totalBySize ? 0:totalBySize}</b>件</span></li>
            <li>用户关注：<span>已有<b>${goods.attention }人</b>关注</span></li>
          </ul>
           -->
          
		  <ul class="kuai">
              <input value="1" id="goodNum" type="hidden" />
				<input type="hidden" id="path" value="<%=basePath%>" />
			  <input type="hidden" id="goodsid1" value="${goods.goodsid }" />
            <li><span>为保证你的利益,收集购买意向的投票后,爱够将以投票数作为重要依据审核商品的品质等相关情况以决定该商品上架。</span></li>
            <li class="ddu"><a href="#?goodsid=${goods.goodsid }" onclick="return false"><img id="ffPic"  src="img/shopping_img/gg.gif" /></a> </li>
          </ul>
          <ul class="liang">
            <li>想购买人数：<span>已有<b>${missnum }人</b>想购买</span></li>
          </ul>
          
        </div>
      </div>
      <div class="cemeun">
        <ul>
          <li><a href="javascript:;" class="dii">商品介绍</a></li>
          <%-- 
          <li><a href="#">商品热评<span>(${goods.commentsnum })条</span></a></li>
           --%>
        </ul>
      </div>
      <div class="cenei">
      	${goods.productdescription }
      </div>
      <%--
      <div class="cemeun">
        <ul>
          <li><a href="#" class="dii">商品热评</a></li>
          <li class="tt">有<span>${ goods.attention}</span>条评论在讨论</li>
        </ul>
      </div>
      <div class="compa">
      <c:choose>
      	<c:when test="${empty result.content}">暂无评论</c:when>
      	<c:otherwise>
      	<c:forEach items="${result.content}" var="goodsRat">
      	<ul>
          <li class="tu"><a href="#?id=${goodsRat.member.memberid }"><img src="<%=basePath%>${goodsRat.member.headpath }" /></a></li>
          <li class="liuzi"><a href="#?id=${goodsRat.member.memberid }">${goodsRat.nikename }</a>：${goodsRat.ratmsg }<br/>
           ${goodsRat.createdate }</li>
        </ul>
      	</c:forEach>
      	</c:otherwise>
      </c:choose>
      </div>
      <div class="page">
        <c:choose>
      	<c:when test="${empty result.content}">
      	</c:when>
      	<c:otherwise>
			<form id="form1" action="<%=basePath %>shopping/shpping_showGoods.action" method="post">
				<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1">
			</t:tpage>
       		</form>
      	</c:otherwise>
     	</c:choose>
      </div>
       --%>
    </div>
  </div>
</div>
<div class="mainbody">
  <div class="commondi"><a href="http://dsis.952116.com/DSIS_system/">数字化校园系统</a> | <a href="#">技术服务</a> | <a href="#">友情链接</a> | <a href="#">网站导航</a> | <a href="#">广告服务</a> | <a href="#">合作伙伴</a> | <a href="#">帮助中心</a><span><a name="aa" id="aa"></a><a href="javascript:scroll(0,0)"><img src="<%=basePath%>img/learning_img/fan.gif" /></a></span></div>
  <div class="tima">@2011 952116.com 版权所有 ICP09002922号备 湖南爱瑞杰科技发展股份有限公司</div>
</div>
</body>
</html>
