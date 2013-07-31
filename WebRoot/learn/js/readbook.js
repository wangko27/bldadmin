//文章的展开与收缩
var s = 10;
var minheight = 100;
var maxheight = 700;
function shoppingcat() {
	var content = document.getElementById("content");
	var key = document.getElementById("key");
	var t = content.style;
	if (t.height == "" || t.height == 0) {
		t.height = minheight;
	}
	var h = parseInt(t.height);
	if (key.innerHTML == "\u5168\u90e8\u5c55\u5f00") {
		h += s;
		t.height = h + "px";
		if (h < maxheight) {
			setTimeout("shoppingcat();", 1);
		} else {
			key.innerHTML = "\u5173\u95ed";
		}
	} else {
		h -= s;
		t.height = h + "px";
		if (h > minheight) {
			setTimeout("shoppingcat();", 1);
		} else {
			key.innerHTML = "\u5168\u90e8\u5c55\u5f00";
		}
	}
	return false;
}
$().ready(function () {
				
	//分享
	$("#a_share").bind("click", function () {
		$("#formRestriction").attr("action","learn/filter/restriction!toShareResource.action");
		$("#formRestriction").submit();
		return false;
	});
				
	//收藏
	$("#a_collect").bind("click", function () {
		$("#formRestriction").attr("action","learn/filter/restriction!toCollectResource.action");
		$("#formRestriction").submit();
		return false;
	});
				
	//下载
	$("#a_down").bind("click", function () {
		$("#formRestriction").attr("action","learn/filter/restriction!toDownResource.action");
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

