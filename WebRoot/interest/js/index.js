$(function(){
		 $("#sumPic").bind("click",function(){
				var typeId=$("#resId").val();
				if($("#resKey").val()==''){
					alert("输入不能为空!");
					return ;
				}
				if(typeId==''||typeId.length<=0){
					alert("请输入类型!");
					return ;
				}else{
					var resfor=$("#resForm");
					resfor.submit();
				}
			});
		$(".neir:first").show();
		 $(".wuse").mouseout(function(){$(this).children(".neir").hide();}).mousemove(function(){$(this).children(".neir").show();});
});
