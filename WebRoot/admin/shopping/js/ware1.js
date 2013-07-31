$(document).ready(function(){
	if($('#succes').val()!=''){
		alert($('#succes').val());
	}
	$.ajax({type:'POST',
		   url:$('#path').val()+'admin/shop/goods_main.action',
		   data:'',
		   success:function(date){
			   var gcArray=eval(date);
			   for(i=0;i<gcArray.length;i++){
				   var op='<option value="'+gcArray[i].id+'">'+gcArray[i].name+'</option>';
				   $('#gSrot').append(op);
				   }
			   }
		   })
	$('#gcsrot').hide();
	$("#ts").show();
});

$(function(){ 
	$(":radio").click(function(){
		var value=$(":radio:checked").val();
		if(value==0){
			$("#zl").hide(10);
			$("#gPw").val(0);
		}else if(value==1){
			$("#zl").show(10);
		}
	});
	$('#gSrot').change(function(){
		$('#gcsrot').children().remove("option[value]");
		if($('#gSrot').val()==' '){
			 $('#gcsrot').hide();
			 $("#ts").show();
			return;
			}
		$.ajax({type:'POST',
		   url:$('#path').val()+'admin/shop/goods_main!showSubtype.action',
		   data:'gSortId='+$('#gSrot').val(),
		   success:function(date){
			   var gcArray=eval(date);
			   if(gcArray.length==0){
				 $('#gcsrot').hide();
				 $("#ts").show();
				   return ;
				}
			   for(i=0;i<gcArray.length;i++){
				   var op='<option value="'+gcArray[i].id+'">'+gcArray[i].name+'</option>';
				   $('#gcsrot').append(op);
				   }
				  $('#gcsrot').show();
				  $("#ts").hide();
			   }
		   })													
	});
		$('#tjBut').click(function(){

        var gcsrot =  $("#gcsrot").val();//二级分类
//		alert("gcsrot="+gcsrot);
		if(gcsrot==' '||gcsrot==null){
			alert("商品类型不能为空!请选择..");       ;
			return ;
		}
		var gSn=$("#gSn").val();//货号
		if(gSn==''){
			alert("货号不能为空!");
			return ;
		}
		var goodsName=$("#goodsName").val();//名称
		if(goodsName==''){
			alert("商品名称不能为空!");
			return ;
		}
        var goodsBrand=$("#goodsBrand").val();//名称
        if(goodsBrand=='' || goodsBrand ==null|| typeof goodsBrand =='undefined' ){
            alert("品牌名称不能为空!");
            return ;
        }
		var gMp=$("#gMp").val();//价格
		if(gMp==''){
			alert("价格不能为空!");
			return ;
		}
		if(isNaN(gMp)){
			alert("请输入数字!");
			return ;
		}
		var gPd=$("#gPd").val();//市场价格
		if(gPd==''){
			alert("市场价格不能为空!");
			return ;
		}
		if(isNaN(gPd)){
			alert("请输入数字!");
			return;
		}
		var gPw=$("#gPw").val();//重量
		if(gPw==''){
			alert("重量不能为空!");
			return ;
		}
		if(isNaN(gPw)){
			alert("请输入数字!");
			return;
		}
		var gSk=$("#gSk").val();//库存数量
		if(gSk==''){
			alert("库存数量不能为空!");
			return ;
		}
		if(isNaN(gSk)){
			alert("请输入数字!");
			return;
		}
		var gOs=$("#gOs").val();//新旧程度
		if(gOs==''){
			alert("输入值不能为空!");
			return;
			}
		var gpH1=$("#gpH1").val();//图片路径

		 //验证上传文件类型
		 if( gpH1 != '' && gpH1 != null && typeof(gpH1) != 'undefined'){
		 	var allowFileType = "JPG,PNG,GIF";
			if(!checkFileType(gpH1, allowFileType)){
				alert("请输入'jpg,png,gif'格式的图片!");
				return ;
			};
		 }
		
		
		$("#form_gAdd").submit();
	});
	
})