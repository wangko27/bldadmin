<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
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

		<title>商品频道管理</title>

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
				商品频道管理&mdash;&mdash;商品类别管理
			</h1>
		</div>

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr>
				<td colspan="8" bgcolor="#e8f0f3">
					搜索
				</td>
			</tr>
			<tr>
				<td colspan="8" bgcolor="#FFFFFF" align="center">
					<form action="admin/shop/sort_showAllSrot.action" method="post">
						<table border="0">
							<tr>
								<td>
									类别名称：
								</td>
								<td>
								<input type="hidden" name="pageId" value="1">
									<input type="text" name="catName" id="proName" />
								</td>
								<td>上级类别名称:</td>
								<td>
										<label>
												<select name="categoryName" id="select">
														<option value=" ">所有的类别</option>
														<c:forEach items="${goodsList}" var="gl">
															<option value="${gl.categoryid }">${gl.categoryname }</option>
														</c:forEach>
												</select>
										</label>
								</td>
								<td>热销类：
								</td>
								<td>
									<select name="isSell" id="proIsenable">
										<option value=" ">
											全部
										</option>
										<option value="1">
											是
										</option>
										<option value="0">
											否
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
				<td height="24" colspan="8" background="skin/images/tbg.gif">
					&nbsp;类别列表&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td>
					类别名称
				</td>
				<td>上级类别名称</td>
				<td>
					是否热销</td>
				<td>商品数量</td>
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
			<c:choose>
			<c:when test="${empty result.content}">
			<tr>
				<td colspan="8" style="text-align: center; font-size: 24px;">没有要搜索的结果!</td>
			</tr>
			</c:when>
			<c:otherwise>
			<c:forEach  items="${result.content}" var="srot">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${srot.categoryname }</u>
					</td>
					<td>
						<u>
							<c:choose>
								<c:when test="${empty srot.goodesCategory}"></c:when>
								<c:otherwise>${srot.goodesCategory.categoryname}</c:otherwise>
							</c:choose>
						 </u>
					</td>
					<td>
						<u> ${srot.ishot == '0' ?'否':'是' }</u>
					</td>
					<td><u>${srot.goodsnum }</u></td>
					<td>
						<u>${srot.orderlist } </u>
					</td>
					<td>
						<U> 
						<fmt:formatDate value="${srot.createdate }" pattern="yyyy-MM-dd"/>
						</U>
					</td>
					<td>
						<U>
						<fmt:formatDate value="${srot.modifydate }" pattern="yyyy-MM-dd"/>
						</U>
					</td>
					<td>
						<a
							href="admin/shop/sort_byIdQuery.action?categoryName=${srot.categoryid }">修改</a>&nbsp;
						|&nbsp;
						<a href="admin/shop/sort_deleteSrot.action?categoryName=${srot.categoryid }"
							onClick="return(confirm('確定刪除?'))">删除</a>
					</td>
				</tr>
			</c:forEach>
				<tr bgcolor="#e8f6ff">
					<td class="nv" colspan="8">
						<form id="form1" action="admin/shop/sort_showAllSrot.action"
							method="post">
							<t:tpage formId="form1" pageDiv="page" page="${result.page}"
							goImg="img/learning_img/gog.gif"></t:tpage>
						</form>
					</td>
				</tr>
			</c:otherwise>
			</c:choose>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
