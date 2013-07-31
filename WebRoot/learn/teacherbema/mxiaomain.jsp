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
		<link href="<%=basePath%>learn/css/clearbox.css" rel="stylesheet"
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
	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<a href="learn/schools_showSchools.action?liindex=4">名校风采</a> >
				<span>${school.schoolname }</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="maind_1">
						${school.schoolname }
					</div>
					<div class="maind_2">
						<form action="" method="post" name="formRestriction"
							id="formRestriction">
							<input type="hidden" name="articlesrcid" id="articlesrcid"
								value="${school.articlesrcid }" />
							<input type="hidden" name="articlesrcId" id="articlesrcId"
								value="${school.articlesrcid }" />
							<input type="hidden" name="liindex" id="liindex" value="4" />
							<input type="hidden" name="forwardurl" id="forwardurl"
								value="schoolview" />
							<c:if test="${flag==1}">
								<script>
									copyurl(window.location.href);
								</script>
							</c:if>	
						</form>
						<span class="s1"><fmt:formatDate
								value="${school.createdate }" pattern="yyyy-MM-dd HH:mm:ss" />
						</span>
						<span class="s2"><a href="#" id="a_share"><img
									src="<%=basePath%>img/learning_img/fen_1.gif" /> </a>${school.sharenum
							}</span>
						<span class="s3"><a href="#" id="a_collect"><img
									src="<%=basePath%>img/learning_img/fen_2.gif" /> </a>${school.collectionnum
							}</span>
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
						<%-- 
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
						--%>
						
				     	<!-- JiaThis Button BEGIN -->
						<div id="ckepop">
							<a class="jiathis_button_qzone">QQ空间</a>
							<a class="jiathis_button_tsina">新浪微博</a>
							<a class="jiathis_button_renren">人人网</a>
							<a class="jiathis_button_kaixin001">开心网</a>
							<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank">更多</a>
							<a class="jiathis_counter_style"></a>
						</div>
						<script type="text/javascript" src="http://v2.jiathis.com/code/jia.js" charset="utf-8"></script>
						<!-- JiaThis Button END -->
							
					</div>
					<div class="maind_5">
						<h1>
							学校相册：
						</h1>
						<div class="xiangce" id="listBox">
							<p>
								<img src="<%=basePath%>img/learning_img/fa1.gif"
									onclick="toup()" style="cursor: pointer;" />
							</p>
							<div>
								<ul id="lis">
									<!--<c:if test="${empty album.str_picture}">
										<li>
											<a href="<%=basePath%>img/learning_img/tu6.gif"
												rel="clearbox"><img
													src="<%=basePath%>img/learning_img/tu6.gif" border="0" />
											</a>
										</li>
									</c:if>-->
								</ul>
								<ul id="lisPics" style="display: none">
									<c:choose>
										<c:when test="${numPic==1}">
											<li>
												<a
													href="<%=basePath%>${album.albumPath}/${album.pictures[0] }"
													rel="clearbox[test1]"> <img
														src="<%=basePath%>${album.albumPath}/${album.pictures[0] }" />
												</a>
											</li>
										</c:when>
										<c:otherwise>
											<c:forEach items="${album.pictures}" var="pic">
												<li>
													<a href="<%=basePath%>${album.albumPath}/${pic }"
														rel="clearbox[test1]"> <img
															src="<%=basePath%>${album.albumPath}/${pic }" /> </a>
												</li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</ul>
								<script language="javascript" src="<%=basePath%>learn/js/pic.js"></script>
								<script src="<%=basePath%>learn/js/clearbox.js"
									type="text/javascript"></script>
								<script language="javascript">
									init();
								</script>
								<p>
									<img src="<%=basePath%>img/learning_img/fa2.gif"
										onclick="todown()" style="cursor: pointer;" />
								</p>
							</div>
						</div>
					</div>
					<div class="maind_4">
						<ul>
							<li class="bbt">
								相关阅读：
							</li>
							<c:choose>
								<c:when test="${empty listsrc}">
									<li>
										无相关阅读
									</li>
								</c:when>
								<c:otherwise>
									<c:forEach items="${listsrc}" var="src">
										<li>
											<a
												href="<%=basePath%>learn/teacherbema_showSchool.action?articlesrcId=${src.articlesrcid }">${src.schoolname
												}</a>
											<span>${src.createdate }</span>
										</li>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp" />
			</div>
		</div>
		<jsp:include page="/base/bottom.jsp"></jsp:include>

		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>

