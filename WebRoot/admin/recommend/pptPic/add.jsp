<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
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
        首页推荐管理&mdash;&mdash;添加轮播图片
    </h1>
</div>
<input type="hidden" id="succes" value="${chonggong }">

<form action="<%=basePath%>admin/recommend/add.action" enctype="multipart/form-data" method="post">


    <s:token></s:token>
    <input type="hidden" id="succes" value="${chonggong }">
    <input type="hidden" id="path" value="<%=basePath %>">
    <table width="98%" border="0" cellpadding="0" cellspacing="1"
           align="center">
        <tr>
            <td height="26" background="skin/images/newlinebg3.gif">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">


                    <tr>
                        <td align="left" style="text-align: right">图片名称:</td>
                        <td>
                            <input name="picture.name" type="text"  size="30">
                        </td>
                        <td style="text-align: right">上传图片</td>
                        <td>
                            <input name="picture.path" type="file"  size="30">
                        </td>
                    </tr>

                    <tr>
                        <td align="left" style="text-align: right">图片链接地址:</td>
                        <td>
                            <input name="picture.name" type="text"  size="30" value="http://" >
                        </td>

                    </tr>

                    <tr>
                        <td colspan="4" align="center">
                            <input type="button" id="tjBut" value="保存" class="sst">
                            <input type="reset" name="czBut" value="重置" class="sst_1">
                        </td>

                    </tr>
                </table>
            </td>
        </tr>
    </table>


</form>
<jsp:include page="/comm/message.jsp"></jsp:include>
</body>
</html>
