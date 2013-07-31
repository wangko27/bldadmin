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

    <title>商品秒杀列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
</head>

<body>
<div class="maindiv">
    <h1>
        推荐管理&mdash;&mdash;商品秒杀管理
    </h1>
</div>
<input type="hidden" value="<%=basePath %>" id="path">
<input type="hidden" id="isSucc" value="${isSucc }">
<table width="98%" border="0" cellpadding="2" cellspacing="1"
       bgcolor="#afd3e9" align="center" style="margin-top: 8px;">

    <tr bgcolor="#E7E7E7">
        <td height="24" colspan="8" background="skin/images/tbg.gif">
            &nbsp;商品秒杀列表&nbsp;
        </td>

    </tr>
    <tr align="center" bgcolor="#e8f0f3" height="22">
        <td>序号</td>
        <td>商品类别</td>
        <td>商品名称</td>
        <td>开始时间</td>
        <td>结束时间</td>
        <td>状态</td>
        <td>库存数量</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <c:choose>
        <c:when test="${ !empty result.content }">
        <c:forEach var="miaosha" items="${result.content}" varStatus="status">
            <tr align="center" bgcolor="#FFFFFF"
                onMouseMove="javascript:this.bgColor='#e8f6ff';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';"
                height="22">
                <input type="hidden" id="goodsId" value="${miaosha.goods.goodsid}">
                <td><u>${status.count}</u></td>
                <td><u>${miaosha.goods.goodesCategory.categoryname}</u></td>
                <td><u>${miaosha.goods.goodsname}</u></td>
                <%--<td><u><img src="${miaosha.goods.photospath}" width="100" height="80"></u></td>--%>
                <td><u>${miaosha.beginDate}</u></td>
                <td><u>${miaosha.endDate}</u></td>
                <td>
                    <u>
                        <c:if test="${miaosha.state == 0}">
                            未秒杀
                        </c:if>
                        <c:if test="${miaosha.state == 1}">
                            正在秒杀
                        </c:if>
                        <c:if test="${miaosha.state == 2}">
                            已秒杀
                        </c:if>
                        <c:if test="${miaosha.state == 3}">
                            即将开始秒杀
                        </c:if>
                    </u>
                </td>
                <td><u>${miaosha.goods.stocknum}</u></td>
                <td><u>${miaosha.createDate}</u></td>

                <td>
                    <%--<a href="<%=basePath%>admin/miaosha/find_byId.action?miaoShaId=${miaosha.miaoShaId}" >修改</a>--%>
                    <%--&nbsp;|&nbsp;--%>
                    <a href="<%=basePath%>admin/miaosha/delete_byId.action?miaoShaId=${miaosha.miaoShaId}"
                       onClick="return(confirm('確定刪除?'))" style="color: red;">删除</a>
                </td>
            </tr>
    </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="7" style="text-align: center; font-size: 24px;">没有要显示的结果!</td>
            </tr>
        </c:otherwise>
    </c:choose>

    <tr bgcolor="#e8f6ff">
        <td class="nv" colspan="8">
            <form id="form1" action="admin/miaosha/showMiaoShaGoods.action"
                  method="post">
                <t:tpage formId="form1" pageDiv="page" page="${result.page}"
                         goImg="img/learning_img/gog.gif"></t:tpage>
            </form>
        </td>
    </tr>

    <%--</table>--%>
    <jsp:include page="/comm/message.jsp"></jsp:include>
</body>
</html>
