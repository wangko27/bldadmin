<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <title>推荐管理</title>

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
        推荐管理&mdash;&mdash;热销商品列表
    </h1>
</div>
<input type="hidden" id="succes" value="${chonggong }">
<table width="98%" border="0" cellpadding="2" cellspacing="1"
       bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
    <tr>
        <td colspan="8" bgcolor="#e8f0f3">
            搜索
        </td>
    </tr>
    <tr>
        <td colspan="8" bgcolor="#FFFFFF" align="center">
            <form action="admin/shop/goods_show.action" method="post">
                <table border="0">
                    <tr>
                        <td>
                            商品名称：
                        </td>
                        <td>
                            <input type="text" name="goodsKey" id="goodsKey" />
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
        <td height="24" colspan="8" background="skin/images/tbg.gif">
            &nbsp;热销商品列表&nbsp;
        </td>
    </tr>
    <tr align="center" bgcolor="#e8f0f3" height="22">
        <td>
            商品名称
        </td>
        <td>商品类别名称</td>
        <td>
            是否上架</td>
        <td>库存/占用数量</td>
        <td>市场/商品(价格)</td>
        <td>
            创建时间
        </td>
        <td>
         是否热销
        </td>
        <td>
            操作
        </td>
    </tr>
    <c:choose>
        <c:when test="${empty result.content}">
            <tr>
                <td colspan="8" style="text-align: center; font-size: 24px;">没有要显示的结果!</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach  items="${result.content}" var="goods">
                <tr align="center" bgcolor="#FFFFFF"
                    onMouseMove="javascript:this.bgColor='#e8f6ff';"
                    onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

                    <td>
                        <u>
                                <%--<c:if test="${fn:length(goods.goodsnmae) > 30}">--%>
                                <%--${fn:length(goods.goodsname) >= 30 ? fn:substring(goods.goodsname,0,29)+".." : goods.goodsname}--%>
                                <%--</c:if>--%>
                                ${goods.goodsname}

                        </u>
                    </td>
                    <td>
                        <u>${goods.goodesCategory.categoryname} </u>
                    </td>
                    <td>
                        <u> ${goods.isadded == '0' ?'否':'是' }</u>
                    </td>
                    <td><u>${goods.stocknum }/${goods.occupiedstock }</u></td>
                    <td>
                        <u>${goods.marketprice }/${goods.productprice } </u>
                    </td>
                    <td>
                        <U> <fmt:formatDate value="${goods.createdate }" pattern="yyyy-MM-dd"/>
                        </U>
                    </td>
                    <td>
                        <u>${goods.ishot == '0' ? '否' : '是'}</u>
                    </td>
                    <td>

                        <a href="admin/shop/goods_show!showGoods.action?goodsKey=${goods.goodsid }" >修改</a>&nbsp;
                        |&nbsp;
                        <a href="admin/shop/goods_show!deleteGoods.action?goodsKey=${goods.goodsid }"
                           onClick="return(confirm('確定刪除?'))">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr bgcolor="#e8f6ff">
                <td class="nv" colspan="8">
                    <form id="form1" action="admin/recommend/showHotGoods.action"
                          method="post">

                        <t:tpage formId="form1" pageDiv="page" page="${result.page}"
                                 goImg="img/learning_img/gog.gif"></t:tpage>
                    </form>
                </td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
<jsp:include page="/comm/message.jsp"></jsp:include>
</body>
</html>
