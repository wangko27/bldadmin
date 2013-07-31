//验证上传文件类型
function checkFileType(filename, allowFileType) {

    if(filename === null || filename === ' ' || filename === undefined || typeof filename ==='undefined' ){
        return false;
    }
	var expanded = filename.substring(filename.lastIndexOf(".") + 1, filename.length);
	var type = allowFileType.split(",");
	var isTypeRight = false;
	for (var i = 0; i < type.length; i++) {
		if (expanded.toUpperCase() == type[i].toUpperCase()) {
			isTypeRight = true;
		}
	}
	return isTypeRight;
}

