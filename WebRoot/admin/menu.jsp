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
					 <%--Item 1 End --%>


					<!-- Item 9 trat -->
					<dl class='bitem'>
						<dt onClick='showHide("items9_1")'>
							<b>商城频道管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items9_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/shop/sort_showAddPage.action" target="main">商品类别添加</a>
								</li>
								<li>
									<a href="admin/shop/sort_showAllSrot.action" target="main">商品类别管理</a>
								</li>
								<li>
									<a href="admin/shopping/ware/add.jsp" target="main">添加商品</a>
								</li>
								<li>
									<a href="admin/shop/goods_show.action" target="main">商品管理</a>
								</li>
								<li>
									<a href="admin/shop/order!manage.action">订单管理</a>
								</li>
                                <li>
                                    <a href="admin/feeTemplate/showAll.action">运费模板管理</a>
                                </li>
                            </ul>
						</dd>
					</dl>
					<!-- Item 9 End -->
					<!-- Item 10 trat -->
					<dl class='bitem'>
						<dt onClick='showHide("items10_1")'>
							<b>广告频道管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items10_1'>
							<ul class='sitemu'>
								<li>
									<a href="admin/adv/add.jsp" target="main">添加广告</a>
								</li>
                                <li>
                                    <a href="admin/adv/select_showAdv.action" target="main">广告管理</a>
                                </li>
                                <li>
                                    <a href="admin/advLocation/showAllAdvLocation.action" target="main">广告位置管理</a>
                                </li>

                                <%--<li>--%>
                                    <%--<a href="admin/notice/add.jsp" target="main">添加公告</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="admin/notice/select_showNotice.action" target="main">公告管理</a>--%>
                                <%--</li>--%>
							</ul>
						</dd>
					</dl>
					<!-- Item 10 End -->

                    <!-- Item 12 trat -->
                    <dl class='bitem'>
                        <dt onClick='showHide("items12_1")'>
                            <b>推荐管理</b>
                        </dt>
                        <dd style='display: block' class='sitem' id='items12_1'>
                            <ul class='sitemu'>
                                <%--<li>--%>
                                    <%--<a href="admin/recommend/showPptPic.action" target="main" >首页轮播图片推荐</a>--%>
                                <%--</li>--%>
                                <li>
                                    <a href="<%=basePath%>admin/recommend/showHotGoods.action" target="main" >热销商品列表</a>
                                </li>
                                    <li>
                                        <a href="<%=basePath%>admin/miaosha/showMiaoShaGoods.action" target="main" >商品秒杀管理</a>
                                    </li>
                                 <li>
                                     <a href="<%=basePath%>admin/recommend/showArticleList.action" target="main">文章管理</a>
                                    </li>
                               </ul>
                        </dd>
                    </dl>
                    <!-- Item 11 End -->
				</td>
			</tr>
		</table>
	</body>
</html>
