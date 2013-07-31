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

		<title>首页活动作品展示管理</title>

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
				兴趣频道管理&mdash;&mdash;首页活动作品展示管理
			</h1>
		</div>
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="8" background="skin/images/tbg.gif">
					&nbsp;文档列表&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td>
					显示图片
				</td>
				<td>
					显示标题
				</td>
				<td>
					排序
				</td>
				<td>
					状态
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
			<s:iterator value="#request.list_worksShow" id="w">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<img src="${w.showImgpath }" width="60" height="80" />
					</td>
					<td width="150">
						<u>${w.showTitle }</u>
					</td>
					<td>
						<u>${w.showSort }</u>
					</td>
					<td>
						<u> <s:if test="#w.showEnabled==1">有效</s:if> <s:else>无效</s:else>
						</u>
					</td>
					<td>
						<U> <s:date name="showCreatedate" format="yyyy-MM-dd HH:mm:ss" />
						</U>
					</td>
					<td>
						<U> <s:date name="showModifydate" format="yyyy-MM-dd HH:mm:ss" />
						</U>
					</td>
					<td>
						<a href="admin/worksShow!updatePage.action?showId=${w.showId }">修改</a>&nbsp;
						|&nbsp;
						<a href="admin/worksShow!delete.action?showId=${w.showId }"
							onClick="return(confirm('確定刪除?'))">删除</a>
					</td>
				</tr>
				<tr>
					<td class="nv" colspan="5" align="right">
						&nbsp;
					</td>
				</tr>
			</s:iterator>

			<tr bgcolor="#e8f6ff">
				<td class="nv" colspan="8">
					<form id="form1" action="admin/worksShow!manage.action"
						method="post">
						<t:tpage formId="form1" pageDiv="page" page="${result.page}"
							goImg="img/learning_img/gog.gif"></t:tpage>
					</form>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
