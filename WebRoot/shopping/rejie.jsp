<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
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
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/shopping/shopping_common.css" rel="stylesheet" type="text/css" />
<link href="css/shopping/shlist_3.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="shopping/js/zhankai.js"></script>
		<script language="javascript" src="<%=basePath%>shopping/js/shangmaid.js"></script>
		<script type="text/javascript">
			$().ready(function (){
				$(".tiwen input:first").bind("keypress",function(){
					$("#showquestiontitle").html("");
					var len=$(".tiwen input").val().length;
					var t=30-len-1;
					if(len>0&&len<30){
						$("#showquestiontitle").html("<font color=red>你还可以输入"+t+"\"</font>");
					}
					else if(len>=30){
						$("#showquestiontitle").html("<font color=red>标题过长</font>");
						return false;
					}
				}),
				$(".tiwen textarea").bind("keypress",function(){
					$("#questiondetails").html("");
					var len=$(".tiwen textarea").val().length;
					var t=100-len;
					if(len>0&&len<100){
						$("#questiondetails").html("<font color=red>你还可以输入"+t+"\"</font>");
					}
					else if(len>=100){
						$("#questiondetails").html("<font color=red>内容过长</font>");
						return false;
					}
				}),
				$(".tiwen img").bind("click",function(){
					var len1=$(".tiwen input").val().length;
					var len2=$(".tiwen textarea").val().length;
					if(len1<=0){
						$("#showquestiontitle").html("<font color=red>标题不能为空</font>");
						return false;
					}
					else if(len2<=0){
						$("#questiondetails").html("<font color=red>内容不能为空</font>");
						return false;
					}
					else{
						$("#Questionadd").submit();	
					}
				})
			})
		</script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="#">商城</a> > <span>购物资讯</span></div>
</div>
<div class="mainbody">
  <div class="shbiglist"> 
    <jsp:include page="comm_left.jsp"></jsp:include>
    <div class="listright">
      <div class="titi"><span><img src="img/shopping_img/reda.gif" /></span> <a onclick="window.scrollTo(0,99999);return false" title="点击此处跳到问题天加处"><img src="img/shopping_img/twen.gif" /></a></div>
      <div class="wenti">
      <c:choose>
      	<c:when test="${empty result.content}">
      	<center>暂无数据</center>
      	</c:when>
      	<c:otherwise>
      		<c:choose>
      			<c:when test="${not empty zealAnswer.answer}">
      				<div class="wtq">
        	<h1><span class="bti">Q:${zealAnswer.questiontitle}</span><span class="time"><fmt:formatDate value="${zealAnswer.modifydate}" pattern="yyyy-MM-dd"/></span></h1>
            <p>${zealAnswer.questiondetails }<br /><b>提问人：</b><a href="#">${zealAnswer.member.nikename }</a></p>
        </div>
         <div class="huida">
        	<span>回答：</span>
        		<p id="content1" style="height: 40px; overflow: hidden; text-overflow: ellipsis;">
            		${zealAnswer.answer}
            	</p>
            	<p class="ann1"><a id="key1" value="${ zealAnswer.answer}" onclick="shoppingcat(value.length,1);">全部展开</a></p>
         </div>
         				<c:forEach items="${result.content}" var="q" varStatus="vs">
         				<c:if test="${q.zealanswerid!=zealAnswer.zealanswerid}">
      		<div class="wtq">
        	<h1><span class="bti">Q:${q.questiontitle}</span><span class="time"><fmt:formatDate value="${q.createdate}" pattern="yyyy-MM-dd"/></span></h1>
            <p>${q.questiondetails }<br /><b>提问人：</b><a href="#">${q.member.nikename }</a></p>
        </div>
         <div class="huida">
        	<span>回答：</span>
        		<p id="content${vs.index+2 }" style="height: 40px; overflow: hidden; text-overflow: ellipsis;">
            		${ q.answer}
            	</p>
            	<p class="ann1"><a id="key${vs.index+2}" value="${ q.answer}" onclick="shoppingcat(value.length,${vs.index+2 });">全部展开</a></p>
         </div></c:if>
      		</c:forEach>
      			</c:when>
      			<c:otherwise>
      			<c:if test="${show=='1'}">
      			 	<div class="wtq"><center><font color="red">还没有该问题的相关答案</font></center></div>
      			</c:if>
      				<c:forEach items="${result.content}" var="q" varStatus="vs">
      	<div class="wtq">
        	<h1><span class="bti">Q:${q.questiontitle}</span><span class="time"><fmt:formatDate value="${q.modifydate}" pattern="yyyy-MM-dd"/></span></h1>
            <p>${q.questiondetails }<br /><b>提问人：</b><a href="#">${q.member.nikename }</a></p>
        </div>
         <div class="huida">
        	<span>回答：</span>
        		<p id="content${vs.index+1 }" style="height: 40px; overflow: hidden; text-overflow: ellipsis;">
            		${ q.answer}
            	</p>
            	<p class="ann1"><a id="key${vs.index+1}" value="${ q.answer}" onclick="shoppingcat(value.length,${vs.index+1 });">全部展开</a></p>
         </div>
      		</c:forEach>
      			</c:otherwise>
      		</c:choose>
      	</c:otherwise>
      </c:choose>
      </div>
      <div class="page">	
      </div>
      <form action="<%=basePath %>shopping/shoppingQuestion!add.action" method="get" id="Questionadd" name="Questionadd"  enctype="multipart/form-data">
      <div class="tiwen">
      	<h1>我要提问：</h1>
      	<ul>
      		<li><span></span><span id="showquestiontitle" style="float:left;"></span></li>
        	<li><span>标题：</span><span><input name="zealAnswer.questiontitle" type="text"  id="zealAnswer.questiontitle"/></span></li>
            <li><span></span><span id="questiondetails" style="float:left;"></span></li>
            <li>内容：<textarea name="zealAnswer.questiondetails" cols="" rows="" id="zealAnswer.questiondetails"></textarea></li>
            <li class="ttj"><img src="img/shopping_img/ttj.gif" style="width:63px" /></li>
        </ul>
      </div>
      <div class="kkhh">有疑问，快来<a href="#">提问</a>吧！没账号？<b><a href="#">立即注册！</a></b></div>
      </form>
            	 	<jsp:include page="../comm/message.jsp"></jsp:include>
    </div>
  </div>
</div>
<a name="anwer">
<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
