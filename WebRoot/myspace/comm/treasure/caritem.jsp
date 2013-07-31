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
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-购物车管理</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/trolley.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
	
		$().ready(function() {	
			
			//全选按钮的change事件
			$("#allche").bind("change",function(){
			
				var chevalue = $("#allche").attr("checked");
				
				var newids = "";
				$("input[name='chename']").each(function(){
					$(this).attr("checked",chevalue);
					if(chevalue){
						if(newids == ""){
							newids = newids + $(this).val();
						}
						else{
							newids = newids + "," + $(this).val();
						}
					}
				});
				
				$("#goodidlist").val(newids);
				
			});
		});
		
		function cheonchange(){
			var oSource = window.event.srcElement ; 
			var oid = "#"+oSource.id;
			
			var ids = $("#goodidlist").val();

			var newids = "";
			
			//增加一个商品编号
			if($(oid).attr("checked")){
				if(ids == ""){
					newids = ids + $(oid).val();
				}
				else{
					newids = ids + ","+$(oid).val();
				}
			}
			//删除一个商品编号
			else{
				var list = ids.split(',');
				for(var i = 0 ; i < list.length ; i ++ ){
					if(list[i]!= $(oid).val()){
						if(newids == ""){
							newids = newids + list[i];
						}
						else{
							newids = newids + "," + list[i];
						}
					}
				}
				
			}
			
			
			$("#goodidlist").val(newids);
		}
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
	        
	        <div class="bobti">百宝箱</div>
	        <div class="dtai">
	          <ul>
	            <li><a href="myspace/comm/downManaList.action">下载管理</a></li>
	            <li><a href="myspace/comm/uploadSrcList.action">资源管理</a></li>
	            <li><a href="myspace/comm/mquestionList.action">问题管理</a></li>
	            <li><a href="myspace/comm/worksList.action">作品管理</a></li>
            	<li class="bai">购物车</li>
            	<!-- 
             	<li><a href="myspace/comm/orderList.action">我的订单</a></li>
             	 -->
            	<li><a href="myspace/comm/receiverList.action">地址管理</a></li>
	            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
	          </ul>
	        </div>
	        <div class="tablist">
	          <div class="bti">
	            <ul>
	              <li class="c1">商品</li>
	              <li class="c2">商城价(元)</li>
	              <li class="c2">数量</li>
	              <li class="c3">实付金额(元)</li>
              	  <li class="c3"><!-- 订单 -->状态</tli>
	              <li class="c3" style="border-right:none;">操作</li>
	            </ul>
	          </div>
	          <table border="0" cellspacing="0" cellpadding="0" width="755" class="lan">
	            
 			  <s:iterator value="carItemList" status="st" id = "caritem">
	            <tr>
	              <td>
	                  <table border="0" cellspacing="0" width="445" cellpadding="0" class="ss">
	                      <tr>
	                        <td class="k1"><ul>
	                        	<li class="che">
	                        	<%--
							          <input id="che${st.count }" onclick="cheonchange(this);" name="chename" type="checkbox" value="${goods.goodsid }" />
	                        	 --%>
	                        	</li>
	                            <li class="ttu">
							        <a href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1"><img src="${ goods.photospath}" onerror="this.src='userspacefile/default/albumcover.gif'" /></a>
						        </li>
	                            <li class="zzi"><a href="shopping/shpping_showGoods.action?goodsId=${goods.goodsid }&t=1">${goods.goodsname }</a></li>
	                          </ul></td>
	                        <td class="k2">${goods.productprice }</td>
	                        <td class="k2">${quantity }</td>
	                      </tr>
	                      
	                    </table>
	                </td>
	              <td class="k3"><b>${goods.productprice * quantity }</b></td>
              	  <td class="k3"><span><!-- 等待付款 -->想购买</span></td>
	              <td class="k3">
	              <%--
	              <a href="shopping/buy/order!showReceiver.action?goodsid=${goods.goodsid }&buytype=2"><img src="img/user_img/fu.gif"/></a>
	               --%>
	              <br /><a href="myspace/comm/carItemDel.action?cartitemid=${cartitemid }"  onClick="return(confirm('確定刪除?'))">删除</a>
	              </td>
	            </tr>
 			  </s:iterator>
	             
	          </table>
	        </div>
	        <form action="shopping/buy/order!showReceiver.action" method="post" id="manypayform">
	        <div class="huise">
	        	<%--
		        <span>
		          <input id="allche" name="" type="checkbox" value="" />
		        </span> 
		        <span>全选</span>
		        <span id="manypay"><a href="javascript:manypayform.submit();"><img src="img/user_img/fu1.gif" width="66" height="23" /></a></span>
		         --%>
		        <b>共：${totalPrice }元</b> 
			</div>
	        <input type="hidden" id="goodidlist" name="goodsid" />
	        <input type="hidden" name="buytype" value="2" />
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
