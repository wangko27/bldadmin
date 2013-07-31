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

		<title>指导老师管理</title>

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
						$("#form_teacher").attr("action","admin/AddTeacher.action");
						$("#form_teacher").submit();
					}else{
						alert("请至少选择一位老师!");
					}
				});
				
			});
			
			function checkTeacher(){
				if($("#nikename").val()==""){
					alert("请输入老师名字!");
					return false;
				}
				$("#form_teacher").attr("admin/teacher!seachTeacher.action");
			}
		</script>

	</head>

	<body>
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash; ${activity.activitytitle } &mdash;&mdash;
				指导老师管理
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
					<form action="admin/teacher!seachTeacher.action" method="post"
						name="form_teacher" id="form_teacher" onsubmit="return checkTeacher()">
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
										value="${param.nikename }"/>
								</td>
								<td>
									<input type="submit" value="搜索" name="btnSeach" id="btnSeach"
										class="sst" />
								</td>
								<td>
									<input type="button" value="添加" name="btnAdd" id="btnAdd"
										class="sst" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<s:iterator value="#request.list_member" id="member">
										<input type="checkbox" name="memberid" id="memberid"
											value="${member.memberid }" 
											<s:iterator value="#request.list_teacher" id="teacher">
												<s:if test="#teacher.member.memberid==#member.memberid">disabled</s:if>
											</s:iterator>
											>
										${member.nikename }
									</s:iterator>
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
			<s:iterator value="#request.list_teacher" id="teacher">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${teacher.member.nikename }</u>
					</td>
					<td>
						<u> <s:if test="#request.teacher.isrecomment==1">已推荐</s:if> <s:else>未推荐</s:else>
						</u>
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
						<s:if test="#request.teacher.isrecomment==1">
							<a
								href="admin/teacher!cancelRecomment.action?id=${teacher.id }&activityid=${activity.activityid }">取消推荐</a>
						</s:if>
						<s:else>
							<a
								href="admin/teacher!recomment.action?id=${teacher.id }&activityid=${activity.activityid }">推荐</a>
						</s:else>
						|&nbsp;
						<a
							href="admin/teacher!delete.action?id=${teacher.id }&activityid=${activity.activityid }"
							onClick="return(confirm('確定刪除?'))">删除</a>
					</td>
				</tr>
				<tr>
					<td class="nv" colspan="7" align="right">
						&nbsp;
					</td>
				</tr>
			</s:iterator>

		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
