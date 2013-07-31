<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>商品清单</title>

	</head>

	<body>
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

				<!-- 显示Action处理结果 -->
				<s:action name="order!showGoodsBill" executeResult="false">
				</s:action>

				<s:iterator value="#request.list_cart" id="cart">
					<table cellspacing="0" cellpadding="0" class="lan">
						<tr class="trg">
							<td class="btd1">
								<ul>
									<li class="ttu">
										<a
											href="shopping/shpping_showGoods.action?goodsId=${cart.goods.goodsid }&t=1"
											target="_blank"><img src="${cart.goods.photospath }"
												width="65" height="65" /> </a>
									</li>
									<li class="zzi">
										<a
											href="shopping/shpping_showGoods.action?goodsId=${cart.goods.goodsid }&t=1"
											target="_blank">${cart.goods.goodsname }</a>
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
			</div>
		</div>
	</body>
</html>
