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
					window.location="admin/article!openAddMastersArticle.action?memberid=${memberid }&nikename=${nikename }";
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

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr>
				<th colspan="7">
					名师：${nikename }
				</th>
			</tr>
			<tr>
				<td colspan="7" bgcolor="#e8f0f3">
					搜索
				</td>
			</tr>
			<tr>
				<td colspan="7" bgcolor="#FFFFFF" align="center">
					<form action="admin/admin/article!openMastersArticle.action"
						method="post" name="form_article" id="form_article">
						<input type="hidden" name="memberid" id="memberid"
							value="${memberid }" />
						<input type="hidden" name="nikename" id="nikename"
							value="${nikename }" />
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
									发布：
								</td>
								<td>
									<select name="ispublication" id="ispublication">
										<option value="">
											全部
										</option>
										<option value="1"
											<c:if test="${param.ispublication=='1' }">selected</c:if>>
											发布
										</option>
										<option value="0"
											<c:if test="${param.ispublication=='0' }">selected</c:if>>
											未发布
										</option>
									</select>
								</td>
								<td>
									置顶：
								</td>
								<td>
									<select name="istop" id="istop">
										<option value="">
											全部
										</option>
										<option value="1"
											<c:if test="${param.istop=='1' }">selected</c:if>>
											置顶
										</option>
										<option value="0"
											<c:if test="${param.istop=='0' }">selected</c:if>>
											未置顶
										</option>
									</select>
								</td>
								<td>
									推荐：
								</td>
								<td>
									<select name="isrecommend" id="isrecommend">
										<option value="">
											全部
										</option>
										<option value="1"
											<c:if test="${param.isrecommend=='1' }">selected</c:if>>
											推荐
										</option>
										<option value="0"
											<c:if test="${param.isrecommend=='0' }">selected</c:if>>
											未推荐
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
									<a href="admin/article!openMasters.action" target="main">返回名师列表</a>
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
					标题
				</td>
				<td>
					是否发布
				</td>
				<td>
					是否置顶
				</td>
				<td>
					是否推荐
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
			<s:iterator value="#request.list_masters_article" id="article">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${article.articletitle }</u>
					</td>
					<td>
						<u> <c:if test="${article.ispublication==1 }">是</c:if> <c:if
								test="${article.ispublication==0 }">否</c:if> </u>
					</td>
					<td>
						<u><c:if test="${article.istop==1 }">是</c:if> <c:if
								test="${article.istop==0 }">否</c:if> </u>
					</td>
					<td>
						<u><c:if test="${article.isrecommend==1 }">是</c:if> <c:if
								test="${article.isrecommend==0 }">否</c:if> </u>
					</td>
					<td>
						<u><s:date name="createdate" format="yyyy-MM-dd HH:mm:ss" />
						</u>
					</td>
					<td>
						<U> <u> <s:date name="modifydate"
									format="yyyy-MM-dd HH:mm:ss" /> </u> </U>
					</td>
					<td>
						<a
							href="admin/article!openModifyMastersArticle.action?articlesrcid=${article.articlesrcid }&memberid=${memberid }&nikename=${nikename }">修改</a>&nbsp;
						|&nbsp;
						<a
							href="admin/article!deleteMastersArticle.action?articlesrcid=${article.articlesrcid }&memberid=${memberid }&nikename=${nikename }"
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
					<t:tpage formId="form_article" pageDiv="page" page="${result.page}"
						goImg="img/learning_img/gog.gif"></t:tpage>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
