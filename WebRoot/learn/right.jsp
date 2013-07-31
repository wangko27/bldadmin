<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<title>学习频道右边</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<script src="<%=basePath%>learn/teacherbema/js/xing.js"></script>
	</head>

	<body>
		<s:action name="together" executeResult="false"></s:action>

		<div class="listright">
			<div class="cetit">
				系统公告
			</div>
			<div class="listwen">
				<c:forEach items="${infos}" var="info">
					<!-- 
					<a
						href="<%=basePath%>learn/teacherbema_showSysInfo.action?sysInfoId=${info.articleid }&liindex=1">${fn:substring(info.articletitle,0,15)}</a>
					 -->
					<a href="Article/viewSysById.action?id=${info.articleid }"
						target="_blank" title="${info.articletitle }">${fn:substring(info.articletitle,0,15)}</a>
				</c:forEach>
			</div>
			<div class="cetit">
				博览群书
			</div>

			<div class="tu_zi">
				<ul>
					<li class="img_1">
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[0].readsrcid }"><img
								src="${readSrcs[0].photopath }" /> </a>
					</li>
					<li class="yu">
						<span><a
							href="learn/readbook!list.action?subjectcode=${readSrcs[0].subjectCode.subjectcode}&subjectname=${readSrcs[0].subjectCode.subjectname}&liindex=5">[${readSrcs[0].subjectCode.subjectname}]</a>
						</span>
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[0].readsrcid }"
							title="${readSrcs[0].readsrctile }">${fn:substring(readSrcs[0].readsrctile,0,15)
							}</a>
					</li>
					<li id="li1">
						<script>
          				showXin('li1',${(readSrcs[1].generalscore==null ? 0:readSrcs[0].generalscore)/readSrcs[0].ratingnum },'<%=basePath%>');
          			</script>
						<c:choose>
							<c:when test="${readSrcs[0].ratingnum==0}">
								<span>&nbsp;0 分</span>
							</c:when>
							<c:otherwise>
								<span>&nbsp;<fmt:formatNumber type="number" value="${readSrcs[0].generalscore/readSrcs[0].ratingnum }" maxFractionDigits="0"/>
          					分</span>
							</c:otherwise>
						</c:choose>
					</li>
					<li class="xia">
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[0].readsrcid }"><img
								src="<%=basePath%>img/common_img/xiazai.gif" /> </a>
					</li>
				</ul>
				<ul>
					<li class="img_1">
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[1].readsrcid }"><img
								src="${readSrcs[1].photopath }" /> </a>
					</li>
					<li class="yu">
						<span><a
							href="learn/readbook!list.action?subjectcode=${readSrcs[1].subjectCode.subjectcode}&subjectname=${readSrcs[1].subjectCode.subjectname}&liindex=5">[${readSrcs[1].subjectCode.subjectname}]</a>
						</span>
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[1].readsrcid }"
							title="${readSrcs[1].readsrctile }">${fn:substring(readSrcs[1].readsrctile,0,15)
							}</a>
					</li>
					<li id="li2">
						<script>
          	showXin('li2',${(readSrcs[1].generalscore==null ? 0:readSrcs[1].generalscore)/readSrcs[1].ratingnum },'<%=basePath%>');
          </script>
						<c:choose>
							<c:when test="${readSrcs[1].ratingnum==0}">
								<span>&nbsp;0 分</span>
							</c:when>
							<c:otherwise>
								<span>&nbsp;<fmt:formatNumber type="number" value="${readSrcs[1].generalscore/readSrcs[1].ratingnum }" maxFractionDigits="0"/>分</span>
							</c:otherwise>
						</c:choose>
					</li>
					<li class="xia">
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[1].readsrcid }"><img
								src="<%=basePath%>img/common_img/xiazai.gif" /> </a>
					</li>
				</ul>
				<ul class="zi">
					<li>
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[2].readsrcid }"
							title="${readSrcs[2].readsrctile }">${fn:substring(readSrcs[2].readsrctile,0,15)
							}</a>
					</li>
					<li>
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[3].readsrcid }"
							title="${readSrcs[3].readsrctile }">${fn:substring(readSrcs[3].readsrctile,0,15)
							}</a>
					</li>
					<li>
						<a
							href="learn/readbook!view.action?readsrcid=${readSrcs[4].readsrcid }"
							title="${readSrcs[4].readsrctile }">${fn:substring(readSrcs[4].readsrctile,0,15)
							}</a>
					</li>
				</ul>
			</div>
			<div class="cetit">
				名校-名师
			</div>
			<div class="xuetu1">
				<div class="jutu">
					<ul>
						<li class="qw_l">
							<a
								href="<%=basePath%>learn/teacherbema_showSchool.action?articlesrcId=${schools[0].articlesrcid }&liindex=4">
								<img src="${schools[0].coverpath }"
									width="69" height="91" /> </a>
							<p class="zii">
								<a
									href="<%=basePath%>learn/teacherbema_showSchool.action?articlesrcId=${schools[0].articlesrcid }&liindex=4">${schools[0].schoolname
									}</a>
							</p>
							<span class="shitu"> <img
									src="<%=basePath%>img/learning_img/shitu.gif" /> </span>
						</li>
						<li class="qw_r">
							<a
								href="<%=basePath%>learn/teacherbema_showSchool.action?articlesrcId=${schools[1].articlesrcid }&liindex=4">
								<img src="${schools[1].coverpath }"
									width="69" height="91" /> </a>
							<p class="zii">
								<a
									href="<%=basePath%>learn/teacherbema_showSchool.action?articlesrcId=${schools[1].articlesrcid }&liindex=4">${schools[1].schoolname
									}</a>
							</p>
							<span class="shitu"> <img
									src="<%=basePath%>img/learning_img/shitu.gif" /> </span>
						</li>
					</ul>
				</div>
				<div class="jutu">
					<ul>
						<li class="qw_l">
							<a
								href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${aticles[0].superTeacher.superTeacherID}&liindex=3">
								<img src="<%=basePath%>${aticles[0].superTeacher.teacherPath }"
									width="69" height="91" /> </a>
							<p class="zii">
								<a
									href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${aticles[0].superTeacher.superTeacherID}&liindex=3">${aticles[0].superTeacher.username
									}: ${aticles[0].articletitle }</a>
							</p>
							<span class="shitu"> <img
									src="<%=basePath%>img/learning_img/shitu.gif" /> </span>
						</li>
						<li class="qw_r">
							<a
								href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${aticles[1].superTeacher.superTeacherID}&liindex=3">
								<img src="<%=basePath%>${aticles[1].superTeacher.teacherPath }"
									width="69" height="91" /> </a>
							<p class="zii">
								<a
									href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${aticles[1].superTeacher.superTeacherID}&liindex=3">${aticles[1].superTeacher.username
									}: ${aticles[1].articletitle }</a>
							</p>
							<span class="shitu"><img
									src="<%=basePath%>img/learning_img/shitu.gif" /> </span>
						</li>
					</ul>
				</div>
				<div class="renmi">
					<c:forEach items="${teachers}" var="teacher">
						<a
							href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${teacher.superTeacherID }&liindex=3">
							${teacher.username }</a> | 
	        </c:forEach>
					;
				</div>
			</div>
			<div class="cetit">
				生活百科
			</div>
			<div class="listwen">
				<c:choose>
					<c:when test="${empty articls}">暂无生活百科</c:when>
					<c:otherwise>
						<c:forEach items="${articls}" var="artic">
							<a
								href="<%=basePath%>Article/getArticleById.action?id=${artic.articlesrcid }"
								title="${artic.articletitle }" target="_blank"><span>[${artic.articleType.articletypename
									}]</span> ${fn:substring(artic.articletitle,0,11) }</a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="cetit">
				读物畅销排行
			</div>
			<div class="dushu">
				<c:forEach items="${goodsList}" var="goods" varStatus="index">
					<ul class="zhai">
						<li class="hao">
							${index.index+1 }
						</li>
						<li>
							<a
								href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1"
								title="${goods.goodsname }" target="_blank">${fn:substring(goods.goodsname,0,13
								)}</a>
						</li>
					</ul>
					<ul class="kuan" style="display: none">
						<li class="hao1">
							${index.index+1 }
						</li>
						<li title="${goods.goodsname }">
							${fn:substring(goods.goodsname,0,13 )}
						</li>
						<li class="tut">
							<a
								href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1"><img
									src="<%=basePath%>${goods.photospath }" /> </a>
						</li>
						<li class="shuzi">
							￥${goods.marketprice }
						</li>
					</ul>
				</c:forEach>
			</div>
		</div>
	</body>
</html>
