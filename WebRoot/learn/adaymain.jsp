<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.cnarj.ttxs.util.DateUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

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
		<link href="<%=basePath%>css/adaymain.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="learn/js/readbook.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js" defer="defer"></script>
		<script type="text/javascript">
	var ind=0;
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
			
			function showcontent(ind){
			
				$("[id^='content']").each(function(i){
					if(ind==i){
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
						
						return showcontent(ind);
						;
					}
			function toDown(len){
				 ind++;
				 if(ind>len-1){
					 	ind=len-1;
					}
				return showcontent(ind);
				 
				}
			function tjiao(){
				var beg=$("#odne").val();
					if(beg!=''){
						$("#form_readbook").submit();	
					}
			}
			/**
			$(function(){
					$("#lwy").click(function(){
											
						var text=$("#odne").val();
						 alert(text.value);
						showCalendar(this,text)			 
					});   
			})
			*/
		</script>
		<jsp:include page="/learn/top.jsp"></jsp:include>

		<form action="" method="post" name="formRestriction"
			id="formRestriction">
			<input type="hidden" name="readsrcid" id="readsrcid"
				value="${read.readsrcid }" />
			<input type="hidden" name="readId" id="readId"
				value="${read.readsrcid }" />
			<input type="hidden" name="liindex" id="liindex" value="1" />
			<input type="hidden" name="forwardurl" id="forwardurl"
				value="onedayview" />
			<c:if test="${flag==1}">
				<script>
					copyurl(window.location.href);
				</script>
			</c:if>		
		</form>

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
			<input type="hidden" value="<%=liindex%>" name="liindex" id="liindex" />

			<input type="hidden" name="readsrcid" id="readsrcid"
				value="${read.readsrcid }" />

			<div class="mainbody">
				<div class="seat">
					<a href="#">952116综合信息门户网首页</a> >
					<a href="learn/xx_index.action?liindex=0">学习首页</a> >
					<a href="learn/oneday_showOneDayOneText.action?liindex=1">一天一课</a>
					>
					<span>${read.readsrctile }</span>
				</div>
			</div>
			<div class="mainbody">
				<div class="listbig">
					<div class="leftbig">
						<div class="listleft">
							<div class="titi">
								<span><img src="<%=basePath%>img/learning_img/tit_1.gif" />
								</span>
								<p
									onclick="WdatePicker({el:'oneTime',onpicked:function(dp){window.open('learn/oneday_showOneDayOneText.action?liindex=1&oneTime='+dp.cal.getDateStr())}})">
									<input name="oneTime" id="oneTime" type="hidden" />
									<%
										Calendar cac = Calendar.getInstance();
									%>
									<span><%=cac.get(Calendar.YEAR)%>年<%=cac.get(Calendar.MONTH) + 1%>月<%=cac.get(Calendar.DATE)%>日
										<%=DateUtil.getWeekDayName(cac.getTime())%></span>
								</p>
							</div>
							<div class="flei">
								<ul>
									<li>
										年级：
									</li>
									<li>
										<c:choose>
											<c:when
												test="${param.gradecode==null || param.gradecode==''}">
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
							</div>
						</div>
						<div class="listleft_1">
							<div class="maind_1">
								${read.readsrctile }
							</div>
							<div class="maind_2">
								<span class="s1"><fmt:formatDate
										value="${read.createdate}" pattern="yyyy-MM-dd HH:mm:ss" /> </span>
								<span class="s2"><a href="#" id="a_share"><img
											src="<%=basePath%>img/learning_img/fen_1.gif" /> </a>${read.sharenum}</span>
								<span class="s3"><a href="#" id="a_collect"><img
											src="<%=basePath%>img/learning_img/fen_2.gif" /> </a>${read.collectionnum}</span>
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

							<div class="maind_2">
								<a id="a_down"
									href="learn/readbook!downFile.action?readsrcid=${read.readsrcid }"><img
										src="<%=basePath%>img/learning_img/xiaan.gif" /> </a>
								<span class="s4"> 需积分：<b> ${read.downpoint } </b>分</span>
								<span class="s5"> 下载次数： ${read.downloadnum} </span>
							</div>
							<div class="maind_4">
								<ul>
									<li class="bbt">
										昨日课堂：
									</li>
									<c:forEach items="${reads}" var="reas">
										<li>
											<a
												href="<%=basePath%>learn/oneday_showOneDayInfo.action?readId=${reas.readsrcid }">${reas.readsrctile
												}</a>
											<span>${reas.createdate}</span>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<jsp:include page="/learn/right.jsp"></jsp:include>
				</div>
			</div>
		</form>
		<jsp:include page="/base/bottom.jsp"></jsp:include>

		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
