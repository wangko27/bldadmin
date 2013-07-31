<%@ page language="java" pageEncoding="utf-8"%>
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

		<title>menu</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


		<link rel="stylesheet" href="admin/skin/css/base.css" type="text/css" />
		<link rel="stylesheet" href="admin/skin/css/menu.css" type="text/css" />

		<script language='javascript'>var curopenItem = '1';</script>
		<script language="javascript" type="text/javascript"
			src="admin/skin/js/frame/menu.js"></script>
		<base target="main" />
	</head>

	<body target="main">
		<table width='150' height="351" border='0' cellspacing='0'
			cellpadding='0'>
			<tr>
				<td style='padding-left: 3px; padding-top: 8px' valign="top">

					<!-- Item 1 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items1_1")'>
							<b>管理员</b>
						</dt>
						<dd style='display: block' class='sitem' id='items1_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/admin_add.jsp" target="main">添加管理员</a>
								</li>
								<li>
									<a href="admin/adminList.action" target="main">管理员管理</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 1 End -->

					<!-- Item 2 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items2_1")'>
							<b>科目代码</b>
						</dt>
						<dd style='display: block' class='sitem' id='items2_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/subjectCode_add.jsp" target="main">添加科目代码</a>
								</li>
								<li>
									<a href="admin/subjectCodeList.action" target="main">科目代码管理</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 2 End -->

					<!-- Item 3 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items3_1")'>
							<b>网站位置内容管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items3_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/locationInfoAddBef.action" target="main">添加网站位置</a>
								</li>
								<li>
									<a href="admin/locationInfoList.action" target="main">网站位置管理</a>
								</li>
								<li>
									<a href="admin/webContent_add.jsp" target="main">添加网站内容</a>
								</li>
								<li>
									<a href="admin/webContentList.action" target="main">网站内容管理</a>
								</li>
								<li>
									<a href="admin/locContentSrc.action" target="main">添加网站位置关联内容</a>
								</li>
								<li>
									<a href="admin/locContentList.action" target="main">管理网站位置关联内容</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 3 End -->

					<!-- Item 4 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items4_1")'>
							<b>网站导航管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items4_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/navigationAddBef.action" target="main">添加导航信息</a>
								</li>
								<li>
									<a href="admin/navigationList.action" target="main">导航管理</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 4 End -->

					<!-- Item 5 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items5_1")'>
							<b>网站广告管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items5_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/navigationAddBef.action" target="main">添加广告信息</a>
								</li>
								<li>
									<a href="admin/navigationList.action" target="main">广告管理</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 5 End -->

					<!-- Item 6 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items6_1")'>
							<b>学习频道管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items6_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/articleType!addPage.action" target="main">添加文章类别</a>
								</li>
								<li>
									<a href="admin/articleType!manage.action" target="main">文章类别管理</a>
								</li>
								<li>
									<a href="admin/article!addPage.action" target="main">添加文章</a>
								</li>
								<li>
									<a href="admin/article!addPage.action?type=school" target="main">添加名校风采</a>
								</li>
								<li>
									<a href="admin/article!manage.action" target="main">文章管理</a>
								</li>
							
								<li>
									<a href="admin/readType!addPage.action" target="main">添加博览群书类别</a>
								</li>
								<li>
									<a href="admin/readType!manage.action" target="main">博览群书类别管理</a>
								</li>
								<li>
									<a href="admin/readbook!addPage.action" target="main">添加博览群书</a>
								</li>
								<li>
									<a href="admin/readbook!manage.action" target="main">博览群书管理</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 6 End -->
					
					<!-- Item 7 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items7_1")'>
							<b>兴趣频道管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items7_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/interest/programa/add.jsp" target="main">添加活动栏目</a>
								</li>
								<li>
									<a href="admin/programa!manage.action" target="main">活动栏目管理</a>
								</li>
								<li>
									<a href="admin/activityType!addPage.action" target="main">添加活动类别</a>
								</li>
								<li>
									<a href="admin/activityType!manage.action" target="main">活动类别管理</a>
								</li>
								<li>
									<a href="admin/activity!addPage.action" target="main">添加活动</a>
								</li>
								<li>
									<a href="admin/activity!manage.action" target="main">活动管理</a>
								</li>
								<li>
									<a href="admin/interest/worksshow/add.jsp" target="main">添加首页活动作品展示</a>
								</li>
								<li>
									<a href="admin/worksShow!manage.action" target="main">首页活动作品展示管理</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 7 End -->
					
						<!-- Item 8 trat -->
					<dl class='bitem'>
						<dt onClick='showHide("items8_1")'>
							<b>系统文章管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items8_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/SysArticletype!list.action" target="main">系统文章类别管理</a>
								</li>
								<li>
									<a href="admin/SysArticletype!addPage.action" target="main">添加系统文章类别</a>
								</li>
								<li>
									<a href="admin/SysArticle!addPage.action" target="main">添加系统文章</a>
								</li>
								<li>
									<a href="admin/SysArticle!list.action" target="main">文章管理</a>
								</li>
							</ul>
						</dd>
					</dl>
					<!-- Item 8 End -->
				</td>
			</tr>
		</table>
	</body>
</html>
