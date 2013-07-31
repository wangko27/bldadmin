<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>资讯管理</title>

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
				资讯频道管理&mdash;&mdash;资讯管理
			</h1>
		</div>
		<form action="admin/article!manage.action" method="post"
			name="form_article" id="form_article">
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
									标题：
								</td>
								<td>
									<input type="text" name="articletitle" id="articletitle"
										value="${param.articletitle }" />
								</td>
								<td>
									类别：
								</td>
								<td>
									<select name="articletypeid" id="articletypeid">
										<option value="">
											所有
										</option>
										<s:iterator value="articleTypeAll" id="at">
											<option value="${at.articletypeid }"
												<c:if test="${at.articletypeid==param.articletypeid }">selected</c:if>>
												${at.articletypename }
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
					<td height="24" colspan="8" background="skin/images/tbg.gif">
						&nbsp;文档列表&nbsp;
					</td>
				</tr>
				<tr align="center" bgcolor="#e8f0f3" height="22">
					<td>
						标题
					</td>
					<td>
						类别
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
				<s:iterator value="#request.list_articleSrc" id="a">
					<tr align="center" bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#e8f6ff';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td width="250">
							<u>${a.articletitle }</u>
						</td>
						<td>
							<u>${a.articleType.articletypename }</u>
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
								href="admin/article!updatePage.action?articlesrcid=${a.articlesrcid }">修改</a>&nbsp;
							|&nbsp;
							<a
								href="admin/article!delete.action?articlesrcid=${a.articlesrcid }"
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
						<t:tpage formId="form_article" pageDiv="page"
							page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
