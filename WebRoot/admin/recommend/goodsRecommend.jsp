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
//            alert($("#isMiaoSha").val());
            var value = $("input[type='radio']:checked").val()
//            alert("value="+value);
            if(value == 0){
                $("#miaoShaDate").hide(10);
                $("#miaoPrice").hide(10)
                $("#isHot").show(10);
            }else if(value == 1){
                $("#miaoShaDate").show(10);
                $("#miaoPrice").show(10)
                $("#isHot").hide(10);
            }

            //单选框按钮
            $("#miaoSha :radio").click(function(){
                var value =   $("input[name=ms]:checked").val()
//                alert("value="+value)
                if(value == 0){
                    $("#miaoShaDate").hide(10);
                    $("#miaoPrice").hide(10)
                    $("#isHot").show(10);
                }else if(value == 1){
                    $("#miaoShaDate").show(10);
                    $("#miaoPrice").show(10)
                    $("#isHot").hide(10);
                }
            });




            //表单提交按钮
            $('#tjBut').click(function(){
                var flag = false;
                var goodsname=$("#goodsname").val();
                var beginDate = $("#beginDate").val();
                var endDate = $("#endDate").val();
                var recommendArea =$("select option:selected").val() ;
                var miaoShaPriceSelect = $("#miaoShaPriceSelect").val();
//                alert("miaoShaPriceSelect ="+miaoShaPriceSelect +",type="+typeof miaoShaPriceSelect );
//                alert("beginDate="+beginDate+",type="+typeof beginDate);
                var value =   $("input[name=ms]:checked").val()

                if(value == 1){


                    if(beginDate == '' || beginDate == null || typeof beginDate == 'undefined'){
                        flag = false;
                        alert("秒杀开始日期不能为空!");
                        return;
                    }else{
                        flag = true;
                    }
                    if(endDate == '' || endDate == null || typeof endDate == 'undefined'){
                        flag = false;
                        alert("秒杀结束日期不能为空!");
                        return;
                    }else{
                        flag = true;
                    }
//                    alert(new Date());
//                    alert("1beginDate="+beginDate+",type="+typeof beginDate+".....endDate="+endDate+",type="+typeof endDate);
                    beginDate = beginDate.replace(/\-/g,"/");
//                    alert("替换- beginDate="+beginDate+",type="+typeof beginDate);
                    beginDate = new Date(Date.parse(beginDate));
                    endDate = endDate.replace(/\-/g,"/");
//                    alert("替换- endDate="+endDate+",type="+typeof endDate);
                    endDate = new Date(Date.parse(endDate));
//                    alert("beginDate="+beginDate+",type="+typeof beginDate+".....endDate="+endDate+",type="+typeof endDate);

                    if(beginDate < new Date() ){
                        flag = false;
                        alert("秒杀开始时间不能小于当前时间!");
                        return;
                    }else{
                        flag = true;
                    }
                    if(endDate < new Date() ){
                        flag = false;
                        alert("秒杀结束时间不能小于当前时间!");
                        return;
                    }else{
                        flag = true;
                    }
                    if(beginDate > endDate){
                        flag = false;
                        alert("秒杀开始时间不能大于结束时间!");
                        return;
                    }else{
                        flag = true;
                    }
                    if(miaoShaPriceSelect == 0 || miaoShaPriceSelect == "0" || typeof miaoShaPriceSelect =='undefined' || miaoShaPriceSelect == null){
                        flag = false;
                        alert("请选择秒杀价格!");
                        return;
                    }else{
                        flag = true;
                    }
                }
                if(goodsname==''){
                    flag = false;
                    alert("商品名称不能为空!");
                    return;
                }else{
                    flag = true;
                }
//                alert("开始表单提交，flag="+flag);
                if(flag == true){
//                    alert("表单提交，flag="+flag);
                    //业务需求：每天只能推荐一件商品为秒杀商品
                    //发送ajax请求，判断所选开始日期是否有推荐秒杀商品。
                    //有，则推荐失败; 没有，则可以推荐
                    $.ajax({
                        url:$('#path').val()+'admin/miaosha/ajaxCheckBeginDate.action?beginDate='+$("#beginDate").val()+'&endDate='+$("#endDate").val(),
                        success:function(data){
                            if(data == null || data == '' || typeof data =='undefined'){
                                flag = false;
                                return;
                            }else{
                                data = JSON.parse(data);
//                                alert("data.goodsNum="+data.goodsNum+",type="+typeof  data.goodsNum);
                                if(data.goodsNum == '1'){
                                    alert("成功推荐该商品为秒杀商品！")
                                    $("#form_advLocation").submit();
                                } else{
                                    flag = false;
                                    alert("此开始时间已有商品在秒杀，请另选择！");
                                    return;
                                }
                            }
                        },
                        error:function(e){
                            flag = false;
                            return;
                            alert("系统发生错误，稍后重试！");
                        }
                    });

                }else{
                    return;
                }
//
//                $("#form_advLocation").submit(function(){
//                    alert("flag="+flag);
//                    if(flag == true){
//                        return true;
//                    }
//                    return false;
//                });

            });

            //加载页面时，自动获取所有的可以推荐的区域
//            $.ajax({
//                url:$('#path').val()+'admin/advLocation/ajaxFindAll.action',
//                success:function(data){
////                    alert("data.length="+data.length+",data="+data+",data.type="+typeof data);
//                    var locationArray = eval(data);
////                    alert("locationArray.length="+locationArray.length);
//                    if(locationArray.length==0){
//                        return ;
//                    }
//                    for(i=0;i<locationArray.length;i++){
//                        var op='<option value="'+locationArray[i].id+'">'+locationArray[i].locIntro+'</option>';
//                        $('#recommendArea').append(op);
//                    }
//                }
//            });
        });

    </script>
</head>
<body>

<div class="maindiv">
    <h1>
        商品推荐管理&mdash;&mdash;商品推荐</h1>
</div>
<input type="hidden" value="<%=basePath %>" id="path">
<form action="<%=basePath %>admin/recommend/recommend.action" method="post" id="form_advLocation">
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
                            <input id="createdate" name="goodsRecommend.goods.createdate" value="${goodsRecommend != null ? goodsRecommend.goods.createdate : goods.createdate}"
                                   type="text" size="50" readonly="true">
                        </td>
                    </tr>
                    <tr>
                        <td align="left">推荐人:</td>
                        <td>
                            <input id="recommend" name="goodsRecommend.admin.username"  type="text" size="50"
                                   value="${goodsRecommend != null ? goodsRecommend.admin.username : admin.username}" readonly="true">
                        </td>
                    </tr>
                    <tr>
                        <td align="left">推荐至秒杀商品</td>
                        <td>
                            <div id="miaoSha">
                                <input type="radio" id="isMiaoSha"   name="ms" value="1">是&nbsp;
                                <input type="radio" id="noMiaoSha"   name="ms" value="0" checked>否
                            </div>
                        </td>
                    </tr>
                    <tr id="miaoShaDate">
                        <td align="left">秒杀开始时间</td>
                        <td>
                            <input type="text" class="Wdate" id="beginDate" name="miaoSha.beginDate"
                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                   size="30" maxlength="30" readonly="readonly"><span style="color: red;">(请至少提前一小时设置开始时间)</span>
                        </td>
                        <td align="left">秒杀结束时间</td>
                        <td>
                            <input type="text" class="Wdate" id="endDate"   name="miaoSha.endDate"
                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                   size="30" maxlength="30" readonly="readonly" >
                        </td>
                    </tr>
                    <tr id="miaoPrice">
                        <td align="left">秒杀价</td>
                        <td>
                            <select id="miaoShaPriceSelect" name="miaoSha.miaoPrice">
                                <option value="0">--请选择折扣--</option>
                                <option value="0.1">1折秒杀</option>
                                <option value="0.15">1.5折</option>
                                <option value="0.2">2折</option>
                                <option value="0.25">2.5折</option>
                                <option value="0.3">3折</option>
                                <option value="0.3.5">3.5折</option>
                                <option value="0.4">4折</option>
                                <option value="0.45">4.5折</option>
                                <option value="0.5">5折</option>
                                <option value="0.55">5.5</option>
                                <option value="0.6">6折</option>
                                <option value="0.6.5">6.5折</option>
                                <option value="0.7">7折</option>
                                <option value="0.75">7.5折</option>
                                <option value="0.8">8折</option>
                                <option value="0.85">8.5折</option>
                                <option value="0.9">9折</option>
                                <option value="0.95">9.5折</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="isHot">
                        <td>是否推荐位热销商品</td>
                        <td>
                            <input type="radio"   name="hot" value="1" checked>是&nbsp;
                            <input type="radio"   name="hot" value="0" >否
                        </td>
                    </tr>

                    <%--<tr id="recommendAreaId">--%>
                        <%--<td align="left">推荐区域:</td>--%>
                        <%--<td>--%>
                            <%--<select id="recommendArea" name="locationId" >--%>
                                <%--<option value="0">————请选择推荐区域————</option>--%>
                            <%--</select>--%>
                        <%--</td>--%>
                    <%--</tr>--%>

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
