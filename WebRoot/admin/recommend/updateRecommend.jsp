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

    <title>商品推荐</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
    <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/common.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js" defer="defer"></script>
    <script type="text/javascript">
        $(function(){
            $('#tjBut').click(function(){
                var goodsname=$("#goodsname").val();
                var recommendArea =$("select option:selected").val() ;
                if(goodsname==''){
                    alert("商品名称不能为空!");
                    return;
                }
                if(recommendArea == 0 || recommendArea == "0" || typeof recommendArea =='undefined' || recommendArea == null){
                    alert("推荐区域不能为空!");
                    return;
                }
                $("#form_advLocation").submit();
            });

            //加载页面时，自动获取所有的可以推荐的区域
            $.ajax({
                url:$('#path').val()+'admin/advLocation/ajaxFindAll.action',
                success:function(data){
//                    alert("data.length="+data.length+",data="+data+",data.type="+typeof data);
                    var locationArray = eval(data);
//                    alert("locationArray.length="+locationArray.length);
                    if(locationArray.length==0){
                        return ;
                    }
                    for(i=0;i<locationArray.length;i++){
                        var op='<option value="'+locationArray[i].id+'">'+locationArray[i].locIntro+'</option>';
                        $('#recommendArea').append(op);
                    }
                }
            });
        });

    </script>
</head>
<body>

<div class="maindiv">
    <h1>
        商品推荐管理&mdash;&mdash;修改商品推荐</h1>
</div>
<input type="hidden" value="<%=basePath %>" id="path">
<form action="<%=basePath %>admin/recommend/update.action" method="post" id="form_advLocation">
    <table width="98%" border="0" cellpadding="0" cellspacing="1"
           align="center">
        <input type="hidden" id="isSucc" value="${isSucc }">
        <tr>
            <td height="26" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <input type="hidden" name="goodsRecommend.goods.goodsid" value="${goodsRecommend != null ? goodsRecommend.goods.goodsid : goods.goodsid}">
                    <input type="hidden" name="goodsRecommend.admin.adminid" value="${goodsRecommend != null ? goodsRecommend.admin.adminid : admin.adminid}">
                    <tr>
                        <td align="left" width="150">商品类别:
                        </td>
                        <td>
                            <input id="categoryname" name="goods.goodesCategory.categoryname"
                                   value="${goodsRecommend != null ? goodsRecommend.goods.goodesCategory.categoryname :goods.goodesCategory.categoryname}"
                                   type="text" size="50" readonly="true">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" width="150">商品名:
                        </td>
                        <td>
                            <input id="goodsname" name="goodsRecommend.goods.goodsname" value="${goodsRecommend != null ? goodsRecommend.goods.goodsname : goods.goodsname}"
                                   type="text" size="50">
                        </td>
                    </tr>
                    <tr>
                        <td align="left">上架时间:</td>
                        <td>
                            <input id="createdate" name="createdate" value="${goodsRecommend != null ? goodsRecommend.goods.createdate : goods.createdate}"
                                   type="text" size="50" readonly="true">
                        </td>
                    </tr>
                    <tr>
                        <td align="left">推荐人:</td>
                        <td>
                            <input id="recommend" name="goodsRecommend.lastModifyUser.username"  type="text" size="50"
                                   value="${sessionScope.admin.username}" readonly="true">
                        </td>
                    </tr>
                    <tr>
                        <td align="left">推荐区域:</td>
                        <td>
                            <select id="recommendArea" name="locationId" >
                                <option value="0">————请选择推荐区域————</option>
                            </select>
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
