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

		<title>支付方式</title>

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

		<form method="post" action="shopping/buy/order!showOrderOk.action"
			name="form_payment" id="form_payment">
			<input type="hidden" name="deliverytypename" id="deliverytypename"
				value="${deliverytypename }" />
			<input type="hidden" name="paymentconfigname" id="paymentconfigname" />
			<input type="hidden" name="goodsid" id="goodsid" value="${goodsid }" />
			<input type="hidden" name="buytype" id="buytype" value="${buytype }" />
			<input type="hidden" name="goodsnum" id="goodsnum" value="${goodsnum }" />
			<div class="mainbody">
				<div class="buz_1"></div>
				<div class="ddu">
					请确认以下信息，然后提交付款信息方式
				</div>
				
				<div class="yti">
					<p>
						<b>确认付款方式： </b>
					</p>
					<div class="tuiz">
						<h1>
							<span>付款方式</span>
						</h1>
						<div class="tt_1">
							<p>
								<input name="paymentconfig" id="paymentconfig" type="radio"
									value="网上支付" />
								<b>网上支付</b><span>（您需要先拥有一张已开通网上支付功能的银行卡。）</span>
							</p>
							<ul>
								<li class="baise">
									支持以下银行
									<p>
										<input type="radio" name="bank" id="bank" value="招商银行" />
										招商银行
										<input type="radio" name="bank" id="bank" value="中国工商银行" />
										中国工商银行
										<input type="radio" name="bank" id="bank" value="中国农业银行" />
										中国农业银行
										<input type="radio" name="bank" id="bank" value="中国建设银行" />
										中国建设银行
										<input type="radio" name="bank" id="bank" value="深琛发展银行" />
										深琛发展银行
									</p>
									<img src="img/shopping_img/fft.gif" />
									<img src="img/shopping_img/st.gif" />
								</li>
							</ul>
							<p>
								<input name="paymentconfig" id="paymentconfig" type="radio"
									value="邮局汇款" />
								<b>邮局汇款</b><span>（您需要先去邮局汇款，所购商品将在款项到达952116综合信息门户网站账户后发出，到款时间一般为2-7个工作日）</span>
							</p>
							<p>
								<input name="paymentconfig" id="paymentconfig" type="radio"
									value="银行转账" />
								<b>银行转账</b><span>（您需要先去银行转账，所购商品将在款项到达952116综合信息门户网站账户后发出，到款时间一般为1-5个工作日）</span>
							</p>
							<p>
								<input type="image" src="img/shopping_img/ty.gif" />
								<span id="spanerror"></span>
							</p>
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
			
				//验证银行有没有选择
				$.validator.methods.check_bank = function(value, element, param){
					if($("input[name='bank']:checked").length==0 && $("input[name='paymentconfig']").eq(0).attr("checked")){ 
						  return false;
					}else{
						return true;
					}
				}  
			
				//表单验证
				$("#form_payment").validate({
					//验证规则
					rules:{
						paymentconfig:"required",
						bank:{
							check_bank:true
						}
					},
					messages:{
						paymentconfig:"请选择一种付款方式!",
						bank:{
							check_bank:"请选择一种网上支付的银行!"
						}
					},
					errorLabelContainer:"#spanerror"
				});	
				
				//选中送货方式
				$("input[name='paymentconfig']").bind("click",function(){
					$("input[name='paymentconfig']").each(function(index){
						if($(this).attr("checked")){
							if(index==0){
								$("#paymentconfigname").val($(this).val()+" "+$("input[name='bank']:checked").val());
							}else{
								$("#paymentconfigname").val($(this).val());
							}
						}
					});
				});
				
				// 银行改变
				$("input[name='bank']").bind("click",function(){
					$("#paymentconfigname").val($("input[name='paymentconfig']:checked").val()+" "+$("input[name='bank']:checked").val());	
				});	
			});
			
		</script>
	</body>
</html>
