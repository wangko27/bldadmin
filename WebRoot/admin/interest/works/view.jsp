<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/interesting/moban.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/interesting/motyss.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<div class="mmaind">
			<div class="mmright">
				<div class="ritu_1">
					<h1>
						<span>参赛作品</span>
					</h1>
					<div class="zzpp">
						<p>
							<a href="#"><img src="${works.facepath }"
									width="203" height="248" />
							</a>
						</p>
						<ul>
							<li class="hti">
								<b>${works.workstitle }</b><span id="vot">票数：${works.votes}</span>
							</li>
							<li>
								编号：${works.worksnumber }
							</li>
							<li>
								作者：${works.author }
							</li>
							<li>
								时间：${works.createdate }
							</li>
							<li class="jianjie">
								作品简介：
								<br />
								<span>${works.worksintro }</span>
							</li>
						</ul>
					</div>
					<div class="zuop">
						作品介绍
					</div>
					<img src="<%=basePath%>${works.showsrc }" width="600" />
					<div class="neirr">
						${works.workscontent }
					</div>
					
				</div>
			</div>
		</div>
	</body>
</html>
