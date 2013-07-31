<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>博览群书列表页</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/learning_common.css" rel="stylesheet" type="text/css" />
		<link href="css/bolist.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> &gt;
				<a href="learn/xx_index.action?liindex=0">学习首页</a> &gt;
				<span>博览群书</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="titi">
						<img src="img/learning_img/tit_2.gif" />
					</div>
					<div class="dda">
						<ul>
							<li>搜索结果:</li>
						</ul>
					</div>
					<div class="list_2">
						<span class="ro1">资源</span>
						<span class="ro2">下载</span>
						<span class="ro3">评分</span>
					</div>
					<div class="list_1">
						<s:iterator value="#request.list_readSrc" id="readSrc" status="s">
							<ul <s:if test="#s.even"> class="lv" </s:if>>
								<li class="biti">
									<p class="kk">
										<a
											href="learn/readbook!view.action?readsrcid=${readSrc.readsrcid }&liindex=5"
											target="_blank">${readSrc.readsrctile }</a>
									</p>
									<p>
										<span class="dd1">${readSrc.downloadnum}</span>
									</p>
									<p>
										<span class="dd2"> <span id="spanxing${s.index}">
												<s:if test="#request.readSrc.generalscore==0">
													<script>
								        	showXin('spanxing${s.index}',0,'<%=basePath%>');
								        </script>
												</s:if> <s:else>
													<script>
								        	showXin('spanxing${s.index}',${(readSrc.generalscore==null ? 0:readSrc.generalscore)/readSrc.ratingnum },'<%=basePath%>');
								        </script>
												</s:else> </span> <b> &nbsp; <s:if
													test="#request.readSrc.generalscore==0">
								        	0
								        </s:if> <s:else><fmt:formatNumber type="number" value="${readSrc.generalscore/readSrc.ratingnum}" maxFractionDigits="0"/> </s:else> </b> 分</span>
									</p>
								</li>
								<li>
									<span>阅读(${readSrc.readnum }) | 分享(${readSrc.sharenum })
										| 收藏(${readSrc.collectionnum })</span>
								</li>
								<li
									style="height: 70px; overflow: hidden; text-overflow: ellipsis;">
									简介：${readSrc.contentintro }
								</li>
							</ul>
						</s:iterator>

					</div>

					<div class="page">
						<t:tpage formId="form_readbook" pageDiv="page"
							page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
					</div>
				</div>


				<jsp:include page="/learn/right.jsp"></jsp:include>


			</div>
		</div>

		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
