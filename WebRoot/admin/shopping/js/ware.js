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
	$('#subSort').hide();
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
		$('#subSort').children().remove("option[value]");
		if($('#gSrot').val()==' '){
			 $('#subSort').hide();
			 $("#ts").show();
			return;
			}
		$.ajax({type:'POST',
		   url:$('#path').val()+'admin/shop/goods_main!showSubtype.action',
		   data:'gSortId='+$('#gSrot').val(),
		   success:function(date){
			   var gcArray=eval(date);

			   if(gcArray.length==0){
                   var op='<option value=" ">—无下一级类别—</option>';
                   $('#subSort').append(op);
				 $("#ts").show();
				   return ;
				}
			   for(i=0;i<gcArray.length;i++){
				   var op='<option value="'+gcArray[i].id+'">'+gcArray[i].name+'</option>';
				   $('#subSort').append(op);
				   }
				  $('#subSort').show();
				  $("#ts").hide();
			   }
		   })													
		});
	
	$("#gPds").keyup(function(){
		var num=$(this).val().length;
		//alert(num);
			if(num<=128){
				$("#gPdsNum").html("还可以输入"+(128-num)+"个字符. ")	;
			}else{
				$("#gPdsNum").html("页面描叙内容过长!");
			}
		});
	
	$('#tjBut').click(function(){
		var gSrot=$("#gSrot").val();//类型
//        alert("gSrot="+gSrot+",type="+typeof gSrot);
        var subSort = $("#subSort").val();
//        alert("subSort="+subSort+",type="+typeof subSort);
		//alert($("#subSort").val());
		if(gSrot==' '||gSrot==null){
			alert("商品类型不能为空!请选择..");
			return ;
		}
        if(subSort==' '||subSort==null || typeof subSort =='undefined'){
            alert("商品二级类别不能为空!");
            return ;
        }

//        if(typeof subSort )
		var gSn=$("#gSn").val();//货号
		if(gSn==''){
			alert("货号不能为空!");
			return ;
		}
		if(gSn.length>=128){
			alert("货号的长度太长!");
		}
		var goodsName=$("#goodsName").val();//名称
		if(goodsName==''){
			alert("商品名称不能为空!");
			return ;
		}
        var goodsBrand=$("#goodsBrand").val();//名称
        if(goodsBrand=='' || goodsBrand ==null ||typeof goodsBrand =='undefined'){
            alert("品牌名称不能为空!");
            return ;
        }

        var reg=/^(\d+)(\.?)(\d{0,2})$/;
        var regex = new RegExp(reg);
        var gMp=$("#gMp").val();//价格
		if(gMp=='' || isNaN(gMp) || gMp <= 0 ){
			alert("价格不能为空,只能是数字,并且大于0!");
			return ;
		}

		var gPd=$("#gPd").val();//市场价格
		if(gPd=='' || isNaN(gPd) || gPd <= 0){
			alert("市场价格不能为空,只能是数字,并且大于0!");
			return ;
		}
		if(isNaN(gPd)){
			alert("请输入数字!");
			return;
		}
		var gPw=$("#gPw").val();//重量
		if(gPw=='' || isNaN(gPw) || gPw <= 0){
			alert("重量不能为空,只能是数字,并且大于0!");
			return ;
		}
		var gSk=$("#gSk").val();//库存数量
		if(gSk=='' || isNaN(gSk) || gSk <= 0){
			alert("库存数量不能为空,只能是数字,并且大于0!");
			return ;
		}

		if($("#gPds").val().length>128){
			alert("页面描叙内容过长!");
			return ;
		}
		var gOs=$("#gOs").val();//新旧程度
		if(gOs==''){
			alert("输入值不能为空!");
			return;
			}
		var gpH=$("#gpH").val();//图片路径
//        alert("gpH="+gpH+",type="+typeof gpH);
        if(gpH === null || gpH ===' '|| gpH === undefined || typeof gpH === 'undefined'){
            alert("商品图片不能为空!");
            return;
        }
		 //验证上传文件类型
		var allowFileType = "JPG,PNG,GIF";
		if(!checkFileType(gpH, allowFileType)){
			alert("请输入'jpg,png,gif'格式的图片!");
			return ;
		};
		$("#form_gAdd").submit();
	});
	
})