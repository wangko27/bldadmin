<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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

		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/learning_common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/mshimain.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="">
			var ind=0;
			function showcontent(index){
				$("[id^='content']").each(function(i){
					if(index==i){
						$(this).show();
					}else{
						$(this).hide();
					}
				});
				return false;
			}
			function toUp(){
						ind--;
						if(ind<0){
							ind=0;
						}
						showcontent(ind);
						return false;
					}
			function toDown(len){
				 ind++;
				 if(ind>len-1){
					 	ind=len-1;
					}
				showcontent(ind);
				return false;
				}
		</script>
	</head>
	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<a href="#">系统公告</a> >
				<span>${article.articletitle }</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="maind_1">
						${article.articletitle }
					</div>
					<div class="maind_2">
						<span class="s1"> <fmt:formatDate
								value="${article.createdate }" pattern="yyyy-MM-dd HH:mm:ss" />
						</span>
					</div>
					<div class="maind_3">
						<div class="ppmm">
							<p>
								<c:forEach items="${content}" var="con" varStatus="index">
									<c:choose>
										<c:when test="${index.index==0}">
											<div id="content${index.index }">
												${con }
											</div>
										</c:when>
										<c:otherwise>
											<div id="content${index.index }" style="display: none">
												${con }
											</div>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</p>
						</div>
						<div class="page">
							<ul>
								<li>
									<a href="#" onclick="return showcontent(0)">首页</a>
								</li>
								<li>
									<a href="#" onclick="return toUp()">上一页</a>
								</li>
								<c:forEach begin="1" end="${srclength}" var="showindex"
									varStatus="ind">
									<li>
										<a href="#" onclick="return showcontent(${ind.index-1 })">${showindex
											}</a>
									</li>
								</c:forEach>
								<li>
									<a href="#" onclick="return toDown(${srclength})">下一页</a>
								</li>
								<li>
									<a href="#" onclick="return showcontent(${srclength-1 })">尾页</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="maind_4">
						<ul>
							<li class="bbt">
								相关阅读：
							</li>

							<c:forEach items="${list}" var="arc">
								<li>
									<a
										href="<%=basePath%>learn/teacherbema_showSysInfo.action?sysInfoId=${arc.articleid }">${arc.articletitle
										}</a>
									<span>${arc.createdate }</span>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp" />
	</body>
</html>
