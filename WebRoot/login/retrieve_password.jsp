<%@ page language="java" pageEncoding="utf-8"%>
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

		<title>您好，欢迎来到952116综合信息门户网！ -- 找回密码</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/login/common.css" rel="stylesheet" type="text/css" />
		<link href="css/login/log.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript">
			/*$.validator.setDefaults({
				submitHandler: function() { alert("submitted!"); }
			});*/
		
			$().ready(function() {
			
				$("#formPassword").validate({
					//验证规则
					rules:{
						username:"required",
						email:"required"
					},
					messages:{
						username:"用户名不能为空!",
						email:"邮箱不能为空!"
					},
					/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
			        showErrors: function(errorMap, errorList) {   
			            var msg = "";   
			            $.each( errorList, function(i,v){   
			              msg += (v.message+"\r\n");   
			            });   
			            if(msg!="") alert(msg);   
			        },   
			        /* 失去焦点时不验证 */    
			        onfocusout: false 
				});
			});
		</script>
	</head>

	<body>

		<jsp:include page="/base/top.jsp"></jsp:include>

		<jsp:include page="/base/toplink.jsp"></jsp:include>

		<div class="mainbody">
			<div class="logo_1">
				家校快捷方便沟通的平台
			</div>
		</div>
		<form action="retrievepassword.action" name="formPassword" id="formPassword" method="post">
			<s:token></s:token>	
			<div class="mainbody">
				<div class="zhuce">
					<div class="tit">
						<span>忘记密码</span>
						<a href="login/register.jsp">还没账号，请注册！</a>
					</div>
					<div class="xunmi">
						<div class="mibj">
							找回密码
							<span>此功能一天只能使用一次！</span>
						</div>
						<div class="mimp">
							输入您的邮箱账号，我们将把您的密码发送到邮箱！建议您把密码修改成您常用密码！
						</div>
						<div class="chahao">
							请输入您的用户名：
						</div>
						<div class="chahao_1">
							<input name="username" id="username" type="text" />
						</div>
						<div class="chahao">
							请输入您的邮箱账号：
						</div>
						<div class="chahao_1">
							<input name="email" id="email" type="text" />
						</div>
						<div class="chahao_2">
							<input type="image" src="img/login/qq4.gif" />
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<jsp:include page="/base/bottom.jsp"></jsp:include>
		
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
