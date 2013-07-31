//javascript
$(function(){ 
	$(":checkbox").click(function(){
		var tol=0;
		var value=$(this).val();
		$(":checkbox:checked").each(function(){
				tol=tol+parseInt(this.alt);	
		})
		//alert(tol);
		$("#to2").text(tol);
		$("#to1").text(tol);
		
		$("#"+value).attr("disabled","true");
		$("#p"+value).hide();
		$("#d"+value).hide();
		
		if(!this.checked==""){
			$("#"+value).removeAttr("disabled");
			$("#p"+value).show();
			$("#d"+value).show();
		}
	});
	$("#delSel").bind("click",function(){
		if($("input[name='goodsids']:checked").length==0){
					alert("请至少选择一件商品!");
					return ;
		}
		if(confirm("你确定要删除吗?")){
			$("#form_del").submit();	  
		}
	});
})