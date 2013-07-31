<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
		<base href="<%=basePath%>" />
    <title>您好，欢迎来到952116综合信息门户网！</title>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/interesting.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/interesting/interesting_common.css" rel="stylesheet" type="text/css" />
		<script src="<%=basePath%>learn/teacherbema/js/xing.js"></script>
  </head> 
  <body>
    <s:action name="common" executeResult="false"></s:action>
    <div class="listright">
      <div class="cetit">系统公告</div>
      <div class="listwen">
				<c:forEach items="${activitySysarticle}" var="info">
						<a href="interest/viewById.action?id=${info.articleid}">${fn:substring(info.articletitle  , 0,15)}</a>
				</c:forEach>
			</div>
      <div class="cetit">活动兴趣</div>
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
      <%-- 
      <div class="cetit">活动兴趣</div>
      <div class="xuetu1">
        <div class="jutu">
          <ul>
            <li class="qw_l"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[0].activityid }"><img src="<%=basePath%>${rightActivitylist[0].activitysrc }" width="69" height="91" /></a>
              <p class="zii"><a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[0].programa.proID }">${fn:substring(rightActivitylist[0].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[0].programa.proName }]</span></a></p>
            </li>
            <li class="qw_r"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[1].activityid }"><img src="<%=basePath%>${rightActivitylist[1].activitysrc }" width="69" height="91" /></a>
              <p class="zii"> <a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[1].programa.proID }">${fn:substring(rightActivitylist[1].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[1].programa.proName }]</span></a></p>
            </li>

          </ul>
        </div>
        <div class="jutu">
          <ul>
            <li class="qw_l"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[2].activityid }"><img src="<%=basePath%>${rightActivitylist[2].activitysrc }" width="69" height="91" /></a>
              <p class="zii"><a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[2].programa.proID }">${fn:substring(rightActivitylist[2].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[2].programa.proName }]</span></a></p>
            </li>
            <c:if test="${rightActivitylist[3]!=null}">
            <li class="qw_r"> <a href="<%=basePath%>interest/activity_showactintro.action?activitId=${rightActivitylist[3].activityid }"><img src="<%=basePath%>${rightActivitylist[3].activitysrc }" width="69" height="91" /></a>
              <p class="zii"> <a href="<%=basePath%>interest/activity_showActions.action?proID=${rightActivitylist[2].programa.proID }">${fn:substring(rightActivitylist[3].activitytitle ,0,11) }<br />
                <span>[${rightActivitylist[3].programa.proName }]</span></a></p>
            </li>
            </c:if>
          </ul>
        </div>
      </div>
      --%>
      <div class="cetit">新知识点</div>
      <div class="dayilist">
			 <c:forEach items="${newknows}" var="pin" varStatus="vs">
							<c:if test="${vs.index%5==0}">
								<ul>
							</c:if>
									<li>
									<a href="<%=basePath%>interest/viewById.action?id=${pin.articleid}">${fn:substring(pin.articletitle  , 0,15)}</a>
									</li>
							<c:if test="${vs.index%5==4}">
								</ul>
							</c:if>
						</c:forEach>
      </div>
      <div class="cetit">博览群书</div>
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
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[0].readsrcid }">${fn:length(readSrcs[0].readsrctile)>13 ? fn:substring(readSrcs[0].readsrctile,0,13 ) : readSrcs[0].readsrctile}</a>
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
          					<span>${readSrcs[0].generalscore/readSrcs[0].ratingnum }分</span>
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
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[1].readsrcid }">${fn:length(readSrcs[1].readsrctile)>13 ? fn:substring(readSrcs[1].readsrctile,0,13 ) : readSrcs[1].readsrctile}</a>
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
          					<span>${readSrcs[0].generalscore/readSrcs[0].ratingnum }分</span>
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
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[2].readsrcid }">${fn:length(readSrcs[2].readsrctile)>13 ? fn:substring(readSrcs[2].readsrctile,0,13 ) : readSrcs[2].readsrctile}</a>
					</li>
					<li>
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[3].readsrcid }">${fn:length(readSrcs[3].readsrctile)>13 ? fn:substring(readSrcs[3].readsrctile,0,13 ) : readSrcs[3].readsrctile}</a>
					</li>
					<li>
						<a href="learn/readbook!view.action?readsrcid=${readSrcs[4].readsrcid }">${fn:length(readSrcs[4].readsrctile)>13 ? fn:substring(readSrcs[4].readsrctile,0,13 ) : readSrcs[4].readsrctile}</a>
					</li>
				</ul>
			</div>
      <div class="cetit">读物畅销排行</div>
     <div class="dushu">
				<c:forEach items="${goodsList}" var="goods" varStatus="index">
					<ul class="zhai">
						<li class="hao">
							${index.index+1 }
						</li>
						<li>
							<a href="<%=basePath %>shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1">${fn:length(goods.goodsname)>10 ? fn:substring(goods.goodsname,0,10 ) : goods.goodsname}</a>
						</li>
					</ul>
					<ul class="kuan" style="display: none">
						<li class="hao1">
							${index.index+1 }
						</li>
						<li>
						${fn:length(goods.goodsname)>10 ? fn:substring(goods.goodsname,0,10 ) : goods.goodsname}
						</li>
						<li class="tut">
							<a href="<%=basePath %>shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1"><img src="<%=basePath%>${goods.photospath }" />
							</a>
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
