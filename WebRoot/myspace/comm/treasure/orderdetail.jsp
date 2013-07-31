<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-订单管理</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/trolley.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/myspace/header.jsp"></jsp:include> 
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		  <!-- 用户中心中部左边菜单栏 -->
		  <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		  <!-- 用户中心中部右边内容详细页 -->
	      <div class="right">
	        
	        <div class="bobti">百宝箱</div>
	        <div class="dtai">
	          <ul>
	            <li><a href="myspace/comm/downManaList.action">下载管理</a></li>
	            <li><a href="myspace/comm/uploadSrcList.action">资源管理</a></li>
	            <li><a href="myspace/comm/mquestionList.action">问题管理</a></li>
	            <li><a href="myspace/comm/worksList.action">作品管理</a></li>
            	<li><a href="myspace/comm/carItemList.action">购物车</a></li>
             	<li class="bai">我的订单</li>
            	<li><a href="myspace/comm/receiverList.action">地址管理</a></li>
	            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
	          </ul>
	        </div>
	        
      		<div class="dingxia">
      			<h1>订单详情：</h1>
        		<table width="700" border="0" cellspacing="0" cellpadding="0">
				  <tr>
				    <td>订单编号：<span>${myorder.ordersn}</span></td>
				    <td colspan="2">订单状态：
				    <span>
		              <s:if test="myorder.orderstatus == 1">
		                交易成功<br/>
		              <s:if test='myorder.israt == "0"'>未评论</s:if>
		              <s:elseif test='myorder.israt == "1"'>已评论</s:elseif>
		              </s:if>
		              <s:elseif test="myorder.orderstatus == 2">等待付款</s:elseif>
		              <s:elseif test="myorder.orderstatus == 4 || myorder.orderstatus == 3">已付款<br />等待收取</s:elseif>
		              <s:elseif test="myorder.orderstatus == 5">已取消</s:elseif>
		              <s:elseif test="myorder.orderstatus == 6">退款中</s:elseif>
		              <s:elseif test="myorder.orderstatus == 7">已退款</s:elseif>
				    </span>
				    </td>
				    
				  </tr>
				  <s:iterator value="myorder.orderitems" status="stitem" id = "item">
				   <tr>
				     <td>商品名称：<a target="_blank" href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1">${goods.goodsname }</a></td>
				     <td>商品数量：<span>${goodsnum}</span></td>
				     <td>商品单价：<span>${goods.productprice }元</span></td>
				   </tr>
				  </s:iterator>
				 
				  <tr>
				    <td colspan="3">订单总价：<b>${myorder.totalamount }元</b></td>
				  </tr>
				</table>
				<table width="700" border="0" cellspacing="0" cellpadding="0">
				  <tr>
				    <td>收货地址：<span>${myorder.shiparea}&nbsp;${myorder.shipaddress}</span></td>
				  </tr>
				  <tr>
				    <td>收货方式：<span>${myorder.deliverytypename}</span></td>
				  </tr>
				   <tr>
				    <td>收&nbsp;货&nbsp;人&nbsp;：<span>${myorder.shipname}</span></td>
				  </tr>
				  <tr>
				    <td>联系电话：<span>${myorder.shipmobile}</span></td>
				  </tr>
				</table>
				<h1>订单日志：</h1>
     			<table width="700" border="0" cellspacing="0" cellpadding="0">
     			
				  <s:iterator value="myorder.orderLogs" status="stlog" id = "orderlog">
			        <s:if test="#stlog.odd||#stlog.first">
			        <tr>	
			        </s:if>
			        
					<td>${orderlog.orderloginfo }</td>
					
			        <s:if test="#stlog.even||#stlog.last">
			        </tr>	
			        </s:if>
				  </s:iterator>
				  

				</table>
				<h1>备注：</h1>
				<ul class="uui">
					<li>客服电话：0731-952116</li>
					<li>Email：952116@sina.com</li>
				</ul>
			</div>
			
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
  	
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
