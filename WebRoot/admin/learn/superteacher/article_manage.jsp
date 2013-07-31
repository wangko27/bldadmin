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
					window.location="admin/learn/teacherArticle!openAddTeacherArticle.action?superTeacherID=${superTeacherID }&username=${username }";
				});
			});
		</script>
	</head>

	<body>
		<div class="maindiv">
			<h1>
				学习频道管理——名师讲坛——文章管理
			</h1>
		</div>

		<form action="admin/learn/teacherArticle!openTeacherArticle.action"
			method="post" name="form_article" id="form_article">
			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
				<tr>
					<th colspan="7">
						名师：${username }
					</th>
				</tr>
				<tr>
					<td colspan="7" bgcolor="#e8f0f3">
						搜索
					</td>
				</tr>
				<tr>
					<td colspan="7" bgcolor="#FFFFFF" align="center">
						<input type="hidden" name="superTeacherID" id="superTeacherID"
							value="${superTeacherID }" />
						<input type="hidden" name="username" id="username"
							value="${username }" />
						<table>
							<tr>
								<td>
									标题：
								</td>
								<td>
									<input type="text" name="articletitle" id="articletitle"
										value="${param.articletitle }" />
								</td>
								<td>
									文章类别：
								</td>
								<td>
									<select name="flag" id="flag">
										<option value="">
											全部
										</option>
										<option value="1"
											<c:if test="${param.flag=='1' }">selected</c:if>>
											图片+文字
										</option>
										<option value="2"
											<c:if test="${param.flag=='2' }">selected</c:if>>
											视频+文字
										</option>
										<option value="3"
											<c:if test="${param.flag=='3' }">selected</c:if>>
											文字
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
								<td>
									<a href="admin/learn/superTeacher!openSuperTeacher.action"
										target="main">返回名师列表</a>
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
						标题
					</td>
					<td>
						文章类别
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
				<s:iterator value="#request.list_superAticle" id="superAticle">
					<tr align="center" bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#e8f6ff';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<u>${superAticle.articletitle }</u>
						</td>
						<td>
							<u> <c:if test="${superAticle.flag==1 }">图片+文字</c:if> <c:if
									test="${superAticle.flag==2 }">视频+文字</c:if> <c:if
									test="${superAticle.flag==3 }">文字</c:if> </u>
						</td>
						<td>
							<u><s:date name="createDate" format="yyyy-MM-dd HH:mm:ss" />
							</u>
						</td>
						<td>
							<U> <u> <s:date name="modifyDate"
										format="yyyy-MM-dd HH:mm:ss" /> </u> </U>
						</td>
						<td>
							<a
								href="admin/learn/teacherArticle!openModifyTeacherArticle.action?superAticleID=${superAticle.superAticleID }&superTeacherID=${superTeacherID }&username=${username }">修改</a>&nbsp;
							|&nbsp;
							<a
								href="admin/learn/teacherArticle!deleteTeacherArticle.action?superAticleID=${superAticle.superAticleID }&superTeacherID=${superTeacherID }&username=${username }"
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
						<t:tpage formId="form_article" pageDiv="page"
							page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
