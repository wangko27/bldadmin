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

		<title>博览群书详情</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/learning_common.css" rel="stylesheet" type="text/css" />
		<link href="css/bookmain.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script src="learn/teacherbema/js/xing.js"></script>
		<script type="text/javascript" src="learn/js/readbook.js"></script>
	</head>

	<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> &gt;
				<a href="learn/xx_index.action">学习首页</a> &gt;
				<a href="learn/readbook!list.action?liindex=5">群览博书</a> &gt;
				<span>内页</span>
			</div>
		</div>
		
		<form action="" method="post" name="formRestriction" id="formRestriction">
			<input type="hidden" name="readsrcid" id="readsrcid" value="${readSrc.readsrcid }" />
			<input type="hidden" name="liindex" id="liindex" value="5" />
			<input type="hidden" name="forwardurl" id="forwardurl" value="bookview" />
			<c:if test="${flag==1}">
				<script>
					copyurl(window.location.href);
				</script>
			</c:if>	
		</form>
		
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="maind_6">
						<div class="mmimg">
							<img src="${readSrc.photopath }" width="149" height="187" />
						</div>
						<div class="mmzi">
							<h1>
								${readSrc.readsrctile }
							</h1>
							<ul class="nn">
								<li>
									<p>
										资源类别：
										<a href="#">${readSrc.readSrcType.srctype }</a>
									</p>
									<p>
										资源属性：
										<a href="#">${readSrc.gradeCode.gradename }
											${readSrc.subjectCode.subjectname }</a>
									</p>
									<p>
										更新时间：
										<s:date name="#request.readSrc.modifydate"
											format="yyyy-MM-dd HH:mm:ss" />
									</p>
									<p>
										资源格式：${readSrc.readsrcformat }
									</p>
									<p>
										资源大小：${readSrc.readsrcsize }KB
									</p>
									<p>
										来&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;源：
										<a href="#">${readSrc.username }</a>
									</p>
									<p>
										下载次数：${readSrc.downloadnum }
									</p>
								</li>
								<li class="lil">
									综合评分:
									<br />
									<span id="spanxing"> <s:if
											test="#request.readSrc.generalscore==0">
											<script>
								        	showXin('spanxing',0,'<%=basePath%>');
								        </script>
										</s:if> <s:else>
											<script>
								        	showXin('spanxing',${(readSrc.generalscore==null ? 0:readSrc.generalscore)/readSrc.ratingnum },'<%=basePath%>');
								        </script>
										</s:else> </span>
									<b> &nbsp; <s:if test="#request.readSrc.generalscore==0">
								        	0
								        	
								        </s:if> <s:else> <fmt:formatNumber type="number" value="${readSrc.generalscore/readSrc.ratingnum}" maxFractionDigits="0"/></s:else> </b>分
									<br />
									${readSrc.ratingnum }人评
								</li>
							</ul>
							
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
							
							<ul class="ss">
								<li>
									<a href="#" id="a_share"><img
											src="img/learning_img/fen_1.gif" /> </a>
								</li>
								<li>
									${readSrc.sharenum }
								</li>
								<li>
									<a href="#" id="a_collect"><img
											src="img/learning_img/fen_2.gif" /> </a>
								</li>
								<li>
									${readSrc.collectionnum }
								</li>
								<li class="yy">
									温馨提示：您只能下载后才能进行评分
								</li>
							</ul>
							<ul class="xx">
								<li>
									<s:if test="#request.readSrc.srcpath==null">
										<img
											src="img/learning_img/xiabj1.gif" />
									</s:if>
									<s:else>
									<a
										href="learn/readbook!downFile.action?readsrcid=${readSrc.readsrcid }"
										target="_blank" id="a_down"><img
											src="img/learning_img/xiabj.gif" /> </a>
									</s:else>		
								</li>
								<li>
									需积分：
									<b> ${readSrc.downpoint } </b>分
								</li>
							</ul>
						</div>
					</div>
					<div class="maind_7">
						<h1>
							内容简介：
						</h1>
						<div id="content"
							style="height: 100px; overflow: hidden; text-overflow: ellipsis;">
							${readSrc.contentintro }
						</div>
						<p class="quan">
							<span id="key" onclick="shoppingcat();">全部展开</span>
						</p>
					</div>
					<div class="maind_4">
						<ul>
							<li class="bbt">
								相关阅读：
							</li>
							<s:iterator value="#request.list_correlateRead"
								id="correlateRead">
								<li>
									<a
										href="learn/readbook!view.action?readsrcid=${correlateRead.readsrcid }&liindex=5">${correlateRead.readsrctile
										}</a>
									<span> <s:date name="#correlateRead.modifydate"
											format="yyyy-MM-dd" /> </span>
								</li>
							</s:iterator>
							<s:if test="#request.list_correlateRead.size==0">
								<li>
									无
								</li>
							</s:if>
						</ul>
					</div>
					<div class="maind_8">
						<h1>
							用户热评：
						</h1>
					</div>
					<div class="maind_9">
						<span>有 <s:property
								value="#request.readSrc.readSrcCommenteds.size" /> 条评论在讨论</span>
						<a href="myspace/comm/ratingGo.action?readsrcid=${readSrc.readsrcid }">我也来评！</a>
					</div>
					<form action="learn/readbook!view.action" name="form_readCommented"
						id="form_readCommented" method="post">
						<div class="maind_10">
							<s:iterator value="#request.list_readCommented"
								id="readCommented">
								<ul>
									<li class="tu">
										<a
											href="Zone/index.action?TTid=${readCommented.member.memberid}"
											target="_blank"><img
												src="${readCommented.member.headpath }" /> </a>
									</li>
									<li class="liuzi">
										<a
											href="Zone/index.action?TTid=${readCommented.member.memberid}"
											target="_blank">${readCommented.member.nikename }</a>：${readCommented.commentedcontent
										}
										<br />
										<s:date name="commenteddate" format="yyyy-MM-dd HH:mm:ss" />
									</li>
									<li class="wuxi">
										<s:if test="#request.readSrc.generalscore==0">
											<script>
								        	showXin('spanxing',0,'<%=basePath%>');
								        </script>
										</s:if>
										<s:else>
											<script>
								        	showXin('spanxing',${(readCommented.readSrc.generalscore==null ? 0:readCommented.readSrc.generalscore)/readCommented.readSrc.ratingnum },'<%=basePath%>');
								        </script>
										</s:else>
									</li>
								</ul>
							</s:iterator>

							<s:if test="#request.list_readCommented.size==0">
								<ul>
									<li>
										暂无评论
									</li>
								</ul>
							</s:if>

						</div>

						<div class="page">
							<input type="hidden" name="readsrcid" id="readsrcid"
								value="${readSrc.readsrcid }" />
							<t:tpage formId="form_readCommented" pageDiv="page"
								page="${result.page}" goImg="img/learning_img/gog.gif"></t:tpage>
						</div>
					</form>
					<div class="maind_11">
						<span>还没下载？请<a href="javascript:scroll(0,0)" target="_self">下载</a>进行讨论。没账号？<a
							href="login/register.jsp">立即注册</a> </span>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp"></jsp:include>
			</div>
		</div>

		<jsp:include page="/base/bottom.jsp"></jsp:include>
		
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
