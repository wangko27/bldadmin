	function typeChange(goodsMianSrot){
				
				$.ajax({
					type:"post",
					url:"index/index!getcildtypeByparent.action",
					data:{
						goodsMianSrot:goodsMianSrot
					},
					dataType:"text",
					success:function(msg){
					if(msg!=""){
							$("#goodsSrot").html(msg);
						}else{
						$("#goodsSrot").html("");
						}
					},
					error:function(xhr,msg,e){
						alert(goodsMianSrot);
					}
				});
			}
			function showhotgoods(goodstype,shownum){
				$("#shownum").val(shownum);	
				$.ajax({
					type:"post",
					url:"index/index!gethotgoods.action",
					data:{
						goodstype:goodstype,
						shownum:shownum
					},
					dataType:"text",
					success:function(msg){
					if(msg!=""){
						
						$("#goodstype").html(msg);
						}else{
						$("#goodstype").html("");
						}
					},
					error:function(xhr,msg,e){
						
					}
				});
				return false;
			}
			$(function(){
				$(".scmenu ul li").bind("click",function(){
					$(this).attr("class","mmbj");
					$(this).siblings().attr("class","");
				})
			});
			$().ready(function(){
				$(".scmenu ul li:first").siblings().attr("class","");
			});	
			var i=0;
				function showgalast(){
					var gradeCode=$("a[name=gradeCode]");
					var nub=gradeCode.length;
					i=i-3;
					var m=i;
					if(m>=0){
						for(var j=1;j<nub;j++){
							$("#g"+j).show();
						}
						for(var h=1;h<=m;h++){
							$("#g"+h).hide();
						}
					}
					if(i<0){
						i=0;
					}
					
				}
				function showganext(){
					i=i+3;
					var m=i;
					var gradeCode=$("a[name=gradeCode]");
					var nub=gradeCode.length;
					if(nub>m){
						for(var j=1;j<nub;j++){
							$("#g"+j).show();
						}
						for(var j=1;j<=m;j++){
							$("#g"+j).hide();
						}
					}
					if(i>=nub){
						i=nub-3;
					}
				}
				$(function(){
					$(".qie_1 ul li a").bind("click",function(){
					$(this).attr("class","din");
					$(this).siblings().attr("class","");
					})
				});
				$().ready(function(){
					$(".qie_1 ul li a:first").siblings().attr("class","");
				});
				var i=0;
				function showsblast(){
					var subject=$("li[name=subject]");
					var nub=subject.length;
					i=i-4;
					var m=i;
					if(m>=0){
						for(var j=1;j<nub;j++){
							$("#li"+j).show();
							$("#lis"+j).show();
						}
						for(var h=1;h<=m;h++){
							$("#li"+j).hide();
							$("#lis"+j).hide();
						}
					}
					if(m<0){
						i=0;
					}
					
				}
				function showsbnext(){
					i=i+4;
					var m=i;
					var subject=$("li[name=subject]");
					var nub=subject.length;
					if(nub>m){
						for(var j=1;j<nub;j++){
							$("#li"+j).show();
							$("#lis"+j).show();
						}
						for(var j=1;j<=m;j++){
							$("#li"+j).hide();
							$("#lis"+j).hide();
						}
					}
					if(i>=nub){
						i=nub-4;
					}
				}
				$(function(){
					$(".qie_2 ul li a").bind("click",function(){
					$(".qie_2 ul li a").attr("class","");
					$(this).attr("class","din_1");
					})
				});
				$().ready(function(){
					$(".qie_2 a").attr("class","");
					$(".qie_2 a:first").attr("class","din_1");
				});
				function changedailyReads(gradeCode,subject){
				var str="";
				if(gradeCode==''){
					str="subject="+subject;
				}
				if(subject==''){
					str="gradeCode="+gradeCode;
				}
				$.ajax({
					type:"post",
					url:"index/index!changedailyReads.action",
					data:str,
					dataType:"text",
					success:function(msg){
					if(msg!=""){
						
						$("#changedailyReads").html(msg);
						}else{
						$("#changedailyReads").html("");
						}
					},
					error:function(xhr,msg,e){
						
					}
				});
				return false;
			}
				
			