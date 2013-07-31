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

    <title>修改文章</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
    <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>

</head>
<body>
<div class="maindiv">
    <h1>
        推荐管理&mdash;&mdash;修改文章
    </h1>
</div>
<form action="<%=basePath %>admin/recommend/updateArticle.action" method="post" enctype="multipart/form-data"
      id="form_gAdd">
    <s:token></s:token>
    <input type="hidden" id="succes" value="${chonggong }">
    <input type="hidden" id="path" value="<%=basePath %>">
    <table width="98%" border="0" cellpadding="0" cellspacing="1"
           align="center">
        <tr>
            <td height="26" background="skin/images/newlinebg3.gif">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <input type="hidden" id="articleId" name="article.id" value="${article.id}"/>
                        <td width="150" align="left" style="text-align: right">文章类型:
                        </td>

                        <td >
                            <script type="text/javascript">
                                var type= ${article.type};
                                var options = document.getElementById("articleTypeSelect").options;
                                for(var i=0; i< options.length;i++){
                                     if(options[i].value == type){
                                         options[i].selected = true;
                                     }
                                }
                            </script>
                            <select name="article.type" id="articleTypeSelect">
                                <option value="0">   家政服务     </option>
                                <option value="1">   鲜花服务     </option>
                                <option value="2">   驾校服务     </option>
                                <option value="3">   旅游服务     </option>
                                <option value="4">   帮助中心     </option>
                                <option value="5">   配送方式     </option>
                                <option value="6">   客户服务     </option>
                                <option value="7">   会员中心     </option>
                                <option value="8">   招商专区    </option>
                                <option value="9">   公司介绍     </option>
                                <option value="10">   商城公告     </option>
                            </select>
                            &nbsp;</td>

                    </tr>




                    <tr>
                        <td align="left" valign="top" style="text-align: right">标题:</td>
                        <td colspan="3">
                            <input name="article.title" value="${article.title}"/>
                            <span id="gPdsNum" style="color: #F03; font-size: 12px;"></span></td>
                    </tr>
                    <tr>
                        <td align="left" valign="top" style="text-align: right">排序</td>
                        <td><input name="article.orderList" value="${article.orderList}"/></td>
                    </tr>

                    <tr>
                        <td align="left" valign="top" style="text-align: right">内容:</td>
                        <td style="word-break: break-all" colspan="3">
                            <textarea cols="80" id="gPdp" name="article.text"  rows="10" >${article.text}</textarea>
                            <script type="text/javascript">//<![CDATA[
                            window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
                            //]]></script>
                            <script type="text/javascript"
                                    src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
                            <script type="text/javascript">//<![CDATA[
                            CKEDITOR.replace('article.text');
                            //]]></script>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="4" align="center">
                            <input type="submit" id="tjBut" value="保存" class="sst">
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
