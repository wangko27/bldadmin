$(function(){
	$(document).ready(function(){
		if($("#isSucc").val()!=''){
			alert($("#isSucc").val());
		}
		$.ajax({type:'POST',
		   url:$('#path').val()+'admin/adv/select_getAdvAddress.action',
		   data:"lj="+$("#lj").val(),
		   success:function(data){
			   var lis=eval(data);
			   if(lis.length<=0){
			  	   var op='<option value="1">暂无广告位可添加</option>'
				   $("#lAdd").append(op);
				   //$('#tjBut').attr("disabled" ,"true" );
			   }else{
				   //$('#tjBut').attr("disabled" ,"false" );
				   for(i=0;i<lis.length;i++){
					   var op='<option value="'+lis[i].id+'">'+lis[i].name+'</option>'
					   $("#lAdd").append(op);
					 }
				}
			 }
		})	
		
	})
	$('#tjBut').click(function(){
		var lAdd=$("#lAdd").val();//广告地址
		var lLoction=$("#lLoction").val();//广告链接
		var begindate=$("#begindate").val();//开始日期
		var enddate=$("#enddate").val();//结束时间
		
		if(lAdd==''){
			alert("广告地址不能为空!");
			return;
		}
		if(lLoction==''||lLoction=='http://'){
			alert("广告链接不能为空!");
			return;
		}
		/*
		if(!IsURL(lLoction)&&lLoction!="#"){
			alert("链接地址格式不对!");
			return;
		}
		*/
		var gpH=$("#gpH").val();//图片路径
		 //验证上传文件类型
		
		 if(gpH!=''){
			 var allowFileType = "JPG,PNG,GIF";
			if(!checkFileType(gpH, allowFileType)){
				alert("请输入'jpg,png,gif'格式的图片!");
				return ;
				};
		}
		
		if(begindate==''){
			alert("请选择开始展示时间!");
			return;
		}
		if(enddate==''){
			alert("请选择结束展示时间!");
			return;
		}
		if(compareDate(begindate,enddate)){
			return;
		}
		$("#form_srotAdd").submit();
	});
	function IsURL(str_url){ 
	  var strRegex = "^((https|http|ftp|rtsp|mms)?://)"  
	  + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
			+ "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184  
			+ "|" // 允许IP和DOMAIN（域名） 
			+ "([0-9a-z_!~*'()-]+\.)*" // 域名- www.  
			+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名  
			+ "[a-z]{2,6})" // first level domain- .com or .museum  
			+ "(:[0-9]{1,4})?" // 端口- :80  
			+ "((/?)|" // a slash isn't required if there is no file name  
			+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
			var re=new RegExp(strRegex);  
			//re.test() 
			if (re.test(str_url)){ 
				return (true);  
			}else{  
				return (false);  
			} 
    } 
})