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


<%
	//类别
	String srctypeid = request.getParameter("srctypeid");
	if (null == srctypeid) {
		srctypeid = "";
	}
	String srctypename = request.getParameter("srctypename");
	if (null == srctypename || null == srctypeid
			|| "".equals(srctypeid)) {
		srctypename = "全部";
	}

	//科目
	String subjectcode = request.getParameter("subjectcode");
	if (null == subjectcode) {
		subjectcode = "";
	}
	String subjectname = request.getParameter("subjectname");
	if (null == subjectname || null == subjectcode
			|| "".equals(subjectcode)) {
		subjectname = "全部";
	}
	//年级
	String gradecode = request.getParameter("gradecode");
	if (null == gradecode) {
		gradecode = "";
	}
	String gradename = request.getParameter("gradename");
	if (null == gradename || null == gradecode || "".equals(gradecode)) {
		gradename = "全部";
	}
	//排序
	String order = request.getParameter("order");
	if (null == order) {
		order = "modifydate";
	}
	String ordername = request.getParameter("ordername");
	if (null == order) {
		ordername = "全部";
	}

	String orderliindex = request.getParameter("orderliindex");
	if (null == orderliindex) {
		orderliindex = "0";
	}

	//头部选项记录
	String liindex = request.getParameter("liindex");
	if (null == liindex) {
		liindex = "0";
	}
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

		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script src="learn/teacherbema/js/xing.js"></script>

		<script type="text/javascript">
			//设置年级
			function setgrade(gradecode,gradename){
				$("#gradecode").val(gradecode);
				$("#gradename").val(gradename);
				$("#form_readbook").submit();
				return false;
			}
			
			//设置科目
			function setsubject(subjectcode,subjectname){
				$("#subjectcode").val(subjectcode);
				$("#subjectname").val(subjectname);
				$("#form_readbook").submit();
				return false;
			}
			
			//设置类别
			function setsrctype(srctypeid,srctypename){
				$("#srctypeid").val(srctypeid);
				$("#srctypename").val(srctypename);
				$("#form_readbook").submit();
				return false;
			}
			
			//设置排序
			function setorder(order,ordername,orderliindex){
				$("#order").val(order);
				$("#ordername").val(ordername);
				$("#orderliindex").val(orderliindex);
				$("#form_readbook").submit();
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
				showorder(<%=orderliindex%>);
			});
			
		</script>
	</head>

	<body>

		<jsp:include page="/learn/top.jsp"></jsp:include>

		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> &gt;
				<a href="learn/xx_index.action">学习首页</a> &gt;
				<span>博览群书</span>
			</div>
		</div>


		<div class="mainbody">
			<div class="listbig">

				<form action="learn/readbook!list.action" method="post"
					name="form_readbook" id="form_readbook">
					<input type="hidden" value="<%=srctypeid%>" name="srctypeid"
						id="srctypeid" />
					<input type="hidden" value="<%=srctypename%>" name="srctypename"
						id="srctypename" />
					<input type="hidden" value="<%=subjectcode%>" name="subjectcode"
						id="subjectcode" />
					<input type="hidden" value="<%=subjectname%>" name="subjectname"
						id="subjectname" />
					<input type="hidden" value="<%=gradecode%>" name="gradecode"
						id="gradecode" />
					<input type="hidden" value="<%=gradename%>" name="gradename"
						id="gradename" />
					<input type="hidden" value="<%=order%>" name="order" id="order" />
					<input type="hidden" value="<%=ordername%>" name="ordername"
						id="ordername" />
					<input type="hidden" value="<%=orderliindex%>" name="orderliindex"
						id="orderliindex" />
					<input type="hidden" value="<%=liindex%>" name="liindex"
						id="liindex" />




					<div class="listleft">
						<div class="titi">
							<img src="img/learning_img/tit_2.gif" />
						</div>
						<div class="flei">
							<ul>
								<li>
									年级：
								</li>
								<li>
									<c:choose>
										<c:when test="${param.gradecode==null || param.gradecode==''}">
											<b><a href="#" onclick="return setgrade('','全部')">全部</a>
											</b>
										</c:when>
										<c:otherwise>
											<a onclick="return setgrade('','全部')">全部</a>
										</c:otherwise>
									</c:choose>
								</li>

								<s:action name="public!getGradeCodeAll" executeResult="false"></s:action>
								<s:iterator value="#request.list_gradeCode" id="g" status="s">
									<li>
										<c:choose>
											<c:when test="${param.gradecode==g.gradecode}">
												<b><a href="#"
													onclick="return setgrade('${g.gradecode}','${g.gradename}')">${g.gradename
														}</a> </b>
											</c:when>
											<c:otherwise>
												<a href="#"
													onclick="return setgrade('${g.gradecode}','${g.gradename}')">${g.gradename
													}</a>
											</c:otherwise>
										</c:choose>
									</li>
								</s:iterator>
							</ul>
							<ul>
								<li>
									科目：
								</li>
								<li>
									<c:choose>
										<c:when
											test="${param.subjectcode==null || param.subjectcode==''}">
											<b><a href="#" onclick="return setsubject('','全部')">全部</a>
											</b>
										</c:when>
										<c:otherwise>
											<a href="#" onclick="return setsubject('','全部')">全部</a>
										</c:otherwise>
									</c:choose>
								</li>

								<s:action name="public!getSubjectCodeAll" executeResult="false"></s:action>
								<s:iterator value="#request.list_subjictCode" id="sub"
									status="s">
									<li>
										<c:choose>
											<c:when test="${param.subjectcode==sub.subjectcode}">
												<b><a href="#"
													onclick="return setsubject('${sub.subjectcode}','${sub.subjectname}')">${sub.subjectname
														}</a> </b>
											</c:when>
											<c:otherwise>
												<a href="#"
													onclick="return setsubject('${sub.subjectcode}','${sub.subjectname}')">${sub.subjectname
													}</a>
											</c:otherwise>
										</c:choose>
									</li>
								</s:iterator>
							</ul>
							<ul>
								<li>
									类别：
								</li>
								<li>
									<c:choose>
										<c:when test="${param.srctypeid==null || param.srctypeid==''}">
											<b><a href="#" onclick="return setsrctype('','全部')">全部</a>
											</b>
										</c:when>
										<c:otherwise>
											<a href="#" onclick="return setsrctype('','全部')">全部</a>
										</c:otherwise>
									</c:choose>
								</li>

								<s:action name="public!getReadsrctypeAllByBook"
									executeResult="false"></s:action>
								<s:iterator value="#request.list_readType" id="r">
									<li>
										<c:choose>
											<c:when test="${param.srctypeid==r.srctypeid}">
												<b> <a href="#"
													onclick="return setsrctype('${r.srctypeid}','${r.srctype}')">${r.srctype
														}</a> </b>
											</c:when>
											<c:otherwise>
												<a href="#"
													onclick="return setsrctype('${r.srctypeid}','${r.srctype}')">${r.srctype
													}</a>
											</c:otherwise>
										</c:choose>
									</li>
								</s:iterator>
							</ul>
							<p>
								您的检索条件是：
								<span><%=gradename%>+<%=subjectname%>+<%=srctypename%></span>
							</p>
						</div>
						<div class="dda">
							<ul>
								<li class="dibai">
									<a href="#" onclick="return setorder('modifydate','全部',0)">全部</a>
								</li>
								<li>
									<span>|</span>
								</li>
								<li>
									<a href="#" onclick="return setorder('downloadnum','按热度',2)">按热度</a>
								</li>
								<li>
									<span>|</span>
								</li>
								<li>
									<a href="#" onclick="return setorder('generalscore','按分数',4)">按分数</a>
								</li>
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
												href="learn/readbook!view.action?readsrcid=${readSrc.readsrcid }&liindex=<%=liindex%>"
												target="_blank">${readSrc.readsrctile }</a>
											<s:if test="#request.readSrc.srcpath!=null">
												<span>&nbsp;</span>	
											</s:if>
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
													</s:else> </span> <b>  <s:if
														test="#request.readSrc.generalscore==0">
								        	0
								        </s:if> <s:else><fmt:formatNumber type="number" value="${readSrc.generalscore/readSrc.ratingnum}" maxFractionDigits="0"/> </s:else> </b> 分</span>
										</p>
									</li>
									<li>
										<span>阅读(${readSrc.readnum }) | 分享(${readSrc.sharenum
											}) | 收藏(${readSrc.collectionnum })</span>
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
				</form>

				<jsp:include page="/learn/right.jsp"></jsp:include>


			</div>
		</div>

		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
