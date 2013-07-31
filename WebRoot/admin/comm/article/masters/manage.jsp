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

		<title>名师管理</title>

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
					if($("input[name='memberid']:checked").length>0){
						$("#form_teacher").attr("action","admin/article!toAddMasters.action");
						$("#form_teacher").submit();
					}else{
						alert("请至少选择一位老师!");
					}
				});
				
				//搜索
				$("#btnSeach").bind("click",function(){
					$("#form_teacher").attr("admin/teacher!seachTeacher.action");
					$("#form_teacher").submit();
				});
			});
		</script>

	</head>

	<body>
		<div class="maindiv">
			<h1>
				学习频道管理&mdash;&mdash; 名师管理
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
					<form action="admin/article!seachTeacher.action" method="post"
						name="form_teacher" id="form_teacher">
						<s:token></s:token>
						<input type="hidden" name="activityid" id="activityid"
							value="${activity.activityid }" />
						<table>
							<tr>
								<td>
									老师名称：
								</td>
								<td>
									<input type="text" name="nikename" id="nikename"
										value="${param.nikename }" />
								</td>
								<td>
									<input type="submit" value="搜索" name="btnSeach" id="btnSeach"
										class="sst" />
								</td>
								<td>
									<input type="button" value="设为名师" name="btnAdd" id="btnAdd"
										class="sst" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<table>
										<tr>
											<s:iterator value="#request.list_member" id="member">
												<td>
													<input type="checkbox" name="memberid" id="memberid"
														value="${member.memberid }"
														<s:iterator value="#request.list_masters" id="masters">
												<s:if test="#masters.memberid==#member.memberid">disabled</s:if>
											</s:iterator>>
													${member.nikename }
												</td>
											</s:iterator>
										</tr>
									</table>
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
					老师名称
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="#request.list_masters" id="masters">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${masters.nikename }</u>
					</td>
					<td>
						<a
							href="admin/article!toCancelMasters.action?memberid=${masters.memberid }" onClick="return(confirm('確定取消?'))">取消名师资格</a>

						|&nbsp;
						<a
							href="admin/article!openAddMastersArticle.action?memberid=${masters.memberid }&nikename=${masters.nikename }" >添加文章</a> |&nbsp;
						<a
							href="admin/article!openMastersArticle.action?memberid=${masters.memberid }&nikename=${masters.nikename }" >文章管理</a>
					</td>
				</tr>
				<tr>
					<td class="nv" colspan="7" align="right">
						&nbsp;
					</td>
				</tr>
			</s:iterator>
			<tr bgcolor="#e8f6ff">
				<td class="nv" colspan="8">
					<form id="form1" action="admin/article!openMasters.action" method="post">
					</form>
					<t:tpage formId="form1" pageDiv="page" page="${result.page}"
						goImg="img/learning_img/gog.gif"></t:tpage>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
