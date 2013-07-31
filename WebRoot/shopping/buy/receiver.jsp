<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />

		<title>收货地址</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/shopping/shopping_common.css" rel="stylesheet"
			type="text/css" />
		<link href="css/shopping/gwc.css" rel="stylesheet" type="text/css" />

	</head>

	<body>

		<jsp:include page="/shopping/top.jsp"></jsp:include>

		<div class="mainbody">
			<div class="seat">
				<a href="learn/readbook!view.action">952116综合信息门户网首页</a> &gt;
				<a href="shopping/shoppingIndex_showIndex.action?t=">商城</a> &gt;
				<span>购买</span>
			</div>
		</div>

		<div class="mainbody">
			<div class="buz_1"></div>
			<div class="ddu">
				请确认以下信息，然后提交收货信息
			</div>
			<div class="ggy">
				<div class="yti">
					<p>
						<b>确认收货地址：<a href="#" onclick="return a_add();">[新增]</a> </b>
					</p>

					<form action="shopping/buy/AddReceiver.action" method="post"
						name="form_receiver" id="form_receiver">
						<s:token></s:token>
						<input type="hidden" name="isdefault" id="isdefault" value="1" />
						<input type="hidden" name="goodsid" id="goodsid" value="${goodsid }" />
						<input type="hidden" name="buytype" id="buytype" value="${buytype }" />
						<input type="hidden" name="goodsnum" id="goodsnum" value="${goodsnum }" />
						<div class="tuiz" id="divreceiverinfo"
							<s:if test="#request.list_receiver.size>0"> style="display:none" </s:if>>
							<h1>
								<span>新增收货人信息</span>
							</h1>
							<ul>
								<li>
									<span>*</span> 收&nbsp;&nbsp;货&nbsp;&nbsp;人：
									<input name="recusername" id="recusername" type="text" />
								</li>
								<li>
									<span>*</span>
									地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：
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
									<span>*</span> 街道地址：
									<input name="receiveraddress" id="receiveraddress" type="text" />
								</li>
								<li>
									<span>*</span>
									邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：
									<input name="zipcode" id="zipcode" type="text" />
								</li>
								<li>
									<span>*</span>
									手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：
									<input name="receivermobile" id="receivermobile" type="text" />
									或固定电话：
									<input name="receiverphone" id="receiverphone" type="text" />
								</li>
								<li class="io">
									<a href="#"
										onclick="javascript:$('#form_receiver').submit();return false;"><img
											src="img/shopping_img/ty.gif" /> </a>
									<s:if test="#request.list_receiver.size>0">
										<a href="#" onclick="return a_cancel();"><img
												src="img/shopping_img/ty_1.gif" /> </a>
									</s:if>
								</li>
							</ul>
						</div>
					</form>
					<s:if test="#request.list_receiver.size>0">
						<form action="shopping/buy/UpdateReceiver.action" method="post">
							<s:token></s:token>
							<input type="hidden" name="goodsid" id="goodsid" value="${goodsid }" />
							<input type="hidden" name="buytype" id="buytype" value="${buytype }" />
							<input type="hidden" name="goodsnum" id="goodsnum" value="${goodsnum }" />
							<s:iterator value="#request.list_receiver" id="receiver">
								<p>
									<input name="receiverid" id="receiverid" type="radio"
										value="${receiver.receiverid }"
										<s:if test="#request.receiver.isdefault==1">checked</s:if> />
									${receiver.areapath } ${receiver.receiveraddress }

								</p>
							</s:iterator>
							<p id="spanok">
								<input type="image" src="img/shopping_img/ty.gif" />
								
								<span style="padding:10px;color:red">备注：地址如有变动，请到“<a href="myspace/comm/receiverList.action">用户中心</a>”修改</span>
							</p>
						</form>
					</s:if>
				</div>
			</div>
		</div>

		<jsp:include page="/shopping/buy/bill.jsp"></jsp:include>
		
		<jsp:include page="/base/bottom.jsp"></jsp:include>
		
		
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript">
			/*
			$.validator.setDefaults({
				submitHandler: function() { alert("submitted!"); }
			});*/
		
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
				
				//验证手机和电话号码
				$.validator.methods.check_phone = function(value, element, param){
					if($("#receiverphone").val()=="" && $("#receivermobile").val()==""){
						return false;
					}else{
						return true;
					}
				}  
			
				//表单验证
				$("#form_receiver").validate({
					//验证规则
					rules:{
						recusername:"required",
						county:{
							check_xzqh:true
						},
						receiveraddress:"required",
						zipcode:"required",
						receiverphone:{
							check_phone:true
						}
					},
					messages:{
						recusername:"收货人不能为空!",
						county:{
							check_xzqh:"请选择地区!"
						},
						receiveraddress:"街道地址不能为空!",
						zipcode:"邮编不能为空!",
						receiverphone:{
							check_phone:"手机或固定电话号码必填一个!"
						}
					}
				});			
				
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
			});
			
			//新增
			function a_add(){
				
				$("input[name='receiverid']").each(function(){
					$(this).attr("disabled",true);
					$(this).attr("checked",false);
				});
				
				$("#divreceiverinfo").show();
				$("#spanok").hide();
				return false;
			}
			
			//取消
			function a_cancel(){
				$("input[name='receiverid']").each(function(index){
					$(this).attr("disabled",false);
					if(index==0){
						$(this).attr("checked",true);
					}
				});
				
				$("#divreceiverinfo").hide();
				$("#spanok").show();
				return false;
			}
		</script>
	</body>
</html>
