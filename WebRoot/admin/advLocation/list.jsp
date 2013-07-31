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

    <title>广告频道管理</title>

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
        广告频道管理&mdash;&mdash;广告位置管理
    </h1>
</div>
<input type="hidden" value="<%=basePath %>" id="path">
<input type="hidden" id="isSucc" value="${isSucc }">
<table width="98%" border="0" cellpadding="2" cellspacing="1"
       bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
    <%--<tr>--%>
        <%--<td colspan="8" bgcolor="#e8f0f3">--%>
            <%--搜索--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td colspan="8" bgcolor="#FFFFFF" align="center">--%>
            <%--<form action="admin/adv/select_" method="post">--%>
                <%--<table border="0">--%>
                    <%--<tr>--%>
                        <%--<td nowrap="nowrap">广告位置：--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<select name="locationId" id="lAdd">--%>
                                <%--<option value=""> 　　　　全　部　　　　</option>--%>
                            <%--</select>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<input type="submit" value="搜索" class="sst" />--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</form>--%>
        <%--</td>--%>
    <%--</tr>--%>
        <tr>
            <td >
                <a style="color: red;" href="admin/advLocation/add.jsp">添加</a>
            </td>
        </tr>
    <tr bgcolor="#E7E7E7">
        <td height="24" colspan="8" background="skin/images/tbg.gif">
            &nbsp;广告列表&nbsp;
        </td>

    </tr>
    <tr align="center" bgcolor="#e8f0f3" height="22">
        <td>序号</td>
        <td>广告位置</td>
        <td>位置代码</td>
        <td>位置尺寸</td>
        <td>可投放广告数量</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <c:choose>
        <c:when test="${! empty result.content }">
            <c:forEach var="locationInfo" items="${result.content}" varStatus="status">
            <tr align="center" bgcolor="#FFFFFF"
                onMouseMove="javascript:this.bgColor='#e8f6ff';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';"height="22">
                    <td>
                        <u>${status.count}</u>
                    </td>

                <td>
                        <u>${locationInfo.locationintro}</u>
                    </td>
                    <td>
                        <u>${locationInfo.locationname}</u>
                    </td>
                    <td>
                        <u>${locationInfo.locationSize}</u>
                    </td>
                    <td>
                        <u>${locationInfo.num}</u>
                    </td>
                    <td>
                        <u>${locationInfo.createdate}</u>
                    </td>

                <td>
                    <a href="admin/advLocation/find_ById.action?advLocationId=${locationInfo.locationid}">修改</a>
                    &nbsp;|&nbsp;
                    <a href="admin/advLocation/delete_ById.action?advLocationId=${locationInfo.locationid}" onClick="return(confirm('確定刪除?'))">删除</a>
                </td>
            </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4" style="text-align: center; font-size: 24px;">没有要显示的结果!</td>
            </tr>
        </c:otherwise>
    </c:choose>
        <tr bgcolor="#e8f6ff">
            <td class="nv" colspan="8">
                <form id="form1" action="admin/advLocation/showAllAdvLocation.action"
                      method="post">
                    <t:tpage formId="form1" pageDiv="page" page="${result.page}"
                             goImg="img/learning_img/gog.gif"></t:tpage>
                </form>
            </td>
        </tr>

</table>
<jsp:include page="/comm/message.jsp"></jsp:include>
</body>
</html>
