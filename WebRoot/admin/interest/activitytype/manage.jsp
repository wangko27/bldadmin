<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
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

		<title>活动类别管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />

	</head>

	<body>
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash;活动类别管理
			</h1>
		</div>

		<form action="admin/activityType!manage.action" method="post"
			name="formActivityType" id="formActivityType">
			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
				<tr>
					<td colspan="7" bgcolor="#e8f0f3">
						搜索
					</td>
				</tr>
				<tr>
					<td colspan="7" bgcolor="#FFFFFF" align="center">
						<table>
							<tr>
								<td>
									类别名称：
								</td>
								<td>
									<input type="text" name="typeName" id="typeName"
										value="${param.typeName }" />
								</td>
								<td>
									栏目：
								</td>
								<td>
									<select name="programa.proID" id="programa.proID">
										<option value="">
											全部
										</option>
										<s:iterator value="programaAll" id="p">
											<option value="${p.proID }"
												<s:if test="#p.proID==#attr['programa.proID']">selected</s:if>>
												${p.proName }
											</option>
										</s:iterator>
									</select>
								</td>
								<td>
									<input type="submit" value="搜索" class="sst" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="7" background="skin/images/tbg.gif">
						&nbsp;文档列表&nbsp;
					</td>
				</tr>
				<tr align="center" bgcolor="#e8f0f3" height="22">
					<td>
						类别名称
					</td>
					<td>
						所属栏目
					</td>
					<td>
						创建时间
					</td>
					<td>
						修改时间
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="#request.list_activityType" id="activityType">
					<tr align="center" bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#e8f6ff';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<u>${activityType.typeName }</u>
						</td>
						<td>
							<u>${activityType.programa.proName } <s:if
									test="#activityType.programa==null">公用类别</s:if> </u>
						</td>
						<td>
							<U> <s:date name="typeCreatedate"
									format="yyyy-MM-dd HH:mm:ss" /> </U>
						</td>
						<td>
							<U> <s:date name="typeUpdatedate"
									format="yyyy-MM-dd HH:mm:ss" /> </U>
						</td>
						<td>
							<a
								href="admin/activityType!updatePage.action?typeId=${activityType.typeId }">修改</a>&nbsp;
							|&nbsp;
							<a
								href="admin/activityType!delete.action?typeId=${activityType.typeId }"
								onClick="return(confirm('確定刪除?'))">删除</a>
						</td>
					</tr>
					<tr>
						<td class="nv" colspan="7" align="right">
							&nbsp;
						</td>
					</tr>
				</s:iterator>

				<tr bgcolor="#e8f6ff">
					<td class="nv" colspan="7">
						<t:tpage formId="formActivityType" pageDiv="page"
							page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
