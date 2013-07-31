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

		<title>活动管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="admin/interest/js/activitytype.js"></script>

	</head>

	<body
		onload="selectType('${param['programa.proID'] }','所有类别','${param['activityType.typeId'] }')">
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash;活动管理
			</h1>
		</div>

		<form action="admin/activity!manage.action" method="post"
			name="form_activity" id="form_activity">
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
									活动标题：
								</td>
								<td>
									<input type="text" name="activitytitle" id="activitytitle"
										value="${param.activitytitle }" />
								</td>
								<td>
									所属栏目：
								</td>
								<td>
									<select name="programa.proID" id="programa.proID"
										onchange="selectType(this.value,'所有类别')">
										<option value="">
											所有栏目
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
									所属类别：
								</td>
								<td>
									<select name="activityType.typeId" id="typeId">
										<option value="">
											所有类别
										</option>
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
						活动标题
					</td>
					<td>
						所属栏目
					</td>
					<td>
						所属类别
					</td>
					<td>
						作品数
					</td>
					<td>
						开始时间
					</td>
					<td>
						结束时间
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="#request.list_activity" id="activity">
					<tr align="center" bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#e8f6ff';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<u>${activity.activitytitle }</u>
						</td>
						<td>
							<u>${activity.programa.proName } </u>
						</td>
						<td>
							<u>${activity.activityType.typeName }</u>
						</td>
						<td>
							<u> <s:property value="#activity.activityWorkses.size"/> </u>
						</td>
						<td>
							<u><s:date name="begindate" format="yyyy-MM-dd" /> </u>
						</td>
						<td>
							<U> <u> <s:date name="enddate" format="yyyy-MM-dd" /> </u> </U>
						</td>
						<td>
							<a
								href="admin/activity!picManage.action?activityid=${activity.activityid }">线下图片管理</a>
							<a
								href="admin/teacher!manage.action?activityid=${activity.activityid }">指导老师管理</a>
							<!-- <a
								href="admin/works!manage.action?activityid=${activity.activityid }">作品管理</a>
							 -->
							<a
								href="admin/works!openWorksAudit.action?activityid=${activity.activityid }">作品审核管理</a>
							<a
								href="admin/activity!updatePage.action?activityid=${activity.activityid }">修改</a>&nbsp;
							|&nbsp;
							<a
								href="admin/activity!delete.action?activityid=${activity.activityid }"
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
						<t:tpage formId="form_activity" pageDiv="page"
							page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
