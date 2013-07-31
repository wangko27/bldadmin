<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-发表博文</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/usermaid.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
	<script type="text/javascript">
	$().ready(function() {
		//事件
		$("#addpwd").bind("click",function(){
			$("#setpwd").css("display","block");
		});
		
		$("#addpwd").focusin(function(){
			$("#setpwd").css("display","block");
		});
		$("#addpwd").focusout(function(){
			$("#setpwd").css("display","none");
		});
		
		$("#subbtn").click(function(){
			var op = $("#oper").val();
			if(op == 'edit'){
				$("#form1").attr("action","<%=basePath%>myspace/comm/blogEdit.action");
			$("#form1").submit();
			}
			else{
				$("#form1").attr("action","<%=basePath%>myspace/comm/blogAdd.action");
			$("#form1").submit();
			}
		});
	
		//验证
		$("#form1").validate({
			//验证规则
			rules:{
				blogtitle:"required",
				blogcontent:"required"
			},
			messages:{
				blogtitle:"博文标题不能为空!",
				blogcontent:"博文内容不能为空!"
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

  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="../header.jsp"></jsp:include> 
    
    <form action="myspace/comm/blogAdd.action" id="form1" method="post">
    <s:token></s:token>
    <div class="mainbody_1">
	  <div class="dde">
	    <div class="uuop">
	      <div class="right_1">
	        <div class="bobti"> 博文 </div>
	        <div class="dtai_1">
	          <ul>
		            <li><a href="myspace/comm/blogList.action?blogtype=1">我的博文</a></li>
		            <li><a href="myspace/comm/blogList.action?blogtype=2">好友博文</a></li>
		            <li><a href="myspace/comm/blogList.action?blogtype=3">大家的博文</a></li>
	            <li class="bai">发表博文</li>
	          </ul>
	        </div>
	        <div class="bbti">标题：<input name="blog.blogtitle" id="blogtitle" value="${ blog.blogtitle}" type="text" /></div>
	        <div class="eidm">
	        	<textarea cols="80" id="blogcontent" name="blog.blogcontent" rows="10">${ blog.blogcontent} </textarea>
				<script type="text/javascript">
				//<![CDATA[
				window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
				//]]>
				</script>
				<script type="text/javascript"
					src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V">
				</script>
				<script type="text/javascript">
				//<![CDATA[
				CKEDITOR.replace('blogcontent',addUploadButton(this));
				 function addUploadButton(editor){
		           CKEDITOR.on('dialogDefinition', function( ev ){
		               var dialogName = ev.data.name;
		               var dialogDefinition = ev.data.definition;
		               if ( dialogName == 'image' ){
		                   var infoTab = dialogDefinition.getContents( 'info' );
		                   infoTab.add({
		                       type : 'button',
		                       id : 'upload_image',
		                       align : 'center',
		                       label : '上传',
		                       onClick : function( evt ){
		                           var thisDialog = this.getDialog();
		                           var txtUrlObj = thisDialog.getContentElement('info', 'txtUrl');
		                           var txtUrlId = txtUrlObj.getInputElement().$.id;
		                           addUploadImage(txtUrlId);
		                       }
		                   }, 'browse'); //place front of the browser button
		               }
		           });
		       }
				 function addUploadImage(theURLElementId){
				 
	           		var uploadUrl = "<%=basePath%>uploadsFiles.jsp"; //这是我自己的处理文件/图片上传的页面URL
					 var obj = new Object();
			    	obj.name="myspace/comm/imgUpload.action";
		           var imgUrl = window.showModalDialog(uploadUrl,obj);
		       //在upload结束后通过js代码window.returnValue=...可以将图片url返回给imgUrl变量。
		       //更多window.showModalDialog的使用方法参考
		           var urlObj = document.getElementById(theURLElementId);
		           urlObj.value = "<%=basePath%>"+imgUrl;
		           urlObj.fireEvent("onchange"); //触发url文本框的onchange事件，以便预览图片
		       }
				//]]>
				</script>
	        </div>
	        <div class="quan">
	        浏览权限：
	        <s:if test="blog.viewperm == 1">
	        <input name="blog.viewperm" type="radio" value="1" checked="checked" /> 所有人 
	        <input name="blog.viewperm" type="radio" value="2"  /> 仅好友 
	        <input name="blog.viewperm" id="addpwd" type="radio" /> 加密 
	        <input name="blog.viewperm" type="radio" value="3" /> 仅自己
	        </s:if>
	        <s:elseif test="blog.viewperm == 2">
	        <input name="blog.viewperm" type="radio" value="1"/> 所有人 
	        <input name="blog.viewperm" type="radio" value="2"  checked="checked"  /> 仅好友 
	        <input name="blog.viewperm" id="addpwd" type="radio" /> 加密 
	        <input name="blog.viewperm" type="radio" value="3" /> 仅自己
	        </s:elseif>
	        <s:elseif test="blog.viewperm == 3">
	        <input name="blog.viewperm" type="radio" value="1" /> 所有人 
	        <input name="blog.viewperm" type="radio" value="2"  /> 仅好友 
	        <input name="blog.viewperm" id="addpwd" type="radio" /> 加密 
	        <input name="blog.viewperm" type="radio" value="3"  checked="checked"/> 仅自己
	        </s:elseif>
	        <s:elseif test="blog.viewperm == 4">
	        <input name="blog.viewperm" type="radio" value="1" /> 所有人 
	        <input name="blog.viewperm" type="radio" value="2"  /> 仅好友 
	        <input name="blog.viewperm" id="addpwd" type="radio"  checked="checked"/> 加密 
	        <input name="blog.viewperm" type="radio" value="3" /> 仅自己
	        </s:elseif>
	        <s:else>
	        <input name="blog.viewperm" type="radio" value="1" checked="checked" /> 所有人 
	        <input name="blog.viewperm" type="radio" value="2"  /> 仅好友 
	        <input name="blog.viewperm" id="addpwd" type="radio" /> 加密 
	        <input name="blog.viewperm" type="radio" value="3" /> 仅自己
	        </s:else>
	        </div>
	        <div class="mima" style="display: none;" id="setpwd">
	        	<p>设置密码：<input name="blog.viewpwd" id="viewpwd" type="text" /></p>
	            <p class="zhu">加密的博文，朋友需输入密码才可见！</p>
	        </div>
	        <div class="botton"><img id="subbtn" src="img/user_img/fb1.gif" width="69" height="21" /><a href="javascript:;"><img src="img/user_img/fg.gif" width="45" height="21" /></a></div>
	      </div>
	    </div>
	  </div>
	</div>
	<input type="hidden" name="oper" id="oper" value="${oper }" />
	<input type="hidden" name="blog.blogid" id="blogid" value="${blog.blogid }" />
	</form>
	
	<!-- 底 -->
    <jsp:include page="../footer.jsp"></jsp:include> 
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
	
  </body>
</html>
