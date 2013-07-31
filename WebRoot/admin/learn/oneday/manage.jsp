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

		<title>学习频道管理&mdash;&mdash;一天一课管理</title>

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
				学习频道管理&mdash;&mdash;一天一课管理
			</h1>
		</div>

		<form action="admin/learn/oneday!openOneday.action" method="post"
			name="form_oneday" id="form_oneday">
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
									标题：
								</td>
								<td>
									<input type="text" name="readsrctile" id="readsrctile"
										value="${param.readsrctile }" />
								</td>
								<td>
									年级：
								</td>
								<td style="word-break: break-all">
									<select name="gradecode" id="gradecode">
										<option value="">
											所有
										</option>
										<s:iterator value="gradeCodeAll" id="g">
											<option value="${g.gradecode }"
												<c:if test="${g.gradecode==param.gradecode }">selected</c:if>>
												${g.gradename }
											</option>
										</s:iterator>
									</select>
								</td>
								<td>
									科目：
								</td>
								<td style="word-break: break-all">
									<select name="subjectcode" id="subjectcode">
										<option value="">
											所有
										</option>
										<s:iterator value="subjectCodeAll" id="s">
											<option value="${s.subjectcode }"
												<c:if test="${s.subjectcode==param.subjectcode }">selected</c:if>>
												${s.subjectname }
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
					<td height="24" colspan="7" background="skin/images/tbg.gif">
						&nbsp;文档列表&nbsp;
					</td>
				</tr>
				<tr align="center" bgcolor="#e8f0f3" height="22">
					<td>
						标题
					</td>
					<td>
						年级
					</td>
					<td>
						科目
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
				<s:iterator value="#request.list_readSrc" id="r">
					<tr align="center" bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#e8f6ff';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td width="280">
							<u>${r.readsrctile }</u>
						</td>
						<td>
							<u>${r.gradeCode.gradename }</u>
						</td>
						<td>
							<u>${r.subjectCode.subjectname }</u>
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
								href="admin/learn/oneday!openModifyOneday.action?readsrcid=${r.readsrcid }">修改</a>&nbsp;
							|&nbsp;
							<a
								href="admin/learn/oneday!deleteOneday.action?readsrcid=${r.readsrcid }"
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
					<td class="nv" colspan="7">
						<t:tpage formId="form_oneday" pageDiv="page" page="${result.page}"
							goImg="img/learning_img/gog.gif"></t:tpage>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
