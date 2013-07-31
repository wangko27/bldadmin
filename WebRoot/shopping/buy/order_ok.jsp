<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />

		<title>订单确认</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/shopping/shopping_common.css" rel="stylesheet"
			type="text/css" />
		<link href="css/shopping/gwc.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript">			
			function orderOk(){
				if($("#goodssize").val()>0){
					return true;
				}else{
					alert("无商品清单，无法提交订单!");
					return false;
				}
			}
		</script>

	</head>

	<body>

		<jsp:include page="/shopping/top.jsp"></jsp:include>

		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> &gt;
				<a href="shopping/shoppingIndex_showIndex.action?t=">商城</a> &gt;
				<span>购买</span>
			</div>
		</div>

		<!-- 显示Action处理结果 -->
		<s:action name="order!showGoodsBill" executeResult="false">
		</s:action>


		<form action="shopping/buy/AddOrder.action" method="post" onsubmit="return orderOk();">
			<input type="hidden" name="goodssize" id="goodssize" value="<s:property value="#request.list_cart.size"/>"/>
		
			<input type="hidden" name="ordersn" id="ordersn" value="${ordersn }" />
			<input type="hidden" name="producttotalprice" id="producttotalprice" value="${totalprice }" />
			<input type="hidden" name="producttotalquantity" id="producttotalquantity" value="${totalquantity }" />
			
			<input type="hidden" name="shipname" id="shipname" value="${receiver.recusername }" />
			<input type="hidden" name="shiparea" id="shiparea" value="${receiver.areapath }" />
			<input type="hidden" name="shipaddress" id="shipaddress" value="${receiver.receiveraddress }" />
			<input type="hidden" name="shipzipcode" id="shipzipcode" value="${receiver.zipcode }" />
			<input type="hidden" name="shipphone" id="shipphone" value="${receiver.receiverphone }" />
			<input type="hidden" name="shipmobile" id="shipmobile" value="${receiver.receivermobile }" />
			
			<input type="hidden" name="goodsid" id="goodsid" value="${goodsid }" />
			<input type="hidden" name="buytype" id="buytype" value="${buytype }" />
			<input type="hidden" name="goodsnum" id="goodsnum" value="${goodsnum }" />
			<s:token></s:token>
			<div class="mainbody">
				<div class="buz_1"></div>
				<div class="ddu">
					请确认以下信息，然后提交订单
				</div>
				<div class="ggy">
					<div class="yti">
						<p>
							<b>确认收货地址： </b>
						</p>
						<p>
							<input name="receiverid" id="receiverid" type="radio"
								value="${receiver.receiverid }" checked />
							${receiver.recusername } ，
							<s:if test="#request.receiver.receivermobile!=null">
							${receiver.receivermobile } ，
						</s:if>
							<s:if test="#request.receiver.receiverphone!=null">
							${receiver.receiverphone } ，
						</s:if>
							${receiver.areapath } ${receiver.receiveraddress }
						</p>
					</div>
				</div>

				<div class="ggy">
					<div class="yti">
						<p>
							<b>确认送货方式： </b>
						</p>
						<p>
							<input name="deliverytypename" id="deliverytypename" type="radio"
								value="${deliverytypename }" checked />
							${deliverytypename }

						</p>
					</div>
				</div>

				<div class="ggy">
					<div class="yti">
						<p>
							<b>确认付款方式： </b>
						</p>
						<p>
							<input name="paymentconfigname" id="paymentconfigname"
								type="radio" value="${paymentconfigname }" checked />
							${paymentconfigname }
						</p>
					</div>
				</div>
			</div>

			<div class="mainbody">
				<div class="tiop">
					<span>商品清单：</span>（商家：952116综合信息门户网）
				</div>
				<div class="tab">
					<table cellspacing="0" cellpadding="0" class="big">
						<tr>
							<td class="btd1">
								商品
							</td>
							<td class="btd2">
								商城价(元)
							</td>
							<td class="btd2">
								数量
							</td>
							<td class="btd2">
								实付金额(元)
							</td>
						</tr>
					</table>

					<s:iterator value="#request.list_cart" id="cart">
						<table cellspacing="0" cellpadding="0" class="lan">
							<tr class="trg">
								<td class="btd1">
									<ul>
										<li class="ttu">
											<a href="shopping/shpping_showGoods.action?goodsId=${cart.goods.goodsid }&t=1" target="_blank"><img src="${cart.goods.photospath }"
													width="65" height="65" /> </a>
										</li>
										<li class="zzi">
											<a href="shopping/shpping_showGoods.action?goodsId=${cart.goods.goodsid }&t=1" target="_blank">${cart.goods.goodsname }</a>
										</li>
									</ul>
								</td>
								<td class="btd2">
									${cart.goods.productprice }
									<br />
									优惠了${cart.goods.marketprice-cart.goods.productprice }
								</td>
								<td class="btd2">
									${cart.quantity }
								</td>
								<td class="btd2">
									<b>${cart.quantity*cart.goods.productprice }</b>
								</td>
							</tr>
						</table>
					</s:iterator>
				</div>
				<div class="att">
					<p class="ff_3">
						<span>商品总价：￥${totalprice}</span>
						<br />
						<b>您需支付：<span>￥${totalprice}</span> </b>
					</p>

					<p class="ab_1">
						<input type="image" src="img/shopping_img/tid.gif" />
					</p>
				</div>
			</div>
		</form>

		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
