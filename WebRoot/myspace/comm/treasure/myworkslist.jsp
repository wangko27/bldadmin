<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-我的作品管理</title>
    
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
	            <li><a href="myspace/comm/uploadSrcList.action">资源管理</a></li>
	            <li><a href="myspace/comm/mquestionList.action">问题管理</a></li>
	            <li class="bai">作品管理</li>
            	<li><a href="myspace/comm/carItemList.action">购物车</a></li>
            	<!-- 
             	<li><a href="myspace/comm/orderList.action">我的订单</a></li>
             	 -->
            	<li><a href="myspace/comm/receiverList.action">地址管理</a></li>
	            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
	          </ul>
	        </div>
	        <div class="ziyuan">
	        	<h1>温馨提示：上传作品参与兴趣活动，可获得官方提供的奖品！请您在参与我们的活动时仔细浏览我们的参赛规则！<br />
	        	<a href="myspace/comm/worksAddGo.action"><img src="img/user_img/zz.gif" width="80" height="24" /></a></h1>
	          <table width="200" border="0" cellspacing="0" cellpadding="0">
	            <tr class="lase">
	              <td class="k1">标题</td>
	              <td class="k2">票数</td>
	              <td class="k2">状态</td>
	              <td class="k3">上传时间</td>
	            </tr>
	            
 			  	<s:iterator value="worksList" status="st" id = "work">
	             <tr>
	              <td class="k1"><a href="interest/Comm_showActivityWorkComm.action?workId=${worksid }">${workstitle }</a></td>
	              <td class="k2">${votes }</td>
	              <td 
		              <s:if test='approstatu == "0"'> class="sz"</s:if>
		              <s:elseif test='approstatu == "1"'> class="kt"</s:elseif>
		              <s:else> class="k2"</s:else>
	              >
		              <s:if test='approstatu == "0"'>审核中</s:if>
		              <s:elseif test='approstatu == "1"'>通过审核</s:elseif>
		              <s:else>未通过审核</s:else>
	              </td>
	              <td class="k3"><fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd HH:mm"/></td>
	             </tr>
	            </s:iterator>
	          </table>
	        </div>
	        
	        
			<s:if test="result != null">
	        <form action="myspace/comm/friendList.action" id="formpage" method="post">
	        	<input type="hidden" name="typeid" id="typeid"/>
	        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="formpage"></t:tpage>
	        </form>
	        </s:if>
	        
	        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 

	<!-- 消息 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
