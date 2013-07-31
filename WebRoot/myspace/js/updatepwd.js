$(document).ready(function(){
	
	    var basePath = $("#basePath").val();
		$("#updpwdSubmot").hover(function(){
			$(this).css("cursor","hand");
		}).click(function(){
			var loginpassword = $("#loginpassword").val();
			var newpassword = $("#newpassword").val();
			var renewpassword = $("#renewpassword").val();
			if(loginpassword == ""){
					alert("请填写当前登录密码！");
					$("#loginpassword").focus();
					return false;
			}
			if(newpassword == ""){
				alert("请填写新密码！");
				$("#newpassword").focus();
				return false;
			}
			if(renewpassword == ""){
				alert("请重复填写密码！");
				$("#renewpassword").focus();
				return false;
			}
			if(newpassword != renewpassword){
				alert("两次填写密码不一致！");
				return false;
			}
			$.ajax({
				url:basePath+"member/memberLogin!updatePwd.action",
				type:"post",
    	    	dataType:"json",
				data:{loginpassword:loginpassword, newpassword:newpassword },
				success:function(data){
					if (data.status == "success"){
						alert("密码修改成功！请牢记！");
						$("#loginpassword").val("");
						$("#newpassword").val("");
					    $("#renewpassword").val("");
					} else {
						alert(data.message);
					}
				}
			});
		});

});