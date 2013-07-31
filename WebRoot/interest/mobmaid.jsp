<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/moban.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/motyss.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/jquery-1.4.2.js" language="javascript"></script>
<script src="<%=basePath%>interest/js/mobmaid.js" language="javascript"></script>
</head>
<body>
	<jsp:include page="top2.jsp"></jsp:include>
  	<div class="mmaind">
    <jsp:include page="left.jsp"></jsp:include>
    <input type="hidden" id="worksId" value="${works.worksid}" />
    <input type="hidden" id="urlPath" value="<%=basePath%>" />
    <div class="mmright">
      <div class="ritu_1">
        <h1><span>参赛作品</span> </h1>
        <div class="zzpp">
          <p><a href="#"><img src="<%=basePath%>${works.facepath }" width="203" height="248" /></a></p>
          <ul>
            <li class="hti"><b>${works.workstitle }</b><span id="vot">票数：${works.votes}</span></li>
            <li>编号：${works.worksnumber }</li>
            <li>作者：${works.author }</li>
            <li>时间：${works.createdate }</li>
            <li class="jianjie">作品简介：<br />
              <span>${works.worksintro }</span></li>
            <li class="ann"><a href="#" onclick="return false"><img name="tp" src="<%=basePath%>img/interesting_img/tp.gif" width="110" height="40" />
            </a><span id="vot2">${works.votes}票</span><a href="interest/Comm_showActivityWorkComm.action#pingrun">
            <img src="<%=basePath%>img/interesting_img/tp1.gif" width="110" height="40" />
            </a></li>
          </ul>
        </div>
        <div class="zuop">作品介绍</div>
        <c:choose>
        <c:when test="${empty photos}">
        	<img src="<%=basePath%>${works.showsrc }" width="600"/>
        </c:when>
        <c:otherwise>
        <c:forEach items="${photos}" var="photo">
        	<img src="<%=basePath%>${photo.photopath }" title="${photo.photoname }" width="600"/>
        </c:forEach>
        </c:otherwise>
        </c:choose>
        <div class="neirr">  ${works.workscontent }</div>
        <div class="touan"><a href="#" onclick="return false"><img name="tp" src="<%=basePath%>img/interesting_img/tp.gif" width="110" height="40" />
        </a><span id="vot3">${works.votes}票</span></div>
        <div class="zuop">作品评论</div>
        <div class="messpp_2">
          <div class="maind_13"><span>有${total }条评论在讨论</span> <a href="interest/Comm_showActivityWorkComm.action#pingrun">我也来评！</a></div>
          <div class="maind_14">
          <c:choose>
          	<c:when test="${empty comms}">
          		暂时没有评论!
          	</c:when>
          	<c:otherwise>
          	<c:forEach items="${comms}" var="comm">
          	<ul>
              <li class="tu"><a href="#"><img src="<%=basePath%>${comm.member.headpath }" /></a></li>
              <li class="liuzi"><a href="#">${comm.comUserName }</a>：${comm.comContent }<br/>
                ${comm.comDate }</li>
            </ul>
          	</c:forEach>
          	</c:otherwise>
          </c:choose>
          
          </div>
          <div class="page">
            	<c:choose>
	      		<c:when test="${empty comms}">
		      	</c:when>
		      	<c:otherwise>
		      	<form id="form1" action="interest/Comm_showActivityWorkComm.action" method="post">
						<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1">
					</t:tpage>
		        </form>
		      	</c:otherwise>
		     	</c:choose>
          </div>
          
          <div class="ppkk">
          <a name="pingrun" name="pingrun">
            <textarea name="comContent" id="comContent" cols="" rows=""></textarea>
            <p><span>验证码：
              <input name="yanCode" type="text"  class="yan"/><img  id="yan" src="<%=basePath %>validatecode" width="58" height="20" align="top" alt="看不清楚,换一张"/>
              </span>
              <input name="fb" type="button" id="fb" class="fabi" value="发表"/>
            </p>
          </div>
          <div class="maind_15">没账号？<span><a href="#">立即注册</a></span> </div>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
