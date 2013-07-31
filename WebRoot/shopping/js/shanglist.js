// JavaScript Document

$(function(){
	$("ul[class=zhai]").mousemove(function(){
		$(this).hide();
		$(this).next(".kuan").show();
	 });
	$("ul[class=kuan]").mouseout(function(){
		$(this).hide();
		$(this).siblings(".zhai").show();								   
	});
	$("a[name=cate]").mousemove(function(){
			$(this).addClass("dind");
			$(this).siblings().removeClass("dind");
			//得到链接地址
			var href=this.href;
			$.ajax({type:'POST',
				   url:href,
				   data:'',
				   success:function(data){
					   var goodes=eval(data);
					   $("div[class=donwmaid]").empty();//移出所有子节点
					   if(goodes.length==0){
						   $("div[class=donwmaid]").html("没有热销产品");
						}else{
							var htmlStr="";
							var path=$("#path").val();
							for(var i=0;i<goodes.length;i++){
								goods=goodes[i];
								if(i%5==0&&i!=10){
									htmlStr=htmlStr+"<ul>"
								}
								htmlStr=htmlStr+"<li><a href='"+path+"shopping/shpping_showGoods.action?goodsId="+goods.id+"&t=1'><img src='"+path+goods.picPath+"' /></a><p><a href='"+path+"shopping/shpping_showGoods.action?goodsId="+goods.id+"&t=1'>"+goods.name.substring(0,12)+"</a></p><p class='shanzi'>市场价：￥"+goods.sPic+".00 元</p><p>商城价：<b>￥"+goods.pic+".00 元</b></p></li>";
								if(i%5==4){
									htmlStr=htmlStr+"</ul>"
								}
								//alert(htmlStr);
								 $("div[class=donwmaid]").html(htmlStr);
							}
						}
					}
			});
	});
})