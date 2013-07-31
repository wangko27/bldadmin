<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>学习频道头部</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/learning_common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>


		<script type="text/javascript">
			
			function showmodule(index){
				$(".learning_menu ul li").each(function(i){
					if(index==i){
						$(this).find("a").addClass("dizhu");
					}else{
						$(this).find("a").removeClass("dizhu");
					}
				});
			}
			function isSubmit(){
				var name=$("#topName").val();
				if(name==''){
					alert("请输入关键字!");
					return false;
				}else{
					topForm.submit();;
				}
				return false;
			}
		</script>
		
		<%
			String liindex="0";
			if(null!=request.getParameter("liindex")){
				liindex=request.getParameter("liindex");
			}
		 %>
	</head>

	<body onload="showmodule(<%=liindex %>)">
		<jsp:include page="/base/top.jsp"></jsp:include>
		<jsp:include page="/base/toplink.jsp"></jsp:include>
		<div class="mainbody">
			<div class="logo_ll">
		<form action="<%=basePath %>learn/schools_toPage.action" method="post" name="topForm">
			<ul>
				<li class="img">
						<a href="learn/xx_index.action?liindex=0" target="_blank"><img src="img/learning_img/learninglogo.gif" /> </a>
					</li>
				<% if(liindex.equals("1")||liindex.equals("5")){ %>
					<li>
						<select name="subjectcode">
							<s:action name="public!getSubjectCodeAll" executeResult="false"></s:action>
							<s:iterator value="#request.list_subjictCode" id="sub" status="s">
								<option value="${sub.subjectcode}">${sub.subjectname}</option>
							</s:iterator>
						</select>
					</li>
					<%}else{ %>
						<li>关键字:</li>
					<%} %>
					<li>
						<input type="hidden" name="liindex" value="<%=liindex %>">
						<input type="text" value="" id="topName" name="selectInfo"/>
						<a href="#" onclick="return isSubmit();"><img src="img/learning_img/go.gif" /> </a>
				</li>
			</ul>
		</form>
			</div>
		</div>
		<div class="mainbody">
			<div class="learning_menu">
				<ul>
					<li>
						<a href="learn/xx_index.action?liindex=0">学习首页</a>
					</li>
					<li>
						<a href="learn/oneday_showOneDayOneText.action?liindex=1">一天一课</a>
					</li>
					<li>
						<a href="learn/pinxue_showPinXue.action?liindex=2">品学论道</a>
					</li>
					<li>
						<a href="learn/teacherbema_showTeachers.action?liindex=3">名师讲坛</a>
					</li>
					<li>
						<a href="learn/schools_showSchools.action?liindex=4">名校风采</a>
					</li>
					<li>
						<a href="learn/readbook!list.action?liindex=5">博览群书</a>
					</li>
				</ul>
			</div>
			<div class="commongao"></div>
		</div>
	</body>
</html>