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

		<title>活动栏目管理</title>

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
				兴趣频道管理&mdash;&mdash;活动栏目管理
			</h1>
		</div>

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr>
				<td colspan="7" bgcolor="#e8f0f3">
					搜索
				</td>
			</tr>
			<tr>
				<td colspan="7" bgcolor="#FFFFFF" align="center">
					<form action="admin/programa!manage.action" method="post">
						<table>
							<tr>
								<td>
									栏目名称：
								</td>
								<td>
									<input type="text" name="proName" id="proName" />
								</td>
								<td>
									状态：
								</td>
								<td>
									<select name="proIsenable" id="proIsenable">
										<option value="">
											全部
										</option>
										<option value="1">
											有效
										</option>
										<option value="0">
											无效
										</option>
									</select>
								</td>
								<td>
									<input type="submit" value="搜索" class="sst" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="7" background="skin/images/tbg.gif">
					&nbsp;文档列表&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td>
					栏目名称
				</td>
				<td>
					是否启用
				</td>
				<td>
					排序
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
			<s:iterator value="#request.list_programa" id="programa">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${programa.proName }</u>
					</td>
					<td>
						<u> <s:if test="#request.programa.proIsenable==1">是</s:if> <s:else>否</s:else>
						</u>
					</td>
					<td>
						<u>${programa.proSort } </u>
					</td>
					<td>
						<U> <s:date name="proCreatedate" format="yyyy-MM-dd HH:mm:ss" />
						</U>
					</td>
					<td>
						<U> <s:date name="proUpdatedate" format="yyyy-MM-dd HH:mm:ss" />
						</U>
					</td>
					<td>
						<a
							href="admin/programa!updatePage.action?proID=${programa.proID }">修改</a>&nbsp;
						|&nbsp;
						<a href="admin/programa!delete.action?proID=${programa.proID }"
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
					<form id="form1" action="admin/programa!manage.action"
						method="post">
					</form>
					<t:tpage formId="form1" pageDiv="page" page="${result.page}"
						goImg="img/learning_img/gog.gif"></t:tpage>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
