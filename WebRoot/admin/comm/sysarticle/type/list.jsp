<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
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
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<SCRIPT type="text/javascript">
		//类别改变，如果有子类，显示子类
			function typeChange(typeid,level){
				$.ajax({
					type:"post",
					url:"admin/SysArticletype!searchCildrentype.action",
					data:{
						articletypeid:typeid,
						level:level
					},
					dataType:"text",
					success:function(msg){
						if(msg!=""){
							$("#spantype"+level).html(msg);
							$("#level").val((level+1));
						}else{
							$("#spantype"+level).html("");
							$("#level").val(level);
						}
					},
					error:function(xhr,msg,e){
						alert(msg);
					}
				});
			}
			function test(typeid,level){
				$.ajax({
					type:"post",
					url:"admin/SysArticletype!searchresult.action",
					data:{
						articletypeid:typeid,
						level:level
					},
					dataType:"text",
					success:function(msg){
						if(msg!=""){
							alert(msg);
						}else{
							alert(msg);
						}
					},
					error:function(xhr,msg,e){
						alert(msg);
					}
				});
			}
		</SCRIPT>
	</head>

	<body>
		<div class="maindiv">
			<h1>
				系统文章管理&mdash;&mdash;文章类别管理
			</h1>
		</div>
		<form action="admin/SysArticletype!listCildrentype2.action" method="post" name="search" id="search">
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr>
				<td colspan="8" bgcolor="#e8f0f3">
					搜索
				</td>
			</tr>
			<tr>
				<td colspan="8" bgcolor="#FFFFFF" align="center">
								<input type="hidden" name="level" id="level" value="0">
						<table border="0">
							<tr>
								<td>
									<font color=red>查询类别</font>：
								</td>
								<td>
									<select name="articletypeid0" id="articletypeid0" onchange="typeChange(this.value,0)">
										<option value="">
											请选择上级类别
										</option>
										<c:forEach items="${ParentTypes}" var="st" varStatus="vs">
										<option value="${st.articletypeid }">
												${st.articletypename }
											</option>
										</c:forEach>		
									</select>
									<span id="spantype0"></span>
								</td>
								<td>
									<input type="submit" value="搜索" class="sst" />
								</td>
							</tr>
						</table>
				</td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="5" background="skin/images/tbg.gif">
					&nbsp;文档列表&nbsp;&nbsp;&nbsp;&nbsp;<a href="admin/SysArticletype!list.action" title="点击查询全部类别"><font color=red>查询全部</font></a>
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td>
					类别名称
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
			<c:forEach items="${list_articleType}" var="a">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u><c:if test="${not empty a.articleTypes}"><a href="admin/SysArticletype!listCildrentype.action?sysArticleType.articletypeid=${a.articletypeid}" title="根据上级类别查询"></c:if>${a.articletypename }<c:if test="${not empty a.articleTypes}"></a></c:if></u>
					</td>
					<td>
						<u>${a.articlesort }</u>
					</td>
					<td>
						<U> <fmt:formatDate value="${a.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</U>
					</td>
					<td>
						<U> <fmt:formatDate value="${a.modifydate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</U>
					</td>
					<td>
						<a
							href="admin/SysArticletype!updatePage.action?articletypeid=${a.articletypeid }">修改</a>&nbsp;
						|&nbsp;
						<a
							href="admin/SysArticletype!delete.action?articletypeid=${a.articletypeid }"
							onClick="return(confirm('確定刪除?'))">删除</a>
					</td>
				</tr>
				<tr>
					<td class="nv" colspan="6" align="right">
						&nbsp;
					</td>
				</tr>
			</c:forEach>
			<tr bgcolor="#e8f6ff">
				<td class="nv" colspan="6">
					<t:tpage formId="search" pageDiv="page"
						page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
				</td>
			</tr>
		</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>