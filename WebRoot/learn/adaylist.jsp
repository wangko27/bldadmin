<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	//科目
	String subjectcode = request.getParameter("subjectcode");
	if (null == subjectcode) {
		subjectcode = "";
	}
	String subjectname = request.getParameter("subjectname");
	if (null == subjectname) {
		subjectname = "全部";
	}
	//年级
	String gradecode = request.getParameter("gradecode");
	if (null == gradecode) {
		gradecode = "";
	}
	String gradename = request.getParameter("gradename");
	if (null == gradename) {
		gradename = "全部";
	}
	//排序
	String order = request.getParameter("order");
	if (null == order) {
		order = "0";
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="<%=basePath%>css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/learning_common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>css/adaylist.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js" defer="defer"></script>
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
		<form action="learn/oneday_showOneDayOneText.action" method="post"
			name="form_readbook" id="form_readbook">
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
		
		<div class="mainbody">
			<div class="seat">
				<a href="#">952116综合信息门户网首页</a> >
				<a href="learn/xx_index.action?liindex=0">学习首页</a> >
				<span>一天一课</span>
			</div>
		</div>
		<div class="mainbody">
			<div class="listbig">
				<div class="listleft">
					<div class="titi">
						<img src="<%=basePath%>img/learning_img/tit_1.gif" />
					</div>
					<div class="flei">
						<ul>
							<li>
								年级：
							</li>
							<li>
								<c:choose>
									<c:when test="${param.gradecode==null || param.gradecode==''}">
										<b><a href="#" onclick="return setgrade('','全部')">全部</a> </b>
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
							<s:iterator value="#request.list_subjictCode" id="sub" status="s">
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
						<p>
							您的检索条件是：
							<span><%=gradename%>+<%=subjectname%></span>
						</p>
					</div>
					<div class="dda">
						<ul>
							<li class="dibai">
								<a href="#" onclick="return setorder('0','全部',0)">全部</a>
							</li>
							<li>
								<a href="#" onclick="return setorder('1','按热度',1)">按热度</a>
							</li>
							<li class="imgrili" onclick="WdatePicker({el:'oneTime',onpicked:function(){$('#form_readbook').submit()}})">
								<input name="oneTime" type="text" value="${empty oneTime ? '查看日期': oneTime}"  class="xue"/>
							</li>
						</ul>
					</div>
					<div class="list_1">
					<c:forEach items="${onedays}" var="oneday" varStatus="num">
						<c:choose>
							<c:when test="${(num.index+1) mod 2 != 0}">
								<ul>
							</c:when>
							<c:otherwise>
								<ul class="lv">
							</c:otherwise>
						</c:choose>
									<li class="biti">
										<a href="<%=basePath %>learn/oneday_showOneDayInfo.action?liindex=1&readId=${oneday.readsrcid }">${oneday.readsrctile }</a>
										<span class="time">
										<fmt:formatDate value="${oneday.createdate}"
										pattern="yyyy-MM-dd HH:mm:ss" />
										</span>
									</li>
									<li>
										<span>阅读(${oneday.readnum }) | 分享(${oneday.sharenum }) | 收藏(${oneday.collectionnum })</span>
									</li>
									<li>
										简介：${oneday.contentintro }
									</li>
								</ul>
					</c:forEach>
					</div>
					<div class="page">
							<t:tpage pageDiv="page" page="${result.page}"
								goImg="img/learning_img/gog.gif" formId="form_readbook"></t:tpage>
					</div>
				</div>
				<jsp:include page="/learn/right.jsp"></jsp:include>
			</div>
		</div>
	</form>
		<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
