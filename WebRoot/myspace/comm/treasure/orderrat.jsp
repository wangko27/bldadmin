<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-订单管理</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/usermaid.css" rel="stylesheet" type="text/css" />
	<link href="css/user/pohto.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="js/jquery-1.4.2.js">
	</script>
	<script type="text/javascript">
		
		$().ready(function() {
			//提交
			$("#subbtn").click(function(){
				$("#formsub").attr("action","myspace/comm/orderRat.action");
				$("#form1").submit();
			});
			
			
			$("#cancel").click(function(){
				$("#formsub").attr("action","myspace/comm/orderList.action");
				$("#form1").submit();
			});
		});
		
	</script>
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
	        
	        <div class="bobti"> 评论 </div>
	        <div class="discuss">
	          <ul>
	            <li class="discuss_xz">评论须知：</li>
	            <li>1、请您根据本次交易，给予真实、客观、仔细地评论。您的评论将是其他会员的参考。</li>
	            <li>2、评论成功后无法进行修改。</li>
	          </ul>
	        </div>
	        
	        <form id="form1" action="myspace/comm/orderRat.action" method="post">
	        <s:token></s:token>
	        <input type="hidden" name="orderid" value="${myorder.orderid }" />
	        <div class="discuss1">
			  <s:iterator value="myorder.orderitems" status="stitem" id = "item">
			   <table width="730" border="0" align="center" cellpadding="0" cellspacing="0">
	            <tr>
	            <input type="hidden" name="goodids" value="${goods.goodsid }" id="goodids"　/>
	              <td colspan="2" class="discuss_sp">被评商品：<span class="blue">${goods.goodsname }</span></td>
	            </tr>
	            <tr>
	              <td><textarea name="ratcotents" id="textarea" cols="60" rows="8"></textarea></td>
	              <td>&nbsp;&nbsp;欢迎给予真实、客观地评价</td>
	            </tr>
	            <tr>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	          </table>
	          <hr />
			  </s:iterator>
              <table width="100%" border="0"  cellpadding="0" cellspacing="0">
	            <tr>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	            <tr>
	              <td align="left" width="38%" ><input type="checkbox" name="isAnonys" id="checkbox" />&nbsp;&nbsp;匿名评论</td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
                <tr>
                  <td align="center"><img src="img/user_img/qrtj.gif" width="78" height="25" id="subbtn"/></td>
                  <td align="center">&nbsp;</td>
                  <td align="left"><img src="img/user_img/yhzp.gif" width="78" height="25" id="cancel" /></td>
                  </tr>
              </table>
	        </div>
	        </form>
			
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
