//文章的展开与收缩
var s = 10;
var minheight = 100;
var maxheight = 700;
function shoppingcat(mh) {
	
	if(mh){
		maxheight=mh;
	}
	
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
			setTimeout("shoppingcat("+mh+");", 1);
		} else {
			key.innerHTML = "\u5173\u95ed";
		}
	} else {
		h -= s;
		t.height = h + "px";
		if (h > minheight) {
			setTimeout("shoppingcat("+mh+");", 1);
		} else {
			key.innerHTML = "\u5168\u90e8\u5c55\u5f00";
		}
	}
	return false;
}

