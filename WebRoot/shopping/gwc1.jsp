<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/shopping/shopping_common.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/shopping/gwc.css" rel="stylesheet"
			type="text/css" />
		<script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
		<script language="javascript"
			src="<%=basePath%>shopping/js/shanglist.js"></script>
		<script language="javascript"
			src="<%=basePath%>shopping/js/shangmaid.js"></script>
		<script language="javascript"
			src="<%=basePath%>shopping/js/gwc1.js"></script>

		<script type="text/javascript">
			//结算
			function balance(){
				if($("input[name='goodsids']:checked").length==0){
					alert("请至少选择一件商品!");
				}else{
					var goodsid="";
					$("input[name='goodsids']:checked").each(function(index){
						goodsid+=$(this).val();
						if(index<($("input[name='goodsids']:checked").length-1)){
							goodsid+=",";
						}
					});
					$("#goodsid").val(goodsid);
					$("#form_GoodsBuy").submit();
				}
				return false;
			}
			
		</script>
	</head>
	<body>

		<jsp:include page="top.jsp"></jsp:include>


		<form action="shopping/buy/order!showReceiver.action" method="post"
			name="form_GoodsBuy" id="form_GoodsBuy">
			<input type="hidden" name="goodsid" id="goodsid" />
			<input type="hidden" name="buytype" id="buytype" value="2" />
		</form>

		<input type="hidden" id="path" value="<%=basePath%>" />
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="shopping/shoppingIndex_showIndex.action?t=">商城</a> >
				<span>购买</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="buz"></div>
			<div class="yyt">
				<p class="ys">
					购物车里一共有${conut }件商品
				</p>
				<p class="ff">
					商品总价：
					<span id="to1">${priceTotal }</span>元
				</p>
				<p class="ab">
					<a href="#" onclick="return balance()"><img
							src="<%=basePath%>img/shopping_img/jie.gif" /> </a>
				</p>
			</div>
			<div class="tab">
			<form action="<%=basePath%>shopping/shoppingCart_remvoeAllCart.action" id="form_del" method="post">
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
						<td class="btd2">
							操作
						</td>
					</tr>
				</table>
				<c:choose>
					<c:when test="${empty cartsInfo}">
						<center>无商品</center>
					</c:when>
					<c:otherwise>
						<c:forEach items="${cartsInfo}" var="cinfo">
							<table cellspacing="0" cellpadding="0" class="lan">
								<tr>
									<td colspan="5" class="lanbj">
										<input name="goodsids"  alt="${cinfo.goods.productprice*cinfo.quantity}" 
										id="goodsids" type="checkbox" value="${cinfo.goods.goodsid }" checked="checked" />
										${cinfo.goods.goodsid }
									</td>
								</tr>
								<tr class="trg">
									<td class="btd1">
										<ul>
											<li class="ttu">
												<a
													href="shopping/shpping_showGoods.action?goodsId=${cinfo.goods.goodsid }"><img
														src="<%=basePath%>${cinfo.goods.photospath }" /> </a>
											</li>
											<li class="zzi">
												<a
													href="shopping/shpping_showGoods.action?goodsId=${cinfo.goods.goodsid }">${cinfo.goods.goodsname
													}</a>
											</li>
										</ul>
									</td>
									<td class="btd2">
										${cinfo.goods.productprice }.00
										<br />
										优惠了${cinfo.goods.marketprice-cinfo.goods.productprice}.00 元
									</td>
									<td class="btd2">
										<ul class="shxia">
											<li class="dla">
												<input id="${cinfo.goods.goodsid }"
													onkeyup="changGoodsNum('${cinfo.goods.goodsid }')"
													type="text" class="band" value="${cinfo.quantity }"  />
											</li>
											<li class="dlt">
												<a href="#" onclick="return false"> <img id="p${cinfo.goods.goodsid }"
														onclick="addGoodsNum('${cinfo.goods.goodsid }')"
														src="<%=basePath%>img/shopping_img/sh.gif" /> </a>
											</li>
											<li class="dlt">
												<a href="#" onclick="return false"> <img id="d${cinfo.goods.goodsid }"
														onclick="lessenGoodsNum('${cinfo.goods.goodsid }')"
														src="<%=basePath%>img/shopping_img/xia.gif" /> </a>
											</li>
										</ul>
									</td>
									<td class="btd2">
										<b id="k${cinfo.goods.goodsid }">${cinfo.goods.productprice*cinfo.quantity
											}</b>
									</td>
									<td class="btd2">
										<a
											href="shopping/shoppingCart_deleteCart.action?goodsId=${cinfo.goods.goodsid }"
											onclick="return confirm('你确定要移出吗?');">移出</a>
									</td>
								</tr>
							</table>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</form>
			</div>
			<div class="att">
				<p class="ff_1">
					<a href="#" onclick="return false"><img id="delSel"
							src="<%=basePath%>img/shopping_img/ppt.gif" /> </a>
				</p>
				<p class="ff_2">
					商品总价：
					<span id="to2">${priceTotal }</span>元
				</p>
				<p class="ab_1">
					<a href="#" onclick="return balance();"><img
							src="<%=basePath%>img/shopping_img/jie1.gif" /> </a>
				</p>
			</div>
		</div>


		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
