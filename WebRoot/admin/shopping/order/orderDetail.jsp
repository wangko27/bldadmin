<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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

    <title>订单详细页</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
    <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>


</head>
<body>
<div class="maindiv">
    <h1>
        订单管理&mdash;&mdash;订单详细
    </h1>
</div>
<form action="<%=basePath %>admin/shop/updateOrder.action" method="post" enctype="multipart/form-data"
      id="form_gAdd">
    <s:token></s:token>
    <input type="hidden" id="succes" value="${chonggong }">
    <table width="98%" border="0" cellpadding="0" cellspacing="1"
           align="center">
        <tr>
            <td height="26" background="skin/images/newlinebg3.gif">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <input id=orderid type="hidden" name="orders.orderid" value="${orders.orderid}">
                    <tr>
                        <td width="150" align="left" style="text-align: right">订单编号:
                        </td>
                        <td name="orders.ordersn">
                            ${orders.ordersn}
                        </td>
                        <td idth="150" align="left" style="text-align: right">创建时间</td>
                        <td>${orders.createdate}</td>

                    </tr>
                    <tr>

                        <td width="150" align="left" style="text-align: right">用户名:
                        </td>
                        <td>
                            <input id="memberid" name="orders.member.memberid" type="hidden" value="${orders.member.memberid}"/>
                            ${orders.member.username}
                        </td>
                        <td width="150" align="left" style="text-align: right">收货人:
                        </td>
                        <td ><input name="orders.shipname"value="${orders.shipname}"/></td>
                    </tr>
                    <tr>

                        <td width="150" align="left" style="text-align: right">收货地址:
                        </td>
                        <td>
                            <input id="shipaddress" name="orders.shipaddress" value="${orders.shipaddress}"/>
                        </td>
                        <td width="150" align="left" style="text-align: right">收货邮编:
                        </td>
                        <td>
                            <input id="shipzipcode" name="orders.shipzipcode" value="${orders.shipzipcode}"/>
                        </td>

                    </tr>
                    <tr>
                        <td width="150" align="left" style="text-align: right">固定电话:
                        </td>
                        <td>
                            <input id="shipphone" name="orders.shipphone" value="${orders.shipphone}"/>
                        </td>
                        <td width="150" align="left" style="text-align: right">手机号码:
                        </td>
                        <td>
                            <input id="shipmobile" name="orders.shipmobile" value="${orders.shipmobile}"/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="4">订单条目:</td>
                    </tr>

                    <%--订单条目开始--%>
                    <tr >
                        <td colspan="4">
                            <table   width="100%" border="1" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td>商品名称</td>
                                    <td>商品价格</td>
                                    <td>商品数量</td>
                                    <%--<td>条目价格</td>--%>
                                </tr>
                                <c:choose>
                                    <c:when test="${orders != null && orders.orderitems != null}" >
                                        <c:forEach var="orderItem" items="${orders.orderitems}">
                                            <tr align="center" bgcolor="#FFFFFF"
                                                onMouseMove="javascript:this.bgColor='#e8f6ff';"
                                                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                                                <input type="hidden" name="goods.goodsid" value="${orderItem.goods.goodsid}"/>
                                                <td >${orderItem.goods.goodsname}</td>
                                                <td>${orderItem.goods.productprice}</td>
                                                <td>${orderItem.goodsnum}</td>
                                                <%--<td>${orderItem.orderitemprice}</td>--%>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="4">没有要显示的内容！</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>


                            </table>
                        </td>

                    <%--订单条目结束--%>
                    </tr>



                    <tr>
                        <td align="left" valign="top" style="text-align: right">订单备注:</td>
                        <td colspan="3">
                            <textarea name="orders.ordermemo" id="orderMemo" cols="80" rows="5">${orders.ordermemo}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" align="center">
                            <input type="submit" id="tjBut" value="保存" class="sst">
                            <input type="reset" name="czBut" value="重置" class="sst_1">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
