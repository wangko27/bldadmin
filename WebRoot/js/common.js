	/**去除空格*/
	function objTrim(obj){
		if(obj.value !== ""){
			obj.value = $.trim(obj.value);
		}
	}
	
	/**比较开始时间和结束时间*/
	function compareDate(dateOne,dateTwo){
		if(dateOne !== '' && dateTwo !== ''){
			var arrDateOne = dateOne.split("-");
			var l_oneDate = new Date(arrDateOne[0], parseInt(arrDateOne[1]-1),arrDateOne[2]);
			var attDateTwo = dateTwo.split("-");
			var l_twoDate = new Date(attDateTwo[0], parseInt(attDateTwo[1]-1),attDateTwo[2]);
			if(l_oneDate > l_twoDate){
				  alert("日期开始时间大于结束时间");   
      				  return true; 
			}else{
				  return false;
			}
		}
	}
	
	function displayTime(startDate,endDate){
			var today=new Date();
			//获得年份
			var year=today.getFullYear();
			var month=parseInt(today.getMonth())+1;
			var day=today.getDate();
			var hours=today.getHours();
			var minute=today.getMinutes();
			var seconds=today.getSeconds();
			var result=year+"-"+month+"-"+day;
			//填入到文本框
			$("#"+startDate).val(result);
			$("#"+endDate).val(result);
			//定时调用
			//window.setTimeout("displayTime()",1000);
	}