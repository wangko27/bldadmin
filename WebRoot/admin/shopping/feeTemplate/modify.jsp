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

    <title>修改运费模板</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
    <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>admin/interest/js/activitytype.js"></script>
    <script type="text/javascript">
        $(function(){

            //表单提交
            $('#tjBut').click(function(){
                var selProvince=$("#selProvince").val();
                if(selProvince === '' || selProvince == null){
                    alert("请选择省份!");
                    return ;
                }
                var templateName=$("#templateName").val();
                if(templateName === '' || templateName == null){
                    alert("模板名称不能为空!");
                    return ;
                }
                var firstPrice=$("#firstPrice").val();
                if(firstPrice=='' || isNaN(firstPrice) || parseFloat(firstPrice) <= 0){
                    alert("首价格不能为空,只能是数字,并且大于0!");
                    return ;
                }
                var firstWeight=$("#firstWeight").val();
                if(firstWeight=='' || isNaN(firstWeight) || parseFloat(firstWeight) <= 0){
                    alert("首重量不能为空,只能是数字,并且大于0!");
                    return ;
                }
                var price=$("#price").val();
                if(price=='' || isNaN(price) || parseFloat(price)<= 0){
                    alert("优惠价格不能为空,只能是数字,并且大于0!");
                    return ;
                }
                var continueWeight=$("#continueWeight").val();
                if(continueWeight=='' || isNaN(continueWeight) || parseFloat(continueWeight) <= 0){
                    alert("续重不能为空,只能是数字,并且大于0!");
                    return ;
                }
                var continuePrice=$("#continuePrice").val();
                if(continuePrice=='' || isNaN(continuePrice) || parseFloat(continuePrice) <= 0){
                    alert("续价格不能为空,只能是数字,并且大于0!");
                    return ;
                }



                $("#form_gAdd").submit();
            });



        });
    </script>


</head>
<body>
<div class="maindiv">
    <h1>
        商品频道管理&mdash;&mdash;修改运费模板
    </h1>
</div>
<form action="<%=basePath %>admin/feeTemplate/update.action" method="post" enctype="multipart/form-data"
      id="form_gAdd">
    <s:token></s:token>
    <input type="hidden" name="fee.id" value="${fee.id}">
    <input type="hidden" id="succes" value="${chonggong }">
    <input type="hidden" id="path" value="<%=basePath %>">
    <table width="98%" border="0" cellpadding="0" cellspacing="1"
           align="center">
        <tr>
            <td height="26" background="skin/images/newlinebg3.gif">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>省&nbsp;&nbsp;&nbsp;&nbsp;份:
                            <select name="fee.province" id="selProvince">
                                <option value="">请选择</option>
                                <option value="北京">北京</option>
                                <option value="天津">天津</option>
                                <option value="河北">河北</option>
                                <option value="山西">山西</option>
                                <option value="内蒙古">内蒙古</option>
                                <option value="辽宁">辽宁</option>
                                <option value="吉林">吉林</option>
                                <option value="黑龙江">黑龙江</option>
                                <option value="上海">上海</option>
                                <option value="江苏">江苏</option>
                                <option value="浙江">浙江</option>
                                <option value="安徽">安徽</option>
                                <option value="福建">福建</option>
                                <option value="江西">江西</option>
                                <option value="山东">山东</option>
                                <option value="河南">河南</option>
                                <option value="湖北">湖北</option>
                                <option value="湖南">湖南</option>
                                <option value="广东">广东</option>
                                <option value="广西">广西</option>
                                <option value="海南">海南</option>
                                <option value="重庆">重庆</option>
                                <option value="四川">四川</option>
                                <option value="贵州">贵州</option>
                                <option value="云南">云南</option>
                                <option value="西藏">西藏</option>
                                <option value="陕西">陕西</option>
                                <option value="甘肃">甘肃</option>
                                <option value="青海">青海</option>
                                <option value="宁夏">宁夏</option>
                                <option value="新疆">新疆</option>
                                <option value="香港">香港</option>
                                <option value="澳门">澳门</option>
                                <option value="台湾">台湾</option>
                                <option value="国外">国外</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>模板名称:<input name="fee.templateName" id="templateName" value="${fee.templateName}"/></td>
                    </tr>
                    <tr>
                        <%--<td>价&nbsp;格&nbsp;在:<input name="fee.firstPrice" id="firstPrice"/>元--%>
                        <%--至<input name="fee.continuePrice" id="continuePrice"/>元之间--%>
                        <%--</td>--%>
                        <td>
                            优惠价格:<input name="fee.price" id="price" value="${fee.price}"/>元
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%--重&nbsp;量&nbsp;在--%>
                            <%--<input name="fee.firstWeight"/>--%>
                            <%--<select name="fee.firstWeightUnit">--%>
                            <%--<option value="g" selected> 克</option>--%>
                            <%--<option value="kg">千克</option>--%>
                            <%--</select>--%>
                            <%--至--%>
                            <%--<input name="fee.continueWeight"/>--%>
                            <%--<select name="fee.continueWeightUnit">--%>
                            <%--<option value="g" selected> 克</option>--%>
                            <%--<option value="kg">千克</option>--%>
                            <%--</select>--%>
                            <%--之间--%>
                            首&nbsp;重&nbsp;量:<input name="fee.firstWeight" id="firstWeight" value="${fee.firstWeight}"/>
                            <select name="fee.firstWeightUnit">
                                <option value="g" selected> 克</option>
                                <option value="kg">千克</option>
                            </select>
                        </td>
                    </tr>

                    <tr id="priceTr">
                        <td>首&nbsp;运&nbsp;费:<input id="firstPrice" name="fee.firstPrice" value="${fee.firstPrice}"/>元</td>
                    </tr>
                    <tr>
                        <td>续重，则按照每<input name="fee.continueWeight" value="${fee.continueWeight}" id="continueWeight"/>
                            <select name="fee.continueWeightUnit" id="continueWeightUnit">
                                <option value="g" selected> 克</option>
                                <option value="kg">千克</option>
                            </select>
                            收取<input name="fee.continuePrice" value="${fee.continuePrice}" id="continuePrice"/>元的运送费用</td>
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
</body>
</html>
