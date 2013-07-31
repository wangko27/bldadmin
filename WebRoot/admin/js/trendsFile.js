//======================
//功能:在表单中input file控件
//参数:parentID---要插入input file控件的父元素ID
//    inputID----input file控件的ID
//======================
function createInput(parentID, inputFileID) {
	var parent = getId(parentID);//获取父元素
	var div = document.createElement("div");//创建一个div容器用于包含input file
	var x = parseInt(Math.random() * (80 - 1)) + 1;
	var divName = inputFileID + x.toString();//随机div容器的名称
	div.name = divName;
	div.id = divName;
	var aElement = document.createElement("input"); //创建input
	aElement.name = inputFileID;
	aElement.id = inputFileID;
	aElement.size=50;
	aElement.type = "file";//设置类型为file
	var delBtn = document.createElement("input");//再创建一个用于删除input file的Button
	delBtn.type = "button";
	delBtn.value = "\u5220\u9664";
	delBtn.onclick = function () {
		removeInput(parentID, divName);
	};//为button设置onclick方法
	div.appendChild(aElement);//将input file加入div容器
	div.appendChild(delBtn);//将删除按钮加入div容器
	parent.appendChild(div);//将div容器加入父元素
}

//============================
//功能:删除一个包含input file的div 容器
//参数:parentID---input file控件的父元素ID
//    DelDivID----个包含input file的div 容器ID
//============================
function removeInput(parentID, DelDivID) {
	var parent = getId(parentID);
	parent.removeChild(getId(DelDivID));
}

//通过元素ID获取文档中的元素 
function getId(v) {
	return document.getElementById(v);
}

