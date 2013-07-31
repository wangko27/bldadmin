<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/learning_common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/mshimain.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="learn/js/articlehandle.js"></script>
		<script type="text/javascript">
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
	<body><jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<a href="learn/teacherbema_showTeachers.action?liindex=3">名师讲坛</a> >
				<a
					href="learn/teacherbema_showTeacherinfo.action?teacherId=${superAticle.superTeacher.superTeacherID }&liindex=3">${superAticle.superTeacher.username
					}</a> > 内页
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="maind_1">
						${art.articletitle }
					</div>
					<div class="maind_2">
						<form action="" method="post" name="formRestriction"
							id="formRestriction">
							<input type="hidden" name="articlesrcid" id="articlesrcid"
								value="${art.articlesrcid }" />
							<input type="hidden" name="articId" id="articId"
								value="${art.articlesrcid }" />
							<input type="hidden" name="liindex" id="liindex" value="4" />
							<input type="hidden" name="forwardurl" id="forwardurl"
								value="teacherview" />
							<c:if test="${flag==1}">
								<script>
									copyurl(window.location.href);
								</script>
							</c:if>
						</form>
						<span class="s1">${art.createdate}</span>
						<span class="s2"><a href="#" id="a_share"><img
									src="<%=basePath%>img/learning_img/fen_1.gif" /> </a>${art.sharenum}</span>
						<span class="s3"><a href="#" id="a_collect"><img
									src="<%=basePath%>img/learning_img/fen_2.gif" /> </a>${art.collectionnum}</span>
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
							<c:forEach items="${srcs}" var="ar">
								<li>
									<a
										href="<%=basePath%>learn/teacherbema_showTeacherArticleSrc.action?articId=${ar.articlesrcid }&liindex=3">${ar.articletitle
										}</a>
									<span> <fmt:formatDate value="${ar.createdate}"
											pattern="yyyy-MM-dd HH:mm:ss" /> </span>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp" /></div>
		</div>
		<jsp:include page="/base/bottom.jsp"></jsp:include>

		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>

