//加载广告js
$(function(){ 
	$(document).ready(function(){
		$("img[name=advertisement]").each(function(){
			var path='';//图片路径
			var picId=$(this).attr("title");
			var herf='';//链接
			var title='';//标题
			if(picId==''){
				alert("加载失败!");
				return;
			}
			//alert($("base").attr("href"));
			$.ajax({type:'POST',
				   url:$("base").attr("href")+'adv/queryAdv.action',
				   async:false,
				   data:'loctId='+picId,
				   success: function(date){
					  	if(date=='{}'){
							alert("没有数据,请要求管理员添加!");
						}else{
							var json=eval("("+date+")");
							path=json.path;
							herf=json.href;
							title=json.title;
						}
					  }
				});
			//alert(path);
			this.src=path;
			$(this).click(function(){
					window.location=herf;					   
			});
			if(title!="" && title!='null'){
				$(this).next("p").text(title);
			}
		});
	});
})