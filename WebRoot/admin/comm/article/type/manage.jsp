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

		<title>文章类别管理</title>

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
				学习频道管理&mdash;&mdash;文章类别管理
			</h1>
		</div>
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="6" background="skin/images/tbg.gif">
					&nbsp;文档列表&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td>
					类别名称
				</td>
				<td>
					上级类别
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
			<s:iterator value="#request.list_articleType" id="a">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${a.articletypename }</u>
					</td>
					<td>
						<u>${a.articleType.articletypename } </u>
					</td>
					<td>
						<u>${a.articlesort }</u>
					</td>
					<td>
						<U> <s:date name="createdate" format="yyyy-MM-dd HH:mm:ss" />
						</U>
					</td>
					<td>
						<U> <s:date name="modifydate" format="yyyy-MM-dd HH:mm:ss" />
						</U>
					</td>
					<td>
						<a
							href="admin/articleType!updatePage.action?articletypeid=${a.articletypeid }">修改</a>&nbsp;
						|&nbsp;
						<a
							href="admin/articleType!delete.action?articletypeid=${a.articletypeid }"
							onClick="return(confirm('確定刪除?'))">删除</a>
					</td>
				</tr>
				<tr>
					<td class="nv" colspan="6" align="right">
						&nbsp;
					</td>
				</tr>
			</s:iterator>

			<tr bgcolor="#e8f6ff">
				<td class="nv" colspan="6">
					<form id="form1" action="admin/readType!manage.action" method="post">
					</form>
					<t:tpage formId="form1" pageDiv="page"
						page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
