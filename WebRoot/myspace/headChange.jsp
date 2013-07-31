<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！-- 更换头像</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/zzll.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				$("#uploadSubmit").hover(function(){
					$(this).css("cursor","hand");
				}).click(function(){
					var headpath = $("#headpath").val();
					if(headpath == ""){
						alert("请选择头像文件文件!");
						$("#headpath").focus();
						return false;
					}
					if((headpath.toLowerCase().lastIndexOf(".jpg")) == -1 && (headpath.toLowerCase().lastIndexOf(".gif")) == -1 
					&& (headpath.toLowerCase().lastIndexOf(".png")) == -1 && (headpath.toLowerCase().lastIndexOf(".jpeg")) == -1){
						alert("上传文件扩展名必须为.jpg, .jpeg, .gif, .png!");
						$("#headpath").focus();
						return false;
					}
					var $uploadForm = $("#uploadForm");
					$uploadForm.attr("action","<%=basePath%>member/changeHeadImage.action");
					$uploadForm.submit();
				});
				
				$("#headpath").change(function(){
					var headpath = $("#headpath").val();
					if(headpath != "" && (headpath.toLowerCase().lastIndexOf(".jpg")) == -1 && (headpath.toLowerCase().lastIndexOf(".gif")) == -1 
					&& (headpath.toLowerCase().lastIndexOf(".png")) == -1 && (headpath.toLowerCase().lastIndexOf(".jpeg")) == -1){
						alert(headpath);
						$("#headimg").attr("src",headpath);
					}
				})
			
				
				
			});
			
		</script>
  </head>
  
  <body>
   <jsp:include page="header.jsp"></jsp:include>
<div class="mainbody_1">
  <div class="dde">
    <div class="uuop">
	<jsp:include page="content_leftmenu.jsp"></jsp:include>
	   <div class="right">
        <div class="bobti">更换头像</div>
        <form action="" method="post" id="uploadForm" name="uploadForm" enctype="multipart/form-data">
        <s:token></s:token>
        <div class="tucc">
        	<ul style="width:280px">
            <li>
            <img <c:if test="${empty loginMemberHeadpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> <c:if test="${not empty loginMemberHeadpath}">src="<%=basePath%>${loginMemberHeadpath}"</c:if> width="73" height="73" id="headimg" />
            </li>
            </ul>
            <ul style="width:400px">
            <li><span>温馨提示：请注意您上传图片的格式，暂时只能上传JPG/GIF/PNG等格式的图片,且大小不能超过256字节</span></li>
            <li><input name="headpath" id="headpath" type="file" class="juj" /></li>
            <li  class="aal"><input name="uploadbtn" type="button"  class="qqd" id="uploadSubmit" /></li>
            </ul>
        </div>
        </form>
      </div> 
  </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
