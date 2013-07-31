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

		<title>添加商品类别</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
        <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
        <script language="javascript" src="<%=basePath %>admin/shopping/js/sort.js"></script>
	</head>
	<body>
		<div class="maindiv">
			<h1>
				商品频道管理&mdash;&mdash;添加商品类别
			</h1>
		</div>
		<form method="post" action="admin/shop/addSrot.action"
			id="form_srotAdd">
			<s:token></s:token>
			<input type="hidden" id="succ" value="${sucResult }">
			<input type="hidden" id="path" value="<%=basePath %>">
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" width="150">上级目录：
								</td>
								<td>
                                <select name="category.goodesCategory.categoryid" id="sjSrot">
                                <option value=""> 无需上级目录</option>
                                	<c:forEach items="${goodsList}" var="gSort">
                                		<option value="${gSort.categoryid }"> ${gSort.categoryname }</option>
                                    </c:forEach>
                                </select>
                                </td>
							</tr>
							<tr>
								<td align="left" width="150">
									分类名称：
								</td>
								<td>
									<input type="text" name="category.categoryname" id="srotName" size="30">
									<span style="font-size: 12px; color: #F00;" id="err"></span>
								</td>
							</tr>
							<tr>
                                <td align="left">是否为热销类别:</td>
                                <td>
                                <input type="radio" name="category.ishot" id="rxSrot" value="1">
                                是 
                                <input name="category.ishot" type="radio" id="rxSrot" value="0" checked>否
                                </td>
                            </tr>
                            <tr>
                                <td align="left" width="150">页面关键词：
                                </td>
                                <td><input name="category.metakeywords" type="text" id="ymSrotKey" size="30">
								<span style="font-size: 12px; color: #F00;" id="errKey"></span>
								</td>
                            </tr>
							<tr>
								<td align="left" width="150">
									排序：
								</td>
								<td>
									<input type="text" name="category.orderlist" id="pxSrot" value="1"
										size="30">
									<span style="font-size: 12px; color: #F00;" id="errpx"></span>
								</td>
							</tr>
                            <tr>
                                <td align="left" valign="top">页面描述:</td>
                                <td><textarea name="category.metadescription" id="ymSrot" cols="45" rows="5"></textarea>
								<span style="font-size: 12px; color: #F00;" id="errYm"></span>
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
