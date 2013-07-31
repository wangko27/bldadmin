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

		<title>作品管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>

		<script type="text/javascript">
			$().ready(function(){
				//添加
				$("#btnAdd").bind("click",function(){
					window.location="admin/works!addPage.action?activityid=${activity.activityid }";
				});
			});
		</script>
	</head>

	<body>
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash; ${activity.activitytitle } &mdash;&mdash; 作品管理
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
					<form action="admin/works!manage.action" method="post"
						name="form_works" id="form_works">
						<input type="hidden" name="activityid" id="activityid"
							value="${activity.activityid }" />
						<table>
							<tr>
								<td>
									作品编号：
								</td>
								<td>
									<input type="text" name="worksnumber" id="worksnumber"
										value="${param.worksnumber }" size="10" />
								</td>
								<td>
									作品标题：
								</td>
								<td>
									<input type="text" name="workstitle" id="workstitle"
										value="${param.workstitle }" />
								</td>
								<td>
									作者：
								</td>
								<td>
									<input type="text" name="author" id="author"
										value="${param.author }" size="10" />
								</td>
								<td>
									<input type="submit" value="搜索" class="sst" />
								</td>
								<td>
									<input type="button" value="添加" name="btnAdd" id="btnAdd"
										class="sst" />
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
					作品编号
				</td>
				<td>
					作者
				</td>
				<td>
					作品标题
				</td>
				<td>
					总票数
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
			<s:iterator value="#request.list_activityWorks" id="works">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${works.worksnumber }</u>
					</td>
					<td>
						<u>${works.author } </u>
					</td>
					<td>
						<u>${works.workstitle }</u>
					</td>
					<td>
						<u>${works.votes }</u>
					</td>
					<td>
						<u><s:date name="createdate" format="yyyy-MM-dd HH:mm:ss" /> </u>
					</td>
					<td>
						<U> <u> <s:date name="modifydate" format="yyyy-MM-dd HH:mm:ss" />
						</u> </U>
					</td>
					<td>
						<a href="admin/works!updatePage.action?worksid=${works.worksid }&activityid=${activity.activityid }">修改</a>&nbsp;
						|&nbsp;
						<a href="admin/works!delete.action?worksid=${works.worksid }&activityid=${activity.activityid }"
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
					<t:tpage formId="form_works" pageDiv="page" page="${result.page}"
						goImg="img/learning_img/gog.gif"></t:tpage>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
