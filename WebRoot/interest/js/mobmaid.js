// JavaScript Document
$(function(){ 
		   $("img[name=tp]")
		   .bind("click", function(){
					var worksId=$("#worksId").val();
					var urlPath=$("#urlPath").val();
					$.ajax({type:'POST',
						   url:urlPath+'interest/Comm_worksFare.action',
						   data:'workId='+worksId,
						   success: function(msg){
									if(msg=='0'){
										alert("对不起,请登录!");
									}else if(msg=='2'){
										alert("谢谢您的参与，当天限制投票一次");
									}else{
										$("#vot").text("票数："+msg)
										$("#vot2").text(msg+"票");
										$("#vot3").text(msg+"票");
										alert("投票成功!");
									}
								}
						   });
			});
		   $("#yan").mousemove(function (){
				$(this).attr( "style","cursor:hand;" );
			}).click(function(){
				var urlPath=$("#urlPath").val();
				$(this).attr( "src",urlPath+"validatecode?"+Math.floor(Math.random()*100) );
			});
		   $("#fb").click(function (){				
					var yanCode=$("input[name=yanCode]").val();
					var commContext=$("#comContent").val();
					var workId=$("#worksId").val();
					if(yanCode==''){
						alert("验证码不能为空!");
						return false;
					}
					if(commContext==''){
						alert("评论内容不能为空!");
						return false;
					}
					$.ajax({type:'POST',
						   url:'interest/Comm_showCommInfo.action',
						   data:'valiedateCode='+yanCode+'&comContent='+commContext+'&workId='+workId,
						   success: function(msg){
							   	if(msg=='0'){
										alert("对不起,请登录!");
										//form1.submit=false;
								}else if(msg=='1'){
										alert("验证码错误!");
										//form1.submit=false;
								}else if(msg=='2'){
										alert("谢谢您的参与，当天限制评论一次!");
										//form1.submit=false;
								}else
								if(msg=='3'){
										alert("含非法字符,不能提交!");
								}else if(msg=='4'){
										alert("评论成功!");
										window.location.reload();//重新加载页面
								}
							  }
						   });;
			});
});