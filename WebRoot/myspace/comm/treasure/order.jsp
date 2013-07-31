<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>

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
	        
	        <div class="qunbu">
	          <ul>
	            <li><a href="myspace/comm/orderList.action" <s:if test='orderstatuStr == null || orderstatuStr == ""'> class="dbu" </s:if>>全部</a></li>
	            <li>|</li>
	            <li><a href="myspace/comm/orderList.action?orderstatuStr=1,3,4" <s:if test='orderstatuStr=="1,3,4"'> class="dbu" </s:if>>已购买</a></li>
	            <li>|</li>
	            <li><a href="myspace/comm/orderList.action?orderstatuStr=2" <s:if test='orderstatuStr == "2"'> class="dbu" </s:if>>需付款</a></li>
	            <li>|</li>
	            <li><a href="myspace/comm/orderList.action?orderstatuStr=5" <s:if test='orderstatuStr == "5"'> class="dbu" </s:if>>已取消</a></li>
	            <li>|</li>
	            <li><a href="myspace/comm/orderList.action?orderstatuStr=7,6" <s:if test='orderstatuStr == "7,6"'> class="dbu" </s:if>>已退款</a></li>
	          </ul>
	        </div>
	        <div class="tablist">
	          <div class="bti">
	            <ul>
	              <li class="c1">商品</li>
	              <li class="c2">商城价(元)</li>
	              <li class="c2">数量</li>
	              <li class="c3">实付金额(元)</li>
	              <li class="c3">订单状态</tli>
	              <li class="c3" style="border-right:none;">操作</li>
	            </ul>
	          </div>
	          <table border="0" cellspacing="0" cellpadding="0" width="755" class="lan">
	          
 			  <s:iterator value="orderList" status="st" id = "order">
	            <tr>
	              <td colspan="4" <s:if test='orderstatus == "7" || orderstatus == "5" || orderstatus == "1" || orderstatus == "6"'> class="huibj"</s:if> <s:else> class="lanbj"</s:else>><span class="dsj_1">
	              <input name="" type="checkbox" value="" />
	                订单编号：${ordersn}</span><span class="dsj_2">下单时间：<fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
	            </tr>
	            <tr>
	              <td>
	                  <table border="0" cellspacing="0" width="445" cellpadding="0" class="ss">
	                      <s:iterator value="orderitems" status="st" id = "item">
	                      <tr>
	                        <td class="k1"><ul>
	                            <li class="ttu"><a target="_blank" href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1"><img src="${ goods.photospath}" onerror="this.src='userspacefile/default/albumcover.gif'" /></a></li>
	                            <li class="zzi"><a target="_blank" href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1">${goods.goodsname }</a></li>
	                          </ul></td>
	                        <td class="k2">${goods.productprice }</td>
	                        <td class="k2">${goodsnum}</td>
	                      </tr>
	                      </s:iterator>
	                    </table>
	                </td>
	              <td class="k3"><b>${totalamount }</b></td>
	              <td class="k3">
	              <span>
	              <s:if test="orderstatus == 1">
	                交易成功<br/>
		              <s:if test='israt == "0" || israt == "" || israt == null'>未评论</s:if>
		              <s:elseif test='israt == "1"'>已评论</s:elseif>
	              </s:if>
	              <s:elseif test="orderstatus == 2">等待付款</s:elseif>
	              <s:elseif test="orderstatus == 4 || orderstatus == 3">已付款<br />等待收取</s:elseif>
	              <s:elseif test="orderstatus == 5">已取消</s:elseif>
	              <s:elseif test="orderstatus == 6">退款中</s:elseif>
	              <s:elseif test="orderstatus == 7">已退款</s:elseif>
	              </span>
	              </td>
	              
	              <!-- 交易成功 -->
	              <s:if test="orderstatus == 1">
	              <td class="k3">
	              	<s:if test='israt == "0" || israt == "" || israt == null'>
	              	<a href="myspace/comm/orderRatGo.action?orderid=${orderid }">给商品评论</a><br />
	              	</s:if>
	                
                	<a href="myspace/comm/orderDetail.action?orderid=${orderid }">详情</a><br />
                  </td>
	              </s:if>
	              <!-- 等待付款 -->
	              <s:elseif test="orderstatus == 2">
	              <td class="k3">
		              <a href="#"><img src="img/user_img/fu.gif"/></a><br />
	                  <a href="myspace/comm/orderCancel.action?orderid=${orderid }">取消订单</a><br />
	                  <a href="myspace/comm/orderDetail.action?orderid=${orderid }">详情</a>
                  </td>
	              </s:elseif>
	              <!-- 已付款<br />等待收取 -->
	              <s:elseif test="orderstatus == 4 || orderstatus == 3">
	              <td class="k3">
	                <a href="myspace/comm/orderOK.action?orderid=${orderid }"><img src="img/user_img/qe.gif"/></a><br />
                	<a href="myspace/comm/orderDetail.action?orderid=${orderid }">详情</a>
                  </td>
	              </s:elseif>
	              <!-- 已取消 -->
	              <s:elseif test="orderstatus == 5">
	              <td class="k3">
                	<a href="myspace/comm/orderDetail.action?orderid=${orderid }">详情</a><br />
                  </td>
	              </s:elseif>
	              <!-- 退款中 -->
	              <s:elseif test="orderstatus == 6">
	               <td class="k3">
                	<a href="myspace/comm/orderDetail.action?orderid=${orderid }">详情</a><br />
                  </td>
	              </s:elseif>
	              <!-- 已退款 -->
	              <s:elseif test="orderstatus == 7">
	              <td class="k3">
                	<a href="myspace/comm/orderDetail.action?orderid=${orderid }">详情</a><br />
                  </td>
	              </s:elseif>
	              
	            </tr>
	          </s:iterator>  
	            
	          </table>
	        </div>
	        <div class="huise"><span>
	          <input name="" type="checkbox" value="" />
	          </span> <span>全选</span><span><a href="#"><img src="img/user_img/fu1.gif" width="66" height="23" /></a></span> <b>共：${totalOrderPrice }元</b>
	        </div>
	        
			<s:if test="result != null">
	        <form action="myspace/comm/orderList.action" id="formpage" method="post">
	        	<input type="hidden" name="orderstatuStr" value="${orderstatuStr }"/>
	        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="formpage"></t:tpage>
	        </form>
	        </s:if>
	        
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
