	var s = 10;
	var maxheight = 100;
	function shoppingcat(mh,i) {
	var k=parseInt(mh/52);
	var minheight=40;
	if(k>0){
		maxheight=(k+1)*20;
	}
	var content = document.getElementById("content"+i);
	var key = document.getElementById("key"+i);
	var t = content.style;
	if (t.height == "" || t.height == 0) {
		t.height = minheight;
	}
	var h = parseInt(t.height);
	if (key.innerHTML == "\u5168\u90e8\u5c55\u5f00") {
		h += s;
		t.height = h + "px";
		if (h < maxheight) {
			setTimeout("shoppingcat("+mh+","+i+");", 1);
		} else {
			key.innerHTML = "\u5173\u95ed";
		}
	} else {
		h -= s;
		t.height = h + "px";
		if (h > minheight) {
			setTimeout("shoppingcat("+mh+","+i+");", 1);
		} else {
			key.innerHTML = "\u5168\u90e8\u5c55\u5f00";
		}
	}
	return false;
}
