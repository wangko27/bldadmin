<%@ page language="java" pageEncoding="UTF-8"%>
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

		<title>舒天便民后台管理系统</title>
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<link href="css/adminlogin.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript">
			$().ready(function(){
			
				//表单验证
				$("#formLogin").validate({
					//验证规则
					rules:{
						username:"required",
						adminpassword:"required",
						adminvalidate:"required"						
					},
					messages:{
						username:"账号不能为空!",
						adminpassword:"密码不能为空!",
						adminvalidate:"验证码不能为空!"
					},
					/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
			        showErrors: function(errorMap, errorList) {   
			            var msg = "";   
			            $.each( errorList, function(i,v){   
			              msg += (v.message+"\r\n");   
			            });   
			            if(msg!=""){ 
			            	alert(msg);
			            }   
			        },   
			        /* 失去焦点时不验证 */    
			        onfocusout: false
				});
			});
		</script>
	</head>

	<body>
		<form action="adminlogin/login!login.action" method="post" name="formLogin" id="formLogin">
			<div class="big">
				<div class="lobj">
					<div class="lodk">
						<ul>
							<li>
								<span>账&nbsp;&nbsp;号</span>
								<span><input name="username" id="username" type="text"
										class="put" /> </span>
							</li>
							<li>
								<span>密&nbsp;&nbsp;码</span>
								<span><input name="adminpassword" id="adminpassword"
										type="password" class="put" /> </span>
							</li>
							<%--<li>--%>
								<%--<span>验证码</span><span> <input name="adminvalidate"--%>
										<%--id="adminvalidate" type="text" class="put1" /> </span><span><img--%>
										<%--src="validatecode" id="stuLoginValidateImage" alt="点击图片更换验证码"--%>
										<%--onmouseover="javascript:this.style.cursor='hand'"--%>
										<%--onclick="javascript:this.src = 'validatecode?now='+new Date()" />--%>
								<%--</span>--%>
							<%--</li>--%>
							<li class="qw">
								<span><input type="image"
										src="img/admin_login/dd.gif" /> </span><span><a
									href="#"><img src="img/admin_login/qq.gif"
											width="88" height="48" /> </a> </span>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="bottom">
				<div class="bot1">
                    湖南舒天网络科技发展有限公司 Copyright(C)2004-2013 湘ICP备11007592号
					<br />

				</div>
			</div>
		</form>
		
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
