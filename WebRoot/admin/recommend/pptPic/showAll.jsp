<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
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

    <title>首页推荐管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
    <script language="javascript" >
        $(document).ready(function(){
            if($('#succes').val()!=''){
                alert($('#succes').val());
            }

        });
    </script>
</head>

<body>
<div class="maindiv">
    <h1>
        首页推荐管理&mdash;&mdash;轮播图片管理
    </h1>
</div>
<input type="hidden" id="succes" value="${chonggong }">
<a href="admin/recommend/pptPic/add.jsp" style="margin-left: 10px" >添加</a>
<table width="98%" border="0" cellpadding="2" cellspacing="1"  bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
    <%--<tr>--%>
        <%--<td colspan="8" bgcolor="#e8f0f3">--%>
            <%--搜索--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td colspan="8" bgcolor="#FFFFFF" align="center">--%>
            <%--<form action="admin/shop/goods_show.action" method="post">--%>
                <%--<table border="0">--%>
                    <%--<tr>--%>
                        <%--<td>--%>
                            <%--商品名称：--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<input type="text" name="goodsKey" id="goodsKey" />--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<input type="submit" value="搜索" class="sst" />--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</form>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <tr bgcolor="#E7E7E7">
        <td height="24" colspan="8" background="skin/images/tbg.gif">
            &nbsp;图片列表&nbsp;
        </td>
    </tr>
    <tr align="center" bgcolor="#e8f0f3" height="22">
        <td>
            图片名称
        </td>
        <td>商品类别名称</td>
        <td>图片大小</td>
        <td>图片链接地址</td>
        <td>
            创建时间
        </td>
        <td>
            修改时间
        </td>
        <td>
            操作
        </td>
    </tr>
    <%--<c:choose>--%>
        <%--<c:when test="${empty result.content}">--%>
            <%--<tr>--%>
                <%--<td colspan="8" style="text-align: center; font-size: 24px;">没有要显示的结果!</td>--%>
            <%--</tr>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<c:forEach  items="${result.content}" var="goods">--%>
                <%--<tr align="center" bgcolor="#FFFFFF"--%>
                    <%--onMouseMove="javascript:this.bgColor='#e8f6ff';"--%>
                    <%--onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">--%>
                    <%--<td>--%>
                        <%--<u>${goods.goodsname }</u>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<u>${goods.goodesCategory.categoryname} </u>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<u> ${goods.isadded == '0' ?'否':'是' }</u>--%>
                    <%--</td>--%>
                    <%--<td><u>${goods.stocknum }/${goods.occupiedstock }</u></td>--%>
                    <%--<td>--%>
                        <%--<u>${goods.marketprice }/${goods.productprice } </u>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<U> <fmt:formatDate value="${goods.createdate }" pattern="yyyy-MM-dd"/>--%>
                        <%--</U>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<U> <fmt:formatDate value="${goods.modifydate }" pattern="yyyy-MM-dd"/>--%>
                        <%--</U>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<a--%>
                                <%--href="admin/shop/goods_show!showGoods.action?goodsKey=${goods.goodsid }" >修改</a>&nbsp;--%>
                        <%--|&nbsp;--%>
                        <%--<a href="admin/shop/goods_show!deleteGoods.action?goodsKey=${goods.goodsid }"--%>
                           <%--onClick="return(confirm('確定刪除?'))">删除</a>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--<tr bgcolor="#e8f6ff">--%>
                <%--<td class="nv" colspan="8">--%>
                    <%--<form id="form1" action="admin/shop/goods_show.action"--%>
                          <%--method="post">--%>

                        <%--<t:tpage formId="form1" pageDiv="page" page="${result.page}"--%>
                                 <%--goImg="img/learning_img/gog.gif"></t:tpage>--%>
                    <%--</form>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>
</table>
<jsp:include page="/comm/message.jsp"></jsp:include>
</body>
</html>
