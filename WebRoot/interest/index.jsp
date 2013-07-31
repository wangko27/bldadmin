<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<link href="<%=basePath%>css/interesting/interesting.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/interesting/interesting_common.css" rel="stylesheet" type="text/css" />
    <link href="css/interesting/bb.css" rel="stylesheet" type="text/css" />
  </head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="mainbody">
  <div class="slide_1">
    <div id="player">
		<ul class="Limg">
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="interest-index-a1" src="" width="695" height="160"/><p>宣传新专辑与徐静蕾合作很紧张 </p></a></li>
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="interest-index-a2" src="" width="695" height="160"/><p>尚雯婕为演唱会携天价古董拍海报</p></a></li>
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="interest-index-a3" src="" width="695" height="160"/><p>爸妈齐助阵周杰伦2010年新专辑MV</p></a></li>
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="interest-index-a4" src="" width="695" height="160"/><p>阿朵唱功遭质疑撩裙露臀卖肉博眼球</p></a></li>
		</ul>
		<cite class="Nubbt"><span class="on">1</span><span >2</span><span >3</span><span >4</span></cite> 
	</div>
	<script language="javascript" src="<%=basePath%>js/bb.js"></script>
  </div>
  <div class="login_1">
		<jsp:include page="/base/logging_status.jsp?pathitem=interesting_img"></jsp:include>		
  </div>
</div>
<div class="mainbody">
  <div class="tuibig">
    <div class="quit">
      <ul id="zy">
      <c:choose>
      <c:when test="${empty actps}">
     	<li> 暂无栏目</li>
      </c:when>
      <c:otherwise>
      <c:forEach items="${actps}" var="actp" varStatus="vs">
      	<c:if test="${vs.index<5}">
      	 	<li  class="${actp.proID==activityProid? 'dbai':'' }">
      	 	<a href="<%=basePath %>interest/XQ_index.action?activityProid=${actp.proID }">${actp.proName }</a>
      	 	</li>
      	 	<c:if test="${vs.index<4}">
      	 		<li>|</li>
      	 	</c:if>
        </c:if>
      </c:forEach>
      </c:otherwise>
      </c:choose>
      </ul>
    </div>
    <div class="tunei">
    <c:choose>
    <c:when test="${empty indexact }">无活动</c:when>
    <c:otherwise>
      <div class="left">
        <div class="tttop">
          <div class="huotu">
          <a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${indexact.activityid }&activitPro=${indexact.programa.proID }"><img src="<%=basePath%>img/interesting_img/tu1.gif" /></a>
          <a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${indexact.activityid }&activitPro=${indexact.programa.proID }">${indexact.activitytitle }</a>
          </div>
          <div class="huozi">
            <ul class="hhwenzi">
              <li class="tbj">[${indexPro.proName }活动]</li>
              <li class="tbii"><a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${indexact.activityid }&activitPro=${indexact.programa.proID }">${indexact.activitytitle }</a></li>
              <li class="danjie">　　${fn:length(indexContext)>200 ? fn:substring(indexContext,0,200) : indexContext}</li>
            </ul>
            <ul class="hjzzi">
            <c:forEach items="${indexpic}" var="pic" varStatus="vs">
            <c:if test="${vs.index<4}">
            <li class="mmar"><a href="#"><img src="<%=basePath%>${indexact.unlinepath }${pic }" /></a></li>
            </c:if>
            </c:forEach>
            </ul>
          </div>
        </div>
        <div class="hangzhi">
          <h1><strong>行业知识</strong></h1>
          <ul>
  		  <c:choose>
          <c:when test="${empty indexArt}">
          	<li>暂无行业知识</li>
          </c:when>
          <c:otherwise>
          <c:forEach items="${indexArt}" var="inArt">
          <li><a href="<%=basePath %>interest/viewById.action?id=${inArt.articleid }&proID=${indexact.programa.proID }">
          ${fn:substring(inArt.articletitle,0,16 )}
          </a>
          </li>
          </c:forEach>
          </c:otherwise>
          </c:choose>
          </ul>
        </div>
      </div>
     </c:otherwise>
      </c:choose>
      <div class="right">
        <div class="paib">排行榜</div>
        <div class="pang">
        <c:choose>
        <c:when test="${empty indexWorks}">
        	 <ul class="wuse"><li>暂无排行信息</li></ul>
        </c:when>
        <c:otherwise>
        <c:forEach items="${indexWorks}" var="works" varStatus="vs">
    
        <c:choose>
          <c:when test="${vs.index<3}">
	        <ul class="wuse">
	            <li class="hong">${vs.index+1 }</li>
	            <li class="hbt"><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }">${works.workstitle }</a></li>
	            <li class="ming"><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }">${works.author }</a></li>
	            <li class="ming">${works.votes }</li>
	            <li class="neir" style="display: none;">
	              <p><span class="d1">网络票数：${works.votes }</span> <span class="d2">短信票数：0</span> <span class="d3">合计：${works.votes }</span></p>
	              <p>学校：${works.schoolName }</p>
	              <p><span class="d4">标题：<a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }">${works.workstitle }</a> </span> <span class="d5">作品编号：${works.worksnumber }</span></p>
	            </li>
	         </ul>
        </c:when>
        <c:otherwise>
      
	        <ul class="wuse">
	            <li class="zi">${vs.index+1 }</li>
	            <li class="hbt"><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }">${works.workstitle }</a></li>
	            <li class="ming"><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }">${works.author }</a></li>
	            <li class="ming">${works.votes }</li>
	            <li class="neir" style="display: none;">
	              <p><span class="d1">网络票数：${works.votes }</span> <span class="d2">短信票数：0</span> <span class="d3">合计：${works.votes }</span></p>
	              <p>学校：${works.schoolName }</p>
	              <p><span class="d4">标题：<a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${works.worksid }">${works.workstitle }</a> </span> <span class="d5">作品编号：${works.worksnumber }</span></p>
	            </li>
	         </ul> 
         </c:otherwise>
         
         </c:choose>
        </c:forEach>
        </c:otherwise>
        </c:choose>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="mainbody">
  <div class="banner"><a href="#" onclick="return false"><img name="advertisement" title="interest-index-b" src="" /></a></div>
</div>
<div class="mainbody">
  <div class="nnbig">
    <div class="bla_1">
      <p class="titbi"><img src="<%=basePath%>img/interesting_img/titbj.gif" /></p>
      <p>
      <c:choose>
      <c:when test="${empty indexType}">
      	无类型
      </c:when>
      <c:otherwise>
      <c:forEach items="${indexType}" var="type" varStatus="vs">
      	<a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${type.activityid }&activitPro=${type.programa.proID }">${type.activityType.typeName }</a> -
      	<c:if test="${(vs.index+1)==typelength}">
      	<a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${type.activityid }&activitPro=${type.programa.proID }">${type.activityType.typeName }</a>
      	</c:if>
      </c:forEach>
      </c:otherwise>
      </c:choose>
       </p>
      <p class="more"><a href="interest/activity_showActions.action?proID=8a8081b121bd7ec20131bd7f78e50001"><img src="<%=basePath%>img/home_img/more.gif" /></a></p>
    </div>
    <div class="tudiv">
      <div class="tuu1">
        <div class="ui1">
        	<a href="${activPic[0].showUrl }"><img src="<%=basePath%>${activPic[0].showImgpath }" /></a>
          <p><a href="${activPic[0].showUrl }">${activPic[0].showTitle }</a></p>
        </div>
        <div class="ui2"><a href="${activPic[1].showUrl }"><img src="<%=basePath%>${activPic[1].showImgpath }" /></a>
          <p><a href="${activPic[1].showUrl }">${activPic[1].showTitle }</a></p>
        </div>
      </div>
      <div class="tuu2">
        <div class="ui3"><a href="${activPic[2].showUrl }"><img src="<%=basePath%>${activPic[2].showImgpath }" /></a>
          <p><a href="${activPic[2].showUrl }">${activPic[2].showTitle }</a></p>
        </div>
        <div class="ui4"><a href="${activPic[3].showUrl }"><img src="<%=basePath%>${activPic[3].showImgpath }" /></a>
          <p><a href="${activPic[3].showUrl }">${activPic[3].showTitle }</a></p>
        </div>
      </div>
      <div class="tuu3">
        <div class="ui5"><a href="${activPic[4].showUrl }"><img src="<%=basePath%>${activPic[4].showImgpath }" /></a>
          <p><a href="${activPic[4].showUrl }">${activPic[4].showTitle }</a></p>
        </div>
        <div class="ui5"><a href="${activPic[5].showUrl }"><img src="<%=basePath%>${activPic[5].showImgpath }" /></a>
          <p><a href="${activPic[5].showUrl }">${activPic[5].showTitle }</a></p>
        </div>
        <div class="ui6"><a href="${activPic[6].showUrl }"><img src="<%=basePath%>${activPic[6].showImgpath }" /></a>
          <p><a href="${activPic[6].showUrl }">${activPic[6].showTitle }</a></p>
        </div>
      </div>
      <div class="tuu4"> <a href="${activPic[7].showUrl }"><img src="<%=basePath%>${activPic[7].showImgpath }" /></a>
        <p><a href="${activPic[7].showUrl }">${activPic[7].showTitle }</a></p>
      </div>
    </div>
  </div>
</div>
<div class="mainbody">
  <div class="nnbig">
    <div class="bla_1">
      <p class="titbi"><img src="<%=basePath%>img/interesting_img/titbj2.gif" /></p>
      <p>&nbsp;</p>
      <p class="more"><a href="interest/XQ_index!getAllColseAct.action"><img src="<%=basePath%>img/home_img/more.gif" /></a></p>
    </div>
    <div class="daxia">
      <div class="you">
        <div class="scmenu">
          <ul id="zy2">
           <c:forEach items="${actps}" var="actp">
            <li  class="${actp.proID==activityColseId? 'mmbj':'' }"><a href="<%=basePath %>interest/XQ_index.action?activityColseId=${actp.proID }">${actp.proName}</a></li>
           </c:forEach>
          </ul>
        </div>
        <div class="listbiao">
        	<ul>
        	<c:choose>
        	<c:when test="${empty indexActs}">
        		<li>没有记录</li>
        	</c:when>
        	<c:otherwise>
        	<c:forEach items="${indexActs}" var="inact">
        	<li><a href="<%=basePath %>interest/works_showActionWorks.action?activitId=${inact.activityid }&activitPro=${inact.programa.proID }">${inact.activitytitle }</a></li>
        	</c:forEach>
        	</c:otherwise>
        	</c:choose>
            </ul>
        </div>
      </div>
      <div class="zou">
      	<h1>专业老师推荐</h1>
      	<c:choose>
      	<c:when test="${empty indexTea}">
      	<ul>
	      	<li>暂无推荐老师</li>
      	</ul>
      	</c:when>
      	<c:otherwise>
      	<c:forEach items="${indexTea}" var="tea" varStatus="vs">
      	<ul>
        	<li class="tu"><a href="#?id=${tea.id }"><img src="<%=basePath%>${tea.member.headpath }" /></a></li>
            <li>
            	<p class="cose">[航模老师] <b><a href="#">${tea.member.username }</a></b></p>
                <p>${empty blogs[vs.index] ? '暂无信息' : blogs[vs.index] }</p>
                <p class="rr"><a href="#"><img src="<%=basePath%>img/interesting_img/ty.gif" /></a></p>
            </li>
        </ul>
      	</c:forEach>
      	</c:otherwise>
      	</c:choose>
      </div>
    </div>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>

