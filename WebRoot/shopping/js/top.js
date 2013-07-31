// JavaScript Document
$(function(){ 		   
	$("#seaImg").bind("click", function(){
		var key=$("#key").val();
		if(key=='' || key=='请输入关键词，如：儿童,书本'){
			alert('请输入关键字');
			$("#key").val('请输入关键词，如：儿童,书本');
			return ;
		}
		$("#seaFor").submit();	
	});
	$("#key").focusin(function(){
			$(this).val('');
		});
	$("#ls").bind("click",function(){
		 var base=$("base").attr("href");
		 document.location=base+"myspace/comm/carItemList.action"})
})