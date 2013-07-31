$(document).ready(function(){
	
	    var basePath = $("#basePath").val();
		//单选按钮操作 start
		$("input[name='memberType']").get(0).checked = true;//默认选择第一个单选框按钮
		var chk_length = $("input[name='memberType']:checked").length;
		$("input[name='memberType']").click(function(){
				var checkValue = $("input[name='memberType']:checked").val();
				var index = parseInt(checkValue) -1 ;
				$("#loginDiv > div")    //选取子节点
					.eq(index).show()
					.siblings().hide();
				if(index == 0){loginValidateImageRefresh('stuLoginValidateImage');}
				if(index == 1){loginValidateImageRefresh('parLoginValidateImage');}
				if(index == 2){loginValidateImageRefresh('teaLoginValidateImage');}
				if(index == 3){loginValidateImageRefresh('touLoginValidateImage');}
		});
	
	//单选按钮操作 end
	
	//学生按钮
    $("#imgStuLoginSubmit").mouseover(function(){
    	$(this).css("cursor","hand");
    }).click(function(){
    	if(chk_length == 0){
			alert("请选择类型！");
			return false;
		}
    	 var $stuUsername = $("#stuUsername");
    	 var $stuPassword = $("#stuPassword");
    	 var $stuValidate = $("#stuValidate");
    	 if($stuUsername.val() == '' || $stuUsername.val() == '校徽卡号'){alert("请填写校徽卡号!");return false;}
   		 if($stuPassword.val() == '' || $stuPassword.val() == '密码'){alert("请填写密码!");return false;}
   		 if($stuValidate.val() == '' || $stuValidate.val() == '输入验证码' ){alert("请填写验证码!");return false;}
    	$.ajax({
    	    url:basePath+"login.action",
    	    type:"post",
    	    dataType:"json",
    	    data:{stuUsername:$stuUsername.val(),stuPassword:$stuPassword.val(),stuValidate:$stuValidate.val(),memberType:'1'},
    	    beforeSend:function(){
    	    	$("body").mask('正在为您验证，请稍后。。。');
    	    },
    	    success: function(data) {
    	    		$("body").unmask();
					if (data.status == "success") {
						$("body").mask('登录成功，正在为您加载数据。。。');
						var lastUrl = getCookie("lastUrl");
						if(lastUrl==undefined || lastUrl == ""){
							location.href = basePath+"openzone/zoneIndexAction!userCenterIndex.action";
						}else{
							location.href = lastUrl;
						}
						
					} else {
					    loginValidateImageRefresh('stuLoginValidateImage');
						$("#stuValidate").val("");
						alert(data.message);
					}
					
					$("#imgStuLoginSubmit").attr("disabled", false);
					
				}
    	});
    });
    
    
    //家长按钮
     $("#imgParLoginSubmit").hover(function(){
     	$(this).css("cursor","hand");
     }).click(function(){
    	 var $parentUsername = $("#parentUsername");
    	 var $parentPassword = $("#parentPassword");
    	 var $parentValidate = $("#parentValidate");
    	 if($parentUsername.val() == '' || $parentUsername.val() == '手机号码'){alert("请填写手机号码!");return false;}
   		 if($parentPassword.val() == '' || $parentPassword.val() == '密码'){alert("请填写密码!");return false;}
   		 if($parentValidate.val() == '' || $parentValidate.val() == '输入验证码' ){alert("请填写验证码!");return false;}
    	$.ajax({
    	    url:basePath+"login.action",
    	    type:"post",
    	    dataType:"json",
    	    data:{parentUsername:$parentUsername.val(),parentPassword:$parentPassword.val(),parentValidate:$parentValidate.val(),memberType:'2'},
    	    beforeSend:function(){
    	    	$("body").mask('正在为您验证，请稍后。。。');
    	    },
    	    success: function(data) {
    	    		$("body").unmask();
					if (data.status == "success") {
						$("body").mask('登录成功，正在为您加载数据。。。');
						var lastUrl = getCookie("lastUrl");
						if(lastUrl==undefined || lastUrl == ""){
							location.href = basePath+"openzone/zoneIndexAction!userCenterIndex.action";
						}else{
							location.href = lastUrl;
						}
						
					} else {
					    loginValidateImageRefresh('parLoginValidateImage');
						$("#parentValidate").val("");
						alert(data.message);
					}
					
					$("#imgParLoginSubmit").attr("disabled", false);
					
				}
    	});
    });
    
    //老师按钮
     $("#imgTeaLoginSubmit").hover(function(){
     	$(this).css("cursor","hand");
     }).click(function(){
    	 var $teacherUsername = $("#teacherUsername");
    	 var $teacherPassword = $("#teacherPassword");
    	 var $teacherValidate = $("#teacherValidate");
    	 if($teacherUsername.val() == '' || $teacherUsername.val() == '手机号码'){alert("请填写手机号码!");return false;}
   		 if($teacherPassword.val() == '' || $teacherPassword.val() == '密码'){alert("请填写密码!");return false;}
   		 if($teacherValidate.val() == '' || $teacherValidate.val() == '输入验证码' ){alert("请填写验证码!");return false;}
    	$.ajax({
    	    url:basePath+"login.action",
    	    type:"post",
    	    dataType:"json",
    	    data:{teacherUsername:$teacherUsername.val(),teacherPassword:$teacherPassword.val(),teacherValidate:$teacherValidate.val(),memberType:'3'},
    	    beforeSend:function(){
    	    	$("body").mask('正在为您验证，请稍后。。。');
    	    },
    	    success: function(data) {
    	    		$("body").unmask();
					if (data.status == "success") {
						$("body").mask('登录成功，正在为您加载数据。。。');
						var lastUrl = getCookie("lastUrl");
						if(lastUrl==undefined || lastUrl == ""){
							location.href = basePath+"openzone/zoneIndexAction!userCenterIndex.action";
						}else{
							location.href = lastUrl;
						}
						
					} else {
					    loginValidateImageRefresh('teaLoginValidateImage');
						$("#teacherValidate").val("");
						alert(data.message);
					}
					
					$("#imgTeaLoginSubmit").attr("disabled", false);
					
				}
    	});
    });
    
    //普通按钮
     $("#imgTouLoginSubmit").hover(function(){
     	$(this).css("cursor","hand");
     }).click(function(){
    	 var $touristUsername = $("#touristUsername");
    	 var $touristPassword = $("#touristPassword");
    	 var $touristValidate = $("#touristValidate");
    	 if($touristUsername.val() == '' || $touristUsername.val() == '手机号码'){alert("请填写账号!");return false;}
   		 if($touristPassword.val() == '' || $touristPassword.val() == '密码'){alert("请填写密码!");return false;}
   		 if($touristValidate.val() == '' || $touristValidate.val() == '输入验证码' ){alert("请填写验证码!");return false;}
    	$.ajax({
    	    url:basePath+"login.action",
    	    type:"post",
    	    dataType:"json",
    	    data:{touristUsername:$touristUsername.val(),touristPassword:$touristPassword.val(),touristValidate:$touristValidate.val(),memberType:'4'},
    	    beforeSend:function(){
    	    	$("body").mask('正在为您验证，请稍后。。。');
    	    },
    	    success: function(data) {
    	    		$("body").unmask();
					if (data.status == "success") {
						$("body").mask('登录成功，正在为您加载数据。。。');
						var lastUrl = getCookie("lastUrl");
						if(lastUrl==undefined || lastUrl == ""){
							location.href = basePath+"openzone/zoneIndexAction!userCenterIndex.action";
						}else{
							location.href = lastUrl;
						}
						
					} else {
					    loginValidateImageRefresh('touLoginValidateImage');
						$("#touristValidate").val("");
						alert(data.message);
					}
					
					$("#imgTouLoginSubmit").attr("disabled", false);
					
				}
    	});
    });
    
    
   	// 刷新验证码图片
	function loginValidateImageRefresh(id) {
		$("#"+id).attr("src",'validatecode?now='+(new Date()).valueOf());
	}
	
	//js读取cookie
	function getCookie(name)//取cookies函数        
	{
	    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
	    if(arr != null){
	    	var url=unescape(arr[2]);
	    	url=url.substring(1,url.length-1);
	    	return url;
	    }
	    return null;
	}

});