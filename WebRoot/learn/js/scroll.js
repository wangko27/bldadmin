//图片左右滚动
function myscroll(direction) {
	if (direction == "left") {
		$("#pictures").find("ul:last").css("marginLeft", "0px");
		$("#pictures").find("li:last").insertBefore($("#pictures").find("li:first"));
		$("#pictures").find("ul:first").animate({marginLeft:"0px"}, 10);
	} else {
		$("#pictures").find("ul:first").animate({marginLeft:"0px"}, 10, function () {
			$(this).css({marginLeft:"0"}).find("li:first").appendTo(this);
		});
	}
}

