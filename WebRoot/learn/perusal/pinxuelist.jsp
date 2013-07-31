<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%
			String articleTypeid = request.getParameter("id");
			if (null == articleTypeid) {
				articleTypeid = "0";
			}
		%>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/learning_common.css" rel="stylesheet" type="text/css" />
		<link href="css/bolist.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>



		<script type="text/javascript">
		//设置查询类别
			function setarticleType(articleTypeid){
				if(articleTypeid==0){
					$("#ar").val('');
				}else{
					$("#ar").val('1');
				}
				$("#articleTypeid").val(articleTypeid);
				$("#articlelist").submit();
				return false;
			}
			
			//设置当前选中的选项
			function showorder(index){
				$(".dda ul li").each(function(i){
					if(index==i){
						$(this).addClass("dibai");
					}else{
						$(this).removeClass("dibai");
					}
				});
			}
			$().ready(function(){
				showorder(<%=articleTypeid%>);
			});
		
		</script>


	</head>


	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<form action="learn/pinxue_showPinXue.action" method="post"
			name="articlelist" id="articlelist">
			<input name="liindex" type="hidden" value="2" />
			<input name="id" type="hidden" value="${id }"
				id="articleTypeid" />
			<input name="type" type="hidden" id="ar" />
		
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action">学习</a> >
				<span>品学论道</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="titi">
						<img src="img/learning_img/tit_3.gif" />
					</div>

					<div class="dda">
						<ul>
							<li class="dibai">
								<a href="#" onclick="return setarticleType('0')">全部</a>
							</li>
							<li>
								<a href="#" onclick="return setarticleType('1')">学生</a>
							</li>
							<li>
								<a href="#" onclick="return setarticleType('2')">家长</a>
							</li>

							<li>
								<a href="#" onclick="return setarticleType('3')">老师</a>
							</li>
						</ul>
					</div>
					<div class="list_3">
						<c:choose>
						<c:when test="${empty pins}"><ul><li>暂时没有数据</li></ul></c:when>
						<c:otherwise>
						<c:forEach items="${pins}" var="pin" varStatus="vs">
							<c:if test="${vs.index%5==0}">
								<ul>
							</c:if>
							<li>
								<p>
									<a
										href="<%=basePath%>learn/PerusalArticle!getArticleById.action?id=${pin.articlesrcid}&liindex=2">${pin.articletitle
										}</a>
								</p>
								<span><fmt:formatDate value="${pin.createdate}"
										pattern="yyyy-MM-dd" />
								</span>
							</li>
							<c:if test="${vs.index%5==4 }">
								</ul>
							</c:if>
						</c:forEach>
						</c:otherwise>
						</c:choose>
					</div>
					<div class="page">
						<t:tpage formId="articlelist" pageDiv="page" page="${result.page}"
							goImg="img/learning_img/gog.gif"></t:tpage>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp"></jsp:include>
			</div>
		</div>
		</form>
		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>