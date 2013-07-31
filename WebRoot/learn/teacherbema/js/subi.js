// JavaScript Document
function commit(path){
		var type=document.getElementsByName("typeid");
		var context=document.getElementById("termString");
		var typeid='';
		for(var i=0 ;i<type.length;i++){
			if(type[i].checked==true){
					typeid=type[i].value;
					break;
				}
			}
		if(context.value==''){
			alert("请输入查询条件!");
			return ;
		}else{
			//alert(path+'learn/teacherbema_showTerm.action?termString='+context.value+'&typeid='+typeid);
			//location.href=path+'learn/teacherbema_showTerm.action?typeid='+type+'&termString='+termString;
			sForm.submit();
		}
	}