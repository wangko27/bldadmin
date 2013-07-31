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
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-编辑相册</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/pohto.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
	<script type="text/javascript">
	$().ready(function() {
	
		//验证
		$("#form1").validate({
			//验证规则
			rules:{
				'album.albumname':{
					required:true,
					maxlength:64
				},
				'album.albumnotes':{
					maxlength:256
				}
			},
			messages:{
				'album.albumname':{
					required:"相册名称不能为空!",
					maxlength:$.validator.format("相册名称最大输入{0}字符!")
				},
				'album.albumnotes':{
					maxlength:$.validator.format("相册信息最大输入{0}字符!")
				}
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
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		  <!-- 用户中心中部左边菜单栏 -->
		  <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		  <!-- 用户中心中部右边内容详细页 -->
	      <div class="right">
	      
	        <form action="myspace/comm/albumEdit.action" id="form1" method="post">
	        <s:token></s:token>
	        <div class="bobti">我的相册</div>
	        <div class="lujin"> <a href="myspace/comm/albumList.action">我的相册</a> > <b>编辑相册信息</b> </div>
	        <div class="poth_1">
	          <ul>
	            <li class="tm"><b>编辑相册信息</b> </li>
	          </ul>
	        </div>
	        <div class="poth_6">
	        	<ul>
	            	<li>相册名称：<input id="album.albumname" name="album.albumname" value="${album.albumname }" type="text" /></li>
		            <li>相册信息：<textarea id="album.albumnotes" name="album.albumnotes" cols="" rows="">${album.albumnotes }</textarea></li>
					<li>谁能访问：
						<select name="album.viewperm">
							<option value="1" <s:if test="1 == album.viewperm">selected="selected"</s:if>>所有人</option>
							<option value="2" <s:if test="2 == album.viewperm">selected="selected"</s:if>>所有好友</option>
							<option value="3" <s:if test="3 == album.viewperm">selected="selected"</s:if>>仅主人</option>
						</select>
					</li>
	                <li class="bot"><input id="subbtn" type="submit" class="bx" value=""/> <input type="reset"  class="qx" value=""/></li>
	            </ul>
	        </div>
	        <input type="hidden" name="album.albumid" value="${album.albumid}"/>
	        </form>
	        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="../footer.jsp"></jsp:include> 
  	
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
