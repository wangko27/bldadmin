<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-上传资源管理</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/ziyuan.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
	<!-- 消息 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
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
	            <li><a href="myspace/comm/downManaList.action">下载管理</a></li>
	            <li class="bai">资源管理</li>
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
	        <div class="ziyuan">
	        	<h1>温馨提示：上传资料，分享给大家，您可以获得积分，下载次数越多获取的积分越多。积分可用来下载更多资料！赶快来<a href="myspace/comm/uploadSrcGo.action">上传资源</a>吧！<br />
	        	<a href="myspace/comm/uploadSrcGo.action"><img src="img/user_img/shz.jpg" width="80" height="24" /></a>
	        	</h1>
	          <table width="200" border="0" cellspacing="0" cellpadding="0">
	            <tr class="lase">
	              <td class="k1">标题</td>
	              <td class="k2">下载次数</td>
	              <td class="k2">操作</td>
	              <td class="k3">上传时间</td>
	            </tr>
	            
 			    <s:iterator value="readsrcList" status="st" id = "readsrc">
	            <tr>
	              <td <s:if test='isenable == "1"'> class="k1"</s:if><s:else>class="k4"</s:else>>
	              <a href="learn/readbook!view.action?readsrcid=${readsrcid }&liindex=5" target="_blank">
	                <c:choose>
	           		<c:when test="${fn:length(readsrctile)<35}">${readsrctile }</c:when>
	           		<c:otherwise>${fn:substring(readsrctile,0,33)}...</c:otherwise> 
	           		</c:choose>
	              </a>
	              </td>
	              <td <s:if test='isenable == "1"'> class="k2"</s:if><s:else>class="k5"</s:else> >${downloadnum}</td>
	              <td <s:if test='isenable == "1"'> class="k2"</s:if><s:else>class="k5"</s:else> >
	              <s:if test='isenable == "1"'>
	              <a href="myspace/comm/uploadSrcClose.action?srcid=${readsrcid }">关闭资源</a>
	              </s:if>
	              <s:else>已关闭</s:else>
	              </td>
	              <td <s:if test='isenable == "1"'> class="k3"</s:if><s:else>class="k6"</s:else> ><fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd HH:mm"/></td>
	            </tr>
	            </s:iterator>
	            
	          </table>
	        </div>
	        
			<s:if test="result != null">
	        <form action="" id="form1" method="post">
	        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1"></t:tpage>
	        </form>
	        </s:if>
        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
  	
  </body>
</html>
