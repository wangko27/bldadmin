
$().ready(function () {
				
	//分享
	$("#a_share").bind("click", function () {
		$("#formRestriction").attr("action", "learn/filter/restriction!toShareArticle.action");
		$("#formRestriction").submit();
		return false;
	});
				
	//收藏
	$("#a_collect").bind("click", function () {
		$("#formRestriction").attr("action", "learn/filter/restriction!toCollectArticle.action");
		$("#formRestriction").submit();
		return false;
	});
});
			
//复制网址
function copyurl(url) {
	var clipBoardContent = "";
	clipBoardContent += url;
	window.clipboardData.setData("Text", clipBoardContent);
	alert("\u5730\u5740\u5df2\u590d\u5236\u6210\u529f\uff01");
}


