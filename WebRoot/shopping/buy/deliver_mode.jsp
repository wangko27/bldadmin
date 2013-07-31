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

		<title>送货方式</title>

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
				<a href="#">952116综合信息门户网首页</a> &gt;
				<a href="shopping/shoppingIndex_showIndex.action?t=">商城</a> &gt;
				<span>购买</span>
			</div>
		</div>

		<form method="post" action="shopping/buy/order!showPayment.action"
			name="form_deliver" id="form_deliver">
			<input type="hidden" name="deliverytypename" id="deliverytypename" />
			<input type="hidden" name="goodsid" id="goodsid" value="${goodsid }" />
			<input type="hidden" name="buytype" id="buytype" value="${buytype }" />
			<input type="hidden" name="goodsnum" id="goodsnum" value="${goodsnum }" />
			<div class="mainbody">
			
				<div class="buz_1"></div>
				<div class="ddu">
					请确认以下信息，然后提交送货方式
				</div>
				
				<div class="ggy">
					<div class="yti">
						<p>
							<b>确认送货方式：</b>
						</p>
						<div class="tuiz">
							<h1>
								<span>送货方式</span>
							</h1>
							<div class="tt_1">
								<p>
									<input name="deliverytype" id="deliverytype" type="radio"
										value="普通快递送货上门" />
									<b>普通快递送货上门</b>
								</p>
								<ul>
									<li>
										送货上门时间：
										<select name="deliverytime" id="deliverytime">
											<option value="周一到周五">
												周一到周五
											</option>
											<option value="周末">
												周末
											</option>
											<option value="任何时间">
												任何时间
											</option>
										</select>
									</li>
									<li class="baise">
										请确认收货地址在岳麓区的以下范围内，才可选择此项！
										<br />
										<span>除东方红旗下属村租外，其它均可送。</span>
									</li>
								</ul>
								<p>
									<input name="deliverytype" id="deliverytype" type="radio"
										value="普通邮递" />
									<b>普通邮递</b>
								</p>
								<p>
									<input name="deliverytype" id="deliverytype" type="radio"
										value="邮政特快专递EMS" />
									<b>邮政特快专递EMS</b>
								</p>
								<p>
									<input type="image" src="img/shopping_img/ty.gif" />

									<span id="spanerror"></span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>

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
			
				//表单验证
				$("#form_deliver").validate({
					//验证规则
					rules:{
						deliverytype:"required"
					},
					messages:{
						deliverytype:"请选择一种送货方式!"
					},
					errorLabelContainer:"#spanerror"
				});	
				
				//选中送货方式
				$("input[name='deliverytype']").bind("click",function(){
					$("input[name='deliverytype']").each(function(index){
						if($(this).attr("checked")){
							if(index==0){
								$("#deliverytypename").val($(this).val()+" "+$("#deliverytime").val()+"送货");
							}else{
								$("#deliverytypename").val($(this).val());
							}
						}
					});
				});
				
				// 送货时间改变
				$("#deliverytime").bind("change",function(){
					$("#deliverytypename").val($("input[name='deliverytype']:checked").val()+" "+$(this).val()+"送货");	
				});	
			});
			
		</script>
	</body>
</html>
