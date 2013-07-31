<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<script src="<%=basePath%>learn/teacherbema/js/xing.js"></script>
		<script type="text/javascript">
		function mouseOver(i,j){
			var showid=eval("show"+i);
			var hideid=eval("hide"+j);
			showid.style.display="none";
			hideid.style.display="";
		}
		function mouseOut(i,j){
			var showid=eval("show"+i);
			var hideid=eval("hide"+j);
			showid.style.display="";
			hideid.style.display="none";
		}
		</script>
</head>
<body>
		<s:action name="zxright!rightList" executeResult="false"></s:action>
<!-- 右边部分 -->
  <div class="listright">
      <div class="cetit">系统公告</div>
      <div class="listwen">
      	<c:forEach items="${newsSysarticle}" var="info">
			<a href="<%=basePath %>Article/viewSysById.action?id=${info.articleid}" title="${info.articletitle }">${fn:substring(info.articletitle  , 0,15)}</a>
		</c:forEach>
 </div>
      <div class="cetit">活动兴趣</div>
      <%--
       <div class="xuetu1">
        <div class="jutu">
          <ul>
            <li class="qw_l"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[0].activityid }"><img src="<%=basePath%>img/common_img/${rightActivitylist[0].activitysrc }" width="69" height="91" /></a>
              <p class="zii"><a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[0].programa.proID }">${fn:substring(rightActivitylist[0].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[0].programa.proName }]</span></a></p>
            </li>
            <li class="qw_r"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[1].activityid }"><img src="<%=basePath%>img/common_img/${rightActivitylist[1].activitysrc }" width="69" height="91" /></a>
              <p class="zii"> <a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[1].programa.proID }">${fn:substring(rightActivitylist[1].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[1].programa.proName }]</span></a></p>
            </li>

          </ul>
        </div>
        <div class="jutu">
          <ul>
            <li class="qw_l"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[2].activityid }"><img src="<%=basePath%>img/common_img/${rightActivitylist[2].activitysrc }" width="69" height="91" /></a>
              <p class="zii"><a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[2].programa.proID }">${fn:substring(rightActivitylist[2].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[2].programa.proName }]</span></a></p>
            </li>
            <c:if test="${rightActivitylist[3]!=null}">
            <li class="qw_r"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[3].activityid }"><img src="<%=basePath%>img/common_img/${rightActivitylist[3].activitysrc }" width="69" height="91" /></a>
              <p class="zii"> <a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[2].programa.proID }">${fn:substring(rightActivitylist[3].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[3].programa.proName }]</span></a></p>
            </li>
            </c:if>
          </ul>
        </div>
      </div>
       --%>
       <div class="xuetu1">
        <div class="jutu">
          <ul>
            <li class="qw_l"> <a href="index_interest.jsp"><img src="${rightActivitylist[0].activitysrc }" width="69" height="91" /></a>
              <p class="zii"><a href="index_interest.jsp">
              	<c:choose>
	          		<c:when test="${fn:length(rightActivitylist[0].activitytitle)<11}">${rightActivitylist[0].activitytitle}</c:when>
	          		<c:otherwise>${fn:substring(rightActivitylist[0].activitytitle,0,9)}...</c:otherwise> 
	          		</c:choose>
              <br />
                <span>[${rightActivitylist[0].programa.proName }]</span></a></p>
            </li>
            <li class="qw_r"> <a href="index_interest.jsp"><img src="${rightActivitylist[1].activitysrc }" width="69" height="91" /></a>
              <p class="zii"> <a href="index_interest.jsp">
					<c:choose>
	          		<c:when test="${fn:length(rightActivitylist[1].activitytitle)<11}">${rightActivitylist[1].activitytitle}</c:when>
	          		<c:otherwise>${fn:substring(rightActivitylist[1].activitytitle,0,9)}...</c:otherwise> 
	          		</c:choose>
			<br />
                <span>[${rightActivitylist[1].programa.proName }]</span></a></p>
            </li>

          </ul>
        </div>
        <div class="jutu">
          <ul>
            <li class="qw_l"> <a href="index_interest.jsp"><img src="${rightActivitylist[2].activitysrc }" width="69" height="91" /></a>
              <p class="zii"><a href="index_interest.jsp">
              <c:choose>
	          		<c:when test="${fn:length(rightActivitylist[2].activitytitle)<11}">${rightActivitylist[2].activitytitle}</c:when>
	          		<c:otherwise>${fn:substring(rightActivitylist[2].activitytitle,0,9)}...</c:otherwise> 
	          		</c:choose>
              <br />
                <span>[${rightActivitylist[2].programa.proName }]</span></a></p>
            </li>
            <c:if test="${rightActivitylist[3]!=null}">
            <li class="qw_r"> <a href="index_interest.jsp"><img src="${rightActivitylist[3].activitysrc }" width="69" height="91" /></a>
              <p class="zii"> <a href="index_interest.jsp">
              <c:choose>
	          		<c:when test="${fn:length(rightActivitylist[3].activitytitle)<11}">${rightActivitylist[3].activitytitle}</c:when>
	          		<c:otherwise>${fn:substring(rightActivitylist[3].activitytitle,0,9)}...</c:otherwise> 
	          		</c:choose>
              <br />
                <span>[${rightActivitylist[3].programa.proName }]</span></a></p>
            </li>
            </c:if>
          </ul>
        </div>
      </div>
  
  
      
      
      <div class="cetit">答疑小博士</div>
      <div class="dayilist">
			 <c:forEach items="${questionhotlist}" var="pin" varStatus="vs">
							<c:if test="${(vs.index+1)%6==0 || vs.index==0}">
								<ul>
							</c:if>							
									<li>	<a href="<%=basePath %>Article/getQuestionById.action?id=${pin.questionid}" title="${pin.question }">${fn:substring(pin.question  , 0,15)}</a>
										</li>
							
							<c:if test="${(vs.index+1)%5==0 && vs.index!=9}">
								</ul>
							</c:if>
						</c:forEach>
						</ul>
      </div>
      
				<div class="cetit">
				博览群书
			</div>

			<div class="tu_zi">
				<ul>
					<li class="img_1">
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[0].readsrcid }"><img
								src="${readSrcs[0].photopath }" />
						</a>
					</li>
					<li class="yu">
						<span><a href="#">[${readSrcs[0].subjectCode.subjectname}]</a>
						</span>
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[0].readsrcid }">${fn:substring(readSrcs[0].readsrctile,0,15) }</a>
					</li>
					<li id="li1">
					<script>
          				showXin('li1',${(readSrcs[1].generalscore==null ? 0:readSrcs[0].generalscore)/readSrcs[0].ratingnum },'<%=basePath%>');
          			</script>
          			<c:choose>
          				<c:when test="${readSrcs[0].ratingnum==0}">
          					<span>0分</span>
          				</c:when>
          				<c:otherwise>
          					<span>
          					<fmt:formatNumber type="number" value="${readSrcs[0].generalscore/readSrcs[0].ratingnum }" maxFractionDigits="0"/>
          					分</span>
          				</c:otherwise>
          			</c:choose>
					</li>
					<li class="xia">
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[0].readsrcid }"><img src="<%=basePath%>img/common_img/xiazai.gif" />
						</a>
					</li>
				</ul>
				<ul>
					<li class="img_1">
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[1].readsrcid }"><img
								src="${readSrcs[1].photopath }" />
						</a>
					</li>
					<li class="yu">
						<span><a href="#">[${readSrcs[1].subjectCode.subjectname}]</a>
						</span>
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[1].readsrcid }">${fn:substring(readSrcs[1].readsrctile,0,15) }</a>
					</li>
					<li id="li2">
						<script>
          	showXin('li2',${(readSrcs[1].generalscore==null ? 0:readSrcs[1].generalscore)/readSrcs[1].ratingnum },'<%=basePath%>');
          </script>
						<c:choose>
          				<c:when test="${readSrcs[0].ratingnum==0}">
          					<span>0分</span>
          				</c:when>
          				<c:otherwise>
          					<span><fmt:formatNumber type="number" value="${readSrcs[1].generalscore/readSrcs[1].ratingnum }" maxFractionDigits="0"/>分</span>
          				</c:otherwise>
          			</c:choose>
					</li>
					<li class="xia">
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[1].readsrcid }"><img src="<%=basePath%>img/common_img/xiazai.gif" />
						</a>
					</li>
				</ul>
				<ul class="zi">
					<li>
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[2].readsrcid }">${fn:substring(readSrcs[2].readsrctile,0,15) }</a>
					</li>
					<li>
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[3].readsrcid }">${fn:substring(readSrcs[3].readsrctile,0,15) }</a>
					</li>
					<li>
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[4].readsrcid }">${fn:substring(readSrcs[4].readsrctile,0,15) }</a>
					</li>
				</ul>
			</div>
      <div class="cetit">读物畅销排行</div>
  		  <div class="dushu" >
		<br /><c:choose>
			<c:when test="${empty goodsList}">
				<center>暂时没有数据</center>
			</c:when>
			<c:otherwise>
				<c:forEach items="${goodsList}" var="bs" varStatus="vs">
					<ul class="zhai" style="display:" onmouseover="mouseOver(${vs.index+1 },${vs.index+1 })"  id="show${vs.index+1 }" >
           			 	<li class="hao">${vs.index+1}<br /></li>
            			<li><a href="#"><a href="#">${fn:substring(bs.goodsname,0,11) }</a></a><br /></li>
         			</ul>
         			<ul class="kuan" id="hide${vs.index+1 }" style="display:none" onmouseout="mouseOut(${vs.index+1 },${vs.index+1 })">
           				<li class="hao1">${vs.index+1}<br /></li>
            			<li>${fn:substring(bs.goodsname,0,11) }<br /></li>
            			<li class="tut"><a href="<%=basePath%>shopping/shpping_showGoods.action?goodsId=${bs.goodsid }"><img src="<%=basePath%>${bs.photospath }" /></a><br /></li>
            			<li class="shuzi">￥${bs.marketprice }<br /></li>
          			</ul>
				</c:forEach>
			</c:otherwise>
		</c:choose>
        </div>
    </div>
</body>
</html>



