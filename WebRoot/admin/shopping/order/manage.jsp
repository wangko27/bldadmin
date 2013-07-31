<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
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

		<title>订单管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="admin/interest/js/activitytype.js"></script>

	</head>

	<body>
		<div class="maindiv">
			<h1>
				商城频道管理&mdash;&mdash;订单管理
			</h1>
		</div>

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr>
				<td colspan="7" bgcolor="#e8f0f3">
					搜索
				</td>
			</tr>
			<tr>
				<td colspan="7" bgcolor="#FFFFFF" align="center">
					<form action="admin/shop/order!manage.action" method="post"
						name="form_order" id="form_order">
						<table>
							<tr>
								<td>
									订单号：
								</td>
								<td>
									<input type="text" name="ordersn" id="ordersn"
										value="${param.ordersn }" />
								</td>
								<td>
									订单状态：
								</td>
								<td>
									<select name="status" id="status">
										<option value="">
											所有订单
										</option>
										<option value="1"
											<c:if test="${param.status==1 }">selected</c:if>>
											交易成功
										</option>
										<option value="2"
											<c:if test="${param.status==2 }">selected</c:if>>
											未付款
										</option>
										<option value="3"
											<c:if test="${param.status==3 }">selected</c:if>>
											已付款 未发货
										</option>
										<option value="4"
											<c:if test="${param.status==4 }">selected</c:if>>
											已付款 已发货
										</option>
										<option value="5"
											<c:if test="${param.status==5 }">selected</c:if>>
											已取消
										</option>
										<option value="6"
											<c:if test="${param.status==6 }">selected</c:if>>
											退款中
										</option>
										<option value="7"
											<c:if test="${param.status==7 }">selected</c:if>>
											已退款
										</option>
									</select>
								</td>
								<td>
									<input type="submit" value="搜索" class="sst" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="7" background="skin/images/tbg.gif">
					&nbsp;文档列表&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td>
					订单号
				</td>
				<td>
					订单状态
				</td>
                <%--<td>--%>
                    <%--发货状态--%>
                <%--</td>--%>
				<td>
					配送方式
				</td>
				<td>
					支付方式
				</td>
				<td>
					创建时间
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="#request.list_order" id="order">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u><a href="<%=basePath%>admin/shop/findOrderById.action?id=${order.orderid}">${order.ordersn }</a></u>
					</td>
					<td>
						<u> <s:if test="#order.orderstatus==1">交易成功</s:if> <s:elseif
								test="#order.orderstatus==2">未付款</s:elseif> <s:elseif
								test="#order.orderstatus==3">已付款 等待发货
							</s:elseif> <s:elseif test="#order.orderstatus==4">已付款 已发货
							</s:elseif> <s:elseif test="#order.orderstatus==5">已取消</s:elseif> <s:elseif
								test="#order.orderstatus==6">退款中</s:elseif> <s:elseif
								test="#order.orderstatus==7">已退款</s:elseif> </u>
					</td>
                    <%--<td>--%>
                        <%--<u>--%>
                            <%--<s:if test="#order.shippingstatus == 0">未发货</s:if>--%>
                            <%--<s:elseif test="#order.shippingstatus == 1">已发货</s:elseif>--%>
                        <%--</u>--%>
                    <%--</td>--%>
					<td>
						<u>${order.deliverytypename }</u>
					</td>
					<td>
						<u>${order.paymentconfigname }</u>
					</td>
					<td>
						<u>${order.createdate}</u>
					</td>
					<td>
                        <%--订单状态:1交易成功 2等待付款 3已付款 未发货 4已付款 已发货 5已取消 6退款中 7已退款--%>
                            <%--<a href="admin/shop/order!updateOrderStatus.action?orderid=${order.orderid }">修改状态</a>--%>
                            <%--|&nbsp;--%>
						<s:if test="#order.orderstatus==3">
							<a href="admin/shop/order!shipments.action?orderid=${order.orderid }">发货</a>
						|&nbsp;
						</s:if>
						<s:if test="#order.orderstatus==3 || #order.orderstatus==4">
							<a href="admin/shop/order!refund.action?orderid=${order.orderid }">退款</a>
						</s:if>
					</td>
				</tr>
				<tr>
					<td class="nv" colspan="7" align="right">
						&nbsp;
					</td>
				</tr>
			</s:iterator>

			<tr bgcolor="#e8f6ff">
				<td class="nv" colspan="7">
					<t:tpage formId="form_order" pageDiv="page" page="${result.page}"
						goImg="img/learning_img/gog.gif"></t:tpage>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
