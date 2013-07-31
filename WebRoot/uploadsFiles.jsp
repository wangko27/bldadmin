<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    <base target="_self" />
    
    <title>My JSP 'uploadsFiles.jsp' starting page</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
	<script type="text/javascript">
	$().ready(function() {
		
   
		//验证
		$("#form1").validate({
			//验证规则
			rules:{
				imgfile:"required"
			},
			messages:{
				imgfile:"请先选择要上传的图片!",
			},
			/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
	        showErrors: function(errorMap, errorList) {   
	            var msg = "";   
	            $.each( errorList, function(i,v){   
	              msg += (v.message+"\r\n");   
	            });   
	            if(msg!="") alert(msg);   
	        },   
	        /* 失去焦点时不验证 */    
	        onfocusout: false  
		});
		
		
	});
	</script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <form action="" id="form1" method="post" encType="multipart/form-data" >  
  	请选择要上传的图片：
	<input type="file" id="imgfile" name="imgfile" /><input type="submit" id="subbutton" value="提  交"/>
  </form>
  <input type="hidden" name="imgPath" id="_img_path" value="${imgPath}"/>
  
  </body>
  
  <script type="text/javascript">
    var obj = window.dialogArguments;
	this.document.getElementById("form1").action = obj.name;
    var _page_path = document.getElementById("_img_path").value;
    if(null!=_page_path  && ""!=_page_path){
       window.returnValue=_page_path;
       window.close();
    }
  </script>
</html>
