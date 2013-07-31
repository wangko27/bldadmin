
	var index=0;//记载图片的位置
	var pageNub=4;//显示多少个
	var $imags=$("#lisPics li");//得到所有的图片
	var imagCount=$imags.length;//得到图片的数量
	//载入页面的时候   加载4张图片
	function init(){
		//alert(imagCount);
		if(imagCount<pageNub){
			for(var i=0;i<imagCount;i++){//将图片一个一个的添加到 lis中
				$("#lis").append($imags.get(i));
			}
		}else{
			for(var i=0;i<pageNub;i++){//将图片一个一个的添加到 lis中
				$("#lis").append($imags.get(i));
			}
		}
	}
	//移出 lis中的元素 重新添加
	function disply(ind){
		$("#lis").empty();
		var i=ind;
		//var n=index+pageNub;
		for(i;i<ind+pageNub;i++){
			$("#lis").append($imags.get(i))
		}
	}
	
	//下一页
	function todown(){
		index++;
		//alert(index);
		//如果大于图片数量
		if(index>imagCount-pageNub){
			index=imagCount-pageNub;
		}
		disply(index);
	}
	//上一页
	function toup(){
		//alert();
		index--;
		if(index<0){
			index=0;
		}
		disply(index);
	}