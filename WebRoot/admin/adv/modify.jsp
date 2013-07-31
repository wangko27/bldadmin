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

		<title>修改广告</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
        <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="<%=basePath %>js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js" defer="defer"></script>
		<script type="text/javascript" src="<%=basePath %>admin/js/checkfile.js"></script>
        <script language="javascript" src="<%=basePath %>admin/adv/js/add.js"></script>
	</head>
<body>
		
		<div class="maindiv">
			<h1>
				广告频道管理&mdash;&mdash;修改广告</h1>
		</div>
		<input type="hidden" value="<%=basePath %>" id="path">
		<form action="admin/advLocation/updateAdvInfo.action" method="post" enctype="multipart/form-data"
			id="form_srotAdd">
			<input type="hidden" name="advInfo.advinfoid" value="${info.advinfoid }">
			<input type="hidden" name="advInfo.advtype" value="${info.advtype }">
			<input type="hidden" name="advInfo.showtype" value="${info.showtype }">
			<input type="hidden" name="advInfo.upuserip" value="${info.upuserip }">
			<input type="hidden" name="advInfo.createdate" value="${info.createdate }">
			<input type="hidden" id="isSucc" value="${isSucc }">
			<s:token></s:token>
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" width="150">广告所在的位置:</td>
								<td>
                                    <select name="locationId" id="lAdd" >
                                        <option value="${info.locationInfo.locationid}" selected="selected">${info.locationInfo.locationintro}</option>
                                    </select>
                                </td>
							</tr>
							<tr>
									<td align="left">广告主题:</td>
									<td>
											<input name="advInfo.advtitle" value="${info.advtitle }" type="text" size="30">
									</td>
							</tr>
							<tr>
								<td align="left" width="150">广告链接:</td>
								<td>
									<input name="advInfo.hyperlink" type="text" id="lLoction" value="${info.hyperlink }" size="30">
									<span style="font-size: 12px; color: #F00;" id="err"></span>
								</td>
							</tr>
							<tr>
                                <td align="left">是否展示:</td>
                                <td>
                                <input name="advInfo.advstat" type="radio" id="isShow" value="1" ${info.advstat==1 ? 'checked':'' }>
                                是 
                                <input name="advInfo.advstat" type="radio" id="isShow" value="0" ${info.advstat==0 ? 'checked':'' }>否
                                </td>
                            </tr>
                            <tr>
                                <td align="left" width="150">图片路径:</td>
                                <td><span style="font-size: 12px; color: #F00;" id="errKey"></span>
                                		<input name="advInfo.photoid" type="text" id="textfield" value="${info.photoid }" size="45" readonly="readonly">
                                </td>
                            </tr>
                            <tr>
                            		<td align="left"> 修改图片:</td>
                            		<td>
                            				<input name="img" type="file" id="gpH" size="0">
                            		</td>
                            		</tr>
							<tr>
								<td align="left" width="150">广告开始展示日期:
								</td>
								<td>
									<input name="advInfo.showbegindate" type="text" class="Wdate" id="begindate"
										onclick="WdatePicker()" size="30" maxlength="30" readonly="readonly" value="<fmt:formatDate value="${info.showbegindate }" pattern="yyyy-MM-dd"/>" />
									<span style="font-size: 12px; color: #F00;" id="errpx"></span>
								</td>
							</tr>
                            <tr>
                                <td align="left" valign="top">广告展示结束日期:</td>
                                <td>
                                		<input name="advInfo.showenddate" type="text" class="Wdate" id="enddate"
										onclick="WdatePicker()" size="30" value="<fmt:formatDate value="${info.showenddate }" pattern="yyyy-MM-dd"/>" readonly="readonly" />
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
