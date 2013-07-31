// JavaScript Document

$(function(){ 
	var path=$("#path").val();
	$("#ffPic").bind("click",function(){
		var goodNum=$("#goodNum").val();//商品数量
		var goodsid=$("#goodsid1").val();//商品id
		if(goodNum==''||isNaN(goodNum)){
			alert("请输入正确的数目!");
			$("#goodNum").val('1')
			return ;
		}
		if(parseInt(goodNum)<=0){
				alert("请输入正整数!");
				$("#goodNum").val('1');
				return ;
			}
		if(goodsid==''||goodsid.length==0){
			alert("商品出错,请重试!");
			return ;
		}
		url=path+"shopping/shoppingCart_setCartInfo.action";
		data="goodsId="+goodsid+"&goodsNum="+goodNum;
		//添加购物车
		maidAjax(url,data,commSucFun);
		
		
	});
	
	$(document).ready(//购物车的数量显示
		function(){
		  maidAjax(path+"shopping/shoppingCart_getTotalNum.action",'',showShopNum);
		}
	);
	/**
	url:为请求地址
	data:为传入的参数
	sucFun:为处理函数名称
	*/
	function maidAjax(url,data,sucFun){
			$.ajax({
				   type:'POST',
				   url:url,
				   data:data,
				   success:sucFun
				   });
	}
	function showShopNum(data){
		$("#goodsNum").html(data);
		}
	function commSucFun(data){
		alert(data);
		//得到购物车的数量
		maidAjax(path+"shopping/shoppingCart_getTotalNum.action",'',showShopNum);
	}

 })
//加一
	function addGoodsNum(goodsid){
		var goodsNum=$("#"+goodsid).val();
		var tolh=0;
		
		goodsNum=parseInt(goodsNum)+1;
		updateGoods(goodsid,goodsNum);
		
	}
	//减一
	function lessenGoodsNum(goodsid){
		var goodsNum=$("#"+goodsid).val();
		var tolh=0;
		
		goodsNum=parseInt(goodsNum)-1;
		updateGoods(goodsid,goodsNum);
		
	}
	//改变
	function changGoodsNum(goodsid){
		var goodsNum=$("#"+goodsid).val();
		
		if(goodsNum==''||isNaN(goodsNum)){
			goodsNum=1;
		}
		updateGoods(goodsid,goodsNum);
		
	}
	function updateGoods(goodsId,goodsNum){
		if(parseInt(goodsNum)<=0){
			$("#"+goodsId).val('1');
			goodsNum=1;
		}
		$("#"+goodsId).val(goodsNum)
		var path=$("#path").val();
		$.ajax({type:'POST',url:path+'shopping/shoppingCart_updateCart.action',data:'goodsNum='+goodsNum+"&goodsId="+goodsId,
			   success:function(data){
				   	//总价格
					var da=eval("("+data+")");
					//$("#to1").html(da.i);
					//$("#to2").html(da.i);
					//当个总价0
					//alert(goodsId);
					$("#k"+goodsId).html(da.k);
					$("input[value="+goodsId+"]").attr("alt",da.k);
					var tolh=0;
					$(":checkbox:checked").each(function(){
								tolh=tolh+parseInt(this.alt);
										//alert(this.alt);	
					})
					$("#to2").html(tolh);
					$("#to1").html(tolh);
					//alert(check.alt);
		}});
			
	}