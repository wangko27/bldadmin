<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>学习频道管理——名师讲坛——文章管理</title>

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
					window.location="superteacher/add.jsp";
				});
			});
		</script>
	</head>

	<body>
		<div class="maindiv">
			<h1>
				学习频道管理——名师讲坛——名师管理
			</h1>
		</div>

		<form action="admin/learn/superTeacher!openSuperTeacher.action"
			method="post" name="form_superTeacher" id="form_superTeacher">
			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
				<tr>
					<td colspan="8" bgcolor="#e8f0f3">
						搜索
					</td>
				</tr>
				<tr>
					<td colspan="8" bgcolor="#FFFFFF" align="center">
						<table>
							<tr>
								<td>
									姓名：
								</td>
								<td>
									<input type="text" name="username" id="username"
										value="${param.username }" />
								</td>
								<td>
									所属学校：
								</td>
								<td>
									<input type="text" name="inSchool" id="inSchool"
										value="${param.inSchool }" />
								</td>
								<td>
									状态：
								</td>
								<td>
									<select name="flag" id="flag">
										<option value="">
											全部
										</option>
										<option value="1"
											<c:if test="${param.flag=='1' }">selected</c:if>>
											在职
										</option>
										<option value="0"
											<c:if test="${param.flag=='0' }">selected</c:if>>
											不在职
										</option>
									</select>
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
					</td>
				</tr>
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="8" background="skin/images/tbg.gif">
						&nbsp;文档列表&nbsp;
					</td>
				</tr>
				<tr align="center" bgcolor="#e8f0f3" height="22">
					<td>
						姓名
					</td>
					<td>
						所在学校
					</td>
					<td>
						职位
					</td>
					<td>
						工龄
					</td>
					<td>
						状态
					</td>
					<td>
						人气
					</td>
					<td>
						所发文章数
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="#request.list_superTeacher" id="superTeacher">
					<tr align="center" bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#e8f6ff';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<u>${superTeacher.username }</u>
						</td>
						<td>
							<u> ${superTeacher.inSchool } </u>
						</td>
						<td>
							<u>${superTeacher.teacherPost } </u>
						</td>
						<td>
							<u>${superTeacher.workyears } </u>
						</td>
						<td>
							<u><c:if test="${superTeacher.flag==1 }">在职</c:if> <c:if
									test="${superTeacher.flag==0 }">不在职</c:if> </u>
						</td>
						<td>
							<u>${superTeacher.peopleNum } </u>
						</td>
						<td>
							<u><s:property
									value="#request.superTeacher.superAticles.size" /> </u>
						</td>
						<td>
							<a
								href="admin/learn/superTeacher!openModifySuperTeacher.action?superTeacherID=${superTeacher.superTeacherID }">修改</a>&nbsp;
							|&nbsp;
							<a
								href="admin/learn/superTeacher!deleteSuperTeacher.action?superTeacherID=${superTeacher.superTeacherID }"
								onClick="return(confirm('確定刪除?'))">删除</a> |&nbsp;
							<a
								href="admin/learn/teacherArticle!openAddTeacherArticle.action?superTeacherID=${superTeacher.superTeacherID }&username=${superTeacher.username }">添加文章</a>
							|&nbsp;
							<a
								href="admin/learn/teacherArticle!openTeacherArticle.action?superTeacherID=${superTeacher.superTeacherID }&username=${superTeacher.username }">文章管理</a>
						</td>
					</tr>
					<tr>
						<td class="nv" colspan="8" align="right">
							&nbsp;
						</td>
					</tr>
				</s:iterator>

				<tr bgcolor="#e8f6ff">
					<td class="nv" colspan="8">
						<t:tpage formId="form_superTeacher" pageDiv="page"
							page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
