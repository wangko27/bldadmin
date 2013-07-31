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

		<title>成功提交订单</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/shopping/shopping_common.css" rel="stylesheet"
			type="text/css" />
		<link href="css/shopping/gwc.css" rel="stylesheet" type="text/css" />

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

		<div class="mainbody">
			<div class="buz_2"></div>
			<div class="ghp">
				<p class="po1" style="height: 40px">
					订单 ${ordersn } 已提交成功,您需要支付￥ ${producttotalprice }
					<br />
				</p>
				<p>
					<b>您选择的是${paymentconfigname }支付：<br /> 选择网上银行或者平台支付</b><span>（您需要一张已经开通网上银行的银行卡）</span>
				</p>
				<p class="po3">
					支持以下银行：
					<img src="img/shopping_img/st.gif" />
				</p>
				<p>
					<a href="#"><img src="img/shopping_img/lizhi.gif" /> </a>
				</p>
			</div>
		</div>

		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
