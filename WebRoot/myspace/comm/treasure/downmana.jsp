<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-下载管理</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/download.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/myspace/header.jsp"></jsp:include> 
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		  <!-- 用户中心中部左边菜单栏 -->
		  <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		  <!-- 用户中心中部右边内容详细页 -->
	      <div class="right">
	        
	        <div class="bobti">百宝箱</div>
	        <div class="dtai">
	          <ul>
	            <li class="bai">下载管理</li>
	            <li><a href="myspace/comm/uploadSrcList.action">资源管理</a></li>
	            <li><a href="myspace/comm/mquestionList.action">问题管理</a></li>
	            <li><a href="myspace/comm/worksList.action">作品管理</a></li>
            	<li><a href="myspace/comm/carItemList.action">购物车</a></li>
            	<!-- 
             	<li><a href="myspace/comm/orderList.action">我的订单</a></li>
             	 -->
            	<li><a href="myspace/comm/receiverList.action">地址管理</a></li>
	            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
	          </ul>
	        </div>
	        <div class="yutr">
	        
 			  <s:iterator value="downlist" status="st" id = "down">
            	<ul class="nmmid">
                	<li class="${readSrc.readsrcformat }">
                   		<p> <a 
	                   		<s:if test='readSrc.readSrcType.srctype=="一天一课"'>
	                   			href="learn/oneday_showOneDayInfo.action?liindex=1&readId=${readSrc.readsrcid }"
	                   		</s:if>
	                   		<s:else>
	                   			href="learn/readbook!view.action?readsrcid=${readSrc.readsrcid }&liindex=5"
	                   		</s:else>
                   		 target="_blank">
                   		<c:choose>
                   		<c:when test="${fn:length(readSrc.readsrctile)<30}">${readSrc.readsrctile }</c:when>
                   		<c:otherwise>${fn:substring(readSrc.readsrctile,0,30)}...</c:otherwise> 
                   		</c:choose>
                   		</a> <span>需${readSrc.downpoint }积分</span></p>
                        <p><span>${readSrc.readsrcsize }KB</span></p>
                    </li>
                    <li class="an">
                    	<p><span>${downloaddate }</span></p>
                    	<s:if test='israting == "1"'>
                    		<p>已打分</p>
                    	</s:if>
                    	<s:elseif test='readSrc.isenable == "0"'>
                    		<p>资源关闭,无法打分</p>
                    	</s:elseif>
                    	<s:else>
                    		<p>还未评论，<a href="myspace/comm/ratingGo.action?downrecid=${downrecid }">给资源打分</a></p>
                    	</s:else>
                    </li>
               </ul>
 			  </s:iterator>
 			  
	        </div>

			<s:if test="result != null">
	        <form action="myspace/comm/downManaList.action" id="form1" method="post">
	        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1"></t:tpage>
	        </form>
	        </s:if>
	        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
  	
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
