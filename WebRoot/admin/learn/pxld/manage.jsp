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

		<title>学习频道管理——品学论道——文章管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>

	</head>

	<body>
		<div class="maindiv">
			<h1>
				学习频道管理——品学论道——文章管理
			</h1>
		</div>

		<form action="admin/learn/pxld!openPxld.action" method="post"
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
									角色：
								</td>
								<td>
									<select name="memberType" id="memberType">
										<option value="">
											全部
										</option>
										<option value="1"
											<c:if test="${param.memberType=='1' }">selected</c:if>>
											学生
										</option>
										<option value="2"
											<c:if test="${param.memberType=='2' }">selected</c:if>>
											家长
										</option>
										<option value="3"
											<c:if test="${param.memberType=='3' }">selected</c:if>>
											老师
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
											已推荐
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
						发布人
					</td>
					<td>
						角色
					</td>
					<td>
						推荐状态
					</td>
					<td>
						用户推荐数
					</td>
					<td>
						创建时间
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="#request.list_pxld_article" id="article">
					<tr align="center" bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#e8f6ff';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<u>${article.articletitle }</u>
						</td>
						<td>
							${article.member.nikename }
						</td>
						<td>
							<c:if test="${article.member.memberType==1 }">学生</c:if>
							<c:if test="${article.member.memberType==2 }">家长</c:if>
							<c:if test="${article.member.memberType==3 }">老师</c:if>
						</td>
						<td>
							<u> <c:if test="${article.isrecommend==1 }">已推荐</c:if> <c:if
									test="${article.isrecommend==0 }">未推荐</c:if> </u>
						</td>
						<td>
							<u>${article.userpushnum } </u>
						</td>
						<td>
							<U> <s:date name="createdate" format="yyyy-MM-dd HH:mm:ss" />
							</U>
						</td>
						<td>
							<c:if test="${article.isrecommend==1 }">
								<a
									href="admin/learn/pxld!cancelRecommendPxld.action?articlesrcid=${article.articlesrcid }">从品学论道移除</a>&nbsp;
						</c:if>
							<c:if test="${article.isrecommend==0 }">
								<a
									href="admin/learn/pxld!recommendPxld.action?articlesrcid=${article.articlesrcid }">推荐到品学论道</a>&nbsp;
						</c:if>
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
						<t:tpage formId="form_article" pageDiv="page"
							page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
