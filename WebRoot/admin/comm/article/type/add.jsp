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

		<title>添加文章类别</title>

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
				学习频道管理&mdash;&mdash;添加文章类别
			</h1>
		</div>
		<form method="post" action="admin/addArticleType.action"
			name="form_articleTypeAdd" id="form_articleTypeAdd">
			<s:token></s:token>
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr id="addarea">
								<td>
									上级类别：
								</td>
								<td>
									<select name="articleType.articletypeid"
										id="articleType.articletypeid">
										<option value="">
										</option>
										<s:iterator value="articleTypeAll" id="a">
											<option value="${a.articletypeid }">
												${a.articletypename }
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									类别名称：
								</td>
								<td>
									<input type="text" name="articletypename" id="articletypename"
										size="30">
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									排序：
								</td>
								<td>
									<input type="text" name="articlesort" id="articlesort"
										size="30">
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
