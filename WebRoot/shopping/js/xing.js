
function showXin(name,number,path){
	var lxin;
	var xin;
	var liname=document.getElementById(name);
	var images='';
	if(number==0||isNaN(number)){
		
		for(var i=0;i<5;i++){
			images=images+'<img src="'+path+'img/common_img/xing_1.gif" />';
			}
	}else{
		lxin=parseInt(number/2);
		xin=5-lxin;
		for(var i=0;i<lxin;i++){
			images=images+' <img src="'+path+'img/common_img/xing.gif" />';
		}
		for(var j=0;j<xin;j++){
			images=images+' <img src="'+path+'img/common_img/xing_1.gif" />';
		}
	}
	liname.innerHTML=images;
	
}