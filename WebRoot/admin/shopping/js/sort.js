$(function(){ 
		   $("#tjBut").click(function (){
				var srotName =$("#srotName").val();
				var ymSrotKey=$("#ymSrotKey").val();
				var ymSrot=$("#ymSrot").val();
				var pxSrot=$("#pxSrot").val();
				if(srotName==''){
					$("#err").html('类名不能为空!')	;
					return ;
				}
				if(srotName.length>10){
					$("#err").html("长度不能超过10!")	;
					return ;
				}
				if(ymSrotKey.length>256){
					$("#errKey").html("长度不能超过256");
					return ;
				}
				if(ymSrot.length>256){
					$("#errYm").html("长度不能超过256");
					return ;
				}
				if(pxSrot==""){
					$('#errpx').html("不能为空!");
					return ;
				}
				if(isNaN(pxSrot)){
					$('#errpx').html("必须是数字");
					return ;
				}
				$('#form_srotAdd').submit();
			 });
		   $('#srotName').keyup(isOccur).focus(function(){
					isOccur;
				 $("#err").html("")	;
			})
		   function isOccur(){
			   $.ajax({type:'POST',
					   url:$('#path').val()+'admin/shop/sort_isOccurSrot.action',
					   data:'categoryName='+this.value,
						success:function (data){	
						if(data=='1'){
							$("#err").html('以存在改名称!')	;
						}else{
							$("#err").html('')	;
						}								 
				 }})
			   }
			$('#pxSrot').focus(function(){
					 $("#errpx").html("");
					 this.value="1";
				})
})
$(document).ready(function(){
				var succval=$('#succ').val();
				//alert(succval);
				if(succval!=''){
					alert(succval);
					}
			 });
