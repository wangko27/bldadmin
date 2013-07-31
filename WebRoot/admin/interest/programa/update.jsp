<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>修改活动栏目</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />

	</head>

	<body>
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash;修改活动栏目
			</h1>
		</div>
		<form method="post" action="admin/UpdatePrograma.action"
			name="form_programaUpdate" id="form_programaUpdate">
			<s:token></s:token>
			<input type="hidden" id="proID" name="proID"
				value="${programa.proID }" />
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" width="150">
									栏目名称：
								</td>
								<td>
									<input type="text" name="proName" id="proName" size="30"
										value="${programa.proName }">
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									栏目URL：
								</td>
								<td>
									<input type="text" name="proUrl" id="proUrl" size="30"
										value="${programa.proUrl }">
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									是否启用：
								</td>
								<td>
									<s:radio list="#{1:'是',0:'否'}"
										value="%{#request.programa.proIsenable}" name="proIsenable"></s:radio>
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									排序：
								</td>
								<td>
									<input type="text" name="proSort" id="proSort"
										value="${programa.proSort }" size="30">
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" name="Submit" value="保存" class="sst">
									<input type="reset" name="Submit" value="重置" class="sst_1">

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
