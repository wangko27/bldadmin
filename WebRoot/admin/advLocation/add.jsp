<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>广告位置添加</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
    <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/common.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js" defer="defer"></script>
    <script language="javascript" src="<%=basePath %>admin/advLocation/js/add.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            if($('#isSucc').val()!=''){
                alert($('#isSucc').val());
            }
        });
        $(function(){
            $('#tjBut').click(function(){
                var locationintro=$("#locationintro").val();
                var locationname=$("#locationname").val();
                var size = $("#size").val();
                var number = $("#number").val();
                if(locationintro==''){
                    alert("广告位置名称不能为空!");
                    return;
                }
                if(locationname==''){
                    alert("广告位置代码不能为空!");
                    return;
                }
                if(size==''){
                    alert("广告位置尺寸不能为空!");
                    return;
                }
                if(isNaN(number)){
                   alert("填写的广告数量不是数字!");
                    return;
                }

                $("#form_advLocation").submit();
            });
        });

    </script>
</head>
<body>

<div class="maindiv">
    <h1>
        广告频道管理&mdash;&mdash;添加广告位置</h1>
</div>
<input type="hidden" value="<%=basePath %>" id="path">
<form action="<%=basePath %>admin/advLocation/add_ById.action" method="post" id="form_advLocation">
    <table width="98%" border="0" cellpadding="0" cellspacing="1"
           align="center">
        <input type="hidden" id="isSucc" value="${isSucc }">
        <tr>
            <td height="26" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="left" width="150">广告所在的位置:
                        </td>
                        <td>
                            <input id="locationintro" name="locationInfo.locationintro"  type="text" size="30">
                        </td>
                    </tr>
                    <tr>
                        <td align="left">广告位置代码:</td>
                        <td>
                            <input id="locationname" name="locationInfo.locationname"  type="text" size="30">
                        </td>
                    </tr>
                    <tr>
                        <td align="left">广告位置尺寸:</td>
                        <td>
                            <input id="size" name="locationInfo.locationSize"  type="text" size="30">
                            <span>如长宽大小为:300X300</span>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">可投放广告数量:</td>
                        <td>
                            <input id="number" name="locationInfo.num"  type="text" size="30">
                            <span> 若不写默认数量为1</span>
                        </td>

                    </tr>

                    <tr>
                        <td colspan="2" align="center">
                            <input type="button" id="tjBut" value="保存" class="sst">
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
