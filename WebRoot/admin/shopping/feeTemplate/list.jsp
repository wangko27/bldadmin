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

    <title>商品频道管理</title>

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
        商品频道管理&mdash;&mdash;运费模板管理
    </h1>
</div>
<input type="hidden" id="succes" value="${chonggong }">
<table width="98%" border="0" cellpadding="2" cellspacing="1"
       bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
    <tr>
        <td >
                <span >
                <a href="<%=basePath%>admin/shopping/feeTemplate/add.jsp" style="color: red">添加运费模板</a>
                    </span>
        </td>
    </tr>
    <tr bgcolor="#E7E7E7">
        <td height="24" colspan="8" background="skin/images/tbg.gif">
            &nbsp;模板列表&nbsp;
        </td>
    </tr>
    <tr align="center" bgcolor="#e8f0f3" height="22">
        <td>模板名称</td>
        <td>省份</td>
        <td>价格优惠点</td>
        <td>首重量</td>
        <td>首价格</td>
        <td>超过重量</td>
        <td>超重价格</td>
        <td>创建时间</td>
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
            <c:forEach  items="${result.content}" var="fee">
                <tr align="center" bgcolor="#FFFFFF"
                    onMouseMove="javascript:this.bgColor='#e8f6ff';"
                    onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                    <td><u>${fee.templateName} </u></td>
                    <td><u> ${fee.province }</u></td>
                    <td><u>${fee.price}</u></td>
                    <td><u>${fee.firstWeight}&nbsp;${fee.firstWeightUnit}</u></td>
                    <td><u>${fee.firstPrice}</u></td>
                    <td><u>${fee.continueWeight}&nbsp;${fee.continueWeightUnit}</u></td>
                    <td><u>${fee.continuePrice}</u></td>
                    <td><u>${fee.createTime}</u></td>
                    <td>
                        <a href="<%=basePath%>admin/feeTemplate/findById.action?id=${fee.id}" >修改</a>&nbsp;
                        |&nbsp;
                        <a href="<%=basePath%>admin/feeTemplate/deleteById.action?id=${fee.id}" onClick="return(confirm('確定刪除?'))">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr bgcolor="#e8f6ff">
                <td class="nv" colspan="8">
                    <form id="form1" action="admin/feeTemplate/showAll.action"
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
