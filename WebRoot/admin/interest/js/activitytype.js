//查询类别
function selectType(proID, defaultText, selectTypeId) {
	$.ajax({type:"post", url:"admin/activityType!getActivityTypeByOption.action", data:{proID:proID, selectTypeId:selectTypeId}, dataType:"text", success:function (msg) {
		$("#typeId option").each(function () {
			$(this).remove();//移除原有项
		});
		if(defaultText){
			$("#typeId").append("<option value=\"\">" + defaultText + "</option>");
		}
		$(msg).appendTo("#typeId");
	}, error:function (xhr, msg, e) {
		alert("error");
	}});
}

