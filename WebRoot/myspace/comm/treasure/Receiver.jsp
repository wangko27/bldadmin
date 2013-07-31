<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-收货地址管理</title>
    
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
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>

	<style type="text/css" media="screen">
	.tance {
		width:600px;
		background:#fff;
		height:200px;
		border:3px solid #a2d0ff;
		position:absolute;
		top:50%;
		left:50%;
		margin:-100px 0px 0px -300px;
	}
	.tance ul {
		padding:10px 0px 10px 50px;
		width:550px;
		border:none;
	}
	.tance ul li {
		float:left;
		width:540px;
		padding:5px 0px;
	}
	.tance ul li select {
		width:80px; font-size:12px;
	}
	input.chaa {
		background:url(img/user_img/uy1.gif);
		border:none;
		width:18px;
		height:18px;
		float:right
	}
	</style>
	
	
	<script type="text/javascript">
		$().ready(function() {	
		
			//添加自定义方法
			
			//验证地区
			$.validator.methods.check_xzqh = function(value, element, param){
				if($("#province").val()=="" || $("#province").val()==null || $("#city").val()=="" || $("#city").val()==null || $("#county").val()=="" || $("#county").val()==null){
					return false;
				}else{
					return true;
				}
			}		
					
				
				//省市县级联
				$("#province").bind("change",function(){
					$.ajax({
						type:"post",
						url:"dsis/xzqh!getCityOption.action",
						data:{provinceBm:$(this).val()},
						dataType:"text",
						success:function(msg){
							$("#city option").remove();
							$(msg).appendTo("#city");
							
							$.ajax({
								type:"post",
								url:"dsis/xzqh!getCountyOption.action",
								data:{cityBm:$("#city").val()},
								dataType:"text",
								success:function(msg){
									$("#county option").remove();
									$(msg).appendTo("#county");
								},
								error:function(xhr,msg,e){
									alert("error");
								}
							});
						},
						error:function(xhr,msg,e){
							alert("error");
						}
					});
				});
				
				//市县级联
				$("#city").bind("change",function(){
					$.ajax({
						type:"post",
						url:"dsis/xzqh!getCountyOption.action",
						data:{cityBm:$(this).val()},
						dataType:"text",
						success:function(msg){
							$("#county option").remove();
							$(msg).appendTo("#county");
						},
						error:function(xhr,msg,e){
							alert("error");
						}
					});
				});
			
			//关闭弹出层
			$("#divcloseupd").click(function(){
				$("#updreceiver").css("display","none");
			});
		});
		
		function showUpdDiv(id,area,address){
			$("#updreceiver").css("display","block");
			$("#updre").html(area+" "+address);
			
			$("#receiverid").val(id);
			$("#address").val(address);
			
			//取省份
			$.ajax({
				type:"post",
				url:"myspace/comm/receiverUpdGo.action",
				data:{area:area},
				dataType:"text",
				success:function(msg){
					if(msg == "exception"){
						alert("error");
					}
					$("#province option").remove();
					$(msg).appendTo("#province");
					
					var list = area.split(' ');
					//选中省份
					$("#province option").each(function(){
						if($(this).text()==list[0]){
							$(this).attr("selected","true");
							
							//选中后查询城市
							$.ajax({
								type:"post",
								url:"dsis/xzqh!getCityOption.action",
								data:{provinceBm:$(this).val()},
								dataType:"text",
								success:function(msg){
									$("#city option").remove();
									$(msg).appendTo("#city");
									
									//选中城市
									$("#city option").each(function(){
										if($(this).text()==list[1]){
											$(this).attr("selected","true");
											$.ajax({
												type:"post",
												url:"dsis/xzqh!getCountyOption.action",
												data:{cityBm:$(this).val()},
												dataType:"text",
												success:function(msg){
													$("#county option").remove();
													$(msg).appendTo("#county");
													
													//选中区县
													$("#county option").each(function(){
														if($(this).text()==list[2]){
															$(this).attr("selected","true");
														}
													});							
													
												},
												error:function(xhr,msg,e){
													alert("error");
												}
											});
										}
									
									});
									
								},
								error:function(xhr,msg,e){
									alert("error");
								}
							});
						}
					});
							
				},
				error:function(xhr,msg,e){
					alert("error");
				}
			});
			
			

			
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
            	<li><a href="myspace/comm/carItemList.action">购物车</a></li>
            	<!-- 
             	<li><a href="myspace/comm/orderList.action">我的订单</a></li>
             	 -->
            	<li class="bai">地址管理</li>
	            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
	          </ul>
	        </div>
	        
	        <div class="queslist">
	          <table border="0" cellspacing="0" cellpadding="0">
	            <tr>
	              <td class="lsr">收货地址</td>
	              <td class="lsr">操作</td>
	            </tr>
	            
 			    <s:iterator value="receiverList" status="st" id = "receiver">
	            <tr>
	              <td>${areapath }&nbsp;&nbsp;
	                <c:choose>
	          		<c:when test="${fn:length(receiveraddress)<10}">${receiveraddress}</c:when>
	          		<c:otherwise>${fn:substring(receiveraddress,0,10)}...</c:otherwise> 
	          		</c:choose>
	              </td>
	              <td>
	              <a href="javascript:showUpdDiv('${receiverid }','${areapath }','${receiveraddress}');" >修改</a> | 
	              <a href="myspace/comm/receiverDel.action?receiverid=${receiverid }"  onClick="return(confirm('確定刪除?'))">删除</a>
	              </td>
	            </tr>
	            </s:iterator>
	            
	          </table>
	        </div>
	        
      		<div class="tance" id="updreceiver" style="display:none" >
      		<form action="myspace/comm/receiverUpd.action">
      			<s:token></s:token>
      			<input name="receiver.receiverid" id="receiverid" type="hidden"/>
                <ul>
                  <li>
                    <input name="" type="button" class="chaa"  id="divcloseupd"/>
                  </li>
                  <li>您要修改的地址是：“<span id="updre"></span>”</li>
                  <li>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：
                    <select name="province" id="province">
						<s:iterator value="#request.list_province" id="province">
							<option value="${province.bm }">
								${province.mc }
							</option>
						</s:iterator>
					</select>
					<select name="city" id="city">
						<s:iterator value="#request.list_city" id="city">
							<option value="${city.bm }">
								${city.mc }
							</option>
						</s:iterator>
					</select>
					<select name="county" id="county">
						<s:iterator value="#request.list_county" id="county">
							<option value="${county.bm }">
								${county.mc }
							</option>
						</s:iterator>
					</select>
                  </li>
                    <li>
                   街道地址：
                   <input id="address" name="receiver.receiveraddress" type="text"  style="float:none; width:330px;"/>
                  </li>
                  <li>
                    <input name="确定" type="submit" id="确定" value="确定" />
                  </li>
                </ul>
            </form>
            </div>
            
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
